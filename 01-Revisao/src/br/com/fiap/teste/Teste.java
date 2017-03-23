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
		//Declarar uma vari�vel para armazenar uma data
		Calendar inicioAula;
		//armazenar uma data na vari�vel
		inicioAula = Calendar.getInstance(); //Data atual
		
		//Declarar uma vari�vel para data
		Calendar terminoAula = 
							//ano, mes (come�a no 0), dia
			new GregorianCalendar(2017,Calendar.JUNE,30);
		
		//Formatar a data
		SimpleDateFormat formatador = 
				new SimpleDateFormat("dd/MM/yyyy");
		
		//Exibir as datas...
		System.out.println("Come�o: " + 
				formatador.format(inicioAula.getTime()));
		System.out.println("T�rmino: " + 
				formatador.format(terminoAula.getTime()));
		
		//Instanciar um carro
		Carro carro = new Carro(1,1000,
				"Hyundai",Combustivel.FLEX);
		
		//Comparar o combustivel
		if (carro.getCombustivel() == Combustivel.FLEX){
			System.out.println("Carro flex!");
		}else{
			System.out.println("Carro n�o � flex");
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




