import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Vuelo {

	public static HashSet<Vuelo> tiempoDeVuelo;
	private static int numVuelo=0;
	public String tiempoVuelo;


	public Avion autobusConAlas;
	public Vuelo(Avion autobusConAlas) {
		Vuelo.numVuelo++;
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
		String fin = autobusConAlas.getNombre()+""+getMitad()+Vuelo.numVuelo;
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
