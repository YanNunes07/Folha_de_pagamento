package views;

import model.Funcionario;

import java.util.Scanner;

public class TestFuncionario {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Funcionario f1 = new Funcionario();


        System.out.println("Digite seu nome");
        f1.nome = ler.nextLine();

        System.out.println("Digite seu CPF");
        f1.setCPF(ler.nextLine());

        System.out.println("Digite seu cargo");
        f1.setCargo(ler.nextLine());

        System.out.println("Quantidade de dependentes");
        f1.setDependentes(ler.nextDouble());

        System.out.println("Digite as horas trabalhadas por mes");
        f1.setQuantidadeDeHoras(ler.nextDouble());

        System.out.println("Digite o valor da hora:");
        f1.setValorHora(ler.nextDouble());

        do {
            System.out.println("tipo de insalubridade");
            System.out.println("1- Sem insalubridade");
            System.out.println("2- Insalubridade minima");
            System.out.println("3- Insalubridade media");
            System.out.println("4- Insalubridade maxima");
            f1.setInsalubridade(ler.nextInt());

        }while (f1.getInsalubridade()<1 || f1.getInsalubridade()>4);


        int opcao;
        do {
            System.out.println("");
            System.out.println("Escolha uma opção");

            opcao=ler.nextInt();
            switch (opcao){
                case 1:
                    System.out.println("Dados do funcionario:"+f1.toString());
                    break;
                case 2:
                    System.out.println("Salario bruto:"+f1.calcularSalarioBruto());
                    break;
                case 3:
                    System.out.println("Salario familia"+f1.quantidadesDeDependentes());
                    break;

                case 4:
                    System.out.println("vale transporte:"+f1.calcularVT());
                    break;

                case 5:
                    System.out.println("Ver insalubridade" +f1.calcularInsalubridade());
                    break;
                case 6:
                    System.out.println("Ver inss:"+f1.calcularInss());
                    break;
                case 7:
                    System.out.println("Ver salario Final"+f1.calcularSalarioLiquido());
                    break;
                case 8:
                    System.out.println("SAIR");
                    System.exit(0);

                default:System.out.println("Opção inválida...");
                    break;
            }

        }while (opcao!= 8);

        System.out.println(f1);


        System.out.println(f1.toString());
    }
}
