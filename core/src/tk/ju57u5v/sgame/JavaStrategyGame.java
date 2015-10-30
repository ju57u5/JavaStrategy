package tk.ju57u5v.sgame;

import tk.ju57u5v.sgame.graphics.Updateable;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.sun.javafx.geom.Vec2f;

public class JavaStrategyGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private static OrthographicCamera camera;
	private Tilemap tilemap;
	final Matrix4 matrix = new Matrix4();

	@Override
	public void create() {
		camera = new OrthographicCamera(10, 10 * (Gdx.graphics.getHeight() / (float) Gdx.graphics.getWidth()));
		camera.position.set(5, 5, 10);
		camera.direction.set(-1, -1, -1);
		camera.near = 1;
		camera.far = 100;
		matrix.setToRotation(new Vector3(1, 0, 0), 90);

		batch = new SpriteBatch();
		tilemap = new Tilemap(10, 10);

	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		// Render Tilemap
		batch.setProjectionMatrix(camera.combined);
		batch.setTransformMatrix(matrix);
		batch.begin();
		tilemap.render(batch);
		batch.end();

		// Render Rest

		update();

	}

	public void update() {
		if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
			Tile tile = tilemap.tileAt(new Vec2f(Gdx.input.getX(), Gdx.input.getY()));
			if (tile != null) {
				tile.setAlpha(0.2f);
			}
		}
		if (Gdx.input.isKeyPressed(Input.Keys.A)) {
			camera.position.add(-0.05f, 0, 0.05f);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.D)) {
			camera.position.add(0.05f, 0, -0.05f);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.W)) {
			camera.position.add(-0.05f, 0, -0.05f);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.S)) {
			camera.position.add(0.05f, 0, 0.05f);
		}
	}

	public static OrthographicCamera getCamera() {
		return camera;
	}
}
