## API REST

### Dependencies

Para copilar el proyecto se requiere lo siguiente:

* Instalar Java 8 JDK

* Instalar Maven (Apache Maven 3.3.9)

### Build & Deploy

Ingresar a la carpeta raiz del proyecto y ejecutar el siguiente comando maven


    $ mvn clean package && java -jar target/previred-desafio-0.0.1-SNAPSHOT.jar


Nota: Debe estar disponible el puerto 9090 en el PC donde se ejecute esta API

### Consumir Api

Para invocar la api debe ejecutar el siguiente comando

```bash
curl -X GET --header 'Accept: application/json' 'http://localhost:9090/api/v1/periodos'
```

# Visualizar Documentación

La documentación swagger del API (una vez que se levanta el API) queda disponible en

http://localhost:9090/api/v1/swagger-ui.html#/