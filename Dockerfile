FROM eclipse-temurin:11
EXPOSE 8080
COPY target/wellsaid.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar" ]
