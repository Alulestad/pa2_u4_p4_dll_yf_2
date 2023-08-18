package com.example.demo.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repo.modelo.Propietario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class PropietarioRepoImpl implements IPropietarioRepo {

	
	@PersistenceContext
	private EntityManager entityManager;

	
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Propietario propietario) {
		this.entityManager.persist(propietario);
	}


	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Propietario seleccionarPorId(Integer id) {
		return this.entityManager.find(Propietario.class, id);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)//requiried
	public void actualizar(Propietario propietario) {
		this.entityManager.merge(propietario);
	}


	@Override
	@Transactional(value = TxType.MANDATORY)
	public void eliminarPorId(Integer id) {
		Propietario propietario=this.seleccionarPorId(id);
		this.entityManager.remove(propietario);
		
	}


	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Propietario> seleccionarTodos() {
		TypedQuery<Propietario> typedQuery=this.entityManager.createQuery("select p from Propietario p",Propietario.class);
		
		return typedQuery.getResultList();
	}
	
	
	
}
