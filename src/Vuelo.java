import java.time.LocalTime;
import java.util.HashSet;

public class Vuelo {

	public static HashSet<Vuelo> tiempoDeVuelo;
	private static int numVuelo=0;
	private int vuelo;
	public LocalTime tiempoVuelo;


	public Avion autobusConAlas;
	public Vuelo(Avion autobusConAlas) {
		Vuelo.numVuelo++;
		this.vuelo = Vuelo.numVuelo;
		this.autobusConAlas = autobusConAlas;
	}
	@Override
	public int hashCode() {
		String aux = autobusConAlas.getOrigen().corto+""+autobusConAlas.getLlegada().corto;
		
		int def = Integer.valueOf(aux);
		return def;
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
	
	
	
	

//	public Ciudades hacerVuelo() {


//		return (Ciudades)city.get(num);
//	}
//	private static void generarVuelosDelDia() {
//		for (Vuelo v : vuelos) {
//			hacerVuelo();
//		}
//	}
//	
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Vuelo other = (Vuelo) obj;
//		return Objects.equals(autobusConAlas, other.autobusConAlas);
//	}
//	
//	
	
	
	
	
}
