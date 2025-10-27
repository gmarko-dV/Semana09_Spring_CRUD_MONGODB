package com.tecsup.demo.controladores;

import com.tecsup.demo.modelo.entidades.Alumno;
import com.tecsup.demo.servicios.AlumnoService;
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
@SessionAttributes("alumno")
public class AlumnoController {
    
    @Autowired
    private AlumnoService servicio;
    
    @RequestMapping(value = "/alumno", method = RequestMethod.GET)
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de Alumnos CJAVA");
        model.addAttribute("alumnos", servicio.listar());
        return "alumnoView";
    }
    
    @RequestMapping(value = "/alumno/form")
    public String crear(Map<String, Object> model) {
        Alumno alumno = new Alumno();
        model.put("alumno", alumno);
        model.put("titulo", "Formulario de Alumno");
        return "alumnoFormView";
    }
    
    @RequestMapping(value = "/alumno/form/{id}")
    public String editar(@PathVariable(value = "id") String id, Map<String, Object> model) {
        Alumno alumno = null;
        if (id != null && !id.isEmpty()) {
            alumno = servicio.buscar(id);
        } else {
            return "redirect:/alumno";
        }
        model.put("alumno", alumno);
        model.put("titulo", "Editar Alumno");
        return "alumnoFormView";
    }
    
    @RequestMapping(value = "/alumno/form", method = RequestMethod.POST)
    public String guardar(@Valid Alumno alumno, BindingResult result, Model model, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario de Alumno");
            return "alumnoFormView";
        }
        servicio.grabar(alumno);
        status.setComplete();
        return "redirect:/alumno";
    }
    
    @RequestMapping(value = "/alumno/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") String id) {
        if (id != null && !id.isEmpty()) {
            servicio.eliminar(id);
        }
        return "redirect:/alumno";
    }
}
