

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Scanner;


import java.io.IOException;




public class Utility {
	public static void main(String[] args) throws IOException {
		/*
	    // Setup terminal and screen layers
	    Terminal terminal = new UnixTerminal(System.in, System.out, java.nio.charset.Charset.defaultCharset());
	    Screen screen = new Screen(terminal);
	    screen.startScreen();
	    
	    

	    // Setup WindowBasedTextGUI for dialogs
	    final WindowBasedTextGUI textGUI = new MultiWindowTextGUI(screen);
	    textGUI.updateScreen();
	    
	    Button button = new Button("Enter");
	    
	    
	    Panel panel = new com.googlecode.lanterna.gui2.Panel();
		
		
		panel.addComponent(button);
		textGUI.updateScreen();
		*/
		
	    
	}
	private static int get_console_property(int magic) {
		
		try {
			ProcessBuilder processBuilder = new ProcessBuilder("/bin/sh", "-c", "stty -a < /dev/tty");
			Process process = processBuilder.start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			
			@SuppressWarnings("resource")
			Scanner s = new Scanner(reader.readLine());
			
			for (int i = 0; i <= magic; i++){
				while(!s.hasNextInt()){
					s.next();
				}
				s.nextInt();
			}
			s.next();
			return s.nextInt();
		} catch (Exception e) {
			return -1;
		}
	}
	
	public static int getCols() {
		return 80;//get_console_property(1);
	}
	
	public static int getLines() {
		return get_console_property(0);
	}
	/*
	public enum Strings {
		HORIZONTAL_LINE("-"),
		VERTICAL_LINE("|"),
		
		TOP_LEFT("+"),
		TOP_CENTER("+"),
		TOP_RIGHT("+"),
		
		MIDDLE_LEFT("+"),
		MIDDLE_CENTER("+"),
		MIDDLE_RIGHT("+"),
		
		BOTTOM_LEFT("+"),
		BOTTOM_CENTER("+"),
		BOTTOM_RIGHT("+");

	    private final String text;

	    private Strings(final String text) {
	        this.text = text;
	    }


	    @Override
	    public String toString() {
	        return text;
	    }
	}
	
	
	
	private static String wrapValue(String str, int i, int j){
		return "";
	}
	
	public static String prettyPrintMatrix(String[][] m) {
		String HORIZONTAL_LINE = "-";
		String VERTICAL_LINE = "|";
		
		String TOP_LEFT = "+";
		String TOP_CENTER = "+";
		String TOP_RIGHT = "+";
		
		String MIDDLE_LEFT = "+";
		String MIDDLE_CENTER = "+";
		String MIDDLE_RIGHT = "+";
		
		String BOTTOM_LEFT = "+";
		String BOTTOM_CENTER = "+";
		String BOTTOM_RIGHT = "+";
		
		
		StringBuilder output = new StringBuilder();
		
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[i].length; i++) {
				
				
				output.append((j==0?VERTICAL_LINE:"") + m[i][j] + VERTICAL_LINE);
			}
		}
		
		
		
		return "";
	}
	*/




	public static class ANSI {
		public static final String x = "";
	}



}
