package io.github.luansm50.spring.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MetadadosDTO {
    @JsonProperty("pagina_atual")
    private int paginaAtual;

    @JsonProperty("total_registros")
    private long totalRegistros;
}
