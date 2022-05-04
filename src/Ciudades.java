
public enum Ciudades {
MADRID("Madrid", "MA"),
BARCELONA("Barcelona","BC"),
VALENCIA("Valencia","VA"),
ALICANTE("Alicante","AL"),
BILBAO("Bilbao","BI"),
PARIS("Paris","PA");
	
	String nombre;
	String corto;

Ciudades(String nombre, String corto) {
	this.nombre = nombre;
	this.corto = corto;
}

public String getCorto(){
	return this.corto;
}


}
