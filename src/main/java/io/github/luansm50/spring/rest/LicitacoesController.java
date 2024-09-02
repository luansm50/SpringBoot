package io.github.luansm50.spring.rest;

import io.github.luansm50.spring.domain.dto.LicitacaoPageResponse;
import io.github.luansm50.spring.service.LicitacaoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/licitacoes")
public class LicitacoesController {

    private LicitacaoService licitacaoService;

    public LicitacoesController(LicitacaoService licitacaoService) {
        this.licitacaoService = licitacaoService;
    }

    @GetMapping
    public LicitacaoPageResponse buscarLicitacoes(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "100") int size
    ) {
        return licitacaoService.findAll(page, size);
    }
}
