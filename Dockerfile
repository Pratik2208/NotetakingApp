FROM openjdk:11
EXPOSE 8080
ADD target/NotetakingApp.jar NotetakingApp.jar
ENTRYPOINT ["java","-jar","/NotetakingApp.jar"]