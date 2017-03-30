package br.com.fiap.teste;

import java.util.List;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.repository.ProdutoRepository;
import br.com.fiap.to.ProdutoTO;

public class ListaTeste {

	public static void main(String[] args) {
		//Listar todos os produtos
		
		ProdutoRepository rep = new ProdutoRepository();
		
		try {
			List<ProdutoTO> listar = rep.listar();
			for (ProdutoTO produtoTO : listar) {
				System.out.println(produtoTO.getNome() + " R$" + produtoTO.getPreco() + " - " + produtoTO.getQuantidade() );
			}	
		} catch (WebServiceException e) {
			System.err.println("Deu ruim");
			e.printStackTrace();
		}
	}
}


