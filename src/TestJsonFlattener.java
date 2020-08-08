
public class TestJsonFlattener {

	String testInput = "\n" + "	{\n" + "		\"id\": \"0001\",\n" + "		\"type\": \"donut\",\n"
			+ "		\"name\": \"Cake\",\n" + "		\"ppu\": 0.55,\n" + "		\"batters\":\n" + "			{\n"
			+ "				\"batter\":\n" + "					[\n"
			+ "						{ \"id\": \"1001\", \"type\": \"Regular\" }\n" + "					]\n"
			+ "			}\n" + "	}\n" + "]";
	
//	public static void main(String[] args) {
//		TestJsonFlattener testFla = new TestJsonFlattener();
//		testFla.test();
//	}

	public void test() {
		
		JsonFlattener jFlattner = new JsonFlattener();
		System.out.println("input is "+testInput);
		System.out.println("output is ");
		jFlattner.flattenJson(testInput);
	}
}
