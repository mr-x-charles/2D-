package dev.mrcharles.tankwarfare.gfx;

import java.awt.image.BufferedImage;

public class spritesheet {
	private BufferedImage sheet;
	
	public spritesheet(BufferedImage sheet) {
		this.sheet = sheet;
	}
	public BufferedImage crop(int x, int y, int width, int height) {
		return sheet.getSubimage(x, y, width, height);
	}

}
