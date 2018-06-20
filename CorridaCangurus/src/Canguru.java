
public class Canguru extends Thread {
	private SyncBuffer buffer;
	private int turnoDoCanguru = 0;
	
	public Canguru(String nome, SyncBuffer buffer, int turno) {
		super(nome);
		this.buffer = buffer;
		this.turnoDoCanguru = turno;
	}
	
	public void run() {
		int distanciaPulada = 0;
		
		while (distanciaPulada < Principal.distanciaTotal) {
			try {
				int distanciaDoPulo = Principal.distancia(0, 10);
				
				//Thread.sleep(1000);
				distanciaPulada += buffer.pular(distanciaDoPulo, Principal.distanciaTotal, distanciaPulada, turnoDoCanguru);
				//Principal.canguruDaVez++;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		if (distanciaPulada >= Principal.distanciaTotal) {
			System.err.println(Thread.currentThread().getName() + " terminou a corrida em " + Principal.colocacao + "� lugar");
			Principal.colocacao++;
		}
		
		while (Principal.colocacao < 6) {
			buffer.pular(0, Principal.distanciaTotal, distanciaPulada, turnoDoCanguru);
			System.out.println(Principal.colocacao);
		}
	}
}
