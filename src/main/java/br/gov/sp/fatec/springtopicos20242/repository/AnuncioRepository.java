package br.gov.sp.fatec.springtopicos20242.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springtopicos20242.entity.Anuncio;

public interface AnuncioRepository extends JpaRepository<Anuncio, Long>{

    public List<Anuncio> findByPrecoLessThanAndDataHoraCadastroGreaterThan(Float preco, LocalDateTime dataHoraCadastro);

    public List<Anuncio> findByDataHoraCadastroGreaterThanOrDescricaoContains(LocalDateTime dataHoraCadastro, String descricao);
    
}
