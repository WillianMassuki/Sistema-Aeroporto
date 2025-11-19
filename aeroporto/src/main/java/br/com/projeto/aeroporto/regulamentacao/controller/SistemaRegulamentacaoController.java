package br.com.projeto.aeroporto.regulamentacao.controller;


import br.com.projeto.aeroporto.regulamentacao.model.Inspecao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sistemaregulamentar")
public class SistemaRegulamentacaoController {


    /*
    public Boolean verificarConformidade(EntidadeRegulada entidade) {
        return true;
    }

     */

    public void registrarInspecao(Inspecao inspecao) {

    }

    public void gerarRelatorioConformidade() {

    }

}
