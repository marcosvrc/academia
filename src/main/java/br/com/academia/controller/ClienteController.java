package br.com.academia.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.academia.service.ClienteService;
import br.com.academia.vo.CategoriaVO;
import br.com.academia.vo.ClienteVO;

@ManagedBean(name = "clienteMbean")
@SessionScoped
public class ClienteController extends AbstractController {

	public static String TELA_LISTA_TODOS = "/cliente/listar_todos_clientes.xhtml";
	public static String TELA_CADASTRAR_CLIENTE = "/cliente/cadastrar_cliente.xhtml";

	@Autowired
	private ClienteService clienteService;

	private List<ClienteVO> listaClienteVO;
	private ClienteVO cliente = new ClienteVO();
	private List<ClienteVO> listaFiltrada;

	@PostConstruct
	private void init() {
		super.getConfigSpring();
	}

	public ClienteVO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteVO employee) {
		this.cliente = cliente;
	}
	
	

	public List<ClienteVO> getListaFiltrada() {
		return listaFiltrada;
	}

	public void setListaFiltrada(List<ClienteVO> listaFiltrada) {
		this.listaFiltrada = listaFiltrada;
	}

	public String salvar() {
		// Calling Business Service
		clienteService.salvarCliente(cliente);
		// Add message
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Cliente gravado com sucesso!"));

		this.limparCampos();
		return "";
	}

	public void alterar(RowEditEvent event) {

		ClienteVO clienteVOAlterado = ((ClienteVO) event.getObject());
		clienteService.alterarCliente(clienteVOAlterado);

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Cliente alterado com sucesso!"));

	}

	public void cancelarEdicao(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edi��o Cancelada!", ((ClienteVO) event.getObject()).getNome());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public String excluir(ClienteVO clienteVO) {
		if (clienteVO != null && clienteVO.getId() != 0) {
			this.clienteService.excluirCliente(clienteVO.getId());
		}
		this.listaClienteVO = clienteService.listarTodosClientes();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Cliente excluido com sucesso!"));
		return "";
	}

	/**
	 * @return the listaClienteVO
	 */
	public List<ClienteVO> getListaClienteVO() {
		return listaClienteVO;
	}

	private void limparCampos() {
		this.getCliente().setCpf(null);
		this.getCliente().setDataNascimento(null);
		this.getCliente().setEmail(null);
		this.getCliente().setNome(null);
	}

	public String chamarTelaListarTodosClientes() {
		listaClienteVO = clienteService.listarTodosClientes();
		return TELA_LISTA_TODOS;
	}

	public String chamarTelaCadastro() {
		return TELA_CADASTRAR_CLIENTE;
	}

}
