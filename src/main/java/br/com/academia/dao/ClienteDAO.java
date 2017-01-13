package br.com.academia.dao;

import java.util.List;

import br.com.academia.entidade.Cliente;



public interface ClienteDAO {

	public void salvar(Cliente cliente);
	public List<Cliente> listarTodos();
}
