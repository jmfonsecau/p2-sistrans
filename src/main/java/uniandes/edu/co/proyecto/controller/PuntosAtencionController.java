package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.PuntosAtencion;
import uniandes.edu.co.proyecto.repositorio.PuntosAtencionRepository;

import java.util.Collection;

@Controller
public class PuntosAtencionController {

    @Autowired
    private PuntosAtencionRepository puntosAtencionRepository;

    @GetMapping("/puntosAtencion")
    public String puntosAtencion(Model model) {
        model.addAttribute("puntosAtencion", puntosAtencionRepository.darPuntosAtencion());
        return "puntosAtencion";
    }

    @GetMapping("/puntosAtencion/new")
    public String puntosAtencionForm(Model model) {
        model.addAttribute("puntosAtencion", new PuntosAtencion());
        return "puntosAtencionNuevo";
    }

    @PostMapping("/puntosAtencion/new/save")
    public String puntosAtencionGuardar(@ModelAttribute PuntosAtencion puntosAtencion) {
        puntosAtencionRepository.insertarPuntosAtencion(puntosAtencion.getOperaciones(), puntosAtencion.getLatitud(), puntosAtencion.getLongitud(), puntosAtencion.getTipo());
        return "redirect:/puntosAtencion";
    }

    @GetMapping("/puntosAtencion/{id}/edit")
    public String puntosAtencionEditarForm(@PathVariable("id") String id, Model model) {
        PuntosAtencion puntosAtencion = puntosAtencionRepository.darPuntosAtencion(id);
        if (puntosAtencion != null) {
            model.addAttribute("puntosAtencion", puntosAtencion);
            return "puntosAtencionEditar";
        } else {
            return "redirect:/puntosAtencion";
        }
    }

    @PostMapping("/puntosAtencion/{id}/edit/save")
    public String puntosAtencionEditarGuardar(@PathVariable("id") String id, @ModelAttribute PuntosAtencion puntosAtencion) {
        puntosAtencionRepository.actualizarPuntosAtencion(id, puntosAtencion.getOperaciones(), puntosAtencion.getLatitud(), puntosAtencion.getLongitud(), puntosAtencion.getTipo());
        return "redirect:/puntosAtencion";
    }

    @GetMapping("/puntosAtencion/{id}/delete")
    public String puntosAtencionEliminar(@PathVariable("id") String id) {
        puntosAtencionRepository.eliminarPuntosAtencion(id);
        return "redirect:/puntosAtencion";
    }
}
