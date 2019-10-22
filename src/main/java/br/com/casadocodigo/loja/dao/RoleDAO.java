package br.com.casadocodigo.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.casadocodigo.loja.models.Role;

@Repository
@Transactional
public class RoleDAO {

	@PersistenceContext
	private EntityManager manager;

	public void gravar(Role role) {
		manager.persist(role);
	}

	public List<Role> findAll() {
		List<Role> roles = manager.createQuery("select r from Role r", Role.class).getResultList();

		return roles;
	}

	public Role findByName(String role) {
		return manager.createQuery("select r from Role r where nome = :nome", Role.class).setParameter("nome", role)
				.getSingleResult();
	}
}
