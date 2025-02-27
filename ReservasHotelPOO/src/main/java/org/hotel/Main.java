package org.hotel;

import org.hotel.Entidades.Quarto;
import org.hotel.Entidades.Reserva;
import org.hotel.Filhas.Hospede;
import org.hotel.Filhas.QuartoLuxo;
import org.hotel.Filhas.QuartoSimples;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hotel hotel = new Hotel("HotelPOO");

        String numeroQuarto, nomeHospede, cpfHospede, telefoneHospede;
        double valorQuarto;
        int id_hospede, id_quarto, id_reserva;
        String checkInStr, checkOutStr;
        int opcao = 0;

        while(opcao != -1){
            System.out.println("Digite a opção desejada");
            System.out.println("1 - Listar Quartos");
            System.out.println("2 - Adicionar Quarto Simples");
            System.out.println("3 - Adicionar Quarto de Luxo");
            System.out.println("4 - Editar Quarto");
            System.out.println("5 - Deletar Quarto");
            System.out.println("-------------------------------");
            System.out.println("6 - Listar Hospedes");
            System.out.println("7 - Adicionar Hospede");
            System.out.println("8 - Editar Hospede");
            System.out.println("9 - Deletar Hospede");
            System.out.println("-------------------------------");
            System.out.println("10 - Listar Reservas");
            System.out.println("11 - Adicionar Reservas");
            System.out.println("12 - Editar Reservas");
            System.out.println("13 - Deletar Reservas");
            System.out.println("-------------------------------");
            System.out.println("14 - Gerar Nota Fiscal");
            System.out.println("-------------------------------");
            System.out.println("-1 - Para Sair");
            System.out.println("-------------------------------");


            opcao = sc.nextInt();
            switch(opcao){
                case 1:
                    List<Quarto> quartos = hotel.listarQuartos();
                    System.out.println("-------------------------------");
                    for(Quarto quarto : quartos){
                        System.out.print("id quarto: " + quarto.getId() + " ");
                        System.out.print("numero: " + quarto.getNumero() + " ");
                        System.out.print("valor: " + quarto.getValor() + " ");
                        System.out.println("ocupado? " + quarto.isOcupado() + " ");
                    }
                    break;
                case 2:
                    System.out.println("Digite o número do quarto:");
                    numeroQuarto = sc.next();
                    System.out.println("Digite o valor da diária:");
                    valorQuarto = sc.nextDouble();
                    QuartoSimples quartoSimples = new QuartoSimples(numeroQuarto, valorQuarto);
                    hotel.addQuartoSimples(quartoSimples);
                    break;
                case 3:
                    System.out.println("Digite o número do quarto:");
                    numeroQuarto = sc.next();
                    System.out.println("Digite o valor da diária:");
                    valorQuarto = sc.nextDouble();
                    QuartoLuxo quartoLuxo = new QuartoLuxo(numeroQuarto, valorQuarto);
                    hotel.addQuartoLuxo(quartoLuxo);
                    break;
                case 4:
                    System.out.println("Digite o id do quarto a ser editado");
                    id_quarto = sc.nextInt();
                    System.out.println("Digite o número do quarto:");
                    numeroQuarto = sc.next();
                    System.out.println("Digite o valor da diária:");
                    valorQuarto = sc.nextDouble();
                    QuartoSimples quarto = new QuartoSimples(numeroQuarto, valorQuarto);
                    hotel.editarQuarto(id_quarto, quarto);
                    break;
                case 5:
                    System.out.println("Digite o id do quarto a ser excluida:");
                    id_quarto = sc.nextInt();
                    hotel.deletarQuarto(id_quarto);
                    break;
                case 6:
                    List<Hospede> hospedes = hotel.listarHospedes();
                    System.out.println("-------------------------------");
                    for(Hospede hospede : hospedes){
                        System.out.print("id hospede: " + hospede.getId() + " ");
                        System.out.print("nome: " + hospede.getNome() + " ");
                        System.out.print("cpf: " + hospede.getCpf() + " ");
                        System.out.println("telefone: " + hospede.getTelefone() + " ");
                    }
                    break;
                case 7:
                    System.out.println("Digite o nome do Hóspede");
                    nomeHospede = sc.next();
                    System.out.println("Digite o CPF do Hóspede");
                    cpfHospede = sc.next();
                    System.out.println("Digite o telefone do Hóspede");
                    telefoneHospede = sc.next();
                    Hospede hospede = new Hospede(nomeHospede, cpfHospede, telefoneHospede);
                    hotel.addHospede(hospede);
                    break;
                case 8:
                    System.out.println("Digite o id do hospede a ser editado");
                    id_hospede = sc.nextInt();
                    System.out.println("Digite o nome do Hóspede");
                    nomeHospede = sc.next();
                    System.out.println("Digite o CPF do Hóspede");
                    cpfHospede = sc.next();
                    System.out.println("Digite o telefone do Hóspede");
                    telefoneHospede = sc.next();
                    Hospede hospedeObj = new Hospede(nomeHospede, cpfHospede, telefoneHospede);
                    hotel.editarHospede(id_hospede, hospedeObj);
                    break;
                case 9:
                    System.out.println("Digite o id do hospede a ser excluida:");
                    id_hospede = sc.nextInt();
                    hotel.deletarHospede(id_hospede);
                    break;
                case 10:
                    List<Reserva> reservas = hotel.listarReservas();
                    System.out.println("-------------------------------");
                    for(Reserva reserva : reservas){
                        System.out.print("id: " + reserva.getId() + " ");
                        System.out.print("id_hospede: " + reserva.getId_hospede() + " ");
                        System.out.print("id_quarto: " + reserva.getId_quarto() + " ");
                        System.out.print("data In: " + reserva.getDataChekIn() + " ");
                        System.out.println("data Out: " + reserva.getDataCheckOut() + " ");
                    }
                    break;
                case 11:
                    System.out.println("Digite o id do Hóspede:");
                    id_hospede = sc.nextInt();
                    System.out.println("Digite o id do quarto");
                    id_quarto = sc.nextInt();
                    System.out.println("Digite a data do checkIn (YYYY-MM-DD)");
                    checkInStr = sc.next();
                    System.out.println("Digite a data do checkOut (YYYY-MM-DD)");
                    checkOutStr = sc.next();
                    Reserva reservaObj = new Reserva(id_hospede, id_quarto, Date.valueOf(checkInStr), Date.valueOf(checkOutStr));
                    hotel.addReserva(reservaObj);
                    break;
                case 12:
                    System.out.println("Digite o id da reserva a ser editada:");
                    id_reserva = sc.nextInt();
                    System.out.println("Digite o id do Hóspede:");
                    id_hospede = sc.nextInt();
                    System.out.println("Digite o id do quarto");
                    id_quarto = sc.nextInt();
                    System.out.println("Digite a data do checkIn (YYYY-MM-DD)");
                    checkInStr = sc.next();
                    System.out.println("Digite a data do checkOut (YYYY-MM-DD)");
                    checkOutStr = sc.next();
                    Reserva reserva = new Reserva(id_hospede, id_quarto, Date.valueOf(checkInStr), Date.valueOf(checkOutStr));
                    hotel.editarReserva(id_reserva, reserva);
                    break;
                case 13:
                    System.out.println("Digite o id da reserva a ser excluida:");
                    id_reserva = sc.nextInt();
                    hotel.deletarReserva(id_reserva);
                    break;
                case 14:
                    Pagamento pagamento = new NotaFiscal();
                    System.out.println("Para gerar Nota Fiscal, digite o id da reserva:");
                    id_reserva = sc.nextInt();
                    pagamento.exibirNota(id_reserva);
                    break;
                case -1:
                    System.out.println("Fechando o sistema...");
                    break;
            }
        }
    }
}