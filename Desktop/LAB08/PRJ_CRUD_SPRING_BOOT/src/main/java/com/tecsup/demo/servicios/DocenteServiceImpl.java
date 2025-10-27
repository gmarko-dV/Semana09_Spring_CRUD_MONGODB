package com.tecsup.demo.servicios;

import com.tecsup.demo.modelo.daos.DocenteRepository;
import com.tecsup.demo.modelo.entidades.Docente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocenteServiceImpl implements DocenteService {
    
    @Autowired
    private DocenteRepository dao;
    
    @Override
    public void grabar(Docente docente) {
        dao.save(docente);
    }
    
    @Override
    public void eliminar(String id) {
        dao.deleteById(id);
    }
    
    @Override
    public Docente buscar(String id) {
        return dao.findById(id).orElse(null);
    }
    
    @Override
    public List<Docente> listar() {
        return dao.findAll();
    }
}
