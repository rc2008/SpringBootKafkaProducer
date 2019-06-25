# kafkaspringboot
 # Start Zookeeper 
 ./bin/zookeeper-server-start.sh config/zookeeper.properties
# Start 3 Brokers with different port numbers using below command
./bin/kafka-server-start.sh config/server.properties
./bin/kafka-server-start.sh config/server1.properties
./bin/kafka-server-start.sh config/server2.properties
    
# Once the project is started use below post request to push the data 
http://localhost:8080/api/json/
{
	"id" : 11,
	"name" : "rahul cho",
	"dep" : "cs"
}
