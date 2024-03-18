package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.repositorio.ClienteRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class ClienteController {
    
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/cliente")
    public String clientes(Model model) {
        model.addAttribute("clientes", clienteRepository.darCliente(null));
        return model.toString();
    }

    @GetMapping("/cliente/new")
    public String clientesForm(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "clienteNuevo";
    }    

    @PostMapping("clientes/new/save")
    public String clienteGuardar(@ModelAttribute Cliente cliente) {
       clienteRepository.insertarCliente(cliente.getNombre(), cliente.getTipo_Documento(), 
       cliente.getNumero_Documento(), cliente.getDireccion_Electronica(), cliente.getClave(), 
       cliente.getCiudad(), cliente.getDireccion_Fisica(), cliente.getNacionalidad(), cliente.getDepartamento(), 
       cliente.getCodigo_Postal(), cliente.getLogin(), cliente.getRol());
        
        return "redirect:/clientes";
    }

    @GetMapping("clientes/{id}/edit")
    public String clienteEditarForm(@PathVariable("id") String id, Model model) {
        Cliente cliente = clienteRepository.darCliente(id);
        if (cliente != null){
            model.addAttribute("cliente", cliente);
            return "clienteEditar";
        }
        else{
            return "redirect:/clientes";
        }

    }
    
    @PostMapping("clientes/{id}/edit/save")
    public String clienteEditarGuardar(@PathVariable("id") String id, @ModelAttribute Cliente cliente){
        clienteRepository.actualizarCliente(id, cliente.getNombre(), cliente.getTipo_Documento(), 
        cliente.getNumero_Documento(), cliente.getDireccion_Electronica(), cliente.getClave(), 
        cliente.getCiudad(), cliente.getDireccion_Fisica(), cliente.getNacionalidad(), cliente.getDepartamento(), 
        cliente.getCodigo_Postal(), cliente.getLogin(), cliente.getRol());
        return "redirect:/clientes";
    }

    @GetMapping("clientes/{id}/delete")
    public String clienteEliminar(@PathVariable("id") String id) {
        clienteRepository.eliminarCliente(id);
        return "redirect:/clientes";
    }
    
}
