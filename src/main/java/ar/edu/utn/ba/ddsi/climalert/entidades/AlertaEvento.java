package ar.edu.utn.ba.ddsi.climalert.entidades;

import lombok.Getter;

@Getter
public class AlertaEvento {
    private String mensaje;
    private ClimaData climaData;

    public AlertaEvento(String mensaje, ClimaData climaData){
        this.mensaje = mensaje;
        this.climaData = climaData;
    }
}
