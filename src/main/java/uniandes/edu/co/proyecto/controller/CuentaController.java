package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Cuenta;
import uniandes.edu.co.proyecto.repositorio.CuentaRepository;

@Controller
public class CuentaController {

    @Autowired
    private CuentaRepository cuentaRepository;

    @GetMapping("/cuenta")
    public String cuentas(Model model) {
        model.addAttribute("cuentas", cuentaRepository.darCuentas());
        return "cuentaLista";
    }

    @GetMapping("/cuenta/new")
    public String cuentaForm(Model model) {
        model.addAttribute("cuenta", new Cuenta());
        return "cuentaNuevo";
    }

    @PostMapping("/cuenta/new/save")
    public String cuentaGuardar(@ModelAttribute Cuenta cuenta) {
        cuentaRepository.insertarCuenta(cuenta.getTipo(), cuenta.getEstado(), cuenta.getNumeroIdentificador(), cuenta.getSaldo(), cuenta.getOperaciones_Permitidas(), cuenta.getFecha_ultima_transaccion());
        return "redirect:/cuenta";
    }

    @GetMapping("/cuenta/{id}/edit")
    public String cuentaEditarForm(@PathVariable("id") String id, Model model) {
        Cuenta cuenta = cuentaRepository.darCuenta(id);
        if (cuenta != null) {
            model.addAttribute("cuenta", cuenta);
            return "cuentaEditar";
        } else {
            return "redirect:/cuenta";
        }
    }

    @PostMapping("/cuenta/{id}/edit/save")
    public String cuentaEditarGuardar(@PathVariable("id") String id, @ModelAttribute Cuenta cuenta) {
        cuentaRepository.actualizarCuenta(id, cuenta.getTipo(), cuenta.getEstado(), cuenta.getNumeroIdentificador(), cuenta.getSaldo(), cuenta.getOperaciones_Permitidas(), cuenta.getFecha_ultima_transaccion());
        return "redirect:/cuenta";
    }

    @GetMapping("/cuenta/{id}/delete")
    public String cuentaEliminar(@PathVariable("id") String id) {
        cuentaRepository.eliminarCuenta(id);
        return "redirect:/cuenta";
    }
}
