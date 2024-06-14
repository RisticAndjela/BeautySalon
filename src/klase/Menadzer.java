package klase;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Menadzer extends SvakiZaposleni{

	public Menadzer() {
		super();
		
	}
	
	public Menadzer(String ime, String prezime, String pol, String telefon, String adresa, String korisnickoIme, String lozinka, String strucnaSprema, String staz, int bonus, double plata) {
		super(ime, prezime, pol, telefon, adresa, korisnickoIme, lozinka, strucnaSprema, staz, bonus, plata);
		Menadzer menadzerZaPlatu = new Menadzer();
		this.konacnaPlata=this.menadzerPraviPlatu(menadzerZaPlatu);

	}
	public ArrayList<Menadzer> sacuvajMenadzera(ArrayList<Menadzer> menadzeri){
		menadzeri.add(this);
		File file=new File("C:\\Users\\User\\eclipse-workspace\\kt3_sv_67_2022\\src\\klase\\sacuvaniPodaci\\menadzeri.txt");
		try {
			FileWriter fr = new FileWriter(file, true);
			BufferedWriter br = new BufferedWriter(fr);
			br.write(this.inputZaFajl());
			br.close();
			fr.close();
		} catch (IOException e) {
			System.out.print(e.getMessage());
		} // cuvanje u fajlu
		return menadzeri;
	}
	public ArrayList<Menadzer> obrisiMenadzera(ArrayList<Menadzer> menadzeri){
		menadzeri.remove(menadzeri.indexOf(this));
		File file=new File("C:\\Users\\User\\eclipse-workspace\\kt3_sv_67_2022\\src\\klase\\sacuvaniPodaci\\menadzeri.txt");
		
		try {
			FileWriter file1 = new FileWriter(file, false);
			for(Menadzer i : menadzeri) {	
		    file1.write(i.inputZaFajl());
			}
		    file1.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}   
		return menadzeri;
	}
	
	public String napraviString() {
		return "ime: "+getIme() +" prezime: "+ getPrezime() +" pol: "+ getPol() +" telefon: "+ getTelefon() +" adresa: "+ getAdresa() +" korisnicko ime: "+ getKorisnickoIme() +" lozinka: "+ getLozinka() + " strucna sprema: "+ getStrucnaSprema()+" staz: "+ getStaz()+" bonus: "+ getBonus()+" plata: "+ getPlata() + "\n"; 
	}
	public String inputZaFajl() {
		return getIme() +","+ getPrezime() +","+ getPol() +","+ getTelefon() +","+ getAdresa() +","+ getKorisnickoIme() +","+ getLozinka() + ","+ getStrucnaSprema()+","+ getStaz()+","+ getBonus()+","+ getPlata() + "\n"; 

	}
	public String inputZaFajlVan() {
		return getIme() +"-"+ getPrezime() +"-"+ getPol() +"-"+ getTelefon() +"-"+ getAdresa() +"-"+ getKorisnickoIme() +"-"+ getLozinka() + "-"+ getStrucnaSprema()+"-"+ getStaz()+"-"+ getBonus()+"-"+ getPlata() + ","; 

	}
	public void izmeniMenadzera(Menadzer novi,ArrayList<Menadzer> menadzeri) {
		this.obrisiMenadzera(menadzeri);
		this.izmenaSvakogZaposlenog(novi);
		this.sacuvajMenadzera(menadzeri);
	}
	
}
