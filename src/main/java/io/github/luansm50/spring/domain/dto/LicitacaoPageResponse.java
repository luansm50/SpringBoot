package io.github.luansm50.spring.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.luansm50.spring.domain.entity.Licitacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LicitacaoPageResponse {
    private List<Licitacao> licitacoes;

    @JsonProperty("_metadata")
    private MetadadosDTO metadata;
}
