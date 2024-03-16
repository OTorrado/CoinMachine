FROM openjdk:17
EXPOSE 80:8080
ADD target/CoinMachine-0.0.1.jar CoinMachine-0.0.1.jar
ENTRYPOINT [ "java","-jar","/CoinMachine-0.0.1.jar" ]