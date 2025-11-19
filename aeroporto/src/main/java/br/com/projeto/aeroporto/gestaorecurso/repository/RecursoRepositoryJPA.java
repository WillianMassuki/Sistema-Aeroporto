package br.com.projeto.aeroporto.gestaorecurso.repository;


import br.com.projeto.aeroporto.gestaorecurso.model.Recurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecursoRepositoryJPA extends JpaRepository<Recurso, String> {}
