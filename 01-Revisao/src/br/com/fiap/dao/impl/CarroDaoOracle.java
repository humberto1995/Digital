package br.com.fiap.dao.impl;

import java.util.List;

import br.com.fiap.bean.Carro;
import br.com.fiap.dao.CarroDao;
import br.com.fiap.exceptions.BancoException;

public class CarroDaoOracle implements CarroDao {

	@Override
	public void gravar(Carro carro) throws BancoException{
		//Logica para gravar no banco...
		//Lançar a exceção, no caso de erro
		throw new BancoException("Erro ao persistir");
	}

	@Override
	public void excluir(int codigo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Carro carro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Carro> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Carro exibir(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
