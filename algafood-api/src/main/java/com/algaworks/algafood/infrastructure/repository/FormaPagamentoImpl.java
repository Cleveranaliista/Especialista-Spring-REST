package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;

@Component
public class FormaPagamentoImpl implements FormaPagamentoRepository {

	@PersistenceContext
	private EntityManager manager;

	public List<FormaPagamento> todos() {
		return manager.createQuery("from FormaPagamento", FormaPagamento.class).getResultList();
	}

	public FormaPagamento porId(Long id) {
		return manager.find(FormaPagamento.class, id);
	}

	@Transactional
	public FormaPagamento adicionar(FormaPagamento formaPagamento) {
		return manager.merge(formaPagamento);
	}

	@Transactional
	public void remover(FormaPagamento formaPagamento) {
		formaPagamento = porId(formaPagamento.getId());
		manager.remove(formaPagamento);
	}

}