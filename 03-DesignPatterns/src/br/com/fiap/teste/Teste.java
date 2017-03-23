package br.com.fiap.teste;

import br.com.fiap.config.PropertySingleton;

public class Teste {

	public static void main(String[] args) {
		//Recuperar uma das propriedades configuradas no arquivo
		String user = 
			PropertySingleton.getInstance().getProperty("usuario");
		System.out.println(user);
		
		String banco = 
			PropertySingleton.getInstance().getProperty("url");
		System.out.println(banco);
	}
	
}