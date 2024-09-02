package io.github.luansm50.spring.domain.repository;

import io.github.luansm50.spring.domain.entity.Anexo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnexoRepository extends JpaRepository<Anexo, Long> {
    @Query("SELECT a FROM Anexo a WHERE a.licitacao.id = :id")
    List<Anexo> findByLicitacaoId(@Param("id")  Long id);

}
