

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Scanner;

import java.io.IOException;




public class Utility {
	/*
	public static void main(String[] args) throws IOException {
		
	    // Setup terminal and screen layers
	    Terminal terminal = 
	    		new UnixTerminal(System.in, System.out, java.nio.charset.Charset.defaultCharset());
	    Screen screen = new com.googlecode.lanterna.screen.Screen();
	    screen.startScreen();
	    
	    

	    // Setup WindowBasedTextGUI for dialogs
	    final WindowBasedTextGUI textGUI = new MultiWindowTextGUI(screen);
	    textGUI.updateScreen();
	    
	    Button button = new Button("Enter");
	    
	    
	    Panel panel = new com.googlecode.lanterna.gui2.Panel();
		
		
		panel.addComponent(button);
		textGUI.updateScreen();
		
		
	    
	}*/
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
			return 80;
		}
	}
	
	public static int getCols() {
		return get_console_property(1);
	}
	
	public static int getLines() {
		return get_console_property(0);
	}




	public static class ANSI {
		public static final String x = "";
	}

	
	
	public static final String[] roomDescriptions = new String[]{
            "A room with bodies, not exactly human but close, many of them have keyboards surgically attached, albeit not very professionally, to various parts of their body. Some small keyboards similar to the pip boy in fallout, others full size embedded in to their backs.",
            "A large room, mainly empty except large drums with very large gauge wires hanging out of the top. As you go closer to view one of them your hair starts to stand up. The drum has a label, ‘MelodiCapacitor - High Voltage’. Strange.",
            "Large tubes fill this room, inside of the tubes are people floating in some type of amniotic fluid, their eyes closed. A childs xylophone labelled ’control panel’ is wired into a desk, you pick up the percussion mallet and hit a key. Immediately the bodies spring to life, and look at you like your stupid, they point to you and sneer.",
            "Many people have cried in this room, you can feel it. The walls are painted with chalk paint, and drawings one the wall suggest unhappy things have happened here. Most of the words written on the walls are ‘stop playing music’, and ‘people are trying to sleep’.",
            "A child’s bedroom, many toys are laying out as someone left in a hurry, most of the toys music related. Being a small child stuck in a mans body, you pick up a fisher price keyboard and press a key, nothing, you turn the switch to on, still no sound. You scramble for batteries in the other toys, there aren’t any. Someone has stolen all of the batteries.",
            "The Professor is in the room, a room full of work benches, multimeters and oscilloscopes. He is frantically searching, going through the piles of wires and parts, yelling ‘2 percent, theres no way I’m going to be able to finish!’ You ask him if it’s related to the hyper melodica, he replies, ‘No, I lost my phone charger.’",
            "As you open the door, someone pushes back, you push back and enter the room, the room is full of stripped copper and scrap aluminum. A pile of signs on the floor mentioning  ‘UVIC FUNDRAISER FOR TOP SECRET PROJECTS’ is propped up against the wall. You look back the way you came, and notice the door has an automatic closer, and you are just weak.",
            "Cages, at least 30 of them with the cutest puppies you’ve ever seen! You spend 30 seconds telling them all ‘hello’ in a high pitched voice. On the other side of the room lies a control panel full of screens. The control panel for the system seems to be a drum wired into the terminal. You decide its not worth the risk scaring the puppies and do not attempt to see what the system does. Damn those were cute puppies.",
            "A red room, very small, with a single red button on a pedestal in the middle. You decide to push it. Nothing. You push it harder. Nothing. Upon inspection of the wiring you notice there isn’t any, What a waste of time.",
            "A Blue room, very small, with a pedestal that has wires running to the top of it, on top of the pedestal is a button, on top of the button is a spider. You try to shoo the spider off, as the spider moves, hundreds of baby spiders run out from underneath it. No way your gunna go near that. nope nope nope nope nope nope nope."
	};

	public static final String GAME_START_ASCII = 
	  "        __          __  _                            _                                      \n"
	+ "        \\ \\        / / | |                          | |                                     \n"
	+ "         \\ \\  /\\  / /__| | ___ ___  _ __ ___   ___  | |_ ___                                \n"
	+ "          \\ \\/  \\/ / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ | __/ _ \\                               \n"
	+ "           \\  /\\  /  __/ | (_| (_) | | | | | |  __/ | || (_) |                              \n"
	+ "____        \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___|  \\__\\___/                               \n"
	+ "|  _ \\                     | | (_)            |  __ \\                                        \n"
	+ "| |_) |_   _ ______ _ _ __ | |_ _ _ __   ___  | |  | |_   _ _ __   __ _  ___  ___  _ __  ___ \n"
	+ "|  _ <| | | |_  / _` | '_ \\| __| | '_ \\ / _ \\ | |  | | | | | '_ \\ / _` |/ _ \\/ _ \\| '_ \\/ __|\n"
	+ "| |_) | |_| |/ / (_| | | | | |_| | | | |  __/ | |__| | |_| | | | | (_| |  __/ (_) | | | \\__ \\\n"
	+ "|____/ \\__, /___\\__,_|_| |_|\\__|_|_| |_|\\___| |_____/ \\__,_|_| |_|\\__, |\\___|\\___/|_| |_|___/\n"
	+ "        __/ |                                                      __/ |                     \n"
	+ "       |___/                                                      |___/                      \n";

	
	public static final String GAME_START_DESCRIPTION = "You wake up, cold, alone, in a room full of what looks to be tubing, wiring and keyboards and about 22 microwaves with the door safety switch removed. Your head is splitting. What happened after that meeting with the professor?"
			+ "\n" + "As you try to get up, you realize something is covering you, your are buried deep in the last 8 years of Modern Melodica Weekly magazine. The worlds foremost authority on melodica news."
			+ "\n" + "A Door opens, the professor a walks in."
			+ "\n" + "“Hey you!, I need you to help me find my hyper melodica, I need to patent it before on of my students steals my idea and becomes the richest and most powerful person on the planet.”"
			+ "\n" + "“What’s a hyper melodica?”, you ask."
			+ "\n" + "Seemingly upset at your ignorance, he replies “That’s not important, you’ll know it when you hear it, the most beautiful sound ever created. What is important, is that this building is full of monsters, a by-product of the development of such a godly instrument. You will have to fight them off, and in exchange for finding my hyper melodica I will allow you to play 5 minutes of music on my steam powered theremin."
			+ "\n" + "You want neither of these things, but agree as the professor seems like a nice guy generally, and you don’t want to upset him as marks will be coming out soon."
			+ "\n" + "And so the journey begins…";

	public static final String GAME_GEORGE = "                                                   `.,:,``"
			+ "\n" + "                                             `:;+#+#@@@@+#:"
			+ "\n" + "                                            `+@@@@@@@@@@@@@+`"
			+ "\n" + "                                           ;#@@@@@@@@@@@@@@@@:`"
			+ "\n" + "                                         `;+#@@@@@@@@@@@@@@@@@;."
			+ "\n" + "                                        `+##@#@#@@@@@@@@@@@@@@@+,"
			+ "\n" + "                                        ;+#########@@@@@@@@@@@@@#:;;,`"
			+ "\n" + "                                       .#++###+++#####@@@@@@@@@@@@###:"
			+ "\n" + "                                       ;#'+'+++''''''++###@@@@@@@@@@@#`"
			+ "\n" + "                                      .'';''';:,,::::;'+++###@@@@@@@@@;"
			+ "\n" + "                                      '+;+#',......,,;;';'''++#@@@@@@@#."
			+ "\n" + "                                     :'''#:.``````...,:;';;;;;;+##@@@@#'"
			+ "\n" + "                                     ;''+:``````````..:';,:,:::;+##@@@@#`"
			+ "\n" + "                                    .;;+'.``````````..,::,,,,,,:;+#@@@@#;"
			+ "\n" + "                                    ,;'+.````````````..,,,,,,,,::'#@@@@#'"
			+ "\n" + "                                    ,;',``````````````....,,,,,,:;#@@@@#:"
			+ "\n" + "                                    :':```````````````......,,,,,:'#@@@@,"
			+ "\n" + "                                    ;;.``````````````.......,,,,,:;+@@@@,"
			+ "\n" + "                                   `;:````` `````````.......,,,,,::+@@@#,"
			+ "\n" + "                                   .;.```````````````.......,,,,,::;@@@#"
			+ "\n" + "                                   .:````````````````.......,,,,,,,:#@@+"
			+ "\n" + "                                   :,````````````````.`.....,,,,,,,:+@#'"
			+ "\n" + "                                   :,``````  ```````..``.....,,,,,,:'@#:"
			+ "\n" + "                                   ;,```````````````.``......,,,,,,:'##:"
			+ "\n" + "                                   :,````` `````````````......,,,,,:'##,"
			+ "\n" + "                                   ,,``````......```.`.......,,,,,,:'##."
			+ "\n" + "                                   .:`````..,::::,.`.`..,,::::::,,,,;#+`"
			+ "\n" + "                                    :````...,:;';:.```.,;''+'';;;,,,;#+"
			+ "\n" + "                                  `.:``````,,::;;,```.,:;'+';''';:,,;#'"
			+ "\n" + "                                 `.`,````.::.'#::,.``.,;;+'';;;;;;,,'#,"
			+ "\n" + "                                 `.`,````.,.`'',:.```.:;;';##''';:,,++`"
			+ "\n" + "                                 ```,````````..,,````.:;;';++:+';:,,++:."
			+ "\n" + "                                 ```:` ``````....```..::;;;:::;';:,,+',,"
			+ "\n" + "                                  ...`  ````````````.,:::::::::::,,,+,,,"
			+ "\n" + "                                  .,``  ````````````.,::,:::,,,,,,,,',,,"
			+ "\n" + "                                  `,``   ```````````.,::,,,,,,,,,,,.;,,`"
			+ "\n" + "                                  ````    ``````````.,::,,,,,,,,,,,.,,,"
			+ "\n" + "                                   ```    ```..``` `.,::,,,,,,,,,,,..,."
			+ "\n" + "                                   ```   ````.```.``.::,:,,,,,,,,,,.,:"
			+ "\n" + "                                   ``` ````````````.,;;;::,,,,,,,,,.:,"
			+ "\n" + "                                    `` ````````````.,:;;::,,,,,,,,,.,."
			+ "\n" + "                                     ``````````````.,::::::,,,,,,,,.,"
			+ "\n" + "                                     ``````.``````....,,,,,,,,,,,,,,."
			+ "\n" + "                                     `````.,,,```....,,,:,,,,,,,,,,,`"
			+ "\n" + "                                     `````.,.`.`...,::;;;'',,,,,,,."
			+ "\n" + "                                      `````..`````...,;;;::,,,:,,,`"
			+ "\n" + "                                      `````.`````...,,:::,:,,,:,,,"
			+ "\n" + "                                      ```````````....,,::,,,,::,,."
			+ "\n" + "                                      ````````````....,,,::,::,,,`"
			+ "\n" + "                                      ````````````...,,,,::,::,,,"
			+ "\n" + "                                      ```````````...,,,,,:::::,`"
			+ "\n" + "                                      ```````````...,,,::::::,.`"
			+ "\n" + "                                       `````````....,::::::::.,"
			+ "\n" + "                                       ````````....,,:::::::,,,"
			+ "\n" + "                                     ` ``````..,,:,,:::::::::,,"
			+ "\n" + "                                    ` ```````..,,,,::;;;;::::,,"
			+ "\n" + "                                   `` ````````..,,,:::;;;:::,,,,"
			+ "\n" + "                                  `.```````````.,,:::::::::,:,,;"
			+ "\n" + "                                  ...```````````.,,::::::::::,;'."
			+ "\n" + "                                 `..;```````````..,,,,,:::,,::+;:"
			+ "\n" + "                                ``..;````````````.,,,,,,:,,,::#;:."
			+ "\n" + "                              ......::```````````.,,:,,::,,::'+;;:"
			+ "\n" + "                            .:,.....:'.`````````..,:::,,,,:::#;;;:."
			+ "\n" + "                          .,:,......:;:`````````..,,,,,,,,::;+;;;;:;."
			+ "\n" + "                       `..,:,.......,;'.````````...,,,,,,,:;#;:;;;:,';.`"
			+ "\n" + "                     `..,,:,,.......,;':.````````.,,,,,,,::'+::;;;;:''':,."
			+ "\n" + "                  `....,,:,.........,;;',.``````...,,,,,,,:#:::;;;;::+'';;:."
			+ "\n" + "                `..,,,.,.,,,........,:;';,..````..,,,,,,,:'#,,:;;;;;:+++'';;;."
			+ "\n" + "             `....,,,,.,,,.,.`.....,,;;'':...```..,,,,,,,:+:,,:;;';;:+++''''';;,`"
			+ "\n" + "           `....,,:,::,,............,:;;';,..........,,,,;+,,::;;;;;;++'''''''';:,`"
			+ "\n" + "        `.,.,,..,,,:,:,,........,;#@@+;'';;,.........,,,;+'.#@@#;;';;'+'+'''''';;;;:`"
			+ "\n" + "      `,,,,,,,,,.,::,::,,.,...,#@@@@@@:'#';:,........,,,+@.,##@@@#;;;'+++''''''''';;;:`"
			+ "\n" + "     ..,,,,,,,,..:::::::,,,..;#@##@@@@#:'@#;:,,,,.,,,::#@+.+@@@##@@';'++++++'''''';';;;,"
			+ "\n" + "    ...,,:.,,,,..,:::::,,,,.:'#####@@@#;;'@@#;:,:,,;+#@@@,,#@@####@@;'++++++'''''''';;';:."
			+ "\n" + "  `...,.,;:,,,..,,,,::;:,,.,:;+#++'+###';;+@@@@@@@@@@@@@:.;@@#####@@#'+++++'''''''''''';;;:`"
			+ "\n" + " `..,.,,.:;,,...,:,,,:;;,:.::'''';;;'#+';''+@@@@@@@@@@@::.@@#####@@@@'++++''''''''';''';';;:`"
			+ "\n" + " `.....,;.,;;,,..,:,,,,::;:::;;;;;;;::'+;;:'++@@@@@@@@@;,,,###########++#+'''''''''''''''''';;`"
			+ "\n" + "`..,...,',.:;:,..:;:,,,,,::;;;:::::::::+'::;'+#@@@@@@@;,,,;##########+##'''''';''';;''''''';'':"
			+ "\n" + "..,...,.;;.,;;,..:;::,,,,,,:;;;;::,::,,;'::,+;+#@@@@@;,,,'#########+#++''''''';''';'';'';'''+'':"
			+ "\n" + "......,.:',.:;,.,:;::,,,,,,,,,;'':::::,;'::,,+;+@@@@;,,:########+++++''''''';;;''';'';''';;'+''':"
			+ "\n" + "..,.,,,,,',.:;,.,;;::::::,,,,,,:;'::;;,:;:::,;;'+@@+,,'#######+++++'''''''';;;;'''''';'';;;++''';`"
			+ "\n" + "..,..,:,,':.,:,.:;;::::::,,,,,,,,:::;';:::,;,,:;+++.;########++++'''''''''';;;;;''''';+';;'+++'+',"
			+ "\n" + "..:,,,:,:',.,,,,;;::::::,,,,:,,,,,,:::;::;:;;,:,+',+@#####++++''''''''';''';;;;;''''';'';;+#++'+''"
			+ "\n" + ",,::,::::;..,,,:;::::;::,,,,::,,,,,:::::::::';,,;:######+++''';;'''''';;''';;';;''''';'';;+#+'+'''`"
			+ "\n" + ",,:;,::;::..::,:::::;;:,,,,:;:,,,,,,:::;;:::;;::'@@##+++'''';;;'''';;;;;;'';;;;'''''';'+''##'++++':"
			+ "\n" + ",,;',::;:,.,:,,::::;;:,,,,:;;::,,,.,;::;;:::::;:#@@#+''''';';;;''';;;;;;;'';;;;'''''';''''##++++++;"
			+ "\n" + ",,;+,:;;,.,;,,:::::;;:,.,,:;::,:,,,,;::;:::,,:''###+';';;;;;;;;;;;;;;;;;;';;;;''+'''';''''##++#+++'`"
			+ "\n" + ",,:+,;;;,,;:.,:::::;:,..,:;;::::,,.,;;;;:::,,:;+#+''';';;;;;;;;;;;;;;;;;;;;;;'''+'''';''++##'+#++++:"
			+ "\n" + ".::+,';:.:;,.,:::;::,...,:;;::::,,..:;;;:::,,,'##';;;'';;;;;;;;;;;;;;;;;;;;;'''++';;';''++##+##++++;"
			+ "\n" + ".::#,'':,;:..,:;;:,....,:;;:::::::,.:;;;,,:,,,'#+';;:;;;;;;;;;;;;;;;;;;;;;;''''++'';';''++@#+#+++++;"
			+ "\n" + ".:,#,;+:,:,..:;;:,....,:::;;;:,:::,.:;;:::::,,'+';;;::;;;;;;;:;;:;;;;;;;;;;'''''+';;;;;++###+#++++#'"
			+ "\n" + ".:,+:;#:,:,..:;:,....,,::;;;;:,,::,.,;:::,:::,'+';:::::;;;;;;::;:;;;;;;::;;''''++'';;;;+##@#+#++##++";
	
	public static final String GAME_OVER_ASCII = "┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼\n"
			+ "███▀▀▀██┼███▀▀▀███┼███▀█▄█▀███┼██▀▀▀\n" + "██┼┼┼┼██┼██┼┼┼┼┼██┼██┼┼┼█┼┼┼██┼██┼┼┼\n"
			+ "██┼┼┼▄▄▄┼██▄▄▄▄▄██┼██┼┼┼▀┼┼┼██┼██▀▀▀\n" + "██┼┼┼┼██┼██┼┼┼┼┼██┼██┼┼┼┼┼┼┼██┼██┼┼┼\n"
			+ "███▄▄▄██┼██┼┼┼┼┼██┼██┼┼┼┼┼┼┼██┼██▄▄▄\n" + "┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼\n"
			+ "███▀▀▀███┼▀███┼┼██▀┼██▀▀▀┼██▀▀▀▀██▄┼\n" + "██┼┼┼┼┼██┼┼┼██┼┼██┼┼██┼┼┼┼██┼┼┼┼┼██┼\n"
			+ "██┼┼┼┼┼██┼┼┼██┼┼██┼┼██▀▀▀┼██▄▄▄▄▄▀▀┼\n" + "██┼┼┼┼┼██┼┼┼██┼┼█▀┼┼██┼┼┼┼██┼┼┼┼┼██┼\n"
			+ "███▄▄▄███┼┼┼─▀█▀┼┼─┼██▄▄▄┼██┼┼┼┼┼██▄\n" + "┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼\n"
			+ "┼┼┼┼┼┼┼┼██┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼██┼┼┼┼┼┼┼┼┼\n" + "┼┼┼┼┼┼████▄┼┼┼▄▄▄▄▄▄▄┼┼┼▄████┼┼┼┼┼┼┼\n"
			+ "┼┼┼┼┼┼┼┼┼▀▀█▄█████████▄█▀▀┼┼┼┼┼┼┼┼┼┼\n" + "┼┼┼┼┼┼┼┼┼┼┼█████████████┼┼┼┼┼┼┼┼┼┼┼┼\n"
			+ "┼┼┼┼┼┼┼┼┼┼┼██▀▀▀███▀▀▀██┼┼┼┼┼┼┼┼┼┼┼┼\n" + "┼┼┼┼┼┼┼┼┼┼┼██┼┼┼███┼┼┼██┼┼┼┼┼┼┼┼┼┼┼┼\n"
			+ "┼┼┼┼┼┼┼┼┼┼┼█████▀▄▀█████┼┼┼┼┼┼┼┼┼┼┼┼\n" + "┼┼┼┼┼┼┼┼┼┼┼┼███████████┼┼┼┼┼┼┼┼┼┼┼┼┼\n"
			+ "┼┼┼┼┼┼┼┼▄▄▄██┼┼█▀█▀█┼┼██▄▄▄┼┼┼┼┼┼┼┼┼\n" + "┼┼┼┼┼┼┼┼▀▀██┼┼┼┼┼┼┼┼┼┼┼██▀▀┼┼┼┼┼┼┼┼┼\n"
			+ "┼┼┼┼┼┼┼┼┼┼▀▀┼┼┼┼┼┼┼┼┼┼┼▀▀┼┼┼┼┼┼┼┼┼┼┼\n" + "┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼";


	
	
	
	
	
	
	
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


}
