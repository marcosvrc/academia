package br.com.academia.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.academia.service.CategoriaService;
import br.com.academia.vo.CategoriaVO;

@ManagedBean(name = "categoriaMbean")
@SessionScoped
public class CategoriaController extends AbstractController{

	private static String TELA_CADASTRAR_CATEGORIA = "/categoria/cadastrar_categoria.xhtml";
	private static String TELA_LISTAR_TODOS = "/categoria/listar_todas_categorias.xhtml";
	private static String TELA_ALTERAR_CATEGORIA = "/categoria/alterar_categoria.xhtml";
	
	@Autowired
	private CategoriaService categoriaService;
	private List<CategoriaVO> listaCategoriaVO;
	private List<CategoriaVO> listaCategoriaFiltrada;
	private CategoriaVO categ = new CategoriaVO();

	@PostConstruct
	public void init() {
		super.getConfigSpring();
		listaCategoriaVO = categoriaService.listarTodasCategorias();
	}

	public String salvar() {

		categoriaService.salvarCategoria(categ);
		
		FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,null,"Categoria gravada com sucesso!"));
		limparCampos();
		return "";
	}
	
	public void alterar(RowEditEvent event) {
		
		CategoriaVO categoriaVOAlterada = ((CategoriaVO) event.getObject());
		categoriaService.alterarCategoria(categoriaVOAlterada);
		
		FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,null,"Categoria alterada com sucesso!"));
		
		
	}
	
	public void cancelarEdicao(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edição Cancelada!", ((CategoriaVO) event.getObject()).getDescricao());
        FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public String excluir(CategoriaVO categoriaVO){
		if(categoriaVO != null && categoriaVO.getId() != 0){
				this.categoriaService.excluirCategoria(categoriaVO.getId());
				this.listaCategoriaVO = categoriaService.listarTodasCategorias();
				FacesContext.getCurrentInstance().addMessage(null, 
						new FacesMessage(FacesMessage.SEVERITY_INFO,null,"Categoria excluida com sucesso!"));
					
		}
		return "";
	}
	
	public String chamarTelaAlterar(CategoriaVO categVO){
		this.categ = categVO;
		return TELA_ALTERAR_CATEGORIA;	
	}
	
	public String chamarTelaListarTodasCategorias(){
		listaCategoriaVO = categoriaService.listarTodasCategorias();
		return TELA_LISTAR_TODOS;
	}
	
	private void limparCampos(){
		this.categ.setDescricao(null);
		this.categ.setId(0);
	}
	
	/** MÉTODOS GET E SET**/
	public String chamarTelaCadastro(){
		return TELA_CADASTRAR_CATEGORIA;
	}

	public CategoriaVO getCateg() {
		return categ;
	}

	public void setCateg(CategoriaVO categ) {
		this.categ = categ;
	}
	
	public List<CategoriaVO> getListaCategoriaVO() {
		return listaCategoriaVO;
	}

	public void setListaCategoriaVO(List<CategoriaVO> listaCategoriaVO) {
		this.listaCategoriaVO = listaCategoriaVO;
	}

	public List<CategoriaVO> getListaCategoriaFiltrada() {
		return listaCategoriaFiltrada;
	}

	public void setListaCategoriaFiltrada(List<CategoriaVO> listaCategoriaFiltrada) {
		this.listaCategoriaFiltrada = listaCategoriaFiltrada;
	}
	
}
