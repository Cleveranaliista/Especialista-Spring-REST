package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.model.Estado;

@Component
public class EstadoRepositoryImpl {

	@PersistenceContext
	private EntityManager manager;
	
	public List<Estado> todos(){
		return manager.createQuery("from Estado", Estado.class)
				.getResultList();
	}
	
	public Estado porId(Long id) {
		return manager.find(Estado.class, id);
	}

	@Transactional
	public Estado adicionar(Estado estado) {
		return manager.merge(estado);
	}

	@Transactional
	public void remover(Estado estado) {
		estado = porId(estado.getId());
		manager.remove(estado);

	}
}