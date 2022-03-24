package com.ExxonStock.repository;


import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ExxonStock.models.Produto;


public interface ProdutoRepository extends CrudRepository<Produto, Long>{
	
	Produto findByCodigo(long codigo);

	List<Produto> findByNome(String nome);


	@Query(value = "select u from Produto u where u.nome like %?1%")
	List<Produto> findByNomesProduto(String nome);
	

}
