package com.fiap.loja;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fiap.bo.EstoqueBO;
import com.fiap.to.ProdutoTO;

import br.com.fiap.config.PropertySingleton;

public class TerminalConsulta {
	
	private static Logger log = 
			LoggerFactory.getLogger(TerminalConsulta.class);

	public static void main(String[] args) {
		
		log.info("In�cio da aplica��o");
		
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat formatador = 
				new SimpleDateFormat("dd/MM/yyyy");
		Calendar hoje = Calendar.getInstance();
		
		String nomeLoja = PropertySingleton.getInstance().getProperty("nome");
		
		System.out.println(nomeLoja + "          " + 
				formatador.format(hoje.getTime()));
		
		System.out.println("******************************");
		System.out.print("C�digo Produto: ");
		try{
			int codigo = sc.nextInt();
		
			EstoqueBO bo = new EstoqueBO();
			ProdutoTO produto = bo.consultarProduto(codigo);
			
			if (produto != null){
				log.debug("Produto encontrado: " + codigo);
				System.out.println(produto.getDescricao());
				System.out.println("Quantidade: " 
							+ produto.getQuantidade());
				DecimalFormat format = new DecimalFormat("R$ #,###.00");
				System.out.println("Pre�o: " 
							+ format.format(produto.getPreco()));
			}else{
				log.debug("Produto n�o encontrado: " + codigo	);
				System.out.println("Produto n�o cadastrado!");
			}
		}catch(Exception e){
			log.error("Valor digitado inv�lido");
		}
		
		sc.close();
	}
	
}


