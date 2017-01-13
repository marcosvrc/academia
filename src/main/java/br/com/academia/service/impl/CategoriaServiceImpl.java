package br.com.academia.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academia.dao.CategoriaDAO;
import br.com.academia.service.CategoriaService;
import br.com.academia.vo.CategoriaVO;
import br.com.academia.vo.converter.Converter;

@Service
public class CategoriaServiceImpl implements CategoriaService{

	@Autowired(required=true)
	private CategoriaDAO dao;
	
	@Override
	@Transactional
	public void salvar(CategoriaVO categoriaVO) {
		dao.salvar(Converter.converterVoParaEntidade(categoriaVO));
		
	}

	@Override
	public List<CategoriaVO> listarTodos() {
		return Converter.converterListaCategoriaParaListaVo(dao.listarTodos());
	}

}
