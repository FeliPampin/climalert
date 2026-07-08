package ar.edu.utn.ba.ddsi.climalert.strategies;

import ar.edu.utn.ba.ddsi.climalert.entidades.ClimaData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AltaTemperaturaYHumedadRegla implements AlertaRegla{
    private final Double maxTemp;
    private final Double maxHum;

    public AltaTemperaturaYHumedadRegla(
            @Value("${climalert.reglas.max-temperatura:35.0}") Double maxTemp,
            @Value("${climalert.reglas.max-humedad:60.0}") Double maxHum) {

        this.maxTemp = maxTemp;
        this.maxHum = maxHum;
    }

    //Devuelve true si la temperatura y la humedad son altas
    @Override
    public Boolean evaluar(ClimaData climaData) {
        if(climaData.getTemperatura() > maxTemp && climaData.getHumedad() > maxHum){
            return true;
        }
        return false;
    }

    @Override
    public String getAlertaMensaje(ClimaData climaData) {
        return "ALERTA: La temperatura y la humedad superaron los maximos permitidos en " + climaData.getUbicacion() + ", la temperatura es de " + climaData.getTemperatura() + "° y la humedad es de " + climaData.getHumedad() + "%.";
    }
}
