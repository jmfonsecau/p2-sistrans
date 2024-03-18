package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Operacion_Cuenta;
import uniandes.edu.co.proyecto.modelo.Operaciones;
import uniandes.edu.co.proyecto.repositorio.Operacion_CuentaRepository;

@Controller
public class Operacion_CuentaController {

    @Autowired
    private Operacion_CuentaRepository operacionCuentaRepository;

    @GetMapping("/operacion_cuenta")
    public String operaciones(Model model) {
        model.addAttribute("operaciones", operacionCuentaRepository.darOperaciones());
        return "operacionCuentaLista";
    }

    @GetMapping("/operacion_cuenta/new")
    public String operacionForm(Model model) {
        model.addAttribute("operacion", new Operacion_Cuenta());
        return "operacionCuentaNueva";
    }

    @PostMapping("/operacion_cuenta/new/save")
    public String operacionGuardar(@ModelAttribute Operaciones operaciones) {
        operacionCuentaRepository.insertarOperacion(operaciones.getTipoOperacion(), operaciones.getMonto(), operaciones.getFecha(), operaciones.getCuenta());
        return "redirect:/operacion_cuenta";
    }

    @GetMapping("/operacion_cuenta/{id}/edit")
    public String operacionEditarForm(@PathVariable("id") String id, Model model) {
        Operaciones operacion = operacionCuentaRepository.darOperacion(id);
        if (operacion != null) {
            model.addAttribute("operacion", operacion);
            return "operacionCuentaEditar";
        } else {
            return "redirect:/operacion_cuenta";
        }
    }

    @PostMapping("/operacion_cuenta/{id}/edit/save")
    public String operacionEditarGuardar(@PathVariable("id") String id, @ModelAttribute Operaciones operaciones) {
        operacionCuentaRepository.actualizarOperacion(id, operaciones.getTipoOperacion(), operaciones.getMonto(), operaciones.getFecha(), operaciones.getCuenta());
        return "redirect:/operacion_cuenta";
    }

    @GetMapping("/operacion_cuenta/{id}/delete")
    public String operacionEliminar(@PathVariable("id") String id) {
        operacionCuentaRepository.eliminarOperacion(id);
        return "redirect:/operacion_cuenta";
    }
}
