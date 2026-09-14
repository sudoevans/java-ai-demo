FROM container-registry.oracle.com/java/jdk:25.0.4.1
WORKDIR /opt/app

ARG JAR_FILE=./target/libs/container-cpu-ergonomics-java-1.0.0.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
