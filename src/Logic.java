import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.*;
import processing.video.Movie;
import processing.video.Video;

public class Logic {

	PApplet app;
	Mundo mundo;
	Movie fondo;
	private Minim minim;
	private AudioPlayer charco;
	private AudioPlayer teatrino;
	private boolean people;
	PImage tertulia;

	public Logic(PApplet app) {
		this.app = app;
		mundo = new Mundo(app);
		fondo = new Movie(app, "../data/fondo.mp4");
		fondo.loop();
		fondo.frameRate(2);
		minim = new Minim(app);
		charco = minim.loadFile("../data/water_sound.mp3");
		people = true;
		charco.play();
		charco.loop();
		// tertulia = app.loadImage("../data/teatrino.png");

	}

	public void display() {

		if (people) {
			fondo.read();
			fondo.play();
			app.image(fondo, 0, 0);
			mundo.displayUsuario();

		} else {
			app.image(tertulia, 0, 0);
			charco.mute();
		}

	}

}
