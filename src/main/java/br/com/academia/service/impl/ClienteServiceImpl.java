package br.com.academia.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academia.dao.ClienteDAO;
import br.com.academia.service.ClienteService;
import br.com.academia.vo.ClienteVO;
import br.com.academia.vo.converter.Converter;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired(required=true)
	private ClienteDAO dao;
	

	@Transactional
	public void salvar(ClienteVO cliente) {
		dao.salvar(Converter.converterVoParaCliente(cliente));
		
	}

	@Override
	public List<ClienteVO> listarTodos() {
		
		return Converter.converterListaClienteParaListaVo(dao.listarTodos());
	}
}
