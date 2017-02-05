package com.myfirstgame.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Shop extends MouseAdapter {
	Handler handler;
	HUD hud;
	private int B1 = 500;
	private int B2 = 500;
	private int B3 = 750;
	public Shop(Handler handler, HUD hud, Game game){
		this.handler = handler;
		this.hud = hud;
	}
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.setFont(new Font("arial", 0, 48));
		g.drawString("SHOP", 245, 50);
		//box 1
		g.setFont(new Font("arial", 0, 14));
		g.drawString("Upgrade Health", 115, 120);
		g.drawString("Cost: " + B1, 115, 140);
		g.drawRect(110, 100, 110, 80);
		//box 2
		g.drawString("Upgrade Speed", 265, 120);
		g.drawString("Cost: " + B2, 265, 140);
		g.drawRect(260, 100, 110, 80);
				//box 3
		g.drawString("Refill Health", 415, 120);
		g.drawString("Cost: " + B3, 415, 140);
		g.drawRect(410, 100, 110, 80);
		g.setFont(new Font("arial", 0, 18));
		g.drawString("SCORE: " + hud.getScore(), 7, 420);
		g.setFont(new Font("arial", 0, 22));
		g.drawString("Press space to go back!", 205, 280);
	}
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		//box 1
		if(mx >= 100 && mx <= 200){
			if(my >= 100 && my <= 180) {
				//You've selected box 1
				if(hud.getScore() >= B1){
					hud.setScore(hud.getScore() - B1);
					B1 += 500;
					hud.bounds += 20;
				}
			}
		}
		//box 2
		if(mx >= 250 && mx <= 350){
			if(my >= 100 && my <= 180) {
				//You've selected box 2
				//this
				if(hud.getScore() >= B2){
					hud.setScore(hud.getScore() - B2);
					B2 += 500;
					handler.spd++;
				}
			}
		}
		//box 3
		if(mx >= 400 && mx <= 500){
			if(my >= 100 && my <= 180) {
				//You've selected box 3
				if(hud.getScore() >= B3){
					hud.setScore(hud.getScore() - B3);
					HUD.HEALTH = (100 + (hud.bounds/2));
				}
			}
		}
	}
}

	
