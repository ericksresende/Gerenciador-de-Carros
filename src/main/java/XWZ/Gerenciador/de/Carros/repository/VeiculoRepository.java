import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class VeiculoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void salvarCarro(Carro carro) {
        String sql = "INSERT INTO carro (modelo, fabricante, ano, preco, quantidade_portas, tipo_combustivel) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, carro.getModelo(), carro.getFabricante(), carro.getAno(), carro.getPreco(), carro.getQuantidadePortas(), carro.getTipoCombustivel());
    }

    public void salvarMoto(Moto moto) {
        String sql = "INSERT INTO moto (modelo, fabricante, ano, preco, cilindrada) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, moto.getModelo(), moto.getFabricante(), moto.getAno(), moto.getPreco(), moto.getCilindrada());
    }

    public List<Carro> listarCarros() {
        String sql = "SELECT * FROM carro";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Carro carro = new Carro();
            carro.setId(rs.getInt("id"));
            carro.setModelo(rs.getString("modelo"));
            carro.setFabricante(rs.getString("fabricante"));
            carro.setAno(rs.getInt("ano"));
            carro.setPreco(rs.getDouble("preco"));
            carro.setQuantidadePortas(rs.getInt("quantidade_portas"));
            carro.setTipoCombustivel(rs.getString("tipo_combustivel"));
            return carro;
        });
    }

    public List<Moto> listarMotos() {
        String sql = "SELECT * FROM moto";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Moto moto = new Moto();
            moto.setId(rs.getInt("id"));
            moto.setModelo(rs.getString("modelo"));
            moto.setFabricante(rs.getString("fabricante"));
            moto.setAno(rs.getInt("ano"));
            moto.setPreco(rs.getDouble("preco"));
            moto.setCilindrada(rs.getInt("cilindrada"));
            return moto;
        });
    }

    public void excluirCarro(int id) {
        String sql = "DELETE FROM carro WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public void excluirMoto(int id) {
        String sql = "DELETE FROM moto WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}