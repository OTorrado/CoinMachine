FROM openjdk:17
EXPOSE 80:8080
ADD target/CoinMachine-0.0.1-SNAPSHOT.jar CoinMachine-0.0.1-SNAPSHOT.jar
ENTRYPOINT [ "java","-jar","/CoinMachine.jar" ]