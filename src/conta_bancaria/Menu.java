package conta_bancaria;



import java.util.Scanner;

import conta_bancaria.model.Conta;
import conta_bancaria.util.Cores;

public class Menu {

	static Scanner leia = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		//Criar objetos da classe conta para testes
		
		Conta c1 = new Conta(1 , 123 , 1 ,"Victória Moraes" ,10000.0f);
		c1.visualizar();
		c1.sacar(12000.0f);
		c1.visualizar();
		c1.depositar(5000.0f);
		c1.visualizar();
		
		
		int opcao ;
		
		
		while (true) {
			
			
			System.out.println(Cores.TEXT_BLUE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND
			                  +"|---------------------------------------------|");
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
			System.out.println("|                                             |" + Cores.TEXT_RESET);

			opcao = leia.nextInt();
			
			if (opcao == 9) {
				System.out.println(Cores.TEXT_BLUE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND
		                  +"|---------------------------------------------------------|");	
				System.out.println(Cores.TEXT_BLUE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND + "| Banco X9 - Sua vida financeira em destaque!             |");
					sobre();
			leia.close();
					System.exit(0);
			}
		switch (opcao) {
			case 1 -> 
				System.out.println( "Criar conta\n\n");
			
			case 2 ->
				System.out.println( "Listar todas as Contas\n\n");
			
			case 3 -> 
				System.out.println( "Consultar dados da Conta -  por número\n\n");
			
			case 4 ->
				System.out.println( "Atualizar dados da Conta ");
			
			case 5 ->
				System.out.println( "Apagar a Conta.\n\n");
				
			case 6 ->
				System.out.println( "Saque\n");
				
			case 7 -> 
				System.out.println("Depóstito\n");
			
			case 8 ->
				System.out.println( "Transferência entre Contas\n\n");
				
				default ->
					System.out.println( "\n Opção Inválida!\n\n");
			}
		}
	}
	public static void sobre() {
		
		System.out.println  (Cores.TEXT_BLUE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND
		                  +"|---------------------------------------------------------|");
		System.out.println("|Projeto Desenvolvido por: Sthefany Sousa                 |");
		System.out.println("|Sthefany Sousa -  sthefanysousageneration@gmail.com      |");
		System.out.println("|https://github.com/SthefayBastos                         |");
		System.out.println("|---------------------------------------------------------|");
	}
}
