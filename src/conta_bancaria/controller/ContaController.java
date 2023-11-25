package conta_bancaria.controller;

import java.util.ArrayList;
import java.util.Optional;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;

public class ContaController implements ContaRepository{

	//Criar Collection
	
	private ArrayList <Conta>listaContas = new ArrayList<Conta>();
	
	
	// Variável para receber o número da conta para automatizar o processo de definir o número de cada conta.
	int numero = 0;
	
	@Override
	public void procurarPorNum(int numero) {
		
		Optional<Conta> conta = buscarNaCollection(numero);
	
		if (conta.isPresent())
			conta.get().visualizar();
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
			System.out.println("A conta número " + conta.getNumero() + " foi criada com sucesso!");
		
	}

	@Override
	public void atualizar(Conta conta) {
		
		Optional<Conta> buscaConta = buscarNaCollection(conta.getNumero());
		
		if (buscaConta.isPresent()){
				
				listaContas.set(listaContas.indexOf(buscaConta.get()), conta);
				System.out.println("A conta: " + conta.getNumero() + " foi atualizada com sucesso!");
		}else
			System.out.println("A conta número " + conta.getNumero() + " não foi encontrada!");
	}

	@Override
	public void delete(int numero) {
		Optional<Conta> conta = buscarNaCollection(numero);
		
		if (conta.isPresent())
			if(listaContas.remove(conta.get())== true)
				System.out.println("A conta: " + numero + " foi excluída com sucesso!");
		else
			System.out.println("A conta número " + numero + " não foi encontrada!");
		
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
	
	public Optional<Conta> buscarNaCollection(int numero) {
		for (var conta : listaContas) {
			if (conta.getNumero()== numero)
				return Optional.of(conta);
		}
	 return Optional.empty();
	}
	
	
}
