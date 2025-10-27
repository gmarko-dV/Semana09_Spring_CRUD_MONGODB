package com.tecsup.demo.servicios;

import com.tecsup.demo.modelo.entidades.Docente;

import java.util.List;

public interface DocenteService {
    
    public List<Docente> listar();
    
    public void grabar(Docente docente);
    
    public Docente buscar(String id);
    
    public void eliminar(String id);
}
