package br.com.academia.dao;

import java.util.List;

import br.com.academia.entidade.Categoria;

public interface CategoriaDAO {
	
	public void salvar(Categoria categoria);
	public List<Categoria> listarTodos();

}
