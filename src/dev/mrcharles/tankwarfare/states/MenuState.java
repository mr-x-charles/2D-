package dev.mrcharles.tankwarfare.states;

import java.awt.Graphics;
import java.util.ArrayList;

import dev.mrcharles.tankwarfare.Game;
import dev.mrcharles.tankwarfare.Handler;
import dev.mrcharles.tankwarfare.entities.Entity;

public class MenuState extends State {

	public MenuState(Handler handler) {
		super(handler);
		
	}
	public void tick() {
		
	}

	public void render(Graphics g) {
		g.drawString("Welcome to Tank Warfare - go commit you phat ret", 400, 400	 );
	}
	@Override
	public ArrayList<Entity> getEntities() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
