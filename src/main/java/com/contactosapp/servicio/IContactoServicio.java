package com.contactosapp.servicio;

import com.contactosapp.modelo.Contacto;

import java.util.List;

public interface IContactoServicio {
    public List<Contacto> listar();
    public Contacto buscarPorId(Integer idContacto);
    public void guardar(Contacto contacto);
    public void eliminar(Contacto contacto);
}
