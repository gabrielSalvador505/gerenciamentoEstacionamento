package objetos;

public class Vaga {

    private int numero;
    private int tamanho;
    private boolean disponibilidade;

    public Vaga() {

    }

    public Vaga(int numero, int tamanho) {
        this.numero = numero;
        this.tamanho = tamanho;
        this.disponibilidade = true;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    private String transformaTamanho(int tamanho) {
        return switch (tamanho) {
            case 1 -> "Pequena";
            case 2 -> "Média";
            case 3 -> "Grande";
            default -> "";
        };
    }

    @Override
    public String toString() {
        return  "Numero: " + numero +
                "| Tamanho: " + transformaTamanho(tamanho) +
                "| Disponibilidade: " + disponibilidade;
    }
}
