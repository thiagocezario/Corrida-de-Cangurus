
public class SyncBuffer {
	/*
	 * buffer serve para armazenar o valor da distancia pulada e retornar pra thread
	 * rodada indica qual rodada esta no momento
	 * primeiroCanguru e ultimoCanguru eh pra controlar o print da rodada, ainda esta em implementacao
	 */
	private int buffer = -1;
	private int rodada = 0;
	public static int primeiroCanguru = 0;
	public static int ultimoCanguru = 4;
	
	
	/*
	 * metodo que faz o canguru pular
	 * distanciaDoPulo eh quanto ele vai pular na rodada
	 * distanciaTotal eh o tamanho do percurso
	 * distanciaPulada eh quanto o canguru pulou ate o momento
	 * turnoDoCanguru eh em que momento ele deve rodar
	 */
	public synchronized int pular(int distanciaDoPulo, int distanciaTotal, int distanciaPulada, int turnoDoCanguru) {
		try {
			/*
			 * enquanto nao for a vez da thread, ela fica esperando
			 * wait(1000) eh pra atualizar a checagem de vez, notify() nao funcionou
			 * Principal.canguruDaVez%5 eh pra nao precisar se preocupar em resetar a variavel de ordem, desse jeito ela sempre vai oscilar de 0 a 4
			 */
			while(turnoDoCanguru != Principal.canguruDaVez%5) {
				wait(1000);
			}
		} catch (Exception ex) {
			ex.getStackTrace();
		}
		
		/*
		 * serve para passar a vez quando for uma thread que ja terminou a corrida
		 * se ela ja tiver pulado mais que a distancia do percurso ela passa a vez
		 */
		if (distanciaPulada >= distanciaTotal) {
			Principal.canguruDaVez += 1;
			return buffer;
		}
		
		
		/*
		 * Pra imprimir a rodada, em construcao
		 */
		if (Principal.canguruDaVez%5 == primeiroCanguru) {
			System.err.println("\n-----Rodada " + (rodada+1) + "-----\n");
			rodada++;
		}
		
		
		/*
		 * imprime quanto pulou na rodada, quanto pulou total e tamanho do percurso
		 * adiciona o valor do pulo no buffer pra informar a thread
		 */
		distanciaPulada += distanciaDoPulo;
		System.err.println(Thread.currentThread().getName() + " pulou " + distanciaDoPulo + "m de " + distanciaTotal + "m, para um total de " + distanciaPulada + "m");
		buffer = distanciaDoPulo;
		
		/*
		 * serve para dar uma pausa na execucao das threads quando o ultimo canguru pula, assim ele apresenta 
		 * na tela de um jeito melhor
		 * Em construcao tbm
		 */
		if (Principal.canguruDaVez%5 == ultimoCanguru) {
			try {
				wait(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/*
		 * passa a vez da thread que pulou, assim a seguinte executa
		 */
		Principal.canguruDaVez += 1;
		
		return buffer;
	}
}
