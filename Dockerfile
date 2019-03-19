FROM openjdk:8-jre-alpine

COPY docker/Chess-0.0.1-SNAPSHOT.war docker/app.war

USER user

CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=default", "docker/app.war"]