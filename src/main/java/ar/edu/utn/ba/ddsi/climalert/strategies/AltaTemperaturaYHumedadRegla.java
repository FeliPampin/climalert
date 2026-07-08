package ar.edu.utn.ba.ddsi.climalert.strategies;

import ar.edu.utn.ba.ddsi.climalert.entidades.ClimaData;

public class AltaTemperaturaYHumedadRegla implements AlertaRegla{
    private Double maxTemp;
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
