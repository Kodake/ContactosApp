package com.contactosapp.servicio;

import com.contactosapp.modelo.Contacto;
import com.contactosapp.repositorio.IContactoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactoServicio implements IContactoServicio {
    @Autowired
    private IContactoRepositorio contactoRepositorio;

    @Override
    public List<Contacto> listar() {
        return contactoRepositorio.findAll();
    }

    @Override
    public Contacto buscarPorId(Integer idContacto) {
        return contactoRepositorio.findById(idContacto).orElse(null);
    }

    @Override
    public void guardar(Contacto contacto) {
        contactoRepositorio.save(contacto);
    }

    @Override
    public void eliminar(Contacto contacto) {
        contactoRepositorio.delete(contacto);
    }
}
