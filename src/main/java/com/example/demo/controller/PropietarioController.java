
package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repo.modelo.Propietario;
import com.example.demo.service.IPropietarioService;

@Controller
@RequestMapping("/propietarios")
public class PropietarioController {
	
	

	@Autowired
	private IPropietarioService iPropietarioService;
	
	@GetMapping("/buscar")
	public String buscarTodos(Model model) {
		
		List<Propietario> lista=this.iPropietarioService.buscarTodos();
		
		model.addAttribute("propietarios",lista);
		
		return "vistaListaPropietarios";
	}
	
	
	@GetMapping("/buscarPorID/{idPropietario}")
	public String buscarPorId(@PathVariable("idPropietario") Integer id, Model model) {
		Propietario prop=this.iPropietarioService.buscarPorId(id);
		model.addAttribute("propietario",prop);
		return "vistaPropietario";
	}
	
	
	@PutMapping("/actualizar/{idPropietario}")
	public String actualizarPropietario(@PathVariable("idPropietario") Integer id,Propietario propietario) {
		this.iPropietarioService.actualizar(propietario);
		
		return "redirect:/propietarios/buscar";
	}
	
	@DeleteMapping("/borrar/{idPropietario}")
	public String eliminarPorID(@PathVariable("idPropietario") Integer id) {
		this.iPropietarioService.borrarPorId(id);
		return "redirect:/propietarios/buscar";
		
		
	}
	//Metodo de pagina de redireccionamiento
	@GetMapping("/nuevo")
	public String paginaNuevoPropietario(Propietario propietario){
		return "registrarPropietario";
	}
	@PostMapping("/insertar")
	public String insertarPropietario(Propietario propietario) {
		this.iPropietarioService.agregar(propietario);
		return "redirect:/propietarios/buscar";
	}
	
}
