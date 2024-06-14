package GUI;

import java.awt.Color;
import java.lang.reflect.Method;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import klase.Klijent;
import klase.Kontejneri;
import klase.Kozmeticar;
import klase.Menadzer;
import klase.NovcanikSalona;
import klase.Recepcionar;

public class DefaultButton extends JButton {
    public String korisnickoIme;
    public String lozinka;

    public DefaultButton(String poruka) {
        this.setText(poruka);
        this.setBackground(Color.white);
        
    }

    // Dugme za sledeci prozor logovanje
    public DefaultButton(Prozor prozor, String poruka, Kontejneri kontejner, String korisnik, NovcanikSalona novcanikSalona) {
        this.setText(poruka);
        this.setBackground(Color.white);
        this.addActionListener(e -> {
        	this.korisnickoIme= JOptionPane.showInputDialog("Unesite korisnicko ime");
            this.lozinka=JOptionPane.showInputDialog("Unesite lozinku");
            if(korisnickoIme==null||lozinka==null) {
            	return;
            }
            Prozor zakaziKozmetickiTretman= new Prozor("zakaziKozmetickiTretman","Zakazite kozmeticki tretman",0);
            if(korisnik=="klijent") {
            for(Klijent i:kontejner.klijenti) {
            	if(this.korisnickoIme.equalsIgnoreCase(i.getKorisnickoIme()) && this.lozinka.equalsIgnoreCase(i.getLozinka())) {
            		System.out.println("uspesno ste prijavljeni");
               	 	prozor.setVisible(true);
            		salonGui.przorKlijenta(prozor, i,kontejner,novcanikSalona,zakaziKozmetickiTretman);
            		break;}
            }}
            else if(korisnik=="recepcionar") {
            for(Recepcionar i: kontejner.recepcionari) {
            	

            	if(this.korisnickoIme.equalsIgnoreCase(i.getKorisnickoIme())&&this.lozinka.equalsIgnoreCase(i.getLozinka())) {
            		System.out.println("uspesno ste prijavljeni");
               	 	prozor.setVisible(true);
            		salonGui.prozorRecepcionara(prozor, i,kontejner,zakaziKozmetickiTretman,novcanikSalona);
            		break;
            	}
            }}
            else if(korisnik=="menadzer") {
            
            for(Menadzer i: kontejner.menadzeri) {
            	if(this.korisnickoIme.equalsIgnoreCase(i.getKorisnickoIme())&&this.lozinka.equalsIgnoreCase(i.getLozinka())) {
            		System.out.println("uspesno ste prijavljeni");
               	 	prozor.setVisible(true);
            		salonGui.prozorMenadzera(prozor, i,novcanikSalona,kontejner);
            		break;
            	}
            }}
            else if(korisnik=="kozmeticar") {
            for(Kozmeticar i: kontejner.kozmeticari) {
            	if(this.korisnickoIme.equalsIgnoreCase(i.getKorisnickoIme())&&this.lozinka.equalsIgnoreCase(i.getLozinka())) {
            		System.out.println("uspesno ste prijavljeni");
               	 	prozor.setVisible(true);
            		salonGui.prozorKozmeticara(prozor, i,kontejner,novcanikSalona);
            		break;
            	}
            }}
            else {
            	System.out.println("niste ulogovani");
            }
            
        });
    }

	
    
}
