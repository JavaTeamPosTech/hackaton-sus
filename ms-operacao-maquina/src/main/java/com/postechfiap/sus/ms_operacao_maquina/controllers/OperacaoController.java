package com.postechfiap.sus.ms_operacao_maquina.controllers;

import com.postechfiap.sus.ms_operacao_maquina.dto.request.ManutencaoMaquinaRequestDto;
import com.postechfiap.sus.ms_operacao_maquina.dto.request.UtilizacaoMaquinaRequestDto;
import com.postechfiap.sus.ms_operacao_maquina.dto.response.ManutencaoMaquinaResponseDto;
import com.postechfiap.sus.ms_operacao_maquina.dto.response.UtilizacaoMaquinaResponseDto;
import com.postechfiap.sus.ms_operacao_maquina.services.utilizacaoMaquina.IManutencaoMaquinaService;
import com.postechfiap.sus.ms_operacao_maquina.services.utilizacaoMaquina.IUtilizacaoMaquinaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/operacoes")
public class OperacaoController {


    private final IUtilizacaoMaquinaService utilizacaoMaquinaService;
    private final IManutencaoMaquinaService manutencaoMaquinaService;


    public OperacaoController(IUtilizacaoMaquinaService utilizacaoMaquinaService, IManutencaoMaquinaService manutencaoMaquinaService) {
        this.utilizacaoMaquinaService = utilizacaoMaquinaService;
        this.manutencaoMaquinaService = manutencaoMaquinaService;
    }

    /**
     * Endpoint para criação de uma nova utilização da maquina.
     */
    @PostMapping("/utilizacao-maquina")
    @Operation(summary = "Criar Nova Utilizacao da maquina",
            description = "Cria uma nova Utilizacao da maquina, valida e publica um evento Kafka.")
    @ApiResponse(responseCode = "201", description = "Utilizacao Maquina criada com sucesso.")
    @ApiResponse(responseCode = "400", description = "Regra de Negócio violada.")
    @ResponseStatus(HttpStatus.CREATED)
    //@PreAuthorize("hasAuthority('ALUNO')")
    public ResponseEntity<UtilizacaoMaquinaResponseDto> criarUtilizacaoDaMaquina(
            @Valid  @RequestBody UtilizacaoMaquinaRequestDto dto//, Authentication authentication
    ) {
        UtilizacaoMaquinaResponseDto response = utilizacaoMaquinaService.criarUtilizacaoMaquina(dto);//, authentication);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * Endpoint para criação de uma nova manutenção da maquina.
     */
    @PostMapping("/manutencao-maquina")
    @Operation(summary = "Criar Nova Manutenção da maquina",
            description = "Cria uma nova Manutenção da maquina, valida e publica um evento Kafka.")
    @ApiResponse(responseCode = "201", description = "Manutenção Maquina criada com sucesso.")
    @ApiResponse(responseCode = "400", description = "Regra de Negócio violada.")
    @ResponseStatus(HttpStatus.CREATED)
    //@PreAuthorize("hasAuthority('ALUNO')")
    public ResponseEntity<ManutencaoMaquinaResponseDto> criarManutencaoDaMaquina(
            @Valid  @RequestBody ManutencaoMaquinaRequestDto dto//, Authentication authentication
    ) {
        ManutencaoMaquinaResponseDto response = manutencaoMaquinaService.criarManutencaoMaquina(dto);//, authentication);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
