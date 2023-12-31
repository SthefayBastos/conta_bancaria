package conta_bancaria;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {

	static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {

		ContaController contas = new ContaController();
		int opcao, numero, agencia, tipo, aniver, numeroDestino;
		String titular = "";
		float saldo, limite,valor;

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

			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Digite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}
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
				System.out.println(Cores.TEXT_BLUE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND + "Criar conta\n\n");
				System.out.println("Digite o número da agência: ");
				agencia = leia.nextInt();

				System.out.println("Digite seu nome: ");
				leia.skip("\\R");
				titular = leia.nextLine();

				System.out.println("Digite o tipo de Conta: ");
				System.out.println(" 1 - Conta Corrente");
				System.out.println(" 2 - Conta Poupança");
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
				keyPress();
			}

			case 2 -> {
				System.out.println("Listar todas as Contas\n\n");

				contas.listarTodas();
				keyPress();
			}

			case 3 -> {

				System.out.println("Consultar dados da Conta -  por número\n\n");

				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();

				contas.procurarPorNum(numero);

				keyPress();
			}

			case 4 -> {
				System.out.println("Atualizar dados da Conta ");

				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();

				Optional<Conta> conta = contas.buscarNaCollection(numero);
				if (contas.buscarNaCollection(numero).isPresent()) {
					System.out.println(Cores.TEXT_BLUE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND+"Digite o número da agência: ");
					agencia = leia.nextInt();

					System.out.println("Digite seu nome: ");
					leia.skip("\\R");
					titular = leia.nextLine();

					tipo = conta.get().getTipo();

					System.out.println("Digite o depósito inicial da Conta: ");
					saldo = leia.nextFloat();

					switch (tipo) {
					case 1 -> {
						System.out.println("Digite o limite aprovado para a conta: ");
						limite = leia.nextFloat();
						contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
					}
					case 2 -> {
						System.out.println("Digite o aniversário de rendimento da conta: "+ Cores.TEXT_RESET);
						aniver = leia.nextInt();
						contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniver));

					}

					}
				} else
					System.out.println(Cores.TEXT_BLUE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND+"A conta " + numero + " não foi encontrada!");

				keyPress();
			}
			case 5 -> {
				System.out.println(Cores.TEXT_BLUE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND+"Apagar a Conta.\n\n");
				System.out.println(Cores.TEXT_BLUE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND+"Digite o número da conta: ");
				numero = leia.nextInt();

				contas.delete(numero);
				keyPress();
			}
			case 6 -> {
				System.out.println(Cores.TEXT_BLUE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND+"Saque\n");
				
				System.out.println(Cores.TEXT_BLUE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND+"Digite o número da conta: ");
				numero = leia.nextInt();
				
				System.out.println(Cores.TEXT_BLUE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND+"Digite o valor do saque: ");
				valor = leia.nextFloat();
				
				contas.sacar(numero, valor);
				keyPress();
			}

			case 7 -> {
				System.out.println(Cores.TEXT_BLUE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND+"Depóstito\n");
				
				System.out.println(Cores.TEXT_BLUE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND+"Saque\n");
				
				System.out.println(Cores.TEXT_BLUE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND+"Digite o número da conta: ");
				numero = leia.nextInt();
				
				System.out.println(Cores.TEXT_BLUE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND+"Digite o valor do depósito: ");
				valor = leia.nextFloat();
				
				contas.depositar(numero, valor);
				keyPress();
			}

			case 8 -> {
				System.out.println(Cores.TEXT_BLUE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND+"Transferência entre Contas\n\n");

				System.out.println(Cores.TEXT_BLUE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND+"Digite o número da Conta Origem: ");
				numero = leia.nextInt();
				
				System.out.println(Cores.TEXT_BLUE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND+"Digite o número da Conta Destino: ");
				numeroDestino = leia.nextInt();
				
				System.out.println(Cores.TEXT_BLUE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND+"Digite o valor da transfência: ");
				valor = leia.nextFloat();
				
				contas.transferir (numero, numeroDestino, valor);
				keyPress();
			}

			default -> {
				System.out.println(Cores.TEXT_RED_BOLD +"\n Opção Inválida!\n\n" + Cores.TEXT_RESET);
				keyPress();
			}
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

	public static void keyPress() {
		try {

			System.out.println(Cores.TEXT_BLUE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND+"Precione a tecla ENTER para continuar");
			System.in.read();

		} catch (IOException e) {
			System.out.println("Voce pressionou uma tecla inválida!" + Cores.TEXT_RESET);
		}

	}

}
