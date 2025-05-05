package conta_bancaria.controller;

import java.util.ArrayList;
import java.util.Optional;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;

public class ContaController implements ContaRepository {
	
	//Criar a Collection Arraylist para armazenar as informações da conta (array de objetos).
	
	private ArrayList<Conta> listaContas = new ArrayList<Conta>(); // funcionará como se fosse nosso banco de dados.
	
	//Variável para controlar os números das contas (id das contas).
	
	int numero = 0;

	@Override
	public void procurarPorNumero(int numero) {
		Optional<Conta> conta = buscarNaCollection(numero);
		
		if(conta.isPresent()) {
			conta.get().visualizar();
		}else {
			System.out.printf("\n A conta %d não foi encontrada", numero);
		}
		
	}

	@Override
	public void listarTodas() {
		for(var conta : listaContas) {
			conta.visualizar();  //para cada conta que tiver no arraylist, vamos usar o metodo visualizar que já existe em cada conta.
			
		}
		
	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("Conta criada com sucesso!");
	}

	@Override
	public void atualizar(Conta conta) {
		
		Optional<Conta> contaExistence = buscarNaCollection(conta.getNumero());
		
		if(contaExistence.isPresent()) {
			listaContas.set(listaContas.indexOf(contaExistence.get()), conta); // atualiza o array de contas (na posição que o usuario solicitou
				System.out.printf("\n A conta numero %d foi atualizada com sucesso!", conta.getNumero());
			
		}else {
			System.out.printf("\n A conta %d não foi encontrada", conta.getNumero());
		}
		
	}

	@Override
	public void deletar(int numero) {
		Optional<Conta> conta = buscarNaCollection(numero);
		
		if(conta.isPresent()) {
			if(listaContas.remove(conta.get()) == true ) { // se conseguiu remover a conta retornada mostrar mensagem de apagada com sucesso.
				System.out.printf("\n A conta numero %d foi apagada com sucesso!", numero);
			}
		}else {
			System.out.printf("\n A conta %d não foi encontrada", numero);
		}
	}

	@Override
	public void sacar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void depositar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		// TODO Auto-generated method stub
		
	}
	
	//Métodos Auxiliares
	
	public int gerarNumero() {
		return ++ numero;
	}
	
	public Optional<Conta> buscarNaCollection (int numero) {  //passamos Optional de um objeto conta como retorno.
		for(var conta : listaContas) {
			if(conta.getNumero() == numero) {
				return Optional.of(conta);// aqui utilizamos o of e não o ofnullable pois temos a certeza que não será nullo o retorno, neste caso.
			}
		}
		return Optional.empty(); // ao inves de retornar nullo retornamos um objeto Optional vazio.
	}

}
