package br.com.projeto.aeroporto.regulamentacao.repository;


import br.com.projeto.aeroporto.regulamentacao.model.Aeronave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AeronaveRepositoryJpa extends JpaRepository<Aeronave, Long> {
}
