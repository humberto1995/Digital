package br.com.fiap.teste;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.repository.ProdutoRepository;
import br.com.fiap.to.ProdutoTO;

public class CadastroTeste {

	public static void main(String[] args) {
		
		//Testar o cadastro através do webservice restfull
		ProdutoRepository rep = new ProdutoRepository();
		
		ProdutoTO produto = new ProdutoTO(0, "Sabonete", 10, 1000);
		
		try {
			rep.cadastrar(produto);
			System.out.println("Sucesso!");
		} catch (WebServiceException e) {
			e.printStackTrace();
			System.err.println("Deu Ruim");
		}
		
	}
	
}
