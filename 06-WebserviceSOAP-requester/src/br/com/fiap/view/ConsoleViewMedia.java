package br.com.fiap.view;

import org.apache.axis2.AxisFault;

import br.com.fiap.bo.CursoBOStub;
import br.com.fiap.bo.CursoBOStub.CalcularMedia;
import br.com.fiap.bo.CursoBOStub.CalcularMediaResponse;

public class ConsoleViewMedia {

	public static void main(String[] args) {
		//Chamar o webservice para calcular a m�dia
		try {
			CursoBOStub bo = new CursoBOStub();
			
			CalcularMedia valores = new CalcularMedia();
			valores.setAm(5);
			valores.setNac(7);
			valores.setPs(6);
			
			CalcularMediaResponse response = bo.calcularMedia(valores);

			double media = response.get_return();
			
			System.out.println("M�dia �: " + media);
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
