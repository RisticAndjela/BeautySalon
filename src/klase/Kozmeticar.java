package klase;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringJoiner;

import tretmani.TipTretmana;
import tretmani.ZakazanTretman;

public class Kozmeticar extends SvakiZaposleni{
	private ArrayList<TipTretmana> kozmetickiTretmani = new ArrayList<TipTretmana>();
	private Menadzer napravljenBy;
	
	public Kozmeticar() {
		super();
		ArrayList<TipTretmana> tretmani = new ArrayList<TipTretmana>();
		TipTretmana tip1=new TipTretmana();
		tretmani.add(tip1);
		this.setKozmetickiTretmani(tretmani) ;
	}
	
	public Kozmeticar(Menadzer menadzer,String ime, String prezime, String pol, String telefon, String adresa, String korisnickoIme,
			String lozinka, String strucnaSprema, String staz, int bonus, double plata, ArrayList<TipTretmana> kozmetickiTretmani) {
		super(ime, prezime, pol, telefon, adresa, korisnickoIme, lozinka, strucnaSprema, staz, bonus, plata);
		this.kozmetickiTretmani=kozmetickiTretmani;
		this.konacnaPlata=this.menadzerPraviPlatu(menadzer);
		this.setNapravljenBy(menadzer);

	}
	
	public ArrayList<TipTretmana> getKozmetickiTretmani() {
		return kozmetickiTretmani;
	}
	public void setKozmetickiTretmani(ArrayList<TipTretmana> kozmetickiTretmani) {
		this.kozmetickiTretmani = kozmetickiTretmani;
	}
	public Menadzer getNapravljenBy() {
		return napravljenBy;
	}

	public void setNapravljenBy(Menadzer napravljenBy) {
		this.napravljenBy = napravljenBy;
	}
	
	public ArrayList<Kozmeticar> sacuvajKozemticara(Menadzer menadzer, ArrayList<Kozmeticar> kozmeticari){
		if(getNapravljenBy()!=menadzer) {
			System.out.println("Jedino menadzer koji je napravio kozmeticara moze i da ga sacuva");
			return kozmeticari;
		}
		System.out.println("tu smo");
		File file=new File("C:\\Users\\User\\eclipse-workspace\\kt3_sv_67_2022\\src\\klase\\sacuvaniPodaci\\kozmeticari.txt");
		try {
			FileWriter fr = new FileWriter(file, true);
			BufferedWriter br = new BufferedWriter(fr);
			br.write(this.inputZaFajl());
			br.close();
			fr.close();
		} catch (IOException e) {
			System.out.print(e.getMessage());
		} // cuvanje u fajlu
		kozmeticari.add(this);
		return kozmeticari;
	}
	public ArrayList<Kozmeticar> obrisiKozemticara(Menadzer menadzer, ArrayList<Kozmeticar> kozmeticari){
		if(getNapravljenBy()!=menadzer) {
			System.out.println("Jedino menadzer koji je napravio kozmeticara moze i da ga obrise");
			return kozmeticari;
		}
		kozmeticari.remove(kozmeticari.indexOf(this));
		File file=new File("C:\\Users\\User\\eclipse-workspace\\kt3_sv_67_2022\\src\\klase\\sacuvaniPodaci\\kozmeticari.txt");
		
		try {
			FileWriter file1 = new FileWriter(file, false);
			for(Kozmeticar i : kozmeticari) {	
		    file1.write(i.inputZaFajl());
			}
		    file1.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}   
		return kozmeticari;
	}
	public String inputZaFajl() {
		StringJoiner povratna= new StringJoiner(""); 
		povratna.add(getNapravljenBy().inputZaFajlVan());
		povratna.add(getIme() +","+ getPrezime() +","+ getPol() +","+ getTelefon() +","+ getAdresa() +","+ getKorisnickoIme() +","+ getLozinka() + ","+ getStrucnaSprema()+","+ getStaz()+","+ getBonus()+","+ getPlata()+","); 
		for(int i=0; i<kozmetickiTretmani.size();i++) {
			povratna.add(kozmetickiTretmani.get(i).getNaziv());
			povratna.add("-");
		}
		povratna.add("\n");
		return povratna.toString();
	}
	public String inputZaFajlVan() {
		StringJoiner povratna= new StringJoiner(""); 
		povratna.add(getNapravljenBy().inputZaFajlVan());
		povratna.add(getIme() +"--"+ getPrezime() +"--"+ getPol() +"--"+ getTelefon() +"--"+ getAdresa() +"--"+ getKorisnickoIme() +"--"+ getLozinka() + "--"+ getStrucnaSprema()+"--"+ getStaz()+"--"+ getBonus()+"--"+ getPlata()+"--"); 
		for(int i=0; i<kozmetickiTretmani.size();i++) {
			povratna.add(kozmetickiTretmani.get(i).getNaziv());
			povratna.add("-");
		}
		povratna.add(",");
		return povratna.toString();
	}
	
	public String napraviString() {
		StringJoiner povratna= new StringJoiner(""); 
		povratna.add("ime: "+getIme() +" prezime: "+ getPrezime() +" pol: "+ getPol() +" telefon: "+ getTelefon() +" adresa: "+ getAdresa() +" korisnicko ime: "+ getKorisnickoIme() +" lozinka: "+ getLozinka() + " strucna sprema: "+ getStrucnaSprema()+" staz: "+ getStaz()+" bonus: "+ getBonus()+" plata: "+ getPlata()+"\ntretmani: "); 
		for(int i=0; i<kozmetickiTretmani.size();i++) {
			povratna.add(kozmetickiTretmani.get(i).napraviString());
			povratna.add(" ");
		}
		povratna.add("\nnapravljen od: "+getNapravljenBy().getIme()+" "+getNapravljenBy().getPrezime()+"\n");
		return povratna.toString();
	}
	
	public void izmeniKozmeticara(Menadzer menadzer,Kozmeticar novi, ArrayList<Kozmeticar> kozmetiari) {
		Kozmeticar stari=this;
		this.izmenaSvakogZaposlenog(novi);
		if(novi.getKozmetickiTretmani()!=this.getKozmetickiTretmani()) {
			this.setKozmetickiTretmani(novi.getKozmetickiTretmani());
		}
		stari.obrisiKozemticara(menadzer,kozmetiari);
		this.sacuvajKozemticara(menadzer,kozmetiari);
		
	}
	
	
	public void rasporedKozmeticara(ArrayList<ZakazanTretman> zakazaniTretmani){
		System.out.println("------------------------Zakazani tretmani kod "+this.getIme()+" "+this.getPrezime()+"--------------------------");
		for(int i=0;i<zakazaniTretmani.size();i++) {
			if(zakazaniTretmani.get(i).getKozmeticar()==this) {
				System.out.println(zakazaniTretmani.get(i).napraviString());
			}
		}
		}
	public ArrayList<ZakazanTretman> proveraRasporedaKozmeticara(ArrayList<ZakazanTretman> zakazaniTretmani) {
		ArrayList<ZakazanTretman> njegoviTretmani=new ArrayList<ZakazanTretman>();
		for(int i=0;i<zakazaniTretmani.size();i++) {
			if(zakazaniTretmani.get(i).getKozmeticar()==this) {
				njegoviTretmani.add(zakazaniTretmani.get(i));
			}}
		return njegoviTretmani;
	}

	
}
