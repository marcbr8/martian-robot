# martian-robot
Moving a martian robot around Mars


This repository contains two apps:
- A standalone backend RESTFUL API
- A standalone frontend app that uses the backend API

The Backend API can be called without the need of the frontend, i.e. with Postman or any other client.
The Backend is written in Java and uses Spring. Frontend is written in JavaScript using React.

In order to run make use of both applications, you need to navigate to the directory and simply:

```mvn clean install```

Then navigate to the `frontend` directory and type:

```node install```

The backend run on http://localhost:8080 and the frontend app works on http://localhost:3000
