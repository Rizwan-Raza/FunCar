import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEvents implements KeyListener {

	private Player player;
	private Scene scene;
	private String lastMove = "right";

	private int speed = 5;
	private int acceleration = 1;

	public KeyEvents(Player player, Scene scene) {
		this.scene = scene;
		this.player = player;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent keyEvent) {
		switch (keyEvent.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			if (lastMove != "left") {
				speed = 5;
			}
			player.setXAxis(player.getxAxis() - speed);
			lastMove = "left";
			break;
		case KeyEvent.VK_RIGHT:
			if (lastMove != "right") {
				speed = 5;
			}
			player.setXAxis(player.getxAxis() + speed);
			lastMove = "right";
			break;
		case KeyEvent.VK_UP:
			if (lastMove != "up") {
				speed = 5;
			}
			player.setYAxis(player.getyAxis() - speed);
			lastMove = "up";
			break;
		case KeyEvent.VK_DOWN:
			if (lastMove != "down") {
				speed = 5;
			}
			player.setYAxis(player.getyAxis() + speed);
			lastMove = "down";
			break;

		default:
			break;
		}
		player.setImagePath("images//car_" + lastMove + ".png");
		speed += acceleration;
		scene.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
}
