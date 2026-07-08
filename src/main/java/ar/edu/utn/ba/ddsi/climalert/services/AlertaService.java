package ar.edu.utn.ba.ddsi.climalert.services;

import ar.edu.utn.ba.ddsi.climalert.entidades.AlertaEvento;
import ar.edu.utn.ba.ddsi.climalert.entidades.ClimaData;
import ar.edu.utn.ba.ddsi.climalert.strategies.AlertaRegla;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertaService {
    private List<AlertaRegla> reglas;
    private final ApplicationEventPublisher publicador;

    public AlertaService(List<AlertaRegla> reglas, ApplicationEventPublisher publicador) {
        this.reglas = reglas;
        this.publicador = publicador;
    }

    public void analizar(ClimaData climaData){
        for (int i=0; i<reglas.size(); i++){
            if (reglas.get(i).evaluar(climaData)){
                AlertaEvento eventoAPublicar = new AlertaEvento(reglas.get(i).getAlertaMensaje(climaData), climaData);
                publicador.publishEvent(eventoAPublicar);
            }
        }
    }
}
