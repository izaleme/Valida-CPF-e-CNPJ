package meuPacote;

import java.util.Scanner;

public class TestaExemplos {

  public static void main(String[] args) {
    Scanner ler = new Scanner(System.in);

    String cnpj;
    String cpf;

    System.out.printf("Informe um CNPJ: ");
    cnpj = ler.next();

    System.out.printf("Informe um CPF: ");
    cpf = ler.next();
    
    System.out.printf("\nResultado CNPJ: ");
    
    if (ValidaCNPJeCPF.isValidCNPJ(cnpj) == true)
    	System.out.printf("%s\n", ValidaCNPJeCPF.imprimeCNPJ(cnpj));
    else System.out.printf("Erro, CNPJ inválido!\n");
    
    System.out.printf("Resultado CPF: ");
    
    if (ValidaCNPJeCPF.isValidCPF(cpf) == true)
		System.out.printf("%s\n", ValidaCNPJeCPF.imprimeCPF(cpf));
	else
		System.out.printf("Erro, CPF invalido !!!\n");
    
  }
}