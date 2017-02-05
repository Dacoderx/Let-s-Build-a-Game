package com.myfirstgame.main;

import java.util.Random;

public class Spawn {
	private Handler handler;
	private HUD hud;
	private Game game;
	private Random r = new Random();
	private int scoreKeep = 0;
	public Spawn(Handler handler, HUD hud, Game game) {
		this.handler = handler;
		this.hud = hud;
		this.game = game;
	}
	public void tick() {
		scoreKeep++;
		if(scoreKeep >= 300) {
			scoreKeep = 0;
			System.out.println(game.diff);
			hud.setLevel(hud.getLevel() + 1);
			
			if(game.diff == 0) {
				if(hud.getLevel() == 2) {
					handler.addObject(new BasicEnemy(1, 1, ID.BasicEnemy, handler));
					handler.addObject(new BasicEnemy(1, 436, ID.BasicEnemy, handler));
					handler.addObject(new BasicEnemy(622, 1, ID.BasicEnemy, handler));
					handler.addObject(new BasicEnemy(622, 436, ID.BasicEnemy, handler));
				} else if(hud.getLevel() == 3) {
					handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
				} else if(hud.getLevel() == 4) {
					handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
				} else if(hud.getLevel() == 5) {
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
				} else if(hud.getLevel() == 7) {
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
				} else if(hud.getLevel() == 10) {
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
					handler.addObject(new FastSmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastSmartEnemy, handler));
				}else if(hud.getLevel() == 15) {
					handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
					handler.addObject(new FastSmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastSmartEnemy, handler));
					}
				}
			}else if(game.diff == 1) {
				if(hud.getLevel() == 2) {
					handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.HardEnemy, handler));
				} else if(hud.getLevel() == 3) {
					handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.HardEnemy, handler));
				} else if(hud.getLevel() == 4) {
					handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
				} else if(hud.getLevel() == 5) {
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
				} else if(hud.getLevel() == 7) {
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
				} else if(hud.getLevel() == 8) {
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
				}
			}
		}
	}

