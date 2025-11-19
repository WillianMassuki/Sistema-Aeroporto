package br.com.projeto.aeroporto.regulamentacao.repository;


import br.com.projeto.aeroporto.regulamentacao.model.Auditor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditorRepositoryJpa extends JpaRepository<Auditor, Long> {
}
