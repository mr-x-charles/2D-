package dev.mrcharles.tankwarfare;

import dev.mrcharles.tankwarfare.entities.Entity;
import dev.mrcharles.tankwarfare.entities.Wall_Breakable;
import dev.mrcharles.tankwarfare.gfx.GameCamera;
import dev.mrcharles.tankwarfare.input.KeyManager;
import dev.mrcharles.tankwarfare.worlds.World;

public class Handler {
	
	private Game game;
	private World world;
	
	public Handler(Game game) {
		this.game = game;
		
	}
	
	public GameCamera getGameCamera() {
		return game.getGameCamera();
	}
	
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}
	
	public int getWidth() {
		return game.getWidth();
	}
	
	public int getHeight() {
		return game.getHeight();
	}
	
	public Game getGame() {
		return game;
	}
	
	public void setGame(Game game) {
		this.game = game;
	}
	
	public World getWorld() {
		return world;
	}
	
	public void setWorld(World world) {
		this.world = world;
	}

	public boolean checkCollision(Entity entity) {
		for(Entity e : game.getEntities()) {
			if(e.getX() - entity.getX() > 0 && e.getX() - entity.getX() < 20) {
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}

}
