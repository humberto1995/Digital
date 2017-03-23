package com.fiap.view;

import javax.swing.JOptionPane;

import com.fiap.bo.EstoqueBOStub;
import com.fiap.bo.EstoqueBOStub.ConsultarProduto;
import com.fiap.bo.EstoqueBOStub.ConsultarProdutoResponse;
import com.fiap.bo.EstoqueBOStub.ProdutoTO;

public class TerminalBuscaPreco {

	public static void main(String[] args) {
		
		try {
			EstoqueBOStub bo = new EstoqueBOStub();
			
			//1 - Pesquisar por código
			//2 - Listar todos produtos
			
			
			ConsultarProduto valores = new ConsultarProduto();
			int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código"));
			valores.setCodigo(codigo);
			
			ConsultarProdutoResponse response =	bo.consultarProduto(valores);
			
			ProdutoTO produto = response.get_return();
			
			JOptionPane.showMessageDialog(null, "Descrição: " +
					produto.getDescricao() + "\nPreço: " +
					produto.getPreco() + "\nQuantidade: " +
					produto.getQuantidade());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
