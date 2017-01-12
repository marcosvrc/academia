package br.com.academia.dao.impl;

import br.com.academia.dao.PedidoDAO;
import br.com.academia.entidade.Pedido;

public class PedidoDAOImpl extends AbstractDAO implements PedidoDAO{

	@Override
	public void salvar(Pedido pedido) {
		this.getEntityManager().persist(pedido);
		
	}

}
