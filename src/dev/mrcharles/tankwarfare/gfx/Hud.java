package dev.mrcharles.tankwarfare.gfx;

import java.awt.Graphics;

import dev.mrcharles.tankwarfare.Handler;

public class Hud {

	private Handler handler;

	public Hud(Handler handler) {
		this.handler = handler;
	}

	public void render(Graphics g, int reloadClock, int shellX, int shellY, int playerX, int playerY) {
		g.drawString("Reload Time: " + reloadClock, 10, 15);
		g.drawString("SHELL X: " + shellX + ", Y: " + shellY, 10, 25);
		g.drawString("PLAYER X: " + playerX + ", Y: " + playerY, 10, 35);
	}

}
