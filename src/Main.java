import processing.core.*;

public class Main extends PApplet {
	Logic app;

	public void setup() {
		app = new Logic(this);
		size(displayWidth, displayHeight);

	}

	public void draw() {
		background(0);
		app.display();
	}

}
