
//Classe de ultilidade que gerencia instancias do tipo Reserva, e ,
// contem metodos relacionados a interface de usuario

import java.util.Objects;
import java.util.Scanner;

public class InterfaceUsuario {

    public static Reserva[] listaReservas = new  Reserva[10]; //lista de reservas, max 10
    private static int indiceReserva;// indice auxiliar para marcar o numero de reservas feitas


    //Cria a interface de usuario inicial e retorna o int com a opçao escolhida
    private static int menu(){
        Scanner sc = new Scanner(System.in);
        int opcao;
        System.out.println("MENU PRINCIPAL");
        System.out.println();
        System.out.println("1. Nova reserva" + "\n2. Listar Reservas");
        System.out.println("3. Buscar Reserva por nome do hospede" + "\n4. Ordenar reserva po numero de dias (Decrescente)");
        System.out.println("0. Sair");
        opcao = sc.nextInt();

        return opcao;
    }

    //recebe o valor selecionado do menu, e entao, redireciona para metodo relacionado a escolha

    public static void selecao() {

        int opcao;

        do{
            opcao = menu();
            if(opcao > 4){
                System.out.println("Digite uma opçao valida");
                continue;
            }
            switch (opcao) {

                case 1:
                    addReservas();
                    continue;

                case 2:
                    listarReservas();
                    continue;

                case 3:
                    buscarReserva();
                    continue;

                case 4:
                    ordenaReservas();

                case 0:
                    break;
            }
        } while (opcao > 0);
    }

//Recebe input do usuario e cria uma nova reserva, e adiciona a lista
    public static void addReservas(){
        Scanner sc =  new Scanner(System.in);
        System.out.println("Digite o nome do hospede: ");
        String nomeHospede = sc.nextLine();
        System.out.println("Digite o tipo de quarto: ");
        String tipoQuarto = sc.nextLine();
        System.out.println("Digite o numero de dias: ");
        int numeroDias = sc.nextInt();
        System.out.println("Digite o valor da diaria: ");
        double valorDiaria = sc.nextDouble();
        listaReservas[indiceReserva] = new Reserva(nomeHospede, tipoQuarto , numeroDias , valorDiaria);
        indiceReserva++;
    }

    //Imprime todas as reservas na lista
    private static void listarReservas(){
        for(int i = 0; i < listaReservas.length; i++){
            if(listaReservas[i] == null){
                break;
            }
            System.out.println(listaReservas[i]);
        }
    }
//Busca por nome o cliente hospedado no hotel, comparando as Strings
    private static void buscarReserva(){
        Scanner sc =  new Scanner(System.in);
        System.out.println("Digite o nome do hospede: ");
        String nomeHospede = sc.nextLine();
        boolean encontrado = false;

        for (Reserva listaReserva : listaReservas) {
            if (listaReserva == null){
                continue;
            }
            if (nomeHospede.equalsIgnoreCase(listaReserva.getNomeHospede())) {
                System.out.println(listaReserva);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {

            System.out.println("Hospede nao foi encontrado");

        }

    }
//usa um bubble sort para ordenar de forma decrescente baseado no numero de dias da estadia do hospede
    private static void ordenaReservas(){
        Reserva aux;
        for(int i = 0; i < listaReservas.length; i++){
            for(int j = i; j < listaReservas.length; j++){
                if (listaReservas[j] == null || listaReservas[i] == null){
                    continue;
                }
                if(listaReservas[j].getNumeroDias() > listaReservas[i].getNumeroDias()){
                    aux = listaReservas[i];
                    listaReservas[i] = listaReservas[j];
                    listaReservas[j] = aux;
                }
            }
        }

    }

    //retorna a reserva na posiçao i
    private static Reserva getReservas(int i){
        return  listaReservas[i];
    }







}


