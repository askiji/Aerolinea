
public class Avion {
	private static int codigo=0;
	private int nombre;
	private Ciudades origen = Ciudades.MADRID;
	private Ciudades llegada;
	
	public Avion() {
		Avion.codigo++;
		this.nombre= Avion.codigo;
	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	public Ciudades getOrigen() {
		return origen;
	}

	public void setOrigen(Ciudades origen) {
		this.origen = origen;
	}

	public Ciudades getLlegada() {
		return llegada;
	}

	public void setLlegada(Ciudades llegada) {
		this.llegada = llegada;
	}
	
	
	
	
	
}
