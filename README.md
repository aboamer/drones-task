# drones-task
the very beginning of drones task required by Musala Soft

## Steps to run project
```
docker image is public, you can run this command and all apis would be available

docker run -d -p 8080:8080 --name drone-container aboamer2000/drone-image:latest

or follow these steps:

go to project path and run the following:

mvn clean install
docker build -t drone-image .
docker run -d -p 8080:8080 --name drone-container drone-image:latest

then use the postman collection attached in the project

```
