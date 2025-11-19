package br.com.projeto.aeroporto.regulamentacao.repository;


import br.com.projeto.aeroporto.regulamentacao.model.CompanhiaAerea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanhiaAereaRepositoryJpa extends JpaRepository<CompanhiaAerea, Long> {
}
