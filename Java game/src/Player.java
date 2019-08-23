import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.Random;

public class Player extends GameObject {
	public Color color = Color.white;
	Handler handler;
	public int initialFrames = 0;
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		// TODO Auto-generated constructor stub

	}

	public void tick() {
		x += velX;
		y += velY;

		x = Game.clamp(x, 0, Game.WIDTH - 37);
		y = Game.clamp(y, 0, Game.HEIGHT - 60);
		collision();
		if (collisionRender()) {
			initialFrames = Game.frames + 30;
			color = color.green;
		}
		if (initialFrames == Game.frames) {
			color = color.white;
		}
	}

	private void collision() {
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getId() == ID.BasicEnemy) {

				if (getBounds().intersects(tempObject.getBounds())) {
					HUD.HEALTH -= 2;

				}
			}
		}

	}

	// collison method for damage graphics
	public boolean collisionRender() {
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getId() == ID.BasicEnemy) {

				if (getBounds().intersects(tempObject.getBounds())) {
					return true;
				}
			}

		}
		return false;

	}

	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(color);
		g.fillRect(x, y, 31, 31);
		Toolkit.getDefaultToolkit().sync();

	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}

}
