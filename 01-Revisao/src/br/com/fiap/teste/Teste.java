package br.com.fiap.teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.fiap.bean.Carro;
import br.com.fiap.bean.Combustivel;
import br.com.fiap.dao.CarroDao;
import br.com.fiap.dao.impl.CarroDaoOracle;
import br.com.fiap.exceptions.BancoException;

public class Teste {

	public static void main(String[] args) {
		//Data -> Calendar
		//Declarar uma variável para armazenar uma data
		Calendar inicioAula;
		//armazenar uma data na variável
		inicioAula = Calendar.getInstance(); //Data atual
		
		//Declarar uma variável para data
		Calendar terminoAula = 
							//ano, mes (começa no 0), dia
			new GregorianCalendar(2017,Calendar.JUNE,30);
		
		//Formatar a data
		SimpleDateFormat formatador = 
				new SimpleDateFormat("dd/MM/yyyy");
		
		//Exibir as datas...
		System.out.println("Começo: " + 
				formatador.format(inicioAula.getTime()));
		System.out.println("Término: " + 
				formatador.format(terminoAula.getTime()));
		
		//Instanciar um carro
		Carro carro = new Carro(1,1000,
				"Hyundai",Combustivel.FLEX);
		
		//Comparar o combustivel
		if (carro.getCombustivel() == Combustivel.FLEX){
			System.out.println("Carro flex!");
		}else{
			System.out.println("Carro não é flex");
		}
		
		//Cadastrar o carro
		CarroDao dao = new CarroDaoOracle();		
		try {
			//tenta gravar
			dao.gravar(carro);
		} catch (BancoException e) {
			//executa em caso de erro
			e.printStackTrace();
			//Exibe a mensagem da exception
			System.err.println(e.getMessage());
		}
		
	}
	
}




