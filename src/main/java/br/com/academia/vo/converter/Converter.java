package br.com.academia.vo.converter;

import java.util.ArrayList;
import java.util.List;

import br.com.academia.entidade.Cliente;
import br.com.academia.vo.ClienteVO;


public class Converter {

	public static Cliente converterVoParaCliente(ClienteVO clienteVO){
		Cliente cliente = new Cliente();
		
		cliente.setNome(clienteVO.getNome());
		cliente.setDataNascimento(clienteVO.getDataNascimento());
		cliente.setEmail(clienteVO.getEmail());
		cliente.setCpf(clienteVO.getCpf());
		return cliente;
	}
	
	public static ClienteVO converterClienteParaVO(Cliente cliente){
		ClienteVO clienteVo = new ClienteVO();
		
		clienteVo.setNome(cliente.getNome());
		clienteVo.setDataNascimento(cliente.getDataNascimento());
		clienteVo.setEmail(cliente.getEmail());
		clienteVo.setCpf(cliente.getCpf());
		return clienteVo;
	}
	
	public static List<ClienteVO> converterListaClienteParaListaVo(List<Cliente> listaEntidade){
		
		List<ClienteVO> listClienteVO = new ArrayList<ClienteVO>();
		if(listaEntidade != null && !listaEntidade.isEmpty()){
			for(Cliente cliente : listaEntidade){
				ClienteVO clienteVO = converterClienteParaVO(cliente);
				listClienteVO.add(clienteVO);
			}
		}
		return listClienteVO;
	}
	
	
	
}
