import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Scene extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9188979244758775638L;
	private int XAXIS_OF_ENEMY = 10;
	private int YAXIS_OF_ENEMY = 10;
	public int widhtOfScene = 1024;
	public int heightOfScene = 768;

	JFrame window = new JFrame("FunCar Game");
	public JLabel score = new JLabel("Fuel Tanks Collected: 0");
	Player player = new Player(8, 8, "images//car_right.png", true, 0);
	KeyEvents keyEvents = new KeyEvents(player, this);
	Enemy ecar1 = new Enemy(XAXIS_OF_ENEMY + 32, YAXIS_OF_ENEMY + 122, "images//enemy_right.png", this, player);
	Enemy ecar2 = new Enemy(XAXIS_OF_ENEMY + 128, YAXIS_OF_ENEMY + 506, "images//enemy_right.png", this, player);
	Enemy ecar3 = new Enemy(XAXIS_OF_ENEMY + 512, YAXIS_OF_ENEMY + 314, "images//enemy_right.png", this, player);
	Collectable good = new Collectable(500, 250, "images//fuel.png", player, this);

	public Scene() {
		window.addKeyListener(keyEvents);
		window.setFocusable(true);
		window.add(this, BorderLayout.CENTER);
		window.add(score, BorderLayout.NORTH);
		Thread thread = new Thread(ecar1);
		thread.start(); // It basically calls the run method
		Thread thread2 = new Thread(ecar2);
		thread2.start();
		Thread thread3 = new Thread(ecar3);
		thread3.start();

		Thread fuel = new Thread(good);
		fuel.start();
		window.setSize(widhtOfScene, heightOfScene);
		window.setIconImage(new ImageIcon("images//Logo.png").getImage());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);

	}

	public void paint(Graphics graphics) {
		ImageIcon imageIcon = new ImageIcon("images//concrete_ground.jpg");
		graphics.drawImage(imageIcon.getImage(), 0, 0, null);
		good.drawObject(graphics);
		ecar1.drawObject(graphics);
		ecar2.drawObject(graphics);
		ecar3.drawObject(graphics);
		player.drawObject(graphics);
	}
}
