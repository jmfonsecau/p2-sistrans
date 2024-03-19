package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.Prestamo;
import uniandes.edu.co.proyecto.repositorio.PrestamoRepository;

import java.util.Collection;

@Controller
public class PrestamoController {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @GetMapping("/prestamos")
    public String prestamos(Model model) {
        model.addAttribute("prestamos", prestamoRepository.darPrestamos());
        return "prestamos";
    }

    @GetMapping("/prestamos/new")
    public String prestamoForm(Model model) {
        model.addAttribute("prestamo", new Prestamo());
        return "prestamoNuevo";
    }

    @PostMapping("/prestamos/new/save")
    public String prestamoGuardar(@ModelAttribute Prestamo prestamo) {
        prestamoRepository.insertarPrestamo(prestamo.getMonto(), prestamo.getInteres(), prestamo.getNumeroCuotas(), prestamo.getDiaPagoCuota(), prestamo.getValorCuota(), prestamo.getEstado());
        return "redirect:/prestamos";
    }

    @GetMapping("/prestamos/{id}/edit")
    public String prestamoEditarForm(@PathVariable("id") int id, Model model) {
        Prestamo prestamo = prestamoRepository.darPrestamo(id);
        if (prestamo != null) {
            model.addAttribute("prestamo", prestamo);
            return "prestamoEditar";
        } else {
            return "redirect:/prestamos";
        }
    }

    @PostMapping("/prestamos/{id}/edit/save")
    public String prestamoEditarGuardar(@PathVariable("id") int id, @ModelAttribute Prestamo prestamo) {
        prestamoRepository.actualizarPrestamo(id, prestamo.getMonto(), prestamo.getInteres(), prestamo.getNumeroCuotas(), prestamo.getDiaPagoCuota(), prestamo.getValorCuota(), prestamo.getEstado());
        return "redirect:/prestamos";
    }

    @GetMapping("/prestamos/{id}/delete")
    public String prestamoEliminar(@PathVariable("id") int id) {
        prestamoRepository.eliminarPrestamo(id);
        return "redirect:/prestamos";
    }
}
