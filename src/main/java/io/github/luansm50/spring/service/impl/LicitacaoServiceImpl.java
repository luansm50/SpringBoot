package io.github.luansm50.spring.service.impl;

import io.github.luansm50.spring.domain.dto.LicitacaoDataDTO;
import io.github.luansm50.spring.domain.dto.LicitacaoPageResponse;
import io.github.luansm50.spring.domain.dto.MetadadosDTO;
import io.github.luansm50.spring.domain.entity.Anexo;
import io.github.luansm50.spring.domain.entity.ItemEdital;
import io.github.luansm50.spring.domain.entity.Licitacao;
import io.github.luansm50.spring.domain.repository.AnexoRepository;
import io.github.luansm50.spring.domain.repository.ItemEditalRepository;
import io.github.luansm50.spring.domain.repository.LicitacaoRepository;
import io.github.luansm50.spring.service.LicitacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LicitacaoServiceImpl implements LicitacaoService {

    private final AnexoRepository anexoRepository;
    private final LicitacaoRepository licitacaoRepository;
    private final ItemEditalRepository itemEditalRepository;

    @Override
    public LicitacaoPageResponse findAll(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Licitacao> licitacoesPage = licitacaoRepository.findAll(pageable);
        return LicitacaoPageResponse
                .builder()
                .licitacoes(licitacoesPage.getContent())
                .metadata(MetadadosDTO
                        .builder()
                        .paginaAtual(licitacoesPage.getNumber())
                        .totalRegistros(licitacoesPage.getTotalElements())
                        .build())
                .build();
    }

    @Override
    public List<ItemEdital> findAllItems() {
        return itemEditalRepository.findByLicitacaoId(1L);
    }

    @Override
    public List<Anexo> findAllAnexos() {
        return anexoRepository.findByLicitacaoId(1L);
    }

    @Override
    @Transactional
    public void init(LicitacaoDataDTO data) {
        List<Licitacao> licitacoes = data.getLicitacoes();
        for (Licitacao licitacao : licitacoes)
            saveLicitacao(licitacao);
    }

    @Transactional
    public void saveLicitacao(Licitacao data) {
        Licitacao licitacao = licitacaoRepository.save(data);
        for (ItemEdital itemEdital : data.getItensEdital()) {
            itemEdital.setLicitacao(licitacao);
            itemEditalRepository.save(itemEdital);
        }

        for (Anexo anexo : data.getAnexos()) {
            anexo.setLicitacao(licitacao);
            anexoRepository.save(anexo);
        }
    }
}
