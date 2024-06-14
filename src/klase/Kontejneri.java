package klase;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

import tretmani.Opcije;
import tretmani.TipTretmana;
import tretmani.Tretman;
import tretmani.ZakazanTretman;

public class Kontejneri {
	

	public ArrayList<Klijent> klijenti = new ArrayList<Klijent>();
	public ArrayList<Kozmeticar> kozmeticari = new ArrayList<Kozmeticar>();
	public ArrayList<Menadzer> menadzeri = new ArrayList<Menadzer>();
	public ArrayList<Recepcionar> recepcionari = new ArrayList<Recepcionar>();
	public ArrayList<Tretman> tretmani = new ArrayList<Tretman>();
	public ArrayList<ZakazanTretman> zakazaniTretmani = new ArrayList<ZakazanTretman>();
	public ArrayList<TipTretmana> tipoviTretmana= new ArrayList<TipTretmana>();
	public ArrayList<KarticaLojalnosti> karticeLojalnosti=new ArrayList<KarticaLojalnosti>();
	
	public Kontejneri() {
		this.ucitajSveKlijente();
		this.ucitajSveKozmeticare();
		this.ucitajSveReceocionare();
		this.ucitajSveMenadzere();
		this.ucitajSveTipoveTretmana();
		this.ucitajSveTretmane();
		this.ucitajSveZakazaneTretmane();
		this.ucitajSveKarticeLojalnosti();
		
		//this.prikaziSveKorisnike();
	}
	private void ucitajSveKarticeLojalnosti() {
		File file = new File("C:\\Users\\User\\eclipse-workspace\\kt3_sv_67_2022\\src\\klase\\sacuvaniPodaci\\lojaltiKartice.txt");
		if(file.length()!=0) {
		try {
		      Scanner myReader = new Scanner(file);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String[] podaci=data.split(",");
		        String[] menadzerPodaci= podaci[0].split("-");
		   
		        Menadzer menadzer= new Menadzer(menadzerPodaci[0],menadzerPodaci[1],menadzerPodaci[2],menadzerPodaci[3],menadzerPodaci[4],menadzerPodaci[5],menadzerPodaci[6],menadzerPodaci[7],menadzerPodaci[8],Integer.parseInt(menadzerPodaci[9]),Double.parseDouble(menadzerPodaci[10]));
		        KarticaLojalnosti kartica=new KarticaLojalnosti(menadzer,Double.parseDouble(podaci[1]),this);
		        karticeLojalnosti.add(kartica);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      e.printStackTrace();
		    }
		}
		
	}
	public void ucitajSveKlijente() {
		File file = new File("C:\\Users\\User\\eclipse-workspace\\kt3_sv_67_2022\\src\\klase\\sacuvaniPodaci\\klijenti.txt");
		if(file.length()!=0) {
		try {
		      Scanner myReader = new Scanner(file);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String[] podaci=data.split(",");
		        Klijent klijent=new Klijent(podaci[0],podaci[1],podaci[2],podaci[3],podaci[4],podaci[5],podaci[6]);
		        klijenti.add(klijent);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      e.printStackTrace();
		    }
		}
		
	}
	public void ucitajSveKozmeticare() {
		File file = new File("C:\\Users\\User\\eclipse-workspace\\kt3_sv_67_2022\\src\\klase\\sacuvaniPodaci\\kozmeticari.txt");
		if(file.length()!=0) {
		try {
		      Scanner myReader = new Scanner(file);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String[] podaci=data.split(",");
		        String[] menadzerPodaci= podaci[0].split("-");
		   
		        String[] kozmetickiTretmani= podaci[12].split("-");
		        ArrayList<TipTretmana> kozmetickiTretmaniArray= new  ArrayList<TipTretmana>();
		        for(String i: kozmetickiTretmani) {
		        	TipTretmana tip=new TipTretmana(i);
		        	kozmetickiTretmaniArray.add(tip);
		        }
		        Menadzer menadzer= new Menadzer(menadzerPodaci[0],menadzerPodaci[1],menadzerPodaci[2],menadzerPodaci[3],menadzerPodaci[4],menadzerPodaci[5],menadzerPodaci[6],menadzerPodaci[7],menadzerPodaci[8],Integer.parseInt(menadzerPodaci[9]),Double.parseDouble(menadzerPodaci[10]));
		        Kozmeticar kozmeticar=new Kozmeticar(menadzer,podaci[1],podaci[2],podaci[3],podaci[4],podaci[5],podaci[6],podaci[7],podaci[8],podaci[9],Integer.parseInt(podaci[10]),Double.parseDouble(podaci[11]),kozmetickiTretmaniArray);
		        kozmeticari.add(kozmeticar);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      e.printStackTrace();
		    }
		}
		
}
	public void ucitajSveReceocionare() {
		File file = new File("C:\\Users\\User\\eclipse-workspace\\kt3_sv_67_2022\\src\\klase\\sacuvaniPodaci\\recepcionari.txt");
		if(file.length()!=0) {
		try {
		      Scanner myReader = new Scanner(file);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String[] podaci=data.split(",");
		        String[] menadzerPodaci= podaci[0].split("-"); 
		        Menadzer menadzer= new Menadzer(menadzerPodaci[0],menadzerPodaci[1],menadzerPodaci[2],menadzerPodaci[3],menadzerPodaci[4],menadzerPodaci[5],menadzerPodaci[6],menadzerPodaci[7],menadzerPodaci[8],Integer.parseInt(menadzerPodaci[9]),Double.parseDouble(menadzerPodaci[10]));
		        Recepcionar recepcionar=new Recepcionar(menadzer,podaci[1],podaci[2],podaci[3],podaci[4],podaci[5],podaci[6],podaci[7],podaci[8],podaci[9],Integer.parseInt(podaci[10]),Double.parseDouble(podaci[11]));
		        recepcionari.add(recepcionar);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      e.printStackTrace();
		    }
		}
	}
	public void ucitajSveMenadzere() {
		File file = new File("C:\\Users\\User\\eclipse-workspace\\kt3_sv_67_2022\\src\\klase\\sacuvaniPodaci\\menadzeri.txt");
		if(file.length()!=0) {
		try {
		      Scanner myReader = new Scanner(file);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String[] menadzerPodaci=data.split(",");
		        Menadzer menadzer= new Menadzer(menadzerPodaci[0],menadzerPodaci[1],menadzerPodaci[2],menadzerPodaci[3],menadzerPodaci[4],menadzerPodaci[5],menadzerPodaci[6],menadzerPodaci[7],menadzerPodaci[8],Integer.parseInt(menadzerPodaci[9]),Double.parseDouble(menadzerPodaci[10]));
		        menadzeri.add(menadzer);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      e.printStackTrace();
		    }
		}
	}
	public void prikaziSveKlijente(){
		System.out.println("------SVI KLIJENTI------");
		for(int i = 0;i<this.klijenti.size();i++) {
			System.out.println("KLIJENT "+(i+1)+": \n"+this.klijenti.get(i).napraviString());
		}
	}
	
	public void prikaziSveKozmeticare(){
	System.out.println("------SVI KOZMETICARI------");
		for(int i = 0;i<this.kozmeticari.size();i++) {
			System.out.println("KOZMETICAR "+(i+1)+": \n"+this.kozmeticari.get(i).napraviString());
		}
	}
	
	public void prikaziSveMenadzere(){
	System.out.println("------SVI MENADZERI------");
		for(int i = 0;i<this.menadzeri.size();i++) {
			System.out.println("MENADZER "+(i+1)+": \n"+this.menadzeri.get(i).napraviString());
		}
	}
	
	public void prikaziSveRecepcionare(){
	System.out.println("------SVI RECEPCIONARI------");
		for(int i = 0;i<this.recepcionari.size();i++) {
			System.out.println("RECEPCIONAR "+(i+1)+": \n"+this.recepcionari.get(i).napraviString());
		}
	}
	public void prikaziSveKorisnike() {
		System.out.println("------------------------SVI KORISNICI------------------------");
		this.prikaziSveKlijente();
		this.prikaziSveKozmeticare();
		this.prikaziSveMenadzere();
		this.prikaziSveRecepcionare();
	}
	public void prikaziSveTretmane(){
	System.out.println("------SVI TRETMANI------");
		for(int i = 0;i<this.tretmani.size();i++) {
			System.out.println("TRETMAN "+(i+1)+": \n"+this.tretmani.get(i).napraviString());
		}
	}
	
	public void prikaziSveZakazaneTretmane(){
	System.out.println("------SVI ZAKAZANI TRETMANI------");
		for(int i = 0;i<this.zakazaniTretmani.size();i++) {
			System.out.println("ZAKAZAN TRETMAN "+(i+1)+": \n"+this.zakazaniTretmani.get(i).napraviString());
		}
	}
	
	public void prikaziSveTipoveTretmana(){
	System.out.println("------SVI TIPOVI TRETMANA------");
		for(int i = 0;i<this.tipoviTretmana.size();i++) {
			System.out.println("TIP TRETMANA "+(i+1)+": \n"+this.tipoviTretmana.get(i).napraviString());
		}
	}
	public  void ucitajSveZakazaneTretmane() {
		File file = new File("C:\\Users\\User\\eclipse-workspace\\kt3_sv_67_2022\\src\\klase\\sacuvaniPodaci\\zakazaniTretmani.txt");
		if(file.length()!=0) {
		try {
		      Scanner myReader = new Scanner(file);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String[] podaci=data.split(",");
		        Opcije opcija=Opcije.valueOf(podaci[0]);
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		        LocalDateTime vreme=  LocalDateTime.parse(podaci[1], formatter) ;
		        String[] menadzerPodaci= podaci[2].split("-"); 
		        Menadzer menadzer= new Menadzer(menadzerPodaci[0],menadzerPodaci[1],menadzerPodaci[2],menadzerPodaci[3],menadzerPodaci[4],menadzerPodaci[5],menadzerPodaci[6],menadzerPodaci[7],menadzerPodaci[8],Integer.parseInt(menadzerPodaci[9]),Double.parseDouble(menadzerPodaci[10]));
		        String[] kozmeticarPodaci =podaci[3].split("--");
		        String[] kozmetickiTretmani= kozmeticarPodaci[11].split("-");
		        ArrayList<TipTretmana> kozmetickiTretmaniArray= new  ArrayList<TipTretmana>();
		        for(String i: kozmetickiTretmani) {
		        	TipTretmana tip=new TipTretmana(i);
		        	kozmetickiTretmaniArray.add(tip);
		        }
		        Kozmeticar kozmeticar=new Kozmeticar(menadzer,kozmeticarPodaci[0],kozmeticarPodaci[1],kozmeticarPodaci[2],kozmeticarPodaci[3],kozmeticarPodaci[4],kozmeticarPodaci[5],kozmeticarPodaci[6],kozmeticarPodaci[7],kozmeticarPodaci[8],Integer.parseInt(kozmeticarPodaci[9]),Double.parseDouble(kozmeticarPodaci[10]),kozmetickiTretmaniArray);
		       
		        String[] tretmanPodaci=podaci[4].split("-");
		        String[] tretmanPodaci2=podaci[5].split("-");
			    Tretman tretman= new Tretman(tretmanPodaci[0],Integer.parseInt(tretmanPodaci[1]),new TipTretmana(tretmanPodaci2[0]),Double.parseDouble(tretmanPodaci2[1])) ;
			    String[] klijentPodaci=podaci[6].split("-");
			    Klijent klijent=new Klijent(klijentPodaci[0],klijentPodaci[1],klijentPodaci[2],klijentPodaci[3],klijentPodaci[4],klijentPodaci[5],klijentPodaci[6]);
		        ZakazanTretman zakazan=new ZakazanTretman(opcija,vreme,kozmeticar,tretman,klijent,Double.parseDouble(podaci[7]));
		        zakazaniTretmani.add(zakazan);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      e.printStackTrace();
		    }
		}
	}
	public void ucitajSveTipoveTretmana() {
		File file = new File("C:\\Users\\User\\eclipse-workspace\\kt3_sv_67_2022\\src\\klase\\sacuvaniPodaci\\tipoviTretmana.txt");
		if(file.length()!=0) {
		try {
		      Scanner myReader = new Scanner(file);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String[] podaci=data.split(",");
		        TipTretmana tip= new TipTretmana(podaci[0]);
		        tipoviTretmana.add(tip);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      e.printStackTrace();
		    }
		}
	}
	public void ucitajSveTretmane() {
		File file = new File("C:\\Users\\User\\eclipse-workspace\\kt3_sv_67_2022\\src\\klase\\sacuvaniPodaci\\tretmani.txt");
		if(file.length()!=0) {
		try {
		      Scanner myReader = new Scanner(file);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String[] podaci=data.split(",");
		       Tretman tretman= new Tretman(podaci[0],Integer.parseInt(podaci[1]),new TipTretmana(podaci[2]),Double.parseDouble(podaci[3])) ;
		        tretmani.add(tretman);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      e.printStackTrace();
		    }
		}
	}
	public Kozmeticar giveKozmeticarWithObuka(Tretman usluga, LocalDateTime vreme,ArrayList<Kozmeticar>kozmeticari1) {
		boolean dobro=true;
		TipTretmana uslugaZT=usluga.getTip();
		for(Kozmeticar kozmeticarPokazivac : kozmeticari1) {
			ArrayList<TipTretmana> tretmani=kozmeticarPokazivac.getKozmetickiTretmani();
			for(TipTretmana tretman : tretmani) {
				if (tretman==uslugaZT ){
					for(ZakazanTretman zakazanTretman : kozmeticarPokazivac.proveraRasporedaKozmeticara(zakazaniTretmani)){
							LocalDateTime ranije= zakazanTretman.getDatum_i_vreme().plus(Duration.of(zakazanTretman.getUsluga().getTrajanje(), ChronoUnit.MINUTES));
							LocalDateTime kasnije= zakazanTretman.getDatum_i_vreme();
							
							if(ranije.isBefore(vreme) || vreme.isBefore(kasnije)) {
								continue;
							}
							else {
								dobro=false; //bar jedan datum ne odgvara
							}
					}
				}
			}
			if(dobro) {
				return kozmeticarPokazivac;
			}
			else {
				kozmeticari1.remove(kozmeticari1.indexOf(kozmeticarPokazivac));
				return this.giveKozmeticarWithObuka(usluga, vreme, kozmeticari1);
			}
		}
		System.out.println("Nema kozmeticara sa zavrsenom obukom za vasu uslugu ");
		return null;
	}
	
	
	public boolean proveraPostojecegKlijenta(String ime, String lozinka) {
		ArrayList<Klijent> kontejner= this.klijenti;
		for(Klijent i : kontejner) {
			if(i.getKorisnickoIme().equals(ime)) {
				if(i.getLozinka().equals(lozinka)) {
					return true;
				}
			}
		}
		return false;
	}
	public ArrayList<ZakazanTretman> prikaziSveZakazaneTretmaneZaKlijenta(Klijent klijent) {
		ArrayList<ZakazanTretman> tretmaniKlijenta=new ArrayList<ZakazanTretman>();
		for(ZakazanTretman i: zakazaniTretmani) {
			System.out.println(i.getKlijent().napraviString());
			System.out.println(klijent.napraviString());
			if(i.getKlijent().napraviString().equals(klijent.napraviString())) {
				tretmaniKlijenta.add(i);
			}
		}
		return tretmaniKlijenta;
	}
	public ArrayList<ZakazanTretman> prikaziSveZakazaneTretmaneZaKozmeticara(Kozmeticar kozmeticar) {
		ArrayList<ZakazanTretman> tretmaniKozmeticara=new ArrayList<ZakazanTretman>();
		for(ZakazanTretman i: zakazaniTretmani) {
			if(i.getKozmeticar().napraviString().equals(kozmeticar.napraviString())) {
				System.out.println("true");
				tretmaniKozmeticara.add(i);
			}
		}
		return tretmaniKozmeticara;
	}
}
