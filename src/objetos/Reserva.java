package objetos;

import java.time.LocalTime;

public class Reserva {

    private String placa;
    private String modelo;
    private int tamanho;
    private LocalTime entrada;
    private LocalTime saida;
    private Vaga vaga;
    private double valor;


    public Reserva(String placa, String modelo, int tamanho, LocalTime entrada, Vaga vaga) {
        this.placa = placa;
        this.modelo = modelo;
        this.tamanho = tamanho;
        this.entrada = entrada;
        this.vaga = vaga;
        this.saida = null;
        this.valor = 0;
    }

    public Reserva() {

    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public LocalTime getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalTime entrada) {
        this.entrada = entrada;
    }

    public LocalTime getSaida() {
        return saida;
    }

    public void setSaida(LocalTime saida) {
        this.saida = saida;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    private String transformaTamanho(int tamanho) {
        return switch (tamanho) {
            case 1 -> "Pequeno";
            case 2 -> "Médio";
            case 3 -> "Grande";
            default -> "";
        };
    }

    @Override
    public String toString() {
        return  "Placa: " + placa +
                "| Modelo: " + modelo +
                "| Tamanho: " + transformaTamanho(tamanho) +
                "| Entrada: " + entrada +
                "| Saida: " + saida +
                "| Valor: R$" + valor;
    }
}
