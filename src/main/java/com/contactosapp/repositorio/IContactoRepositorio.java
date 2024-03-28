package com.contactosapp.repositorio;

import com.contactosapp.modelo.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContactoRepositorio extends JpaRepository<Contacto, Integer> {
}
