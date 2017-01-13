package br.com.academia.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.academia.dao.ProdutoDAO;
import br.com.academia.entidade.Produto;

@Repository
public class ProdutoDAOImpl extends AbstractDAO implements ProdutoDAO{

	@Override
	public void salvar(Produto produto) {
		super.getEntityManager().persist(produto);
		
	}

	@Override
	public void excluir(long id) {
		Produto produto = this.consultarPorId(id);
		this.getEntityManager().remove(produto);
		
	}

	@Override
	public void alterar(Produto produto) {
		this.getEntityManager().merge(produto);
		
	}

	@Override
	public Produto consultarPorId(long id) {
		return super.getEntityManager().find(Produto.class, id);
	}

	@Override
	public List<Produto> consultarTodos() {
		Query query = super.getEntityManager().createQuery("select c from Produto c");
		List<Produto> listarProduto = query.getResultList();
		getEntityManager().close();
		return listarProduto;
	}

}
