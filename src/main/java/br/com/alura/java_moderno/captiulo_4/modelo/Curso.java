package br.com.alura.java_moderno.captiulo_4.modelo;

public class Curso {
	private String nome;
	private int alunos;
	
	public Curso(String nome, int alunos) {
		super();
		this.nome = nome;
		this.alunos = alunos;
	}

	public String getNome() {
		return nome;
	}

	public int getAlunos() {
		return alunos;
	}
}
