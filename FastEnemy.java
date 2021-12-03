package xmas.wave;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class FastEnemy extends GameObject{
	private Handler handler;
	Random r = new Random();
	boolean dir = r.nextInt(1) == 1 ? true : false;
	
	public FastEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = dir ? 3 : -3;
		velY = dir ? 8 : -8;
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if (y <= 0 || y >= Game.HEIGHT - 42) velY *= -1;
		if (x <= 0 || x >= Game.WIDTH - 32) velX *= -1;
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.yellow, 16, 16, 0.05f, handler));
	}

	public void render(Graphics g) {
		
		g.setColor(Color.yellow);
		g.fillOval(x, y, 16, 16);;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 16, 16);
	}
}
