package dev.mrcharles.tankwarfare.worlds;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import dev.mrcharles.tankwarfare.Handler;
import dev.mrcharles.tankwarfare.entities.creatures.Creature;
import dev.mrcharles.tankwarfare.utils.Utils;

public class Level {
	
	private Handler handler;
	private int width; 
	private int height;
	private int[][] spawns;
	
	public Level(Handler handler, String path) {
		this.handler = handler;
		loadLevel(path);
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
	}
	
	public Creature getSpawn(int x, int y) {
		return null;
	}
	
	private void loadLevel(String path) {
		Spawn[] spawns = new Spawn[500];
		
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		for (int i = 0; i < tokens.length % 3 - 1; i += 3) {
			spawns[i] = new Spawn(Utils.parseInt(tokens[i]), Utils.parseInt(tokens[i + 1]), Utils.parseInt(tokens[i + 2]));
		}
		for(Spawn s : spawns) {
			System.out.println(s);
		}
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}


}
