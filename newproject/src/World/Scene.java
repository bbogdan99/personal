package World;

import java.awt.Color;
import java.util.ArrayList;

import ThreeDimensionals.Object3D;
import newproject.Camera;
import newproject.Vertex;

public class Scene 
{
	private ArrayList<Object3D>Objects;
	private Camera cam;
	private ArrayList<LightSource>LightSources;
	
	private AmbientLight Ia;
	private Color backgroundColor;
	
	public Scene(Camera cam)
	{
		Objects = new ArrayList<>();
		LightSources = new ArrayList<>();
		setIa(new AmbientLight( new Color(64, 64, 64)));
		this.setCam(cam);
		setBackgroundColor(Color.BLACK);
	}
	public void addObject(Object3D obj)
	{
		Objects.add(obj);
	}
	public void addLight(LightSource Light)
	{
		LightSources.add(Light);
	}
	public void setIA(AmbientLight Ia)
	{
		this.Ia = new AmbientLight(Ia.getColor());
	}
	public String toString()
	{
		String returnd = "";
		//returnd += "Lumina ambientala " + getIa().getX() + " " + getIa().getY() + " " + getIa().getZ() + "\n";
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
	public AmbientLight getIa() {
		return Ia;
	}
	public void setIa(AmbientLight ia) {
		Ia = new AmbientLight(ia.getColor());
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
	public Color getBackgroundColor() {
		return backgroundColor;
	}
	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	
	public ArrayList<LightSource> getLightSources() {
		return LightSources;
	}
	public void setLightSources(ArrayList<LightSource>LightSources)
	{
		this.LightSources = LightSources;
	}
	
	
}
