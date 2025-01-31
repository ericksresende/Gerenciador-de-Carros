package XWZ.Gerenciador.de.Carros.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import XWZ.Gerenciador.de.Carros.model.Carro;
import XWZ.Gerenciador.de.Carros.model.Moto;

import java.util.List;

@Repository
public class VeiculoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void salvarCarro(Carro carro) {
        String sql;
        if (carro.getId() == 0) {
            // Se o ID for 0, insere um novo carro
            sql = "INSERT INTO carro (modelo, fabricante, ano, preco, quantidade_portas, tipo_combustivel) VALUES (?, ?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql, carro.getModelo(), carro.getFabricante(), carro.getAno(), carro.getPreco(), carro.getQuantidadePortas(), carro.getTipoCombustivel());
        } else {
            // Se o ID não for 0, atualiza o carro existente
            sql = "UPDATE carro SET modelo = ?, fabricante = ?, ano = ?, preco = ?, quantidade_portas = ?, tipo_combustivel = ? WHERE id = ?";
            jdbcTemplate.update(sql, carro.getModelo(), carro.getFabricante(), carro.getAno(), carro.getPreco(), carro.getQuantidadePortas(), carro.getTipoCombustivel(), carro.getId());
        }
    }
    

    public void salvarMoto(Moto moto) {
        String sql;
        if (moto.getId() == 0) {
            // Se o ID for 0, insere uma nova moto
            sql = "INSERT INTO moto (modelo, fabricante, ano, preco, cilindrada) VALUES (?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql, moto.getModelo(), moto.getFabricante(), moto.getAno(), moto.getPreco(), moto.getCilindrada());
        } else {
            // Se o ID não for 0, atualiza a moto existente
            sql = "UPDATE moto SET modelo = ?, fabricante = ?, ano = ?, preco = ?, cilindrada = ? WHERE id = ?";
            jdbcTemplate.update(sql, moto.getModelo(), moto.getFabricante(), moto.getAno(), moto.getPreco(), moto.getCilindrada(), moto.getId());
        }
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

    public Carro buscarCarroPorId(int id) {
        String sql = "SELECT * FROM carro WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
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

    public Moto buscarMotoPorId(int id) {
        String sql = "SELECT * FROM moto WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
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
}
