package com.postechfiap.sus.msmaquina.controllers;

import com.postechfiap.sus.msmaquina.dto.request.MaquinaRequestDto;
import com.postechfiap.sus.msmaquina.dto.request.OperacaoRequestDto;
import com.postechfiap.sus.msmaquina.dto.response.MaquinaResponseDto;
import com.postechfiap.sus.msmaquina.dto.response.OperacaoResponseDto;
import com.postechfiap.sus.msmaquina.services.maquina.IMaquinaService;
import com.postechfiap.sus.msmaquina.services.operacao.IOperacaoService;
import com.postechfiap.sus.msmaquina.services.utilizacaoMaquina.IUtilizacaoMaquinaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/operacao")
public class OperacaoController {


    private final IOperacaoService operacaoService;

    public OperacaoController(IOperacaoService operacaoService) {
        this.operacaoService = operacaoService;
    }

    /**
     * Endpoint para criação de uma nova Maquina.
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

}
