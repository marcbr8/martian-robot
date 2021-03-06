# martian-robot


This repository contains a Spring Boot standalone app that provides a RESTful API for creation and deletion of mars grids, robots as well as the calculation of where the robots end given their instructions.

The API is deployed  under https://tranquil-cove-41891.herokuapp.com

[Navigating to that](https://tranquil-cove-41891.herokuapp.com) on the browser will redirect you to the frontend app


If you want to run the app locally, just clone this repo, navigate to it and

```
mvn spring-boot:run
```
This will deploy the backend on ```http://localhost:8080``` In ```resources/application.properties``` you can change the frontend url for a correct redirect from the local backend

The exposed endpoints are the following:
- 

Endpoint | Method/Verb | Response | Request
------------ | ------------- | ------------- | ------------- 
```/robots``` | GET | A list of the current robots | 
```/robot``` | POST | The newly created given robot the request | JSON
```/robot``` | DELETE | Deletes all robots and returns empty list |
```/robot/calculate``` | GET | The positions of the posted robots given the latest given grid |
```/grid``` | GET | Returns the current in-use grid
```/grids``` | GET | Return a list of all grids created
```/grid``` | POST | The newly created grid given the request. This will be the used mars grid | JSON
```/grid``` | DELETE | Deletes all robots and returns empty list |

### Example of a POST request
To create a robot, call the ```/robot``` endpoint with the verb POST and pass as a request a JSON object like this one:
```
    {
        "coordinates" : {
            "x" : 1,
            "y": 1
            },
        "orientation" : "E",
        "instructions" : "RFRFRFRF"
    }

```
The API will validate the passed robot.

To create a robot, call the ```/grid``` endpoint with the verb POST and pass as a request a JSON object like this one:
```
    {
        "boundaries" : {
            "x" : 5,
            "y" : 3
        }
    }
```

### Example of a GET request

To get all the current robots

```GET https://tranquil-cove-41891.herokuapp.com/robots```

To get the current grid

```GET https://tranquil-cove-41891.herokuapp.com/grid```

To calculate for those current robots and grid

```GET https://tranquil-cove-41891.herokuapp.com/robot/calculate```
