//klase prozor, defaultLabel, defaultButton i defaultPanel su napravljene tako da svaki od ovih elemenata ima istu boju ili namenu bez nepotrebnog dodeljivanja vrednosti svaki put kada se napravi
package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import klase.KarticaLojalnosti;
import klase.Klijent;
import klase.Kontejneri;
import klase.Kozmeticar;
import klase.Menadzer;
import klase.NovcanikSalona;
import klase.Recepcionar;
import tretmani.Opcije;
import tretmani.TipTretmana;
import tretmani.Tretman;
import tretmani.ZakazanTretman;

public class salonGui{


	public static void main(String[] args) {
		Kontejneri kontejneri=new Kontejneri();
		NovcanikSalona novcanikSalona=new NovcanikSalona();
		
		Prozor glavniProzor=new Prozor();
		Prozor prozorMenadzer=new Prozor("Menadzer","Ulogovani ste kao menadzer");
		Prozor prozorKljient =new Prozor("Klijent","Ulogovani ste kao klijent");
		Prozor prozorRecepcionar=new Prozor("Recepcionar","Ulogovani ste kao recepcionar");
		Prozor prozorKozmeticar =new Prozor("Kozmeticar","Ulogovani ste kao kozmeticar");
		Prozor registracijaKorisnika= new Prozor("Registracija","Registrujte se:",0);
		
		
		DefaultPanel DefaultPanelLog= new DefaultPanel("Ulogujte se kao:",70);
		glavniProzor.add(DefaultPanelLog);
		
		DefaultPanel prijavljivanje= new DefaultPanel(150,4,1);
		
		DefaultButton dugmeMenadzer=new DefaultButton(prozorMenadzer,"Menadzer",kontejneri,"menadzer",novcanikSalona);
		prijavljivanje.add(dugmeMenadzer);
		
		DefaultButton dugmeKlijent=new DefaultButton(prozorKljient,"Klijent",kontejneri,"klijent",novcanikSalona);
		
	
		prijavljivanje.add(dugmeKlijent);
		
		DefaultButton dugmeRecepcionar=new DefaultButton(prozorRecepcionar,"Recepcionar",kontejneri,"recepcionar",novcanikSalona);
		prijavljivanje.add(dugmeRecepcionar);
		
		DefaultButton dugmeKozmeticar=new DefaultButton(prozorKozmeticar,"Kozmeticar",kontejneri,"kozmeticar",novcanikSalona);
		prijavljivanje.add(dugmeKozmeticar);
		
		glavniProzor.add(prijavljivanje);
		registracijaKlijenta(registracijaKorisnika,kontejneri,prozorKljient,true);
		
	    
		DefaultPanel DefaultPanelLog2= new DefaultPanel("Registruj se kao novi klijent:",270);
		glavniProzor.add(DefaultPanelLog2);
		DefaultPanel registracija= new DefaultPanel(350,1,1);
		DefaultButton dugmeRegistracija= new DefaultButton("Registruj se");
		dugmeRegistracija.addActionListener(e -> {
        	registracijaKorisnika.setVisible(true);
        });
		registracija.add(dugmeRegistracija);
		glavniProzor.add(registracija);

		
		glavniProzor.setVisible(true);
		
		
		
	}

	public static void registracijaKlijenta(Prozor registracijaKorisnika,Kontejneri kontejneri, Prozor prozorKljient,boolean klijentSeRegistruje) {
		JTextField Field1= new JTextField(20);
		DefaultPanel myPanel1 = new DefaultPanel(80,"Unesite ime:",Field1); 
		registracijaKorisnika.add(myPanel1);

		JTextField Field2= new JTextField(20);
		DefaultPanel myPanel2 = new DefaultPanel(120,"Unesite prezime:",Field2);
		registracijaKorisnika.add(myPanel2);
		
		DefaultPanel myPanel3 = new DefaultPanel("Unesite pol:",160);
		String[] pol = { "muski","zenski"};

	    final JComboBox<String> cb = new JComboBox<String>(pol);
	    String Field3 = (String) cb.getSelectedItem();
	    cb.setVisible(true);
	    myPanel3.add(cb);
		registracijaKorisnika.add(myPanel3);
		
		JTextField Field4= new JTextField(20);
		DefaultPanel myPanel4 = new DefaultPanel(210,"Unesite telefon:",Field4);
		registracijaKorisnika.add(myPanel4);
		
		JTextField Field5= new JTextField(20);
		DefaultPanel myPanel5 = new DefaultPanel(250,"Unesite adresu:",Field5);
		registracijaKorisnika.add(myPanel5);
		
		JTextField Field6= new JTextField(20);
		DefaultPanel myPanel6 = new DefaultPanel(290,"Unesite korisnicko ime:",Field6);
		registracijaKorisnika.add(myPanel6);
		
		JTextField Field7= new JTextField(20);
		
		DefaultPanel myPanel7 = new DefaultPanel(330,"Unesite lozinku:",Field7);
		registracijaKorisnika.add(myPanel7);
		
		DefaultPanel submitPanel=new  DefaultPanel(370);
		DefaultButton submitRegistracija=new DefaultButton("Sacuvaj");
		submitRegistracija.addActionListener(e -> {
			Klijent registrovanKlijent1= new Klijent(Field1.getText(),Field2.getText(),Field3,Field4.getText(),Field5.getText(),Field6.getText(),Field7.getText());
			registrovanKlijent1.sacuvajKlijenta(kontejneri.klijenti);
			if (klijentSeRegistruje==true) {
				prozorKljient.setVisible(true);
			}
        });
		submitPanel.add(submitRegistracija);
		registracijaKorisnika.add(submitPanel);
	}

	public static void przorKlijenta(Prozor prozorKlijent,Klijent trenutni,Kontejneri kontejner,NovcanikSalona novcanikSalona,Prozor zakaziKozmetickiTretman) {
		prozorKlijent.isprazniProzor("Klijent","Ulogovani ste kao klijent");

		AtomicInteger i = new AtomicInteger(180);
		
		System.out.println("ulogovani ste kao korisnik "+trenutni.getIme());
		prozorKlijent.panelZaKlijenta=new DefaultPanel(80,3,1);
		
		DefaultButton zakaziTretman =new DefaultButton("Zakazi tretman");
		zakaziTretman.addActionListener(e-> {
			prozorKlijent.isprazniProzor("Klijent","Ulogovani ste kao klijent");
			zakaziTretman(zakaziKozmetickiTretman,trenutni,kontejner,0,Opcije.ONLINE_ZAKAZIVANJE);
		});
		prozorKlijent.panelZaKlijenta.add(zakaziTretman);
		DefaultPanel panelZaTablu=new DefaultPanel(150);
		DefaultButton prikaziZakazaneTretmane= new DefaultButton("Prikazi zakazane tretmane");
		prikaziZakazaneTretmane.addActionListener(e->{
			prozorKlijent.isprazniProzor("Klijent","Ulogovani ste kao klijent");
			ArrayList<ZakazanTretman>tretmani=kontejner.prikaziSveZakazaneTretmaneZaKlijenta(trenutni);
			int m=i.get();
			tableMaker tabela= new tableMaker( kontejner,  prozorKlijent,tretmani,m);
			DefaultButton otkazi=new DefaultButton("otkazi tretman");
			prozorKlijent.getContentPane().add(otkazi);
			otkazi.addActionListener(ei->{
				tabela.otkaziTretman(kontejner, novcanikSalona,"klijent");
			});
			otkazi.setBounds(10, m+200, 688, 37);
			
			});
	
		prozorKlijent.panelZaKlijenta.add(prikaziZakazaneTretmane);
		
		DefaultButton prikaziInformacije= new DefaultButton("Prikazi informacije o Vama");
		prikaziInformacije.addActionListener(e->{
			prozorKlijent.isprazniProzor("Klijent","Ulogovani ste kao klijent");
			int m=i.get();
			tableMaker tabela=new tableMaker(trenutni, m,prozorKlijent);
			 
		});
		prozorKlijent.panelZaKlijenta.add(prikaziInformacije);
		
		prozorKlijent.add(prozorKlijent.panelZaKlijenta);
	}
	public static void prozorKozmeticara(Prozor prozorKozmeticar, Kozmeticar trenutni,Kontejneri kontejner, NovcanikSalona novcanikSalona) {
		prozorKozmeticar.isprazniProzor("Kozmeticar","Ulogovani ste kao kozmeticar");
		AtomicInteger i = new AtomicInteger(180);
		System.out.println("ulogovani ste kao korisnik "+trenutni.getIme());
		prozorKozmeticar.panelZaKlijenta=new DefaultPanel(80,3,1);
		DefaultButton ZakazanitretmaniBtn = new DefaultButton("Svi zakazaniTretmani");
		ZakazanitretmaniBtn.addActionListener(e->{
			prozorKozmeticar.isprazniProzor("Kozmeticar","Ulogovani ste kao kozmeticar");

			ArrayList<ZakazanTretman> zakazani= new ArrayList<ZakazanTretman>();
			for(ZakazanTretman j: kontejner.zakazaniTretmani) {
				if(j.getKozmeticar().getIme().equals(trenutni.getIme())) {
					zakazani.add(j);
				}
			}
			tableMaker table= new tableMaker(kontejner,prozorKozmeticar,trenutni,zakazani,i.get());
			
			DefaultPanel panelOI=new DefaultPanel(330,2,1);
			DefaultButton otkazi=new DefaultButton("otkazi tretman");
			DefaultButton izvrsen=new DefaultButton("izvrsi  tretman");
			panelOI.add(otkazi);
			panelOI.add(izvrsen);
			otkazi.addActionListener(ei->{
				table.otkaziTretman(kontejner, novcanikSalona,"kozmeticar otkazi");
			});
			izvrsen.addActionListener(ei->{
				table.otkaziTretman(kontejner, novcanikSalona,"kozmeticar zavrsi");
			});
			prozorKozmeticar.getContentPane().add(panelOI);

			prozorKozmeticar.getContentPane().revalidate();
			prozorKozmeticar.getContentPane().repaint();
		});
		DefaultButton InfoBtn = new DefaultButton("Sve informacije");
		InfoBtn.addActionListener(e->{
			prozorKozmeticar.isprazniProzor("Kozmeticar","Ulogovani ste kao kozmeticar");

			tableMaker tabela=new tableMaker(  prozorKozmeticar, kontejner, trenutni,kontejner.zakazaniTretmani,i.get());
			JLabel tretmani = new JLabel("Kozmeticki tretmani: ");
			tretmani.setBounds(52, i.get(), 148, 33);
			prozorKozmeticar.getContentPane().add(tretmani);
			
			JPanel panelZaTablu=new JPanel(new GridLayout(0, trenutni.getKozmetickiTretmani().size()));
			for(int m =0;m< trenutni.getKozmetickiTretmani().size();m++) {
				JLabel label = new JLabel(trenutni.getKozmetickiTretmani().get(m).getNaziv());
	            label.setHorizontalAlignment(JLabel.CENTER); // Center align the text
	            label.setOpaque(true); // Make the label opaque
	            label.setBackground(Color.WHITE); // Set the background color to white
	            panelZaTablu.add(label);
			}
			panelZaTablu.setBounds(220, i.get(), 450, 33);
			panelZaTablu.setVisible(true);
			prozorKozmeticar.getContentPane().add(panelZaTablu);
			prozorKozmeticar.getContentPane().revalidate();
			prozorKozmeticar.getContentPane().repaint();
		});
		
		
		prozorKozmeticar.panelZaKlijenta.add(InfoBtn);
		prozorKozmeticar.panelZaKlijenta.add(ZakazanitretmaniBtn);
		
		prozorKozmeticar.add(prozorKozmeticar.panelZaKlijenta);
		
		
	}

	public static void prozorRecepcionara(Prozor prozorRecepcionar, Recepcionar trenutni,Kontejneri kontejner,Prozor zakaziKozmetickiTretman,NovcanikSalona novcanikSalona) {
		prozorRecepcionar.isprazniProzor("Recepcionar","Ulogovani ste kao recepcionar");
		System.out.println("ulogovani ste kao korisnik "+trenutni.getIme());
		AtomicInteger i = new AtomicInteger(180);
		prozorRecepcionar.panelZaKlijenta=new DefaultPanel(80,3,1);
		DefaultButton pregledTretmana =new DefaultButton("Pregled tretmana");
		
		pregledTretmana.addActionListener(e->{
			prozorRecepcionar.isprazniProzor("Recepcionar","Ulogovani ste kao recepcionar");

			tableMaker tabela= new tableMaker( kontejner,  prozorRecepcionar,kontejner.zakazaniTretmani,i.get());
			i.addAndGet(200);
			DefaultPanel panelOI=new DefaultPanel(i.get(),2,1);
			DefaultButton otkazi=new DefaultButton("otkazi tretman");
			DefaultButton izmena=new DefaultButton("izmeni  tretman");
			panelOI.add(otkazi);
			panelOI.add(izmena);
			otkazi.addActionListener(ei->{
				tabela.otkaziTretman(kontejner, novcanikSalona,"kozmeticar otkazi");
			});
			izmena.addActionListener(ei->{
				prozorRecepcionar.isprazniProzor("Recepcionar","Ulogovani ste kao recepcionar");
				tabela.otkaziTretman(kontejner, novcanikSalona,"izmena");
			});
			prozorRecepcionar.add(panelOI);

			prozorRecepcionar.getContentPane().revalidate();
			prozorRecepcionar.getContentPane().repaint();
		});
		DefaultButton infoBtn = new DefaultButton("Sve informacije");
		infoBtn.addActionListener(e->{
			prozorRecepcionar.isprazniProzor("Recepcionar","Ulogovani ste kao recepcionar");

			tableMaker tabela=new tableMaker( prozorRecepcionar, kontejner, trenutni,kontejner.zakazaniTretmani,i.get());
		});
		DefaultButton zakaziTretman =new DefaultButton("Zakazi tretman");
		zakaziTretman.addActionListener(e-> {
			prozorRecepcionar.isprazniProzor("Recepcionar","Ulogovani ste kao recepcionar");

			zakaziTretman(zakaziKozmetickiTretman,trenutni,kontejner);
		});
		prozorRecepcionar.panelZaKlijenta.add(zakaziTretman);
		prozorRecepcionar.panelZaKlijenta.add(infoBtn);
		prozorRecepcionar.panelZaKlijenta.add(pregledTretmana);
		prozorRecepcionar.add(prozorRecepcionar.panelZaKlijenta);
	}

	public static void prozorMenadzera(Prozor prozorMenadzer, Menadzer trenutni,NovcanikSalona novcanikSalona,Kontejneri kontejner) {
		prozorMenadzer.isprazniProzor("Menadzer", "Ulogovani ste kao menadzer");
		System.out.println("ulogovani ste kao korisnik "+trenutni.getIme());
		AtomicInteger i = new AtomicInteger(250);
		prozorMenadzer.panelZaKlijenta=new DefaultPanel(80,4,3);
//		registracija klijenta dugme
		DefaultButton registrujKlijenta =new DefaultButton("Registruj klijenta");
		registrujKlijenta.addActionListener(e->{
			prozorMenadzer.isprazniProzor("Menadzer", "Ulogovani ste kao menadzer");
			Prozor registracijaKorisnika= new Prozor("Registracija","Registrujte klijenta:");
			registracijaKlijenta(registracijaKorisnika,kontejner,prozorMenadzer, false);
			registracijaKorisnika.setVisible(true);
		});
//		registracija zaposlenog dugme
		DefaultButton registrujZaposlenog =new DefaultButton("Registruj zaposlenog");
		registrujZaposlenog.addActionListener(e->{
			prozorMenadzer.isprazniProzor("Menadzer", "Ulogovani ste kao menadzer");
			Prozor registracijaKorisnika= new Prozor("Registracija","Registrujte zaposlenog:",0);
			registracijaZaposlenih(trenutni,registracijaKorisnika,kontejner,prozorMenadzer);
			registracijaKorisnika.setVisible(true);
	    });
//		pregled zaposlenih dugme
		DefaultButton pregledZaposlenih =new DefaultButton("Pregled svih zaposlenih");
		pregledZaposlenih.addActionListener(e->{
			prozorMenadzer.isprazniProzor("Menadzer", "Ulogovani ste kao menadzer");
			tableMaker tabela=new tableMaker(prozorMenadzer,kontejner,i.get());
		});
//		pregled prihoda i rashoda dugme
		DefaultButton pregledNovcanika =new DefaultButton("Pregled novcanika salona");
		pregledNovcanika.addActionListener(e->{
			prozorMenadzer.isprazniProzor("Menadzer", "Ulogovani ste kao menadzer");
			tableMaker tabela=new tableMaker(novcanikSalona,prozorMenadzer,i.get());
		});
//		nova lojalti kartica dugme
		DefaultButton lojaltiKarticaDugme =new DefaultButton("Napravi lojalti karticu");
		lojaltiKarticaDugme.addActionListener(e->{
			prozorMenadzer.isprazniProzor("Menadzer", "Ulogovani ste kao menadzer");

			JTextField Field1 = new JTextField(20);
		    DefaultPanel myPanel1 = new DefaultPanel(i.get(), "Unesite minialan iznos za ostvarenje lojalti kartice:", Field1);
		    prozorMenadzer.add(myPanel1);
	        DefaultButton sacuvaj = new DefaultButton("Sacuvaj");
	        sacuvaj.addActionListener(ei->{
	        	KarticaLojalnosti lojaltiKartica=new KarticaLojalnosti(trenutni,Integer.parseInt(Field1.getText()),kontejner);
	        	lojaltiKartica.sacuvajKarticu(kontejner.karticeLojalnosti);
	        });
	        sacuvaj.setBounds(75, i.get()+50, 503, 23);
	        prozorMenadzer.getContentPane().add(sacuvaj);
	        prozorMenadzer.getContentPane().revalidate();
	        prozorMenadzer.getContentPane().repaint();
		});
//		napravljene lojalti kartice dugme
		DefaultButton pregledKartica =new DefaultButton("Pogledajte sve  lojalti kartice");
		pregledKartica.addActionListener(e->{
			prozorMenadzer.isprazniProzor("Menadzer", "Ulogovani ste kao menadzer");
			tableMaker table=new tableMaker(prozorMenadzer, kontejner, trenutni, i.get());
		});
//		informacije o menadzeru dugme
		DefaultButton informacije =new DefaultButton("Pogledajte vase informacije");
		informacije.addActionListener(e->{
			prozorMenadzer.isprazniProzor("Menadzer", "Ulogovani ste kao menadzer");
			tableMaker tabela=new tableMaker( prozorMenadzer, kontejner, trenutni,kontejner.zakazaniTretmani,i.get());
		});
//		cenovnik dugme
		DefaultButton cenovnik =new DefaultButton("Ispravite cenovnik");
		cenovnik.addActionListener(e->{
			prozorMenadzer.isprazniProzor("Menadzer", "Ulogovani ste kao menadzer");
			tableMaker table=new tableMaker(prozorMenadzer, trenutni, kontejner, i.get());
			JTextField Field1 = new JTextField(20);
		    DefaultPanel myPanel1 = new DefaultPanel(i.get()+200, "Unesite novi iznos:", Field1);
		    prozorMenadzer.add(myPanel1);
		    
		    ArrayList<String> tretmani=new ArrayList<String>();
		    for(Tretman z:kontejner.tretmani) {
		    	tretmani.add(z.getNaziv());
		    }
		    String[] tretmaniZaCB=new String[tretmani.size()];
	        for (int l = 0; l < tretmani.size(); l++) {
	        	tretmaniZaCB[l] = tretmani.get(l);
	        }
		    JComboBox<String> Combo = new JComboBox<String>(tretmaniZaCB);
		    DefaultPanel myPanel2 = new DefaultPanel(i.get()+250, "Izaberite tretman:", Combo);
		    prozorMenadzer.add(myPanel2);
			DefaultButton izmena=new DefaultButton("Izmeni");
			izmena.addActionListener(ei->{
				for(Tretman k:kontejner.tretmani) {
					if(k.getNaziv().equals(Combo.getSelectedItem().toString())) {
						Tretman t=k;
						t.setCena(Double.parseDouble(Field1.getText()));
						k.izmenaTretmana(t, kontejner.tretmani, kontejner.tipoviTretmana);
					}
				}
			});
			izmena.setBounds(75, i.get()+300, 503, 23);
	        prozorMenadzer.getContentPane().add(izmena);

	        prozorMenadzer.getContentPane().revalidate();
	        prozorMenadzer.getContentPane().repaint();
		});
//      dodaj bonus yaposlenom
		DefaultButton bonusi=new DefaultButton("Dodaj bonus zaposlenima");
		bonusi.addActionListener(e->{
			prozorMenadzer.isprazniProzor("Menadzer", "Ulogovani ste kao menadzer");

			tableMaker tabela=new tableMaker(prozorMenadzer,kontejner,i.get());
			JTextField Field1 = new JTextField(20);
		    DefaultPanel myPanel1 = new DefaultPanel(i.get()+200, "Unesite bonus:", Field1);
		    prozorMenadzer.add(myPanel1);
		    ArrayList<String> imena=new ArrayList<String>();
		    for(Menadzer z:kontejner.menadzeri) {
		    	imena.add(z.getIme());
		    }
		    for(Recepcionar z:kontejner.recepcionari) {
		    	imena.add(z.getIme());
		    }
		    for(Kozmeticar z:kontejner.kozmeticari) {
		    	imena.add(z.getIme());
		    }
		    String[] imenaZaCB=new String[imena.size()];
	        for (int l = 0; l < imena.size(); l++) {
	        	imenaZaCB[l] = imena.get(l);
	        }
		    JComboBox<String> Combo = new JComboBox<String>(imenaZaCB);
		    DefaultPanel myPanel2 = new DefaultPanel(i.get()+250, "Izaberite zaposlenog :", Combo);
		    prozorMenadzer.add(myPanel2);
			DefaultButton izmena=new DefaultButton("Dodaj bonus");
			izmena.addActionListener(ei->{
				 for(Menadzer z:kontejner.menadzeri) {
						if(z.getIme().equals(Combo.getSelectedItem().toString())) {
							Menadzer t=z;
							t.setBonus(Integer.parseInt(Field1.getText()));
							z.izmeniMenadzera(t,kontejner.menadzeri);
						}
				    }
				    for(Recepcionar z:kontejner.recepcionari) {
				    	if(z.getIme().equals(Combo.getSelectedItem().toString())) {
				    		Recepcionar t=z;
							t.setBonus(Integer.parseInt(Field1.getText()));
							z.izmeniRecepcionara(trenutni, t, kontejner.recepcionari);
						}
				    }
				    for(Kozmeticar z:kontejner.kozmeticari) {
				    	if(z.getIme().equals(Combo.getSelectedItem().toString())) {
				    		Kozmeticar t=z;
							t.setBonus(Integer.parseInt(Field1.getText()));
							z.izmeniKozmeticara(trenutni, t, kontejner.kozmeticari);
						}
				    }
				
			});
			izmena.setBounds(75, i.get()+300, 503, 23);
	        prozorMenadzer.getContentPane().add(izmena);
	        prozorMenadzer.getContentPane().revalidate();
	        prozorMenadzer.getContentPane().repaint();
		});
//		klijenti sa lojalti karticom
		DefaultButton klijentiSaKarticom=new DefaultButton("Klijenti sa karticama lojalnosti");
		klijentiSaKarticom.addActionListener(e->{
			prozorMenadzer.isprazniProzor("Menadzer", "Ulogovani ste kao menadzer");
			tableMaker tabela=new tableMaker(i.get(),prozorMenadzer,kontejner);
		});
//		svi klijenti
		DefaultButton sviKlijenti=new DefaultButton("Svi klijenti");
		sviKlijenti.addActionListener(e->{
			prozorMenadzer.isprazniProzor("Menadzer", "Ulogovani ste kao menadzer");
			tableMaker tabela =new tableMaker(i.get(),kontejner,prozorMenadzer);
		});
//		izvestaji
		DefaultButton izvestaji= new DefaultButton("Izvestaji");
		izvestaji.addActionListener(e->{
			Prozor prozorIzvestaji=new Prozor("Izvestaji","IZVESTAJI");
			prozorIzvestajiFunkcija(prozorIzvestaji,kontejner,novcanikSalona);
		});
		prozorMenadzer.panelZaKlijenta.add(registrujKlijenta);
		prozorMenadzer.panelZaKlijenta.add(registrujZaposlenog);
		prozorMenadzer.panelZaKlijenta.add(pregledZaposlenih);
		prozorMenadzer.panelZaKlijenta.add(pregledNovcanika);
		prozorMenadzer.panelZaKlijenta.add(lojaltiKarticaDugme);
		prozorMenadzer.panelZaKlijenta.add(pregledKartica);
		prozorMenadzer.panelZaKlijenta.add(informacije);
		prozorMenadzer.panelZaKlijenta.add(cenovnik);
		prozorMenadzer.panelZaKlijenta.add(bonusi);
		prozorMenadzer.panelZaKlijenta.add(klijentiSaKarticom);
		prozorMenadzer.panelZaKlijenta.add(sviKlijenti);
		prozorMenadzer.panelZaKlijenta.add(izvestaji);
		prozorMenadzer.panelZaKlijenta.setVisible(true);
		prozorMenadzer.add(prozorMenadzer.panelZaKlijenta);



		
	}
	
	private static void prozorIzvestajiFunkcija(Prozor prozorIzvestaji, Kontejneri kontejner,NovcanikSalona novcanikSalona) {
		prozorIzvestaji.isprazniProzor("Izvestaji", "IZVESTAJI");
		prozorIzvestaji.setVisible(true);
		prozorIzvestaji.panelZaKlijenta=new DefaultPanel(80,4,1);
		DefaultButton izvestaji1=new DefaultButton("Tremani jednog kozmeticara");
		izvestaji1.addActionListener(e->{
			prozorIzvestaji.isprazniProzor("Izvestaji", "IZVESTAJI");
			String[] dan= {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
			JComboBox comboBoxDanOd = new JComboBox(dan);
			comboBoxDanOd.setBounds(299, 211, 87, 22);
			prozorIzvestaji.getContentPane().add(comboBoxDanOd);
			
			String[] meseci= {"januar","februar","mart","april","maj","jun","jul","avgust","septembar","oktobar","novembar","decembar"};
			JComboBox comboBoxMesecOd = new JComboBox(meseci);
			comboBoxMesecOd.setBounds(434, 211, 87, 22);
			prozorIzvestaji.getContentPane().add(comboBoxMesecOd);
			
			String[] godine= {"2023","2024"};
			JComboBox comboBoxGodinaOd= new JComboBox(godine);
			comboBoxGodinaOd.setBounds(557, 211, 87, 22);
			prozorIzvestaji.getContentPane().add(comboBoxGodinaOd);
			
			JComboBox comboBoxDanDo = new JComboBox(dan);
			comboBoxDanDo.setBounds(299, 258, 87, 22);
			prozorIzvestaji.getContentPane().add(comboBoxDanDo);
			
			JComboBox comboBoxMesecDo = new JComboBox(meseci);
			comboBoxMesecDo.setBounds(434, 258, 87, 22);
			prozorIzvestaji.getContentPane().add(comboBoxMesecDo);
			
			JComboBox comboBoxGodinaDo= new JComboBox(godine);
			comboBoxGodinaDo.setBounds(557, 258, 87, 22);
			prozorIzvestaji.getContentPane().add(comboBoxGodinaDo);
			
			ArrayList<String> kozmeticari = new ArrayList<String>();  
			    for (Kozmeticar i : kontejner.kozmeticari) {
			                kozmeticari.add(i.getIme());
			    }
			String[] kozmeticariZaCB = kozmeticari.toArray(new String[0]);
			JComboBox comboBox = new JComboBox(kozmeticariZaCB);
			comboBox.setBounds(299, 167, 345, 22);
			prozorIzvestaji.getContentPane().add(comboBox);
			
			
			JLabel kozmeticarLabel = new JLabel("Kozmeticar:");
			kozmeticarLabel.setBounds(40, 167, 209, 22);
			prozorIzvestaji.getContentPane().add(kozmeticarLabel);
			
			JLabel vremeOdLabel = new JLabel("Vreme od:");
			vremeOdLabel.setBounds(40, 215, 209, 22);
			prozorIzvestaji.getContentPane().add(vremeOdLabel);
			
			JLabel vremeDolabel = new JLabel("Vreme do:");
			vremeDolabel.setBounds(40, 262, 209, 22);
			prozorIzvestaji.getContentPane().add(vremeDolabel);
			
			DefaultButton prikaziDugme = new DefaultButton("Prikazi");
			prikaziDugme.setBounds(40, 316, 604, 23);
			prozorIzvestaji.getContentPane().add(prikaziDugme);
			prikaziDugme.addActionListener(ej->{
				 String danCBDo = comboBoxDanDo.getSelectedItem().toString();
				    String mesecCBDo =comboBoxMesecDo.getSelectedItem().toString();
				    String godinaCbDo =comboBoxGodinaDo.getSelectedItem().toString();
				    String danCBOd = comboBoxDanOd.getSelectedItem().toString();
				    String mesecCBOd =comboBoxMesecOd.getSelectedItem().toString();
				    String godinaCbOd =comboBoxGodinaOd.getSelectedItem().toString();

					String monthNumberDo;
					String monthNumberOd;

					
					switch (mesecCBDo) {
					    case "januar":
					        monthNumberDo ="01";
					        break;
					    case "februar":
					    	monthNumberDo = "02";
					        break;
					    case "mart":
					    	monthNumberDo ="03";
					        break;
					    case "april":
					    	monthNumberDo = "04";
					        break;
					    case "maj":
					    	monthNumberDo = "05";
					        break;
					    case "jun":
					    	monthNumberDo ="06";
					        break;
					    case "jul":
					    	monthNumberDo = "07";
					        break;
					    case "avgust":
					    	monthNumberDo = "08";
					        break;
					    case "septembar":
					    	monthNumberDo = "09";
					        break;
					    case "oktobar":
					    	monthNumberDo = "10";
					        break;
					    case "novembar":
					    	monthNumberDo = "11";
					        break;
					    case "decembar":
					    	monthNumberDo = "12";
					        break;
					    default:
					    	monthNumberDo = "-1"; // Invalid month name
					        break;
					}
					switch (mesecCBOd) {
				    case "januar":
				    	monthNumberOd ="01";
				        break;
				    case "februar":
				    	monthNumberOd = "02";
				        break;
				    case "mart":
				    	monthNumberOd ="03";
				        break;
				    case "april":
				    	monthNumberOd = "04";
				        break;
				    case "maj":
				    	monthNumberOd = "05";
				        break;
				    case "jun":
				    	monthNumberOd ="06";
				        break;
				    case "jul":
				    	monthNumberOd = "07";
				        break;
				    case "avgust":
				    	monthNumberOd = "08";
				        break;
				    case "septembar":
				    	monthNumberOd = "09";
				        break;
				    case "oktobar":
				    	monthNumberOd = "10";
				        break;
				    case "novembar":
				    	monthNumberOd = "11";
				        break;
				    case "decembar":
				    	monthNumberOd = "12";
				        break;
				    default:
				    	monthNumberOd = "-1"; // Invalid month name
				        break;
				}
				    String kozmeticarCB = comboBox.getSelectedItem().toString();
				    LocalDateTime datumVremeDo = null;
				    if ( danCBDo != null && mesecCBDo != null && godinaCbDo != null) {
				       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
				       String dateTimeString = godinaCbDo + "-" + monthNumberDo + "-" + danCBDo+"T00:00";
				       datumVremeDo = LocalDateTime.parse(dateTimeString, formatter);
				    }
				    LocalDateTime datumVremeOd = null;
				    if ( danCBOd != null && mesecCBOd != null && godinaCbOd != null) {
					       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
					       String dateTimeString = godinaCbOd + "-" + monthNumberOd + "-" + danCBOd+"T00:00";
					       datumVremeOd = LocalDateTime.parse(dateTimeString, formatter);
					    }
				    Kozmeticar kozmeticar= new Kozmeticar();
				    for (Kozmeticar i: kontejner.kozmeticari) {
				    	if (i.getIme().equals(kozmeticarCB)) {
				    		kozmeticar=i;
				    		break;
				    	}
				    }
				    tableMaker tabela=new tableMaker(prozorIzvestaji,datumVremeDo,datumVremeOd,kozmeticar,kontejner,novcanikSalona,360);
			});
			   prozorIzvestaji.getContentPane().revalidate();
			   prozorIzvestaji.getContentPane().repaint();
		});
		DefaultButton izvestaji2=new DefaultButton("Izvrsavanja tretmana");
		izvestaji2.addActionListener(e->{
			prozorIzvestaji.isprazniProzor("Izvestaji", "IZVESTAJI");
			String[] dan= {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
			JComboBox comboBoxDanOd = new JComboBox(dan);
			comboBoxDanOd.setBounds(299, 211, 87, 22);
			prozorIzvestaji.getContentPane().add(comboBoxDanOd);
			
			String[] meseci= {"januar","februar","mart","april","maj","jun","jul","avgust","septembar","oktobar","novembar","decembar"};
			JComboBox comboBoxMesecOd = new JComboBox(meseci);
			comboBoxMesecOd.setBounds(434, 211, 87, 22);
			prozorIzvestaji.getContentPane().add(comboBoxMesecOd);
			
			String[] godine= {"2023","2024"};
			JComboBox comboBoxGodinaOd= new JComboBox(godine);
			comboBoxGodinaOd.setBounds(557, 211, 87, 22);
			prozorIzvestaji.getContentPane().add(comboBoxGodinaOd);
			
			JComboBox comboBoxDanDo = new JComboBox(dan);
			comboBoxDanDo.setBounds(299, 258, 87, 22);
			prozorIzvestaji.getContentPane().add(comboBoxDanDo);
			
			JComboBox comboBoxMesecDo = new JComboBox(meseci);
			comboBoxMesecDo.setBounds(434, 258, 87, 22);
			prozorIzvestaji.getContentPane().add(comboBoxMesecDo);
			
			JComboBox comboBoxGodinaDo= new JComboBox(godine);
			comboBoxGodinaDo.setBounds(557, 258, 87, 22);
			prozorIzvestaji.getContentPane().add(comboBoxGodinaDo);
			
			
			String[] opcijeZaCB = {	"ZAKAZAN","IZVRSEN","OTKAZAO_KLIJENT","OTLAZAO_SALON","NIJE_SE_POJAVIO","NEDEFINISAN","ONLINE_ZAKAZIVANJE"};
			JComboBox comboBox = new JComboBox(opcijeZaCB);
			comboBox.setBounds(299, 167, 345, 22);
			prozorIzvestaji.getContentPane().add(comboBox);
			
			
			JLabel opcijarLabel = new JLabel("Opcije:");
			opcijarLabel.setBounds(40, 167, 209, 22);
			prozorIzvestaji.getContentPane().add(opcijarLabel);
			
			JLabel vremeOdLabel = new JLabel("Vreme od:");
			vremeOdLabel.setBounds(40, 215, 209, 22);
			prozorIzvestaji.getContentPane().add(vremeOdLabel);
			
			JLabel vremeDolabel = new JLabel("Vreme do:");
			vremeDolabel.setBounds(40, 262, 209, 22);
			prozorIzvestaji.getContentPane().add(vremeDolabel);
			
			DefaultButton prikaziDugme = new DefaultButton("Prikazi");
			prikaziDugme.setBounds(40, 316, 604, 23);
			prozorIzvestaji.getContentPane().add(prikaziDugme);
			prikaziDugme.addActionListener(ej->{
				 String danCBDo = comboBoxDanDo.getSelectedItem().toString();
				    String mesecCBDo =comboBoxMesecDo.getSelectedItem().toString();
				    String godinaCbDo =comboBoxGodinaDo.getSelectedItem().toString();
				    String danCBOd = comboBoxDanOd.getSelectedItem().toString();
				    String mesecCBOd =comboBoxMesecOd.getSelectedItem().toString();
				    String godinaCbOd =comboBoxGodinaOd.getSelectedItem().toString();

					String monthNumberDo;
					String monthNumberOd;

					
					switch (mesecCBDo) {
					    case "januar":
					        monthNumberDo ="01";
					        break;
					    case "februar":
					    	monthNumberDo = "02";
					        break;
					    case "mart":
					    	monthNumberDo ="03";
					        break;
					    case "april":
					    	monthNumberDo = "04";
					        break;
					    case "maj":
					    	monthNumberDo = "05";
					        break;
					    case "jun":
					    	monthNumberDo ="06";
					        break;
					    case "jul":
					    	monthNumberDo = "07";
					        break;
					    case "avgust":
					    	monthNumberDo = "08";
					        break;
					    case "septembar":
					    	monthNumberDo = "09";
					        break;
					    case "oktobar":
					    	monthNumberDo = "10";
					        break;
					    case "novembar":
					    	monthNumberDo = "11";
					        break;
					    case "decembar":
					    	monthNumberDo = "12";
					        break;
					    default:
					    	monthNumberDo = "-1"; // Invalid month name
					        break;
					}
					switch (mesecCBOd) {
				    case "januar":
				    	monthNumberOd ="01";
				        break;
				    case "februar":
				    	monthNumberOd = "02";
				        break;
				    case "mart":
				    	monthNumberOd ="03";
				        break;
				    case "april":
				    	monthNumberOd = "04";
				        break;
				    case "maj":
				    	monthNumberOd = "05";
				        break;
				    case "jun":
				    	monthNumberOd ="06";
				        break;
				    case "jul":
				    	monthNumberOd = "07";
				        break;
				    case "avgust":
				    	monthNumberOd = "08";
				        break;
				    case "septembar":
				    	monthNumberOd = "09";
				        break;
				    case "oktobar":
				    	monthNumberOd = "10";
				        break;
				    case "novembar":
				    	monthNumberOd = "11";
				        break;
				    case "decembar":
				    	monthNumberOd = "12";
				        break;
				    default:
				    	monthNumberOd = "-1"; // Invalid month name
				        break;
				}
				    String opcijaCB = comboBox.getSelectedItem().toString();
				    LocalDateTime datumVremeDo = null;
				    if ( danCBDo != null && mesecCBDo != null && godinaCbDo != null) {
				       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
				       String dateTimeString = godinaCbDo + "-" + monthNumberDo + "-" + danCBDo+"T00:00";
				       datumVremeDo = LocalDateTime.parse(dateTimeString, formatter);
				    }
				    LocalDateTime datumVremeOd = null;
				    if ( danCBOd != null && mesecCBOd != null && godinaCbOd != null) {
					       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
					       String dateTimeString = godinaCbOd + "-" + monthNumberOd + "-" + danCBOd+"T00:00";
					       datumVremeOd = LocalDateTime.parse(dateTimeString, formatter);
					    }
				   
				    tableMaker tabela=new tableMaker(prozorIzvestaji,datumVremeDo,datumVremeOd,Opcije.valueOf(opcijaCB),kontejner,novcanikSalona,360);
				    prozorIzvestaji.getContentPane().revalidate();
				    prozorIzvestaji.getContentPane().repaint();
			});
		});
		DefaultButton izvestaji3=new DefaultButton("Zakazani tretmani za uslugui");
		izvestaji3.addActionListener(e->{
			prozorIzvestaji.isprazniProzor("Izvestaji", "IZVESTAJI");
			String[] dan= {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
			JComboBox comboBoxDanOd = new JComboBox(dan);
			comboBoxDanOd.setBounds(299, 211, 87, 22);
			prozorIzvestaji.getContentPane().add(comboBoxDanOd);
			
			String[] meseci= {"januar","februar","mart","april","maj","jun","jul","avgust","septembar","oktobar","novembar","decembar"};
			JComboBox comboBoxMesecOd = new JComboBox(meseci);
			comboBoxMesecOd.setBounds(434, 211, 87, 22);
			prozorIzvestaji.getContentPane().add(comboBoxMesecOd);
			
			String[] godine= {"2023","2024"};
			JComboBox comboBoxGodinaOd= new JComboBox(godine);
			comboBoxGodinaOd.setBounds(557, 211, 87, 22);
			prozorIzvestaji.getContentPane().add(comboBoxGodinaOd);
			
			JComboBox comboBoxDanDo = new JComboBox(dan);
			comboBoxDanDo.setBounds(299, 258, 87, 22);
			prozorIzvestaji.getContentPane().add(comboBoxDanDo);
			
			JComboBox comboBoxMesecDo = new JComboBox(meseci);
			comboBoxMesecDo.setBounds(434, 258, 87, 22);
			prozorIzvestaji.getContentPane().add(comboBoxMesecDo);
			
			JComboBox comboBoxGodinaDo= new JComboBox(godine);
			comboBoxGodinaDo.setBounds(557, 258, 87, 22);
			prozorIzvestaji.getContentPane().add(comboBoxGodinaDo);
			
			ArrayList<String> tretmani = new ArrayList<>();

		    for (Tretman i : kontejner.tretmani) {
		            tretmani.add(i.getNaziv());
		    }
		    String[] opcijeZaCB = tretmani.toArray(new String[0]);
			JComboBox comboBox = new JComboBox(opcijeZaCB);
			comboBox.setBounds(299, 167, 345, 22);
			prozorIzvestaji.getContentPane().add(comboBox);
			
			
			JLabel opcijarLabel = new JLabel("Tretman:");
			opcijarLabel.setBounds(40, 167, 209, 22);
			prozorIzvestaji.getContentPane().add(opcijarLabel);
			
			JLabel vremeOdLabel = new JLabel("Vreme od:");
			vremeOdLabel.setBounds(40, 215, 209, 22);
			prozorIzvestaji.getContentPane().add(vremeOdLabel);
			
			JLabel vremeDolabel = new JLabel("Vreme do:");
			vremeDolabel.setBounds(40, 262, 209, 22);
			prozorIzvestaji.getContentPane().add(vremeDolabel);
			
			DefaultButton prikaziDugme = new DefaultButton("Prikazi");
			prikaziDugme.setBounds(40, 316, 604, 23);
			prozorIzvestaji.getContentPane().add(prikaziDugme);
			prikaziDugme.addActionListener(ej->{
				 String danCBDo = comboBoxDanDo.getSelectedItem().toString();
				    String mesecCBDo =comboBoxMesecDo.getSelectedItem().toString();
				    String godinaCbDo =comboBoxGodinaDo.getSelectedItem().toString();
				    String danCBOd = comboBoxDanOd.getSelectedItem().toString();
				    String mesecCBOd =comboBoxMesecOd.getSelectedItem().toString();
				    String godinaCbOd =comboBoxGodinaOd.getSelectedItem().toString();

					String monthNumberDo;
					String monthNumberOd;

					
					switch (mesecCBDo) {
					    case "januar":
					        monthNumberDo ="01";
					        break;
					    case "februar":
					    	monthNumberDo = "02";
					        break;
					    case "mart":
					    	monthNumberDo ="03";
					        break;
					    case "april":
					    	monthNumberDo = "04";
					        break;
					    case "maj":
					    	monthNumberDo = "05";
					        break;
					    case "jun":
					    	monthNumberDo ="06";
					        break;
					    case "jul":
					    	monthNumberDo = "07";
					        break;
					    case "avgust":
					    	monthNumberDo = "08";
					        break;
					    case "septembar":
					    	monthNumberDo = "09";
					        break;
					    case "oktobar":
					    	monthNumberDo = "10";
					        break;
					    case "novembar":
					    	monthNumberDo = "11";
					        break;
					    case "decembar":
					    	monthNumberDo = "12";
					        break;
					    default:
					    	monthNumberDo = "-1"; // Invalid month name
					        break;
					}
					switch (mesecCBOd) {
				    case "januar":
				    	monthNumberOd ="01";
				        break;
				    case "februar":
				    	monthNumberOd = "02";
				        break;
				    case "mart":
				    	monthNumberOd ="03";
				        break;
				    case "april":
				    	monthNumberOd = "04";
				        break;
				    case "maj":
				    	monthNumberOd = "05";
				        break;
				    case "jun":
				    	monthNumberOd ="06";
				        break;
				    case "jul":
				    	monthNumberOd = "07";
				        break;
				    case "avgust":
				    	monthNumberOd = "08";
				        break;
				    case "septembar":
				    	monthNumberOd = "09";
				        break;
				    case "oktobar":
				    	monthNumberOd = "10";
				        break;
				    case "novembar":
				    	monthNumberOd = "11";
				        break;
				    case "decembar":
				    	monthNumberOd = "12";
				        break;
				    default:
				    	monthNumberOd = "-1"; // Invalid month name
				        break;
				}
				    String tretmanCB = comboBox.getSelectedItem().toString();
				    Tretman tretman= new Tretman();
				    for (Tretman i: kontejner.tretmani) {
				    	if (i.getNaziv().equals(tretmanCB)) {
				    		tretman=i;
				    		break;
				    	}
				    }
				    LocalDateTime datumVremeDo = null;
				    if ( danCBDo != null && mesecCBDo != null && godinaCbDo != null) {
				       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
				       String dateTimeString = godinaCbDo + "-" + monthNumberDo + "-" + danCBDo+"T00:00";
				       datumVremeDo = LocalDateTime.parse(dateTimeString, formatter);
				    }
				    LocalDateTime datumVremeOd = null;
				    if ( danCBOd != null && mesecCBOd != null && godinaCbOd != null) {
					       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
					       String dateTimeString = godinaCbOd + "-" + monthNumberOd + "-" + danCBOd+"T00:00";
					       datumVremeOd = LocalDateTime.parse(dateTimeString, formatter);
					    }
				   
				    tableMaker tabela=new tableMaker(prozorIzvestaji,datumVremeDo,datumVremeOd,tretman,kontejner,novcanikSalona,360);
				    prozorIzvestaji.getContentPane().revalidate();
				    prozorIzvestaji.getContentPane().repaint();
			});
		});
		DefaultButton izvestaji4=new DefaultButton("Klijenti koji imaju karticu lojalnosti");
		izvestaji4.addActionListener(e->{
			prozorIzvestaji.isprazniProzor("Izvestaji", "IZVESTAJI");
			tableMaker tabela=new tableMaker(180,prozorIzvestaji,kontejner);
		});
		prozorIzvestaji.panelZaKlijenta.add(izvestaji1);
		prozorIzvestaji.panelZaKlijenta.add(izvestaji2);
		prozorIzvestaji.panelZaKlijenta.add(izvestaji3);
		prozorIzvestaji.panelZaKlijenta.add(izvestaji4);
		prozorIzvestaji.add(prozorIzvestaji.panelZaKlijenta);
	
	}

	public static void zakaziTretman(Prozor zakaziKozmetickiTretman,Klijent klijent, Kontejneri kontejner,int a, Opcije opcija) {
		zakaziKozmetickiTretman.setVisible(true);
		System.out.println("Tu smo");
	    zakaziKozmetickiTretman.popuniZKT(zakaziKozmetickiTretman,a);

		
		String[] sat= {"00","01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};
		JComboBox comboBoxVreme = new JComboBox(sat);
		comboBoxVreme.setBounds(322, 73+a, 133, 22);
		zakaziKozmetickiTretman.getContentPane().add(comboBoxVreme);
		
		
		String[] minut= {"00","01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"};
		JComboBox comboBoxVreme_2 = new JComboBox(minut);
		comboBoxVreme_2.setBounds(480, 73+a, 133, 22);
		zakaziKozmetickiTretman.getContentPane().add(comboBoxVreme_2);
		zakaziKozmetickiTretman.setVisible(true);
		
		ArrayList<String> Tiptretmana= new ArrayList<String>();
		for(TipTretmana i : kontejner.tipoviTretmana) {
			Tiptretmana.add(i.getNaziv());
		}

		String[] tipoviTretmanaZaCB=new String[Tiptretmana.size()];
        for (int i = 0; i < Tiptretmana.size(); i++) {
        	tipoviTretmanaZaCB[i] = Tiptretmana.get(i);
        }

		
		JComboBox comboBoxTipTretmana = new JComboBox(tipoviTretmanaZaCB);
		comboBoxTipTretmana.setBounds(295, 165+a, 345, 22);
		zakaziKozmetickiTretman.getContentPane().add(comboBoxTipTretmana);
		
		JComboBox<String>[] comboBoxTretman = new JComboBox[]{new JComboBox<>()};
		JComboBox<String>[] comboBoxKozmeticari = new JComboBox[]{new JComboBox<>()};

		comboBoxTipTretmana.addActionListener(e -> {
		    String value = comboBoxTipTretmana.getSelectedItem().toString();
		    ArrayList<String> tretmani = new ArrayList<>();

		    for (Tretman i : kontejner.tretmani) {
		        if (i.getTip().getNaziv().equals(value)) {
		            tretmani.add(i.getNaziv());
		        }
		    }
		    
		    ArrayList<String> kozmeticari = new ArrayList<String>();
		    
		    for (Kozmeticar i : kontejner.kozmeticari) {
		        for (TipTretmana m : i.getKozmetickiTretmani()) {
		            if (m.getNaziv().equals(value)) {
		                kozmeticari.add(i.getIme());
		            }
		        }
		    }
		    kozmeticari.add("izaberi slobodnog kozmeticara");
		    String[] kozmeticariZaCB = kozmeticari.toArray(new String[0]);
		    String[] tretmaniZaCB = tretmani.toArray(new String[0]);

		    zakaziKozmetickiTretman.getContentPane().remove(comboBoxTretman[0]);
		    zakaziKozmetickiTretman.getContentPane().remove(comboBoxKozmeticari[0]);

		    comboBoxTretman[0] = new JComboBox<>(tretmaniZaCB);
		    comboBoxTretman[0].setBounds(295, 252+a, 345, 22);
		    zakaziKozmetickiTretman.getContentPane().add(comboBoxTretman[0]);
		    
		    comboBoxKozmeticari[0] = new JComboBox<>(kozmeticariZaCB);
		    comboBoxKozmeticari[0].setBounds(295, 209+a, 345, 22);
		    zakaziKozmetickiTretman.getContentPane().add(comboBoxKozmeticari[0]);

		    zakaziKozmetickiTretman.getContentPane().revalidate();
		    zakaziKozmetickiTretman.getContentPane().repaint();
		});

		
		
		String[] dan= {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
		JComboBox comboBoxDatum = new JComboBox(dan);
		comboBoxDatum.setBounds(295, 120+a, 87, 22);
		zakaziKozmetickiTretman.getContentPane().add(comboBoxDatum);
		
		String[] meseci= {"januar","februar","mart","april","maj","jun","jul","avgust","septembar","oktobar","novembar","decembar"};
		JComboBox comboBoxDatum_1 = new JComboBox(meseci);
		comboBoxDatum_1.setBounds(430, 120+a, 87, 22);
		zakaziKozmetickiTretman.getContentPane().add(comboBoxDatum_1);
		
		String[] godine= {"2023","2024"};
		JComboBox comboBoxDatum_2 = new JComboBox(godine);
		comboBoxDatum_2.setBounds(553, 120+a, 87, 22);
		zakaziKozmetickiTretman.getContentPane().add(comboBoxDatum_2);
		
		
		DefaultButton sacuvajDugme = new DefaultButton("Sacuvaj");
		sacuvajDugme.setBounds(197, 360+a, 284, 23);
		zakaziKozmetickiTretman.getContentPane().add(sacuvajDugme);
		zakaziKozmetickiTretman.setVisible(true);
		sacuvajDugme.addActionListener(e->{
		    String satCB = comboBoxVreme.getSelectedItem().toString();
		    String minutCB = comboBoxVreme_2.getSelectedItem().toString();
		    String danCB = comboBoxDatum.getSelectedItem().toString();
		    String mesecCB =comboBoxDatum_1.getSelectedItem().toString();
		    String godinaCb =comboBoxDatum_2.getSelectedItem().toString();

			String monthNumber;
			
			switch (mesecCB) {
			    case "januar":
			        monthNumber ="01";
			        break;
			    case "februar":
			        monthNumber = "02";
			        break;
			    case "mart":
			        monthNumber ="03";
			        break;
			    case "april":
			        monthNumber = "04";
			        break;
			    case "maj":
			        monthNumber = "05";
			        break;
			    case "jun":
			        monthNumber ="06";
			        break;
			    case "jul":
			        monthNumber = "07";
			        break;
			    case "avgust":
			        monthNumber = "08";
			        break;
			    case "septembar":
			        monthNumber = "09";
			        break;
			    case "oktobar":
			        monthNumber = "10";
			        break;
			    case "novembar":
			        monthNumber = "11";
			        break;
			    case "decembar":
			        monthNumber = "12";
			        break;
			    default:
			        monthNumber = "-1"; // Invalid month name
			        break;
			}

		    String kozmeticarCB = comboBoxKozmeticari[0].getSelectedItem().toString();
		    String tretmanCB = comboBoxTretman[0].getSelectedItem().toString();
		    Tretman tretman=new Tretman();
		    for(Tretman i: kontejner.tretmani) {
		    	if(i.getNaziv().equals(tretmanCB)) {
		    		tretman=i;
		    	}
		    }
		 
			
			LocalDateTime datumVreme = null;
		    if (satCB != null && minutCB != null && danCB != null && mesecCB != null && godinaCb != null) {
		       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		       String dateTimeString = godinaCb + "-" + monthNumber + "-" + danCB + "T" + satCB + ":" + minutCB;
		       datumVreme = LocalDateTime.parse(dateTimeString, formatter);
		    }
		    Kozmeticar kozmeticar= new Kozmeticar();
		    for (Kozmeticar i: kontejner.kozmeticari) {
		    	if (i.getIme().equals(kozmeticarCB)) {
		    		kozmeticar=i;
		    		break;
		    	}
		    }
		    if (!kozmeticar.getIme().equals(kozmeticarCB)) {
		    	ArrayList<Kozmeticar> kozmeticariKopija=new ArrayList<Kozmeticar>();
				kozmeticariKopija.addAll(kontejner.kozmeticari);
				Kozmeticar kozmeticarRandom= kontejner.giveKozmeticarWithObuka(tretman,datumVreme,kozmeticariKopija);
				kozmeticar=kozmeticarRandom;
		    }
			ZakazanTretman zakazanNovi= new ZakazanTretman(opcija,  datumVreme,  kozmeticar,  tretman,  klijent,tretman.getCena());
			int result =zakazanNovi.provera(kontejner.zakazaniTretmani);
			
			JLabel porukaLabel = new JLabel();
	        porukaLabel.setBounds(197, 313 + a, 284, 50);
	        
	        switch (result) {
	            case -1:
	                porukaLabel.setText(" Vec ste zakazali u ovo vreme");
	                break;
	            case -2:
	                porukaLabel.setText(" Zauzet klijent");
	                break;
	            case -3:
	                porukaLabel.setText(" Zuzet kozmeticar");
	                break;
	            case -4:
	                porukaLabel.setText(" Necete zavrsiti prethodni tretman ili stici na buduci");
	                break;
	            case -5:
	                porukaLabel.setText(" Kozmeticar nece stici da zavrsi tretman");
	                break;
	            case 1:
	                porukaLabel.setText(" Uspesno sacuvano ");
	                break;
	            default:
	                porukaLabel.setText(" Unknown result");
	        }
	        porukaLabel.revalidate();
	        zakaziKozmetickiTretman.getContentPane().add(porukaLabel);
	        zakaziKozmetickiTretman.revalidate();
	        zakaziKozmetickiTretman.repaint();

	        zakazanNovi.sacuvajZakazanTretman(kontejner.zakazaniTretmani);
	        kontejner.prikaziSveZakazaneTretmane();
		});
		
		
	}
	public static void zakaziTretman(Prozor zakaziKozmetickiTretman,Recepcionar recepcionar,Kontejneri kontejner) {
		zakaziKozmetickiTretman.setVisible(true);
		ArrayList<String> klijenti=new ArrayList<String>();
		for (Klijent i : kontejner.klijenti) {
			klijenti.add(i.getIme());
		}
		String[] klijentiZaCB=new String[klijenti.size()];
        for (int i = 0; i < klijenti.size(); i++) {
        	klijentiZaCB[i] = klijenti.get(i);
        }

		JLabel klijentiLabel = new JLabel("KLIJENT:");
		klijentiLabel.setBounds(22, 73, 263, 22);
		zakaziKozmetickiTretman.getContentPane().add(klijentiLabel);
		
		JComboBox comboBoxklijenti= new JComboBox(klijentiZaCB);
		comboBoxklijenti.setBounds(295, 73, 345, 22);
		zakaziKozmetickiTretman.getContentPane().add(comboBoxklijenti);
		
		comboBoxklijenti.addActionListener(e -> {
		    String ime = comboBoxklijenti.getSelectedItem().toString();
		    Klijent klijent=new Klijent();
		    for (Klijent i : kontejner.klijenti) {
		    	if(i.getIme().equals(ime)) {
		    		klijent=i;
		    		break;
		    	}
		    }
		    zakaziTretman( zakaziKozmetickiTretman,klijent, kontejner,50,Opcije.ZAKAZAN);
		    zakaziKozmetickiTretman.getContentPane().revalidate();
		    zakaziKozmetickiTretman.getContentPane().repaint();
		});
	}

	public static void registracijaZaposlenih(Menadzer trenutni,Prozor registracijaKorisnika, Kontejneri kontejner, Prozor prozorZaposlenih) {
		AtomicInteger a=new AtomicInteger(0);
		DefaultPanel myPanel0 = new DefaultPanel("Izaberite zaposlenog:", 80);
        String[] zaposleni = {"menadzer", "recepcionar", "kozmeticar"};

        JComboBox<String> cb1 = new JComboBox<>(zaposleni);
        
        myPanel0.add(cb1);
        registracijaKorisnika.getContentPane().add(myPanel0);

        final DefaultPanel[] checkBoxPanel = {new DefaultPanel("", 0)};
        cb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedValue = (String) cb1.getSelectedItem();
                if (selectedValue.equals("kozmeticar")) {
                    checkBoxPanel[0] = new DefaultPanel("Izaberite tretmane: ", 570);
                    for (TipTretmana i : kontejner.tipoviTretmana) {
                        JCheckBox checkBox = new JCheckBox(i.getNaziv());
                        checkBoxPanel[0].add(checkBox);
                    }
                    registracijaKorisnika.getContentPane().add(checkBoxPanel[0]);
                }
                a.addAndGet(40);
                registracijaKorisnika.getContentPane().revalidate();
                registracijaKorisnika.getContentPane().repaint();
            }
        });
	    
		JTextField Field1 = new JTextField(20);
	    DefaultPanel myPanel1 = new DefaultPanel(120, "Unesite ime:", Field1);
	    registracijaKorisnika.add(myPanel1);

	    JTextField Field2 = new JTextField(20);
	    DefaultPanel myPanel2 = new DefaultPanel(160, "Unesite prezime:", Field2);
	    registracijaKorisnika.add(myPanel2);

	    DefaultPanel myPanel3 = new DefaultPanel("Unesite pol:", 210);
	    String[] pol = {"muski", "zenski"};

	    final JComboBox<String> cb = new JComboBox<String>(pol);
	    String Field3 = (String) cb.getSelectedItem();
	    cb.setVisible(true);
	    myPanel3.add(cb);
	    registracijaKorisnika.add(myPanel3);

	    JTextField Field4 = new JTextField(20);
	    DefaultPanel myPanel4 = new DefaultPanel(250, "Unesite telefon:", Field4);
	    registracijaKorisnika.add(myPanel4);

	    JTextField Field5 = new JTextField(20);
	    DefaultPanel myPanel5 = new DefaultPanel(290, "Unesite adresu:", Field5);
	    registracijaKorisnika.add(myPanel5);

	    JTextField Field6 = new JTextField(20);
	    DefaultPanel myPanel6 = new DefaultPanel(330, "Unesite korisnicko ime:", Field6);
	    registracijaKorisnika.add(myPanel6);

	    JTextField Field7 = new JTextField(20);
	    DefaultPanel myPanel7 = new DefaultPanel(370, "Unesite lozinku:", Field7);
	    registracijaKorisnika.add(myPanel7);

	    JTextField Field8 = new JTextField(20);
	    DefaultPanel myPanel8 = new DefaultPanel(410, "Unesite strucnu spremu:", Field8);
	    registracijaKorisnika.add(myPanel8);

	    JTextField Field9 = new JTextField(20);
	    DefaultPanel myPanel9 = new DefaultPanel(450, "Unesite staz:", Field9);
	    registracijaKorisnika.add(myPanel9);

	    JTextField Field10 = new JTextField(20);
	    DefaultPanel myPanel10 = new DefaultPanel(490, "Unesite bonus:", Field10);
	    registracijaKorisnika.add(myPanel10);

	    JTextField Field11 = new JTextField(20);
	    DefaultPanel myPanel11 = new DefaultPanel(530, "Unesite platu:", Field11);
	    registracijaKorisnika.add(myPanel11);

	    DefaultPanel submitPanel = new DefaultPanel(610+a.get());
	    DefaultButton submitRegistracija = new DefaultButton("Sacuvaj");
	    submitRegistracija.addActionListener(e -> {
	 
	    	String Field0=cb1.getSelectedItem().toString();
	    	String[] proveraPraznih= {Field1.getText(), Field2.getText(), Field3, Field4.getText(), Field5.getText(), Field6.getText(), Field7.getText(), Field8.getText(), Field9.getText(), Field10.getText(),Field11.getText()};
	    	boolean prazan=false;
	    	for (String i : proveraPraznih) {
	    		if(i.equals("")) {
	    			prazan=true;
	    			break;
	    		}
	    	}
	    	if(!prazan) {
	    	if (Field0.equals("menadzer")) {
	    	    Menadzer menadzerNovi = new Menadzer(Field1.getText(), Field2.getText(), Field3, Field4.getText(), Field5.getText(), Field6.getText(), Field7.getText(), Field8.getText(), Field9.getText(), Integer.parseInt(Field10.getText()), Double.parseDouble(Field11.getText()));
	    	    menadzerNovi.sacuvajMenadzera(kontejner.menadzeri);
	    	}
	    	else if (Field0.equals("kozmeticar")) {
	    	    System.out.println("kozmeticar");
	    	    Kozmeticar kozmeticarNovi = new Kozmeticar(trenutni, Field1.getText(), Field2.getText(), Field3, Field4.getText(), Field5.getText(), Field6.getText(), Field7.getText(), Field8.getText(), Field9.getText(), Integer.parseInt(Field10.getText()), Double.parseDouble(Field11.getText()), izvuciIzabraneTretmane(checkBoxPanel[0], kontejner));
	    	    kozmeticarNovi.sacuvajKozemticara(trenutni, kontejner.kozmeticari);
	    	    kozmeticarNovi.napraviString();
	    	}
	    	else if (Field0.equals("recepcionar")) {
	    	    Recepcionar recepcionarNovi = new Recepcionar(trenutni, Field1.getText(), Field2.getText(), Field3, Field4.getText(), Field5.getText(), Field6.getText(), Field7.getText(), Field8.getText(), Field9.getText(), Integer.parseInt(Field10.getText()), Double.parseDouble(Field11.getText()));
	    	    recepcionarNovi.sacuvajRecepcionara(trenutni, kontejner.recepcionari);
	    	}}
	    });
	    submitPanel.add(submitRegistracija);
	    registracijaKorisnika.add(submitPanel);
	}
	private static ArrayList<TipTretmana> izvuciIzabraneTretmane(DefaultPanel panel,Kontejneri kontejner) {
        ArrayList<String> selectedFields = new ArrayList<String>();
        Component[] components = panel.getComponents();
        for (Component component : components) {
            if (component instanceof JCheckBox) {
                JCheckBox checkBox = (JCheckBox) component;
                if (checkBox.isSelected()) {
                    selectedFields.add(checkBox.getText());
                }
            }
        }
        ArrayList<TipTretmana> uTipovima=new ArrayList<TipTretmana>();
        for(String i: selectedFields) {
        	for(TipTretmana m: kontejner.tipoviTretmana) {
        		if(m.getNaziv().equals(i)) {
        			uTipovima.add(m);
        		}
        	}
        }
        return uTipovima;
    }
}
