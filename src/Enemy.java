import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JOptionPane;

public class Enemy extends GameObject implements Runnable {

	private Scene scene;
	Random random = new Random();
	private Player player;
	private float speed = 3.0f;
	private float acceleration = 0.33f;
	public int direction = 1; // Assuming, my enemy is facing right. Right is 1 and left would be -1

	public Enemy(int xAxis, int yAxis, String imagePath, Scene scene, Player player) {
		super(xAxis, yAxis, imagePath);
		this.scene = scene;
		this.player = player;
	}

	/*
	 * I will make the game end??? Let's say restart the scene.
	 */
	public void kill() {
		Rectangle carColRect = new Rectangle(player.getxAxis(), player.getyAxis(), 50, 50);
		Rectangle enemyCarRect = new Rectangle(this.getxAxis(), this.getyAxis(), 50, 50);
		// System.out.println("Enemy's (X, Y): (" + getxAxis() + ", " + getyAxis() + ",
		// " + getImagePath() + ")");
		// System.out.println("Player's (X, Y): (" + player.getxAxis() + ", " +
		// player.getyAxis() + ", "
		// + player.getImagePath() + ")");
		if (carColRect.contains(enemyCarRect) || carColRect.intersects(enemyCarRect)) {
			JOptionPane.showMessageDialog(null, "Crashed! Fuel Collected: " + player.getScore() + " Liters");
			System.out.println("I died");
			System.exit(0);
		}

	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(random.nextInt(100));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Thread interrupted");
				System.exit(1);
			}

			if (getxAxis() <= new Random().nextInt(50)) {
				direction = 1;
				speed = 3;
				setImagePath("images//enemy_right.png");
			} else if (getxAxis() >= 900) {
				direction = -1;
				speed = 3;
				setImagePath("images//enemy_left.png");
			}

			kill();
			setXAxis((int) (getxAxis() + speed * direction));
			speed += acceleration;
			scene.repaint();

		}
	}
}
