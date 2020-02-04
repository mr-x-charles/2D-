package dev.mrcharles.tankwarfare.entities.creatures;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import dev.mrcharles.tankwarfare.Handler;
import dev.mrcharles.tankwarfare.entities.TankShell;
import dev.mrcharles.tankwarfare.gfx.Animation;
import dev.mrcharles.tankwarfare.gfx.Assets;

public class Player extends Creature {
	
	//Animations
	private Animation animFire;
	
	private int reloadClock;
	public int getReloadClock() {
		return reloadClock;
	}

	private boolean reloading = true;
	private boolean firing = false;
	private BufferedImage TankFrame = Assets.tank_frame_a;
	private double FrameAngle;
	private double TurretAngle;
	private boolean turning;
	private TankShell shell;
	

	public Player(Handler handler, float x, float y, TankShell shell) {
		super(handler, x, y, 112, 197);
		this.shell = shell;
		bounds.x = 16;
		bounds.y = 32;
		bounds.width = 32;
		bounds.height = 32;
		//Animations
		animFire = new Animation(200, Assets.tank_fire);
		FrameAngle = 0;
		TurretAngle = Math.PI/2;
		shell.setX(x - handler.getGameCamera().getxOffset() + 50);
		shell.setY(y - handler.getGameCamera().getyOffset() - 100);
	}

	public void tick() {	
		//Animations
		animFire.tick();
		//Movement
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
		//Logic
		//RELOADING IS VERY QUESTIONABLE... NEEDS POLISHING
		if(reloading == true) {
			reloadClock += 1;
			if(reloadClock > 500) {
				reloading = false;
			}
		}
		else if(firing == true) {
			reloadClock += 1;
			if(reloadClock > 505) {
				firing = false;
				reloadClock = 0;
				reloading = true;
			}
		}
		else {
			if(handler.getKeyManager().space && reloading == false) {
				firing = true;
				shell.setX1((x - handler.getGameCamera().getxOffset()) + Assets.tank_gun_a.getWidth()/2 + 15);
				shell.setY1((y - handler.getGameCamera().getyOffset()) + Assets.tank_gun_a.getHeight()/2);
				shell.setX((x - handler.getGameCamera().getxOffset()) + 60);
				shell.setY((y - handler.getGameCamera().getyOffset()) + 200);
				shell.setWaiting(false);
			}
		}
	}
	
	private void getInput() {
		xMove = 0;
		yMove = 0;

		if(handler.getKeyManager().up && turning == false) {
			xMove = (float) (Math.cos(FrameAngle + Math.PI/2) * 0.5);
			yMove = (float) (Math.sin(FrameAngle + Math.PI/2) * 0.5);
		}
		else if(handler.getKeyManager().down && turning == false) {
			xMove = -(float) (Math.cos(FrameAngle + Math.PI/2) * 0.5);
			yMove = -(float) (Math.sin(FrameAngle + Math.PI/2) * 0.5);
		}
		else if(handler.getKeyManager().left) {	
			FrameAngle += Math.toRadians(0.5);
			turning = true;
		}
		else if(handler.getKeyManager().right) {
			FrameAngle -= Math.toRadians(0.5);
			turning = true;
		}
		else {
			turning = false;
		}
		if(handler.getKeyManager().ArrowLeft) {
			TurretAngle += Math.toRadians(0.6);
		}
		else if(handler.getKeyManager().ArrowRight) {
			TurretAngle -= Math.toRadians(0.6);
		}
	}
	@Override
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		AffineTransform oldXForm = g2d.getTransform();
		g2d.rotate(FrameAngle, (int) (x - handler.getGameCamera().getxOffset()) + (TankFrame.getWidth()/2), 
		(int) (y - handler.getGameCamera().getyOffset()) + (TankFrame.getHeight()/2));
		g.drawImage(TankFrame, (int) (x - handler.getGameCamera().getxOffset()), 
				(int) (y - handler.getGameCamera().getyOffset()), width, height ,null);
		g2d.rotate(TurretAngle - Math.toRadians(90), (int) (x - handler.getGameCamera().getxOffset()) + (TankFrame.getWidth()/2), 
		(int) (y - handler.getGameCamera().getyOffset()) + (TankFrame.getHeight()/2));
		g.drawImage(Assets.tank_gun_a, (int) (x - handler.getGameCamera().getxOffset()) + 10, 
				(int) (y - handler.getGameCamera().getyOffset()) + 40, null);
		if((handler.getKeyManager().space) && (reloading == false)) {
			g.drawImage(animFire.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()) + 30, (int)
					(y - handler.getGameCamera().getyOffset()) + 200, null);
		}
		g.drawLine((int) (x - handler.getGameCamera().getxOffset()) + Assets.tank_gun_a.getWidth()/2 + 15, 
				(int) (y - handler.getGameCamera().getyOffset()) + Assets.tank_gun_a.getHeight()/2, 
				(int) (x - handler.getGameCamera().getxOffset()) + 60, 
				(int) (y - handler.getGameCamera().getyOffset()) + 200);
		shell.render(g2d);
		g2d.setTransform(oldXForm);
// For debugging of bounding boxes for collision uncomment the below lines	
//		g.setColor(Color.red);
//		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), 
//				(int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
	}
}
