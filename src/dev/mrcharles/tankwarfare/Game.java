package dev.mrcharles.tankwarfare;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import dev.mrcharles.tankwarfare.display.Display;
import dev.mrcharles.tankwarfare.entities.Entity;
import dev.mrcharles.tankwarfare.gfx.Assets;
import dev.mrcharles.tankwarfare.gfx.GameCamera;
import dev.mrcharles.tankwarfare.gfx.ImageLoader;
import dev.mrcharles.tankwarfare.gfx.spritesheet;
import dev.mrcharles.tankwarfare.input.KeyManager;
import dev.mrcharles.tankwarfare.states.GameState;
import dev.mrcharles.tankwarfare.states.MenuState;
import dev.mrcharles.tankwarfare.states.SettingsState;
import dev.mrcharles.tankwarfare.states.State;

public class Game implements Runnable{
	private Display display;
	private int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	//States
	private long timer = 0;
	private State gameState;
	private State menuState;
	private State settingsState;
	
	//Input
	private KeyManager keyManager;
	
	//Camera
	private GameCamera gameCamera;
	
	//Handler
	
	private Handler handler;
	private ArrayList<Entity> entities;
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
 		this.title = title;
		keyManager = new KeyManager();
	}
	private void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		
		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0,0);
		
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		settingsState = new SettingsState(handler);
		State.setState(gameState);
		this.entities = gameState.getEntities();
	}
	private void tick() {
		keyManager.tick();
		
		if(State.getState() != null) {
			State.getState().tick();
		}
	}
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//Clear Screen
		g.clearRect(0, 0, width, height);
		//Draw Objects Section
		if(State.getState() != null) {
			State.getState().render(g);
		}
		g.setColor(Color.WHITE);
		//End of Drawing
		bs.show();
		g.dispose();
	}
	public long getTimer() {
		return timer;
	}
	public void setTimer(long timer) {
		this.timer = timer;
	}
	public void run() {
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			if(delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}
			if(timer >= 1000000000) {
				System.out.println("tick and frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public GameCamera getGameCamera() {
		return gameCamera;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public synchronized void start() {
		if(running) return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	public synchronized void stop() {
		if(!running) return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public ArrayList<Entity> getEntities() {
		return this.entities;
	}
}
