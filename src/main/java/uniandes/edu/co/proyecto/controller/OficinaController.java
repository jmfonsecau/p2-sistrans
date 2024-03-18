package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Oficina;
import uniandes.edu.co.proyecto.repositorio.OficinaRepository;

@Controller
public class OficinaController {

    @Autowired
    private OficinaRepository oficinaRepository;

    @GetMapping("/oficina")
    public String oficinas(Model model) {
        model.addAttribute("oficinas", oficinaRepository.darOficinas());
        return "oficinaLista";
    }

    @GetMapping("/oficina/new")
    public String oficinaForm(Model model) {
        model.addAttribute("oficina", new Oficina());
        return "oficinaNueva";
    }

    @PostMapping("/oficina/new/save")
    public String oficinaGuardar(@ModelAttribute Oficina oficina) {
        oficinaRepository.insertarOficina(oficina.getNombre(), oficina.getDireccion(), oficina.getNum_puntos_atencion(), oficina.getCiudad());
        return "redirect:/oficina";
    }

    @GetMapping("/oficina/{id}/edit")
    public String oficinaEditarForm(@PathVariable("id") String id, Model model) {
        Oficina oficina = (Oficina) oficinaRepository.darOficina(id);
        if (oficina != null) {
            model.addAttribute("oficina", oficina);
            return "oficinaEditar";
        } else {
            return "redirect:/oficina";
        }
    }

    @PostMapping("/oficina/{id}/edit/save")
    public String oficinaEditarGuardar(@PathVariable("id") String id, @ModelAttribute Oficina oficina) {
        oficinaRepository.actualizarOficina(id, oficina.getNombre(), oficina.getDireccion(), oficina.getNum_puntos_atencion(), oficina.getCiudad());
        return "redirect:/oficina";
    }

    @GetMapping("/oficina/{id}/delete")
    public String oficinaEliminar(@PathVariable("id") String id) {
        oficinaRepository.eliminarOficina(id);
        return "redirect:/oficina";
    }
}
