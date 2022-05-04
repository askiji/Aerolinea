import java.util.ArrayList;
import java.util.Random;

public class AgenciaAerea {

	public ArrayList<Avion> flota = new ArrayList<>();
	private static ArrayList<Ciudades> city = new ArrayList<>();

	public void init() {
		Avion a1=new Avion();
		Avion a2=new Avion();
		Avion a3=new Avion();
		Avion a4=new Avion();
		flota.add(a1);
		flota.add(a2);
		flota.add(a3);
		flota.add(a4);
	}
	
	
	public void buscarDestino() {
		Random r = new Random();
		
		for (Avion av : flota) {
			int num = r.nextInt(city.size());
			System.out.println(num);
			if(av.getOrigen().equals(city.get(num))) {
				System.out.println("asdasd");
				if(num==0) {
					num++;
				}
				else {
					num--;
				}
			}
			
			av.setLlegada(city.get(num));
//			System.out.println(av.getNombre());
			city.remove(num);
		}
	}
	public void llenarCiudades() {
		city.clear();
		for (Ciudades a : Ciudades.values()) {
			city.add(a);
//			System.out.println(a.getCorto());
		}
	}
	
	
}
