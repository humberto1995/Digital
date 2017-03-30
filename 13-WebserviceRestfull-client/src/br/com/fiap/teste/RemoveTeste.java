package br.com.fiap.teste;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.repository.ProdutoRepository;

public class RemoveTeste {

	public static void main(String[] args) {
		ProdutoRepository rep = new ProdutoRepository();
		try {
			rep.remover(1);
			System.out.println("Sucesso!");
		} catch (WebServiceException e) {
			System.err.println("Erro!");
			e.printStackTrace();
		}
	}
	
}
