package dev.mrcharles.tankwarfare.entities;

import dev.mrcharles.tankwarfare.Handler;
import dev.mrcharles.tankwarfare.tiles.Tile;

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

	public void move() {
		moveX();
		moveY();
	}
	
	public void moveX() {
		if(xMove > 0) {//Moving right
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) && 
				!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
				x += xMove;
			} else {
				x = tx * Tile.TILEWIDTH - bounds.x - bounds.width -1;
			}
		} else if(xMove < 0) {//Moving left
			int tx = (int) (x + xMove + bounds.x) / Tile.TILEHEIGHT;
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) && 
				!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
				x += xMove;
			} else {
				x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
			}
		}
	}
	
	public void moveY() {
		if(yMove <0) {//Up
			int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
				y += yMove;
			} else {
				y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
			}
		}else if(yMove > 0) {//Down
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
				y += yMove;
			} else {
				y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
			}
		}
	}
	protected boolean collisionWithTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isSolid();
	}

}
