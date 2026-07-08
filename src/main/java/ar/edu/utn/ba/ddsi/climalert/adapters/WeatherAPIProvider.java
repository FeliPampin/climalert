package ar.edu.utn.ba.ddsi.climalert.adapters;

import ar.edu.utn.ba.ddsi.climalert.entidades.ClimaData;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherAPIProvider implements ClimaProvider{
    private RestTemplate restTemplate;
    private String apiUrl = "/current.json.";

    @Override
    public ClimaData obtenerClimaActual(String ubicacion) {
        return null;
    }
}
