package ar.edu.utn.ba.ddsi.climalert.adapters;

import ar.edu.utn.ba.ddsi.climalert.entidades.ClimaData;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

@Component
public class WeatherAPIProvider implements ClimaProvider{
    private RestTemplate restTemplate;
    private String apiUrl;

    public WeatherAPIProvider(
            RestTemplate restTemplate,
            @Value("${climalert.api.endpoint:/current.json}") String apiUrl) {

        this.restTemplate = restTemplate;
        this.apiUrl = apiUrl;
    }

    @Override
    public ClimaData obtenerClimaActual(String ubicacion) {
        return null;
    }
}
