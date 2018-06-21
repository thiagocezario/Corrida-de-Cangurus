import java.util.Random;

public class Principal {

	/*
	 * colocacao eh a colocacao do canguru quando encerrar a corrida
	 * canguruDaVez indica qual canguru deve pular
	 * distanciaTotal eh a distancia do percurso, varia de 80m a 100m
	 */
	public static int colocacao = 1;
	public static int canguruDaVez = 0;
	public static int distanciaTotal = distancia(80, 101);
	
	/*
	 * Gera um numero aleatorio entre os limites estabelecidos
	 */
	public static int distancia(int minimo, int maximo) {
		Random rand = new Random();
		return rand.nextInt(maximo - minimo) + minimo;
	}
	
	/*
	 * Cria as threads e inicia elas
	 */
	public static void main(String[] args) {
		SyncBuffer buffer = new SyncBuffer();		
		
		Canguru c1 = new Canguru("Canguru 1", buffer, 0);
		Canguru c2 = new Canguru("Canguru 2", buffer, 1);
		Canguru c3 = new Canguru("Canguru 3", buffer, 2);
		Canguru c4 = new Canguru("Canguru 4", buffer, 3);
		Canguru c5 = new Canguru("Canguru 5", buffer, 4);

		System.err.println("\n----------Inicio da corrida----------\n");
		System.err.println("\n-----Rodada 1-----\n");
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		c5.start();
	}
}