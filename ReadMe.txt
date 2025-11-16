
-----------------------------------------------------------------------------------------
Kafka Proof-of-Concept (POC) description for email sending


This system consists of three separate projects forming a Kafka-based email sending microservices platform:

shared-dto: A standalone Java project containing common entity classes (such as EmailRequest) used across services. This project is built into a JAR and added as a dependency to both microservices to ensure consistent, shared data models.

email-producer: A Spring Boot microservice exposing a REST endpoint that receives and processes incoming email requests. It publishes these requests as messages to a Kafka topic.

email-consumer: A Spring Boot microservice that listens for messages from the Kafka broker (running in Docker), processes each message, and sends individual emails using Gmail as the SMTP provider.

This architecture uses Kafka as a messaging backbone to decouple request intake and email dispatch, with a shared DTO module ensuring consistent message formats across both producer and consumer services.
-----------------------------------------------------------------------------------------

Steps to run 

1 - build shared-dto project.

2 - then started other services.

3 - start email-producer app and send request 
	POST - localhost:9881/api/email/producer/send
	{
		"name" : "yourName",
		"toEmail": "yourEmailId@gmail.com",
		"subject" :"testing mail",
		"body" : "Hi, How are you?"
	}

4 -  start email-consumer
	it will take your resest and send mail. 
	Note -- go to properties and put your email id and password.


-----------------------------------------------------------------------------------------
Other details 

topic name -- EMAIL_TOPIC2

-----------------------------------------------------------------------------------------


### Kafka -- Install & Execute kafka in docker

Reffrence -- https://kafka.apache.org/quickstart


Get the Docker image:
	$ docker pull apache/kafka:4.1.1

Start the Kafka Docker container:
	$ docker run -p 9092:9092 apache/kafka:4.1.1
	
create topic (quickstart-events)
	$ bin/kafka-topics.sh --create --topic EMAIL_TOPIC --bootstrap-server localhost:9092
	
details of topic 
	$ bin/kafka-topics.sh --describe --topic EMAIL_TOPIC --bootstrap-server localhost:9092

Run the console producer client to write a few events into your topic
	$ bin/kafka-console-producer.sh --topic EMAIL_TOPIC --bootstrap-server localhost:9092
	
Open another terminal session and run the console consumer client to read the events you just created
	$ bin/kafka-console-consumer.sh --topic EMAIL_TOPIC --from-beginning --bootstrap-server localhost:9092
	
	
Note -- 
	In Docker installtion 
	kafka location is -- /opt/kafka/bin
	
	
