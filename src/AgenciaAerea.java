import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

public class AgenciaAerea {

	public ArrayList<Avion> flota = new ArrayList<>();
	private static ArrayList<Ciudades> city = new ArrayList<>();
	private ArrayList<Vuelo> vuelosDia = new ArrayList<>();
	private DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uuuu");
	
	private LocalDate ldt = LocalDate.now();
	

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
			if(av.getOrigen().equals(city.get(num))) {
				if(num==0) {
					num++;
				}
				else {
					num--;
				}
			}
			av.setLlegada(city.get(num));
			city.remove(num);
		}
	}
	
	public void setOrigen() {
		for (Avion av : flota) {
			av.setOrigen(av.getLlegada());
		}
	}
	public void llenarCiudades() {
		city.clear();
		for (Ciudades a : Ciudades.values()) {
			city.add(a);
		}
	}
	public void generarVuelo() {
		vuelosDia.clear();
		for (Avion av : flota) {
			Vuelo  v = new Vuelo(av); 
			vuelosDia.add(v);
			
			if( Vuelo.tiempoDeVuelo!=null && Vuelo.tiempoDeVuelo.contains(v)) {
				System.out.println("entra en que lo tiene");
			}
		}
	}
	
	public LocalTime horaSalida() {
		Random r = new Random();
		int hora = r.nextInt(16)+7;
		int minutos = r.nextInt(12)*5;
		LocalTime lt=LocalTime.of(hora, minutos);
		return lt;
	}
	
	public void pantalla() {
		System.out.println("Vuelos "+ldt.format(formatters) + "\t        Hora de salida \n");
		for (Vuelo v : vuelosDia) {
			LocalTime lt = horaSalida();
			System.out.println(v.getCode()+ " " +v.autobusConAlas.getOrigen().nombre+"-"+v.autobusConAlas.getLlegada().nombre+"\t \t" +lt);
		}
	}
	
}
