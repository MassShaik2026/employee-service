FROM openjdk:11
EXPOSE 8080
COPY /target/wellsaid.jar .
ENTRYPOINT ["java", "-jar", "/wellsaid.jar" ]