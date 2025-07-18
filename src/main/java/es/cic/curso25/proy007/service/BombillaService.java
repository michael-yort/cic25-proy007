package es.cic.curso25.proy007.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.cic.curso25.proy007.model.Bombilla;
import es.cic.curso25.proy007.repository.BombillaRepositoryImpl;

@Service
public class BombillaService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BombillaService.class);

    @Autowired
    private BombillaRepositoryImpl repo;

    public long create(Bombilla bombilla) {
        return repo.create(bombilla);
    }

    public List<Bombilla> listarBombillas() {

        return repo.listarBombillas();
    }

    public Bombilla buscarPorId(Long id) {
        LOGGER.info("Leo la bombilla" + id);
        return repo.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("No existe la bombilla con ID " + id));
    }

    public Bombilla toggle(Long id) {
        Bombilla b = repo.buscarPorId(id).orElseThrow(() -> new RuntimeException("No existe la bombilla " + id));
        b.setEncendida(!b.isEncendida());
        repo.update(b);
        return b;
    }

    public void delete(Long id) {
        repo.delete(id);
    }

}
