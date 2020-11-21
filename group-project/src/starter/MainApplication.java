package starter;

public class MainApplication extends GraphicsApplication {
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	public static final int BUTTON_WIDTH = 400;
	public static final int BUTTON_HEIGHT = 75;
	public static final int ROW_ALIENS = 3;
	public static final int COLUMN_ALIENS = 8;
	public static final int TIMER_SPEED = 10; //bigger = slower, smaller = faster
	public static final int ALIEN_MODULUS = 9;
	public static final int LASER_MODULUS = 50;
	public static final int LASER_SPEED = 5; //bigger = faster, smaller = slower
	public static final String MUSIC_FOLDER = "sounds";
	private static final String[] SOUND_FILES = { "r2d2.mp3", "somethinlikethis.mp3", "alienlaser.mp3" };

	private GamePane gamePane;
	private ExitPane exitPane;
	private WinPane winPane;
	private MenuPane menu;
	private LosePane losePane;
	private int count;

	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	public void run() {
		System.out.println("Hello, world!");
		exitPane = new ExitPane(this);
		menu = new MenuPane(this);
		switchToMenu();
	}

	public void switchToWin() {
		winPane = new WinPane(this);
		switchToScreen(winPane);
	}
	
	public void switchToLose() {
		losePane = new LosePane(this);
		switchToScreen(losePane);
	}
	
	public void switchToMenu() { //switches to menu screen
		//playRandomSound();
		count++;
		switchToScreen(menu);
	}

	public void switchToGame() { //switches to game screen
		//playRandomSound();
		gamePane = new GamePane(this);
		switchToScreen(gamePane);
	}
	
	public void switchToExit() { //switches to exit screen
		//playRandomSound();
		switchToScreen(exitPane);
	}

	private void playRandomSound() {
		AudioPlayer audio = AudioPlayer.getInstance();
		audio.playSound(MUSIC_FOLDER, SOUND_FILES[count % SOUND_FILES.length]);
	}
	
	/*
	 * private void playAlienLaser() { AudioPlayer audio =
	 * AudioPlayer.getInstance(); audio.playSound(MUSIC_FOLDER, SOUND_FILES[2]); }
	 */
	
}
