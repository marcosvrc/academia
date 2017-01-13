package br.com.academia.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.academia.service.CategoriaService;
import br.com.academia.service.ClienteService;
import br.com.academia.vo.CategoriaVO;
import br.com.academia.vo.ClienteVO;

@Controller("categoriaMbean")
@Scope("session")
public class CategoriaController {

	private CategoriaService categoriaService;
	private List<CategoriaVO> listaCategoriaVO;

	@Autowired
	public CategoriaController(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}

	@PostConstruct
	public void init() {
		listaCategoriaVO = categoriaService.listarTodos();
	}

	private CategoriaVO categ = new CategoriaVO();

	public CategoriaVO getCateg() {
		return categ;
	}

	public void setCateg(CategoriaVO categ) {
		this.categ = categ;
	}

	public String salvar() {

		categoriaService.salvar(categ);

		return "";
	}

}
