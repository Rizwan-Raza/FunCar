import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JOptionPane;

public class Collectable extends GameObject implements Runnable {

	private Player player;
	private Scene scene;
	Random random = new Random();

	public Collectable(int xAxis, int yAxis, String imagePath, Player player, Scene scene) {
		super(xAxis, yAxis, imagePath);
		this.player = player;
		this.scene = scene;
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
			if (checkForCollision()) {
				setXAxis(random.nextInt(900));
				setYAxis(random.nextInt(650));
				player.setScore(player.getScore() + 1);
				scene.score.setText("Fuel Tanks Collected: " + player.getScore());
				scene.repaint();
			}
		}
	}

	public boolean checkForCollision() {
		Rectangle carColRect = new Rectangle(player.getxAxis(), player.getyAxis(), 50, 50);
		Rectangle fuelRect = new Rectangle(this.getxAxis(), this.getyAxis(), 50, 50);
		System.out.println("Fuel's (X, Y): (" + getxAxis() + ", " + getyAxis() + ", " + getImagePath() + ")");
		System.out.println("Player's (X, Y): (" + player.getxAxis() + ", " + player.getyAxis() + ", "
				+ player.getImagePath() + ")");
		if (carColRect.contains(fuelRect) || carColRect.intersects(fuelRect)) {
			System.out.println("Collected");
			return true;
		}
		return false;
	}
}
