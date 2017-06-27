/*
  Copyright (C) 2000,2001 Tom Mitchell

  This file is part of KarelJ.

  This program is free software; you can redistribute it and/or
  modify it under the terms of the GNU General Public License
  as published by the Free Software Foundation; either version 2
  of the License, or (at your option) any later version.

  This program is distributed in the hope that it will be useful,
  but WITHOUT ANY WARRANTY; without even the implied warranty of
  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  GNU General Public License for more details.

  You should have received a copy of the GNU General Public License
  along with this program; if not, write to the Free Software
  Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
*/

package karel.swingui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.*;

import karel.AppWindow;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.BorderLayout;
import java.awt.Font;

public class Main {
  private static JTextField textField;
  private static JTextField textField_1;

    public static void main(String args[]) throws Exception {
	File worldFile = null;
	File progFile = null;

	int i=0;
	while (i<args.length) {
	    if (args[i].equals("-w")) {
		worldFile = new File(args[++i]);
		i++;
	    } else if (args[i].equals("-p")) {
		progFile = new File(args[++i]);
		i++;
	    } else {
		System.out.println("usage: Main [-w world] [-p program]");
		System.exit(1);
	    }
	}
	
	JLabel lblHierBefehleSchreiben = new JLabel("Hier Befehle Schreiben:");
	lblHierBefehleSchreiben.setBounds(99, 92, 191, 15);
	appWindow.getContentPane().add(lblHierBefehleSchreiben);
	
	KarelFrame appWindow = new KarelFrame("Karel");
	appWindow.fWorldPanel.setBounds(392, 12, 535, 396);
		


	// When the user clicks the close window button on the frame,
	// we need to shut down.
	 appWindow.addWindowListener(new WindowAdapter() {
	    public void windowClosing(WindowEvent evt) {
	      System.exit(0);
	    }
	  }
				);

	 appWindow.setSize(953, 773);
	 
	 JButton btnTest = new JButton("test");
	 btnTest.setBounds(67, 190, 63, 25);
	 btnTest.addActionListener(new ActionListener() {
	   public void actionPerformed(ActionEvent arg0) {
	   }
	 });
	 appWindow.fWorldPanel.setLayout(null);
	 appWindow.fWorldPanel.add(btnTest);
	 appWindow.getContentPane().setLayout(null);
	 
	 JButton btnRechtdrehen = new JButton("RechtDrehen");
	 btnRechtdrehen.setBounds(12, 12, 136, 25);
	 appWindow.getContentPane().add(btnRechtdrehen);
	 
	 JButton btnLinksdrehen = new JButton("LinksDrehen");
	 btnLinksdrehen.setBounds(160, 12, 123, 25);
	 appWindow.getContentPane().add(btnLinksdrehen);
	 
	 JButton btnRun = new JButton("Vorwärts");
	 btnRun.addActionListener(new ActionListener() {
	   public void actionPerformed(ActionEvent arg0) {
	   }
	 });
	 btnRun.setBounds(12, 55, 123, 25);
	 appWindow.getContentPane().add(btnRun);
	 
	 JButton btnBlocksetzen = new JButton("BlockSetzen");
	 btnBlocksetzen.setBounds(147, 55, 136, 25);
	 appWindow.getContentPane().add(btnBlocksetzen);
	 
	 textField = new JTextField();
	 textField.setDropMode(DropMode.ON);
	 textField.setBounds(12, 95, 368, 607);
	 appWindow.getContentPane().add(textField);
	 textField.setColumns(10);
	 
	 textField_1 = new JTextField();
	 textField_1.setBounds(392, 421, 537, 281);
	 appWindow.getContentPane().add(textField_1);
	 textField_1.setColumns(10);
	 appWindow.setVisible(true);
	
    }
}
