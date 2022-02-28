import java.util.Scanner;

public class TestaCNPJ {

  public static void main(String[] args) {
    Scanner ler = new Scanner(System.in);

    String CNPJ;

    System.out.printf("Informe um CNPJ: ");
    CNPJ = ler.next();

    System.out.printf("\nResultado: ");
    
    // Usando os m�todos isCNPJ() e imprimeCNPJ() da classe "ValidaCNPJ"
    if (ValidaCNPJ.isCNPJ(CNPJ) == true)
       System.out.printf("%s\n", ValidaCNPJ.imprimeCNPJ(CNPJ));
    else System.out.printf("Erro, CNPJ inv�lido !\n");
  }

}