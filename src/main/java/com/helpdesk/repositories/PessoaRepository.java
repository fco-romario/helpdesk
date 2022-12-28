package com.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

import com.helpdesk.domain.Pessoa;

@Controller
public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

}
