package com.example.demo.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.demo.model.Persona;
import com.example.demo.repository.PersonaRepository;
import com.example.demo.service.API.PersonaServiceAPI;
import com.example.demo.utils.GenericServiceImpl;

@Service
public class PersonaServiceImpl extends GenericServiceImpl<Persona, Long> implements PersonaServiceAPI {

	@Autowired
	private PersonaRepository personaRepository;
	
	@Override
	public CrudRepository<Persona, Long> getDao() {
		// TODO Auto-generated method stub
		return personaRepository;
	}

}
