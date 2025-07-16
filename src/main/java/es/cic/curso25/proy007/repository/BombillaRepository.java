package es.cic.curso25.proy007.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.cic.curso25.proy007.model.Bombilla;

@Repository
public class BombillaRepository {

    private Map<Long, Bombilla> bombillas = new HashMap<>();

    public long create(Bombilla bombilla) {
        long id = getNextId();
        bombilla.setId(id);
        bombilla.setEncendida(false); // Apagada por defecto
        bombillas.put(id, bombilla);
        return id;
    }

  
    public List<Bombilla> listarBombillas() {
        return new ArrayList<>(bombillas.values());
    }

    public Optional<Bombilla> buscarPorId(Long id) {
        return Optional.ofNullable(bombillas.get(id));
    }

    public void delete(Long id) {
        bombillas.remove(id);
    }

    public void update(Bombilla bombilla) {
        bombillas.put(bombilla.getId(), bombilla);
    }

    private long getNextId() {
       
        return bombillas.keySet().stream().max(Long::compare).orElse(0L) + 1;
    }

}
