
public class SyncBuffer {
	private int buffer = -1;
	private int rodada = 0;
	public static int primeiroCanguru = 0;
	
	public synchronized int pular(int distanciaDoPulo, int distanciaTotal, int distanciaPulada, int turnoDoCanguru) {
		try {
			while(turnoDoCanguru != Principal.canguruDaVez%5) {
				wait(1000);
			}
		} catch (Exception ex) {
			ex.getStackTrace();
		}
				
		if (distanciaPulada >= distanciaTotal) {
			Principal.canguruDaVez += 1;
			return buffer;
		}
		
		
		
		if (Principal.canguruDaVez%5 == primeiroCanguru) {
			System.err.println("\n-----Rodada " + (rodada+1) + "-----\n");
			rodada++;
		}
		
		distanciaPulada += distanciaDoPulo;
		System.err.println(Thread.currentThread().getName() + " pulou " + distanciaDoPulo + "m de " + distanciaTotal + "m, para um total de " + distanciaPulada + "m");
		buffer = distanciaDoPulo;
		
		if (Principal.canguruDaVez%5 == 4) {
			try {
				wait(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Principal.canguruDaVez += 1;
		
		return buffer;
	}
}
