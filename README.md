# Modulo

## Tecnologias Trabajadas
* Java 11
* Spring Boot 2.7.14
* Maven
* Docker

## Dependecias Auxiliares 
* Lombok
* Spring Test
* Junit5

## Configuración

1. Clona este repositorio en tu máquina local: `git clone https://github.com/nicoreinaldo/Modulo.git`
2. Navega al directorio del proyecto: `cd Modulo`

## Construcción y Ejecución

Para este proyecto no debe instalar las tecnologias anterioremente mecionadas, ya que esta buildeada en un contenedor docker, los pasos a seguir:
Si no lo tienes puedes verificar aqui como instalarlo: https://docs.docker.com/get-docker/

1. Asegúrate de tener Docker en funcionamiento en tu máquina.
2. Construye la imagen de Docker: `docker build -t project-modulo .`
3. Ejecuta el contenedor: `docker run -p 8080:8080 project-modulo`

## Pruebas Apis

Una vez que esta corriendo el proyecto, podemos probar nuestras api de varias formas, yo voy a brindar dos soluciones:

La primera atravez de consola (terminal o cmd) ejecutando un curl a las apis

GET :
`curl --location 'localhost:8080/api/v1/modulo?x=7&y=5&n=12345'`

POST :
`curl --location 'localhost:8080/api/v1/modulo' \
--header 'Content-Type: application/json' \
--data '{
  "t": 7,
  "list": [
    {"x": 7, "y": 5, "n": 12345},
    {"x": 5, "y": 0, "n": 4},
    {"x": 10, "y": 5, "n": 15},
    {"x": 17, "y": 8, "n": 54321},
    {"x": 499999993, "y": 9, "n": 1000000000},
    {"x": 10, "y": 5, "n": 187},
    {"x": 2, "y": 0, "n": 999999999}
  ]
}'`

La segunda es atravez de Postman (Herramienta para el testeo de api rest)

GET :

<img width="843" alt="Screenshot 2023-08-17 at 03 35 47" src="https://github.com/nicoreinaldo/Modulo/assets/22691843/638d9927-5a44-4230-af6b-33bce4c57e5c">

POST :

<img width="839" alt="Screenshot 2023-08-17 at 03 35 33" src="https://github.com/nicoreinaldo/Modulo/assets/22691843/5423faab-2986-4d19-b7cd-bc29cee05d1c">

## Pruebas Test

Este proyecto utiliza Spring Test y JUnit 5 para las pruebas. Para ejecutar las pruebas, puedes usar Maven:

* mvn test

Opcion dos es ejecutar un Coverage de la siguiente forma:

<img width="1698" alt="Screenshot 2023-08-16 at 01 47 46" src="https://github.com/nicoreinaldo/Modulo/assets/22691843/a76488b1-e3fa-4776-bf43-a6b08b5e3dce">

## Aclaraciones

En el codigo del proyecto explico mediante anotaciones o comentarios el "por qué" detrás de las decisiones y acciones que tomaste.

## Cosas a mejorar

Por falta de tiempo hay ciertas cosas que no llegue a hacer, me hubiera gustado por ejemplo:
* Haber agregado logs , por ejemplo logger.warn(...), cuando hay una excepcion
* Haber subido las api para consumir desde aws ec2 o lambda (pero bueno tambien para que se consuma de afuera tiene un costo)



