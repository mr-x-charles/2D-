package dev.mrcharles.tankwarfare.states;

import java.awt.Graphics;
import java.util.ArrayList;

import dev.mrcharles.tankwarfare.Game;
import dev.mrcharles.tankwarfare.Handler;
import dev.mrcharles.tankwarfare.entities.Entity;

public abstract class State {
	
	private static State currentState = null;
	
	public static void setState(State state) {
		currentState = state;
	}
	public static State getState() {
		return currentState;
	}
	//CLASS
	protected Handler handler;
	public State(Handler handler) {
		this.handler = handler;
	}
	public abstract void tick();
	
	public abstract void render(Graphics g);
	public abstract ArrayList<Entity> getEntities();
	
	
	
}
