package ar.edu.utn.ba.ddsi.climalert.observers;

import ar.edu.utn.ba.ddsi.climalert.entidades.AlertaEvento;

public interface NotificacionStrategy {
    public void enviar(AlertaEvento evento);
}
