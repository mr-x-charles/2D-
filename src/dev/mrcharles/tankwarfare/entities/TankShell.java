package dev.mrcharles.tankwarfare.entities;

import java.awt.Graphics;
import java.awt.Graphics2D;

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
		lifeTime = 100000;
		Explode = new Animation(200, Assets.shell_explode);
		exploding = false;
		exploded = false;
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
		if(this.lifeTime < 1) {
			this.explode();
		}
		else if(this.lifeTime < 50) {
			this.exploded = true;
		}
		if(!waiting){
			this.lifeTime--;
		}
		
	}

	public boolean isExploded() {
		return exploded;
	}
	private void explode() {
		this.exploding = true;
		
	}
	@Override
	public void render(Graphics g2d) {
		((Graphics2D) g2d).rotate(Math.toRadians(180), (int) (x + Assets.tank_shell.getWidth()/2 +
				handler.getGameCamera().getxOffset()), (int) (x + Assets.tank_shell.getHeight()/2) + handler.getGameCamera().getyOffset());
		g2d.drawImage(Assets.tank_shell, (int) x, (int) y, width, height, null);
		if(exploding) {
			g2d.drawImage(this.Explode.getCurrentFrame(), (int) x, (int) y, null);
		}
		g2d.dispose();
	}

	public void setAngle(double angle) {
		this.angleOfFire = angle;
		
	}

}
