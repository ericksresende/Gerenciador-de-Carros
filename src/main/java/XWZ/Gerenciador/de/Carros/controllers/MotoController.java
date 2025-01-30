package XWZ.Gerenciador.de.Carros.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import XWZ.Gerenciador.de.Carros.model.Moto;
import XWZ.Gerenciador.de.Carros.repository.VeiculoRepository;

@RestController
@RequestMapping("/motos")
public class MotoController {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @GetMapping
    public List<Moto> listarMotos() {
        return veiculoRepository.listarMotos();
    }

    @PostMapping
    public void adicionarMoto(@RequestBody Moto moto) {
        veiculoRepository.salvarMoto(moto);
    }

    @DeleteMapping("/{id}")
    public void excluirMoto(@PathVariable int id) {
        veiculoRepository.excluirMoto(id);
    }
}