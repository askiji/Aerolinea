import java.time.LocalTime;
import java.util.HashSet;
import java.util.Objects;

public class Vuelo implements Cloneable {

	
	private static int numVuelo=0;
	private int vuelo;
	public LocalTime tiempoVuelo;
	public Avion autobusConAlas;
	public LocalTime salida;
	public LocalTime llegada;
	
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	public Vuelo(Avion autobusConAlas) {
		Vuelo.numVuelo++;
		this.vuelo = Vuelo.numVuelo;
		this.autobusConAlas = autobusConAlas;
	}
	
<<<<<<< HEAD
	@Override
	public int hashCode() {
		String aux = autobusConAlas.getOrigen().corto+""+autobusConAlas.getLlegada().corto;
		
		int def = Integer.valueOf(aux);
		return def;
=======
	public static int getNumVuelo() {
		return numVuelo;
	}

	public static void setNumVuelo(int numVuelo) {
		Vuelo.numVuelo = numVuelo;
	}

	public int getVuelo() {
		return vuelo;
	}

	public void setVuelo(int vuelo) {
		this.vuelo = vuelo;
	}

	public LocalTime getTiempoVuelo() {
		return tiempoVuelo;
	}

	public void setTiempoVuelo(LocalTime tiempoVuelo) {
		this.tiempoVuelo = tiempoVuelo;
	}

	public Avion getAutobusConAlas() {
		return autobusConAlas;
	}

	public void setAutobusConAlas(Avion autobusConAlas) {
		this.autobusConAlas = autobusConAlas;
	}
//	public int a() {
//		return Objects.hash(autobusConAlas.getOrigen().corto, autobusConAlas.getLlegada().corto);
//	}
//	public int b() {
//		return Objects.hash(autobusConAlas.getLlegada().corto,autobusConAlas.getOrigen().corto);
//	}
	
	public int customHashCode() {
		return Objects.hash(autobusConAlas.getOrigen().corto, autobusConAlas.getLlegada().corto);
>>>>>>> branch 'master' of https://github.com/askiji/Aerolinea.git
	}
	private String getMitad() {
		String aux = autobusConAlas.getOrigen().corto+""+autobusConAlas.getLlegada().corto;
		return aux;
	}
	
	public String getCode() {
//		Vuelo.numVuelo++;
		String fin = autobusConAlas.getNombre()+""+getMitad()+this.vuelo;
		return fin;
	}
	public void setAvion(Avion av) {
		this.autobusConAlas=av;
	}

	public LocalTime getSalida() {
		return salida;
	}

	public void setSalida(LocalTime salida) {
		this.salida = salida;
	}

	public LocalTime getLlegada() {
		return llegada;
	}

	public void setLlegada(LocalTime llegada) {
		this.llegada = llegada;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
