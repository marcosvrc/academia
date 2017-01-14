package br.com.academia.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.academia.service.ProdutoService;
import br.com.academia.vo.ClienteVO;
import br.com.academia.vo.ProdutoVO;

@Controller("produtoMbean")
@Scope("session")
public class ProdutoController {

	private ProdutoService produtoService;
	private List<ProdutoVO> listaProdutoVO;
	private ProdutoVO produto = new ProdutoVO();

	@Autowired
	public ProdutoController(ProdutoService produtoService){
		this.produtoService = produtoService;
	}
	

	public ProdutoVO getProduto() {
		return produto;
	}

	public void setProduto(ProdutoVO produto) {
		this.produto = produto;
	}
	
	/**
	 * 
	 * @return
	 */
	public String salvar() {
		// Calling Business Service
		produtoService.salvar(produto);
		// Add message
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("O Produto "+this.produto.getDescricao()+" foi gravado com sucesso!"));
		this.limparCampos();
		return "";
	}
	
	public void getListaProdutoVO() {
		produtoService.listarTodosProdutos();
	}
	
	private void limparCampos(){
		this.produto.setDescricao(null);
		this.produto.setValor(null);
	}
	
}
