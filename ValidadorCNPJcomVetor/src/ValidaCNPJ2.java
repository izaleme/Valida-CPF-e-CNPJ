
public class ValidaCNPJ2 {

	public static boolean isValidCNPJ(String cnpj) {
		cnpj = cnpj.replaceAll("[/.-]", "");
		if (cnpj.length() != 14)
			return false;
		
		int soma = 0, digito;
		String cnpjCalculado = cnpj.substring(0,12);
		char[] charCnpj = cnpj.toCharArray();
		
		/* Primeira parte */
		
		for (int i = 0; i < 4; i++) {
			if(charCnpj[i] - 48 >= 0 && charCnpj[i] - 48 <= 9) {
				soma += (charCnpj[i] - 48) * (6 - (i + 1));
			}
		}
		
		for (int i = 0; i < 8; i++) {
			if(charCnpj[i + 4] - 48 >= 0 && charCnpj[i + 4] - 48 <= 9) {
				soma += (charCnpj[i + 4] - 48) * (10 - (i + 1));
			}
		}
		
		digito = 11 - (soma % 11);
		cnpjCalculado += (digito == 10 || digito == 11) ? "0" : Integer.toString(digito);
		
		
		/* Segunda parte */
		
		soma = 0;
		for (int i = 0; i < 5; i++) {
			if (charCnpj[i] - 48 >= 0 && charCnpj[i] - 48 <= 9) {
				soma += (charCnpj[i] - 48) * (7 - (i + 1));
			}
		}
		
		for (int i = 0; i < 8; i++) {
			if (charCnpj[i + 5] - 48 >= 0 && charCnpj[i + 5] - 48 <= 9) {
				soma += (charCnpj[i + 5] - 48) * (10 - (i + 1));
			}
		}
		
		digito = 11 - (soma % 11);
		cnpjCalculado += (digito == 10 || digito == 11) ? "0" : Integer.toString(digito);
		
		return cnpj.equals(cnpjCalculado);
		
	}
}
