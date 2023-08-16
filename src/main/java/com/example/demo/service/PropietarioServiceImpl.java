package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.IPropietarioRepo;
import com.example.demo.repo.modelo.Propietario;


@Service
public class PropietarioServiceImpl implements IPropietarioService {

	@Autowired
	private IPropietarioRepo iPropietarioRepo;

	@Override
	public void agregar(Propietario propietario) {
		this.iPropietarioRepo.insertar(propietario);
		
	}

	@Override
	public Propietario buscarPorId(Integer id) {
		return this.iPropietarioRepo.seleccionarPorId(id);
	}

	@Override
	public void actualizar(Propietario propietario) {
		this.iPropietarioRepo.actualizar(propietario);
		
	}

	@Override
	public void borrarPorId(Integer id) {
		this.iPropietarioRepo.eliminarPorId(id);
		
	}

	@Override
	public List<Propietario> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}
	


}
