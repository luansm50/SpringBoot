package io.github.luansm50.spring.domain.repository;

import io.github.luansm50.spring.domain.entity.ItemEdital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemEditalRepository extends JpaRepository<ItemEdital, Long> {
    @Query("SELECT ie FROM ItemEdital ie WHERE ie.licitacao.id = :id")
    List<ItemEdital> findByLicitacaoId(@Param("id")  Long id);
}
