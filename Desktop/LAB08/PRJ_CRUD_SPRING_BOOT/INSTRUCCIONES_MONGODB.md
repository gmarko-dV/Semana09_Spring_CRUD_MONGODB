# Instrucciones para Verificar MongoDB

## 1. Verificar que MongoDB está ejecutándose

### En Windows (PowerShell o CMD):
```bash
# Verificar si el servicio está corriendo
Get-Service -Name MongoDB

# O verificar si el puerto está en uso
netstat -ano | findstr :27017
```

### Si MongoDB no está ejecutándose:
```bash
# Iniciar servicio de MongoDB (si está instalado como servicio)
net start MongoDB

# O ejecutar manualmente
mongod
```

## 2. Instalar MongoDB (si no lo tienes instalado)

1. Descarga MongoDB Community Edition desde: https://www.mongodb.com/try/download/community
2. O instala MongoDB usando Chocolatey:
```bash
choco install mongodb
```

## 3. Verificar conexión con MongoDB Compass

1. Abre MongoDB Compass
2. Conecta a: `mongodb://localhost:27017`
3. Verás todas las bases de datos, incluida "escuela" cuando ejecutes la aplicación

## 4. Ejecutar la Aplicación Spring Boot

### Opción 1: Desde el IDE
- Ejecuta la clase `PrjCrudSpringBootApplication`
- Verás en los logs:
  ```
  === VERIFICANDO CONEXIÓN A MONGODB ===
  Documentos existentes - Cursos: 0, Docentes: 0, Alumnos: 0
  Base de datos vacía, cargando datos iniciales...
  ✓ Cursos creados: 2
  ✓ Docentes creados: 2
  ✓ Alumnos creados: 2
  === CARGA DE DATOS INICIALES COMPLETADA ===
  ```

### Opción 2: Desde la terminal (Maven)
```bash
mvn spring-boot:run
```

### Opción 3: Desde la terminal (con JAR)
```bash
mvn clean package
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

## 5. Verificar la Base de Datos

1. Abre MongoDB Compass
2. Conecta a `mongodb://localhost:27017`
3. Deberías ver la base de datos "escuela"
4. Dentro de "escuela" verás las colecciones:
   - `alumno` - Con 2 documentos
   - `curso` - Con 2 documentos  
   - `docente` - Con 2 documentos

## 6. Acceder a la Aplicación Web

- Abre tu navegador en: http://localhost:8086
- Rutas disponibles:
  - `/listar` - Listar cursos
  - `/alumno` - Listar alumnos
  - `/docente` - Listar docentes

## Solución de Problemas

### Error: "Cannot connect to MongoDB"
- Verifica que MongoDB esté ejecutándose: `mongosh` o `mongo`
- Verifica el puerto: debe ser 27017

### Error: "Connection refused"
- El servicio de MongoDB no está corriendo
- Ejecuta: `net start MongoDB` o `mongod`

### La base de datos no aparece en Compass
- Espera a que se inserte el primer documento (los datos iniciales)
- Refresca la vista en Compass
- Revisa los logs de la aplicación para ver errores

## Nota Importante

La base de datos "escuela" se crea **automáticamente** cuando se inserta el primer documento.
Spring Boot se conectará y creará la base de datos al iniciar si hay datos que insertar.

