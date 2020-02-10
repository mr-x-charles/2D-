package dev.mrcharles.tankwarfare.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.mrcharles.tankwarfare.Handler;
import dev.mrcharles.tankwarfare.entities.creatures.Creature;
import dev.mrcharles.tankwarfare.gfx.Animation;
import dev.mrcharles.tankwarfare.gfx.Assets;

public class Wall_Breakable extends Creature {
	private Animation explode;
	private BufferedImage wall = Assets.wall_destructible;
	private boolean destroy;
	private boolean colliding;
	public Wall_Breakable(Handler handler, float x, float y) {
		super(handler, x, y, Assets.wall_brick.getWidth(), Assets.wall_brick.getHeight());
		this.explode = new Animation(200, Assets.shell_explode);
		this.destroy = false;
	}

	@Override
	public void tick() {
		move();
		if(colliding) {
			this.destroy = true;
		}
		
	}
	@Override
	public void render(Graphics g) {
		if(destroy) {
			g.drawImage(explode.getCurrentFrame(), 
					(int) (x + handler.getGameCamera().getxOffset()), 
					(int) (y + handler.getGameCamera().getyOffset()), 
					explode.getCurrentFrame().getWidth(), 
					explode.getCurrentFrame().getHeight(), 
					null);
		}
		g.drawImage(wall, 
				(int) (x + handler.getGameCamera().getxOffset()), 
				(int) (y + handler.getGameCamera().getyOffset()), 
				wall.getWidth(), 
				wall.getHeight(), 
				null);
	}

	@Override
	public void collide() {
		this.colliding = true;
		
	}

}
