package app;

import logica.LogicaReserva;
import logica.LogicaVaga;

public class Menu {

    public static void menu() {
        int opc = 0;
        int opc2 = 0;

        do {
            opc = header();
            Scan.sc.nextLine();
            switch (opc) {
                case 1:
                    do {
                        opc2 = headerVaga();
                        Scan.sc.nextLine();
                        switch (opc2) {
                            case 1:
                                LogicaVaga.adicionarVaga();
                                break;
                            case 2:
                                LogicaVaga.removerVaga();
                                break;
                            case 3:
                                LogicaVaga.listarVagas();
                                break;
                            default:
                                break;
                        }
                    } while (opc2 != 0);
                    break;
                case 2:
                    do {
                        opc2 = headerReserva();
                        Scan.sc.nextLine();
                        switch (opc2) {
                            case 1:
                                LogicaReserva.novoCheckin();
                                break;
                            case 2:
                                LogicaReserva.listarReservasAtivas();
                                LogicaReserva.checkout();
                                break;
                            case 3:
                                LogicaReserva.listarReservas();
                                break;
                            default:
                                break;
                        }
                    } while (opc2 != 0);
                    break;
            }
        } while (opc!=0);

    }

    public static int header() {
        System.out.println("-- ESTACIONAMENTO --");
        System.out.println("1. Vaga | 2. Reserva");
        return Scan.sc.nextInt();
    }

    public static int headerReserva() {
        System.out.println("-- RESERVA --");
        System.out.println("1. Check-in");
        System.out.println("2. Check-out");
        System.out.println("3. Listar");
        System.out.println("0. Voltar");
        return Scan.sc.nextInt();
    }

    public static int headerVaga() {
        System.out.println("-- VAGA --");
        System.out.println("1. Adicionar");
        System.out.println("2. Remover");
        System.out.println("3. Listar");
        System.out.println("0. Voltar");
        return Scan.sc.nextInt();
    }
}
