# transactional-outbox-pattern
Sample for transactional outbox pattern

### WHAT WHY and HOW
https://dzone.com/articles/implementing-the-outbox-pattern

### Required Tools:

- **Zookeeper for Kafka**
- **Apache Kafka**
- **Debezium connector mysql (CDC Tool)**



### Download and Installation Kafka

[https://bryteflow.com/what-is-apache-kafka-and-installing-kafka-step-by-step/](https://bryteflow.com/what-is-apache-kafka-and-installing-kafka-step-by-step/)

[https://www.javatpoint.com/installation-of-apache-kafka](https://www.javatpoint.com/installation-of-apache-kafka)



### Download and Install Dabezium Connector

[**https://debezium.io/documentation/reference/stable/install.html**](https://debezium.io/documentation/reference/stable/install.html)


### Configure Debezium Connector
[https://debezium.io/documentation/reference/1.5/connectors/mysql.html#mysql-example-configuration](https://debezium.io/documentation/reference/1.5/connectors/mysql.html#mysql-example-configuration)

### Dabezium Rest Interface

[**https://docs.confluent.io/platform/current/connect/references/restapi.html**](https://docs.confluent.io/platform/current/connect/references/restapi.html)

## Basic Kafka Windows Commands

Start Stop Zookeper Server

```
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
.\bin\windows\zookeeper-server-stop.bat .\config\zookeeper.properties
```

Start Stop Kafka Server

```
.\bin\windows\kafka-server-start.bat .\config\server.properties
.\bin\windows\kafka-server-stop.bat .\config\server.properties
```

Consumer Console

```
.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic order_server.orders.outbox --from-beginning
```

List Kafka Topics

```
.\bin\windows\kafka-topics.bat --list --bootstrap-server localhost:9092
```

Delete Kafka Topics

```
.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --delete --topic 'topic-.*'
```


Start Debezium Connect
```
.\bin\windows\connect-standalone.bat .\config\connect-standalone.properties .\config\mysql-connector.properties
```


## Basic Kafka Shell Commands
[https://gist.github.com/sonhmai/5b2b4455162c808c091b661aeb675625](https://gist.github.com/sonhmai/5b2b4455162c808c091b661aeb675625)



