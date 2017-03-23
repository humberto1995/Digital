package br.com.fiap.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.com.fiap.to.ProdutoTO;

public class ProdutoBO {

	private static HashMap<Integer, ProdutoTO> banco = new HashMap<>();
	private static int sequence = 3;
	
	static{
		banco.put(1, new ProdutoTO(1, "Celular", 100, 5));
		banco.put(2, new ProdutoTO(2, "Telefone", 1000, 5));
		banco.put(3, new ProdutoTO(3, "Tablet", 200, 5));
	}
	
	public void cadastrar(ProdutoTO produto){
		produto.setCodigo(++sequence);
		banco.put(sequence, produto);
	}
	
	public List<ProdutoTO> listar(){
		return new ArrayList<ProdutoTO>(banco.values());
	}
	
	public void atualizar(ProdutoTO produto){
		banco.put(produto.getCodigo(), produto);
	}
	
	public void remover(int codigo){
		banco.remove(codigo);
	}
	
	public ProdutoTO buscar(int codigo){
		return banco.get(codigo);
	}
	
}
