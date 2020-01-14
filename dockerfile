FROM codenvy/jdk8_maven3_tomcat8
VOLUME /tmp
ADD ./target/demo-0.0.1-SNAPSHOT.jar demo-0.0.1-SNAPSHOT.jar
EXPOSE 9001
ENTRYPOINT ["java", "-jar", "/demo-0.0.1-SNAPSHOT.jar"]