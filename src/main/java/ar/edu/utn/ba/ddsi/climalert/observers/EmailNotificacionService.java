package ar.edu.utn.ba.ddsi.climalert.observers;

import ar.edu.utn.ba.ddsi.climalert.entidades.AlertaEvento;
import org.springframework.context.event.EventListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailNotificacionService implements NotificacionStrategy{
    private JavaMailSender mailSender;
    private List<String> receptores = new ArrayList<>();

    public EmailNotificacionService(
            JavaMailSender mailSender,
            @Value("${climalert.notificaciones.receptores:admin@clima.com,emergencias@clima.com,meteorologia@clima.com}") List<String> receptores) {

        this.mailSender = mailSender;
        this.receptores = receptores;
    }

    @Override
    public void enviar(AlertaEvento evento) {
        //TODO: Desarrollar metodo
    }

    @EventListener
    public void manejarAlerta(AlertaEvento evento){
        this.enviar(evento);
    }
}
