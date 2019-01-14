package com.ufersacc.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufersacc.socialbooks.domain.Comentario;

public interface ComentariosRepository extends JpaRepository<Comentario, Long>{

}
