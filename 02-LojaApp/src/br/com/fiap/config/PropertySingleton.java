package br.com.fiap.config;

import java.io.IOException;
import java.util.Properties;

public class PropertySingleton {

	private static Properties prop;
	
	//Construtor privado, n�o ser� poss�vel instanciar
	private PropertySingleton(){}
	
	public static Properties getInstance(){
		if (prop == null){
			//Instancia o Properties
			prop = new Properties();
			//Carrega as informa��es do arquivo config.properties
			try{
				prop.load(Properties.
				class.getResourceAsStream("/loja.properties"));
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		return prop;
	}
	
}

