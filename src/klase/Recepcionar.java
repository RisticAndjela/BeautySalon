package klase;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringJoiner;

public class Recepcionar extends SvakiZaposleni{
	private Menadzer napravljenBy;
	public Recepcionar() {
		super();
		
	}
	public Recepcionar(Menadzer menadzer,String ime, String prezime, String pol, String telefon, String adresa, String korisnickoIme, String lozinka, String strucnaSprema, String staz, int bonus, double plata) {
		super(ime, prezime, pol, telefon, adresa, korisnickoIme, lozinka, strucnaSprema, staz, bonus, plata);
		this.konacnaPlata=this.menadzerPraviPlatu(menadzer);
		this.napravljenBy=menadzer;
	}
	
	public Menadzer getNapravljenBy() {
		return napravljenBy;
	}
	public void setNapravljenBy(Menadzer napravljenBy) {
		this.napravljenBy = napravljenBy;
	}
	public ArrayList<Recepcionar> sacuvajRecepcionara(Menadzer menadzer,ArrayList<Recepcionar> recepcionari){
		if(getNapravljenBy()!=menadzer) {
			System.out.println("Jedino menadzer koji je napravio recepcionara moze i da ga izmeni");
			return recepcionari;
		}
		
		File file=new File("C:\\Users\\User\\eclipse-workspace\\kt3_sv_67_2022\\src\\klase\\sacuvaniPodaci\\recepcionari.txt");
		try {
			FileWriter fr = new FileWriter(file, true);
			BufferedWriter br = new BufferedWriter(fr);
			br.write(this.inputZaFajl());
			br.close();
			fr.close();
		} catch (IOException e) {
			System.out.print(e.getMessage());
		} // cuvanje u fajlu
		
		recepcionari.add(this);
		return recepcionari;
	}
	public ArrayList<Recepcionar> obrisiRecepcionara(Menadzer menadzer,ArrayList<Recepcionar> recepcionari){
		if(getNapravljenBy()!=menadzer) {
			System.out.println("Jedino menadzer koji je napravio recepcionara moze i da ga obrise");
			return recepcionari;
		}
		recepcionari.remove(recepcionari.indexOf(this));
		File file=new File("C:\\Users\\User\\eclipse-workspace\\kt3_sv_67_2022\\src\\klase\\sacuvaniPodaci\\recepcionari.txt");
		
		try {
			FileWriter file1 = new FileWriter(file, false);
			for(Recepcionar i : recepcionari) {	
		    file1.write(i.inputZaFajl());
			}
		    file1.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}   
		return recepcionari;
	}
	
	public String napraviString() {
		return "ime: "+getIme() +" prezime: "+ getPrezime() +" pol: "+ getPol() +" telefon: "+ getTelefon() +" adresa: "+ getAdresa() +" korisnicko ime: "+ getKorisnickoIme() +" lozinka: "+ getLozinka() + " strucna sprema: "+ getStrucnaSprema()+" staz: "+ getStaz()+" bonus: "+ getBonus()+" plata: "+ getPlata() + "\nnapravljen od: "+getNapravljenBy().getIme()+" "+getNapravljenBy().getPrezime()+"\n"; 
	}
	public String inputZaFajl() {
		return getNapravljenBy().inputZaFajlVan()+getIme() +","+ getPrezime() +","+ getPol() +","+ getTelefon() +","+ getAdresa() +","+ getKorisnickoIme() +","+ getLozinka() + ","+ getStrucnaSprema()+","+ getStaz()+","+ getBonus()+","+ getPlata()+"\n" ;
	}
	
	public void izmeniRecepcionara(Menadzer menadzer,Recepcionar novi, ArrayList<Recepcionar> recepcionari) {
		this.obrisiRecepcionara(menadzer,recepcionari);
		this.izmenaSvakogZaposlenog(novi);
		if(novi.getNapravljenBy()!=this.getNapravljenBy()) {
			this.setNapravljenBy(novi.getNapravljenBy());
		}
		this.sacuvajRecepcionara(menadzer,recepcionari);
	}
}
