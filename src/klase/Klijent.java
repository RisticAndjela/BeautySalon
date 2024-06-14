package klase;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import tretmani.ZakazanTretman;

public class Klijent extends Korisnik{
	private KarticaLojalnosti karticaLojalnosti;
	private double potrosioUSalonu;
	public Klijent() {
		super("klijentProbaIme","klijentProbaPrezime","klijentProbaPol","klijentProbaTelefon","klijentProbaAdresa","klijentProbaKorisnisckoIme","klijentProbaLozinka");
	}
	public Klijent(String ime, String prezime, String pol, String telefon, String adresa, String korisnickoIme, String lozinka) {
		super(ime, prezime, pol, telefon, adresa, korisnickoIme, lozinka);
	}
	
	
	public KarticaLojalnosti getKarticaLojalnosti() {
		return karticaLojalnosti;
	}
	public void setKarticaLojalnosti(KarticaLojalnosti karticaLojalnosti) {
		this.karticaLojalnosti = karticaLojalnosti;
	}
	public double getPotrosioUSalonu() {
		return potrosioUSalonu;
	}
	public void setPotrosioUSalonu(double potrosioUSalonu) {
		this.potrosioUSalonu = potrosioUSalonu;
	}
	public ArrayList<Klijent> sacuvajKlijenta(ArrayList<Klijent> klijenti){
		File file=new File("C:\\Users\\User\\eclipse-workspace\\kt3_sv_67_2022\\src\\klase\\sacuvaniPodaci\\klijenti.txt");
		try {
			FileWriter fr = new FileWriter(file, true);
			BufferedWriter br = new BufferedWriter(fr);
			br.write(this.ispisZaFajl());
			br.close();
			fr.close();
		} catch (IOException e) {
			System.out.print(e.getMessage());
		} // cuvanje u fajlu
		
		klijenti.add(this);
		return klijenti;
	}
	
	public ArrayList<Klijent> obrisiKlijenta(ArrayList<Klijent> klijenti){
		klijenti.remove(klijenti.indexOf(this));
		File file=new File("C:\\Users\\User\\eclipse-workspace\\kt3_sv_67_2022\\src\\klase\\sacuvaniPodaci\\klijenti.txt");
		
		try {
			FileWriter file1 = new FileWriter(file, false);
			for(Klijent i : klijenti) {	
		    file1.write(i.ispisZaFajl());
			}
		    file1.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}   
		
		return klijenti;
	}
	
	public String napraviString() {
		return "ime: "+getIme() +" prezime: "+ getPrezime() +" pol: "+ getPol() +" telefon: "+ getTelefon() +" adresa: "+ getAdresa() +" korisnicko ime: "+ getKorisnickoIme() +" lozinka: "+ getLozinka() + "\n"; 
	}
	public String ispisZaFajl() {
		return getIme()+","+getPrezime()+","+getPol()+","+getTelefon()+","+getAdresa()+","+getKorisnickoIme()+","+getLozinka()+"\n";
	}
	public String ispisZaFajlVan() {
		return getIme()+"-"+getPrezime()+"-"+getPol()+"-"+getTelefon()+"-"+getAdresa()+"-"+getKorisnickoIme()+"-"+getLozinka()+",";
	}
	public void izmeniKlijenta(Klijent novi,ArrayList<Klijent> klijenti) {
		this.obrisiKlijenta(klijenti);
		this.izmenaKorisnika(novi);
		this.sacuvajKlijenta(klijenti);
		
	}
	public void dodajUKasicu(double cenaTretmana) {
		this.potrosioUSalonu+=cenaTretmana;
	}
	public boolean pravoNaLojaltiKarticu(KarticaLojalnosti kartica) {
		if(kartica.getNajmanjePotroseno()<=this.getPotrosioUSalonu()) {
			return true;
		}
		return false;
	}
	
	public void kompletanPregled(KarticaLojalnosti kartica, ArrayList<ZakazanTretman> zakazaniTretmani) {
		System.out.println("--------KOMPLETN PREGLED KLIJENTA-----------");
		System.out.println(this.napraviString());
		if(this.pravoNaLojaltiKarticu(kartica)) {
			System.out.println(kartica.napraviString());
		}
		System.out.println("Korisnik je u salonu ukupno potrosio: "+Double.toString(this.getPotrosioUSalonu()));
		System.out.println("Tretmani koji se nalaze na imenu klijenta: ");
		int i=0;
		for(ZakazanTretman zakazanTretman: zakazaniTretmani) {
			if(zakazanTretman.getKlijent()==this) {
				i++;
				System.out.println("ZAKAZAN TRETMAN"+i+": "+zakazanTretman.napraviString());
			}
		}
	}
}
