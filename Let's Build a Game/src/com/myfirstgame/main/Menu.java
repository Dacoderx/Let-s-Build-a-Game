package com.myfirstgame.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.myfirstgame.main.Game.STATE;

public class Menu extends MouseAdapter{
	private Game game;
	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	public Menu(Game game, Handler handler, HUD hud) {
		this.game = game;
		this.hud = hud;
		this.handler = handler;
	}
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		if(Game.gameState == STATE.Menu) {
			//play button
			if (mouseOver(mx, my, 210, 150, 200, 64)) {
				Game.gameState = STATE.Select;
				AudioPlayer.getSound("menu_sound").play(1, 0.5f);
				return;
			}
			//help button
			if(mouseOver(mx, my, 210, 250, 200, 64)) {
				Game.gameState = STATE.Help;
				AudioPlayer.getSound("menu_sound").play(1, 0.5f);
			}
			//quit button
			if(mouseOver(mx, my, 210, 350, 200, 64)) {
				System.exit(1);
				AudioPlayer.getSound("menu_sound").play(1, 0.5f);
			}
		}
		
		//back button for help
		if(Game.gameState == STATE.Help) {
			if(mouseOver(mx, my, 210, 350, 200, 64)) {
				Game.gameState = STATE.Menu;
				AudioPlayer.getSound("menu_sound").play(1, 0.5f);
				return;
			}
		}
		if(Game.gameState == STATE.Select) {
			//normal button
			if (mouseOver(mx, my, 210, 150, 200, 64)) {
				Game.gameState = STATE.Game;
				handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
				handler.clearEnemys();
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
				game.diff = 0;
				AudioPlayer.getSound("menu_sound").play(1, 0.5f);
			}
			//hard button
			if(mouseOver(mx, my, 210, 250, 200, 64)) {
				Game.gameState = STATE.Game;
				handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
				handler.clearEnemys();
				handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
				game.diff = 1;
				AudioPlayer.getSound("menu_sound").play(1, 0.5f);
			}
			//back button
			if(mouseOver(mx, my, 210, 350, 200, 64)) {
				Game.gameState = STATE.Menu;
				AudioPlayer.getSound("menu_sound").play(1, 0.5f);
				return;
			}
		}
		//back button for help
				if(Game.gameState == STATE.End) {
					if(mouseOver(mx, my, 210, 350, 200, 64)) {
						Game.gameState = STATE.Menu;
						hud.setLevel(1);
						hud.setScore(0);
						AudioPlayer.getSound("menu_sound").play(1, 0.5f);
					}
				}
	}
	public void mouseReleased(MouseEvent e) {
		
	}
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if(mx > x && mx < x + width) {
			if (my > y && my < y + height) {
				return true;
			}else return false;
		}else return false;
			}
	public void tick() {
		
	}
	public void render(Graphics g) {
		if(Game.gameState == STATE.Menu) {
		Font fnt = new Font("arial", 1, 50);
		Font fnt2 = new Font("arial", 1, 30);
		g.setFont(fnt);
		g.setColor(Color.WHITE);
		g.drawString("Wave", 240, 50);
		
		g.setFont(fnt2);
		g.drawRect(210, 150, 200, 64);
		g.drawString("Play", 270, 190);
		
		g.drawRect(210, 250, 200, 64);
		g.drawString("Rules", 270, 290);
		
		g.drawRect(210, 350, 200, 64);
		g.drawString("Quit", 270, 390);
		} else if(Game.gameState == STATE.Help) {
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
			Font fnt3 = new Font("arial", 1, 20);
			g.setFont(fnt);
			g.setColor(Color.WHITE);
			g.drawString("Rules", 250, 70);
			g.setFont(fnt3);
			g.drawString("Use the WASD keys to move player and dodge enemies!", 75, 160);
			g.drawString("Press space to enter and exit the shop!", 75, 190);
			g.setFont(fnt2);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Back", 270, 390);
		}else if(Game.gameState == STATE.End) {
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
			Font fnt3 = new Font("arial", 1, 20);
			g.setFont(fnt);
			g.setColor(Color.WHITE);
			g.drawString("Game Over", 180, 70);
			g.setFont(fnt3);
			g.drawString("You lost with a score of: " + hud.getScore(), 175, 200);
			g.setFont(fnt2);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Try Again!", 240, 390);
			}else if(Game.gameState == STATE.Select) {
				Font fnt = new Font("arial", 1, 50);
				Font fnt2 = new Font("arial", 1, 30);
				g.setFont(fnt);
				g.setColor(Color.WHITE);
				g.drawString("SELECT DIFFICULTY", 75, 50);
				
				g.setFont(fnt2);
				g.drawRect(210, 150, 200, 64);
				g.drawString("Normal", 270, 190);
				
				g.drawRect(210, 250, 200, 64);
				g.drawString("Hard", 270, 290);
				
				g.drawRect(210, 350, 200, 64);
				g.drawString("Back", 270, 390);
				}
		}
		
	}