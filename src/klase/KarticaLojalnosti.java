package klase;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class KarticaLojalnosti {
	private double popust=0.1;
	private double najmanjePotroseno;
	private Menadzer menadzerPostavljaUslov;
	public KarticaLojalnosti(Menadzer menadzer,double najmanjePotroseno,Kontejneri kontejner) {
		this.najmanjePotroseno=najmanjePotroseno;
		this.menadzerPostavljaUslov=menadzer;
		dodeliPopustKlijentima(kontejner);
	}
	
	private void dodeliPopustKlijentima(Kontejneri kontejner) {
		for(Klijent i: kontejner.klijenti) {
			if(i.getPotrosioUSalonu()>=najmanjePotroseno) {
				i.setKarticaLojalnosti(this);
			}
		}
	}

	public double getPopust() {
		return popust;
	}

	public void setPopust(double popust) {
		this.popust = popust;
	}

	public double getNajmanjePotroseno() {
		return najmanjePotroseno;
	}

	public void setNajmanjePotroseno(double najmanjePotroseno) {
		this.najmanjePotroseno = najmanjePotroseno;
	}

	public Menadzer getMenadzerPostavljaUslov() {
		return menadzerPostavljaUslov;
	}

	public void setMenadzerPostavljaUslov(Menadzer menadzerPostavljaUslov) {
		this.menadzerPostavljaUslov = menadzerPostavljaUslov;
	}

	public String napraviString() {
		return "Kartica lojalnosti vam donosi 10% popusta ukoliko ste najmanje potrosili "+ Double.toString(this.getNajmanjePotroseno())+".Ovo je postavio menadzer:"+this.getMenadzerPostavljaUslov().getIme()+" "+this.getMenadzerPostavljaUslov().getPrezime();
	}

	public ArrayList<KarticaLojalnosti> sacuvajKarticu(ArrayList<KarticaLojalnosti> sveKartice) {
		File file = new File("C:\\Users\\User\\eclipse-workspace\\kt3_sv_67_2022\\src\\klase\\sacuvaniPodaci\\lojaltiKartice.txt");
	    try {
	        FileWriter fr = new FileWriter(file, true);
	        BufferedWriter br = new BufferedWriter(fr);
	        br.write(this.ispisZaFajl());
	        br.newLine(); // Add a new line after writing data
	        br.close();
	        fr.close();
	    } catch (IOException e) {
	        System.out.print(e.getMessage());
	    }
		sveKartice.add(this);
		return sveKartice;
	}

	private String ispisZaFajl() {
		return this.getMenadzerPostavljaUslov().inputZaFajlVan()+Double.toString(this.getNajmanjePotroseno());
	}
}
