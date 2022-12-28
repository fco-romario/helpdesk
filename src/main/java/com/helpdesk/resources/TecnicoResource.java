package com.helpdesk.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helpdesk.domain.Tecnico;
import com.helpdesk.domain.dtos.TecnicoDTO;
import com.helpdesk.services.TecnicoService;

@RestController
@RequestMapping("/tecnicos")
public class TecnicoResource {
	
	@Autowired
	private  TecnicoService tecnicoService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Tecnico> findById(@PathVariable Integer id){
		Tecnico obj = tecnicoService.findById(id); 
		return ResponseEntity.ok().body(obj);
	}
}