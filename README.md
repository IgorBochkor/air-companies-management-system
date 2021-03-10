
### For launch project
1. Clone repository
1. Install Docker Desktop and register on DockerHub
1. Run next command in terminal

    > mvn install -DskipTests
1. Run next command in terminal from the directory:

    > docker-compose up --build -d
1. Initial data are injected from the app. Also they are stored here data/init_db.sql 
1. For testing the application you can use Postman. Collection of request is
stored here `data/airplane-demo.postman_collection.json`
1. Also you can testing the endpoints on [localhost:8086/](http://localhost:8081/)
1. Run next command in terminal if you want to stop app

    > docker-compose down
# air-companies-management-system