package br.gov.sp.fatec.springtopicos20242.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.gov.sp.fatec.springtopicos20242.entity.Alerta;
import br.gov.sp.fatec.springtopicos20242.repository.AlertaRepository;

@Service
public class AlertaServiceImpl {

    private AlertaRepository repo;

    public AlertaServiceImpl(AlertaRepository repo) {
        this.repo = repo;
    }

    public Alerta cadastrarAlerta(Alerta alerta) {
        if(alerta.getDataHoraGeracao() == null) {
            alerta.setDataHoraGeracao(LocalDateTime.now());
        }
        if(alerta.getNivel() == null) {
            alerta.setNivel(5);
        }
        return repo.save(alerta);
    }

    public List<Alerta> todosAlertas() {
        List<Alerta> alertas = new ArrayList<Alerta>();
        for(Alerta alerta: repo.findAll()) {
            alertas.add(alerta);
        }
        return alertas;
    }

    public List<Alerta> buscarPorDataHoraGeracaoENivel(LocalDateTime dataHoraGeracao, Integer nivel) {
        return repo.findByDataHoraGeracaoGreaterThanAndNivelLessThan(dataHoraGeracao, nivel);
    }
    
}
