
public class TestSplashCard {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		SplashCard sc = new SplashCard(null, 0, false, null);
		ProgressBar pb = new ProgressBar(50);
		sc.setWelcome("Please press any key to continue...");
		System.out.println(sc.getWelcome());
		sc.getInput();
		System.out.println("Loading");
		for (int i = 0; i <= 50; i++) {
            Thread.sleep(100);
            pb.printProcessBar(2*i);
        }
        System.out.println();
		sc.setMainMenu("   _____       .___                    __                               \r\n  /  _  \\    __| _/__  __ ____   _____/  |_ __ _________   ____   ______\r\n /  /_\\  \\  / __ |\\  \\/ // __ \\ /    \\   __\\  |  \\_  __ \\_/ __ \\ /  ___/\r\n/    |    \\/ /_/ | \\   /\\  ___/|   |  \\  | |  |  /|  | \\/\\  ___/ \\___ \\ \r\n\\____|__  /\\____ |  \\_/  \\___  >___|  /__| |____/ |__|    \\___  >____  >\r\n        \\/      \\/           \\/     \\/                        \\/     \\/ \r\n___________.__                              .__     \r\n\\__    ___/|  |_________  ____  __ __  ____ |  |__  \r\n  |    |   |  |  \\_  __ \\/  _ \\|  |  \\/ ___\\|  |  \\ \r\n  |    |   |   Y  \\  | \\(  <_> )  |  / /_/  >   Y  \\\r\n  |____|   |___|  /__|   \\____/|____/\\___  /|___|  /\r\n                \\/                  /_____/      \\/ \r\n___________.__                \r\n\\__    ___/|__| _____   ____  \r\n  |    |   |  |/     \\_/ __ \\ \r\n  |    |   |  |  Y Y  \\  ___/ \r\n  |____|   |__|__|_|  /\\___  >\r\n                    \\/     \\/ "); 


		System.out.println(sc.getMainMenu());
	}

}
