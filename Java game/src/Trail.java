import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Trail extends GameObject {
	private float alpha = 1;
	private Handler handler;
	private Color color;
	private int width;
	private int height;
	private float life;

	public Trail(int x, int y, int width, int height, Color color, float life, Handler handler, ID id) {

		super(x, y, id);
		this.width = width;
		this.height = height;
		this.life = life;
		this.handler = handler;
		this.color = color;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		if (alpha > life) {
			alpha -= life - .001f;

		} else {
			handler.removeObject(this);
		}

	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTransparent(alpha));
		g.setColor(color);
		g.fillRect(x, y, width, height);
		g2d.setComposite(makeTransparent(1));

	}

	public AlphaComposite makeTransparent(float alpha) {
		int type = AlphaComposite.SRC_OVER;
		return (AlphaComposite.getInstance(type, alpha));

	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
