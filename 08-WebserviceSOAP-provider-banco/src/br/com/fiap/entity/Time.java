package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_TIME")
@SequenceGenerator(name="seqTime",sequenceName="SQ_TB_TIME",allocationSize=1)
public class Time {

	@Id
	@Column(name="CD_TIME")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqTime")
	private int codigo;
	
	@Column(name="NM_TIME",nullable=false)
	private String nome;
	
	@Column(name="DS_TURMA")
	private String turma;
	
	@Column(name="NR_TITULO")
	private int titulos;
	
	public Time() {
		super();
	}

	public Time(int codigo, String nome, String turma, int titulos) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.turma = turma;
		this.titulos = titulos;
	}

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

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public int getTitulos() {
		return titulos;
	}

	public void setTitulos(int titulos) {
		this.titulos = titulos;
	}
	
}
