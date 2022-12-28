package com.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

import com.helpdesk.domain.Chamado;
@Controller
public interface ChamadoRepository extends JpaRepository<Chamado, Integer>{

}
