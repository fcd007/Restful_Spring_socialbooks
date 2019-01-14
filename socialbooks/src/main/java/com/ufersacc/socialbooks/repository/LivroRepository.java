package com.ufersacc.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufersacc.socialbooks.domain.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

}
