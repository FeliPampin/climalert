package ar.edu.utn.ba.ddsi.climalert.strategies;

import ar.edu.utn.ba.ddsi.climalert.entidades.ClimaData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AltaTemperaturaYHumedadRegla implements AlertaRegla{
    @Value("${climalert.reglas.max-temperatura}")
    private Double maxTemp;
    @Value("${climalert.reglas.max-humedad}")
    private Double maxHum;

    @Override
    public Boolean evaluar(ClimaData climaData) {
        return null;
    }

    @Override
    public String getAlertaMensaje() {
        return "";
    }
}
