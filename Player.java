package xmas.wave;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject{

	Random r = new Random();
	Handler handler;
	
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
	}

	public void tick() {
		x += velX;
		y += velY;
		
		x = Game.clamp(x, 0, Game.WIDTH - 48);
		y = Game.clamp(y, 0, Game.HEIGHT - 72);
		
		collision();
	}
	
	private void collision() {
		for (int i = 0; i < handler.object.size(); i++) {
			
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.BasicEnemy) {
				if(getBounds().intersects(tempObject.getBounds())) {
					HUD.HEALTH -= 2;
					
				}
			}
			
			if(tempObject.getId() == ID.FastEnemy) {
				if(getBounds().intersects(tempObject.getBounds())) {
					HUD.HEALTH -= 4;
					
				}
			}
			
		}
	}

	public void render(Graphics g) {
		if (id == ID.Player) g.setColor(Color.green);
		
		int[] xCoords = new int[3];
		int[] yCoords = new int[3];
		xCoords[0] = x;
		xCoords[1] = x + 16;
		xCoords[2] = x + 32;
		
		yCoords[0] = y + 26;
		yCoords[1] = y + 10;
		yCoords[2] = y + 26;
		
		int[] xCoords2 = new int[3];
		int[] yCoords2 = new int[3];
		
		xCoords2[0] = x + 3;
		xCoords2[1] = x + 16;
		xCoords2[2] = x + 29;
		
		yCoords2[0] = y + 18;
		yCoords2[1] = y + 4;
		yCoords2[2] = y + 18;
		
		int[] xCoords3 = new int[3];
		int[] yCoords3 = new int[3];
		
		xCoords3[0] = x + 6;
		xCoords3[1] = x + 16;
		xCoords3[2] = x + 26;
		
		yCoords3[0] = y + 10;
		yCoords3[1] = y;
		yCoords3[2] = y + 10;
		
		g.fillPolygon(xCoords, yCoords, 3);
		g.fillPolygon(xCoords2, yCoords2, 3);
		g.fillPolygon(xCoords3, yCoords3, 3);
		
		if (id == ID.Player) g.setColor(new Color(165, 60, 60));
		
		g.fillRect(x + 12, y + 26, 10, 6);
		
		
		
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}

}
