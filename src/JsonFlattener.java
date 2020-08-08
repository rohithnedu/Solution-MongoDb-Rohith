import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ValueNode;

public class JsonFlattener {

	public static void main(String[] args) {
		try (Scanner scn = new Scanner(System.in)) {
			StringBuilder inputJson = new StringBuilder();
			while (scn.hasNext()) {
				inputJson.append(scn.next());
			}
			JsonFlattener jFlattner = new JsonFlattener();
			jFlattner.flattenJson(inputJson.toString());
		} catch (Exception e) {
			System.err.println("Something went wrong:" + e.getMessage());
			e.printStackTrace();
		}
	}

	public void flattenJson(String json) {
		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
		try {
			fetchResults("", new ObjectMapper().readTree(json), map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			map.forEach((key, value) -> {
				System.out.println(key + " -> " + value);
			});
		} catch (Exception e) {

		}
	}

	private void fetchResults(String currentPath, JsonNode jsonNode, Map<String, Object> map) {
		if (jsonNode.isObject()) {
			ObjectNode objectNode = (ObjectNode) jsonNode;
			Iterator<Map.Entry<String, JsonNode>> iter = objectNode.fields();
			String pathPrefix = currentPath.isEmpty() ? "" : currentPath + ".";

			while (iter.hasNext()) {
				Map.Entry<String, JsonNode> entry = iter.next();
				fetchResults(pathPrefix + entry.getKey(), entry.getValue(), map);
			}
		} else if (jsonNode.isArray()) {
			ArrayNode arrayNode = (ArrayNode) jsonNode;
			for (JsonNode node : arrayNode) {
				fetchResults(currentPath, node, map);
			}
		} else if (jsonNode.isValueNode()) {
			ValueNode valueNode = (ValueNode) jsonNode;
			map.put("\"" + currentPath + "\"", valueNode);
		}

	}
}
