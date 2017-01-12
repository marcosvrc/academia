package br.com.academia.vo.converter;

import java.util.ArrayList;
import java.util.List;

import br.com.academia.entidade.Cliente;
import br.com.academia.entidade.Produto;
import br.com.academia.vo.ClienteVO;
import br.com.academia.vo.ProdutoVO;


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
		
		clienteVo.setId(cliente.getId());
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
	
	public static Produto converterVoParaProduto(ProdutoVO produtoVO){
		Produto produto = new Produto();
		produto.setId(produtoVO.getId());
		produto.setDescricao(produtoVO.getDescricao());
		produto.setValor(produtoVO.getValor());
		return produto;
	}
	
	public static ProdutoVO converterProdutoParaVO(Produto produto){
		ProdutoVO produtoVO = new ProdutoVO();
		
		produtoVO.setId(produto.getId());
		produtoVO.setDescricao(produto.getDescricao());
		produtoVO.setValor(produto.getValor());
		return produtoVO;
	}
	
	public static List<ProdutoVO> converterListaProdutoParaListaVo(List<Produto> listaEntidade){
		
		List<ProdutoVO> listProdutoVO = new ArrayList<ProdutoVO>();
		if(listaEntidade != null && !listaEntidade.isEmpty()){
			for(Produto produto : listaEntidade){
				ProdutoVO produtoVO = converterProdutoParaVO(produto);
				listProdutoVO.add(produtoVO);
			}
		}
		return listProdutoVO;
	}
	
	
}
