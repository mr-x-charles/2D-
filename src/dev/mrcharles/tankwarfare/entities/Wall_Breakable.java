package dev.mrcharles.tankwarfare.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.mrcharles.tankwarfare.Handler;
import dev.mrcharles.tankwarfare.gfx.Animation;
import dev.mrcharles.tankwarfare.gfx.Assets;

public class Wall_Breakable extends Entity {
	private Animation explode;
	private BufferedImage wall = Assets.wall_brick;
	private boolean destroy;
	public Wall_Breakable(Handler handler, float x, float y) {
		super(handler, x, y, Assets.wall_brick.getWidth(), Assets.wall_brick.getHeight());
		this.explode = new Animation(200, Assets.shell_explode);
		this.destroy = false;
	}

	@Override
	public void tick() {
		if(handler.checkCollision(this)) {
			this.destroy = true;
		}
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(wall, (int) x, (int) y, wall.getWidth(), wall.getHeight(), null);
		if(this.destroy) {
			g.drawImage(explode.getCurrentFrame(), (int) x + wall.getWidth()/2, (int) y + wall.getHeight()/2,
					explode.getCurrentFrame().getWidth(), explode.getCurrentFrame().getHeight(), null);
		}
	}

}
