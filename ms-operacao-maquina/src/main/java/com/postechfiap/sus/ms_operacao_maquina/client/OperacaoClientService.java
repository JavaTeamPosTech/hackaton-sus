package com.postechfiap.sus.ms_operacao_maquina.client;

import com.postechfiap.sus.ms_contracts.domains.maquina.MaquinaDetails;
import com.postechfiap.sus.ms_contracts.domains.operacao.OperacaoDetails;
import com.postechfiap.sus.ms_operacao_maquina.exception.RecursoNaoEncontradoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * Cliente REST síncrono para buscar detalhes de operacoes no ms-operacao.
 * Utiliza chave secreta (X-Internal-Secret) para autenticação Service-to-Service.
 */
@Service
public class OperacaoClientService {

    private static final Logger log = LoggerFactory.getLogger(OperacaoClientService.class);

    private final WebClient webClient;
    private final String operacaoServiceBaseUrl;
    private final String internalSecret;

    private static final String INTERNAL_SECRET_HEADER = "X-Internal-Service";

    public OperacaoClientService(WebClient webClient,
                                 @Value("${app.operacao.service.url}") String operacaoServiceBaseUrl,
                                 @Value("${app.internal-secret}") String internalSecret) {
        this.webClient = webClient;
        this.operacaoServiceBaseUrl = operacaoServiceBaseUrl;
        this.internalSecret = internalSecret;
    }

    /**
     * Busca os detalhes completos da operacao no ms-operacao.
     * @param operacaoId O ID da Operacao.
     * @return OperacaoDetails.
     * @throws RecursoNaoEncontradoException se o usuário não for encontrado (404).
     */
    public OperacaoDetails buscarOperacaoPorId(UUID operacaoId) {
        String url = operacaoServiceBaseUrl + "/" + operacaoId.toString();
        log.info("RPC INICIADO: Buscando Operacao ID {} via GET {}", operacaoId, url);

        try {
            OperacaoDetails response = webClient.get()
                    .uri(url)
                    .header(INTERNAL_SECRET_HEADER, internalSecret)
                    .retrieve()

                    // Tratamento de 404 (Recurso Não Encontrado)
                    .onStatus(status -> status == HttpStatus.NOT_FOUND,
                            clientResponse -> {
                                log.warn("RPC FALHOU: 404 Not Found para o ID {}", operacaoId);
                                return Mono.error(new RecursoNaoEncontradoException("Operacao com ID " + operacaoId + " não encontrado no sistema de operacao."));
                            })

                    .bodyToMono(OperacaoDetails.class)
                    .block(); // Chamada síncrona

            log.info("RPC SUCESSO: Detalhes da Operacao ID {} recebidos.", operacaoId);
            return response;

        } catch (WebClientResponseException e) {
            // Tratamento de falhas de segurança (401/403) ou 5xx
            if (e.getStatusCode() == HttpStatus.FORBIDDEN || e.getStatusCode() == HttpStatus.UNAUTHORIZED) {
                log.error("RPC FALHOU: Acesso negado ao ms-operacao. Status: {}", e.getStatusCode());
                throw new RuntimeException("Falha na autenticação de serviço: Chave interna inválida ou acesso negado.", e);
            }
            log.error("RPC FALHOU: Erro inesperado na comunicação síncrona. Status: {}", e.getStatusCode(), e);
            throw new RuntimeException("Falha na comunicação síncrona com o ms-autenticacao: " + e.getMessage(), e);
        }
    }

//    public CursoDetails buscarCursoPorIdCurso(UUID idCurso){
//        String url = operacaoServiceBaseUrl + "/cursos/" + idCurso.toString();
//        log.info("RPC INICIADO: Buscando Usuario ID {} via GET {}", idCurso, url);
//
//        try {
//            CursoDetails response = webClient.get()
//                    .uri(url)
//                    .header(INTERNAL_SECRET_HEADER, internalSecret)
//                    .retrieve()
//
//                    // Tratamento de 404 (Recurso Não Encontrado)
//                    .onStatus(status -> status == HttpStatus.NOT_FOUND,
//                            clientResponse -> {
//                                log.warn("RPC FALHOU: 404 Not Found para o ID {}", idCurso);
//                                return Mono.error(new RecursoNaoEncontradoException("Usuário com ID " + idCurso + " não encontrado no sistema de Autenticação."));
//                            })
//
//                    .bodyToMono(CursoDetails.class)
//                    .block(); // Chamada síncrona
//
//            log.info("RPC SUCESSO: Detalhes do Usuario ID {} recebidos.", idCurso);
//            return response;
//
//        } catch (WebClientResponseException e) {
//            // Tratamento de falhas de segurança (401/403) ou 5xx
//            if (e.getStatusCode() == HttpStatus.FORBIDDEN || e.getStatusCode() == HttpStatus.UNAUTHORIZED) {
//                log.error("RPC FALHOU: Acesso negado ao ms-autenticacao. Status: {}", e.getStatusCode());
//                throw new RuntimeException("Falha na autenticação de serviço: Chave interna inválida ou acesso negado.", e);
//            }
//            log.error("RPC FALHOU: Erro inesperado na comunicação síncrona. Status: {}", e.getStatusCode(), e);
//            throw new RuntimeException("Falha na comunicação síncrona com o ms-autenticacao: " + e.getMessage(), e);
//        }
//    }

}