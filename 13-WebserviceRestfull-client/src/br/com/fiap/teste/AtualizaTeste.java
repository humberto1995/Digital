package br.com.fiap.teste;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.repository.ProdutoRepository;
import br.com.fiap.to.ProdutoTO;

public class AtualizaTeste {

	public static void main(String[] args) {
		
		ProdutoRepository rep = new ProdutoRepository();
		
		ProdutoTO produto = new ProdutoTO(2, "Cavaquinho", 250, 1000);
		
		try {
			rep.atualizar(produto);
			System.out.println("Sucesso!");
		} catch (WebServiceException e) {
			System.err.println("Deu ruim");
			e.printStackTrace();
		}
		
	}
	
}
