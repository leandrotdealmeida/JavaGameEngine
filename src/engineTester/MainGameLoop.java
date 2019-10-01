package engineTester;

import org.lwjgl.opengl.Display;

import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.RawModel;
import renderEngine.Renderer;

public class MainGameLoop {
	public static void main(String[] args) {

		DisplayManager.createDisplay();

		Loader loader = new Loader();
		Renderer renderer = new Renderer();

		float[] vertices = { -0.5f, 0.5f, 0f, -0.5f, -0.5f, 0f, 0.5f, -0.5f, 0f, 0.5f, -0.5f, 0f, 0.5f, 0.5f, 0f, -0.5f,
				0.5f, 0f };
		
		int[] indices = {
				0,1,3, // top left triangle (v0,v1,v3)
				3,2,1  //Bottom right triangle (v3,v2,v1)
		};

		RawModel model = loader.loadToVAO(vertices, indices);

		while (!Display.isCloseRequested()) {
			renderer.prepare();

			// game logic
			renderer.render(model);
			// render
			DisplayManager.updateDisplay();

		}
		loader.cleanUp();

		DisplayManager.closeDisplay();

	}

}
