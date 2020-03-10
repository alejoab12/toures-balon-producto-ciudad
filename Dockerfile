FROM openjdk:11
ADD build/libs/ciudad-0.0.1.jar producto_ciudad.jar
EXPOSE 8183
ENTRYPOINT ["java", "-jar", "producto_ciudad.jar"]