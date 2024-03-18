package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.Empleado;
import uniandes.edu.co.proyecto.repositorio.EmpleadoRepository;

@Controller
public class EmpleadoController {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @GetMapping("/empleado")
    public String empleados(Model model) {
        model.addAttribute("empleados", empleadoRepository.darEmpleados());
        return "empleadoLista";
    }

    @GetMapping("/empleado/new")
    public String empleadoForm(Model model) {
        model.addAttribute("empleado", new Empleado());
        return "empleadoNuevo";
    }

    @PostMapping("/empleado/new/save")
    public String empleadoGuardar(@ModelAttribute Empleado empleado) {
        empleadoRepository.insertarEmpleado(empleado.getNombre(), empleado.getTipo_Documento(), empleado.getNumero_Documento(), empleado.getDireccion_Electronica(), empleado.getClave(), empleado.getCiudad(), empleado.getDireccion_Fisica(), empleado.getNacionalidad(), empleado.getDepartamento(), empleado.getCodigo_Postal(), empleado.getLogin(), empleado.getRol());
        return "redirect:/empleado";
    }

    @GetMapping("/empleado/{id}/edit")
    public String empleadoEditarForm(@PathVariable("id") String id, Model model) {
        Cliente empleado = empleadoRepository.darEmpleado(id);
        if (empleado != null) {
            model.addAttribute("empleado", empleado);
            return "empleadoEditar";
        } else {
            return "redirect:/empleado";
        }
    }

    @PostMapping("/empleado/{id}/edit/save")
    public String empleadoEditarGuardar(@PathVariable("id") String id, @ModelAttribute Empleado empleado) {
        empleadoRepository.actualizarEmpleado(id, empleado.getNombre(), empleado.getTipo_Documento(), empleado.getNumero_Documento(), empleado.getDireccion_Electronica(), empleado.getClave(), empleado.getCiudad(), empleado.getDireccion_Fisica(), empleado.getNacionalidad(), empleado.getDepartamento(), empleado.getCodigo_Postal(), empleado.getLogin(), empleado.getRol());
        return "redirect:/empleado";
    }

    @GetMapping("/empleado/{id}/delete")
    public String empleadoEliminar(@PathVariable("id") String id) {
        empleadoRepository.eliminarEmpleado(id);
        return "redirect:/empleado";
    }
}
