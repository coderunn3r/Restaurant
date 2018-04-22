Pre requisites
* MongoDB
* JDK 8
* Spring Boot
* Spring Initializr



Getting Started
1. Run the project
./gradlew bootRun

2. API call using curl

2.1 GET command
curl -i -X GET -H "Content-Type: application/json" localhost:8080/restaurants

2.2 POST command
curl -i -X POST -H "Content-Type: application/json" -d '{"restaurantName":"olive garden1","restaurantDescription":"Italian chain restaurant","cuisine":"Italian","location":"Tukwila,WA","menus":[{"name":"Breakfast","type":"classic","menuItems":[{"name":"alferdo fettucine","price":10.99}]}]}' localhost:8080/restaurants/5a7cf7c974791db09117a05f

2.3 DELETE command
curl -i -X DELETE -H "Content-Type: application/json" localhost:8080/restaurants/5a7cf7c974791db09117a05f

2.4 PUT command
curl -i -X PUT -H "Content-Type: application/json" -d '{"restaurantName":"olive garden1","restaurantDescription":"Italian chain restaurant","cuisine":"Italian","location":"Tukwila,WA","menus":[{"name":"Breakfast","type":"classic","menuItems":[{"name":"alferdo fettucine","price":13.99}]}]}' localhost:8080/restaurants/5a7cf9d574791db09117a060