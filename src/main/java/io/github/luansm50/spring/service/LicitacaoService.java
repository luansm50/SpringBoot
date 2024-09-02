package io.github.luansm50.spring.service;

import io.github.luansm50.spring.domain.dto.LicitacaoDataDTO;
import io.github.luansm50.spring.domain.dto.LicitacaoPageResponse;
import io.github.luansm50.spring.domain.entity.Anexo;
import io.github.luansm50.spring.domain.entity.ItemEdital;

import java.util.List;

public interface LicitacaoService {

    void init(LicitacaoDataDTO data);
    LicitacaoPageResponse findAll(int page, int size);

    List<ItemEdital> findAllItems();
    List<Anexo> findAllAnexos();

}
