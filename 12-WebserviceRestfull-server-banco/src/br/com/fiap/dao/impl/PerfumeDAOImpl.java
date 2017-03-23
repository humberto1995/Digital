package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import br.com.fiap.dao.PerfumeDAO;
import br.com.fiap.entity.Perfume;

public class PerfumeDAOImpl extends GenericDAOImpl<Perfume, Integer> implements PerfumeDAO {

	public PerfumeDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Perfume> listar() {
		return em.createQuery("from Perfume",Perfume.class).getResultList();
	}

}