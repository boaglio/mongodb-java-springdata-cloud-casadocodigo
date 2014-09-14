package com.boaglio.casadocodigo.mongodb.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.boaglio.casadocodigo.mongodb.model.Seriado;
import com.boaglio.casadocodigo.mongodb.repository.SeriadosRepository;

@Controller
public class SeriadosController {

	@Autowired
	private SeriadosRepository repository;

	@RequestMapping(value = "/home",method = RequestMethod.GET)
	public String index(ModelMap model) {

		List<Seriado> seriados = repository.findAll();
		model.addAttribute("seriados",seriados);
		return "home";

	}

	@RequestMapping(value = "/detalhe",method = RequestMethod.GET)
	public String detalhe(@RequestParam("id") String id,ModelMap model) {

		Seriado seriado = repository.findById(id);
		model.addAttribute("seriado",seriado);
		int totalDePersonagens = 0;
		if (seriado.getPersonagens() != null) {
			totalDePersonagens = seriado.getPersonagens().size();
		}
		model.addAttribute("totalDePersonagens",totalDePersonagens);
		return "detalhe";

	}

	@RequestMapping(value = "/alterar",method = RequestMethod.GET)
	public String alterar(@ModelAttribute Seriado seriado,ModelMap model,HttpServletRequest request) {

		List<String> personagens = new ArrayList<String>();
		personagens.add(request.getParameter("personagem1"));
		personagens.add(request.getParameter("personagem2"));
		personagens.add(request.getParameter("personagem3"));
		personagens.add(request.getParameter("personagem4"));
		personagens.add(request.getParameter("personagem5"));
		personagens.add(request.getParameter("personagem6"));
		seriado.setPersonagens(personagens);

		repository.update(seriado);
		model.addAttribute("msg","update");

		return "detalhe";

	}

	@RequestMapping(value = "/remover",method = RequestMethod.GET)
	public String remover(@RequestParam("id") String id,ModelMap model) {

		repository.remove(id);
		model.addAttribute("msg","delete");

		return "detalhe";

	}

	@RequestMapping(value = "/novo",method = RequestMethod.GET)
	public String novo() {
		return "novo";
	}

	@RequestMapping(value = "/adicionar",method = RequestMethod.POST)
	public String adicionar(@ModelAttribute Seriado seriado,ModelMap model,HttpServletRequest request) {

		List<String> personagens = new ArrayList<String>();
		personagens.add(request.getParameter("personagem1"));
		personagens.add(request.getParameter("personagem2"));
		personagens.add(request.getParameter("personagem3"));
		personagens.add(request.getParameter("personagem4"));
		personagens.add(request.getParameter("personagem5"));
		personagens.add(request.getParameter("personagem6"));
		seriado.setPersonagens(personagens);

		repository.insert(seriado);
		model.addAttribute("msg","add");

		return "novo";

	}

}
