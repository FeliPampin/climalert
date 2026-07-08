package ar.edu.utn.ba.ddsi.climalert.adapters;

import ar.edu.utn.ba.ddsi.climalert.entidades.ClimaData;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import tools.jackson.databind.JsonNode;

import java.time.LocalDateTime;

@Component
public class WeatherAPIProvider implements ClimaProvider{
    private final RestTemplate restTemplate;
    private final String baseUrl;
    private final String apiKey;

    public WeatherAPIProvider(RestTemplate restTemplate, @Value("${climalert.api.base-url}") String baseUrl, @Value("${climalert.api.key}") String apiKey) {

        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
        this.apiKey = apiKey;
    }

    @Override
    public ClimaData obtenerClimaActual(String ubicacion) {
        try {
            String url = baseUrl + "?key=" + apiKey + "&q=" + ubicacion;

            JsonNode respuesta = restTemplate.getForObject(url, JsonNode.class);

            if (respuesta != null && respuesta.has("current")) {
                Double temperatura = respuesta.get("current").get("temp_c").asDouble();
                Double humedad = respuesta.get("current").get("humidity").asDouble();

                return new ClimaData(temperatura, humedad, LocalDateTime.now(), ubicacion);
            }

        } catch (Exception e) {
            System.err.println("Error de conexión con WeatherAPI: " + e.getMessage());
        }

        return null;
    }
}
