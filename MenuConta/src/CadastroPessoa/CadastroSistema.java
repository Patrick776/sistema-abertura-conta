package CadastroPessoa;

import java.util.Scanner;

public class CadastroSistema {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int opcao;
		
		do {
			
		System.out.println("======== Menu =========");
		System.out.println("1 - Cadastro de Conta\n");
		System.out.println("2 - Acessar Conta\n");
		System.out.println("3 - Sair");
		System.out.println("=======================");
		
		System.out.println("Escolha opção desejada: ");
		opcao = scanner.nextInt();
		
		switch (opcao) {
		case 1:
			System.out.println("Opção selecionada: Cadastro Conta\n");
			cadastroConta(scanner);
			break;
		
		case 2:
			System.out.println("Opção selecionada: Acessar Conta\n");
			acessarConta();
			break;
		
		case 3:
			System.out.println("Opção selecionada: Sair");
			break;
		}
			System.out.println();
		}while(opcao !=3);
		
	}

	private static void acessarConta() {
		// TODO Auto-generated method stub
		
	}

	private static void cadastroConta(Scanner scanner) {
		// TODO Auto-generated method stub
		
	}

}
