# Test IBM

### Contenido del proyecto
*  Capa de presentación (Front End): HTML5, Bootstrap, CSS3
*  Controlador (Front End): AngularJS version 6
*  Servicio Rest (Back – End): Spring Framework
*  Pruebas Unitarias y Documentación: Junit
*  Automatización de construcción de código: Gradle
*  Base de datos in-memory - Hibernate
*  Despliegue con Docker

### Despliegue con Docker
Para este caso hay dos opciones:
1. Crear la imagen y ejecutarla localmente
* Descargar proyecto
* Posicionarse en la carpeta del proyecto
* Ejecutar el siguiente comando que creará la imagen: docker build -t test-ibm .
* Comando para ejecutar la imagen creada: docker run -d  -p 8080:8080 test-ibm:latest

2. Descargar la imagen de Dockerhub  y ejecutarla localmente
* Comando para descargar la imagen: docker pull mafesanchezcardona/test-ibm
* Comando para ejecutarla localmente: docker run -d  -p 80:80 mafesanchezcardona/test-ibm:latest

