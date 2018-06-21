
public class Canguru extends Thread {
	private SyncBuffer buffer;
	private int turnoDoCanguru = 0;
	
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
				int distanciaDoPulo = Principal.distancia(0, 10);
				
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
			System.err.println(Thread.currentThread().getName() + " terminou a corrida em " + Principal.colocacao + "º lugar");
			Principal.colocacao++;
			SyncBuffer.primeiroCanguru++;
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
