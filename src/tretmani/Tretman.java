package tretmani;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Tretman {

	private String naziv;
	private int trajanje;
	private TipTretmana tip;
	private Double cena;
		
	public Tretman() {
		this.naziv="nazivProba";
		this.trajanje=0;
		this.tip=new TipTretmana();
		this.cena=0.0;
		
		}
	public Tretman(String naziv, int trajanje, TipTretmana tip, Double cena) {
		this.naziv=naziv;
		this.trajanje=trajanje;
		this.tip=tip;
		this.cena=cena;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public int getTrajanje() {
		return trajanje;
	}
	public void setTrajanje(int trajanje) {
		this.trajanje = trajanje;
	}
	public TipTretmana getTip() {
		return tip;
	}
	public void setTip(TipTretmana tip) {
		this.tip = tip;
	}
	public Double getCena() {
		return cena;
	}
	public void setCena(Double cena) {
		this.cena = cena;
	}
	
	public ArrayList<Tretman> sacuvajTretman(ArrayList<Tretman> tretmani,ArrayList<TipTretmana> tipovi){
		provera(tipovi);
		System.out.println("tu sam");
		File file=new File("C:\\Users\\User\\eclipse-workspace\\kt3_sv_67_2022\\src\\klase\\sacuvaniPodaci\\tretmani.txt");
		try {
			FileWriter fr = new FileWriter(file, true);
			BufferedWriter br = new BufferedWriter(fr);
			br.write(inputZaFajl());
			br.close();
			fr.close();
		} catch (IOException e) {
			System.out.print(e.getMessage());
		} // cuvanje u fajlu
		tretmani.add(this);
		return tretmani;
	}
	public void provera(ArrayList<TipTretmana> tipovi) {
		if (!tipovi.contains(this.getTip())) {
			try {
				exception("Nevalidan tip tretmana");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		}
	
	public void exception(String message) throws Exception{
		throw new Exception(message);
	}

	
	public ArrayList<Tretman> obrisiTretman(ArrayList<Tretman> tretmani){
		tretmani.remove(tretmani.indexOf(this));
		File file2=new File("C:\\Users\\User\\eclipse-workspace\\kt3_sv_67_2022\\src\\klase\\sacuvaniPodaci\\tretmani.txt");
		try {
			FileWriter file3 = new FileWriter(file2, false);
			for(Tretman i : tretmani) {	
		    file3.write(i.inputZaFajl());
			}
		    file3.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}   
		return tretmani;
	}
	
	public void izmenaTretmana(Tretman novi,ArrayList<Tretman>tretmani,ArrayList<TipTretmana>tipovi) {
		this.obrisiTretman(tretmani);
		if(novi.getCena()!=this.getCena()) {
			this.setCena(novi.getCena());
		}
		if(novi.getNaziv()!=this.getNaziv()) {
			this.setNaziv(novi.getNaziv());
		}
		if(novi.getTip()!=this.getTip()) {
			this.setTip(novi.getTip());
		}
		if(novi.getTrajanje()!=this.getTrajanje()) {
			this.setTrajanje(novi.getTrajanje());
		}
		this.sacuvajTretman(tretmani,tipovi);
	}
	public String napraviString() {
		return "naziv: "+ getNaziv() +" trajanje: "+ getTrajanje() +" tip: "+ getTip().napraviString() +" cena: "+ getCena() + "\n";

	}
	public String inputZaFajl() {
		System.out.println("tuuuuuuuu");
		return getNaziv() +","+ getTrajanje() +","+ getTip().getNaziv() +","+ getCena() + "\n";
	}
	public String inputZaFajlVan() {
		return getNaziv() +"-"+ getTrajanje() +"-,"+ getTip().getNaziv() +"-"+ getCena() + ",";
	}
	
}
