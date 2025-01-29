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