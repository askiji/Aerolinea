import java.util.ArrayList;

public class Pricipal {

	public static void main(String[] args) {

//		Ciudades x = Ciudades.MADRID;
//		System.out.println(x.corto);

		
		
////		System.out.println(a4.ge);
//		ArrayList<Enum> city = new ArrayList<>();
//		for (Ciudades a : Ciudades.values()) {
//			city.add(a);
//		}
//		city.remove(2);
//		for (Enum enum1 : city) {
//			System.out.println(enum1);
//		}
		AgenciaAerea altos = new AgenciaAerea();
		
		
		
		altos.init();
		altos.llenarCiudades();
		altos.buscarDestino();
		altos.llenarCiudades();
		altos.buscarDestino();
		System.out.println(altos.flota.size());
		for (Avion a :altos.flota) {
			System.out.println(a.getLlegada());
		}
		System.out.println("asdasd");
//		System.out.println(AgenciaAerea.city);
		
	}
	

}
