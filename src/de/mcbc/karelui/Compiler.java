
package de.mcbc.karelui;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

/*
 * To Do:
 *
 * - accept '-d' as a command line arg indicating output directory
 *     kc -d testdata/results testdata/programs/iterate.k
 *
 *     yields testdata/results/iterate.ser
 *
 *
 * - Make this class friendly to run from another class.  Invoke it
 *   from CompilerTest instead of having CompilerTest invoke the parser.
 *
 */

/**
 *
 */
public class Compiler {
    public static void main (String[] args) {
	String infile = args[0];
	String outfile = args[1];

	Parser parser = new Parser();
	
	try {
	    Program prog = parser.parse(infile);
//  	    prog.print();
	    FileOutputStream fos = new FileOutputStream(outfile);
	    ObjectOutputStream out = new ObjectOutputStream(fos);
	    out.writeObject(prog);
	    out.flush();
	    out.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
}
