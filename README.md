# **API de Gestión de Eventos y Reservas**

**Descripción:**
API que permita gestionar eventos (como conferencias, conciertos, talleres, etc.) y realizar reservas de entradas. Esta API puede ser utilizada por aplicaciones de eventos o plataformas de gestión de actividades.

**Características:**

- Creación y gestión de eventos (nombre, fecha, lugar, capacidad).
- Registro y gestión de asistentes.
- Procesamiento de pagos para reservas de entradas.
- Envío de confirmaciones y recordatorios de eventos a los usuarios.
- Consultas sobre disponibilidad de entradas y precios.

**Clientes externos:** Plataformas de venta de entradas, aplicaciones de eventos, servicios de turismo, etc.

## Ecosistema de Microservicios:
### API Gateway:
**Dependencias:**
- Gateway (Spring Cloud Routing)
- Eureka Discovery Client (Spring Cloud Discovery)
- Config Client (Spring Cloud Config)
- Spring Boot Actuator (OPS)

### Eureka Server
**Dependencias:**
- Eureka Server (Spring Cloud Discovery)
- Config Client (Spring Cloud Config)
- Spring Boot Actuator (OPS)

### Config Service
**Dependencias:**
- Config Server (Spring Cloud Config)


### Servicios:

#### **📌 Servicio de Eventos**
**Función:** Gestión de eventos (crear, actualizar, eliminar, listar).  

**Dependencias:**  
- **Spring Web** (Para exponer APIs REST).  
- **Spring Data JPA** (Para persistencia).  
- **PostgreSQL Driver** o **MySQL Driver** (Según tu BD).  
- **Eureka Discovery Client** (Para registro en Eureka).  
- **Spring Cloud Config Client** (Para configuración centralizada).  
- **Spring Boot Actuator** (Para monitoreo).  

---

#### **📌 Servicio de Usuarios**
**Función:** Gestión de usuarios y autenticación.  

**Dependencias:**  
- **Spring Web**  
- **Spring Data JPA**  
- **PostgreSQL Driver** o **MySQL Driver**  
- **Spring Security** (Para autenticación y roles).  
- **Spring Boot Starter OAuth2 Resource Server** (Si usas OAuth2 o JWT).  
- **Eureka Discovery Client**  
- **Spring Cloud Config Client**  
- **Spring Boot Actuator**  

---

#### **📌 Servicio de Reservas**
**Función:** Gestión de reservas de entradas a eventos.  

**Dependencias:**  
- **Spring Web**  
- **Spring Data JPA**  
- **PostgreSQL Driver** o **MySQL Driver**  
- **Eureka Discovery Client**  
- **Spring Cloud Config Client**  
- **Spring Boot Actuator**  

---

#### **📌 Servicio de Pagos**
**Función:** Procesamiento de pagos para reservas.  

**Dependencias:**  
- **Spring Web**  
- **Spring Data JPA**  
- **PostgreSQL Driver** o **MySQL Driver**  
- **Spring Cloud OpenFeign** (Para comunicación con el servicio de reservas).  
- **Eureka Discovery Client**  
- **Spring Cloud Config Client**  
- **Spring Boot Actuator**  

---

#### **📌 Servicio de Notificaciones**
**Función:** Enviar confirmaciones y recordatorios de eventos a los usuarios.  

**Dependencias:**  
- **Spring Web**  
- **Spring Cloud Stream** (Si usas Kafka o RabbitMQ para mensajería).  
- **Spring Boot Mail** (Para enviar correos electrónicos).  
- **Twilio SDK** (Opcional, si deseas enviar SMS).  
- **Eureka Discovery Client**  
- **Spring Cloud Config Client**  
- **Spring Boot Actuator**  

---
