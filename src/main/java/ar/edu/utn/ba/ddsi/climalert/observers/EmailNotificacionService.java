package ar.edu.utn.ba.ddsi.climalert.observers;

import ar.edu.utn.ba.ddsi.climalert.entidades.AlertaEvento;
import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailNotificacionService implements NotificacionStrategy{
    private final JavaMailSender mailSender;
    private List<String> receptores;

    public EmailNotificacionService(
            JavaMailSender mailSender,
            @Value("${climalert.notificaciones.receptores:admin@clima.com,emergencias@clima.com,meteorologia@clima.com}") List<String> receptores) {

        this.mailSender = mailSender;
        this.receptores = receptores;
    }

    @Override
    public void enviar(AlertaEvento evento) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(receptores.toArray(new String[0]));
        mail.setSubject("Climalert - Alerta Meteorológica Crítica");
        mail.setText(evento.getMensaje());
        mailSender.send(mail);

        System.out.println("Correos de alerta enviados.");
    }

    @EventListener
    public void manejarAlerta(AlertaEvento evento){
        this.enviar(evento);
    }
}
