package dev.mrcharles.tankwarfare.gfx;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Rotator {
	private BufferedImage image;
	public Rotator(BufferedImage image) {
		this.image = image;
	}
	public BufferedImage rotate(double angle) {
		double sin = Math.abs(Math.sin(Math.toRadians(angle))),
			     cos = Math.abs(Math.cos(Math.toRadians(angle)));
		int w = image.getWidth(null), h = image.getHeight(null);
		int neww = (int) Math.floor(w*cos + h*sin),
		      newh = (int) Math.floor(h*cos + w*sin);
		BufferedImage bimg = new BufferedImage(neww, newh, image.getType());
		Graphics2D g = bimg.createGraphics();
		g.translate((neww-w)/2, (newh-h)/2);
		g.rotate(Math.toRadians(angle), w/2, h/2);
		g.drawRenderedImage(image, null);
		g.dispose();
		this.image = bimg;
		return this.image;
	}

}
