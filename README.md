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

