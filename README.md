# restful-uploader

A simple file uploader with REST

#Build & Rungit

git clone https://github.com/mozammal/restful-uploader.git

cd restful-uploader

mvn clean

mvn spring-boot:run

The application is now accepting file upload request on  http://localhost:8080/rest/upload

As swagger-ui.html is running on http://localhost:8080/swagger-ui.html, you can upload file through swagger.

![Alt text](src/main/resources/images/swagger-ui.PNG?raw=true "Swagger Upload File Through Post request")


