package tk.ju57u5v.sgame;

import tk.ju57u5v.sgame.graphics.Drawable;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sun.javafx.geom.Vec2f;


public class Tile extends GameObject implements Drawable{

	private Sprite sprite;
	private boolean walkable;
	private boolean buildable;
	
	public Tile(Texture texture, Vec2f position) {
		super(position);
		sprite = new Sprite(texture);
		sprite.setSize(1, 1);
		sprite.setPosition(position.x, position.y);
	}

	@Override
	public void render(SpriteBatch batch) {
		sprite.draw(batch);
	}
	
	public void setAlpha(float alpha) {
		sprite.setAlpha(alpha);
	}

}
