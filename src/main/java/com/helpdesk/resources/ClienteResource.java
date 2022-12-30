package com.helpdesk.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.helpdesk.domain.Cliente;
import com.helpdesk.domain.Tecnico;
import com.helpdesk.domain.dtos.ClienteDTO;
import com.helpdesk.services.ClienteService;

import jakarta.servlet.Servlet;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/{id}")
	public ResponseEntity<ClienteDTO> findById(@PathVariable Integer id){
		Cliente obj = clienteService.findById(id);
		return ResponseEntity.ok().body(new ClienteDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> findAll(){
		List<Cliente> list = clienteService.findAll();
		List<ClienteDTO> listDTO = list.stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<ClienteDTO> create(@Valid @RequestBody ClienteDTO clienteDTO){
		Cliente newObj = clienteService.create(clienteDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ClienteDTO> update(@PathVariable Integer id , @Valid @RequestBody ClienteDTO clienteDTO){
		Cliente obj = clienteService.update(id, clienteDTO);
		return ResponseEntity.ok().body(new ClienteDTO(obj));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ClienteDTO> update(@PathVariable Integer id){
		clienteService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
