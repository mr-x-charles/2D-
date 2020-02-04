package dev.mrcharles.tankwarfare.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	//STATICS
	
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(0);
	public static Tile treeTile = new TreeTile(1);
	public static Tile wallTile = new WallTile(2);
	
	//CLASS
	
	public static final int TILEWIDTH = 160, TILEHEIGHT = 160;
	
	protected final int id;
	protected BufferedImage texture;
	
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture,  x,  y,  TILEWIDTH, TILEHEIGHT, null);
	}
	
	public boolean isSolid() {
		return false;
	}
	
	public int getId() {
		return id;
	}

}
