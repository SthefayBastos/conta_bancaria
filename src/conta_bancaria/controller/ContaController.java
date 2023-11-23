package conta_bancaria.controller;

import java.util.ArrayList;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;

public class ContaController implements ContaRepository{

	//Criar Collection
	
	private ArrayList <Conta>listaContas = new ArrayList<Conta>();
	
	
	// Variável para receber o número da conta para automatizar o processo de definir o número de cada conta.
	int numero = 0;
	
	@Override
	public void procurarPorNum(int numero) {
		
		var conta = buscarNaCollection(numero);
	
		if (conta != null)
			conta.visualizar();
		else
			System.out.println("A conta número " + numero + "não foi encontrada!");
	}

	@Override
	public void listarTodas() {
			for (var conta : listaContas) {
					conta.visualizar();
			}
		
	}

	@Override
	public void cadastrar(Conta conta) {
			listaContas.add(conta);
			System.out.println("A conta número " + conta.getNumero() + "foi criada com sucesso!");
		
	}

	@Override
	public void atualizar(Conta conta) {
		
		
	}

	@Override
	public void delete(int numero) {
		var conta = buscarNaCollection(numero);
		
		if (conta != null)
			if(listaContas.remove(conta)== true)
				System.out.println("A conta: " + numero + "foi excluída com sucesso!");
		else
			System.out.println("A conta número " + numero + "não foi encontrada!");
		
	}

	@Override
	public void sacar(int numero, float valor) {
		
		
	}

	@Override
	public void depositar(int numero, float valor) {
		
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		
		
	}

	//Métodos auxiliares
	
	public int gerarNumero () {
		return ++ numero;
	}
	
	public Conta buscarNaCollection(int numero) {
		for (var conta : listaContas) {
			if (conta.getNumero()== numero)
				return conta;
		}
	 return null;
	}
	
	
}
