package br.com.academia.service;

import java.util.List;

import br.com.academia.exception.BusinessException;
import br.com.academia.vo.CategoriaVO;

/**
 * Interface de neg�cio da entidade Categoria
 * @author MARCOS
 *
 */
public interface CategoriaService {
	
	public void salvarCategoria(CategoriaVO categoriaVO);
	public void alterarCategoria(CategoriaVO categoriaVO);
	public void excluirCategoria(long id);
	public CategoriaVO consultarCategoriaPorId(long id);
	public List<CategoriaVO> listarTodasCategorias();

}
