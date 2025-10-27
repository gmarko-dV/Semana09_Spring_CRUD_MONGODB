# Spring Boot CRUD con MongoDB

Aplicación CRUD desarrollada con Spring Boot y MongoDB para la gestión de Cursos, Alumnos y Docentes.

## 🚀 Características

- ✅ CRUD completo para Cursos, Alumnos y Docentes
- ✅ Interfaz web con Thymeleaf y Bootstrap
- ✅ Base de datos MongoDB
- ✅ Carga automática de datos iniciales
- ✅ Validación de formularios

## 📋 Requisitos

- Java 17 o superior
- Maven 3.6+
- MongoDB (localhost:27017)
- MongoDB Compass (opcional, para visualizar datos)

## 🔧 Configuración

### 1. Clonar el repositorio
```bash
git clone https://github.com/gmarko-dV/Semana09_Spring_CRUD_MONGODB.git
cd Semana09_Spring_CRUD_MONGODB
```

### 2. Iniciar MongoDB
```bash
# Windows
net start MongoDB

# O ejecutar mongod en la terminal
mongod
```

### 3. Configurar la aplicación
El archivo `application.properties` está configurado para:
- Host: localhost
- Puerto: 27017
- Base de datos: escuela

## 🚀 Ejecutar la Aplicación

```bash
# Opción 1: Usar Maven
mvn spring-boot:run

# Opción 2: Compilar y ejecutar JAR
mvn clean package
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

La aplicación estará disponible en: http://localhost:8086

## 📂 Estructura del Proyecto

```
src/
├── main/
│   ├── java/com/tecsup/demo/
│   │   ├── controladores/      # Controladores REST
│   │   ├── modelo/
│   │   │   ├── entidades/     # Entidades MongoDB
│   │   │   └── daos/          # Repositories
│   │   ├── servicios/           # Servicios de negocio
│   │   └── config/            # Configuración y carga de datos
│   └── resources/
│       ├── templates/         # Vistas Thymeleaf
│       └── application.properties
```

## 🎯 Endpoints

- `/listar` - Listar cursos
- `/alumno` - Listar alumnos
- `/docente` - Listar docentes
- `/form` - Crear/editar curso
- `/alumno/form` - Crear/editar alumno
- `/docente/form` - Crear/editar docente

## 📊 Entidades

### Curso
- Nombre
- Créditos

### Alumno
- Nombre y Apellido
- Email
- DNI
- Apoderado
- Estado activo

### Docente
- Nombre y Apellido
- Email
- Especialidad
- Años de experiencia
- Estado activo

## 🛠️ Tecnologías

- **Spring Boot 3.5.7**
- **Spring Data MongoDB**
- **Thymeleaf**
- **Bootstrap 5.3.3**
- **MongoDB**
- **Java 17**

## 👤 Autor

gmarko-dV

## 📄 Licencia

Este proyecto es de uso educativo.

