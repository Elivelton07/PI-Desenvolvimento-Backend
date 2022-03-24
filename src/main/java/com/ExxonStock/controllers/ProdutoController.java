package com.ExxonStock.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ExxonStock.models.Cliente;
import com.ExxonStock.models.Produto;
import com.ExxonStock.repository.ClienteRepository;
import com.ExxonStock.repository.ProdutoRepository;

@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository pr;
	
	@Autowired
	private ClienteRepository cr;
	
	@RequestMapping("/cadastrarProduto")
	public String form() {
		return "produto/form-produto";
	}
	
	


	@RequestMapping(value = "/cadastrarProduto", method = RequestMethod.POST)
	public String form(@Valid Produto produto, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos...");
			return "redirect:/cadastrarProduto";
		}

		pr.save(produto);
		attributes.addFlashAttribute("mensagem", "Produto registrado com sucesso!");
		return "redirect:/cadastrarProduto";
	}
	
	@RequestMapping("/produtos")
	public ModelAndView listaProdutos() {
		ModelAndView mv = new ModelAndView("produto/lista-produto");
		Iterable<Produto> produtos = pr.findAll();
		mv.addObject("produtos", produtos);
		return mv;
	}
	
	@RequestMapping("/produto/{codigo}")
	public ModelAndView detalhesProduto(@PathVariable("codigo") long codigo) {
		Produto produto = pr.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("produto/detalhes-produto");
		mv.addObject("produto", produto);

		Iterable<Cliente>clientes = cr.findByProduto(produto);
		mv.addObject("cliente", clientes);

		return mv;

	}
	
	@RequestMapping("/deletarProduto")
	public String deletarProduto(long codigo) {
		Produto produto = pr.findByCodigo(codigo);
		pr.delete(produto);
		return "redirect:/produtos";
	}
	
	@RequestMapping(value = "/produto/{codigo}", method = RequestMethod.POST)
	public String detalhesProdutoPost(@PathVariable("codigo") long codigo, @Valid Cliente cliente,
			BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/produto/{codigo}";
		}

		
		if (cr.findByCnpj(cliente.getCnpj()) != null) {
			attributes.addFlashAttribute("mensagem_erro", "Cnpj já existente");
			return "redirect:/produto/{codigo}";
		}

		Produto produto = pr.findByCodigo(codigo);
		cliente.setProduto(produto);
		cr.save(cliente);
		attributes.addFlashAttribute("mensagem", "Cliente adionado com sucesso!");
		return "redirect:/produto/{codigo}";
	}
	
	@RequestMapping("/deletarCliente")
	public String deletarCliente(String cnpj) {
		Cliente cliente = cr.findByCnpj(cnpj);
		Produto produto = cliente.getProduto();
		String codigo = "" + produto.getCodigo();

		cr.delete(cliente);

		return "redirect:/produto/" + codigo;

	}
	

	@RequestMapping("/editar-produto")
	public ModelAndView editarProduto(long codigo) {
		Produto produto = pr.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("produto/update-produto");
		mv.addObject("produto", produto);
		return mv;
	}

	
	@RequestMapping(value = "/editar-produto", method = RequestMethod.POST)
	public String updateProduto(@Valid Produto produto, BindingResult result, RedirectAttributes attributes) {
		pr.save(produto);
		attributes.addFlashAttribute("success", "Produto alterado com sucesso!");

		long codigoLong = produto.getCodigo();
		String codigo = "" + codigoLong;
		return "redirect:/produto/" + codigo;
	}


}
