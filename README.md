# Spring Boot + Grafana & Influx & StatsD

This application serves as an example, a showcase for [JDD2015](http://15.jdd.org.pl/). It consists of a simple Spring Boot application and Grafana + InfluxDB + StatsD stack. Application exposes jvm (and more) metrics via StatsDMetricsWriter and dropwizard's MetricsRegistry. Metrics stack runs on [this Docker image](https://hub.docker.com/r/samuelebistoletti/docker-statsd-influxdb-grafana/)

### How do I run it?

#### Run the docker container

```
docker run -d \
  --name docker-statsd-influxdb-grafana \
  -p 3003:9000 \
  -p 3004:8083 \
  -p 8086:8086 \
  -p 22022:22 \
  -p 8125:8125/udp \
  samuelebistoletti/docker-statsd-influxdb-grafana
```

You should now be able to reach Grafana at [http://localhost:3003/](http://localhost:3003/).

#### Run the Spring Boot application

`mvn spring-boot:run`

From now on, the application should respond at [http://localhost:8080/](http://localhost:8080/) with a hundred of random strings.

To run second instance in parralel just type:

`mvn spring-boot:run -Dspring.profiles.active=development`

Second instance should be reachable at [http://localhost:8081/](http://localhost:8081/).

There's also management port: 9090 for the first instance and 9091 accordingly.
