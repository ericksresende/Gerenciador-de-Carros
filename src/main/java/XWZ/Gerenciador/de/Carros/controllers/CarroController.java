package XWZ.Gerenciador.de.Carros.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import XWZ.Gerenciador.de.Carros.model.Carro;
import XWZ.Gerenciador.de.Carros.repository.VeiculoRepository;

import java.util.List;

@RestController
@RequestMapping("/carros")
@CrossOrigin(origins = "http://localhost:5500")
public class CarroController {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @GetMapping
    public List<Carro> listarCarros() {
        return veiculoRepository.listarCarros();
    }

    @GetMapping("/{id}")
    public Carro getCarro(@PathVariable int id) {
        return veiculoRepository.buscarCarroPorId(id);  // Chama o método que implementamos
    }

    @PostMapping
    public ResponseEntity<Carro> adicionarCarro(@RequestBody Carro carro) {
        veiculoRepository.salvarCarro(carro);  // Salva o carro no banco
        return ResponseEntity.status(HttpStatus.CREATED).body(carro);  // Retorna o carro criado com status 201
    }

    @DeleteMapping("/{id}")
    public void excluirCarro(@PathVariable int id) {
        veiculoRepository.excluirCarro(id);
    }

    @PutMapping("/{id}")
    public void editarCarro(@PathVariable int id, @RequestBody Carro carro) {
        System.out.println(id);
        System.out.println(carro);
        carro.setId(id);
        System.out.println(carro);
        veiculoRepository.salvarCarro(carro);
    }
}
