package br.com.academia.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.academia.dao.PedidoDAO;
import br.com.academia.entidade.Pedido;

@Repository
public class PedidoDAOImpl extends AbstractDAO implements PedidoDAO{

	@Override
	public void salvar(Pedido pedido) {
		this.getEntityManager().persist(pedido);
		
	}

}
