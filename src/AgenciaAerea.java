import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class AgenciaAerea {

	public ArrayList<Avion> flota = new ArrayList<>();
	private static ArrayList<Ciudades> city = new ArrayList<>();
	private ArrayList<Vuelo> vuelosDia = new ArrayList<>();
	private DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uuuu");
<<<<<<< HEAD
//	public static HashMap<Vuelo , Integer> tiempoDeVuelo= new HashMap<>();
	private LocalDate ldt = LocalDate.now();
=======
	public static HashSet<Vuelo> tiempoDeVuelo= new HashSet<Vuelo>();
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("mm");
	private ArrayList<Vuelo> allFlights = new ArrayList<>();
	private ArrayList<String> chorizo = new ArrayList<String>();
	private HashMap<Integer , LocalTime> duraciones = new HashMap<>();
	private LocalDate ldt;
>>>>>>> branch 'master' of https://github.com/askiji/Aerolinea.git
	

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
			acumulados();
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
	
	private void acumulados() {
		System.out.println("Vuelos "+ldt.format(formatters) + "\t        Hora de salida \t  Hora de llegada");
		
		for (String palabras : chorizo) {
			System.out.println(palabras);
		}
		
	}
	
	public void tiemposDeVuelo() {
		
		Scanner sc = new Scanner(System.in);
		String frase = "Duracion del vulo del avion ";
		LocalTime siete = LocalTime.of(7, 0);
		for (Vuelo vueloDia : vuelosDia) {
			if(duraciones.get(vueloDia.customHashCode()) != null) {
				vueloDia.setTiempoVuelo(duraciones.get(vueloDia.getCode()));
				LocalTime t1 = vueloDia.salida;  // 09:00
				LocalTime t2 = duraciones.get(vueloDia.customHashCode()); // 02:30
				LocalTime total = t1.plusHours(t2.getHour())
				                    .plusMinutes(t2.getMinute());
				vueloDia.setLlegada(total);
				System.out.println(frase + " : "+ vueloDia.getAutobusConAlas().getOrigen().nombre+" - "+vueloDia.getAutobusConAlas().getLlegada().nombre );
				System.out.println("Es de "+ duraciones.get(vueloDia.customHashCode()));
				System.out.println("hora de llegada" + vueloDia.getLlegada());
				if(vueloDia.getLlegada().isBefore(siete)) {
					System.out.println("Del dia siguente");
				}

			}
			else {
				System.out.println(frase+ " : "+ vueloDia.getAutobusConAlas().getOrigen().nombre+" - "+vueloDia.getAutobusConAlas().getLlegada().nombre);
				int aux = sc.nextInt();
				LocalTime cero = LocalTime.of(0, 0);
				cero = cero.plusMinutes(aux);
				duraciones.put(vueloDia.customHashCode(), cero);
				vueloDia.setLlegada(vueloDia.salida.plusMinutes(aux));
				System.out.println("hora de llegada" + vueloDia.getLlegada());
				if(vueloDia.getLlegada().isBefore(siete)) {
					System.out.println("Del dia siguente");
				}
				System.out.println("salida "+ vueloDia.autobusConAlas.getOrigen());
				System.out.println("llegada "+ vueloDia.autobusConAlas.getLlegada());
//				
//				vueloDia.autobusConAlas.setLlegada(vueloDia.autobusConAlas.getLlegada());
			}
				chorizo.add(vueloDia.getCode()+ " " +vueloDia.autobusConAlas.getOrigen().nombre+"-"+vueloDia.autobusConAlas.getLlegada().nombre+"\t \t" +vueloDia.getSalida()+ "\t"+vueloDia.getLlegada());
				allFlights.add(vueloDia);

		}
	}
	
	
	public void buscarDestino() {
		Random r = new Random();
		LocalDate champions = LocalDate.of(2022, 5, 28);
		for (Avion av : flota) {
			if(ldt.isEqual(champions)){
				av.setLlegada(Ciudades.PARIS);
			}
			else {
				
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
			
<<<<<<< HEAD
			
			
=======
>>>>>>> branch 'master' of https://github.com/askiji/Aerolinea.git

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
	
//	public void horaLlegada() {
//		Scanner sc = new Scanner(System.in);
//		for (Vuelo v : vuelosDia) {
//			if (AgenciaAerea.tiempoDeVuelo.containsKey(v.hashCode())) {
//				System.out.println("horallegada");
//			}
//		}
//	}
	
}
