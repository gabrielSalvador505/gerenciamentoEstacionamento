package logica;

import app.Scan;
import objetos.Reserva;
import objetos.Vaga;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LogicaReserva {

    static List<Reserva> listaReservas = new ArrayList<Reserva>();
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

    public static void novoCheckin() {
        String placa;
        String modelo;
        int tamanho;
        int numeroVaga;
        LocalTime entrada;
        Vaga vaga;

        System.out.println("Placa do veículo: ");
        placa = Scan.sc.nextLine();

        System.out.println("Modelo: ");
        modelo = Scan.sc.nextLine();

        System.out.println("Tamanho:\n[1]Pequeno\n[2]Médio\n[3]Grande\n");
        tamanho = Scan.sc.nextInt();

        System.out.println("Selecione a vaga:");
        LogicaVaga.listarVagasPorTamanho(tamanho);
        numeroVaga = Scan.sc.nextInt();
        Scan.sc.nextLine();
        vaga = LogicaVaga.capturarVagaPorTamanho(numeroVaga, tamanho);
        LogicaVaga.ocuparVaga(numeroVaga);

        System.out.println("Hora de entrada: (HH:mm)");
        entrada = LocalTime.parse(Scan.sc.nextLine());

        Reserva novaReserva = new Reserva(placa, modelo, tamanho, entrada, vaga);
        listaReservas.add(novaReserva);
    }

    public static void checkout(){
        String placa;
        double valor;
        System.out.println("Informe a placa do veículo");
        placa = Scan.sc.nextLine();

        for (Reserva reserva : listaReservas) {
            if (reserva.getPlaca().equals(placa) && reserva.getSaida() == null) {
                System.out.println("Hora de saída: (HH:mm)");
                reserva.setSaida(LocalTime.parse(Scan.sc.nextLine(), formatter));
                valor = calcularValor(reserva.getEntrada(), reserva.getSaida());
                reserva.setValor(valor);
                LogicaVaga.desocuparVaga(reserva.getVaga().getNumero());

                System.out.println("Valor a pagar: R$" + valor);
            }
        }
    }

    public static void listarReservas() {
        for (Reserva reserva : listaReservas) {
            System.out.println(reserva.toString());
        }
    }

    public static void listarReservasAtivas() {
        for (Reserva reserva : listaReservas) {
            if (reserva.getSaida() == null) {
                System.out.println(reserva.toString());
            }
        }
    }

    public static double calcularValor(LocalTime in, LocalTime out) {
        Duration duracao = Duration.between(in, out);
        Duration umaHora = Duration.ofHours(1);
        Duration tresHoras = Duration.ofHours(3);

        if (duracao.compareTo(umaHora) <= 0) {
            return 5.00;
        } else if (duracao.compareTo(tresHoras) <= 0) {
            return 10.00;
        } else {
            return 15.00;
        }
    }
}
