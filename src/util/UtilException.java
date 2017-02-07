package util;

/*

Esta classe foi feita para que tenhamos condicao de lancar excecoes personalizadas
para que o nosso programa possa identificar quando que ocorreu uma excecao 
especificamente gerada por alguma parte do codigo que escrevemos nas classes 
do pacote util.

Veja, por exemplo, na classe RelatorioUtil e ConexaoUtil as vezes em que usamos esta 
excecao. Para voce entender, procure as vezes em que escrevemos:

throw new UtilException

*/

public class UtilException extends Exception {

	private static final long serialVersionUID = -3020787300570751186L;

	public UtilException() {
		super();
	}

	public UtilException(String message, Throwable cause) {
		super(message, cause);
	}

	public UtilException(String message) {
		super(message);
	}

	public UtilException(Throwable cause) {
		super(cause);
	}

}
