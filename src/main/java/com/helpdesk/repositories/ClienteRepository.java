package com.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

import com.helpdesk.domain.Cliente;

@Controller
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
