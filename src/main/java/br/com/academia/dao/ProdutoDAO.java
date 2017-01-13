package br.com.academia.dao;

import java.util.List;

import br.com.academia.entidade.Produto;

public interface ProdutoDAO {
	
	public void salvar(Produto produto);
	public void excluir(long id);
	public void alterar(Produto produto);
	public Produto consultarPorId(long id);
	public List<Produto> consultarTodos();

}
