package br.com.academia.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.academia.dao.ClienteDAO;
import br.com.academia.entidade.Cliente;
import javax.persistence.Query;

@Repository
public class ClienteDAOImpl extends AbstractDAO implements ClienteDAO{
	
	@Override
	public void salvar(Cliente cliente) {
		super.getEntityManager().persist(cliente);
		
	}

	@Override
	public List<Cliente> listarTodos() {
		Query query = super.getEntityManager().createQuery("select c from Cliente c");
		List<Cliente> listaCliente = query.getResultList();
		getEntityManager().close();
		return listaCliente;
	}
	
	

}
