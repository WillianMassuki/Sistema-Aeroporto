package br.com.projeto.aeroporto.gestaorecurso.repository;


import br.com.projeto.aeroporto.gestaorecurso.model.Pista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PistaRepositoryJpa extends JpaRepository<Pista, Long> {
}
