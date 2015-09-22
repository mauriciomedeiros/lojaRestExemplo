package br.com.alura.loja.modelo;

import com.thoughtworks.xstream.XStream;

public class Projeto {
	private long id;
	private String descricao;
	private int ano;

	public Projeto(long id, String descricao, int ano) {
		this.id = id;
		this.descricao = descricao;
		this.ano = ano;
	
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String toXml() {
		 return new XStream().toXML(this);
	}

}
