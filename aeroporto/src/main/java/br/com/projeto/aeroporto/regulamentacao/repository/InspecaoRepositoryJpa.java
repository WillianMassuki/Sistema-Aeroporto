package br.com.projeto.aeroporto.regulamentacao.repository;


import br.com.projeto.aeroporto.regulamentacao.model.Inspecao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InspecaoRepositoryJpa extends JpaRepository<Inspecao, Long> {
}
