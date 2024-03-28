package com.contactosapp.controlador;

import com.contactosapp.modelo.Contacto;
import com.contactosapp.servicio.IContactoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class IndexControlador {
    private static final Logger logger =
            LoggerFactory.getLogger(IndexControlador.class);

    @Autowired
    IContactoServicio contactoServicio;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String iniciar(ModelMap modelo) {
        List<Contacto> contactos = contactoServicio.listar();
        contactos.forEach((contacto) -> logger.info(contacto.toString()));
        modelo.put("contactos", contactos);
        return "index";
    }

    @GetMapping("/agregar")
    public String mostrarAgregar(){
        return "agregar";
    }

    @PostMapping("/agregar")
    public String agregar(@ModelAttribute("contactoForm") Contacto contacto){
        logger.info("Contacto a agregar: " + contacto);
        contactoServicio.guardar(contacto);
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String mostrarEditar(@PathVariable(value = "id") int idContacto, ModelMap modelo) {
        Contacto contacto = contactoServicio.buscarPorId(idContacto);
        logger.info("Contacto a actualizar: " + contacto);
        modelo.put("contacto", contacto);
        return "editar";
    }

    @PostMapping("/editar")
    public String editar(@ModelAttribute("contactoForm") Contacto contacto){
        logger.info("Contacto a actualizar: " + contacto);
        contactoServicio.guardar(contacto);
        return "redirect:/";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") int idContacto) {
        Contacto contacto = new Contacto();
        contacto.setIdContacto(idContacto);
        logger.info("Contacto a eliminar: " + contacto);
        contactoServicio.eliminar(contacto);
        return "redirect:/";
    }
}
