package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.OperacionBancaria;
import uniandes.edu.co.proyecto.modelo.Usuario;
import uniandes.edu.co.proyecto.repositorio.OperacionBancariaRepository;
import uniandes.edu.co.proyecto.repositorio.UsuarioRepository;

import java.util.Collection;

@Controller
public class OperacionBancariaController {

    @Autowired
    private OperacionBancariaRepository operacionBancariaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/operaciones")
    public String operaciones(Model model) {
        Collection<OperacionBancaria> operaciones = operacionBancariaRepository.darOperacionesBancarias();
        model.addAttribute("operaciones", operaciones);
        return "operaciones";
    }

    @GetMapping("/operaciones/new")
    public String operacionForm(Model model) {
        model.addAttribute("operacion", new OperacionBancaria());
        return "operacionNuevo";
    }

    @PostMapping("/operaciones/new/save")
    public String operacionGuardar(@ModelAttribute OperacionBancaria operacion, @RequestParam("usuarioId") int clienteId) {
        Usuario cliente = usuarioRepository.darUsuario(clienteId);
        operacion.setCliente(cliente);
        operacionBancariaRepository.insertarOperacionBancaria(operacion.getTipo(), clienteId, operacion.getProducto(),operacion.getValor(), operacion.getPuntoAtencion(),operacion.getFecha());
        return "redirect:/operaciones";
    }

    @GetMapping("/operaciones/{id}/edit")
    public String operacionBancariaEditarForm(@PathVariable("id") String id, Model model) {
    OperacionBancaria operacionBancaria = operacionBancariaRepository.darOperacionBancaria(id);
    if (operacionBancaria != null) {
        model.addAttribute("operacionBancaria", operacionBancaria);
        return "operacionBancariaEditar";
    } else {
        return "redirect:/operaciones";
    }
}


    @PostMapping("/operaciones/{id}/edit/save")
    public String operacionEditarGuardar(@PathVariable("id") String id, @ModelAttribute OperacionBancaria operacion, @RequestParam("usuarioId") int clienteId) {
        Usuario cliente = usuarioRepository.darUsuario(clienteId);
        operacion.setCliente(cliente);
        operacionBancariaRepository.actualizarOperacionBancaria(id, operacion.getTipo(), clienteId, operacion.getProducto(), operacion.getValor(), operacion.getPuntoAtencion(),operacion.getFecha());
        return "redirect:/operaciones";
    }

    @GetMapping("/operaciones/{id}/delete")
    public String oficinaEliminar(@PathVariable("id") int id) {
        operacionBancariaRepository.eliminarOperacionBancaria(id);
        return "redirect:/operaciones";
    }
}
