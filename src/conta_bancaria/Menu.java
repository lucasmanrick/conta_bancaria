package conta_bancaria;

import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {

	public static void main(String[] args) {

		Scanner read = new Scanner(System.in);

		ContaController contas = new ContaController();

		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor;
		
		
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000.00f, 100.00f);
		contas.cadastrar(cc1);
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 123, 2, "Maria da Silva", 1000.00f, 12);
		contas.cadastrar(cp1);

		while (true) {
			System.out.println(Cores.TEXT_WHITE_BOLD + Cores.ANSI_BLACK_BACKGROUND);
			System.out.println("***************************************************");
			System.out.println("****                                           ****");
			System.out.println("******                                       ******");
			System.out.println("*******                                     *******");
			System.out.println("*********       Banco IMOBILIARIO LM      *********");
			System.out.println("*******                                     *******");
			System.out.println("******   _________________________________   ******");
			System.out.println("****    |1.Criar Conta                    |    ****");
			System.out.println("****    |2.Listar todas as Contas         |    ****");
			System.out.println("****    |3.Buscar Conta por Numero        |    ****");
			System.out.println("****    |4.Atualizar Dados da Conta       |    ****");
			System.out.println("****    |5.Apagar Conta                   |    ****");
			System.out.println("****    |6.Sacar                          |    ****");
			System.out.println("****    |7.Depositar                      |    ****");
			System.out.println("****    |8.Transferir valores entre Contas|    ****");
			System.out.println("****    |9.Listar Contas por nome        |    ****");
			System.out.println("****    |10.Sobre                          |    ****");
			System.out.println("****    |> 0.Sair <                       |    ****");
			System.out.println("****   	|_________________________________|    ****");
			System.out.println("***************************************************");
			System.out.println(Cores.TEXT_RESET);

			opcao = read.nextInt();

			switch (opcao) {
			case 0: 
				System.exit(0);
				read.close();
				System.out.println("Sistema encerrado, volte sempre!");
			case 1:
				System.out.println("Criar Conta\n\n");

				System.out.println("Digite o numero da agencia: ");
				agencia = read.nextInt();

				System.out.println("Digite o nome do titular: ");
				read.skip("\\R");
				titular = read.nextLine();

				System.out.println("Digite o tipo da conta (1 - CC | 2 - CP): ");
				tipo = read.nextInt();

				System.out.println("Digite Saldo inicial da conta: ");
				saldo = read.nextFloat();

				switch (tipo) {
				case 1:
					System.out.println("Digite o limite da conta: ");
					limite = read.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia,tipo,titular, saldo, limite));
					break;
				case 2:
					System.out.println("Digite o dia aniversario da conta: ");
					aniversario = read.nextInt();
					contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia,tipo,titular, saldo, aniversario));
				default:
					System.out.println("tipo de conta invalida, selecione uma opção valida.");
				}

				keyPress();
				break;
			case 2:
				System.out.println("Listar todas as Contas\n\n");
				contas.listarTodas();
				keyPress();
				break;
			case 3:
				System.out.println("Consultar dados da Conta - por número\n\n");
				
				System.out.println("Digite o numero da conta que você deseja consultar os dados: ");
				contas.procurarPorNumero(read.nextInt());
	
				keyPress();
				break;
			case 4:
				System.out.println("Atualizar dados da Conta\n\n");
				
				System.out.println("Digite o numero da conta que você deseja consultar Contados: ");
				numero = read.nextInt();
				Optional<Conta> conta = contas.buscarNaCollection(numero); // busca pela conta com o numero inserido.
				
				if(conta.isPresent()) { // verifica se a conta realmente existe.
					System.out.println("Digite o numero da agencia: ");
					agencia = read.nextInt();
					System.out.println("Digite o nome do titular: ");
					read.skip("\\R");
					titular = read.nextLine();
					
					tipo = conta.get().getTipo();
					switch (tipo) {
					case 1: // se for conta corrente pegar limite da conta 
						System.out.println("Digite o limite da conta: ");
						limite = read.nextFloat();
						contas.cadastrar(new ContaCorrente(numero, agencia,tipo,titular, conta.get().getSaldo(), limite));
						break;
					case 2: // se for conta poupança pegar aniversario da conta.
						System.out.println("Digite o dia aniversario da conta: ");
						aniversario = read.nextInt();
						contas.cadastrar(new ContaPoupanca(numero, agencia,tipo,titular, conta.get().getSaldo(), aniversario));
					}
					
				}else 
					System.out.printf("\nA conta numero %d não existe!", numero );
				
				keyPress();
				break;
			case 5:
				System.out.println("Apagar a Conta\n\n");
				
				System.out.println("Digite o numero da conta que você deseja deletar os dados: ");
				contas.deletar(read.nextInt());
		
				keyPress();
				break;
			case 6:
				System.out.println("Saque\n\n");
				
				System.out.println("Digite o numero da conta: ");
				numero = read.nextInt();
				System.out.println("Digite a quantia que deseja sacar: ");
				valor = read.nextFloat();
				contas.sacar(numero, valor);
				keyPress();
				break;
			case 7:
				System.out.println("Depósito\n\n");
				
				System.out.println("Digite o numero da conta: ");
				numero = read.nextInt();
				System.out.println("Digite a quantia que deseja Depositar: ");
				valor = read.nextFloat();
				contas.depositar(numero, valor);
				keyPress();
				break;
			case 8:
				System.out.println("Transferência entre Contas\n\n");
				System.out.println("Digite o numero da conta de origem: ");
				numero = read.nextInt();
				System.out.println("Digite o numero da conta de destino: ");
				numeroDestino = read.nextInt();
				System.out.println("Digite o valor para ser transferido: ");
				valor = read.nextFloat();
				
				contas.transferir(numero, numeroDestino, valor);
				keyPress();
				break;
			case 9:
				System.out.println("Consultar contas por titular");
				System.out.println("Digite o nome do titular:");
				read.skip("\\R");
				titular = read.nextLine();
				
				contas.listarPorTitular(titular);
				keyPress();
				break;
			case 10:
				System.out.println("\nBanco do Brazil com Z - O seu Futuro começa aqui!");
				sobre();
				keyPress();
				break;
			default:
				System.out.println("\nOpção Inválida!\n");
				keyPress();
				break;
			}

			

		}

	}

	public static void sobre() {
		System.out.println(
				"Este é o projeto 'conta bancaria'\ndesenvolvido por: Lucas Manrick Teodoro da Fonseca! \ngithub:https://github.com/lucasmanrick\nlinkedin:https://www.linkedin.com/in/lucas-manrick-0310b3228/");
	}

	public static void keyPress() {

		 try {
		        System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
		        
		        // Lê apenas a tecla Enter e ignora outras teclas
		        int input;
		        while ((input = System.in.read()) != '\n') {
		            // Ignora qualquer outra tecla diferente do Enter
		            if (input == -1) {
		                throw new IOException("Entrada encerrada inesperadamente");
		            }
		        }
		        
		    } catch (IOException e) {
		        System.err.println("Erro de entrada/saída: " + e.getMessage());
		    } catch (Exception e) {
		        System.err.println("Ocorreu um erro ao processar a entrada: " + e.getMessage());
		    }
		}

}
