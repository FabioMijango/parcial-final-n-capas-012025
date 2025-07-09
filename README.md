# Parcial Final Programación N-Capas – (Seguridad con Spring Security + JWT)

Este repositorio contiene un proyecto para evaluar y practicar los conceptos de seguridad en aplicaciones Spring Boot usando JWT, roles y Docker.

### Estudiantes
- **Nombre del estudiante 1**: Fabio Alberto Mijango Serrano - 00156022
- **Nombre del estudiante 2**: Luis Alejandro Nativi Claude - 00200022
- Sección: 01
---

## Como ejecutar
1. Clonar
2. En la raiz del proyecto ejecutar en consola "docker-compose up"

## 📄 Evidencia de Pruebas

Puedes revisar la evidencia de funcionamiento en el siguiente archivo PDF:  
👉 [Ver evidencia.pdf](https://github.com/FabioMijango/parcial-final-n-capas-012025/blob/master/Pruebas.pdf)


## Sistema de Soporte Técnico

### Descripción
Simula un sistema donde los usuarios pueden crear solicitudes de soporte (tickets) y los técnicos pueden gestionarlas. Actualmente **no tiene seguridad implementada**.

Su tarea es **agregar autenticación y autorización** utilizando **Spring Security + JWT**, y contenerizar la aplicación con Docker.

### Requisitos generales

- Proyecto funcional al ser clonado y ejecutado con Docker.
- Uso de PostgreSQL (ya incluido en docker-compose).
- Seguridad implementada con JWT.
- Roles `USER` y `TECH`.
- Acceso restringido según el rol del usuario.
- Evidencia de funcionamiento (colección de Postman/Insomnia/Bruno o capturas de pantalla).

**Nota: El proyecto ya tiene una estructura básica de Spring Boot con endpoints funcionales para manejar tickets. No es necesario modificar la lógica de negocio, solo agregar seguridad. Ademas se inclye un postman collection para probar los endpoints. **

_Si van a crear mas endpoints como el login o registrarse recuerden actualizar postman/insomnia/bruno collection_

### Partes de desarrollo

#### Parte 1: Implementar login con JWT
- [ ] Crear endpoint `/auth/login`.
- [ ] Validar usuario y contraseña (puede estar en memoria o en BD).
- [ ] Retornar JWT firmado.

#### Parte 2: Configurar filtros y validación del token
- [ ] Crear filtro para validar el token en cada solicitud.
- [ ] Extraer usuario desde el JWT.
- [ ] Añadir a contexto de seguridad de Spring.

#### Parte 3: Proteger endpoints con Spring Security
- [ ] Permitir solo el acceso al login sin token.
- [ ] Proteger todos los demás endpoints.
- [ ] Manejar errores de autorización adecuadamente.

#### Parte 4: Aplicar roles a los endpoints

| Rol   | Acceso permitido                                 |
|--------|--------------------------------------------------|
| USER  | Crear tickets, ver solo sus tickets              |
| TECH  | Ver todos los tickets, actualizar estado         |

- [ ] Usar `@PreAuthorize` o reglas en el `SecurityFilterChain`.
- [ ] Validar que un USER solo vea sus tickets.
- [ ] Validar que solo un TECH pueda modificar tickets.

#### Parte 5: Agregar Docker
- [ ] `Dockerfile` funcional para la aplicación.
- [ ] `docker-compose.yml` que levante la app y la base de datos.
- [ ] Documentar cómo levantar el entorno (`docker compose up`).

#### Parte 6: Evidencia de pruebas
- [ ] Probar todos los flujos con Postman/Insomnia/Bruno.
- [ ] Mostrar que los roles se comportan correctamente.
- [ ] Incluir usuarios de prueba (`user`, `tech`) y contraseñas.
