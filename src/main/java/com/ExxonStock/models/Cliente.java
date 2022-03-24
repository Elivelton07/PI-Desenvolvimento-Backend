package com.ExxonStock.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = true)
	private String cnpj;
	
	@NotEmpty
	private String nomeCliente;
	
	@NotEmpty
	private String pedidoCompra;
	
	@NotNull
	private Integer quantidade;
	
	


	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Cliente(String cnpj, @NotEmpty String nomeCliente, @NotEmpty String pedidoCompra,
			@NotNull Integer quantidade, Produto produto) {
		super();
		this.cnpj = cnpj;
		this.nomeCliente = nomeCliente;
		this.pedidoCompra = pedidoCompra;
		this.quantidade = quantidade;
		this.produto = produto;
	}



	@ManyToOne
	private Produto produto;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getPedidoCompra() {
		return pedidoCompra;
	}

	public void setPedidoCompra(String pedidoCompra) {
		this.pedidoCompra = pedidoCompra;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	
	
	
	
}
