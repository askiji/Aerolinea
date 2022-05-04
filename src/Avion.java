import java.util.Objects;

public class Avion {
	private static int codigo=0;
	private int nombre;
	private Ciudades origen = Ciudades.MADRID;
	private Ciudades llegada;
	
	public Avion() {
		Avion.codigo++;
		this.nombre= Avion.codigo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(llegada, origen);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Avion other = (Avion) obj;
		return llegada == other.llegada && nombre == other.nombre && origen == other.origen;
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
