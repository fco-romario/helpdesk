package com.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helpdesk.domain.Cliente;
import com.helpdesk.domain.Pessoa;
import com.helpdesk.domain.Tecnico;
import com.helpdesk.domain.dtos.ClienteDTO;
import com.helpdesk.repositories.ClienteRepository;
import com.helpdesk.repositories.PessoaRepository;
import com.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.helpdesk.services.exceptions.ObjectNotFoundException;

import jakarta.validation.Valid;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;

	public Cliente findById(Integer id) {
		Optional<Cliente> obj = clienteRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado, Id: " + id));
	}

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public Cliente create(ClienteDTO clienteDTO) {
		clienteDTO.setId(null);
		validaPorCpfEEmail(clienteDTO);
		Cliente newObj = new Cliente(clienteDTO);
		return clienteRepository.save(newObj);
	}
	
	public Cliente update(Integer id, @Valid ClienteDTO clienteDTO) {
		clienteDTO.setId(id);
		Cliente oldObj = findById(id);
		validaPorCpfEEmail(clienteDTO);
		oldObj = new Cliente(clienteDTO);
		return clienteRepository.save(oldObj);
	}
	
	public void delete(Integer id) {
		Cliente obj = findById(id);
		if(obj.getChamados().size() > 0) {
			throw new DataIntegrityViolationException("Cliente possui OS, não pode ser deletado!");
		}
		clienteRepository.delete(obj);
		
	}
	
	private void validaPorCpfEEmail(ClienteDTO objDTO){
		Optional<Pessoa> obj = pessoaRepository.findByCpf(objDTO.getCpf());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("CPF já cadastrado!");
		}
		
		obj = pessoaRepository.findByEmail(objDTO.getEmail());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("Email já cadastrado!");
		}
		
	}


	
	
}
