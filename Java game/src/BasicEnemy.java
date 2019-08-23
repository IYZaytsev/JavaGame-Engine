import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.Random;

public class BasicEnemy extends GameObject {
	public Color color = Color.red;
	private Handler handler;
	public BasicEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		velX = 5;
		velY = 5;
		// TODO Auto-generated constructor stub
	}

	

	public void tick() {
		x += velX;
		y += velY;

		if (y <= 0 || y > Game.HEIGHT - 32) {
			velY *= -1;
		}

		if (x <= 0 || x > Game.WIDTH - 16) {
			velX *= -1;

		}
		handler.addObject(new Trail(x,y,16,16,Color.red,.01f,handler, ID.Trail));
	}

	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, 16, 16);
		Toolkit.getDefaultToolkit().sync();

	}



	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 16,16);
	}

}
