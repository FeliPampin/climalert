package ar.edu.utn.ba.ddsi.climalert.strategies;

import ar.edu.utn.ba.ddsi.climalert.entidades.ClimaData;

public interface AlertaRegla {
    public Boolean evaluar(ClimaData climaData);
    public String getAlertaMensaje();
}
