FROM java:8

RUN java -version

WORKDIR /

ADD build/libs/test-ibm-0.0.1-SNAPSHOT.jar test-ibm.jar

EXPOSE 8080

CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=default", "test-ibm.jar"]


