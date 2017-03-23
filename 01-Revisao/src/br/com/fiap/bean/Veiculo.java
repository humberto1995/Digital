package br.com.fiap.bean;

//Não pode ser instanciada
public abstract class Veiculo {

	private int codigo;
	
	private float peso;
	
	private String marca;
	
	public Veiculo() {
		super();
	}

	public Veiculo(int codigo, float peso, String marca) {
		super();
		this.codigo = codigo;
		this.peso = peso;
		this.marca = marca;
	}
	
	public void acelerar(float velocidade){
		System.out.println("Velocidade " + velocidade);
	}
	
	//Pode conter métodos abstratos
	public abstract void parar();

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
}
