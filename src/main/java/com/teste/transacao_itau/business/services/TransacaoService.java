package com.teste.transacao_itau.business.services;

import com.teste.transacao_itau.controller.dtos.TransacaoRequestDTO;
import com.teste.transacao_itau.infrastructure.exceptions.UnprocessableEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransacaoService {

    private final List<TransacaoRequestDTO> listqTransacoes = new ArrayList<>();

    public void adcicionarTransacoes(TransacaoRequestDTO dto){

        log.info("Iniciada o processamento de grvar transaçoes");

        if(dto.dataHora().isAfter(OffsetDateTime.now())){
            log.error("Data e hora maiores que q atual");
            throw new UnprocessableEntity("Data e hora maiores que atual");
        }
        if(dto.valor() < 0){
            log.error("O valor não deve ser menor que 0");
            throw new UnprocessableEntity("O valor não pode ser menor que 0");
        }
    }
}
