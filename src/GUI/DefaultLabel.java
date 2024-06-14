package GUI;

import java.awt.Font;

import javax.swing.JLabel;

public class DefaultLabel extends JLabel {

	public DefaultLabel(String poruka) {
		this.setText(poruka);
		this.setFont(new Font(this.getFont().getName(), 10, 20));
	}
	
	

}
