package com.ufersacc.socialbooks.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufersacc.socialbooks.domain.Autor;
import com.ufersacc.socialbooks.repository.AutoresRepository;
import com.ufersacc.socialbooks.services.exceptions.AutorExistenteException;
import com.ufersacc.socialbooks.services.exceptions.AutorNaoEncontradoException;

@Service
public class AutoresService {
	
	@Autowired
	private AutoresRepository autoresRepository;
	
	public List<Autor> listar(){
		return autoresRepository.findAll();
	}

	public Autor salvar(Autor autor) {
		if(autor.getId() != null) {
			Autor a = autoresRepository.findOne(autor.getId());
			
			if(a != null) {
				throw new AutorExistenteException("Autor já existe");
			}
		}
		return autoresRepository.save(autor);
	}
	
	public Autor buscar(Long id) {
		Autor autor = autoresRepository.findOne(id);
		
		if(autor == null) {
			throw new AutorNaoEncontradoException("Autor não encontrado");
		}
		
		return autor;
	}

	
}
