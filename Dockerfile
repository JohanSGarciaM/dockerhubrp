FROM openjdk:8 
#el 8 de la linea de arriba corresponde a la version de java que se manejo en el proyecto

WORKDIR /usrapp/bin


#El puerto de comunicacion
ENV PORT 46000


#Desde mi directorio local, copio lo que esta en /target/classes a /usrapp/bin/classes
COPY /target/classes /usrapp/bin/classes
COPY /target/dependency /usrapp/bin/dependency

#comando para que corra el app
CMD ["java","-cp","./classes:./dependency/*","co.edu.escuelaing.sparkdockerdemolive.SparkWebServer"]

#Este archivo es la imagen que se va a correr