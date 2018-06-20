
public class SyncBuffer {
	private int buffer = -1;
	//public int aux = 0;
	
	public synchronized int pular(int distanciaDoPulo, int distanciaTotal, int distanciaPulada, int turnoDoCanguru) {
		try {
			while(turnoDoCanguru != Principal.canguruDaVez%5) {
				wait(500);
			}
		} catch (Exception ex) {
			ex.getStackTrace();
		}
				
		if (distanciaPulada >= distanciaTotal) {
			return buffer;
		}
		
		distanciaPulada += distanciaDoPulo;
		System.err.println(Thread.currentThread().getName() + " pulou " + distanciaDoPulo + "m de " + distanciaTotal + "m, para um total de " + distanciaPulada + "m");
		buffer = distanciaDoPulo;
		
		Principal.canguruDaVez += 1;
		notify();
		
		return buffer;
	}
}
