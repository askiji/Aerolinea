import java.util.Scanner;

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
		
//		altos.horaLlegada();
		
		int aux = 1;
		altos.init();
		while(aux<10) {
			altos.llenarCiudades();
			altos.buscarDestino();
			altos.generarVuelo();
			altos.pantalla();
			altos.setOrigen();
			aux++;

		}
//		
		
		System.out.println("next ");
		
		altos.llenarCiudades();
		altos.buscarDestino();
		altos.generarVuelo();
		altos.pantalla();
		altos.setOrigen();

	}
	

}
