package ar.edu.utn.ba.ddsi.climalert.observers;

import ar.edu.utn.ba.ddsi.climalert.entidades.AlertaEvento;
import org.springframework.context.event.EventListener;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.List;

public class EmailNotificacionService implements NotificacionStrategy{
    private JavaMailSender mailSender;
    private List<String> receptores;

    @Override
    public void enviar(AlertaEvento evento) {
        //TODO: Desarrollar metodo
    }

    @EventListener
    public void manejarAlerta(AlertaEvento evento){
        this.enviar(evento);
    }
}
