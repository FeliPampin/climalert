package ar.edu.utn.ba.ddsi.climalert.repositorios;

import ar.edu.utn.ba.ddsi.climalert.entidades.ClimaData;

public interface ClimaDataRepository {
    public void save(ClimaData climaData);
    public ClimaData findUltimo();
}
