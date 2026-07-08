package ar.edu.utn.ba.ddsi.climalert.schedulers;

import ar.edu.utn.ba.ddsi.climalert.entidades.ClimaData;
import ar.edu.utn.ba.ddsi.climalert.repositorios.ClimaDataRepository;
import ar.edu.utn.ba.ddsi.climalert.services.AlertaService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AlertaAnalisisScheduler {
    private final ClimaDataRepository climaDataRepository;
    private final AlertaService alertaService;

    public AlertaAnalisisScheduler(ClimaDataRepository climaDataRepository, AlertaService alertaService) {

        this.climaDataRepository = climaDataRepository;
        this.alertaService = alertaService;
    }

    @Scheduled(fixedRateString = "${climalert.scheduler.analysis-rate:60000}")
    public void analizarUltimaData(){
        ClimaData ultimoClima = climaDataRepository.findUltimo();
        if(ultimoClima != null){
            alertaService.analizar(ultimoClima);
        }
    }
}
