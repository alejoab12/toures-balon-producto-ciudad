FROM openjdk:11
ADD build/libs/ciudad-0.0.1.jar producto_ciudad.jar
ENTRYPOINT ["java", "-jar","-Dspring.profiles.active=prod","producto_ciudad.jar"]
