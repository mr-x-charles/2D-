package dev.mrcharles.tankwarfare.gfx;

import java.awt.Graphics;

import dev.mrcharles.tankwarfare.Handler;

public class Hud {

	private Handler handler;

	public Hud(Handler handler) {
		this.handler = handler;
	}

	public void render(Graphics g, int reloadClock, int shellX, int shellY, int playerX, int playerY, boolean firing, int[] lifetimes, int tank_ammo) {
		g.drawString("Reload Time: " + reloadClock, 10, 15);
		g.drawString("No. Shells: " + tank_ammo, 200, 15);
		g.drawString("SHELL X: " + shellX + ", Y: " + shellY, 10, 25);
		g.drawString("PLAYER X: " + playerX + ", Y: " + playerY, 10, 35);
		g.drawString("Am I firing?: " + firing, 10, 45);
		int i = 0;
		if(lifetimes != null) {
			for(int life : lifetimes) {
				g.drawString("Shell: " + i + ", LifeTime: " + life, 10, 55 + i * 10);
			}
		}
	}

}
