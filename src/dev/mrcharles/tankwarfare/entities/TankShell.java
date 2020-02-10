package dev.mrcharles.tankwarfare.entities;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

import dev.mrcharles.tankwarfare.Handler;
import dev.mrcharles.tankwarfare.gfx.Animation;
import dev.mrcharles.tankwarfare.gfx.Assets;

public class TankShell extends Projectiles {
	
	private int lifeTime;
	private boolean waiting;
	private double angleOfFire;
	private AffineTransform transform;
	
	public TankShell(Handler handler, float x, float y, float x1, float y1,
			float speed) {
		super(handler, x, y, Assets.tank_shell.getWidth(), Assets.tank_shell.getHeight(), x1, y1, speed);
		lifeTime = 0;
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
		}
		else if(waiting == false) {
			lifeTime = 0;
		}
		
	}
	@Override
	public void render(Graphics g2d) {
		((Graphics2D) g2d).transform(this.transform);
		g2d.drawImage(Assets.tank_shell, (int) (x + this.width),
				(int) (y + this.height), null);
		g2d.dispose();
	}

	public void setAngle(double angle) {
		this.angleOfFire = angle;
		
	}

	public int getLifeTime() {
		return lifeTime;
	}

	public void setVector(double angle, float x, float y, float x1, float y1) {
		this.xMove += Math.cos(angle) * speed;
		this.yMove += Math.sin(angle) * speed;
		setAngle(angle - Math.PI/2);
	}

	public void setTransform(AffineTransform transform) {
		this.transform = transform;
		
	}



}
