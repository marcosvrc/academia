package br.com.academia.vo;

import java.io.Serializable;
import java.util.Date;

public class ClienteVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String nome;
	private String cpf;
	private Date dataNascimento;
	private String email;
	private boolean temDesconto;
	private String descricaoTemDesconto;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean getTemDesconto() {
		return temDesconto;
	}
	public void setTemDesconto(boolean temDesconto) {
		this.temDesconto = temDesconto;
	}
	public String getDescricaoTemDesconto() {
		String label;
		if(this.getTemDesconto()){
			label = "Sim";
		}else{
			label = "N�o";
		}
		return label;
	}
	
	
	
	
	
}
