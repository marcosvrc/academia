package br.com.academia.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.academia.dao.CategoriaDAO;
import br.com.academia.entidade.Categoria;

@Repository
public class CategoriaDAOImpl extends AbstractDAO implements CategoriaDAO{

	@Override
	public void salvar(Categoria categoria) {
		super.getEntityManager().persist(categoria);
		
	}

	@Override
	public List<Categoria> listarTodos() {
		Query query = super.getEntityManager().createQuery("select cat from Categoria cat");
		List<Categoria> listaCategoria = query.getResultList();
		getEntityManager().close();
		return listaCategoria;
	}

}
