import javax.swing.JOptionPane;

public class Player extends GameObject {

	private boolean isAlive;
	private int score;

	public Player(int xAxis, int yAxis, String imagePath, boolean isAlive, int score) {
		super(xAxis, yAxis, imagePath);
		setAlive(isAlive);
		setScore(score);
	}

	@Override
	public void setXAxis(int xAxis) {
		// My player to remain on the screen while he is alive
		if (xAxis > 974 || xAxis < 0) {
			JOptionPane.showMessageDialog(null, "Crashed with Wall! Fuel Collected: " + this.getScore() + " Liters");
			System.out.println("Outside");
			System.exit(0);
		}
		if (isAlive) {
			super.setXAxis(xAxis);
		}

	}

	@Override
	public void setYAxis(int yAxis) {
		// My player to remain on the screen while he is alive
		if (yAxis > 718 || yAxis < 0) {
			JOptionPane.showMessageDialog(null, "Crashed with Wall! Fuel Collected: " + this.getScore() + " Liters");
			System.out.println("Outside");
			System.exit(0);
		}
		if (isAlive) {
			super.setYAxis(yAxis);
		}

	}

	public boolean isAlive() {
		return isAlive;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
}
