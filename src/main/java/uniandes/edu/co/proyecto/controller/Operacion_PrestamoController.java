package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Operacion_Prestamo;
import uniandes.edu.co.proyecto.modelo.Operaciones;
import uniandes.edu.co.proyecto.repositorio.Operacion_PrestamoRepository;

@Controller
public class Operacion_PrestamoController {

    @Autowired
    private Operacion_PrestamoRepository operacionPrestamoRepository;

    @GetMapping("/operacion_prestamo")
    public String operaciones(Model model) {
        model.addAttribute("operaciones", operacionPrestamoRepository.darOperaciones());
        return "operacionPrestamoLista";
    }

    @GetMapping("/operacion_prestamo/new")
    public String operacionForm(Model model) {
        model.addAttribute("operacion", new Operacion_Prestamo());
        return "operacionPrestamoNueva";
    }

    @PostMapping("/operacion_prestamo/new/save")
    public String operacionGuardar(@ModelAttribute Operacion_Prestamo operacion) {
        operacionPrestamoRepository.insertarOperacion(operacion.getTipoOperacion(), operacion.getEstado(), operacion.getOperacion_a_hacer(), operacion.getMonto(), operacion.getInteres(), operacion.getCuotas(), operacion.getDia_pago(), operacion.getValor_cuota());
        return "redirect:/operacion_prestamo";
    }

    @GetMapping("/operacion_prestamo/{id}/edit")
    public String operacionEditarForm(@PathVariable("id") String id, Model model) {
        Operaciones operacion = operacionPrestamoRepository.darOperacion(id);
        if (operacion != null) {
            model.addAttribute("operacion", operacion);
            return "operacionPrestamoEditar";
        } else {
            return "redirect:/operacion_prestamo";
        }
    }

    @PostMapping("/operacion_prestamo/{id}/edit/save")
    public String operacionEditarGuardar(@PathVariable("id") String id, @ModelAttribute Operacion_Prestamo operacion) {
        operacionPrestamoRepository.actualizarOperacion(id, operacion.getTipoOperacion(), operacion.getEstado(), operacion.getOperacion_a_hacer(), operacion.getMonto(), operacion.getInteres(), operacion.getCuotas(), operacion.getDia_pago(), operacion.getValor_cuota());
        return "redirect:/operacion_prestamo";
    }

    @GetMapping("/operacion_prestamo/{id}/delete")
    public String operacionEliminar(@PathVariable("id") String id) {
        operacionPrestamoRepository.eliminarOperacion(id);
        return "redirect:/operacion_prestamo";
    }
}
