package dev.mrcharles.tankwarfare.states;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import dev.mrcharles.tankwarfare.Game;
import dev.mrcharles.tankwarfare.Handler;
import dev.mrcharles.tankwarfare.entities.Entity;
import dev.mrcharles.tankwarfare.entities.TankShell;
import dev.mrcharles.tankwarfare.entities.Wall_Breakable;
import dev.mrcharles.tankwarfare.entities.creatures.Player;
import dev.mrcharles.tankwarfare.gfx.Assets;
import dev.mrcharles.tankwarfare.gfx.Hud;
import dev.mrcharles.tankwarfare.tiles.Tile;
import dev.mrcharles.tankwarfare.worlds.Level;
import dev.mrcharles.tankwarfare.worlds.World;

public class GameState extends State {
	
	private Player player;
	private World world;
	private Hud hud;
	private Level level;
	private int ReloadClock;
	private TankShell shell;
	private ArrayList<Entity> entities;
	
	
	public GameState(Handler handler) {
		super(handler);
		entities = new ArrayList<Entity>();
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
		hud = new Hud(handler);
		shell = new TankShell(handler, 1, 1, 1, 1, 1);
		Wall_Breakable wall = new Wall_Breakable(handler, 300, 300);
		player = new Player(handler, 100,100, shell);
		level = new Level(handler, "res/worlds/level1.txt");
		entities.add(player);
		entities.add(shell);
		entities.add(wall);
	}

	public void tick() {
		world.tick();
		player.tick();
		
		
	}

	public void render(Graphics g) {
		world.render(g);
		level.render(g);
		ReloadClock = player.getReloadClock();
		hud.render(g, ReloadClock, (int) shell.getX(), (int) shell.getY(), (int) player.getX(), (int) player.getY(), player.isFiring(), player.getLifetimes(), player.getAmmo());
		player.render(g);
	}

	@Override
	public ArrayList<Entity> getEntities() {
		return this.entities;
	}
	

}
