package ar.edu.utn.ba.ddsi.climalert.repositorios;

import ar.edu.utn.ba.ddsi.climalert.entidades.ClimaData;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClimaDataRepositoryInMemoryImpl implements ClimaDataRepository{
    private List<ClimaData> repositorioEnMemoria;

    @Override
    public void save(ClimaData climaData) {
        repositorioEnMemoria.add(climaData);
    }

    @Override
    public ClimaData findUltimo() {
        return null;
    }
}
