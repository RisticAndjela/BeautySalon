package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Prozor extends JFrame  {
    private JPanel contentPanel;
    private JScrollPane scrollPane;
    public DefaultPanel panelZaKlijenta;
	DefaultPanel poruka1=new DefaultPanel(200);
	public Prozor() {
		this.setTitle("Kozmeticki salon");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(223, 250, 220));
		this.setSize(720, 540);
		this.setLayout(null);
		poruka1.setBounds(0,0,720,50);
		DefaultLabel label1 = new DefaultLabel("Dobrodosli u MojSalon SV67/2022");
		label1.setFont(new Font(label1.getFont().getName(), 20, 30));
		this.poruka1.add(label1);
		this.add(poruka1);
	}
//	prozori za korisnike
	public Prozor(String title, String poruka) {
		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setBackground(new Color(223, 250, 220));
		this.setSize(720, 540);
		this.setLayout(null);
		poruka1.setBounds(0,0,720,50);
		DefaultLabel label1 = new DefaultLabel(poruka);
		this.poruka1.add(label1);
		
		
		
	}
	public void  isprazniProzor(String title, String poruka) {
		Component[] components = getContentPane().getComponents();
	    for (Component component : components) {
	        if (component != panelZaKlijenta) {
	            getContentPane().remove(component);
	        }
	    }
		DefaultLabel label1 = new DefaultLabel("Ulogovani ste kao klijent");
		label1.setBounds(220,0,500,100);
		label1.setFont(new Font(label1.getFont().getName(), 20, 30));
		this.add(label1);
		 this.repaint();
		
	}
	 
	public Prozor(String title, String poruka,int a) {
		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.getContentPane().setBackground(new Color(223, 250, 220));
		this.setSize(720, 800);
		this.setLayout(null);
		poruka1.setBounds(0,0,720,50);
		DefaultLabel label1 = new DefaultLabel(poruka);
		this.poruka1.add(label1);
		this.add(poruka1);
		
	}
	public void popuniZKT(Prozor zakaziKozmetickiTretman,int a) {
		

		JLabel kozmeticarLabel = new JLabel("KOZMETICAR:");
		kozmeticarLabel.setBounds(22, 209+a, 263, 22);
		zakaziKozmetickiTretman.getContentPane().add(kozmeticarLabel);
		kozmeticarLabel.setVisible(true);
		
		
		JLabel tretmanLabel = new JLabel("TRETMAN:");
		tretmanLabel.setBounds(22, 252+a, 263, 22);
		zakaziKozmetickiTretman.getContentPane().add(tretmanLabel);
		
		
		JLabel datumLabel = new JLabel("DATUM:");
		datumLabel.setBounds(22, 120+a, 263, 22);
		zakaziKozmetickiTretman.getContentPane().add(datumLabel);
		

		JLabel TipTretmanaLabel = new JLabel("TIP TRETMANA:");
		TipTretmanaLabel.setBounds(22, 169+a, 263, 22);
		zakaziKozmetickiTretman.getContentPane().add(TipTretmanaLabel);

		JLabel lblNewLabel = new JLabel(":");
		lblNewLabel.setBounds(465, 72+a, 16, 23);
		zakaziKozmetickiTretman.getContentPane().add(lblNewLabel);
		zakaziKozmetickiTretman.setVisible(true);
		

		JLabel vremeLabel = new JLabel("VREME:");
		vremeLabel.setBounds(22, 73+a, 263, 22);
		zakaziKozmetickiTretman.getContentPane().add(vremeLabel);
	}

}
