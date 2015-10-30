package tk.ju57u5v.sgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Plane;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.Ray;
import com.sun.javafx.geom.Vec2f;

import tk.ju57u5v.sgame.graphics.Drawable;

public class Tilemap implements Drawable{

	public Tile [][] tiles;
	private final Plane xzPlane = new Plane(new Vector3(0, 1, 0), 0); //Ebene der Tiles
	private final Vector3 intersection = new Vector3(); // Schnittpunkt mit dem "Klick"/Ray
	
	public Tilemap(int width, int height) {
		tiles = new Tile[width][height];
		
		for(int z = 0; z < 10; z++) {
			for(int x = 0; x < 10; x++) {
				tiles[x][z] = new Tile(new Texture("badlogic.jpg"), new Vec2f(x,z));
			}
		}
	}
	@Override
	public void render(SpriteBatch batch) {
		for(int z = 0; z < 10; z++) {
			for(int x = 0; x < 10; x++) {
				tiles[x][z].render(batch);
			}
		}
	}
	
	public Tile tileAt (Vec2f position) {
		Camera cam = JavaStrategyGame.getCamera();
		Ray pickRay = cam.getPickRay(Gdx.input.getX(), Gdx.input.getY());
		Intersector.intersectRayPlane(pickRay, xzPlane, intersection);
		int x = (int)intersection.x;
		int z = (int)intersection.z;
		if(x >= 0 && x < tiles.length && z >= 0 && z < tiles[1].length) {
			return tiles[x][z];
		}
		return null;
	}
}
