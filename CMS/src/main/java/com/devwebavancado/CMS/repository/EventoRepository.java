package com.devwebavancado.CMS.repository;

import com.devwebavancado.CMS.entidades.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
}
