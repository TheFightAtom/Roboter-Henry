
package karel;

import java.util.Hashtable;

public class Builtin extends Instruction {

    public Builtin(String s) {
	super(s);
	String token = s.toLowerCase().intern();
	keymap.put(token, this);
    }

    public String toString() {
	return "#<Builtin " + description + ">";
    }

    public String getToken() {
	return getDescription();
    }

    public TokenType getId() {
	return TokenType.BLTIN;
    }

    static Hashtable keymap = new Hashtable();

    static {
	try {			// Get the class 'Test' to load
	    Class.forName("karel.Test");
	} catch (Exception e) {
	    e.printStackTrace();
	}
	new Builtin("move") {
		public boolean execute(KarelVM vm) throws KarelException {
		    vm.getRobot().move();
		    return true;
		}
	    };

	new Builtin("pickbeeper") {
		public boolean execute(KarelVM vm) throws KarelException {
		    vm.getRobot().pickBeeper();
		    return true;
		}
	    };

	new Builtin("putbeeper"){
		public boolean execute(KarelVM vm) throws KarelException {
		    vm.getRobot().putBeeper();
		    return true;
		}
	    };

	new Builtin("turnleft") {
		public boolean execute(KarelVM vm) throws KarelException {
		    vm.getRobot().turnleft();
		    return true;
		}
	    };

	new Builtin("turnoff") {
		public boolean execute(KarelVM vm) throws KarelException {
		    vm.getRobot().turnoff();
		    return true;
		}
	    };
    };

    public static Builtin lookup(String s) {
	return (Builtin) keymap.get(s.intern());
    }
}
