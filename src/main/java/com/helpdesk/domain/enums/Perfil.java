package com.helpdesk.domain.enums;

public enum Perfil {
	CLIENTE(0, "CLIENTE"), TECNICO(1, "TECNICO"), ADMIN(2, "ADMIN");
	
	private Integer codigo;
	private String descricao;
	
	private Perfil(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static Perfil toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for(Perfil x: Perfil.values()){
			if(cod.equals(x.getCodigo())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Perfil inválido!");
	}
	
	
	
}
