package br.com.fiap.teste;

import br.com.fiap.bo.TimeBOStub;
import br.com.fiap.bo.TimeBOStub.Cadastrar;
import br.com.fiap.bo.TimeBOStub.CadastrarResponse;
import br.com.fiap.bo.TimeBOStub.Time;

public class CadastroTeste {

	public static void main(String[] args) {
		try {
			//Instanciar o Stub
			TimeBOStub stub = new TimeBOStub();
			//Instanciar a classe com o mesmo nome do método
			Cadastrar params = new Cadastrar();
			//Instanciar o Time
			Time time = new Time();
			time.setNome("Java");
			time.setTitulos(1);
			time.setTurma("2TDSB");
			//Setar o time na classe "Cadastrar"
			params.setTime(time);
			//chamar o método cadastrar do stub
			stub.cadastrar(params);
			
			//Sucesso!
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
