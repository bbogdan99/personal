package World;

import java.util.ArrayList;

import ThreeDimensionals.Object3D;
import newproject.Camera;
import newproject.Triangle;
import newproject.Vertex;

public class Scene 
{
	private ArrayList<Object3D>Objects;
	private Camera cam;
	//ArrayList<LightSource>LightSources;
	private Vertex Ia;
	
	public Scene(Camera cam)
	{
		setObjects(new ArrayList<Object3D>());
		setIa(new Vertex(64, 64, 64));
		this.setCam(cam);
	}
	public void addObject(Object3D obj)
	{
		getObjects().add(obj);
	}
	public void setIA(Vertex Ia)
	{
		this.getIa().setX(Ia.getX());
		this.getIa().setY(Ia.getY());
		this.getIa().setZ(Ia.getZ());
	}
	public String toString()
	{
		String returnd = "";
		returnd += "Lumina ambientala " + getIa().getX() + " " + getIa().getY() + " " + getIa().getZ() + "\n";
		returnd += "Camera pos: " + getCam().getX() + " " + getCam().getY() + " " + getCam().getZ() + "\n";
		returnd += "Camera rot: " + getCam().getPitch() + " " + getCam().getYaw() + " " + getCam().getRoll() + "\n";
		for (Object3D o: getObjects())
		{
			/*returnd += "Triangle in Scene: \n";
			returnd += t.getV1().getX() + " " + t.getV1().getY() + " " + t.getV1().getZ() + "\n";
			returnd += t.getV2().getX() + " " + t.getV2().getY() + " " + t.getV2().getZ() + "\n";
			returnd += t.getV3().getX() + " " + t.getV3().getY() + " " + t.getV3().getZ() + "\n";*/
		}
		return returnd;
	}
	public Camera getCam() {
		return cam;
	}
	public void setCam(Camera cam) {
		this.cam = cam;
	}
	public Vertex getIa() {
		return Ia;
	}
	public void setIa(Vertex ia) {
		Ia = ia;
	}
	public ArrayList<Object3D> getObjects() {
		return Objects;
	}
	public void setObjects(ArrayList<Object3D> objects) {
		Objects = objects;
	}
	/*Vertex normal = (t.v2.subtract(t.v1)).cross(t.v3.subtract(t.v1)).normalizeVect();
	Vertex lightDir = new Vertex(0,1,0).normalizeVect();
	double intensity = 0.2 + Math.max(0.0,  normal.dot(lightDir));*/
}
