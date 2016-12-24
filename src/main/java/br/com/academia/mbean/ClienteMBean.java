package br.com.academia.mbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.academia.service.ClienteService;
import br.com.academia.vo.ClienteVO;

@Controller("clienteMbean")
@Scope("session")
public class ClienteMBean {

	private ClienteService clienteService;
	private List<ClienteVO> listaClienteVO;

	@Autowired
	public ClienteMBean(ClienteService clienteService){
		this.clienteService = clienteService;
	}
	
	@PostConstruct
	public void init(){
		listaClienteVO = clienteService.listarTodos();
	}
	
	private ClienteVO cliente = new ClienteVO();
	
	public ClienteVO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteVO employee) {
		this.cliente = cliente;
	}

	public String salvar() {
		// Calling Business Service
		clienteService.salvar(cliente);
		// Add message
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("O cliente "+this.cliente.getNome()+" foi gravado com sucesso!"));
		
		listaClienteVO = clienteService.listarTodos();
		return "";
	}
	/**
	 * @return the listaClienteVO
	 */
	public List<ClienteVO> getListaClienteVO() {
		return listaClienteVO;
	}
	
	
}
