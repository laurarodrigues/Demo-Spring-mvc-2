FROM eclipse-temurin:17-jdk-focal
 
#WORKDIR /app

#COPY .mvn/ .mvn
COPY target/ home/stratore/.local/
COPY target/big-start-collectibles-0.0.1-SNAPSHOT.jar home/stratore/.local/big-start-collectibles-0.0.1-SNAPSHOT.jar
#COPY mvnw pom.xml ./
#RUN chmod +x mvnw
RUN chmod +x home
#RUN ./mvnw dependency:go-offline
 
#COPY src ./src
 
#CMD [ "mvn", "spring-boot:run", /home/big-start-collectibles-0.0.1-SNAPSHOT.war]
ENTRYPOINT [ "java","-jar","/target/big-start-collectibles-0.0.1-SNAPSHOT.jar" ]