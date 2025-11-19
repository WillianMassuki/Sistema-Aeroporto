package br.com.projeto.aeroporto.gestaofinanceira.repository;


import br.com.projeto.aeroporto.gestaofinanceira.model.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DespesaJpaRepository extends JpaRepository<Despesa, Long> {}

