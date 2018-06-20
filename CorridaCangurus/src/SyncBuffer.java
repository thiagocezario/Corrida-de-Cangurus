
public class SyncBuffer {
	private int buffer = -1;
	//public int aux = 0;
	
	public synchronized int pular(int distanciaDoPulo, int distanciaTotal, int distanciaPulada, int turnoDoCanguru) {
		try {
			while(turnoDoCanguru != Principal.canguruDaVez%5) {
				System.err.println(Thread.currentThread().getName() + " esta esperando");
				wait();
			}
		} catch (Exception ex) {
			ex.getStackTrace();
		}
		
		System.err.println(Thread.currentThread().getName() + " vai pular agora");
		
		if (distanciaPulada >= distanciaTotal) {
			return buffer;
		}
		
		distanciaPulada += distanciaDoPulo;
		System.err.println(Thread.currentThread().getName() + " pulou " + distanciaDoPulo + "m de " + distanciaTotal + "m, para um total de " + distanciaPulada + "m");
		buffer = distanciaDoPulo;
		
		System.err.println("Canguru da vez: " + (Principal.canguruDaVez%5));
		Principal.canguruDaVez += 1;
		System.err.println("Canguru da vez: " + (Principal.canguruDaVez%5));
		notify();
		
		return buffer;
	}
}
