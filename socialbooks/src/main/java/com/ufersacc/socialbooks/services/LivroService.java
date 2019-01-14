package com.ufersacc.socialbooks.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ufersacc.socialbooks.domain.Comentario;
import com.ufersacc.socialbooks.domain.Livro;
import com.ufersacc.socialbooks.repository.ComentariosRepository;
import com.ufersacc.socialbooks.repository.LivroRepository;
import com.ufersacc.socialbooks.services.exceptions.LivroNaoEncontradoException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private ComentariosRepository comentarioRepository;
	
	public List<Livro> listar(){
		return livroRepository.findAll();
	}
	
	public Livro buscar(Long id) {
		Livro livro = livroRepository.findOne(id);
		
		if (livro == null) {
			throw new LivroNaoEncontradoException("O livro não pôde ser encontrado!");
		}
		
		return livro;
	}
	
	public Livro salvar(Livro livro) {
		livro.setId(null);
		return livro = livroRepository.save(livro);
	}
	
	public void deletar(Long id) {
		
		try {
			livroRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new LivroNaoEncontradoException("Livro não encontrado");
		}
	}
	
	public void atualizar(Livro livro) {
		verificarExistencia(livro);
		livroRepository.save(livro);
	}
	
	private void verificarExistencia(Livro livro) {
		buscar(livro.getId());
	}
	
	public Comentario salvarComentario(Long livroId, Comentario comentario) {
		Livro livro = buscar(livroId);
		
		comentario.setLivro(livro);
		comentario.setData(new Date());
		
		return comentarioRepository.save(comentario);
	}
	
	public List<Comentario> listarComenarios(Long id){
		
		Livro livro = buscar(id);
		return livro.getComentarios();
	}
}
