package ar.edu.utn.ba.ddsi.climalert.services;

import ar.edu.utn.ba.ddsi.climalert.entidades.ClimaData;
import ar.edu.utn.ba.ddsi.climalert.strategies.AlertaRegla;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertaService {
    private List<AlertaRegla> reglas;
    private ApplicationEventPublisher publicador;

    public void analizar(ClimaData climaData){
        //TODO: Hacer logica de funcion
    }
}
