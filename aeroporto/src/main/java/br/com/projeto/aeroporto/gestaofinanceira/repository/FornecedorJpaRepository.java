package br.com.projeto.aeroporto.gestaofinanceira.repository;


import br.com.projeto.aeroporto.gestaofinanceira.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorJpaRepository extends JpaRepository<Fornecedor, Long> {}

