package br.com.academia.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academia.dao.ProdutoDAO;
import br.com.academia.entidade.Produto;
import br.com.academia.service.ProdutoService;
import br.com.academia.vo.ProdutoVO;
import br.com.academia.vo.converter.Converter;

@Service
public class ProdutoServiceImpl implements ProdutoService{

	@Autowired(required=true)
	private ProdutoDAO dao;

	@Override
	@Transactional
	public void salvar(ProdutoVO produtoVO) {
		dao.salvar(Converter.converterVoParaProduto(produtoVO));
		
	}

	@Override
	public void excluir(long id) {
		dao.excluir(id);
		
	}

	@Override
	public List<ProdutoVO> listarTodosProdutos() {
		return Converter.converterListaProdutoParaListaVo(
				dao.consultarTodos());
	}

	@Override
	public Produto consultarProdutoPorId(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
}
