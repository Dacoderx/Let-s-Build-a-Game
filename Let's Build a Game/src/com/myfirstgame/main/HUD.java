package com.myfirstgame.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HUD {
	public int bounds = 0;
	public static float HEALTH = 100;
	private float greenValue = 255;
	private int score = 0;
	private int level = 1;
	public void tick(){
		HEALTH = (int) Game.clamp(HEALTH, 0, 100+(bounds/2));
		greenValue = HEALTH*2;
		greenValue = (int) Game.clamp(greenValue, 0, 255);
		score++;
	}
	public void render(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(215, 15, 200 + bounds, 32);
		g.setColor(new Color(75, (int)greenValue, 0));
		g.fillRect(215, 15, (int)HEALTH * 2, 32);
		g.setColor(Color.WHITE);
		g.drawRect(215, 15, 200 + bounds, 32);
		g.setFont(new Font("arial", 0, 18));
		g.drawString("Score: " + score, 7, 420);
		g.drawString("Level: " + level, 7, 440);	
				
	}
	void setScore(int score) {
		this.score = score;
	}
	public int getScore() {
		return score;
	}
	public int getLevel(){
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
}
