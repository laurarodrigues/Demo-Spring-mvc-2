FROM eclipse-temurin:17-jdk-focal
 
#WORKDIR /app

COPY target/big-start-collectibles-0.0.1-SNAPSHOT.war /home/big-start-collectibles-0.0.1-SNAPSHOT.war
#COPY .mvn/ .mvn
#COPY mvnw pom.xml ./
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline
 
#COPY src ./src
 
CMD ["./mvnw", "spring-boot:run", /home/big-start-collectibles-0.0.1-SNAPSHOT.war]