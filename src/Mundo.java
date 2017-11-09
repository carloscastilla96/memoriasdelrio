import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import TUIO.TuioObject;
import TUIO.TuioProcessing;
import TUIO.TuioTime;
import processing.core.*;
import processing.video.Movie;

public class Mundo {
	private PApplet app;
	private boolean callback, verbose, clasificacion, clasificacion2;
	private TuioProcessing tuioClient;
	private Movie[] shadows;
	private ArrayList<Usuario> usuarios;
	private String[] lista, listaSplit, listaHabitat, listaAlimento;
	private String nuevo, nombre, nombreNuevo, habitatString, alimentoString;
	private int ID, position;
	private boolean isOne, isTwo, isThree;

	public Mundo(PApplet app) {

		tuioClient = new TuioProcessing(app);
		usuarios = new ArrayList<>();
		this.app = app;

		for (int i = 0; i < 3; i++) {
			usuarios.add(new Usuario(app, i));
		}

		shadows = new Movie[5];
		for (int i = 1; i < 5; i++) {
			shadows[i] = new Movie(app, "../data/" + i + ".mp4");

		}

	}

	public void displayUsuario() {
		app.stroke(255);
		app.fill(255);

		ArrayList<TuioObject> tuioObjectList = tuioClient.getTuioObjectList();

		for (int i = 0; i < tuioObjectList.size(); i++) {

			TuioObject tobj = tuioObjectList.get(i);

			for (int j = 0; j < usuarios.size(); j++) {

				if (tobj.getSymbolID() == j) {
					if (callback) {

					}
					Usuario u = usuarios.get(j);
					PVector vector = new PVector(tobj.getScreenX(app.width), tobj.getScreenY(app.height));
					u.display(tobj.getAngle(), vector, shadows[j + 1]);
					app.text("" + u.getID(), tobj.getScreenX(app.width), tobj.getScreenY(app.height));
				}
			}

		}
	}

	public void addTuioObject(TuioObject tobj) {
		if (verbose)
			System.out.println("add obj " + tobj.getSymbolID() + " (" + tobj.getSessionID() + ") " + tobj.getX() + " "
					+ tobj.getY() + " " + tobj.getAngle());
	}

	public void updateObject(TuioObject tobj) {
		if (verbose)
			System.out.println("set obj " + tobj.getSymbolID() + " (" + tobj.getSessionID() + ") " + tobj.getX() + " "
					+ tobj.getY() + " " + tobj.getAngle() + " " + tobj.getMotionSpeed() + " " + tobj.getRotationSpeed()
					+ " " + tobj.getMotionAccel() + " " + tobj.getRotationAccel());
	}

	public void removeObject(TuioObject tobj) {
		if (verbose)
			System.out.println("del obj " + tobj.getSymbolID() + " (" + tobj.getSessionID() + ")");
	}

	public int random() {

		position = (int) app.random(1, 5);
		return position;

	}

	public void refresh(TuioTime frameTime) {
		if (verbose)
			app.println("frame #" + frameTime.getFrameID() + " (" + frameTime.getTotalMilliseconds() + ")");
		if (callback)
			app.redraw();
	}

}
