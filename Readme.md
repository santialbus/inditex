Buenas,

En esta prueba técnica pongo a prueba varias tareas o nociones mias las cuales he aprendido durante todos estos años en el mundo de la tecnología.

El código se muestra funcionando con una base de datos h2:

http://localhost:8080/h2-console/

El usuario y contraseña es inditex.

La carga de los datos no se esta realizando por errores en el IDE y demás, por eso he puesto en funcionamiento un endpoint de carga de datos:

POST:

http://localhost:8080/prices

Una vez esto ya se podrá "jugar" con la bbdd.

GET
http://localhost:8080/pricesapplicationDate=2020-06-14 00:00:00&productId=35455&brandId=1

Curl de ejemplo:

curl --location --request GET 'http://localhost:8080/prices?applicationDate=2020-06-14%2000%3A00%3A00&productId=35455&brandId=1' \
--header 'Content-Type: application/json' \
--data '{
"applicationDate": "2020-06-14 00:00:00",
"productId": 35455,
"brandId": 1
}'

Este es el endpoint que se pedía, esta en total funcionamiento.

El request tiene que ser así:

{
"applicationDate": "2020-06-14 00:00:00",
"productId": 35455,
"brandId": 1
}

DOCKER:

Para montar la imagen:

1- docker build -t inditex_docker .
2- docker run -p 8080:8080 inditex_docker

SWAGGER:

http://localhost:8080/swagger-ui/index.html
