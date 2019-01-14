package com.ufersacc.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufersacc.socialbooks.domain.Autor;

public interface AutoresRepository extends JpaRepository<Autor, Long>{

}
