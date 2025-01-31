package XWZ.Gerenciador.de.Carros.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import XWZ.Gerenciador.de.Carros.model.Moto;
import XWZ.Gerenciador.de.Carros.repository.VeiculoRepository;

import java.util.List;

@RestController
@RequestMapping("/motos")
@CrossOrigin(origins = "*") 
public class MotoController {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @GetMapping
    public List<Moto> listarMotos() {
        return veiculoRepository.listarMotos();
    }

    @GetMapping("/{id}")
    public Moto getMoto(@PathVariable int id) {
        return veiculoRepository.buscarMotoPorId(id);
    }


    @PostMapping
    public ResponseEntity<Void> adicionarMoto(@RequestBody Moto moto) {
        veiculoRepository.salvarMoto(moto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public void excluirMoto(@PathVariable int id) {
        veiculoRepository.excluirMoto(id);
    }

    @PutMapping("/{id}")
    public void editarMoto(@PathVariable int id, @RequestBody Moto moto) {
        moto.setId(id);
        veiculoRepository.salvarMoto(moto);
    }
}
