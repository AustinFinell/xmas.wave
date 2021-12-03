package xmas.wave;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	
	public static int HEALTH = 100;
	
	private int greenValue = 255;
	private int redValue = 0;
	
	private int score = 0;
	private int level = 1;
	
	public void tick() {
		HEALTH = Game.clamp(HEALTH, 0, 100);
		
		greenValue = Game.clamp(greenValue, 0, 255);
		greenValue = (int) (HEALTH * 2.5);
		if (HEALTH < 50) {
			greenValue = (int) (HEALTH * 1.5);
		}
		redValue = Game.clamp(redValue, 0, 255);
		redValue = (255 - greenValue) + 75;
		
		score++;
	
	}
	
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200, 32);
		g.setColor(new Color(90, greenValue, 0));
		g.fillRect(15, 15, HEALTH * 2, 32);
		g.setColor(Color.white);
		g.drawRect(15, 15, 200, 32);
		
		g.drawString("Score: " + score, 16, 64);		
		g.drawString("Level: " + level, 16, 80);
		
		
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getLevel() {
		return level;
	}
	
	
	

}
