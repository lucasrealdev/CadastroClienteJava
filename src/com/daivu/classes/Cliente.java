package com.daivu.classes;

public class Cliente {
	
	// DECLARAR OS ATRIBUTOS
	private String nome, email, cpf, telefone, genero;

	// CONSTRUTOR
	public Cliente(String nome, String email, String cpf, String telefone, String genero) {
		super();
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.telefone = telefone;
		this.genero = genero;
	}

	public String getNome() {
		return nome;
	}

	// MÉTODOS
	public String mostrarDados() {
		return "Nome: " + nome + "\nEmail: " + email + "\nCPF: " + cpf + "\nTelefone: " + telefone + "\nGênero: " + genero;
	}
}
