package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.Cuenta;
import uniandes.edu.co.proyecto.repositorio.CuentaRepository;

import java.util.Collection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;





@Controller
public class CuentaController{

    @Autowired
    private CuentaRepository cuentaRepository;

    @GetMapping("/cuentas")
    public String cuentas(Model model) {
        model.addAttribute("cuentas", cuentaRepository.darCuentas());
        return "cuentas";
    }

    @GetMapping("/cuentas/new")
    public String cuentaForm(Model model) {
        model.addAttribute("cuenta", new Cuenta());
        return "cuentaNuevo";
    }
    
    @PostMapping("cuentas/new/save")
    public String cuentaGuardar(@ModelAttribute Cuenta cuenta) {
        cuentaRepository.insertarCuenta(cuenta.getTipo(), cuenta.getCliente(), cuenta.getSaldo(), cuenta.getFechaUltimaTransaccion(), cuenta.getEstado());
        return "redirect:/cuentas";
    }
    
    @GetMapping("/cuentas/{id}/edit")
    public String cuentaEditarForm(@PathVariable("id") int id, Model model) {
        Cuenta cuenta = cuentaRepository.darCuenta(id);
        if (cuenta != null){
            return "cuentaEditar";
        }
        else{
            return "redirect:/cuentas";
        }
    }

    @PostMapping("/cuentas/{id}/edit/save")
    public String cuentaEditarGuardar(@PathVariable("id") int id, @ModelAttribute Cuenta cuenta) {
        cuentaRepository.actualizarCuenta(id, cuenta.getSaldo(), cuenta.getFechaUltimaTransaccion(), cuenta.getEstado());
        return "redirect:/cuentas";
    }
    
    @GetMapping("/cuentas/{id}/delete")
    public String cuentaEliminar(@PathVariable("id") int id) {
        cuentaRepository.eliminarCuenta(id);
        return "redirect:/cuentas";
    }
    

}