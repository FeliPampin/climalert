package ar.edu.utn.ba.ddsi.climalert.schedulers;

import ar.edu.utn.ba.ddsi.climalert.adapters.ClimaProvider;
import ar.edu.utn.ba.ddsi.climalert.entidades.ClimaData;
import ar.edu.utn.ba.ddsi.climalert.repositorios.ClimaDataRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

@Component
public class ClimaFetchScheduler {
    private final ClimaProvider climaProvider;
    private final ClimaDataRepository climaDataRepository;
    private String ubicacion;

    public ClimaFetchScheduler(ClimaProvider climaProvider, ClimaDataRepository climaDataRepository, @Value("${climalert.ubicacion:CABA}") String ubicacion) {

        this.climaProvider = climaProvider;
        this.climaDataRepository = climaDataRepository;
        this.ubicacion = ubicacion;
    }

    @Scheduled(cron = "0 0/5 * * * *")
    public void obtenerYGuardar(){
        ClimaData climaActual = climaProvider.obtenerClimaActual(ubicacion);
        if (climaActual != null) {
            climaDataRepository.save(climaActual);
            System.out.println("Clima guardado exitosamente para " + ubicacion);
        } else {
            System.err.println("No se pudo obtener el clima de la API externa.");
        }
    }
}
