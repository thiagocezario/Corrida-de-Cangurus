import java.util.Random;

public class Principal {

	public static int colocacao = 1;
	public static int canguruDaVez = 0;
	public static int distanciaTotal = distancia(80, 100);
	
	
	public static int distancia(int minimo, int maximo) {
		Random rand = new Random();
		return rand.nextInt(maximo - minimo) + minimo;
	}
	
	public static void main(String[] args) {
		SyncBuffer buffer = new SyncBuffer();		
		
		Canguru c1 = new Canguru("Canguru 1", buffer, 0);
		Canguru c2 = new Canguru("Canguru 2", buffer, 1);
		Canguru c3 = new Canguru("Canguru 3", buffer, 2);
		Canguru c4 = new Canguru("Canguru 4", buffer, 3);
		Canguru c5 = new Canguru("Canguru 5", buffer, 4);
		
		
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		c5.start();

	}

}