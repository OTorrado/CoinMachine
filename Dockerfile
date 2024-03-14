FROM openjdk:17
EXPOSE 80:8080
ADD target/CoinMachine-0.0.2.jar CoinMachine-0.0.2.jar
ENTRYPOINT [ "java","-jar","/CoinMachine-0.0.2.jar" ]