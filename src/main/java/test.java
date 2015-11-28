
import java.lang.ProcessBuilder;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


class test {
	/*
	public static final String ANSI_RESET =  "\u001B[0m";
	public static final String ANSI_BLACK =  "\u001B[30m";
	public static final String ANSI_RED =    "\u001B[31m";
	public static final String ANSI_GREEN =  "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE =   "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN =   "\u001B[36m";
	public static final String ANSI_WHITE =  "\u001B[47m";
	*/
	
	private static int get_console_property(int magic) {
		try {
			ProcessBuilder processBuilder = new ProcessBuilder("/bin/sh", "-c", "stty -a < /dev/tty");
			Process process = processBuilder.start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
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
		return get_console_property(1);
	}
	
	public static int getLines() {
		return get_console_property(0);
	}
	
	public static void main(String[] args) {
		System.out.print(getLines());
		//System.out.print(ANSI_WHITE+"░░░░░░░░░░██████████"+ANSI_RESET);
		
	}
}
