package br.com.projeto.aeroporto.regulamentacao.in;


import br.com.projeto.aeroporto.regulamentacao.model.Auditor;

import java.util.List;
import java.util.Optional;

public interface AuditorServicePort {
    Auditor adicionarAuditor(Auditor auditor);
    Optional<Auditor> buscarAuditorPorId(Long id);
    List<Auditor> listarTodosAuditores();
    Auditor atualizarDadosAuditor(Long id, Auditor auditor);
    void removerAuditor(Long id);
}
