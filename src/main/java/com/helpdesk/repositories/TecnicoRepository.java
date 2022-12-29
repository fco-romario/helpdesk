package com.helpdesk.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

import com.helpdesk.domain.Pessoa;
import com.helpdesk.domain.Tecnico;

@Controller
public interface TecnicoRepository extends JpaRepository<Tecnico, Integer>{

}
