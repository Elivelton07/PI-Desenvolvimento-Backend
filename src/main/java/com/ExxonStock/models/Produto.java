package com.ExxonStock.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;
	
	@NotEmpty
	private String nome;
	
	@NotEmpty
	private String descricao;
	
	@NotNull
	private Integer quantidade;
	
	@NotEmpty
	private String fabricacao;
	
	@NotNull
	private long lote;
	
	@OneToMany(mappedBy = "produto", cascade = CascadeType.REMOVE)
	private List<Cliente> clientes;

	public Produto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Produto(@NotEmpty String nome, @NotEmpty String descricao, @NotNull Integer quantidade,
			@NotEmpty String fabricacao, @NotNull long lote, List<Cliente> clientes) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.fabricacao = fabricacao;
		this.lote = lote;
		this.clientes = clientes;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getFabricacao() {
		return fabricacao;
	}

	public void setFabricacao(String fabricacao) {
		this.fabricacao = fabricacao;
	}

	public long getLote() {
		return lote;
	}

	public void setLote(long lote) {
		this.lote = lote;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	





	
	

}
