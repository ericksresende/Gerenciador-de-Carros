package XWZ.Gerenciador.de.Carros.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import XWZ.Gerenciador.de.Carros.model.Carro;
import XWZ.Gerenciador.de.Carros.repository.VeiculoRepository;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @GetMapping
    public List<Carro> listarCarros() {
        return veiculoRepository.listarCarros();
    }

    @PostMapping
    public void adicionarCarro(@RequestBody Carro carro) {
        veiculoRepository.salvarCarro(carro);
    }

    @DeleteMapping("/{id}")
    public void excluirCarro(@PathVariable int id) {
        veiculoRepository.excluirCarro(id);
    }
}