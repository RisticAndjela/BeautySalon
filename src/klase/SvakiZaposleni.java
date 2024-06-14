package klase;

public class SvakiZaposleni extends Korisnik{

	private String strucnaSprema;
	private String staz;
	private int bonus;
	private double plata;
	public double konacnaPlata=0.0;//menadzer je napravio platu u odnosu na staz,spremu i bonus
	
	public SvakiZaposleni(){
		super();
		this.strucnaSprema="probaStrucnaSprema";
		this.staz="probaStaz";
		this.bonus=0;
		this.plata=0.0;
		this.konacnaPlata=0.0;
	}
	
	public SvakiZaposleni(String ime, String prezime, String pol, String telefon, String adresa, String korisnickoIme, String lozinka,String strucnaSprema,String staz, int bonus,double plata){
		super(ime, prezime, pol, telefon, adresa, korisnickoIme, lozinka);
		this.strucnaSprema=strucnaSprema;
		this.staz=staz;
		this.bonus=bonus;
		this.plata=plata;
	}

	public String getStrucnaSprema() {
		return strucnaSprema;
	}
	public void setStrucnaSprema(String strucnaSprema) {
		this.strucnaSprema = strucnaSprema;
	}
	public String getStaz() {
		return staz;
	}
	public void setStaz(String staz) {
		this.staz = staz;
	}
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	public double getPlata() {
		return plata;
	}
	public void setPlata(double plata) {
		this.plata = plata;
	}
	
	public double getKonacnaPlata() {
		return konacnaPlata;
	}
	public void setKonacnaPlata(double konacnaPlata) {
		this.konacnaPlata = konacnaPlata;
	}

	public void izmenaSvakogZaposlenog(SvakiZaposleni novi){
		this.izmenaKorisnika(novi);
		if(novi.getBonus()!=this.getBonus()) {
			this.setBonus(novi.getBonus());
		}
		if(novi.getPlata()!=this.getPlata()) {
			this.setPlata(novi.getPlata());
		}
		if(novi.getStaz()!=this.getStaz()) {
			this.setStaz(novi.getStaz());
		}
		if(novi.getStrucnaSprema()!=this.getStrucnaSprema()) {
			this.setStrucnaSprema(novi.getStrucnaSprema());
		}
	}
	
	public double menadzerPraviPlatu(Menadzer menadzer) {
		double plata=this.getPlata();
		if(this.getStrucnaSprema()=="srednja skola") {
			plata=plata+plata*0.03;//dodatnih 3% na platu
		}
		else if(this.getStrucnaSprema()=="fakultet") {
			plata=plata+plata*0.06;//dodatnih 6% na platu
		}
		if(this.getBonus()!=0) {
			plata=plata+plata*this.getBonus()/100;
		}
		String[] staz= this.getStaz().split(" ");
		int brojMeseci = Integer.parseInt(staz[0]);
		
		if(brojMeseci>5 && brojMeseci<18) {
			plata=plata+plata*0.03;
		}
		else if(brojMeseci>=18 && brojMeseci<36) {
			plata=plata+plata*0.06;
		}
		else {
			plata=plata+plata*0.1;
		}
		
		return plata;
	}
	
	
}
