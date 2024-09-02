package io.github.luansm50.spring.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemEdital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column(length = 50000)
    private String produtoLicitado;
    private Integer item;
    private String lote;
    private String diferenciado;
    private String unidade;
    private Integer quantidade;
    private Integer decreto7174;

    @ManyToOne
    @JoinColumn(name = "licitacao_id")
    @JsonIgnore
    private Licitacao licitacao;

}
