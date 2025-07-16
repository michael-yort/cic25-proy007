package es.cic.curso25.proy007.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import es.cic.curso25.proy007.model.Bombilla;
import es.cic.curso25.proy007.service.BombillaService;

@RestController
@RequestMapping("/bombilla")
public class BombillaController {

    @Autowired
    private BombillaService service;

    @GetMapping
    public List<Bombilla> listarBombillas() {
        return service.listarBombillas();
    }

    @PostMapping("/{id}/toggle")
    public Bombilla toggle(@PathVariable Long id) {
        return service.toggle(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
