package es.cic.curso25.proy007.repository;

import java.util.*;
import org.springframework.stereotype.Repository;
import es.cic.curso25.proy007.model.Bombilla;

@Repository
public class BombillaRepositoryImpl {

    private Map<Long, Bombilla> bombillas = new HashMap<>();

    public BombillaRepositoryImpl() {
        // Inicializamos 3 bombillas al iniciar la app
        Bombilla b1 = new Bombilla(1L, 60, "LED", false);
        Bombilla b2 = new Bombilla(2L, 75, "Halógena", false);
        Bombilla b3 = new Bombilla(3L, 100, "Incandescente", false);

        bombillas.put(1L, b1);
        bombillas.put(2L, b2);
        bombillas.put(3L, b3);
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

    public boolean update(Bombilla bombilla) {
        if (bombillas.containsKey(bombilla.getId())) {
            bombillas.put(bombilla.getId(), bombilla);
            return true;// Actualizado con exito
        }
        return false;
    }

    // Este método ahora empieza en el último ID usado (3) + 1
    private long getNextId() {
        return bombillas.keySet().stream().max(Long::compare).orElse(0L) + 1;
    }

    // Si aún quieres permitir crear más bombillas manualmente:
    public long create(Bombilla bombilla) {
        long id = getNextId();
        bombilla.setId(id);
        bombilla.setEncendida(false); // Apagada por defecto
        bombillas.put(id, bombilla);
        return id;
    }
}
