FROM amazoncorretto:17-alpine-jdk

ARG JAR_FILE=./build/libs/demoOrder*.jar
COPY ${JAR_FILE} demoOrder.jar

ENTRYPOINT ["java", "-jar", "demoOrder.jar", "--server.port=${SERVER_PORT}", "--spring.datasource.url=${DATASOURCE_URL}", "--spring.datasource.username=${DATASOURCE_USERNAME}", "--spring.datasource.password=${DATASOURCE_PASSWORD}"]