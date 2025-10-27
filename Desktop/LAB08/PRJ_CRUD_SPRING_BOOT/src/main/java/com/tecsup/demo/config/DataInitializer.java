package com.tecsup.demo.config;

import com.tecsup.demo.modelo.entidades.Alumno;
import com.tecsup.demo.modelo.entidades.Curso;
import com.tecsup.demo.modelo.entidades.Docente;
import com.tecsup.demo.modelo.daos.AlumnoRepository;
import com.tecsup.demo.modelo.daos.CursoRepository;
import com.tecsup.demo.modelo.daos.DocenteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DataInitializer.class);

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private DocenteRepository docenteRepository;

    @Override
    public void run(String... args) throws Exception {
        logger.info("=== VERIFICANDO CONEXIÓN A MONGODB ===");
        
        // Verificar si hay datos existentes
        long cursosCount = cursoRepository.count();
        long docentesCount = docenteRepository.count();
        long alumnosCount = alumnoRepository.count();
        
        logger.info("Documentos existentes - Cursos: {}, Docentes: {}, Alumnos: {}", 
                   cursosCount, docentesCount, alumnosCount);
        
        // Solo cargar datos iniciales si la base está vacía
        if (cursosCount == 0 && docentesCount == 0 && alumnosCount == 0) {
            logger.info("Base de datos vacía, cargando datos iniciales...");
            
            Curso curso1 = new Curso(null, "Programación Java", 5);
            Curso curso2 = new Curso(null, "Base de Datos", 4);
            
            cursoRepository.save(curso1);
            cursoRepository.save(curso2);
            logger.info("✓ Cursos creados: {}", cursoRepository.count());
            
            Docente docente1 = new Docente(null, "Juan", "Pérez", "juan.perez@tecsup.edu.pe", "Ingeniería de Software", 10);
            Docente docente2 = new Docente(null, "María", "González", "maria.gonzalez@tecsup.edu.pe", "Base de Datos", 8);
            
            docenteRepository.save(docente1);
            docenteRepository.save(docente2);
            logger.info("✓ Docentes creados: {}", docenteRepository.count());
            
            Alumno alumno1 = new Alumno(null, "Pedro", "Rodríguez", "pedro.rodriguez@example.com", "12345678", "Ana Rodríguez");
            Alumno alumno2 = new Alumno(null, "Laura", "Sánchez", "laura.sanchez@example.com", "87654321", "Carlos Sánchez");
            
            alumnoRepository.save(alumno1);
            alumnoRepository.save(alumno2);
            logger.info("✓ Alumnos creados: {}", alumnoRepository.count());
            
            logger.info("=== CARGA DE DATOS INICIALES COMPLETADA ===");
            logger.info("✓ Base de datos 'escuela' creada con datos de prueba");
        } else {
            logger.info("✓ Base de datos ya contiene datos, omitiendo carga inicial");
        }
        
        logger.info("=== CONEXIÓN A MONGODB VERIFICADA EXITOSAMENTE ===");
    }
}

