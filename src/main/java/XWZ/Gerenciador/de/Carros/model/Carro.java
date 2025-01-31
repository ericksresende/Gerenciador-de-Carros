package XWZ.Gerenciador.de.Carros.model;

public class Carro extends Veiculo {
    private int quantidadePortas;
    private String tipoCombustivel; // gasolina, etanol, diesel, flex

    // Getters e Setters
    public int getQuantidadePortas() {
        return quantidadePortas;
    }

    public void setQuantidadePortas(int quantidadePortas) {
        this.quantidadePortas = quantidadePortas;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
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

    @Override
        public String toString() {
            return "Carro{" +
                "id=" + getId() +
                ", modelo='" + getModelo() + '\'' +
                ", fabricante='" + getFabricante() + '\'' +
                ", ano=" + getAno() +
                ", preco=" + getPreco() +
                ", quantidadePortas=" + quantidadePortas +
                ", tipoCombustivel='" + tipoCombustivel + '\'' +
                '}';
        }
}
