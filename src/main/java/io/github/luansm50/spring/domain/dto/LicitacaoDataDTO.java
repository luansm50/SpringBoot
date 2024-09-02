package io.github.luansm50.spring.domain.dto;

import io.github.luansm50.spring.domain.entity.Licitacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LicitacaoDataDTO {
    private List<Licitacao> licitacoes;;
}
