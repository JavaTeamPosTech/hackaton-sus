package com.postechfiap.sus.msmaquina.controllers;

import com.postechfiap.sus.ms_contracts.domains.maquina.MaquinaDetails;
import com.postechfiap.sus.msmaquina.dto.request.MaquinaRequestDto;
import com.postechfiap.sus.msmaquina.dto.response.MaquinaResponseDtoDetalhes;
import com.postechfiap.sus.msmaquina.services.maquina.IMaquinaService;
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
@RequestMapping("/maquinas")
public class MaquinaController {

    private final IMaquinaService maquinaService;

    public MaquinaController(IMaquinaService maquinaService) {
        this.maquinaService = maquinaService;
    }

    /**
     * Endpoint para criação de uma nova Maquina.
     */
    @PostMapping
    @Operation(summary = "Criar Nova Maquina",
            description = "Cria uma nova Maquina, valida e publica um evento Kafka.")
    @ApiResponse(responseCode = "201", description = "Maquina criada com sucesso.")
    @ApiResponse(responseCode = "400", description = "Regra de Negócio violada.")
    @ResponseStatus(HttpStatus.CREATED)
    //@PreAuthorize("hasAuthority('ALUNO')")
    public ResponseEntity<MaquinaResponseDtoDetalhes> criarMaquina(
            @RequestBody @Valid MaquinaRequestDto request//, Authentication authentication
    ) {
        MaquinaResponseDtoDetalhes response = maquinaService.criarMaquina(request);//, authentication);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @GetMapping("/{id}/detalhes")
    @Operation(summary = "Buscar Maquina por ID",
            description = "Retorna uma maquina. Alunos só podem ver as suas.")
    @ApiResponse(responseCode = "200", description = "Maquina encontrada.")
    @ApiResponse(responseCode = "403", description = "Proibido. Usuário tenta acessar maquina de terceiros.")
    //@PreAuthorize("hasAnyAuthority('PROFESSOR')")
    public ResponseEntity<MaquinaResponseDtoDetalhes> buscarMaquinaPorIdDetalhes(
            @Parameter(description = "ID da Maquina.") @PathVariable UUID id) {

        //log.info("Requisição GET /maquinas/{} recebida.", id);

        MaquinaResponseDtoDetalhes response = maquinaService.buscarMaquinaPorIdDetalhes(id);

        //log.info("Busca de Maquina ID {} concluída.", id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar Maquina por ID",
            description = "Retorna uma maquina. Alunos só podem ver as suas.")
    @ApiResponse(responseCode = "200", description = "Maquina encontrada.")
    @ApiResponse(responseCode = "403", description = "Proibido. Usuário tenta acessar maquina de terceiros.")
    //@PreAuthorize("hasAnyAuthority('PROFESSOR')")
    public ResponseEntity<MaquinaDetails> buscarMaquinaPorId(
            @Parameter(description = "ID da Maquina.") @PathVariable UUID id) {

        //log.info("Requisição GET /maquinas/{} recebida.", id);

        MaquinaDetails response = maquinaService.buscarMaquinaPorId(id);

        //log.info("Busca de Maquina ID {} concluída.", id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("")
    @Operation(summary = "Buscar Maquinas",
            description = "Retorna todas as maquina.")
    @ApiResponse(responseCode = "200", description = "Maquinas encontradas.")
    @ApiResponse(responseCode = "403", description = "Proibido. Usuário tenta acessar maquinas de terceiros.")
    //@PreAuthorize("hasAnyAuthority('PROFESSOR')")
    public ResponseEntity<List<MaquinaResponseDtoDetalhes>> buscarMaquinas() {

        //log.info("Requisição GET /maquinas/{} recebida.");

        List<MaquinaResponseDtoDetalhes> response = maquinaService.buscarMaquinas();

        //log.info("Busca de Maquinas {} concluída.");
        return ResponseEntity.ok(response);
    }



}
