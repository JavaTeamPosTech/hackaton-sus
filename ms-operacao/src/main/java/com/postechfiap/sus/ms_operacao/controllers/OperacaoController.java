package com.postechfiap.sus.ms_operacao.controllers;

import com.postechfiap.sus.ms_operacao.dto.request.OperacaoRequestDto;
import com.postechfiap.sus.ms_operacao.dto.response.OperacaoResponseDto;
import com.postechfiap.sus.ms_operacao.services.operacao.IOperacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/operacao")
public class OperacaoController {


    private final IOperacaoService operacaoService;

    public OperacaoController(IOperacaoService operacaoService) {
        this.operacaoService = operacaoService;
    }

    /**
     * Endpoint para criação de uma nova Operacao.
     */
    @PostMapping
    @Operation(summary = "Criar Nova Operacao",
            description = "Cria uma nova Operacao")
    @ApiResponse(responseCode = "201", description = "Operacao criada com sucesso.")
    @ApiResponse(responseCode = "400", description = "Regra de Negócio violada.")
    @ResponseStatus(HttpStatus.CREATED)
    //@PreAuthorize("hasAuthority('ALUNO')")
    public ResponseEntity<OperacaoResponseDto> criarOperacao(
            @RequestBody @Valid OperacaoRequestDto request//, Authentication authentication
    ) {
        OperacaoResponseDto response = operacaoService.criarOperacao(request);//, authentication);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar Operacao por ID",
            description = "Retorna uma operacao. Alunos só podem ver as suas.")
    @ApiResponse(responseCode = "200", description = "Operacao encontrada.")
    @ApiResponse(responseCode = "403", description = "Proibido. Usuário tenta acessar operacao de terceiros.")
    //@PreAuthorize("hasAnyAuthority('PROFESSOR')")
    public ResponseEntity<OperacaoResponseDto> buscarOperacaoPorId(
            @Parameter(description = "ID da Operacao.") @PathVariable UUID id) {

        //log.info("Requisição GET /operacoes/{} recebida.", id);

        OperacaoResponseDto response = operacaoService.buscarOperacaoPorId(id);

        //log.info("Busca de operacao ID {} concluída.", id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("")
    @Operation(summary = "Buscar Operacoes",
            description = "Retorna as operacoes.")
    @ApiResponse(responseCode = "200", description = "Operacoes encontradas.")
    @ApiResponse(responseCode = "403", description = "Proibido. Usuário tenta acessar operacoes de terceiros.")
    //@PreAuthorize("hasAnyAuthority('PROFESSOR')")
    public ResponseEntity<List<OperacaoResponseDto>> buscarOperacoes() {

        //log.info("Requisição GET /operacoes/{} recebida.", id);

        List<OperacaoResponseDto> response = operacaoService.buscarOperacoes();

        //log.info("Busca de operacao ID {} concluída.", id);
        return ResponseEntity.ok(response);
    }

}
