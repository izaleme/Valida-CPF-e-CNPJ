package meuPacote;

import java.util.Scanner;
import meuPacote.ValidaCPF; // importanto a classe "ValidaCPF" do pacote "meuPacote"

public class TestaCPF {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);

		String CPF;

		System.out.printf("Informe um CPF: ");
		CPF = ler.next();

		System.out.printf("\nResultado: ");
		// Usando os metodos isCPF() e imprimeCPF() da classe "ValidaCPF"
		if (ValidaCPF.isCPF(CPF) == true)
			System.out.printf("%s\n", ValidaCPF.imprimeCPF(CPF));
		else
			System.out.printf("Erro, CPF invalido !!!\n");
	}
}
