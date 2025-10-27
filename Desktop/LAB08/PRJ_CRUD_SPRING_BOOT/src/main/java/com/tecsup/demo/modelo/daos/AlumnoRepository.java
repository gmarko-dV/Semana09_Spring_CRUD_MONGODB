package com.tecsup.demo.modelo.daos;

import com.tecsup.demo.modelo.entidades.Alumno;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlumnoRepository extends MongoRepository<Alumno, String> {
    
}
