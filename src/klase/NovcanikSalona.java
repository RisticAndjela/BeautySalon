package klase;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import tretmani.Opcije;
import tretmani.ZakazanTretman;

public class NovcanikSalona {
	private double prihodi=0.0;
	private double rashodi=0.0;
	public ArrayList<String> prihodiLista=new ArrayList<String>();
	public ArrayList<String> rashodiLista=new ArrayList<String>();
	
	public NovcanikSalona() {	
		readDataFromFile() ;
	}
	public ArrayList<String> getPrihodiLista() {
		return prihodiLista;
	}
	public void setPrihodiLista(ArrayList<String> prihodiLista) {
		this.prihodiLista = prihodiLista;
	}
	public ArrayList<String> getRashodiLista() {
		return rashodiLista;
	}
	public void setRashodiLista(ArrayList<String> rashodiLista) {
		this.rashodiLista = rashodiLista;
	}
	public double getPrihodi() {
		return prihodi;
	}
	public void setPrihodi(double prihodi) {
		this.prihodi = prihodi;
	}
	public double getRashodi() {
		return rashodi;
	}
	public void setRashodi(double rashodi) {
		this.rashodi = rashodi;
	}

	
	public ArrayList<String> rashodiUJM(Month mesec,ArrayList<Kozmeticar> kozmeticari,ArrayList<Menadzer>menadzeri,ArrayList<Recepcionar> recepcionari) {
	
		ArrayList<String> ovajMesec=new ArrayList<String>();
		for(String i : rashodiLista) {
			String[] podaci=i.split(" ");
			if(mesec==Month.valueOf(podaci[1])) {
				ovajMesec.add(i);
			}
		}
		return ovajMesec;
	}
	public double dodelaPlateZaJedanMesec(Month mesec,ArrayList<Kozmeticar> kozmeticari,ArrayList<Menadzer>menadzeri,ArrayList<Recepcionar> recepcionari) {
		double svePlateOvajMesec;
		svePlateOvajMesec=this.plateZaSveKozmeticareJM(mesec,kozmeticari);
		svePlateOvajMesec+=this.plateZaSveMenadzereJM(mesec,menadzeri);
		svePlateOvajMesec+=this.plateZaSveRecepcionareJM(mesec,recepcionari);
		rashodi-=svePlateOvajMesec;
		
		return svePlateOvajMesec;
	}
	public double plateZaSveKozmeticareJM(Month mesec,ArrayList<Kozmeticar> kozmeticari) {
		double plateKozmeticara=0.0;
		for(Kozmeticar kozmeticar:kozmeticari) {
			plateKozmeticara+=kozmeticar.getKonacnaPlata();
		}
		this.rashodiLista.add("plate_kozmeticara_za_JM:-"+mesec.toString()+Double.toString(plateKozmeticara));
		System.out.println("Plate svih kozmeticara za jedan mesec:"+Double.toString(plateKozmeticara));
		return plateKozmeticara;
	}
	public double plateZaSveMenadzereJM(Month mesec,ArrayList<Menadzer>menadzeri) {
		double plateMenadzera=0.0;
		for(Menadzer menadzer:menadzeri) {
			plateMenadzera+=menadzer.getKonacnaPlata();
		}
		this.rashodiLista.add("plate_menadzere_za_JM:-"+mesec.toString()+Double.toString(plateMenadzera));
		System.out.println("Plate svih menadzera za jedan mesec:"+Double.toString(plateMenadzera));
		return plateMenadzera;		
	}
	public double plateZaSveRecepcionareJM(Month mesec,ArrayList<Recepcionar> recepcionari) {
		double plateRecepcionara=0.0;
		for(Recepcionar recepcionar:recepcionari) {
			plateRecepcionara+=recepcionar.getKonacnaPlata();
		}
		this.rashodiLista.add("plate_recepcionara_za_JM:-"+mesec.toString()+Double.toString(plateRecepcionara));
		System.out.println("Plate svih recepcionara za jedan mesec:"+Double.toString(plateRecepcionara));
		return plateRecepcionara;
	}
	
	public void zavrsenTretman(double cena,LocalDateTime datum, Opcije opcija) {
		this.setPrihodi(this.getPrihodi()+cena);
		this.prihodiLista.add(datum.toString()+" "+Double.toString(cena)+" "+opcija.toString());
	}
	public void gotovMesecUnesiUfajl(Month mesec,ArrayList<Kozmeticar> kozmeticari,ArrayList<Menadzer>menadzeri,ArrayList<Recepcionar> recepcionari) {
		
		double svePlateOvajMesec=dodelaPlateZaJedanMesec(mesec,kozmeticari,menadzeri,recepcionari);
		File file=new File("C:\\Users\\User\\eclipse-workspace\\kt3_sv_67_2022\\src\\klase\\sacuvaniPodaci\\novcanik.txt");
		String string=mesec.toString()+","+Double.toString(svePlateOvajMesec)+","+Double.toString(prihodiUJMDouble(mesec));
		try {
			FileWriter fr = new FileWriter(file, true);
			BufferedWriter br = new BufferedWriter(fr);
			br.write(string);
			br.close();
			fr.close();
		} catch (IOException e) {
			System.out.print(e.getMessage());
		}
	}
	public ArrayList<String> prihodiUJMLista(Month mesec) {
		ArrayList<String> ovajMesec=new ArrayList<String>();
		for(String i : prihodiLista) {
			String[] podaci=i.split(" ");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
			LocalDateTime dateTime = LocalDateTime.parse(podaci[0], formatter);
			if(mesec==dateTime.getMonth()) {
				ovajMesec.add(i);
			}
		}
		return ovajMesec;
	}
	public double prihodiUJMDouble(Month mesec) {
		double prihodiZaOvajMesec=0;
		for(String i : prihodiLista) {
			String[] podaci=i.split(" ");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
			LocalDateTime dateTime = LocalDateTime.parse(podaci[0], formatter);
			if(mesec==dateTime.getMonth()) {
				prihodiZaOvajMesec+=Double.parseDouble(podaci[1]);
			}
		}
		return prihodiZaOvajMesec;
	}
	
	public void sviPrihodiIRashodiUJM(Month mesec,ArrayList<Kozmeticar> kozmeticari,ArrayList<Menadzer>menadzeri,ArrayList<Recepcionar> recepcionari) {
		System.out.println("--------PRIHODI I RASHODI U MESECU------------");
		for(String i: this.rashodiLista) {
			
		}
		int d=0;
		for(String s :this.prihodiUJMLista(mesec)) {
			d++;
			System.out.println("Tretman u junu "+d+": "+ s);
		}
		
		System.out.println("Ukupno prihoda za mesec je"+this.getPrihodi()+", ukupno rashoda za mesec je"+this.getRashodi());
	}
	public void readDataFromFile() {
		File file=new File("C:\\Users\\User\\eclipse-workspace\\kt3_sv_67_2022\\src\\klase\\sacuvaniPodaci\\novcanik.txt");
		if(file.length()!=0) {
			try {
			      Scanner myReader = new Scanner(file);
			      while (myReader.hasNextLine()) {
			        String data = myReader.nextLine();
			        String[] podaci=data.split(",");
                Month mesec = Month.valueOf(podaci[0]);
                double plate = Double.parseDouble(podaci[1]);
                double prihodi = Double.parseDouble(podaci[2]);
                this.prihodi+=prihodi;
                this.rashodi+=plate;
                this.rashodiLista.add("plate_kozmeticara_za_JM:-" + mesec.toString() + Double.toString(plate));
                this.prihodiLista.add(mesec.toString() + " " + Double.toString(prihodi));
			      }
			      myReader.close();
			    } catch (FileNotFoundException e) {
			      e.printStackTrace();
			    }
			}
	}}
