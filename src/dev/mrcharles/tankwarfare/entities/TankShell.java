package dev.mrcharles.tankwarfare.entities;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

import dev.mrcharles.tankwarfare.Handler;
import dev.mrcharles.tankwarfare.gfx.Animation;
import dev.mrcharles.tankwarfare.gfx.Assets;

public class TankShell extends Projectiles {
	
	private int lifeTime;
	private Animation Explode;
	private boolean exploding;
	private boolean exploded;
	private boolean waiting;
	private double angleOfFire;
	
	public TankShell(Handler handler, float x, float y, float x1, float y1,
			float speed) {
		super(handler, x, y, Assets.tank_shell.getWidth(), Assets.tank_shell.getHeight(), x1, y1, speed);
		lifeTime = 0;
		Explode = new Animation(1, Assets.shell_explode);
		waiting = false;
		
	}

	public boolean isWaiting() {
		return waiting;
	}

	public void setWaiting(boolean waiting) {
		this.waiting = waiting;
	}

	@Override
	public void tick() {
		if(waiting == true) {
			lifeTime += 1;
			move();
			if(lifeTime > 100) {
				this.explode();
			}
		}
		else if(waiting == false) {
			lifeTime = 0;
		}
		
	}

	public boolean isExploded() {
		return this.exploded;
	}
	private void explode() {
		this.exploding = true;
		this.exploded = true;
		
	}
	@Override
	public void render(Graphics g2d) {
		((Graphics2D) g2d).rotate(Math.toRadians(180) + this.angleOfFire, (int) (x + Assets.tank_shell.getWidth()/2), (int) (x + Assets.tank_shell.getHeight()/2));
		g2d.drawImage(Assets.tank_shell, (int) (x),
				(int) (y), null);
		g2d.drawImage(this.Explode.getCurrentFrame(), (int) x, (int) y, null);
		g2d.dispose();
	}

	public void setAngle(double angle) {
		this.angleOfFire = angle - Math.toRadians(110);
		
	}

	public int getLifeTime() {
		return lifeTime;
	}

	public void setVector(float x, float y, float x1, float y1) {
		this.x = x;
		this.y = y;
		this.x1 = x1;
		this.y1 = y1;
		this.xMove = (x1 - x) * this.speed;
		this.yMove = (y1 - y) * this.speed;
	}



}
