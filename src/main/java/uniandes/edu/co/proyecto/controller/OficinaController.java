package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.Oficina;
import uniandes.edu.co.proyecto.modelo.Usuario;
import uniandes.edu.co.proyecto.repositorio.OficinaRepository;
import uniandes.edu.co.proyecto.repositorio.UsuarioRepository;

import java.util.Collection;

@Controller
public class OficinaController {

    @Autowired
    private OficinaRepository oficinaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/oficinas")
    public String oficinas(Model model) {
        model.addAttribute("oficinas", oficinaRepository.darOficinas());
        return "oficinas";
    }

    @GetMapping("/oficinas/new")
    public String oficinaForm(Model model) {
        Collection<Usuario> gerentes = usuarioRepository.darUsuarios();
        model.addAttribute("oficina", new Oficina());
        model.addAttribute("gerentes", gerentes);
        return "oficinaNuevo";
    }

    @PostMapping("/oficinas/new/save")
    public String oficinaGuardar(@ModelAttribute Oficina oficina, @RequestParam("gerenteId") int gerenteId) {
        Usuario gerente = usuarioRepository.darUsuario(gerenteId);
        oficina.setGerente(gerente);
        oficinaRepository.insertarOficina(oficina.getNombre(), oficina.getDireccion(), oficina.getNumeroPuntosAtencion(), gerenteId);
        return "redirect:/oficinas";
    }


    @GetMapping("/oficinas/{id}/delete")
    public String oficinaEliminar(@PathVariable("id") int id) {
        oficinaRepository.eliminarOficina(id);
        return "redirect:/oficinas";
    }
}
