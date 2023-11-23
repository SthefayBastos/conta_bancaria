package conta_bancaria;

import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {

	static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {

		ContaController contas = new ContaController();
		int opcao, numero, agencia, tipo, aniver;
		String titular = "";
		float saldo, limite;

		while (true) {

			System.out.println(Cores.TEXT_BLUE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND
					+ "|---------------------------------------------|");
			System.out.println("|                                             |");
			System.out.println("|                   BANCO X9                  |");
			System.out.println("|                                             |");
			System.out.println("|---------------------------------------------|");
			System.out.println("|                                             |");
			System.out.println("|       1 - Criar Conta                       |");
			System.out.println("|       2 - Listar todas as Contas            |");
			System.out.println("|       3 - Buscar conta por Número           |");
			System.out.println("|       4 - Atualizar Dados da conta          |");
			System.out.println("|       5 - Apagar Conta                      |");
			System.out.println("|       6 - Sacar                             |");
			System.out.println("|       7 - Depositar                         |");
			System.out.println("|       8 - Transferir valores entre Contas   |");
			System.out.println("|       9 - Sair                              |");
			System.out.println("|                                             |");
			System.out.println("|---------------------------------------------|");
			System.out.println("| Entre com a opção desejada:                 |");
			System.out.println("|---------------------------------------------|" + Cores.TEXT_RESET);

			opcao = leia.nextInt();

			if (opcao == 9) {
				System.out.println(Cores.TEXT_BLUE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND
						+ "|---------------------------------------------------------|");
				System.out.println(Cores.TEXT_BLUE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND
						+ "| Banco X9 - Sua vida financeira em destaque!             |");
				sobre();
				leia.close();
				System.exit(0);
			}
			switch (opcao) {
			case 1 -> {
				System.out.println(Cores.TEXT_BLUE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND+
						"Criar conta\n\n");
				System.out.println("Digite o número da agência: ");
				agencia = leia.nextInt();

				System.out.println("Digite seu nome: ");
				leia.skip("\\R");
				titular = leia.nextLine();

				System.out.println("Digite o tipo de Conta ( 1 - CC ou 2 - CP) ");
				tipo = leia.nextInt();

				System.out.println("Digite o depósito inicial da Conta: ");
				saldo = leia.nextFloat();

				switch (tipo) {
				case 1 -> {
					System.out.println("Digite o limite aprovado para a conta: ");
					limite = leia.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}
				case 2 -> {
					System.out.println("Digite o aniversário de rendimento da conta: ");
					aniver = leia.nextInt();
					contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniver));
				}
				}
			}
			
			case 2 -> {
				System.out.println("Listar todas as Contas\n\n");
			
				contas.listarTodas();
			}
				
			case 3 -> 
			{
			
				System.out.println("Consultar dados da Conta -  por número\n\n");
			
				
			}
			
			
			case 4 -> System.out.println("Atualizar dados da Conta ");

			case 5 -> System.out.println("Apagar a Conta.\n\n");

			case 6 -> System.out.println("Saque\n");

			case 7 -> System.out.println("Depóstito\n");

			case 8 -> System.out.println("Transferência entre Contas\n\n");

			default -> System.out.println("\n Opção Inválida!\n\n"+ Cores.TEXT_RESET);
			}
		}
	}

	public static void sobre() {

		System.out.println(Cores.TEXT_BLUE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND
				+ "|---------------------------------------------------------|");
		System.out.println("|Projeto Desenvolvido por: Sthefany Sousa                 |");
		System.out.println("|Sthefany Sousa -  sthefanysousageneration@gmail.com      |");
		System.out.println("|https://github.com/SthefayBastos                         |");
		System.out.println("|---------------------------------------------------------|");
	}
}
