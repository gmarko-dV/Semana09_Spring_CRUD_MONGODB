package com.tecsup.demo.controladores;

import com.tecsup.demo.modelo.entidades.Curso;
import com.tecsup.demo.servicios.CursoService;
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
@SessionAttributes("curso")
public class CursoController {
    
    @Autowired
    private CursoService servicio;
    
    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de Cursos CJAVA");
        model.addAttribute("cursos", servicio.listar());
        return "listarView";
    }
    
    @RequestMapping(value = "/form")
    public String crear(Map<String, Object> model) {
        Curso curso = new Curso();
        model.put("curso", curso);
        model.put("titulo", "Formulario de Curso");
        return "formView";
    }
    
    @RequestMapping(value = "/form/{id}")
    public String editar(@PathVariable(value = "id") String id, Map<String, Object> model) {
        Curso curso = null;
        if (id != null && !id.isEmpty()) {
            curso = servicio.buscar(id);
        } else {
            return "redirect:/listar";
        }
        model.put("curso", curso);
        model.put("titulo", "Editar Curso");
        return "formView";
    }
    
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(@Valid Curso curso, BindingResult result, Model model, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario de Curso");
            return "formView";
        }
        //System.out.println(curso);
        servicio.grabar(curso);
        status.setComplete();
        return "redirect:/listar";
    }
    
    @RequestMapping(value = "/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") String id, Model model) {
        if (id != null && !id.isEmpty()) {
            try {
                servicio.eliminar(id);
                model.addAttribute("mensaje", "Curso eliminado exitosamente");
            } catch (Exception e) {
                model.addAttribute("error", "Error al eliminar el curso: " + e.getMessage());
            }
        }
        return "redirect:/listar";
    }
}
