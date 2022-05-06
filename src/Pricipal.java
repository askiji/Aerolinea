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
		altos.generarVuelo();
		altos.pantalla();
		altos.setOrigen();
		
		System.out.println("next ");
		
		altos.llenarCiudades();
		altos.buscarDestino();
		altos.generarVuelo();
		altos.pantalla();
		altos.setOrigen();

	}
	

}
