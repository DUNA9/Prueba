package com.Peluqueria;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@Autowired 
	private UsuariosRepository repository;
	
	@Autowired 
	private OpinionesRepository repository1;
	
	@Autowired 
	private CitasRepository repository2;
	
	@Autowired 
	private OfertasRepository repository3;
	
	@PostConstruct
	public void init () {
		repository.save (new Usuario ("Nombre1", "Email1", "Telefono1"));
		repository.save (new Usuario ("Nombre2", "Email2", "Telefono2"));
		repository1.save (new Opinion ("Nombre1", "Esto es una primera opinión"));
		repository1.save (new Opinion ("Nombre2", "Esto es una segunda opinión"));
		repository2.save (new Cita ("Dia1", "Hora1","Profesional1","Tratamient	@PostMapping("/Citas")
	public String nuevaCita(Model model, Cita citas) {

		repository2.save(citas);

		return "ReservaGuardada";
	}
	
	@RequestMapping("/admin")
	public String insertarOfertas(Model model, Oferta ofertas) {

		repository3.save(ofertas);

		return "OperacionCorrecta";
	}
}