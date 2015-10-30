package tk.ju57u5v.sgame;

import com.sun.javafx.geom.Vec2f;

public class GameObject {
	public Vec2f position;

	public GameObject() {
		this(new Vec2f(0, 0));
	}
	
	public GameObject(Vec2f position) {
		this.position = new Vec2f(position);
	}

}
