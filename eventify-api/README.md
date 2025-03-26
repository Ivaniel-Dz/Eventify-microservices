# 

### **📂 Estructura del Proyecto (`eventify-api`)**
```plaintext
eventify-api/  
│── pom.xml  (Proyecto padre)  
│  
├── config-service/  
│   ├── src/main/java/com/eventify/configservice/  
│   ├── src/main/resources/  
│   │   ├── application.yml  
│   │   ├── configurations/  
│   │   │   ├── eureka-svr.yml  
│   │   │   ├── gateway-svc.yml  
│   │   │   ├── eventos-svc.yml  
│   ├── pom.xml  
│  
├── eureka-server/  
│   ├── src/main/java/com/eventify/eurekaserver/  
│   ├── src/main/resources/  
│   │   ├── application.yml  
│   ├── pom.xml  
│  
├── gateway-service/  
│   ├── src/main/java/com/eventify/gateway/  
│   ├── src/main/resources/  
│   │   ├── application.yml  
│   ├── pom.xml  
│  
├── eventos-service/  
│   ├── src/main/java/com/eventify/eventos/  
│   ├── src/main/resources/  
│   │   ├── application.yml  
│   ├── pom.xml  
│  
├── usuarios-service/  
│   ├── src/main/java/com/eventify/usuarios/  
│   ├── src/main/resources/  
│   │   ├── application.yml  
│   ├── pom.xml  
│  
├── reservas-service/  
│   ├── src/main/java/com/eventify/reservas/  
│   ├── src/main/resources/  
│   │   ├── application.yml  
│   ├── pom.xml  
│  
├── pagos-service/  
│   ├── src/main/java/com/eventify/pagos/  
│   ├── src/main/resources/  
│   │   ├── application.yml  
│   ├── pom.xml  
│  
├── notificaciones-service/  
│   ├── src/main/java/com/eventify/notificaciones/  
│   ├── src/main/resources/  
│   │   ├── application.yml  
│   ├── pom.xml  
│  
└── README.md  
```

---

### **📌 Explicación de la Estructura**
- `config-service/`: Servicio de configuración centralizado con `application.yml` y los archivos específicos de cada servicio en `configurations/`.
- `eureka-server/`: Servidor de registro de microservicios (Service Discovery).
- `gateway-service/`: API Gateway para gestionar las rutas de los microservicios.
- `eventos-service/`, `usuarios-service/`, `reservas-service/`, `pagos-service/`, `notificaciones-service/`: Microservicios individuales con su propia lógica de negocio.

---

### **🛠️ Diagrama del Ecosistema de Microservices**


### Configuration del microservice:
1. Se configura y se agrega las dependencias global en pom.xml en el archivo principal (Padre)
2. Cada servicio se agrega los datos del padre en pom.xml y sus dependencias personales
3. En el pom.xml se agrega los servicios hijos como modules
4. En Config-service se agrega las configuraciones generales de cada servicio en el archivo configuration/**.yml
5. Cada servicio llama a su configuration del servicio config-service
6. y se ejecuta los servicios para ver si esta funcionado las configuraciones.
7. Comenzar a desarrollar cada servicio