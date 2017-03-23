package br.com.fiap.view;

import javax.swing.JOptionPane;

import org.tempuri.CalcPrecoPrazoWSStub;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazo;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazoResponse;

public class ConsoleViewCorreios {

	public static void main(String[] args) {
		//Calcular o prazo de entrega (WS dos correios)
		//40010 SEDEX - CalcPrazo
		try {
			CalcPrecoPrazoWSStub bo = new CalcPrecoPrazoWSStub();
			
			//Valores para o webservice
			CalcPrazo valores = new CalcPrazo();
			valores.setNCdServico("40010");
			valores.setSCepDestino(JOptionPane.showInputDialog("CEP DESTINO"));
			valores.setSCepOrigem(JOptionPane.showInputDialog("CEP ORIGEM"));
			
			//Chama o webservices dos correios
			CalcPrazoResponse response = bo.calcPrazo(valores);
			
			//Recuperar a resposta
			String prazo = response.getCalcPrazoResult().getServicos()
									.getCServico()[0].getPrazoEntrega();
			
			System.out.println("Prazo de entrega: " + prazo);
			JOptionPane.showMessageDialog(null, "Prazo: " + prazo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}