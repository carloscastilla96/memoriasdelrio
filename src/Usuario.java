import processing.core.*;
import processing.video.Movie;
import processing.video.Video;

public class Usuario {

	private PApplet app;
	private int ID;
	private Movie shadow;
	

	public Usuario(PApplet app, int ID) {

		this.app = app;
		this.ID = ID;

	}

	public void display(float angle, PVector vector, Movie shadow) {

		app.pushMatrix();

		
		shadow.read();
		shadow.play();
		app.blendMode(app.MULTIPLY);
		app.image(shadow, vector.x, app.height - shadow.height);
		app.imageMode(app.CENTER);
		app.popMatrix();
		app.imageMode(app.CORNER);
		app.blendMode(app.LIGHTEST);
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

}
