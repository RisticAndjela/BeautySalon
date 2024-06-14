package tretmani;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TipTretmana {
		private String naziv;
	public TipTretmana() {
		this.naziv="probaNaziv";
	}
	public TipTretmana(String naziv) {
		this.naziv=naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getNaziv() {
		return naziv;
	}
	public ArrayList<TipTretmana> sacuvajTipTretmana(ArrayList<TipTretmana> tipovi){
		File file=new File("C:\\Users\\User\\eclipse-workspace\\kt3_sv_67_2022\\src\\klase\\sacuvaniPodaci\\tipoviTretmana.txt");
		try {
			FileWriter fr = new FileWriter(file, true);
			BufferedWriter br = new BufferedWriter(fr);
			String ispis=getNaziv()+"\n";
			System.out.println("tuuuuuuuu");
			br.write(ispis);
			br.close();
			fr.close();
		} catch (IOException e) {
			System.out.print(e.getMessage());
		} // cuvanje u fajlu
		tipovi.add(this);
		return tipovi;
	}
	public ArrayList<TipTretmana>  obrisiTipTretmana(ArrayList<TipTretmana> tipovi,ArrayList<Tretman> tretmani) {
		tipovi.remove(tipovi.indexOf(this));
		for(int i=0;i<tretmani.size();i++) {
			if(tretmani.get(i).getTip()==this) {
				tretmani.get(i).obrisiTretman(tretmani);
			}
		}
		File file=new File("C:\\Users\\User\\eclipse-workspace\\kt3_sv_67_2022\\src\\klase\\sacuvaniPodaci\\tipoviTretmana.txt");
		try {
			FileWriter file1 = new FileWriter(file, false);
			for(TipTretmana i : tipovi) {	
		    file1.write(i.getNaziv()+"\n");
			}
		    file1.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}   
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
		return tipovi;
	}
	
	public void izmenaTipaTretmana(TipTretmana novi,ArrayList<TipTretmana> tipovi) {
		tipovi.remove(tipovi.indexOf(this));
		if(novi.getNaziv()!=this.getNaziv()) {
			this.setNaziv(novi.getNaziv());
		}
		this.sacuvajTipTretmana(tipovi);
	}
	public String napraviString() {
		return "naziv: "+ this.getNaziv();
	}


}
