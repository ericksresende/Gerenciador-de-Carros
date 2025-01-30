package XWZ.Gerenciador.de.Carros.model;

public class Moto extends Veiculo {
    private int cilindrada;

    // Getters e Setters
    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    @Override
    public String getModelo() {
        return super.getModelo();
    }

    @Override
    public String getFabricante() {
        return super.getFabricante();
    }

    @Override
    public int getAno() {
        return super.getAno();
    }

    @Override
    public double getPreco() {
        return super.getPreco();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public void setModelo(String modelo) {
        super.setModelo(modelo);
    }

    @Override
    public void setFabricante(String fabricante) {
        super.setFabricante(fabricante);
    }

    @Override
    public void setPreco(double preco) {
        super.setPreco(preco);
    }
}
