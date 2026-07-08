package ar.edu.utn.ba.ddsi.climalert.adapters;

import ar.edu.utn.ba.ddsi.climalert.entidades.ClimaData;

public interface ClimaProvider {
    public ClimaData obtenerClimaActual(String ubicacion);
}
