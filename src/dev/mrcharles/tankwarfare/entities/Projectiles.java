package dev.mrcharles.tankwarfare.entities;

import dev.mrcharles.tankwarfare.Handler;

public abstract class Projectiles extends Entity{
	
	protected float xMove, yMove;
	protected int damage;
	protected float speed;
	protected double angleOfFire;
	protected float x1, y1;
	
	
	
	public Projectiles(Handler handler, float x, float y, int width, int height, float x1, float y1, float speed) {
		super(handler, x, y, width, height);
		this.speed = speed;
		this.x1 = x1;
		this.y1 = y1;
		this.xMove = 0;
		this.yMove = 0;
	}

	public float getX1() {
		return x1;
	}

	public void setX1(float x1) {
		this.x1 = x1;
	}

	public float getY1() {
		return y1;
	}

	public void setY1(float y1) {
		this.y1 = y1;
	}

	public void move(int x, int y) {
		this.xMove = x;
		this.yMove = y;
		moveX();
		moveY();
	}
	
	public void moveX() {
		this.x += this.xMove;
	}
	
	public void moveY() {
		this.y +=this.yMove;
	}

}
