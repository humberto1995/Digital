package br.com.fiap.teste;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.repository.ProdutoRepository;
import br.com.fiap.to.ProdutoTO;

public class BuscarTeste {

	public static void main(String[] args) {
		
		ProdutoRepository rep = new ProdutoRepository();
		
		try {
			ProdutoTO produto = rep.buscar(2);
			System.out.println(produto.getNome() + " R$" + produto.getPreco() + " - " + produto.getQuantidade());			
		} catch (WebServiceException e) {
			e.printStackTrace();
		}
	}
}
