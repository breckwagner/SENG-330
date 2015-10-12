import java.util.Scanner;
import java.lang.StringBuilder;

public class SplashCard {
	// Attributes

	private String welcome;
	private String mainMenu;
	private int number1;
	private boolean aQuestion;
	private Scanner sysin;

	// constructor

	public SplashCard(String w, int n, boolean aq, String mM) {
		welcome = w;
		n = number1;
		aQuestion = aq;
		mainMenu = mM;
		sysin = new Scanner(System.in);
	}

	public String getWelcome() {
		return welcome;
	}

	public String getInput() {
		String input = sysin.next();
		return input;
	}

	public void setWelcome(String welcome) {
		this.welcome = welcome;
	}

	public int getNumber1() {
		return number1;
	}

	public void setNumber1(int number1) {
		this.number1 = number1;
	}

	public boolean isaQuestion() {
		return aQuestion;
	}

	public void setaQuestion(boolean aQuestion) {
		this.aQuestion = aQuestion;
	}

	public String getMainMenu() {
		return mainMenu;
	}

	public void setMainMenu(String mainMenu) {
		this.mainMenu = mainMenu;
	}

	public Scanner getSysin() {
		return sysin;
	}

	public void setSysin(Scanner sysin) {
		this.sysin = sysin;
	}

	public static void printProgBar(int percent) {
		StringBuilder bar = new StringBuilder("[");
		for (int i = 0; i < 50; i++) {

			if (i < (percent / 2)) {
				bar.append("=");
			} else if (i == (percent / 2)) {
				bar.append(">");
			} else {

				bar.append(" ");

			}

		}
		bar.append("]   " + percent + "%      ");
		System.out.println("\r" + bar.toString());

	}

}
