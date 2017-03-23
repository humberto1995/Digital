package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.bean.Carro;
import br.com.fiap.exceptions.BancoException;

public interface CarroDao {

	//Assinaturas de métodos
	void gravar(Carro carro) throws BancoException;
	void excluir(int codigo);
	void atualizar(Carro carro);
	List<Carro> listar();
	Carro exibir(int codigo);
	
}
