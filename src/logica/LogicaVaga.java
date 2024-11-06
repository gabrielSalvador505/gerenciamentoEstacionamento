package logica;

import app.Scan;
import objetos.Vaga;

import java.util.ArrayList;
import java.util.List;

public class LogicaVaga {

    public static List<Vaga> listaVagas = new ArrayList<Vaga>();

    public static void vagas() {
        Vaga vaga1 = new Vaga(222, 1);
        Vaga vaga2 = new Vaga(727, 1);
        Vaga vaga3 = new Vaga(774, 2);
        Vaga vaga4 = new Vaga(753, 3);

        listaVagas.add(vaga1);
        listaVagas.add(vaga2);
        listaVagas.add(vaga3);
        listaVagas.add(vaga4);
    }

    public static void adicionarVaga() {
        int numero;
        int tamanho;

        System.out.println("Número da vaga:");
        numero = Scan.sc.nextInt();

        System.out.println("Tamanho da vaga:\n[1]Pequena\n[2]Média\n[3]Grande\n");
        tamanho = Scan.sc.nextInt();

        Vaga novaVaga = new Vaga(numero, tamanho);
        listaVagas.add(novaVaga);
    }

    public static void removerVaga() {
        int numero;

        System.out.println("Número da vaga:");
        numero = Scan.sc.nextInt();
        Scan.sc.nextLine();

        listaVagas.removeIf(vaga -> vaga.getNumero() == numero);
    }

    public static void listarVagas() {
        for (Vaga vaga : listaVagas) {
            System.out.println(vaga.toString());
        }
    }

    public static void listarVagasPorTamanho(int tamanho) {
        for (Vaga vaga : listaVagas) {
            if (vaga.getTamanho() == tamanho) {
                System.out.println(vaga);
            }
        }
    }

    public static Vaga capturarVagaPorTamanho(int numero, int tamanho) {
        for (Vaga vaga : listaVagas) {
            if (vaga.getNumero() == numero && vaga.getTamanho() == tamanho && vaga.isDisponibilidade()) {
                return vaga;
            }
        }

        System.out.println("Vaga inválida!");
        return null;
    }

    public static void ocuparVaga(int numero) {
        for (Vaga vaga : listaVagas) {
            if (vaga.getNumero() == numero) {
                vaga.setDisponibilidade(false);
            }
        }
    }

    public static void desocuparVaga(int numero) {
        for (Vaga vaga : listaVagas) {
            if (vaga.getNumero() == numero) {
                vaga.setDisponibilidade(true);
            }
        }
    }




}
