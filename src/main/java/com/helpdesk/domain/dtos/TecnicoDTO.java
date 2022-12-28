package com.helpdesk.domain.dtos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.helpdesk.domain.Tecnico;

public class TecnicoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	protected Integer id;
	protected String nome;
	protected String cpf;
	protected String email;
	protected String senha;

	protected Set<Integer> perfis = new HashSet<>();

	public TecnicoDTO() {
		super();
	}

	public TecnicoDTO(Tecnico obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();

	}
	
	
}
