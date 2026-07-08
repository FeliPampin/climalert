package ar.edu.utn.ba.ddsi.climalert.entidades;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
public class ClimaData {
    @Setter
    private Long id;
    private Double temperatura;
    private Double humedad;
    private LocalDateTime timestamp;
    private String ubicacion;

    public ClimaData(Double temperatura, Double humedad, LocalDateTime timestamp, String ubicacion) {
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.timestamp = timestamp;
        this.ubicacion = ubicacion;
    }

}
