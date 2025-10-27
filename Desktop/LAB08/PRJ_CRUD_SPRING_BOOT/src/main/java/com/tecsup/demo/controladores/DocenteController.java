package com.tecsup.demo.controladores;

import com.tecsup.demo.modelo.entidades.Docente;
import com.tecsup.demo.servicios.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import jakarta.validation.Valid;
import java.util.Map;

@Controller
@SessionAttributes("docente")
public class DocenteController {
    
    @Autowired
    private DocenteService servicio;
    
    @RequestMapping(value = "/docente", method = RequestMethod.GET)
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de Docentes CJAVA");
        model.addAttribute("docentes", servicio.listar());
        return "docenteView";
    }
    
    @RequestMapping(value = "/docente/form")
    public String crear(Map<String, Object> model) {
        Docente docente = new Docente();
        model.put("docente", docente);
        model.put("titulo", "Formulario de Docente");
        return "docenteFormView";
    }
    
    @RequestMapping(value = "/docente/form/{id}")
    public String editar(@PathVariable(value = "id") String id, Map<String, Object> model) {
        Docente docente = null;
        if (id != null && !id.isEmpty()) {
            docente = servicio.buscar(id);
        } else {
            return "redirect:/docente";
        }
        model.put("docente", docente);
        model.put("titulo", "Editar Docente");
        return "docenteFormView";
    }
    
    @RequestMapping(value = "/docente/form", method = RequestMethod.POST)
    public String guardar(@Valid Docente docente, BindingResult result, Model model, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario de Docente");
            return "docenteFormView";
        }
        servicio.grabar(docente);
        status.setComplete();
        return "redirect:/docente";
    }
    
    @RequestMapping(value = "/docente/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") String id) {
        if (id != null && !id.isEmpty()) {
            servicio.eliminar(id);
        }
        return "redirect:/docente";
    }
}
