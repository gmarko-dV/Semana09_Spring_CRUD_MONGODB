package com.tecsup.demo.modelo.daos;

import com.tecsup.demo.modelo.entidades.Docente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DocenteRepository extends MongoRepository<Docente, String> {
    
}
