package conta_bancaria;

import conta_bancaria.util.Cores;

public class Menu {

	public static void main(String[] args) {
		System.out.println(Cores.TEXT_WHITE_BOLD + Cores.ANSI_BLACK_BACKGROUND );
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
		System.out.println("****    |9.Sobre                          |    ****");
		System.out.println("****    |> 0.Sair <                       |    ****");
		System.out.println("****   	|_________________________________|    ****");
		System.out.println("***************************************************");
		
		System.out.println(Cores.TEXT_RESET);
		sobre();
	}

	
	
	
	public static void sobre () {
		System.out.println("Este é o projeto 'conta bancaria'\ndesenvolvido por: Lucas Manrick Teodoro da Fonseca! \ngithub:https://github.com/lucasmanrick\nlinkedin:https://www.linkedin.com/in/lucas-manrick-0310b3228/");
	}
}
