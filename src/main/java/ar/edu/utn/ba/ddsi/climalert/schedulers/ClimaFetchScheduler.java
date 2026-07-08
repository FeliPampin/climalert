package ar.edu.utn.ba.ddsi.climalert.schedulers;

import ar.edu.utn.ba.ddsi.climalert.adapters.ClimaProvider;
import ar.edu.utn.ba.ddsi.climalert.repositorios.ClimaDataRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

@Component
public class ClimaFetchScheduler {
    private ClimaProvider climaProvider;
    private ClimaDataRepository climaDataRepository;
    @Value("${climalert.ubicacion}")
    private String ubicacion;

    @Scheduled(cron = "0 0/5 * * * *")
    public void obtenerYGuardar(){
        //TODO: Hacer logica
    }
}
