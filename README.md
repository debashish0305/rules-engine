# rules-engine using core java
# Runnning the project -port 8081 jar present in /libs
java -Dserver.port=8081 -jar rules-engine-0.0.1-SNAPSHOT.jar

1.  POST http://localhost:8081/rules
      {
      	"city":"Chennei", //MUmbai,New Delhi
      	"evehicle":"TWO_WHEELER", //THREE_WHEELER,FOUR_WHEELER
          "gender":"M", //F,N
          "state":"TN", //MAHA,DEL
      	"amount":1900000
      }

2.  GET http://localhost:8081/rules/fetch 
