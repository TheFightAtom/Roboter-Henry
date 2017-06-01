package karel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AppWindow extends JFrame{
	
	JLabel derText;
	private JTextField derProgrammtext;
	JButton button;
	
	public AppWindow(){
		
		requestFocus();
		setResizable(false);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		
		setVisible(true);
		setSize(500,1000);
		setTitle("Programmfenster:");
		setAlwaysOnTop(true);
		derProgrammtext = new JTextField("Hier kannst du dein Programmtext eingeben!");
		add(derProgrammtext);
		
			
		
		DerHandler handler = new DerHandler();
		derProgrammtext.addActionListener(handler);
	}
	public static void main(String[] args){
		AppWindow fenster = new AppWindow();
		fenster.setVisible(true);
		fenster.setDefaultCloseOperation(EXIT_ON_CLOSE);
		fenster.setSize(500,1000);
	}
	
public class DerHandler implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent event){
		String string = "";
		if(event.getSource()==derProgrammtext)
			string=String.format("Der Programmtext: %s", event.getActionCommand());
	JOptionPane.showMessageDialog(null, string);
	
	setVisible(true);
	
	}
}}
