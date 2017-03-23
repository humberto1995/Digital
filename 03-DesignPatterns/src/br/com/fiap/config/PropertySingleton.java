package br.com.fiap.config;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertySingleton {

	//Objeto para realizar o log
	private static Logger log = 
			LoggerFactory.getLogger(PropertySingleton.class); 
	
	private static Properties prop;
	
	//Construtor privado, não será possível instanciar
	private PropertySingleton(){}
	
	public static Properties getInstance(){
		if (prop == null){
			log.debug("Carregando o arquivo de propriedades");
			//Instancia o Properties
			prop = new Properties();
			//Carrega as informações do arquivo config.properties
			try{
				prop.load(Properties.
				class.getResourceAsStream("/config.properties"));
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		log.trace("Retornando as propriedades ");
		return prop;
	}
	
}

