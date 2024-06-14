package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import klase.KarticaLojalnosti;
import klase.Klijent;
import klase.Kontejneri;
import klase.Kozmeticar;
import klase.Menadzer;
import klase.NovcanikSalona;
import klase.Recepcionar;
import klase.SvakiZaposleni;
import tretmani.Opcije;
import tretmani.TipTretmana;
import tretmani.Tretman;
import tretmani.ZakazanTretman;

public class tableMaker {
	private JTable table ;
	ArrayList<ZakazanTretman> zakazaniTretmani;
	public tableMaker(Kontejneri kontejner, Prozor prozor, ArrayList<ZakazanTretman> zakazaniTretmani, int spusti) {
		 table = new JTable();
	    table.setDefaultEditor(Object.class, null);
		this.zakazaniTretmani=zakazaniTretmani;


        Object[] columns = {"Opcija", "Datum i vreme", "Kozmetičar", "Usluga", "Klijent", "Cena"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        table.setRowHeight(30);

        JScrollPane pane = new JScrollPane(table);
        pane.setBackground(new Color(223, 250, 220));
        pane.setBounds(10, spusti, 688, 117);
        prozor.getContentPane().add(pane);

        for (ZakazanTretman tretman : zakazaniTretmani) {
            Object[] row = {
                    tretman.getOpcijeTretmana(),
                    tretman.getDatum_i_vreme(),
                    tretman.getKozmeticar().getIme(),
                    tretman.getUsluga().getNaziv(),
                    tretman.getKlijent().getIme(),
                    tretman.getCenaUVremeZakazivanja(),
                   
            };

            model.addRow(row);
        }

    }
	public tableMaker(Kontejneri kontejner, Prozor prozor,Kozmeticar kozmeticar,	ArrayList<ZakazanTretman>zakazaniTretmani,int spusti) {
		table = new JTable();
		table.setDefaultEditor(Object.class, null);
		this.zakazaniTretmani=zakazaniTretmani;
		 Object[] columns= {"Opcija", "Datum i vreme","Kozmeticar","usluga","klijent","cena"};
		 DefaultTableModel model= new  DefaultTableModel();
		 
		 model.setColumnIdentifiers(columns);
		 table.setModel(model);
		 table.setAutoCreateColumnsFromModel(true);
		 table.setRowHeight(30);
		 
		 JScrollPane pane= new JScrollPane(table);
		 pane.setBackground(new Color(223, 250, 220));

		 pane.setBounds(10,spusti, 688, 117);
		 prozor.getContentPane().add(pane);
		
		Object[] row =new Object[6];
		 for(ZakazanTretman i :zakazaniTretmani) {
			 row[0]=i.getOpcijeTretmana();
			 row[1]=i.getDatum_i_vreme();
			 row[2]=i.getKozmeticar().getIme();
			 row[3]=i.getUsluga().getNaziv();
			 row[4]=i.getKlijent().getIme();
			 row[5]=i.getCenaUVremeZakazivanja();
			
			 model.addRow(row);
		 } 
		 
	}
	public tableMaker(Klijent trenutni, int spusti, Prozor prozor) {
		     table = new JTable();
			 Object[] columns= {"Ime", "Prezime","Pol","Telefon","Adresa","Korisniko ime","Lozinka"};
			 DefaultTableModel model= new  DefaultTableModel();
			 model.setColumnIdentifiers(columns);
			 table.setModel(model);
			 table.setAutoCreateColumnsFromModel(true);
			 table.setRowHeight(30);
			 JScrollPane pane = new JScrollPane(table);
			    pane.setBounds(10, spusti, 688, 50);
			    pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
			    pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			    pane.getViewport().setPreferredSize(table.getPreferredSize());
			 prozor.getContentPane().add(pane);
			Object[] row =new Object[7];
				 row[0]=trenutni.getIme();
				 row[1]=trenutni.getPrezime();
				 row[2]=trenutni.getPol();
				 row[3]=trenutni.getTelefon();
				 row[4]=trenutni.getAdresa();
				 row[5]=trenutni.getKorisnickoIme();
				 row[6]=trenutni.getLozinka();
				 model.addRow(row);
			 
	}
	public tableMaker(Prozor prozor, Kontejneri kontejner, SvakiZaposleni trenutni, ArrayList<ZakazanTretman> zakazaniTretmani2, int spusti) {
	    table = new JTable();
	    Object[] columns = {"Ime", "Prezime", "Pol", "Telefon", "Adresa", "Korisniko ime", "Lozinka", "Staz", "Strucna Sprema", "Bonus", "Plata"};
	    DefaultTableModel model = new DefaultTableModel();
	    model.setColumnIdentifiers(columns);
	    table.setModel(model);
	    table.setAutoCreateColumnsFromModel(true);
	    table.setRowHeight(30);

	    JScrollPane pane = new JScrollPane(table);
	    pane.setBounds(10, spusti, 688, 50);
	    pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
	    pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    pane.getViewport().setPreferredSize(table.getPreferredSize());

	    prozor.getContentPane().add(pane);

	    Object[] row = new Object[11];
	    row[0] = trenutni.getIme();
	    row[1] = trenutni.getPrezime();
	    row[2] = trenutni.getPol();
	    row[3] = trenutni.getTelefon();
	    row[4] = trenutni.getAdresa();
	    row[5] = trenutni.getKorisnickoIme();
	    row[6] = trenutni.getLozinka();
	    row[7] = trenutni.getStaz();
	    row[8] = trenutni.getStrucnaSprema();
	    row[9] = trenutni.getBonus();
	    row[10] = trenutni.getKonacnaPlata();
	    model.addRow(row);
	}
	public tableMaker(Prozor prozor, Kontejneri kontejner, Menadzer trenutni, int spusti) {
	    table = new JTable();
	    Object[] columns = {"Napravio","Iznos", "Popust"};
	    DefaultTableModel model = new DefaultTableModel();
	    model.setColumnIdentifiers(columns);
	    table.setModel(model);
	    table.setAutoCreateColumnsFromModel(true);
	    table.setRowHeight(30);

	    JScrollPane pane = new JScrollPane(table);
	    pane.setBounds(10, spusti, 688, 70);
	    
	    prozor.getContentPane().add(pane);
	    
	    for(KarticaLojalnosti trenutna: kontejner.karticeLojalnosti) {
	    Object[] row = new Object[3];
	    row[0]=trenutna.getMenadzerPostavljaUslov().getIme();
	    row[1] = Double.toString(trenutna.getNajmanjePotroseno());
	    row[2] = Double.toString(trenutna.getPopust()*100)+"%";
	    model.addRow(row);
	
}}
	public tableMaker(Prozor prozor, Menadzer trenutni, Kontejneri kontejner, int spusti) {
	    table = new JTable();
	    Object[] columns = {"Tip","Tretman", "Cena"};
	    DefaultTableModel model = new DefaultTableModel();
	    model.setColumnIdentifiers(columns);
	    table.setModel(model);
	    table.setAutoCreateColumnsFromModel(true);
	    table.setRowHeight(30);

	    JScrollPane pane = new JScrollPane(table);
	    pane.setBounds(10, spusti, 688, 170);
	    
	    prozor.getContentPane().add(pane);
	    
	    for(Tretman trenutna: kontejner.tretmani) {
	    Object[] row = new Object[3];
	    row[0]=trenutna.getTip().getNaziv();
	    row[1] = trenutna.getNaziv();
	    row[2] = Double.toString(trenutna.getCena());
	    model.addRow(row);
	
}}
	public tableMaker(Prozor prozor, Kontejneri kontejner, int spusti) {
	    table = new JTable();
	    Object[] columns = {"Korisnik","Ime", "Prezime", "Pol", "Telefon", "Adresa", "Korisniko ime", "Lozinka", "Staz", "Strucna Sprema", "Bonus", "Plata"};
	    DefaultTableModel model = new DefaultTableModel();
	    model.setColumnIdentifiers(columns);
	    table.setModel(model);
	    table.setAutoCreateColumnsFromModel(true);
	    table.setRowHeight(30);

	    JScrollPane pane = new JScrollPane(table);
	    pane.setBounds(10, spusti, 688, 180);
	    
	    prozor.getContentPane().add(pane);
	    
	    for(Kozmeticar trenutni: kontejner.kozmeticari) {
	    Object[] row = new Object[12];
	    row[0]="kozmeticar";
	    row[1] = trenutni.getIme();
	    row[2] = trenutni.getPrezime();
	    row[3] = trenutni.getPol();
	    row[4] = trenutni.getTelefon();
	    row[5] = trenutni.getAdresa();
	    row[6] = trenutni.getKorisnickoIme();
	    row[7] = trenutni.getLozinka();
	    row[8] = trenutni.getStaz();
	    row[9] = trenutni.getStrucnaSprema();
	    row[10] = trenutni.getBonus();
	    row[11] = trenutni.getKonacnaPlata();
	    model.addRow(row);
	}
	for(Recepcionar trenutni: kontejner.recepcionari) {
	    Object[] row = new Object[12];
	    row[0]="recepcionar";
	    row[1] = trenutni.getIme();
	    row[2] = trenutni.getPrezime();
	    row[3] = trenutni.getPol();
	    row[4] = trenutni.getTelefon();
	    row[5] = trenutni.getAdresa();
	    row[6] = trenutni.getKorisnickoIme();
	    row[7] = trenutni.getLozinka();
	    row[8] = trenutni.getStaz();
	    row[9] = trenutni.getStrucnaSprema();
	    row[10] = trenutni.getBonus();
	    row[11] = trenutni.getKonacnaPlata();
	    model.addRow(row);
	}
for(Menadzer trenutni: kontejner.menadzeri) {
    Object[] row = new Object[12];
    row[0]="menadzer";
    row[1] = trenutni.getIme();
    row[2] = trenutni.getPrezime();
    row[3] = trenutni.getPol();
    row[4] = trenutni.getTelefon();
    row[5] = trenutni.getAdresa();
    row[6] = trenutni.getKorisnickoIme();
    row[7] = trenutni.getLozinka();
    row[8] = trenutni.getStaz();
    row[9] = trenutni.getStrucnaSprema();
    row[10] = trenutni.getBonus();
    row[11] = trenutni.getKonacnaPlata();
    model.addRow(row);
}}
	public boolean isCellEditable(int row, int column) {                
        return false;               
}
	public void otkaziTretman(Kontejneri kontejner,NovcanikSalona novcanik,String korisnik) {
		int row = this.table.getSelectedRow();
		ZakazanTretman selectedTretman = this.zakazaniTretmani.get(row);
		for (ZakazanTretman i : kontejner.zakazaniTretmani) {
		    if (i.napraviString().equals(selectedTretman.napraviString())) {
		    	if(korisnik=="klijent") {
		    		i.tretmanJeOtkazaoKljient(kontejner.zakazaniTretmani, novcanik);
		    	}
		    	if(korisnik=="kozmeticar otkazi") {
		    		i.tretmanJeOtkazaoSalon(zakazaniTretmani, novcanik);
		    	}
		    	if(korisnik=="kozmeticar zavrsi") {
		    		i.tretmanJeIzvrsen(zakazaniTretmani, novcanik);
		    	}
		    	if(korisnik=="izmena") {
		    		izmena(i,kontejner);
		    	}
		        break;
		    }
		}
	}
	public tableMaker(NovcanikSalona novcanik,Prozor prozor, int spusti) {
		 table = new JTable();
		    Object[] columns = {"Prihodi", "Rashodi"};
		    DefaultTableModel model = new DefaultTableModel();
		    model.setColumnIdentifiers(columns);
		    table.setModel(model);
		    table.setAutoCreateColumnsFromModel(true);
		    table.setRowHeight(30);

		    JScrollPane pane = new JScrollPane(table);
		    pane.setBounds(10, spusti, 688, 50);
		    
		    prozor.getContentPane().add(pane);
		    
		    
		    Object[] row = new Object[2];
		    row[0]=novcanik.getPrihodi();
		    row[1] =novcanik.getRashodi();
		   
		    model.addRow(row);
		
	}
	private void izmena(ZakazanTretman tretman,Kontejneri kontejner) {
		Prozor prozorIzmena= new Prozor("Izmena","Izmena");

		String[] opcije= {"ZAKAZAN",	"IZVRSEN","OTKAZAO_KLIJENT","OTLAZAO_SALON","NIJE_SE_POJAVIO","NEDEFINISAN","ONLINE_ZAKAZIVANJE"};
		JComboBox comboBoxOpcije = new JComboBox(opcije);
		comboBoxOpcije.setSelectedItem(tretman.getOpcijeTretmana().toString()); 
		comboBoxOpcije.setBounds(272, 77, 239, 22);
		prozorIzmena.getContentPane().add(comboBoxOpcije);
		
		String dateString = tretman.getDatum_i_vreme().toString();
        List<String> datumVreme = Arrays.asList(dateString.split("[-T:]"));
        String[] datumVremeLista = datumVreme.toArray(new String[0]);

        String[] sat = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};
        JComboBox<String> comboBoxSat = new JComboBox<>(sat);
        comboBoxSat.setSelectedItem(datumVremeLista[3]);
        comboBoxSat.setBounds(272, 117, 99, 22);
        prozorIzmena.getContentPane().add(comboBoxSat);
		
        String[] minut = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"};
        JComboBox<String> comboBoxMinut = new JComboBox<>(minut);
        comboBoxMinut.setSelectedItem(datumVremeLista[4]);
        comboBoxMinut.setBounds(412, 117, 99, 22);
        prozorIzmena.getContentPane().add(comboBoxMinut);

        String[] dan = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        JComboBox<String> comboBoxDan = new JComboBox<>(dan);
        comboBoxDan.setSelectedItem(datumVremeLista[2]);
        comboBoxDan.setBounds(272, 162, 70, 22);
        prozorIzmena.getContentPane().add(comboBoxDan);

        String[] meseci = {"januar", "februar", "mart", "april", "maj", "jun", "jul", "avgust", "septembar", "oktobar", "novembar", "decembar"};
        JComboBox<String> comboBoxMesec = new JComboBox<>(meseci);
        comboBoxMesec.setSelectedItem(meseci[Integer.parseInt(datumVremeLista[1])]);
        comboBoxMesec.setBounds(352, 162, 79, 22);
        prozorIzmena.getContentPane().add(comboBoxMesec);

        String[] godine = {"2023", "2024"};
        JComboBox<String> comboBoxGodina = new JComboBox<>(godine);
        comboBoxGodina.setSelectedItem(datumVremeLista[0]);
        comboBoxGodina.setBounds(441, 162, 70, 22);
        prozorIzmena.getContentPane().add(comboBoxGodina);

		
		JLabel lblNewLabel = new JLabel(":");
		lblNewLabel.setBounds(390, 121, 12, 14);
		prozorIzmena.getContentPane().add(lblNewLabel);
		
		ArrayList<String> kozmeticariAL=new ArrayList<String>();
		for(Kozmeticar i : kontejner.kozmeticari) {
			for(TipTretmana j: i.getKozmetickiTretmani()) {
				if(j.getNaziv().equals(tretman.getUsluga().getTip().getNaziv())) {
									kozmeticariAL.add(i.getIme());

				}
			}
		}
		String[] kozmeticari= kozmeticariAL.toArray(new String[0]);
		System.out.println(Arrays.toString(kozmeticari));
		System.out.println(tretman.getKozmeticar().getIme());
		JComboBox<String> comboBoxKozmeticar = new JComboBox<>(kozmeticari);
		String selectedKozmeticar = tretman.getKozmeticar().getIme();
		 comboBoxKozmeticar.setSelectedItem(selectedKozmeticar);
		comboBoxKozmeticar.setBounds(272, 211, 239, 22);
		prozorIzmena.getContentPane().add(comboBoxKozmeticar);
		
		JLabel LabelKlijent = new JLabel(tretman.getKlijent().getIme());
		LabelKlijent.setBounds(272, 268, 239, 22);
		prozorIzmena.getContentPane().add(LabelKlijent);
		
		JLabel LabelUsluga = new JLabel(tretman.getUsluga().getNaziv());
		LabelUsluga.setBounds(272, 315, 239, 22);
		prozorIzmena.getContentPane().add(LabelUsluga);
		
		JLabel LabelOpcija = new JLabel("OPCIJA:");
		LabelOpcija.setBounds(33, 77, 239, 22);
		prozorIzmena.getContentPane().add(LabelOpcija);
		
		JLabel LabelVreme = new JLabel("VREME:");
		LabelVreme.setHorizontalAlignment(SwingConstants.LEFT);
		LabelVreme.setBounds(33, 117, 239, 22);
		prozorIzmena.getContentPane().add(LabelVreme);
		
		JLabel LabelDatum = new JLabel("DATUM:");
		LabelDatum.setHorizontalAlignment(SwingConstants.LEFT);
		LabelDatum.setBounds(33, 162, 239, 22);
		prozorIzmena.getContentPane().add(LabelDatum);
		
		JLabel LabelKozmeticar = new JLabel("KOZMETICAR:");
		LabelKozmeticar.setHorizontalAlignment(SwingConstants.LEFT);
		LabelKozmeticar.setBounds(33, 211, 239, 22);
		prozorIzmena.getContentPane().add(LabelKozmeticar);
		
		JLabel LabelKlijenta = new JLabel("KLIJENT:");
		LabelKlijenta.setHorizontalAlignment(SwingConstants.LEFT);
		LabelKlijenta.setBounds(33, 268, 239, 22);
		prozorIzmena.getContentPane().add(LabelKlijenta);
		
		JLabel LabelTretman = new JLabel("USLUGA:");
		LabelTretman.setHorizontalAlignment(SwingConstants.LEFT);
		LabelTretman.setBounds(33, 315, 239, 22);
		prozorIzmena.getContentPane().add(LabelTretman);
		
		DefaultButton sacuvajBtn = new DefaultButton("SACUVAJ");
		sacuvajBtn.addActionListener(e->{
			String opcija=comboBoxOpcije.getSelectedItem().toString();
			String satCB = comboBoxSat.getSelectedItem().toString();
		    String minutCB = comboBoxMinut.getSelectedItem().toString();
		    String danCB = comboBoxDan.getSelectedItem().toString();
		    String mesecCB =comboBoxMesec.getSelectedItem().toString();
		    String godinaCb =comboBoxGodina.getSelectedItem().toString();

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

		    String kozmeticarCB = comboBoxKozmeticar.getSelectedItem().toString();
		   
			
			LocalDateTime datumVremeLDT = null;
		    if (satCB != null && minutCB != null && danCB != null && mesecCB != null && godinaCb != null) {
		       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		       String dateTimeString = godinaCb + "-" + monthNumber + "-" + danCB + "T" + satCB + ":" + minutCB;
		       datumVremeLDT = LocalDateTime.parse(dateTimeString, formatter);
		    }
		    Kozmeticar kozmeticar= new Kozmeticar();
		    for (Kozmeticar i: kontejner.kozmeticari) {
		    	if (i.getIme().equals(kozmeticarCB)) {
		    		kozmeticar=i;
		    		break;
		    	}
		    }
		   
			ZakazanTretman zakazanNovi= new ZakazanTretman(Opcije.valueOf(opcija),  datumVremeLDT,  kozmeticar,  tretman.getUsluga(),  tretman.getKlijent(),tretman.getCenaUVremeZakazivanja());
			tretman.izmenaZakazanogTretmana(zakazanNovi, kontejner.zakazaniTretmani);
			int result =tretman.provera(kontejner.zakazaniTretmani);
			JLabel porukaLabel = new JLabel("");
			porukaLabel.setBounds(33, 348, 478, 14);
			prozorIzmena.getContentPane().add(porukaLabel);
			switch (result) {
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
			    case -1:
			    case 1:
			    	porukaLabel.setText(" Uspesno sacuvano ");
			        break;
			    default:
			    	porukaLabel.setText(" Unknown result");
			}
		});
		sacuvajBtn.setBounds(33, 384, 478, 23);
		prozorIzmena.getContentPane().add(sacuvajBtn);
		
		prozorIzmena.setVisible(true);
	}
	public tableMaker(int spusti,Prozor prozor, Kontejneri kontejner) {
		table = new JTable();
	    Object[] columns = {"Ime","Prezime", "Potroseno","Kartica"};
	    DefaultTableModel model = new DefaultTableModel();
	    model.setColumnIdentifiers(columns);
	    table.setModel(model);
	    table.setAutoCreateColumnsFromModel(true);
	    table.setRowHeight(30);

	    JScrollPane pane = new JScrollPane(table);
	    pane.setBounds(10, spusti, 688, 90);
	    
	    prozor.getContentPane().add(pane);
	    
	    for(Klijent trenutni: kontejner.klijenti) {
	    Object[] row = new Object[4];
	    row[0]=trenutni.getIme();
	    row[1] = trenutni.getPrezime();
	    row[2] = Double.toString(trenutni.getPotrosioUSalonu());
	    if(trenutni.getKarticaLojalnosti() != null) {
	    	 row[3]=Double.toString(trenutni.getKarticaLojalnosti().getPopust());
	    }
	    else {
	    	row[3]="nema kartice lojlanosti";
	    }
	    model.addRow(row);
	    }}
	public tableMaker(int spusti,Kontejneri kontejner,Prozor prozor ) {
		table = new JTable();
	    Object[] columns =  {"Ime", "Prezime","Pol","Telefon","Adresa","Korisniko ime","Lozinka"};
	    DefaultTableModel model = new DefaultTableModel();
	    model.setColumnIdentifiers(columns);
	    table.setModel(model);
	    table.setAutoCreateColumnsFromModel(true);
	    table.setRowHeight(30);

	    JScrollPane pane = new JScrollPane(table);
	    pane.setBounds(10, spusti, 688, 90);
	    
	    prozor.getContentPane().add(pane);
	    
	    for(Klijent trenutni: kontejner.klijenti) {
	    Object[] row = new Object[7];
	    row[0]=trenutni.getIme();
		 row[1]=trenutni.getPrezime();
		 row[2]=trenutni.getPol();
		 row[3]=trenutni.getTelefon();
		 row[4]=trenutni.getAdresa();
		 row[5]=trenutni.getKorisnickoIme();
		 row[6]=trenutni.getLozinka();
	    model.addRow(row);
	    }}
	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		this.table = table;
	}
	public tableMaker(Prozor prozor,LocalDateTime datumDo,LocalDateTime datumOd,Kozmeticar kozmeticar, Kontejneri kontejner,NovcanikSalona novcanik,int spusti) {
		ArrayList<ZakazanTretman> zakazaniTretmani=new ArrayList<ZakazanTretman>();
		for (ZakazanTretman i:kontejner.zakazaniTretmani) {
			if(i.getOpcijeTretmana().equals(Opcije.IZVRSEN)) {
				if(i.getKozmeticar().getIme().equals(kozmeticar.getIme())) {
					if(datumDo.isAfter(i.getDatum_i_vreme())) {
						if(datumOd.isBefore(i.getDatum_i_vreme())) {
							System.out.println("O BOZE IMAMO NESTO");
							zakazaniTretmani.add(i);
						}
					}
				}
			}
		}
		if(zakazaniTretmani.isEmpty()) {
			 JLabel poruka=new JLabel("Nemamo nista odgovarajuce u nasoj bazi podataka");
			 poruka.setBounds(10,spusti, 688, 117);
			 prozor.getContentPane().add(poruka);
		 }
		else {
		table = new JTable();
		table.setDefaultEditor(Object.class, null);
		this.zakazaniTretmani=zakazaniTretmani;
	    Object[] columns = {"Tip","Tretman", "Cena"};
	    DefaultTableModel model = new DefaultTableModel();
	    model.setColumnIdentifiers(columns);
	    table.setModel(model);
	    table.setAutoCreateColumnsFromModel(true);
	    table.setRowHeight(30);

	    JScrollPane pane = new JScrollPane(table);
	    pane.setBounds(10, spusti, 688, 170);
	    
	    prozor.getContentPane().add(pane);
	    
	    for(ZakazanTretman trenutni: zakazaniTretmani) {
	    Tretman trenutna=trenutni.getUsluga();
	    Object[] row = new Object[3];
	    row[0]=trenutna.getTip().getNaziv();
	    row[1] = trenutna.getNaziv();
	    row[2] = Double.toString(trenutna.getCena());
	    model.addRow(row);
		 } 
		 
		}
	}
	public tableMaker(Prozor prozor, LocalDateTime datumDo, LocalDateTime datumOd, Opcije opcija, Kontejneri kontejner, NovcanikSalona novcanikSalona, int spusti) {
		ArrayList<ZakazanTretman> zakazaniTretmani=new ArrayList<ZakazanTretman>();
		for (ZakazanTretman i:kontejner.zakazaniTretmani) {
			if(i.getOpcijeTretmana().equals(opcija)) { {
					if(datumDo.isAfter(i.getDatum_i_vreme())) {
						if(datumOd.isBefore(i.getDatum_i_vreme())) {
							System.out.println("O BOZE IMAMO NESTO");
							zakazaniTretmani.add(i);
						}
					}
				}
			}
		}
		if(zakazaniTretmani.isEmpty()) {
			 JLabel poruka=new JLabel("Nemamo nista odgovarajuce u nasoj bazi podataka");
			 poruka.setBounds(10,spusti, 688, 117);
			 prozor.getContentPane().add(poruka);
		 }
		else {
		table = new JTable();
		table.setDefaultEditor(Object.class, null);
		this.zakazaniTretmani=zakazaniTretmani;
		 Object[] columns= {"Opcija", "Datum i vreme","Kozmeticar","usluga","klijent","cena"};
		 DefaultTableModel model= new  DefaultTableModel();
		 
		 model.setColumnIdentifiers(columns);
		 table.setModel(model);
		 table.setAutoCreateColumnsFromModel(true);
		 table.setRowHeight(30);
		 
		 JScrollPane pane= new JScrollPane(table);
		 pane.setBackground(new Color(223, 250, 220));

		 pane.setBounds(10,spusti, 688, 117);
		 prozor.getContentPane().add(pane);
		
		Object[] row =new Object[6];
		 for(ZakazanTretman i :zakazaniTretmani) {
			 row[0]=i.getOpcijeTretmana();
			 row[1]=i.getDatum_i_vreme();
			 row[2]=i.getKozmeticar().getIme();
			 row[3]=i.getUsluga().getNaziv();
			 row[4]=i.getKlijent().getIme();
			 row[5]=i.getCenaUVremeZakazivanja();
			
			 model.addRow(row);
		 } 
		}
	}
	public tableMaker(Prozor prozor, LocalDateTime datumDo, LocalDateTime datumOd, Tretman tretman, Kontejneri kontejner, NovcanikSalona novcanikSalona, int spusti) {
		ArrayList<ZakazanTretman> zakazaniTretmani=new ArrayList<ZakazanTretman>();
		for (ZakazanTretman i:kontejner.zakazaniTretmani) {
			if(i.getOpcijeTretmana().equals(Opcije.ZAKAZAN)||(i.getOpcijeTretmana().equals(Opcije.ONLINE_ZAKAZIVANJE))) {
				if(i.getUsluga().getNaziv().equals(tretman.getNaziv())) {
					if(datumDo.isAfter(i.getDatum_i_vreme())) {
						if(datumOd.isBefore(i.getDatum_i_vreme())) {
							System.out.println("O BOZE IMAMO NESTO");
							zakazaniTretmani.add(i);
						}
					}
				}
			}
		}
		if(zakazaniTretmani.isEmpty()) {
			 JLabel poruka=new JLabel("Nemamo nista odgovarajuce u nasoj bazi podataka");
			 poruka.setBounds(10,spusti, 688, 117);
			 prozor.getContentPane().add(poruka);
		 }
		else {
		table = new JTable();
		table.setDefaultEditor(Object.class, null);
		this.zakazaniTretmani=zakazaniTretmani;
		 Object[] columns= {"Opcija", "Datum i vreme","Kozmeticar","usluga","klijent","cena"};
		 DefaultTableModel model= new  DefaultTableModel();
		 
		 model.setColumnIdentifiers(columns);
		 table.setModel(model);
		 table.setAutoCreateColumnsFromModel(true);
		 table.setRowHeight(30);
		 
		 JScrollPane pane= new JScrollPane(table);
		 pane.setBackground(new Color(223, 250, 220));

		 pane.setBounds(10,spusti, 688, 117);
		 prozor.getContentPane().add(pane);
		
		Object[] row =new Object[6];
		 for(ZakazanTretman i :zakazaniTretmani) {
			 row[0]=i.getOpcijeTretmana();
			 row[1]=i.getDatum_i_vreme();
			 row[2]=i.getKozmeticar().getIme();
			 row[3]=i.getUsluga().getNaziv();
			 row[4]=i.getKlijent().getIme();
			 row[5]=i.getCenaUVremeZakazivanja();
			
			 model.addRow(row);
		 } 
		 
		}
	}
}
