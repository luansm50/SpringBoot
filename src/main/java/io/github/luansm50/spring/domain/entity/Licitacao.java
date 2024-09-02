package io.github.luansm50.spring.domain.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Licitacao {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("idLicitacao")
    private Long id;

    private String perfilNome;
    private String orgao;
    private boolean favorito;
    @Column(length = 50000)
    private String objeto;
    private String dataPublicacao;
    private String dataFinalProposta;
    private String url;
    private Integer perfil;
    private String unidadeGestora;
    private boolean srp;
    private String uf;
    private String dataInicialProposta;
    private String processo;
    private Long uasg;
    private String portal;
    private String dataCaptura;
    private String modalidade;

    @ElementCollection
    private List<String> palavraEncontrada;

    @OneToMany(mappedBy = "licitacao", fetch = FetchType.LAZY)
    private List<ItemEdital> itensEdital;

    @OneToMany(mappedBy = "licitacao")
    private List<Anexo> anexos;
}
