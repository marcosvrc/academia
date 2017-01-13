package br.com.academia.service;

import java.util.List;

import br.com.academia.vo.CategoriaVO;

public interface CategoriaService {
	
	public void salvar(CategoriaVO categoriaVO);
	public List<CategoriaVO> listarTodos();

}
