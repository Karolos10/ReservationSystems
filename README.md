Reservation Systems
Reservation Systems es una aplicación basada en Java Spring Boot que permite gestionar reservas, comentarios, y usuarios en un sistema de negocios. Ofrece funcionalidades para autenticar usuarios, gestionar reservas, y más.

Tabla de Contenidos
Descripción del Proyecto
Características
Tecnologías Utilizadas
Requisitos
Configuración del Entorno
Variables de Entorno
Instrucciones de Instalación y Ejecución
Uso
Estructura del Proyecto
Contribuciones
Licencia
Descripción del Proyecto
Reservation Systems es una aplicación que permite a los usuarios gestionar reservas en un sistema de negocios, incluyendo funcionalidades para autenticar usuarios, añadir y eliminar comentarios, y gestionar detalles de negocios y reservas.

Características
Autenticación de usuarios con JWT.
Gestión de usuarios (crear, eliminar).
Gestión de comentarios.
Gestión de negocios.
CRUD completo para reservas.
Tecnologías Utilizadas
Java: Lenguaje de programación.
Spring Boot: Framework para desarrollar la aplicación.
Spring Security: Para la autenticación y autorización.
MySQL: Base de datos relacional.
BCrypt: Para la codificación de contraseñas.
Maven: Herramienta de construcción y gestión de dependencias.
JWT: Para la autenticación basada en tokens.
Requisitos
Antes de ejecutar el proyecto, asegúrate de tener instalados los siguientes requisitos:

JDK 17 o superior.
Maven 3.6.0 o superior.
MySQL 5.7 o superior.
Configuración del Entorno
Base de Datos: Asegúrate de tener una base de datos MySQL en funcionamiento. Crea una base de datos llamada bookingsystems y configura el usuario y contraseña según tus necesidades.

Archivo de Configuración: Renombra el archivo application.properties a application-dev.properties o application.yml y cámbialo según la configuración de tu entorno de desarrollo.

Variables de Entorno
Define las siguientes variables de entorno para tu aplicación:

TOKEN: La clave secreta para la firma de JWT.
CONECCTION_BASE: La URL de conexión a tu base de datos MySQL.
PASSWORD: La contraseña para acceder a la base de datos MySQL.

set TOKEN=1DaqgqwAM55oOVcI/T9Sbkssg0J+IK2bZhYmLc6VH9o=
set CONECCTION_BASE=jdbc:mysql://localhost:3306/bookingsystems
set PASSWORD=123456

Clonar el repositorio
git clone https://github.com/tu-usuario/reservation-systems.git

Navega al directorio del proyecto:
cd reservation-systems

mvn clean install

mvn spring-boot:run

La aplicación debería estar disponible en http://localhost:8080.

Uso
Autenticación: Realiza peticiones POST a /auth con el cuerpo { "username": "usuario", "password": "contraseña" } para obtener un token JWT.
Gestión de Usuarios: Puedes eliminar usuarios mediante peticiones DELETE a /users/{id}.
Gestión de Comentarios: Realiza peticiones GET a /comments/{reservationId} para obtener un comentario y POST para añadir uno nuevo.
Gestión de Negocios: Realiza peticiones GET a /business para obtener una lista de negocios.
Estructura del Proyecto
src/main/java/com/example/ReservationSystems: Contiene el código fuente de la aplicación.
configurations: Configuración de seguridad y autenticación.
controller: Controladores REST para manejar las solicitudes HTTP.
dto: Objetos de transferencia de datos.
model: Entidades del modelo de datos.
repository: Repositorios JPA para acceso a datos.
service: Servicios de lógica de negocio.
src/main/resources: Contiene archivos de configuración y recursos estáticos.
application.properties: Configuración de la aplicación.