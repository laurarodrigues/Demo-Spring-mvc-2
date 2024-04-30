FROM eclipse-temurin:17-jdk-focal
 
#WORKDIR /app

#COPY .mvn/ .mvn
COPY target/ home/
COPY target/big-start-collectibles-0.0.1-SNAPSHOT.war /home/big-start-collectibles-0.0.1-SNAPSHOT.war
#COPY mvnw pom.xml ./
#RUN chmod +x mvnw
RUN chmod +x home
#RUN ./mvnw dependency:go-offline
 
#COPY src ./src
 
#CMD [ "mvn", "spring-boot:run", /home/big-start-collectibles-0.0.1-SNAPSHOT.war]
#ENTRYPOINT [ "java","-jar","/home/big-start-collectibles-0.0.1-SNAPSHOT.war" ]
ENTRYPOINT [ "java","-jar","home/" ]