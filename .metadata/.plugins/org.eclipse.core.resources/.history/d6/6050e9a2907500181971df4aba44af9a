
public class Canguru extends Thread {
	private SyncBuffer buffer;
	private int turnoDoCanguru = 0;
	public static boolean c1EstaNaCorrida = true;
	public static boolean c2EstaNaCorrida = true;
	public static boolean c3EstaNaCorrida = true;
	public static boolean c4EstaNaCorrida = true;
	public static boolean c5EstaNaCorrida = true;
	
	/*
	 * Construtor do canguru
	 * @param turno turno do canguru, em qual vez ele deve pular
	 * @param buffer peguei do cod. do professor, nao sei exatamente o que faz
	 */
	public Canguru(String nome, SyncBuffer buffer, int turno) {
		super(nome);
		this.buffer = buffer;
		this.turnoDoCanguru = turno;
	}
	
	/** 
	 * Codigo para rodar a thread, enquanto estiver ativo a thread fica viva, quando sair do ultimo while a thread morre
	 */
	public void run() {
		int distanciaPulada = 0;
		
		/*
		 * while para fazer o canguru pular a cada rodada
		 * distanciaPulada eh a distancia que ele ja percorreu
		 * Principal.distanciaTotal eh a distancia do percurso, o quanto ele tem que percorrer
		 * Ele vai continuar pulando enquanto nao tiver passado da linha de chegada (distanciaTotal)
		 */
		while (distanciaPulada < Principal.distanciaTotal) {
			try {
				int distanciaDoPulo = Principal.distancia(0, 11);
				
				distanciaPulada += buffer.pular(distanciaDoPulo, Principal.distanciaTotal, distanciaPulada, turnoDoCanguru);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		/*
		 * se ele terminar o percurso, uma mensagem com qual canguru terminou e em qual posicao
		 * aumenta o numero da colocacao pro proximo canguru
		 * SyncBuffer.primeiroCanguru serve para controlar o print da rodada, ainda nao esta funcionando corretamente
		 */
		if (distanciaPulada >= Principal.distanciaTotal) {
			
			/*
			 * Esses ifs sao pra checar qual canguru ainda esta correndo
			 * sao usados no SyncBuffer pra imprimir a rodada e pra pausa
			 * Foram feitos na tentativa e erro e estao feios pra caralho
			 */
			if(turnoDoCanguru == 0) {
				c1EstaNaCorrida = false;
			}
			
			if(turnoDoCanguru == 1) {
				c2EstaNaCorrida = false;
			}
			
			if(turnoDoCanguru == 2) {
				c3EstaNaCorrida = false;
			}
			
			if(turnoDoCanguru == 3) {
				c4EstaNaCorrida = false;
			}
			
			if(turnoDoCanguru == 4) {
				c5EstaNaCorrida = false;
			}			
			
			System.err.println(Thread.currentThread().getName() + " terminou a corrida em " + Principal.colocacao + "º lugar");
			Principal.colocacao++;
			
			if (turnoDoCanguru == SyncBuffer.ultimoCanguru) {
				System.err.println("\n\n\n");
				
				if (c1EstaNaCorrida ||
						c2EstaNaCorrida ||
						c3EstaNaCorrida ||
						c4EstaNaCorrida ||
						c5EstaNaCorrida) {
					System.err.println("\n-----Rodada " + (SyncBuffer.rodada+1) + "-----\n");
					SyncBuffer.rodada++;
				}
			}
			
		}
		
		/*
		 * Enquanto a colocacao for menor que 6 quer dizer que ainda tem canguru na corrida
		 * serve para segurar a thread que encerrou e nao atrapalhar a execucao das outras
		 */
		while (Principal.colocacao < 6) {
			buffer.pular(0, Principal.distanciaTotal, distanciaPulada, turnoDoCanguru);
		}
	}
}
