/*************************************************************
 * Author: Izabela Leme
 * Project: Validador de CNPJ
 * 
 ************************************************************/


import java.util.InputMismatchException;

public class ValidaCNPJ {

	public static void main(String[] args) {
		
	}
	
	public static boolean isCNPJ(String CNPJ) {
		// CNPJ's formados por uma sequencia de numeros iguais
		if (CNPJ.equals("00000000000000") || CNPJ.equals("11111111111111") ||
			CNPJ.equals("22222222222222") || CNPJ.equals("33333333333333") ||
			CNPJ.equals("44444444444444") || CNPJ.equals("55555555555555") ||
			CNPJ.equals("66666666666666") || CNPJ.equals("77777777777777") ||
			CNPJ.equals("88888888888888") || CNPJ.equals("99999999999999") ||
			(CNPJ.length() != 14))
			return (false);

		char digito13, digito14;
		int soma, i, resultado, num, peso;

		
		try { // "try" protege o código para eventuais erros de conversao de tipo (int)
			
			// -----------------------------------------------------------------------------
			// Calculando o 1º dígito verificador
			soma = 0;
			peso = 2;
			
			// Percorrendo os 13º números do CNPJ
			for (i = 11; i >= 0; i--) {
				// Convertendo o i-ésimo caractere do CNPJ em um número (String --> int):
				num = (int) (CNPJ.charAt(i) - 48); // 48 = posição de "0" na tabela ASCII
				soma = soma + (num * peso);
				peso ++; // peso = peso + 1;
				if (peso == 10) {
					peso = 2;
				}
			}

			resultado = soma % 11;
			
			if ((resultado == 0) || (resultado == 1)) {
				digito13 = '0';
			} else {
				digito13 = (char) ((11 - resultado) + 48);
			}

			// -----------------------------------------------------------------------------
			// Calculando o 2º digito verificador
			
			soma = 0;
			peso = 2;
			for (i = 12; i >= 0; i--) {
				num = (int) (CNPJ.charAt(i) - 48);
				soma = soma + (num * peso);
				peso = peso + 1;
				if (peso == 10)
					peso = 2;
			}

			resultado = soma % 11;
			if ((resultado == 0) || (resultado == 1))
				digito14 = '0';
			else
				digito14 = (char) ((11 - resultado) + 48);

			// Verifica se os dígitos calculados conferem com os dígitos informados.
			if ((digito13 == CNPJ.charAt(12)) && (digito14 == CNPJ.charAt(13))) {
				return (true);
			} else {
				return (false);
			}
			
		} catch (InputMismatchException erro) {
			return (false);
		}
	}

	public static String imprimeCNPJ(String CNPJ) {
		// máscara do CNPJ: 99.999.999.9999-99
		return (CNPJ.substring(0, 2) + "." + CNPJ.substring(2, 5) + "." + CNPJ.substring(5, 8) + "."
				+ CNPJ.substring(8, 12) + "-" + CNPJ.substring(12, 14));
	}
}