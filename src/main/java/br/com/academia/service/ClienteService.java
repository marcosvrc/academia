package br.com.academia.service;

import java.util.List;

import br.com.academia.vo.ClienteVO;


public interface ClienteService {
	
	public void salvar(ClienteVO cliente);
	
	public List<ClienteVO> listarTodos();
		

}
