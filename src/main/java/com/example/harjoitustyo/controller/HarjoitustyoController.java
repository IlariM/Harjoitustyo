package com.example.harjoitustyo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.harjoitustyo.domain.Elokuva;

@Controller
public class HarjoitustyoController {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@RequestMapping(value="/login")
	public String login(){
		return "login";
	}
	
	@RequestMapping("/etusivu")
	public String etusivu() {
		return "etusivu";
	}
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/lisaaelokuva")
	public String lisaaElokuva(Model model) {
		model.addAttribute("elokuva", new Elokuva());
		return "lisaaelokuva";
	}
	
	@RequestMapping(value="/save", method= RequestMethod.POST)
	public String save(Elokuva elokuva) {
		String nimi = elokuva.getNimi();
		String ohjaaja = elokuva.getOhjaaja();
		long arvio = elokuva.getArvio();
		String kommentti = elokuva.getKommentti();
		jdbcTemplate.update("INSERT INTO elokuva(nimi, ohjaaja, arvio, kommentti) VALUES (?,?,?,?)", nimi, ohjaaja, arvio, kommentti);
		return "redirect:omatelokuvat";
	}
	
	@RequestMapping("/omatelokuvat")
	public String listaaElokuva(Model model) {
		
		List<Map<String, Object>> elokuvat = jdbcTemplate.queryForList("SELECT * FROM elokuva");
		model.addAttribute("elokuvat", elokuvat);
		return "omatelokuvat";
	}
	
	@RequestMapping(value="/poista/{id}")
	public String poistaElokuva(@PathVariable("id") Long ElokuvaId, Model model) {
		jdbcTemplate.update("DELETE FROM elokuva WHERE id = ?", ElokuvaId);
		return "redirect:../omatelokuvat";
	}
	
	@RequestMapping(value="/elokuvat", method=RequestMethod.GET)
	public @ResponseBody List<Map<String, Object>> ElokuvatRest(){
		return (List<Map<String, Object>>)jdbcTemplate.queryForList("SELECT * FROM elokuva");
	}
}
