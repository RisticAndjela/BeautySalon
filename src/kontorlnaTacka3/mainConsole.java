//package kontorlnaTacka3;
//
//import java.util.HashMap;
//import java.util.Scanner;
//import java.util.Set;
//
//import klase.*;
//
//public class mainConsole {
//
//	public static void main(String[] args) {
//		Klijent klijenat= new Klijent();
//		HashMap<Integer, Klijent> kolekcijaKlijenata =klijenat.openFromFile();
//		Kozmeticar kozmeticar=new Kozmeticar();
//		HashMap<Integer, Kozmeticar> kolekcijaKozmeticara=kozmeticar.openFromFile();
//		Menadzer menadzer= new Menadzer();
//		HashMap<Integer, Menadzer> kolekcijaMenadzera=menadzer.openFromFile();
//		Recepcionar recepcionar=new Recepcionar();
//		HashMap<Integer, Recepcionar> kolekcijaRecepcionara=recepcionar.openFromFile();
//		
//		
//		//System.out.print(kolekcijaKlijenata);
//		//System.out.print(kolekcijaMenadzera);
//		//System.out.print(kolekcijaRecepcionara);
//		//System.out.print(kolekcijaKozmeticara);
//		System.out.println("Dobrodosli u aplikaciju!");
//		Scanner scanner=new Scanner(System.in);
//		boolean vrednost=true;
//		while(vrednost==true) {
//		System.out.println("Unesite vase korisnicko ime:");
//		String username = scanner.nextLine();
//		
//		String uloga="";
//		Korisnik korisnik=new Korisnik();
//		if (uloga=="") {
//		try{
//			Set<Integer> keys = kolekcijaKlijenata.keySet();
//			for(int i : keys) {
//			Klijent klijenatPretraga=kolekcijaKlijenata.get(i);
//			if(klijenatPretraga.getKorisnickoIme().equals(username)) {
//				System.out.println("Nasli smo klijenta po imenu "+ username);
//				uloga="klijent";
//				korisnik=klijenatPretraga;
//			}
//		}
//		}finally {}
//		}
//		if (uloga=="") {
//		try {
//			Set<Integer> keys = kolekcijaMenadzera.keySet();
//		for(int i: keys) {
//			Menadzer menadzerPretraga=kolekcijaMenadzera.get(i);
//			if(menadzerPretraga.getKorisnickoIme().equals(username)) {
//				System.out.println("Nasli smo menadzera po imenu "+ username);
//				uloga="menadzer";
//				korisnik=menadzerPretraga;
//			}
//		}
//		}finally {}
//		}
//		if (uloga=="") {
//		try {
//			Set<Integer> keys = kolekcijaRecepcionara.keySet();
//		for(int i :keys) {
//			Recepcionar recepcionarPretraga=kolekcijaRecepcionara.get(i);
//			if(recepcionarPretraga.getKorisnickoIme().equals(username)) {
//				System.out.println("Nasli smo recepcionara po imenu "+ username);
//				uloga="recepcionar";
//				korisnik=recepcionarPretraga;
//			}
//		}
//		}finally {}
//		}
//		if (uloga=="") {
//		try {
//			Set<Integer> keys = kolekcijaKozmeticara.keySet();
//		for(int i:keys) {
//			Kozmeticar kozmeticarPretraga=kolekcijaKozmeticara.get(i);
//			if(kozmeticarPretraga.getKorisnickoIme().equals(username)) {
//				System.out.println("Nasli smo kozmeticara po imenu "+ username);
//				uloga="kozmeticar";
//				korisnik=kozmeticarPretraga;
//			}
//		}
//		}finally {}
//		}
//		if (uloga=="") {
//			System.out.println("Vas korisnik nije u sistemu,javite se menadzeru");
//			vrednost=false;
//			break;
//		}
//		
//		System.out.println("Unesite vasu lozinku:");
//		String lozinka = scanner.nextLine();
//		boolean vrednost2=true;
//		while(vrednost2==true){
//		if(korisnik.getLozinka().equals(lozinka)) {
//		 System.out.println("Uspesno ste se prijavili, prebacujemo vas na display "+ uloga);
//		 if(uloga=="kozmeticar") {
//			 mainKozmeticar();
//			 vrednost=false;
//			 vrednost2=false;
//		 }
//		 if(uloga=="recepcionar") {
//			 mainRecepcionar();
//			 vrednost=false;
//			 vrednost2=false;
//		 }
//		 if(uloga=="menadzer") {
//			 mainMenadzer();
//			 vrednost=false;
//			 vrednost2=false;
//		 }
//		 if(uloga=="klijent") {
//			 mainKlijent();
//			 vrednost=false;
//			 vrednost2=false;
//		 }
//		}
//		else {
//			System.out.println("Uneli ste pogresnu lozinku");
//			vrednost2=false;
//		}}
//		}
//		
//	}
//	public static void mainKozmeticar() {
//		
//	}
//	public static void mainRecepcionar() {
//		
//	}
//	public static void mainMenadzer() {
//		Klijent klijenat= new Klijent();
//		HashMap<Integer, Klijent> kolekcijaKlijenata =klijenat.openFromFile();
//		Kozmeticar kozmeticar=new Kozmeticar();
//		HashMap<Integer, Kozmeticar> kolekcijaKozmeticara=kozmeticar.openFromFile();
//		Menadzer menadzer= new Menadzer();
//		HashMap<Integer, Menadzer> kolekcijaMenadzera=menadzer.openFromFile();
//		Recepcionar recepcionar=new Recepcionar();
//		HashMap<Integer, Recepcionar> kolekcijaRecepcionara=recepcionar.openFromFile();
//		
//		boolean vrednost3=true;
//		while (vrednost3==true) {
//			System.out.println("Izaberite opciju:");
//			System.out.println("1. Izbrisite korisnika");
//			System.out.println("2. Izmenite korisnika");
//			System.out.println("3. Pregled svih korisnika");
//			System.out.println("4. Dodajte korisnika");
//			System.out.println("5. Uvid u prihode i rashode");
//			System.out.println("6. Lojalti kartice");
//			System.out.println("7. Tretmani");
//			System.out.println("8. Izlaz");
//			Scanner scanner=new Scanner(System.in);
//			String izbor= scanner.nextLine();
//			
//			if(izbor.equals("1")) {
//				boolean vrednost4=true;
//				while(vrednost4==true) {
//					System.out.println("Izaberite opciju:");
//					System.out.println("1. Izbrisite klijenta");
//					System.out.println("2. Izbrisite recepcionara");
//					System.out.println("3. Izbrisite menadzera");
//					System.out.println("4. Izbrisite kozmeticara");
//					System.out.println("5. Vratite se korak nazad");
//					String izbor2= scanner.nextLine();
//					if(izbor2.equals("1")) {
//						Set<Integer> keys = kolekcijaKlijenata.keySet();
//						for(int i:keys){
//
//							klijenat=kolekcijaKlijenata.get(i);
//							System.out.println(klijenat.getIme());
//						}
//						System.out.println("Izaberite klijenta kojeg cete izbrisati");
//						String odgovor=scanner.nextLine();
//						Klijent klijenatZaBrisnaje=new Klijent();
//						for(int i:keys) {
//							klijenat=kolekcijaKlijenata.get(i);
//							if(klijenat.getIme().equals(odgovor)) {
//								klijenatZaBrisnaje=klijenat;
//							}
//						}
//						klijenatZaBrisnaje.brisanjeKlijenta(klijenatZaBrisnaje);	
//						continue;
//					}
//					else if(izbor2.equals("2")) {
//						Set<Integer> keys = kolekcijaRecepcionara.keySet();
//						for(int i:keys){
//
//							recepcionar=kolekcijaRecepcionara.get(i);
//							System.out.println(recepcionar.getIme());
//						}
//						System.out.println("Izaberite recepcionara kojeg cete izbrisati");
//						String odgovor=scanner.nextLine();
//						Recepcionar recepcionarZaBrisnaje=new Recepcionar();
//						for(int i:keys) {
//							recepcionar=kolekcijaRecepcionara.get(i);
//							if(recepcionar.getIme().equals(odgovor)) {
//								recepcionarZaBrisnaje=recepcionar;
//							}
//							
//						}
//						recepcionarZaBrisnaje.brisanjeRecepcionara(recepcionarZaBrisnaje);
//						continue;
//					}
//					else if(izbor2.equals("3")) {
//						Set<Integer> keys = kolekcijaMenadzera.keySet();
//						for(int i:keys) {
//
//							menadzer=kolekcijaMenadzera.get(i);
//							System.out.println(menadzer.getIme());
//						}
//						System.out.println("Izaberite menadzera kojeg cete izbrisati");
//						String odgovor=scanner.nextLine();
//						Menadzer menadzerZaBrisnaje=new Menadzer();
//						for(int i:keys) {
//							menadzer=kolekcijaMenadzera.get(i);
//							if(menadzer.getIme().equals(odgovor)) {
//								menadzerZaBrisnaje=menadzer;
//							}
//						}
//						menadzerZaBrisnaje.brisanjeMenadzera(menadzerZaBrisnaje);
//						continue;
//					}
//					else if(izbor2.equals("4")) {
//						Set<Integer> keys = kolekcijaKozmeticara.keySet();
//						for(int i:keys) {
//
//							kozmeticar=kolekcijaKozmeticara.get(i);
//							System.out.println(kozmeticar.getIme());
//						}
//						System.out.println("Izaberite kozmeticara kojeg cete izbrisati");
//						String odgovor=scanner.nextLine();
//						Kozmeticar kozmeticarZaBrisnaje=new Kozmeticar();
//						for(int i:keys) {
//							kozmeticar=kolekcijaKozmeticara.get(i);
//							if(kozmeticar.getIme().equals(odgovor)) {
//								kozmeticarZaBrisnaje=kozmeticar;
//							}
//						}
//						kozmeticarZaBrisnaje.brisanjeKozmeticara(kozmeticarZaBrisnaje);
//						continue;
//					}
//					else if(izbor2.equals("5")) {
//						vrednost4=false;
//						continue;
//					}
//					else {
//						System.out.println("Izabrali ste nepostojecu opciju");
//						continue;
//					}
//
//				}
//			}
//			else if(izbor.equals("2")) {
//				boolean vrednost4=true;
//				while(vrednost4==true) {
//					System.out.println("Izaberite opciju:");
//					System.out.println("1. Izmenite klijenta");
//					System.out.println("2. Izmenite recepcionara");
//					System.out.println("3. Izmenite menadzera");
//					System.out.println("4. Izmenite kozmeticara");
//					System.out.println("5. Vratite se korak nazad");
//					String izbor2= scanner.nextLine();
//					if(izbor2.equals("1")) {
//						Set<Integer> keys = kolekcijaKlijenata.keySet();
//						for(int i:keys){
//
//							klijenat=kolekcijaKlijenata.get(i);
//							System.out.println(klijenat.getIme());
//						}
//						System.out.println("Izaberite klijenta kojeg cete izmeniti");
//						String odgovor=scanner.nextLine();
//						Klijent klijenatZaIzmenu=new Klijent();
//						for(int i:keys) {
//							klijenat=kolekcijaKlijenata.get(i);
//							if(klijenat.getIme().equals(odgovor)) {
//								klijenatZaIzmenu=klijenat;
//							}
//						}
//						
//						System.out.println("Izaberite novo ime korisnika:");
//						String novoIme=scanner.nextLine();
//						System.out.println("Izaberite novo prezime korisnika:");
//						String novoPrezime=scanner.nextLine();
//						System.out.println("Izaberite novi pol korisnika:");
//						String noviPol=scanner.nextLine();
//						System.out.println("Izaberite novi broj telefona korisnika:");
//						String noviBrojTelefona=scanner.nextLine();
//						System.out.println("Izaberite novu adresu korisnika:");
//						String novaAdresa=scanner.nextLine();
//						System.out.println("Izaberite novo korisnicko ime korisnika:");
//						String novoKorisnickoIme=scanner.nextLine();
//						System.out.println("Izaberite novu lozinku korisnika:");
//						String novaLozinka=scanner.nextLine();
//						Klijent noviKlijent=new Klijent(novoIme,novoPrezime,noviPol, noviBrojTelefona,novaAdresa,novoKorisnickoIme,novaLozinka);
//						klijenatZaIzmenu.editovanjeKlijenata(klijenatZaIzmenu, noviKlijent);
//						
//						continue;
//					}
//					else if(izbor2.equals("2")) {
//						Set<Integer> keys = kolekcijaRecepcionara.keySet();
//						for(int i:keys){
//
//							recepcionar=kolekcijaRecepcionara.get(i);
//							System.out.println(recepcionar.getIme());
//						}
//						System.out.println("Izaberite recepcionara kojeg cete izmeniti");
//						String odgovor=scanner.nextLine();
//						Recepcionar recepcionarZaIzmenu=new Recepcionar();
//						for(int i:keys) {
//							recepcionar=kolekcijaRecepcionara.get(i);
//							if(recepcionar.getIme().equals(odgovor)) {
//								recepcionarZaIzmenu=recepcionar;
//							}
//						}
//						
//						System.out.println("Izaberite novo ime korisnika:");
//						String novoIme=scanner.nextLine();
//						System.out.println("Izaberite novo prezime korisnika:");
//						String novoPrezime=scanner.nextLine();
//						System.out.println("Izaberite novi pol korisnika:");
//						String noviPol=scanner.nextLine();
//						System.out.println("Izaberite novi broj telefona korisnika:");
//						String noviBrojTelefona=scanner.nextLine();
//						System.out.println("Izaberite novu adresu korisnika:");
//						String novaAdresa=scanner.nextLine();
//						System.out.println("Izaberite novo korisnicko ime korisnika:");
//						String novoKorisnickoIme=scanner.nextLine();
//						System.out.println("Izaberite novu lozinku korisnika:");
//						String novaLozinka=scanner.nextLine();
//						System.out.println("Izaberite novu lozinku korisnika:");
//						String novaStrucnaSprema=scanner.nextLine();
//						System.out.println("Izaberite novu strucnu spremu korisnika:");
//						String noviStaz=scanner.nextLine();
//						System.out.println("Izaberite novu staz korisnika:");
//						int noviBonus=scanner.nextInt();
//						System.out.println("Izaberite novu platu korisnika:");
//						Double novaPlata=scanner.nextDouble();
//						Recepcionar noviRecepcionar=new Recepcionar(novoIme,novoPrezime,noviPol, noviBrojTelefona,novaAdresa,novoKorisnickoIme,novaLozinka,novaStrucnaSprema,noviStaz,noviBonus,novaPlata);
//						recepcionarZaIzmenu.editovanjeRecepcionara(recepcionarZaIzmenu, noviRecepcionar);
//						continue;
//					}
//					else if(izbor2.equals("3")) {
//						Set<Integer> keys = kolekcijaMenadzera.keySet();
//						for(int i:keys){
//
//							menadzer=kolekcijaMenadzera.get(i);
//							System.out.println(menadzer.getIme());
//						}
//						System.out.println("Izaberite menadzera kojeg cete izmeniti");
//						String odgovor=scanner.nextLine();
//						Menadzer menadzerZaIzmenu=new Menadzer();
//						for(int i:keys) {
//							menadzer=kolekcijaMenadzera.get(i);
//							if(menadzer.getIme().equals(odgovor)) {
//								menadzerZaIzmenu=menadzer;
//							}
//						}
//						
//						System.out.println("Izaberite novo ime korisnika:");
//						String novoIme=scanner.nextLine();
//						System.out.println("Izaberite novo prezime korisnika:");
//						String novoPrezime=scanner.nextLine();
//						System.out.println("Izaberite novi pol korisnika:");
//						String noviPol=scanner.nextLine();
//						System.out.println("Izaberite novi broj telefona korisnika:");
//						String noviBrojTelefona=scanner.nextLine();
//						System.out.println("Izaberite novu adresu korisnika:");
//						String novaAdresa=scanner.nextLine();
//						System.out.println("Izaberite novo korisnicko ime korisnika:");
//						String novoKorisnickoIme=scanner.nextLine();
//						System.out.println("Izaberite novu lozinku korisnika:");
//						String novaLozinka=scanner.nextLine();
//						System.out.println("Izaberite novu lozinku korisnika:");
//						String novaStrucnaSprema=scanner.nextLine();
//						System.out.println("Izaberite novu strucnu spremu korisnika:");
//						String noviStaz=scanner.nextLine();
//						System.out.println("Izaberite novu staz korisnika:");
//						int noviBonus=scanner.nextInt();
//						System.out.println("Izaberite novu platu korisnika:");
//						Double novaPlata=scanner.nextDouble();
//						Menadzer noviMenadzer=new Menadzer(novoIme,novoPrezime,noviPol, noviBrojTelefona,novaAdresa,novoKorisnickoIme,novaLozinka,novaStrucnaSprema,noviStaz,noviBonus,novaPlata);
//						menadzerZaIzmenu.editovanjeMenadzera(menadzerZaIzmenu, noviMenadzer);
//						continue;					}
//					else if(izbor2.equals("4")) {
//						Set<Integer> keys = kolekcijaKozmeticara.keySet();
//						for(int i:keys){
//
//							kozmeticar=kolekcijaKozmeticara.get(i);
//							System.out.println(kozmeticar.getIme());
//						}
//						System.out.println("Izaberite kozmeticara kojeg cete izmeniti");
//						String odgovor=scanner.nextLine();
//						Kozmeticar kozmeticarZaIzmenu=new Kozmeticar();
//						for(int i:keys) {
//							kozmeticar=kolekcijaKozmeticara.get(i);
//							if(kozmeticar.getIme().equals(odgovor)) {
//								kozmeticarZaIzmenu=kozmeticar;
//							}
//						}
//						
//						System.out.println("Izaberite novo ime korisnika:");
//						String novoIme=scanner.nextLine();
//						System.out.println("Izaberite novo prezime korisnika:");
//						String novoPrezime=scanner.nextLine();
//						System.out.println("Izaberite novi pol korisnika:");
//						String noviPol=scanner.nextLine();
//						System.out.println("Izaberite novi broj telefona korisnika:");
//						String noviBrojTelefona=scanner.nextLine();
//						System.out.println("Izaberite novu adresu korisnika:");
//						String novaAdresa=scanner.nextLine();
//						System.out.println("Izaberite novo korisnicko ime korisnika:");
//						String novoKorisnickoIme=scanner.nextLine();
//						System.out.println("Izaberite novu lozinku korisnika:");
//						String novaLozinka=scanner.nextLine();
//						System.out.println("Izaberite novu lozinku korisnika:");
//						String novaStrucnaSprema=scanner.nextLine();
//						System.out.println("Izaberite novu strucnu spremu korisnika:");
//						String noviStaz=scanner.nextLine();
//						System.out.println("Izaberite novu staz korisnika:");
//						int noviBonus=scanner.nextInt();
//						System.out.println("Izaberite novu platu korisnika:");
//						Double novaPlata=scanner.nextDouble();
//						System.out.println("Izaberite nove tretmane korisnika odvojene \",\":");
//						String noviTretmani=scanner.nextLine();
//						String[] tretmaniLista=noviTretmani.split(",");
//						ArrayList<String> tretmani= new ArrayList<String>();
//						for(String i : tretmaniLista) {
//							tretmani.add(i);
//						}
//						//Kozmeticar noviKozmeticar=new Kozmeticar(novoIme,novoPrezime,noviPol, noviBrojTelefona,novaAdresa,novoKorisnickoIme,novaLozinka,novaStrucnaSprema,noviStaz,noviBonus,novaPlata,tretmani);
//						//kozmeticarZaIzmenu.editovanjeKozmeticara(kozmeticarZaIzmenu, noviKozmeticar);
//						continue;							}
//					else if(izbor2.equals("5")) {
//						vrednost4=false;
//						continue;
//					}
//					else {
//						System.out.println("Izabrali ste nepostojecu opciju");
//						continue;
//					}
//
//				}		
//						}
//			else if(izbor.equals("3")) {
//				boolean vrednost4=true;
//				while(vrednost4==true) {
//					System.out.println("Izaberite opciju:");
//					System.out.println("1. Pregled svih klijenata");
//					System.out.println("2. Pregled svih recepcionara");
//					System.out.println("3. Pregled svih menadzera");
//					System.out.println("4. Pregled svih kozmeticara");
//					System.out.println("5. Vratite se korak nazad");
//					String izbor2= scanner.nextLine();
//					if(izbor2.equals("1")) {
//						Set<Integer> keys = kolekcijaKlijenata.keySet();
//						for(int i:keys) {
//							klijenat=kolekcijaKlijenata.get(i);
//							System.out.println(klijenat.toString());
//						}
//						continue;
//					}
//					else if(izbor2.equals("2")) {
//						Set<Integer> keys = kolekcijaRecepcionara.keySet();
//						for(int i:keys) {
//							Recepcionar recepcionar1=new Recepcionar();
//							recepcionar1=kolekcijaRecepcionara.get(i);
//							System.out.println(recepcionar1.toString());
//						}
//						continue;
//					}
//					else if(izbor2.equals("3")) {
//						Set<Integer> keys = kolekcijaMenadzera.keySet();
//						for(int i:keys) {
//							Menadzer menadzer1=new Menadzer();
//							menadzer1=kolekcijaMenadzera.get(i);
//							System.out.println(menadzer1.toString());
//						}
//						continue;
//					}
//					else if(izbor2.equals("4")) {
//						Set<Integer> keys = kolekcijaKozmeticara.keySet();
//						for(int i:keys) {
//							Kozmeticar kozmeticar1=new Kozmeticar();
//							kozmeticar1=kolekcijaKozmeticara.get(i);
//							System.out.println(kozmeticar1.toString());
//						}
//						continue;
//					}
//					else if(izbor2.equals("5")) {
//						vrednost4=false;
//						continue;
//					}
//					else {
//						System.out.println("Izabrali ste nepostojecu opciju");
//						continue;
//					}
//
//				}
//			}
//			else if(izbor.equals("4")) {
//				boolean vrednost4=true;
//				while(vrednost4==true) {
//					System.out.println("Izaberite opciju:");
//					System.out.println("1. Dodajte klijenta");
//					System.out.println("2. Dodajte recepcionara");
//					System.out.println("3. Dodajte menadzera");
//					System.out.println("4. Dodajte kozmeticara");
//					System.out.println("5. Vratite se korak nazad");
//					String izbor2= scanner.nextLine();
//					if(izbor2.equals("1")) {
//						System.out.println("Izaberite novo ime korisnika:");
//						String novoIme=scanner.nextLine();
//						System.out.println("Izaberite novo prezime korisnika:");
//						String novoPrezime=scanner.nextLine();
//						System.out.println("Izaberite novi pol korisnika:");
//						String noviPol=scanner.nextLine();
//						System.out.println("Izaberite novi broj telefona korisnika:");
//						String noviBrojTelefona=scanner.nextLine();
//						System.out.println("Izaberite novu adresu korisnika:");
//						String novaAdresa=scanner.nextLine();
//						System.out.println("Izaberite novo korisnicko ime korisnika:");
//						String novoKorisnickoIme=scanner.nextLine();
//						System.out.println("Izaberite novu lozinku korisnika:");
//						String novaLozinka=scanner.nextLine();
//						Klijent noviKlijent=new Klijent(novoIme,novoPrezime,noviPol, noviBrojTelefona,novaAdresa,novoKorisnickoIme,novaLozinka);
//						noviKlijent.cuvanjeKlijenta(noviKlijent);
//						continue;
//					}
//					else if(izbor2.equals("2")) {
//						System.out.println("Izaberite novo ime korisnika:");
//						String novoIme=scanner.nextLine();
//						System.out.println("Izaberite novo prezime korisnika:");
//						String novoPrezime=scanner.nextLine();
//						System.out.println("Izaberite novi pol korisnika:");
//						String noviPol=scanner.nextLine();
//						System.out.println("Izaberite novi broj telefona korisnika:");
//						String noviBrojTelefona=scanner.nextLine();
//						System.out.println("Izaberite novu adresu korisnika:");
//						String novaAdresa=scanner.nextLine();
//						System.out.println("Izaberite novo korisnicko ime korisnika:");
//						String novoKorisnickoIme=scanner.nextLine();
//						System.out.println("Izaberite novu lozinku korisnika:");
//						String novaLozinka=scanner.nextLine();
//						System.out.println("Izaberite novu lozinku korisnika:");
//						String novaStrucnaSprema=scanner.nextLine();
//						System.out.println("Izaberite novu strucnu spremu korisnika:");
//						String noviStaz=scanner.nextLine();
//						System.out.println("Izaberite novu staz korisnika:");
//						int noviBonus=scanner.nextInt();
//						System.out.println("Izaberite novu platu korisnika:");
//						Double novaPlata=scanner.nextDouble();
//						Recepcionar noviRecepcionar=new Recepcionar(novoIme,novoPrezime,noviPol, noviBrojTelefona,novaAdresa,novoKorisnickoIme,novaLozinka,novaStrucnaSprema,noviStaz,noviBonus,novaPlata);
//						noviRecepcionar.cuvanjeRecepcionara(noviRecepcionar);
//						continue;
//					}
//					else if(izbor2.equals("3")) {
//						System.out.println("Izaberite novo ime korisnika:");
//						String novoIme=scanner.nextLine();
//						System.out.println("Izaberite novo prezime korisnika:");
//						String novoPrezime=scanner.nextLine();
//						System.out.println("Izaberite novi pol korisnika:");
//						String noviPol=scanner.nextLine();
//						System.out.println("Izaberite novi broj telefona korisnika:");
//						String noviBrojTelefona=scanner.nextLine();
//						System.out.println("Izaberite novu adresu korisnika:");
//						String novaAdresa=scanner.nextLine();
//						System.out.println("Izaberite novo korisnicko ime korisnika:");
//						String novoKorisnickoIme=scanner.nextLine();
//						System.out.println("Izaberite novu lozinku korisnika:");
//						String novaLozinka=scanner.nextLine();
//						System.out.println("Izaberite novu lozinku korisnika:");
//						String novaStrucnaSprema=scanner.nextLine();
//						System.out.println("Izaberite novu strucnu spremu korisnika:");
//						String noviStaz=scanner.nextLine();
//						System.out.println("Izaberite novu staz korisnika:");
//						int noviBonus=scanner.nextInt();
//						System.out.println("Izaberite novu platu korisnika:");
//						Double novaPlata=scanner.nextDouble();
//						Menadzer noviMenadzer=new Menadzer(novoIme,novoPrezime,noviPol, noviBrojTelefona,novaAdresa,novoKorisnickoIme,novaLozinka,novaStrucnaSprema,noviStaz,noviBonus,novaPlata);
//						noviMenadzer.cuvanjeMenadzera(noviMenadzer);;
//						continue;
//					}
//					else if(izbor2.equals("4")) {
//						System.out.println("Izaberite novo ime korisnika:");
//						String novoIme=scanner.nextLine();
//						System.out.println("Izaberite novo prezime korisnika:");
//						String novoPrezime=scanner.nextLine();
//						System.out.println("Izaberite novi pol korisnika:");
//						String noviPol=scanner.nextLine();
//						System.out.println("Izaberite novi broj telefona korisnika:");
//						String noviBrojTelefona=scanner.nextLine();
//						System.out.println("Izaberite novu adresu korisnika:");
//						String novaAdresa=scanner.nextLine();
//						System.out.println("Izaberite novo korisnicko ime korisnika:");
//						String novoKorisnickoIme=scanner.nextLine();
//						System.out.println("Izaberite novu lozinku korisnika:");
//						String novaLozinka=scanner.nextLine();
//						System.out.println("Izaberite novu lozinku korisnika:");
//						String novaStrucnaSprema=scanner.nextLine();
//						System.out.println("Izaberite novu strucnu spremu korisnika:");
//						String noviStaz=scanner.nextLine();
//						System.out.println("Izaberite novu staz korisnika:");
//						int noviBonus=scanner.nextInt();
//						System.out.println("Izaberite novu platu korisnika:");
//						Double novaPlata=scanner.nextDouble();
//						System.out.println("Izaberite nove tretmane korisnika odvojene \",\":");
//						String noviTretmani=scanner.nextLine();
//						String[] tretmaniLista=noviTretmani.split(",");
//						ArrayList<String> tretmani= new ArrayList<String>();
//						for(String i : tretmaniLista) {
//							tretmani.add(i);
//						}
//						Kozmeticar noviKozmeticar=new Kozmeticar(novoIme,novoPrezime,noviPol, noviBrojTelefona,novaAdresa,novoKorisnickoIme,novaLozinka,novaStrucnaSprema,noviStaz,noviBonus,novaPlata,tretmani);
//						noviKozmeticar.cuvanjeKozmeticara(noviKozmeticar);
//						continue;
//					}
//					else if(izbor2.equals("5")) {
//						vrednost4=false;
//						continue;
//					}
//					else {
//						System.out.println("Izabrali ste nepostojecu opciju");
//						continue;
//					}
//
//				}
//			}
//			else if(izbor.equals("5")) {
//				
//			}
//			else if(izbor.equals("6")) {
//				
//			}
//			else if(izbor.equals("7")) {
//				
//			}
//			else if(izbor.equals("8")) {
//				vrednost3=false;
//				continue;
//			}
//			else {
//				System.out.println("Izabrali ste nepostojecu opciju");
//			}
//		}
//	}
//	public static void mainKlijent() {
//	
//	}
//
//	}
//
//}
