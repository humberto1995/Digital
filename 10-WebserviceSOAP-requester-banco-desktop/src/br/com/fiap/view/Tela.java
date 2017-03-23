package br.com.fiap.view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.apache.axis2.AxisFault;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import br.com.fiap.bo.TimeBOStub;
import br.com.fiap.bo.TimeBOStub.Buscar;
import br.com.fiap.bo.TimeBOStub.BuscarResponse;
import br.com.fiap.bo.TimeBOStub.Cadastrar;
import br.com.fiap.bo.TimeBOStub.Time;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Tela {

	protected Shell shell;
	private Text txtNome;
	private Text txtTitulo;
	private Text txtTurma;
	private Text txtCodigo;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Tela window = new Tela();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(610, 382);
		shell.setText("SWT Application");
		
		Label lblNome = new Label(shell, SWT.NONE);
		lblNome.setBounds(48, 41, 55, 15);
		lblNome.setText("Nome");
		
		txtNome = new Text(shell, SWT.BORDER);
		txtNome.setBounds(48, 63, 208, 21);
		
		Label lblTtulos = new Label(shell, SWT.NONE);
		lblTtulos.setBounds(48, 90, 55, 15);
		lblTtulos.setText("T\u00EDtulos");
		
		txtTitulo = new Text(shell, SWT.BORDER);
		txtTitulo.setBounds(48, 111, 208, 21);
		
		Label lblTurma = new Label(shell, SWT.NONE);
		lblTurma.setBounds(48, 138, 55, 15);
		lblTurma.setText("Turma");
		
		txtTurma = new Text(shell, SWT.BORDER);
		txtTurma.setBounds(48, 159, 208, 21);
		
		Button btnCadastrar = new Button(shell, SWT.NONE);
		btnCadastrar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Recuperar as informações da tela
				String nome = txtNome.getText(); //Recupera a informação da tela
				String turma = txtTurma.getText();
				int titulos = Integer.parseInt(txtTitulo.getText());
				//Instanciar um Time
				Time time = new Time();
				time.setNome(nome);
				time.setTitulos(titulos);
				time.setTurma(turma);
				//Instanciar um Stub
				try {
					TimeBOStub stub = new TimeBOStub();
					//Instanciar o "Cadastrar"
					Cadastrar params = new Cadastrar();
					//Setar o time no "Cadastrar"
					params.setTime(time);
					//Chamar o método cadastrar do stub passando o "Cadastrar"
					stub.cadastrar(params);
					//Exibir a mensagem de sucesso
					MessageBox dialog = new MessageBox(shell,SWT.OK);
					dialog.setMessage("Time cadastrado!");
					dialog.open(); //Exibe o dialog
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnCadastrar.setBounds(48, 194, 208, 25);
		btnCadastrar.setText("Cadastrar");
		
		txtCodigo = new Text(shell, SWT.BORDER);
		txtCodigo.setBounds(366, 63, 76, 21);
		
		Label lblCdigo = new Label(shell, SWT.NONE);
		lblCdigo.setBounds(366, 41, 55, 15);
		lblCdigo.setText("C\u00F3digo");
		
		Button btnBuscar = new Button(shell, SWT.NONE);
		btnBuscar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					TimeBOStub stub = new TimeBOStub();
					Buscar params = new Buscar();
					//Código para a pesquisa no webservice
					params.setCodigo(Integer.parseInt(txtCodigo.getText()));
					//Chama o webservice
					BuscarResponse resp = stub.buscar(params);
					//Recupera o valor enviado pelo webservice
					Time time = resp.get_return();
					//Exibe a resposta
					MessageBox dialog = new MessageBox(shell,SWT.OK);
					dialog.setMessage("Nome: " + time.getNome() 
						+ "\nTítulos: " + time.getTitulos() 
						+ "\nTurma: " + time.getTurma());
					dialog.open();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnBuscar.setBounds(455, 61, 75, 25);
		btnBuscar.setText("Buscar");
		
		Label label = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label.setBounds(309, 41, 2, 252);

	}
}
