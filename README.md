
Step 1)      Create a folder 	, navigate to the folder and clone the github repo

             mkdir mongo_submit_proto   
             cd  mongo_submit_proto
             git clone https://github.com/rohithnedu/Solution-MongoDb-Rohith.git




Step 2)     Identify the localpath(we need this to execute Jar).


                Run pwd. From this we will know the  {current path }


                In my case   {current path } =  /Users/rohithnedunuri/Desktop/workspace/mongo_submit_proto



Step 3)      Executing the Jar :
		

            cat { path of input file }  | java -jar {current path }/Solution-MongoDb-Rohith/target/MongoDbJsonFlattener-0.0.1-SNAPSHOT-jar-with-dependencies.jar


Note :
In Case Developer wants to make any changes ,he is free make changes and run maven clean install to generate new jar under target folder
