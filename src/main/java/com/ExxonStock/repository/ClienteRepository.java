package com.ExxonStock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.ExxonStock.models.Cliente;
import com.ExxonStock.models.Produto;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

	Iterable<Cliente> findByProduto(Produto nome);

	
	Cliente findByCnpj(String cnpj);

	Cliente findById(long id);

	// Query para a busca
	@Query(value = "select u from Cliente u where u.nomeCliente like %?1%")
	List<Cliente> findByNomesCliente(String nomeCliente);
	
	
}