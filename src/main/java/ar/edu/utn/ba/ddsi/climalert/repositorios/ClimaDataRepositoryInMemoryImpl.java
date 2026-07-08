package ar.edu.utn.ba.ddsi.climalert.repositorios;

import ar.edu.utn.ba.ddsi.climalert.entidades.ClimaData;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Repository
public class ClimaDataRepositoryInMemoryImpl implements ClimaDataRepository{
    private List<ClimaData> repositorioEnMemoria = new ArrayList<>();
    private Long contadorId = 1L;

    @Override
    public void save(ClimaData climaData) {
        climaData.setId(contadorId);
        this.contadorId++;
        repositorioEnMemoria.add(climaData);
    }

    @Override
    public ClimaData findUltimo() {
        return repositorioEnMemoria.stream().max(Comparator.comparing(ClimaData::getTimestamp)).orElse(null);
    }
}
