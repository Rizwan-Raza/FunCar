import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class GameObject {
	private int xAxis;
	private int yAxis;
	private String imagePath;

	public GameObject(int xAxis, int yAxis, String imagePath) {
		setXAxis(xAxis);
		setYAxis(yAxis);
		setImagePath(imagePath);
	}

	public void setImagePath(String imagePath) {
		if (imagePath == null) {
			JOptionPane.showMessageDialog(null, "Image is null");
			System.exit(1);
		} else
			this.imagePath = imagePath;
	}

	public void setXAxis(int xAxis) {
		// I will be able to move in a certain bound
		// I want a window of 974 pixels
		if (this.xAxis >= 974) {
			this.xAxis = 974;
		} else if (this.xAxis < 0) {
			this.xAxis = 0;
		} else
			this.xAxis = xAxis; // This only happens when my player is in the window
	}

	public void setYAxis(int yAxis) {
		// I will be able to move in a certain bound
		// I want a window of 718 pixels
		if (this.yAxis >= 718) {
			this.yAxis = 718;
		} else if (this.yAxis < 0) {
			this.yAxis = 0;
		} else
			this.yAxis = yAxis; // This only happens when my player is in the window
	}

	public int getyAxis() {
		return yAxis;
	}

	public int getxAxis() {
		return xAxis;
	}

	public String getImagePath() {
		return imagePath;
	}

	// This function will allow me to draw the object image!
	public void drawObject(Graphics graphics) {
		ImageIcon img = new ImageIcon(imagePath);
		graphics.drawImage(img.getImage(), this.xAxis, this.yAxis, null);
	}

}
