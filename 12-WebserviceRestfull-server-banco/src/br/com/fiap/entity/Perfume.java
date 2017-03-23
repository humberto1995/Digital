package br.com.fiap.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_PERFUME")
@SequenceGenerator(name="seqPerfume",sequenceName="SQ_TB_PERFUME",allocationSize=1)
public class Perfume {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqPerfume")
	private int codigo;
	
	private String nome;
	
	private String aroma;
	
	private float ml;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAroma() {
		return aroma;
	}

	public void setAroma(String aroma) {
		this.aroma = aroma;
	}

	public float getMl() {
		return ml;
	}

	public void setMl(float ml) {
		this.ml = ml;
	}
	
}
