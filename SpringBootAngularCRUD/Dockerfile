FROM openjdk:17-oracle
ADD target/app.jar app.jar
EXPOSE 8080
RUN pwd
ENTRYPOINT [ "java", "-jar", "app.jar" ]
