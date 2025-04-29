package World;

import java.util.ArrayList;

import Utils.ClippingEngine.Plane;
import newproject.Triangle;

public class Renderer 
{
	Scene scene;
	ArrayList<Triangle>toRender;
	Plane[] planes;
	
	
	
	public Renderer(Scene scene, Plane[] planes)
	{
		this.scene = scene;
		this.planes = planes;
		toRender = new ArrayList<>();
	}
	
	
}
