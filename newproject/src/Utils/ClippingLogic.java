package Utils;

import java.util.ArrayList;
//import java.util.List;

import ThreeDimensionals.Object3D;
import World.Scene;
import newproject.Triangle;
import newproject.Vertex;

public class ClippingLogic
{
	/*public static Scene ClipScene(Scene scene, Vertex[] planes)
	{
		ArrayList<Object3D>clipped_objects = new ArrayList<Object3D>();
		for (Object3D obj: scene.getObjects())
		{
			Object3D clipped_obj = ClipObject(obj, planes);
			if (clipped_obj != null) clipped_objects.add(clipped_obj);
		}
		
		Scene clipped_scene = new Scene(scene.getCam());
		clipped_scene.setIA(scene.getIa());
		for (Object3D obj: clipped_objects) clipped_scene.addObject(obj);
		return clipped_scene;
	}
	
	private static Object3D ClipObject(Object3D obj, Vertex[] planes)
	{
		for (Vertex p:  planes)
		{
			obj = ClipObjAgainstPlane(obj, p);
			if (obj == null) return null;
		}
		return obj;
	}
	
	private static Object3D ClipObjAgainstPlane(Object3D obj, Vertex plane)
	{
		double d = SignedDistance(plane, ObjCenter(obj.getTriangles()));
		double r = ObjRadius(obj.getTriangles(), ObjCenter(obj.getTriangles()));
		if (d>r) return obj;
		else if (d<-r) return null;
		else
		{
			Object3D clipped_obj = new Object3D(obj);
			clipped_obj.setTriangles(ClipTrianglesAgainstPlane(obj.getTriangles(), plane));
			return clipped_obj;
		}
	}
	
	private static ArrayList<Triangle> ClipTrianglesAgainstPlane(ArrayList<Triangle> triangles, Vertex plane)
	{
		ArrayList<Triangle> clipped_triangles = new ArrayList<Triangle>();
		for (Triangle t: triangles)
		{
			ArrayList<Triangle> temp = ClipTriangle(t, plane);
			for (Triangle y: temp)
				clipped_triangles.add(y);
		}
		return clipped_triangles;
	}
	
	private static ArrayList<Triangle> ClipTriangle(Triangle t, Vertex plane)
	{
		double d1 = SignedDistance(plane, t.getV1());
		double d2 = SignedDistance(plane, t.getV2());
		double d3 = SignedDistance(plane, t.getV3());
		
		if (d1 >= 0 && d2 >= 0 && d3 >= 0)
		{
			ArrayList<Triangle> temp = new ArrayList<Triangle>();
			temp.add(t);
			return temp;
		}
		else if (d1 < 0 && d2 < 0 && d3 < 0)
		{
			return new ArrayList<Triangle>();
		}
		else if ((d1 >= 0 && d2 < 0 && d3 < 0) || (d1 < 0 && d2 >= 0 && d3 < 0) || (d1 < 0 && d2 < 0 && d3 >= 0))
		{
			Vertex A = new Vertex(0,0,0);
			Vertex B = new Vertex(0,0,0);
			Vertex C = new Vertex(0,0,0);
			
			if (d1 >= 0) 
			{
				A = new Vertex(t.getV1());
				B = new Vertex(t.getV2());
				C = new Vertex(t.getV3());
			}
			else if (d2 >= 0) 
			{
				A = new Vertex(t.getV2());
				B = new Vertex(t.getV1());
				C = new Vertex(t.getV3());
			}
			else 
			{
				A = new Vertex(t.getV3());
				B = new Vertex(t.getV2());
				C = new Vertex(t.getV1());
			}
					
			Vertex Bp = Intersection(A,B, plane);
			Vertex Cp = Intersection(A,C, plane);
			
			ArrayList<Triangle> temp = new ArrayList<Triangle>();
			temp.add(new Triangle(A, Bp, Cp));
			return temp;
		}
		else
		{
			Vertex A = new Vertex(0,0,0);
			Vertex B = new Vertex(0,0,0);
			Vertex C = new Vertex(0,0,0);
			
			if (d1 < 0)
			{
				C = new Vertex(t.getV1());
				A = new Vertex(t.getV3());
				B = new Vertex(t.getV2());
			}
			else if (d2<0)
			{
				C = new Vertex(t.getV2());
				A = new Vertex(t.getV1());
				B = new Vertex(t.getV3());
			}
			else
			{
				C = new Vertex(t.getV3());
				A = new Vertex(t.getV1());
				B = new Vertex(t.getV2());
			}
			
			Vertex Ap = Intersection(A,C ,plane);
			Vertex Bp = Intersection(B,C, plane);
			
			ArrayList<Triangle> temp = new ArrayList<Triangle>();
			temp.add(new Triangle(A, B, Ap));
			temp.add(new Triangle(Ap, B, Bp));
			return temp;
		}
	}*/
	
	public static boolean isBackFace(Triangle t, Scene scene)
	{
		Vertex e1 = new Vertex(t.getV2().getX() - t.getV1().getX(), t.getV2().getY() - t.getV1().getY(), t.getV2().getZ() - t.getV1().getZ());
		Vertex e2 = new Vertex(t.getV3().getX() - t.getV1().getX(), t.getV3().getY() - t.getV1().getY(), t.getV3().getZ() - t.getV1().getZ());
		Vertex n = e1.cross(e2).normalizeVect();
		
		Vertex temp = new Vertex(scene.getCam().getX() - t.getV1().getX(), scene.getCam().getY() - t.getV1().getY(), scene.getCam().getZ() - t.getV1().getZ());
		Vertex viewDir = temp.normalizeVect();
		
		//return false;
		return (n.dot(viewDir) >=0 );
		
		/*Vertex e1 = new Vertex(tv2.x - tv1.x, tv2.y - tv1.y, tv2.z - tv1.z);
    	Vertex e2 = new Vertex(tv3.x - tv1.x, tv3.y - tv1.y, tv3.z - tv1.z);
    	Vertex n = e1.cross(e2).normalizeVect();
    	
    	Vertex tss = new Vertex(cam.getX() - tv1.x, cam.getY() - tv1.y, cam.getZ() - tv1.z);
    	Vertex viewDir = tss.normalizeVect();
    	
    	if (n.dot(viewDir) >= 0) continue;*/
	}
	
	/*private static double ObjRadius(ArrayList<Triangle>Triangles, Vertex Center)
	{
		double maxDist = 0.0;
		for (Triangle t: Triangles)
		{
			double distx = Center.getX() - t.getV1().getX();
			double disty = Center.getY() - t.getV1().getY();
			double distz = Center.getZ() - t.getV1().getZ();
			
			if (maxDist < distx * distx + disty * disty + distz * distz) maxDist = distx * distx + disty * disty + distz * distz;
			
			distx = Center.getX() - t.getV2().getX();
			disty = Center.getY() - t.getV2().getY();
			distz = Center.getZ() - t.getV2().getZ();
			
			if (maxDist < distx * distx + disty * disty + distz * distz) maxDist = distx * distx + disty * disty + distz * distz;
			
			distx = Center.getX() - t.getV3().getX();
			disty = Center.getY() - t.getV3().getY();
			distz = Center.getZ() - t.getV3().getZ();
			
			if (maxDist < distx * distx + disty * disty + distz * distz) maxDist = distx * distx + disty * disty + distz * distz;
		}
		return Math.sqrt(maxDist);
	}
	
	private static Vertex ObjCenter(ArrayList<Triangle>Triangles)
	{
		double x = 0, y = 0, z = 0;
		double count = 0;
		
		for (Triangle t: Triangles)
		{
			x+= t.getV1().getX() + t.getV2().getX() + t.getV3().getX();
			y+= t.getV1().getY() + t.getV2().getY() + t.getV3().getY();
			z+= t.getV1().getZ() + t.getV2().getZ() + t.getV3().getZ();
			count+=3;
		}
		return new Vertex(x/count, y/count, z/count);
	}
	
	private static Vertex Intersection(Vertex A, Vertex B, Vertex plane)
	{
		Vertex dir = new Vertex(B.getX() - A.getX(), B.getY() - A.getY(), B.getZ() - A.getZ());
		double t = -plane.dot(A) / (plane.dot(dir));
		return new Vertex(A.getX() + dir.getX()*t, A.getY() + dir.getY()*t, A.getZ() + dir.getZ()*t);
	}
	
	private static double SignedDistance(Vertex plane, Vertex v)
	{
		return v.getX() * plane.getX() + v.getY() * plane.getY() + v.getZ() * plane.getZ() + plane.getW();
	}*/
}
