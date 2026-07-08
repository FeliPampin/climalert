package ar.edu.utn.ba.ddsi.climalert.schedulers;

import ar.edu.utn.ba.ddsi.climalert.repositorios.ClimaDataRepository;
import ar.edu.utn.ba.ddsi.climalert.services.AlertaService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AlertaAnalisisScheduler {
    private ClimaDataRepository climaDataRepository;
    private AlertaService alertaService;

    @Scheduled(cron = "0 * * * * *")
    public void analizarUltimaData(){
        //TODO: Hacer logica
    }
}
