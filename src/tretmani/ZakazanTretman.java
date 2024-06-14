package tretmani;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import klase.KarticaLojalnosti;
import klase.Klijent;
import klase.Kontejneri;
import klase.Kozmeticar;
import klase.Menadzer;
import klase.NovcanikSalona;

public class ZakazanTretman {

	private Opcije opcijeTretmana;
	private LocalDateTime datum_i_vreme;
	private Kozmeticar kozmeticar;
	private Tretman	usluga;
	private Klijent klijent;
	private double cenaUVremeZakazivanja;


	public ZakazanTretman(){
		Kontejneri kontejner= new Kontejneri();
		this.opcijeTretmana=Opcije.NEDEFINISAN;
		this.datum_i_vreme=LocalDateTime.now();
		this.kozmeticar=new Kozmeticar();
		this.klijent=new Klijent();
		this.usluga= new Tretman();
		Menadzer menadzer=new Menadzer();
		KarticaLojalnosti kartica= new KarticaLojalnosti(menadzer,3000.0,kontejner);
		this.cenaUVremeZakazivanja=usluga.getCena();
		if(this.getKlijent().pravoNaLojaltiKarticu(kartica)) {
			this.cenaUVremeZakazivanja=this.cenaUVremeZakazivanja-this.cenaUVremeZakazivanja/10;
		}
	}
	
	public ZakazanTretman(Opcije opcija, LocalDateTime datumVreme, Kozmeticar kozmeticar, Tretman usluga, Klijent klijent,KarticaLojalnosti kartica){
		this.opcijeTretmana=opcija;
		this.datum_i_vreme=datumVreme;
		this.kozmeticar=kozmeticar;
		this.klijent=klijent;
		this.usluga= usluga;
		this.cenaUVremeZakazivanja=usluga.getCena();
		if(this.getKlijent().pravoNaLojaltiKarticu(kartica)) {
			this.cenaUVremeZakazivanja=this.cenaUVremeZakazivanja-this.cenaUVremeZakazivanja/10;
		}
	}
//	kada ucitavamo iz fajla
	public ZakazanTretman(Opcije opcija, LocalDateTime datumVreme, Kozmeticar kozmeticar, Tretman usluga, Klijent klijent,Double cena){
		this.opcijeTretmana=opcija;
		this.datum_i_vreme=datumVreme;
		this.kozmeticar=kozmeticar;
		this.klijent=klijent;
		this.usluga= usluga;
		this.cenaUVremeZakazivanja=cena;
	}

	public Opcije getOpcijeTretmana() {
		return opcijeTretmana;
	}
	public void setOpcijeTretmana(Opcije opcijeTretmana) {
		this.opcijeTretmana = opcijeTretmana;
	}
	public LocalDateTime getDatum_i_vreme() {
		return datum_i_vreme;
	}
	public void setDatum_i_vreme(LocalDateTime datum_i_vreme) {
		this.datum_i_vreme = datum_i_vreme;
	}
	public Kozmeticar getKozmeticar() {
		return kozmeticar;
	}
	public void setKozmeticar(Kozmeticar kozmeticar) {
		this.kozmeticar = kozmeticar;
	}
	public Klijent getKlijent() {
		return klijent;
	}
	public void setKlijent(Klijent klijent) {
		this.klijent = klijent;
	}
	public Tretman getUsluga() {
		return usluga;
	}
	public void setUsluga(Tretman usluga) {
		this.usluga=usluga;}
	
	public double getCenaUVremeZakazivanja() {
		return cenaUVremeZakazivanja;
	}
	public void setCenaUVremeZakazivanja(double cenaUVremeZakazivanja) {
		this.cenaUVremeZakazivanja = cenaUVremeZakazivanja;
	}

	public int provera(ArrayList<ZakazanTretman> zakazaniTretmani) {
		if(zakazaniTretmani.contains(this)) {
			return -1;
			//vec zakazan isti
		}
		for(ZakazanTretman i: zakazaniTretmani) {
			
			if((i.getKlijent().getIme().equals(this.getKlijent().getIme())) & (i.getDatum_i_vreme().equals(this.getDatum_i_vreme()))) {
				return -2;
			}
			
			if((i.getKozmeticar().getIme().equals(this.getKozmeticar().getIme())) & (i.getDatum_i_vreme().equals(this.getDatum_i_vreme()))) {
				return -3;
			}
			
			int dodaj=i.getUsluga().getTrajanje(); //trajanje tretmana koji se pregleda
			LocalDateTime uzmiDan=i.getDatum_i_vreme().plus(Duration.of(dodaj, ChronoUnit.MINUTES));
			LocalDateTime trebaPrvi=i.getDatum_i_vreme();
		    boolean proverenostVremena=((this.getDatum_i_vreme().isAfter(uzmiDan) || this.getDatum_i_vreme().isBefore(uzmiDan))&& (this.getDatum_i_vreme().isAfter(trebaPrvi)||this.getDatum_i_vreme().isBefore(trebaPrvi)));
			if((i.getKlijent().getIme().equals(this.getKlijent().getIme())) & (proverenostVremena==false)) {
				return -4;}
			
			if((i.getKozmeticar().getIme().equals(this.getKozmeticar().getIme())) & (proverenostVremena==false)) {
				return -5;}
		}
		return 1;
	}

	public ArrayList<ZakazanTretman> sacuvajZakazanTretman(ArrayList<ZakazanTretman> zakazaniTretmani){
		if(this.provera(zakazaniTretmani)==1) {
			zakazaniTretmani.add(this);
		
		File file=new File("C:\\Users\\User\\eclipse-workspace\\kt3_sv_67_2022\\src\\klase\\sacuvaniPodaci\\zakazaniTretmani.txt");
		try {
			FileWriter fr = new FileWriter(file, true);
			BufferedWriter br = new BufferedWriter(fr);
			br.write(this.inputZaFajl());
			br.close();
			fr.close();
		} catch (IOException e) {
			System.out.print(e.getMessage());
		} // cuvanje u fajlu
		}
		else {
			System.out.println("Podaci nisu tacni");
		}
		return zakazaniTretmani;
	}
	public ArrayList<ZakazanTretman> obrisiZakazanTretman(ArrayList<ZakazanTretman> zakazaniTretmani){
		zakazaniTretmani.remove(zakazaniTretmani.indexOf(this));
		File file2=new File("C:\\Users\\User\\eclipse-workspace\\kt3_sv_67_2022\\src\\klase\\sacuvaniPodaci\\zakazaniTretmani.txt");
		try {
			FileWriter file3 = new FileWriter(file2, false);
			for(	ZakazanTretman i : zakazaniTretmani) {	
		    file3.write(i.inputZaFajl());
			}
		    file3.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}   
		return zakazaniTretmani;
	}
	
	public void izmenaZakazanogTretmana(ZakazanTretman novi, ArrayList<ZakazanTretman> zakazaniTretmani) {
		this.obrisiZakazanTretman(zakazaniTretmani);
		if(novi.getOpcijeTretmana()!=this.getOpcijeTretmana()) {
			this.setOpcijeTretmana(novi.getOpcijeTretmana());
		}
		if(novi.getDatum_i_vreme()!=this.getDatum_i_vreme()) {
			this.setDatum_i_vreme(novi.getDatum_i_vreme());
		}
		if(novi.getKlijent()!=this.getKlijent()) {
			this.setKlijent(novi.getKlijent());
		}
		if(novi.getKozmeticar()!=this.getKozmeticar()) {
			this.setKozmeticar(novi.getKozmeticar());
		}
		if(novi.getUsluga()!=this.getUsluga()) {
			this.setUsluga(novi.getUsluga());
		}
		
		this.sacuvajZakazanTretman(zakazaniTretmani);
	}
	
	public String napraviString() {
		String usluga=this.getUsluga().napraviString();
		String klijentIme=this.getKlijent().getIme();
		String klijentPrezime=this.getKlijent().getPrezime();
		String kozmeticarIme=this.getKozmeticar().getIme();
		String kozmeticarPrezime=this.getKozmeticar().getPrezime();
		String konacan="Ovaj tretman je "+this.getOpcijeTretmana().toString()+",datum: "+this.getDatum_i_vreme().toString()+",kozmeticar: "+kozmeticarIme+" "+kozmeticarPrezime+",za uslugu: "+usluga+"klijent:"+klijentIme+" "+klijentPrezime+", cena:"+this.getCenaUVremeZakazivanja()+"\n";
		return konacan;
	}
	
	public void tretmanJeIzvrsen(ArrayList<ZakazanTretman> zakazaniTretmani,NovcanikSalona novcanik) {
		Double cena=this.cenaUVremeZakazivanja;
		ZakazanTretman izmena=this;
		izmena.setOpcijeTretmana(Opcije.IZVRSEN);
		this.izmenaZakazanogTretmana(izmena, zakazaniTretmani);
		novcanik.zavrsenTretman(cena,this.getDatum_i_vreme(),Opcije.IZVRSEN);
		this.getKlijent().dodajUKasicu(cena);
		System.out.println("Prihodi salona su: "+novcanik.getPrihodi());
		System.out.println("Uspesno izvrsen tretman: "+this.napraviString());
	}
	public void tretmanJeOtkazaoKljient(ArrayList<ZakazanTretman> zakazaniTretmani,NovcanikSalona novcanik) {
		Double cena=this.cenaUVremeZakazivanja;
		ZakazanTretman izmena=this;
		izmena.setOpcijeTretmana(Opcije.OTKAZAO_KLIJENT);
		this.cenaUVremeZakazivanja=this.cenaUVremeZakazivanja/10;
		this.izmenaZakazanogTretmana(izmena, zakazaniTretmani);
		novcanik.zavrsenTretman(cena/10,this.getDatum_i_vreme(),Opcije.OTKAZAO_KLIJENT);
		this.getKlijent().dodajUKasicu(cena/10);
		System.out.println("Prihodi salona su: "+novcanik.getPrihodi());
		System.out.println("Kllijent je od uplacenih "+Double.toString(cena)+", dobio nazad:"+Double.toString(cena*90/100));
		System.out.println(this.napraviString());
	}
	public void tretmanJeOtkazaoSalon(ArrayList<ZakazanTretman> zakazaniTretmani,NovcanikSalona novcanik) {
		Double cena=this.cenaUVremeZakazivanja;
		this.cenaUVremeZakazivanja=0.0;
		ZakazanTretman izmena=this;
		izmena.setOpcijeTretmana(Opcije.OTLAZAO_SALON);
		this.izmenaZakazanogTretmana(izmena, zakazaniTretmani);
		novcanik.zavrsenTretman(cena, this.getDatum_i_vreme(),Opcije.OTLAZAO_SALON);
		System.out.println("Prihodi salona su: "+novcanik.getPrihodi());
		System.out.println("Kllijent je od uplacenih "+Double.toString(cena)+", dobio nazad:"+Double.toString(cena));
		System.out.println(this.napraviString());
	}
	public void klijentSeNijePojavio(ArrayList<ZakazanTretman> zakazaniTretmani,NovcanikSalona novcanik) {
		Double cena=this.cenaUVremeZakazivanja;
		
		ZakazanTretman izmena=this;
		izmena.setOpcijeTretmana(Opcije.NIJE_SE_POJAVIO);
		this.izmenaZakazanogTretmana(izmena, zakazaniTretmani);
		novcanik.zavrsenTretman(cena,this.getDatum_i_vreme(),Opcije.NIJE_SE_POJAVIO);
		this.getKlijent().dodajUKasicu(cena);
		System.out.println("Prihodi salona su: "+novcanik.getPrihodi());
		System.out.println("Kllijent je od uplacenih "+Double.toString(cena)+", dobio nazad: 0.0");
		System.out.println(this.napraviString());
	}
	public String inputZaFajl() {
		String opcija=this.getOpcijeTretmana().toString();
		String datumIVreme=this.getDatum_i_vreme().toString();
		String usluga=this.getUsluga().inputZaFajlVan();
		String klijent=this.getKlijent().ispisZaFajlVan();
		String kozmeticar=this.getKozmeticar().inputZaFajlVan();
		String cena=Double.toString(this.getCenaUVremeZakazivanja());
		String konacan=opcija+","+datumIVreme+","+kozmeticar+usluga+klijent+cena+"\n";
		return konacan;
	}
}
