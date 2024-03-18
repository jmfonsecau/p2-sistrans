package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Operaciones;
import uniandes.edu.co.proyecto.repositorio.OperacionesRepository;

@Controller
public class OperacionController {

    @Autowired
    private OperacionesRepository operacionesRepository;

    @GetMapping("/operaciones")
    public String operaciones(Model model) {
        model.addAttribute("operaciones", operacionesRepository.darOperaciones());
        return "operacionesLista"; // Ajusta el nombre de la vista según tu estructura
    }

    @GetMapping("/operaciones/new")
    public String operacionForm(Model model) {
        model.addAttribute("operacion", new Operaciones());
        return "operacionNueva"; // Ajusta el nombre de la vista según tu estructura
    }

    @PostMapping("/operaciones/new/save")
    public String operacionGuardar(@ModelAttribute Operaciones operacion) {
        operacionesRepository.insertarOperacion(operacion.getTipoOperacion(), null, null, operacion.getMonto(), null, null, null, null);
        return "redirect:/operaciones";
    }

    @GetMapping("/operaciones/{id}/edit")
    public String operacionEditarForm(@PathVariable("id") String id, Model model) {
        Operaciones operacion = operacionesRepository.darOperacion(id);
        if (operacion != null) {
            model.addAttribute("operacion", operacion);
            return "operacionEditar"; // Ajusta el nombre de la vista según tu estructura
        } else {
            return "redirect:/operaciones";
        }
    }

    @PostMapping("/operaciones/{id}/edit/save")
    public String operacionEditarGuardar(@PathVariable("id") String id, @ModelAttribute Operaciones operacion) {
        operacionesRepository.actualizarOperacion(id, operacion.getTipoOperacion(), id, id, operacion.getMonto(), null, null, id, null);
        return "redirect:/operaciones";
    }

    @GetMapping("/operaciones/{id}/delete")
    public String operacionEliminar(@PathVariable("id") String id) {
        operacionesRepository.eliminarOperacion(id);
        return "redirect:/operaciones";
    }
}
