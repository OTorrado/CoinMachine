FROM openjdk:17
EXPOSE 80:8080
ADD target/CoinMachine-new.jar CoinMachine-new.jar
ENTRYPOINT [ "java","-jar","/CoinMachine.jar" ]