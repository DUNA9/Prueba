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
		repository2.save (new Cita ("Dia1", "Hora1","Profesional1","Tratamiento1"));
		repository2.save (new Cita ("Dia2", "Hora2","Profesional2","Tratamiento2"));
		repository3.save (new Oferta ("oferta1", "13/02/2017", "13/03/2017"));
		repository3.save (new Oferta ("oferta2", "15/03/2017", "15/04/2017"));
		
	}
	

	@RequestMapping("/")
	public String home(Model model, Pageable page) {
		
		model.addAttribute("usuarios", repository.findAll (page));
		model.addAttribute("opiniones", repository1.findAll (page));
		model.addAttribute("ofertas", repository3.findAll (page));

		return "Home";
	}

	@PostMapping("/usuario/nuevo")
	public String nuevoUsuario(Model model, Usuario usuario) {

		repository.save(usuario);

		return "UsuarioGuardado";

	}

	@RequestMapping("/cita")
	public String Calendario(Model model, Usuario usuario) {

		return "Citas";
		
	}

	@PostMapping("/reserva")
	public String Reserva(Model model, Usuario usuario) {

		return "ReservaGuardada";

	}
	
	@PostMapping("/opinion")
	public String nuevaOpinion(Model model, Opinion opiniones) {

		repository1.save(opiniones);

		return "OpinionGuardada";
	}
	
	@PostMapping("/Citas")
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