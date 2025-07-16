package es.cic.curso25.proy007.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import es.cic.curso25.proy007.model.Bombilla;
import es.cic.curso25.proy007.service.BombillaService;

@RestController
@RequestMapping("/bombilla")
public class BombillaController {

    @Autowired
    private BombillaService service;

    // Listar todas las bombillas
    @GetMapping
    public List<Bombilla> listar() {
        return service.listarBombillas();
    }

    // Ver una bombilla por ID
    @GetMapping("/{id}")
    public Bombilla verPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // Crear nueva bombilla
    @PostMapping
    public long crear(@RequestBody Bombilla bombilla) {
        return service.create(bombilla);
    }

    // Encender o apagar la bombilla   SOLO FUNCIONA DESDE LINEA DE COMANDOS curl -X POST http://localhost:8080/bombilla/1/toggle

    @PostMapping("/{id}/toggle")
    public Bombilla toggle(@PathVariable Long id) {
        return service.toggle(id);
    }

    // Eliminar una bombilla
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.delete(id);
    }
}
