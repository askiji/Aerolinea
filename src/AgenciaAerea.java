import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class AgenciaAerea {

	public ArrayList<Avion> flota = new ArrayList<>();
	private static ArrayList<Ciudades> city = new ArrayList<>();
	private ArrayList<Vuelo> vuelosDia = new ArrayList<>();
	private DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uuuu");
	public static HashSet<Vuelo> tiempoDeVuelo= new HashSet<Vuelo>();
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("mm");
	private ArrayList<Vuelo> allFlights = new ArrayList<>();
	
	private LocalDate ldt;
	

	public void init() {
		Avion a1=new Avion();
		Avion a2=new Avion();
		Avion a3=new Avion();
		Avion a4=new Avion();
		flota.add(a1);
		flota.add(a2);
		flota.add(a3);
		flota.add(a4);
		ldt = LocalDate.now();
		
	
	}
	
	public void info() {
		System.out.println(ldt.format(formatters));
		System.out.println("1.- Listado de vuelos totales");
		System.out.println("2.- pàsar dia siguente y ver vuelos");
		System.out.println("3.- terminar el programa");
		Scanner sc = new Scanner(System.in);
		int opcion = sc.nextInt();
		switch (opcion) {
		case 1:
			System.out.println("to do");
			break;
		case 2:
			ldt=ldt.plusDays(1);
//			ldt.plusDay(1);
			llenarCiudades();
			buscarDestino();
			generarVuelo();
			pantalla();
			tiemposDeVuelo();
			setOrigen();
			break;
		case 3:
			System.out.println("ha terminado el programa");
			System.exit(0);;
			break;

		default:
			break;
		}
		
	}
	
	public void tiemposDeVuelo() {
		Scanner sc = new Scanner(System.in);
		LocalTime cerocero = LocalTime.of(0, 0);
		LocalTime siete = LocalTime.of(7, 0);
		for (Vuelo v : vuelosDia) {
			for (Vuelo vueloGuardado : tiempoDeVuelo) {
				if (v.hashCode() == vueloGuardado.hashCode() && vueloGuardado.tiempoVuelo == null) {
					System.out.println("Duracion del vuelo en minutos avion " + v.getAutobusConAlas().getNombre() +" : " + v.autobusConAlas.getOrigen().nombre +" - "
							+ v.autobusConAlas.getLlegada().nombre+ "?");
					int minutos = sc.nextInt();
					LocalTime aux = cerocero;
					aux = aux.plusMinutes(minutos);
					v.setTiempoVuelo(aux);
					vueloGuardado.setTiempoVuelo(aux);
					LocalTime auxTime = v.getSalida().plusMinutes(minutos);
					v.setLlegada(auxTime);
					String llegada = "Hora de llegada " + v.getLlegada();
					if(v.getLlegada().isBefore(siete)) {
						llegada += " del dia siguente";
					}
//					System.out.println(v.a());
//					System.out.println(v.b());
					System.out.println(llegada);
					
					break;
				}
//				(v.hashCode() == vueloGuardado.hashCode() && vueloGuardado.tiempoVuelo != null)
				if (v.hashCode() == vueloGuardado.hashCode() && vueloGuardado.tiempoVuelo != null){
					System.out.println("*** Duracion del vuelo en minutos avion " + v.getAutobusConAlas().getNombre() +" : " + v.autobusConAlas.getOrigen().nombre +" - "
							+ v.autobusConAlas.getLlegada().nombre+ "?");
					System.out.println("La duracion del vuelo es " + vueloGuardado.getTiempoVuelo());
					v.setLlegada(v.getSalida().plusMinutes(ChronoUnit.MINUTES.between(cerocero,vueloGuardado.getTiempoVuelo())));
					vueloGuardado.getTiempoVuelo();
				}
				allFlights.add(v);
			}
		}
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
			tiempoDeVuelo.add(v);
			

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
			v.setSalida(lt);
			System.out.println(v.getCode()+ " " +v.autobusConAlas.getOrigen().nombre+"-"+v.autobusConAlas.getLlegada().nombre+"\t \t" +lt);
		}
	}
	
}
