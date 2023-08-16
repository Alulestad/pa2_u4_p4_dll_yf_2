package com.example.demo.repo;

import java.util.List;

import com.example.demo.repo.modelo.Propietario;

public interface IPropietarioRepo {

	public void insertar(Propietario propietario);
	public Propietario seleccionarPorId(Integer id);
	public void actualizar(Propietario propietario);
	public void eliminarPorId(Integer id);
	public List<Propietario> seleccionarTodos();
	
}
