package br.com.projeto.aeroporto.regulamentacao.repository;


import br.com.projeto.aeroporto.regulamentacao.model.Norma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NormaRepositoryJpa extends JpaRepository<Norma, Long> {
}
