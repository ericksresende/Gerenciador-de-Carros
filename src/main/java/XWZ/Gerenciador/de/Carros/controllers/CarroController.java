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