package GUI;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import klase.Kontejneri;
import tretmani.TipTretmana;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JTable;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class proba {
	private static JTable table;
	private static JTextField textField;

	public static void main(String[] args) {
		Kontejneri kontejner = new Kontejneri();
        Prozor prozorIzvestaji = new Prozor("Recepcionar", "Ulogovani ste kao recepcionar");
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
		
		JComboBox comboBox = new JComboBox();
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
		
		JButton prikaziDugme = new JButton("Prikazi");
		prikaziDugme.setBounds(40, 316, 604, 23);
		prozorIzvestaji.getContentPane().add(prikaziDugme);
		
		

		prozorIzvestaji.setVisible(true);
    }
}
