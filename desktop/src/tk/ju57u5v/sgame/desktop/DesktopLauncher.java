package tk.ju57u5v.sgame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import tk.ju57u5v.sgame.JavaStrategyGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width=1920;
		config.height=1280;
		new LwjglApplication(new JavaStrategyGame(), config);
	}
}
