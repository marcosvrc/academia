package br.com.academia.service;

import java.util.List;

import br.com.academia.entidade.Produto;
import br.com.academia.vo.ProdutoVO;

public interface ProdutoService {

	public void salvar(ProdutoVO produto);
	public void excluir(long id);
	public List<ProdutoVO> listarTodosProdutos();
	public Produto consultarProdutoPorId(long id);
	
}
