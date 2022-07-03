package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Persona;
import com.example.demo.service.API.PersonaServiceAPI;

@RestController
@RequestMapping("/api/persona/")
@CrossOrigin("*")
public class PersonaController {

	@Autowired
	private PersonaServiceAPI personaServiceAPI;
	
	
	@GetMapping(value = "all")
	public List<Persona> getAll()
	{
		return personaServiceAPI.getAll();
	}
	
	@GetMapping(value = "find/{id}")
	public Persona findPersona(@PathVariable Long id)
	{
		return personaServiceAPI.get(id);
	}
	
	@PostMapping(value = "save")
	public ResponseEntity<Persona> save(@RequestBody Persona persona)
	{
		Persona temporalPersona = personaServiceAPI.save(persona);
		return new ResponseEntity<Persona>(temporalPersona, HttpStatus.OK);
	}
	
	@GetMapping(value = "delete/{id}")
	public ResponseEntity<Persona> delete(@PathVariable Long id)
	{
		Persona temporalPersona = personaServiceAPI.get(id);
		if(temporalPersona != null)
		{
			personaServiceAPI.delete(id);
			return new ResponseEntity<Persona>(temporalPersona, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Persona>(HttpStatus.NO_CONTENT);
		}
	}
	
}
