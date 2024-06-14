package GUI;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DefaultPanel extends JPanel {
	private JTextField Field;
	private JComboBox Combo;

public JTextField getField() {
		return Field;
	}

	public void setField(JTextField field) {
		Field = field;
	}

	// konstruktor za default
	public DefaultPanel(int spustamo) {
		this.setBackground(new Color(223, 250, 220));
		this.setBounds(0, spustamo, 720, 50);
		this.setVisible(true);
	}
	
// konstruktor za poruke
	public DefaultPanel(String poruka, int spustamo) {
		this.setBackground(new Color(223, 250, 220));
		this.setBounds(0, spustamo, 720, 50);
		this.setVisible(true);
		DefaultLabel label=new DefaultLabel(poruka);
		this.add(label);
		
	}
//	konstruktor za dugmice 
	public DefaultPanel(int spustamo,int brojKolona, int brojRedova) {
		this.setBackground(Color.white);
		this.setBounds(0,spustamo,720,50*brojRedova);
		this.setLayout(new GridLayout(brojRedova,brojKolona));
	}
	public DefaultPanel(int dubina,int spustamo,int brojKolona, int brojRedova) {
		this.setBackground(Color.white);
		this.setBounds(0,spustamo,720,dubina);
		this.setLayout(new GridLayout(brojRedova,brojKolona));
	}

	public void add(String string) {
		DefaultLabel label= new DefaultLabel(string);
		this.add(label);
	}
	
	// pravljenje input polja
	public DefaultPanel(int spustamo, String poruka,JTextField polje) {
		this.setBackground(new Color(223, 250, 220));
		this.setBounds(0, spustamo, 720, 50);
		this.setVisible(true);
		this.Field = polje;
		this.add(new DefaultLabel(poruka));
		this.add(Field);
	}

	public DefaultPanel(int spustamo, String poruka,JComboBox<String> polje) {
		this.setBackground(new Color(223, 250, 220));
		this.setBounds(0, spustamo, 720, 50);
		this.setVisible(true);
		this.Combo = polje;
		this.add(new DefaultLabel(poruka));
		this.add(Combo);
	}
}
