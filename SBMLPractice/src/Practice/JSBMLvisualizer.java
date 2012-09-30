package Practice;
import java.io.File;
import javax.swing.*;
import org.sbml.jsbml.*;

/** Displays the content of an SBML file in a {@link JTree} */
public class JSBMLvisualizer extends JFrame {
	/** @param document The SBML root node of an SBML file */
	public JSBMLvisualizer(SBMLDocument document) {
		super(document.getModel().getId());
		getContentPane().add(new JScrollPane(new JTree(document)));
		pack();
		setVisible(true);
	}

	/**
	* Main routine. Note: this does not perform any error checking, but should. It is an illustration only.
	* @param args Expects a valid path to an SBML file.
	*/
public static void main(String[] args) throws Exception {
	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	SBMLReader slread = new SBMLReader();
	SBMLDocument here = slread.readSBML(new File("V:\\workspace\\SBMLPractice\\etc\\Ec_core_flux1.xml"));
	
	/*SBMLDocument here = mainFile(args[0]);*/
	new JSBMLvisualizer(here);
	
	}

public static SBMLDocument mainFile(String arg) throws Exception {
	SBMLReader slread = new SBMLReader();
	
	SBMLDocument here = slread.readSBML(new File(arg));
	return here;
	}
}
