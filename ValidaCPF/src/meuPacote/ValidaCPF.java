/*************************************************************
 * Author: Izabela Leme
 * Project: Validador de CPF
 * 
 ************************************************************/

package meuPacote;

import java.util.InputMismatchException;

public class ValidaCPF {

	public static boolean isCPF(String CPF) {
		// CNPJ's formados por uma sequencia de numeros iguais
		if (CPF.equals("00000000000") || CPF.equals("11111111111") ||
            CPF.equals("22222222222") || CPF.equals("33333333333") ||
            CPF.equals("44444444444") || CPF.equals("55555555555") ||
            CPF.equals("66666666666") || CPF.equals("77777777777") ||
            CPF.equals("88888888888") || CPF.equals("99999999999") ||
            (CPF.length() != 11))
            return(false);

		char digito10, digito11;
		int soma, i, resultado, num, peso;

		try { // "try" protege o c�digo para eventuais erros de conversao de tipo (int)

			// -----------------------------------------------------------------------------
			// Calculando o 1� d�gito verificador ------------------------------------------
			
			soma = 0;
			peso = 10;

			for (i = 0; i < 9; i++) {
				// Convertendo o i-�simo caractere do CPF em um n�mero (String --> int):
				num = (int) (CPF.charAt(i) - 48);
				soma = soma + (num * peso);
				peso = peso - 1;
			}

			resultado = 11 - (soma % 11);
			
			if ((resultado == 10) || (resultado == 11))
				digito10 = '0';
			else
				digito10 = (char) (resultado + 48); // converte no respectivo caractere numerico

			// -----------------------------------------------------------------------------
			// Calculando o 2� digito verificador ------------------------------------------
			
			soma = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (CPF.charAt(i) - 48);
				soma = soma + (num * peso);
				peso = peso - 1;
			}

			resultado = 11 - (soma % 11);
			
			if ((resultado == 10) || (resultado == 11))
				digito11 = '0';
			else
				digito11 = (char) (resultado + 48);

			// Verifica se os digitos calculados conferem com os digitos informados.
			if ((digito10 == CPF.charAt(9)) && (digito11 == CPF.charAt(10)))
				return (true);
			else
				return (false);
		} catch (InputMismatchException erro) {
			return (false);
		}
	}

	public static String imprimeCPF(String CPF) {
		return (CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." + CPF.substring(6, 9) + "-"
				+ CPF.substring(9, 11));
	}
}