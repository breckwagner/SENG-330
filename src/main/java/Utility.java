

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
			"Thick cobwebs fill the corners of the room, and wisps of webbing hang from the ceiling and waver in a wind you can barely feel. One corner of the ceiling has a particularly large clot of webbing within which a goblin's bones are tangled.",
			"Neither light nor darkvision can penetrate the gloom in this chamber. An unnatural shade fills it, and the room's farthest reaches are barely visible. Near the room's center, you can just barely perceive a lump about the size of a human lying on the floor. (It might be a dead body, a pile of rags, or a sleeping monster that can take advantage of the room's darkness.)",
			"Rats inside the room shriek when they hear the door open, then they run in all directions from a putrid corpse lying in the center of the floor. As these creatures crowd around the edges of the room, seeking to crawl through a hole in one corner, they fight one another. The stinking corpse in the middle of the room looks human, but the damage both time and the rats have wrought are enough to make determining its race by appearance an extremely difficult task at best.",
			"Tapestries decorate the walls of this room. Although they may once have been brilliant in hue, they now hang in graying tatters. Despite the damage of time and neglect, you can perceive once-grand images of wizards' towers, magical beasts, and symbols of spellcasting. The tapestry that is in the best condition bulges out weirdly, as though someone stands behind it (an armless statue of a female human spellcaster).",
			"Burning torches in iron sconces line the walls of this room, lighting it brilliantly. At the room's center lies a squat stone altar, its top covered in recently spilled blood. A channel in the altar funnels the blood down its side to the floor where it fills grooves in the floor that trace some kind of pattern or symbol around the altar. Unfortunately, you can't tell what it is from your vantage point.",
			"A liquid-filled pit extends to every wall of this chamber. The liquid lies about 10 feet below your feet and is so murky that you can't see its bottom. The room smells sour. A rope bridge extends from your door to the room's other exits.",
			"Fire crackles and pops in a small cooking fire set in the center of the room. The smoke from a burning rat on a spit curls up through a hole in the ceiling. Around the fire lie several fur blankets and a bag. It looks like someone camped here until not long ago, but then left in a hurry.",
			"A flurry of bats suddenly flaps through the doorway, their screeching barely audible as they careen past your heads. They flap past you into the rooms and halls beyond. The room from which they came seems barren at first glance.",
			"Rusting spikes line the walls and ceiling of this chamber. The dusty floor shows no sign that the walls move over it, but you can see the skeleton of some humanoid impaled on some wall spikes nearby.",
			"You open the door, and the reek of garbage assaults your nose. Looking inside, you see a pile of refuse and offal that nearly reaches the ceiling. In the ceiling above it is a small hole that is roughly as wide as two human hands. No doubt some city dweller high above disposes of his rubbish without ever thinking about where it goes.",
			"You open the door, and the room comes alive with light and music. A sourceless, warm glow suffuses the chamber, and a harp you cannot see plays soothing sounds. Unfortunately, the rest of the chamber isn't so inviting. The floor is strewn with the smashed remains of rotting furniture. It looks like the room once held a bed, a desk, a chest, and a chair.",
			"A skeleton dressed in moth-eaten garb lies before a large open chest in the rear of this chamber. The chest is empty, but you note two needles projecting from the now-open lock. Dust coats something sticky on the needles' points.",
			"Rounded green stones set in the floor form a snake's head that points in the direction of the doorway you stand in. The body of the snake flows back and toward the wall to go round about the room in ever smaller circles, creating a spiral pattern on the floor. Similar green-stone snakes wend along the walls, seemingly at random heights, and their long bodies make wave shapes.",
			"The manacles set into the walls of this room give you the distinct impression that it was used as a prison and torture chamber, although you can see no evidence of torture devices. One particularly large set of manacles -- big enough for an ogre -- have been broken open.",
			"You gaze into the room and hundreds of skulls gaze coldly back at you. They're set in niches in the walls in a checkerboard pattern, each skull bearing a half-melted candle on its head. The grinning bones stare vacantly into the room, which otherwise seems empty.",
			"Unlike the flagstone common throughout the dungeon, this room is walled and floored with black marble veined with white. The ceiling is similarly marbled, but the thick pillars that hold it up are white. A brown stain drips down one side of a nearby pillar.",
			"A huge iron cage lies on its side in this room, and its gate rests open on the floor. A broken chain lies under the door, and the cage is on a rotting corpse that looks to be a hobgoblin. Another corpse lies a short distance away from the cage. It lacks a head.",
			"This room is a tomb. Stone sarcophagi stand in five rows of three, each carved with the visage of a warrior lying in state. In their center, one sarcophagus stands taller than the rest. Held up by six squat pillars, its stone bears the carving of a beautiful woman who seems more asleep than dead. The carving of the warriors is skillful but seems perfunctory compared to the love a sculptor must have lavished upon the lifelike carving of the woman.",
			"A dim bluish light suffuses this chamber, its source obvious at a glance. Blue-glowing lichen and violet-glowing moss cling to the ceiling and spread across the floor. It even creeps down and up each wall, as if the colonies on the floor and ceiling are growing to meet each other. Their source seems to be a glowing, narrow crack in the ceiling, the extent of which you cannot gauge from your position. The air in the room smells fresh and damp.",
			"You open the door to confront a room of odd pillars. Water rushes down from several holes in the ceiling, and each hole is roughly a foot wide. The water pours in columns that fall through similar holes in the floor, flowing down to some unknown depth. Each of the eight pillars of water drops as much liquid as a stream in winter thaw. The floor is damp and looks slippery.",
			"This room smells strange, no doubt due to the weird sheets of black slime that drip from cracks in the ceiling and spread across the floor. The slime seeps from the shattered stone of the ceiling at a snails crawl, forming a mess of dangling walls of gook. As you watch, a bit of the stuff separates from a sheet and drops to the ground with a wet plop.",
			"This room is hung with hundreds of dusty tapestries. All show signs of wear: moth holes, scorch marks, dark stains, and the damage of years of neglect. They hang on all the walls and hang from the ceiling to brush against the floor, blocking your view of the rest of the room.",
			"You catch a whiff of the unmistakable metallic tang of blood as you open the door. The floor is covered with it, and splashes of blood spatter the walls. Some drops even reach the ceiling. It looks fresh, but you don't see any bodies or footprints leaving the chamber.",
			"Several round pits lie in the floor of the room before you. Spaced roughly equally apart, each is about 15 feet in diameter and appears about 20 feet deep. A lattice of thick iron bars covers the top of each pit, and each lattice has a door of iron bars that can be lifted open. The pits smell of sweat and offal.",
			"A strange ceiling is the focal point of the room before you. It's honeycombed with hundreds of holes about as wide as your head. They seem to penetrate the ceiling to some height beyond a couple feet, but you can't be sure from your vantage point.",
			"This chamber was clearly smaller at one time, but something knocked down the wall that separated it from an adjacent room. Looking into that space, you see signs of another wall knocked over. It doesn't appear that anyone made an effort to clean up the rubble, but some paths through see more usage than others.",
			"A chill wind blows against you as you open the door. Beyond it, you see that the floor and ceiling are nothing but iron grates. Above and below the grates the walls extend up and down with no true ceiling or floor within your range of vision. It's as though the chamber is a bridge through the shaft of a great well. Standing on the edge of this shaft, you feel a chill wind pass down it and over your shoulder into the hall beyond.",
			"This room is shattered. A huge crevasse shears the chamber in half, and the ground and ceilings are tilted away from it. It's as though the room was gripped in two enormous hands and broken like a loaf of bread. Someone has torn a tall stone door from its hinges somewhere else in the dungeon and used it to bridge the 15-foot gap of the chasm between the two sides of the room. Whatever did that must have possessed tremendous strength because the door is huge, and the enormous hinges look bent and mangled.",
			"A pit yawns open before you just on the other side of the door's threshold. The entire floor of the room has fallen into a second room beneath it. Across the way you can spy a door in the wall now 15 feet off the rubble-strewn floor, and near the center of the room stands a thick column of mortared stone that appears to hold the spiral staircase that leads down to what was the lower level.",
			"As the door opens, it scrapes up frost from a floor covered in ice. The room before you looks like an ice cave. A tunnel wends its way through solid ice, and huge icicles and pillars of frozen water block your vision of its farthest reaches.",
			"A 30-foot-tall demonic idol dominates this room of black stone. The potbellied statue is made of red stone, and its grinning face holds what looks to be two large rubies in place of eyes. A fire burns merrily in a wide brazier the idol holds in its lap.",
			"The door creaks open, which somewhat overshadows the sound of bubbling liquid. Before you is a room about which alchemists dream. Three tables bend beneath a clutter of bottles of liquid and connected glass piping. Several bookshelves stand nearby stuffed to overfilling with a jumble of books, jars, bottles, bags, and boxes. The alchemist who set this all up doesn't seem to be present, but a beaker of green fluid boils over a burner on one of the tables.",
			"The scent of earthy decay assaults your nose upon peering through the open door to this room. Smashed bookcases and their sundered contents litter the floor. Paper rots in mold-spotted heaps, and shattered wood grows white fungus.",
			"Several white marble busts that rest on white pillars dominate this room. Most appear to be male or female humans of middle age, but one clearly bears small horns projecting from its forehead and another is spread across the floor in a thousand pieces, leaving one pillar empty.",
			"A dozen statues stand or kneel in this room, and each one lacks a head and stands in a posture of action or defense. All are garbed for battle. It's difficult to tell for sure without their heads, but two appear to be dwarves, one might be an elf, six appear human, and the rest look like they might be orcs."
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
