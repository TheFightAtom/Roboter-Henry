package karel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import karel.swingui.WorldPanel;

public class AppWindow extends JFrame{
	
	JLabel derText;
	private JTextField derProgrammtext;
	JButton button;
	
	public AppWindow() throws Exception {
	  File testWorldFile = new File("./test_welt");
	  WorldPanel worldPanel = new WorldPanel();
	  		
		requestFocus();
		setResizable(false);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		
		setVisible(true);
		setSize(364,160);
		setTitle("Programmfenster:");
		setAlwaysOnTop(true);
		derProgrammtext = new JTextField("Hier kannst du dein Programmtext eingeben!");
		getContentPane().add(derProgrammtext);
		
    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(worldPanel);
    
    this.repaint();
    
    worldPanel.setWorld(new WorldParser().parse(new FileReader(testWorldFile)));
    worldPanel.repaint();
    worldPanel.setVisible(true);
    
    System.out.println("Set world");
   
		
		DerHandler handler = new DerHandler();
		derProgrammtext.addActionListener(handler);
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
