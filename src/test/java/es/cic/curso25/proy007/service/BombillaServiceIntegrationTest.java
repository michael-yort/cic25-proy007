package es.cic.curso25.proy007.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.cic.curso25.proy007.model.Bombilla;

@SpringBootTest
public class BombillaServiceIntegrationTest {

    @Autowired
    private BombillaService bombillaService;

    @Test
    void testBuscarPorId() {
        Bombilla bombillaTest = bombillaService.buscarPorId(3L);
        long id = bombillaTest.getId();

        assertEquals(3L, id);
    }

    @Test
    void testCreate() {
        Bombilla bombillaTest = new Bombilla();
        bombillaTest.setEncendida(true);
        bombillaTest.setPotencia(20);
        bombillaTest.setTipo("LED");

        long id = bombillaService.create(bombillaTest);

        assertTrue(id > 0);
    }

    @Test
    @Disabled
    void testDelete() {
        bombillaService.delete(3L);
        List<Bombilla> bombillas = bombillaService.listarBombillas();
        long longitud = bombillas.size();

        assertEquals(2, longitud);
    }

    @Test
    void testListarBombillas() {
        List<Bombilla> bombillas = bombillaService.listarBombillas();
        long longitud = bombillas.size();

        assertEquals(3, longitud);
    }

    @Test
    void testToggle() {
        Bombilla bombilla = bombillaService.buscarPorId(1L);
        bombilla.setEncendida(false);
        long id = bombilla.getId();

        bombillaService.toggle(id);
        boolean estado = bombilla.isEncendida();

        assertTrue(estado == true);
    }
}
