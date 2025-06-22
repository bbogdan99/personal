package Utils;

import java.util.ArrayList;
import java.util.List;

import ThreeDimensionals.Object3D;
import World.Scene;
import newproject.Triangle;
import newproject.UV;
import newproject.Vertex;

public class ClippingEngine {

    public static class Plane {
        public Vertex normal;
        public double d;

        public Plane(Vertex normal, double d) 
        {
            this.normal = normal.normalizeVect();
            this.d = d;
        }

        public double distance(Vertex v) 
        {
            return normal.dot(v) + d;
        }
    }

    public static Scene ClipScene(Scene scene, Plane[] planes) 
    {
        ArrayList<Object3D> clippedObjects = new ArrayList<>();
        for (Object3D obj : scene.getObjects()) 
        {
            Object3D clippedObj = ClipObject(obj, planes);
            if (clippedObj != null) clippedObjects.add(clippedObj);
        }

        Scene clippedScene = new Scene(scene.getCam());
        clippedScene.setIA(scene.getIa());
        clippedScene.setLightSources(scene.getLightSources());
        for (Object3D obj : clippedObjects) clippedScene.addObject(obj);
        return clippedScene;
    }

    private static Object3D ClipObject(Object3D obj, Plane[] planes) 
    {
        ArrayList<Triangle> clippedTriangles = obj.getTriangles();
        for (Plane plane : planes) 
        {
            clippedTriangles = ClipTriangles(clippedTriangles, plane);
            if (clippedTriangles.isEmpty()) return null;
        }
        Object3D clippedObj = new Object3D(obj);
        clippedObj.setTriangles(clippedTriangles);
        return clippedObj;
    }

    private static ArrayList<Triangle> ClipTriangles(ArrayList<Triangle> triangles, Plane plane) 
    {
        ArrayList<Triangle> result = new ArrayList<>();
        for (Triangle t : triangles) 
        {
            result.addAll(ClipTriangleAgainstPlane(t, plane));
        }
        return result;
    }

    private static List<Triangle> ClipTriangleAgainstPlane(Triangle tri, Plane plane) 
    {
        List<Vertex> inside = new ArrayList<>();
        List<Vertex> outside = new ArrayList<>();
        
        if (plane.distance(tri.getV1()) >= 0) inside.add(tri.getV1());
        else outside.add(tri.getV1());
        
        if (plane.distance(tri.getV2()) >= 0) inside.add(tri.getV2());
        else outside.add(tri.getV2());
        
        if (plane.distance(tri.getV3()) >= 0) inside.add(tri.getV3());
        else outside.add(tri.getV3());

        if (inside.size() == 3) return List.of(tri);
        if (inside.size() == 0) return List.of();
        if (inside.size() == 1) 
        {
            Vertex a = inside.get(0);
            Vertex b = Intersection(a, outside.get(0), plane);
            Vertex c = Intersection(a, outside.get(1), plane);
            Triangle temp = new Triangle(a,b,c, tri.getColor(), tri.clampedv1, tri.clampedv2, tri.clampedv3);
            
            UV uva = getUV(a, tri);
            UV uvb = getUV(outside.get(0), tri);
            UV uvc = getUV(outside.get(1), tri);
            
            temp.setUV1(uva);
            
            double ABp = SegmentLength(a, b);
            double AB = SegmentLength(a, outside.get(0));
            double tAB = ABp/AB;
            
            double ACp = SegmentLength(a, c);
            double AC = SegmentLength(a, outside.get(1));
            double tAC = ACp/AC;
            
            UV uv_2 = new UV(uva.getU() + tAB * (uvb.getU() - uva.getU()),
            		uva.getV() + tAB * (uvb.getV() - uva.getV()));
            UV uv_3 = new UV(uva.getU() + tAC * (uvc.getU() - uva.getU()),
            		uva.getV() + tAC * (uvc.getV() - uva.getV()));
            
            temp.setUV2(uv_2);
            temp.setUV3(uv_3);
            temp.setTexture(tri.getTexture());
            
            return List.of(temp);
        } 
        else 
        { 
            Vertex a = inside.get(0);
            Vertex b = inside.get(1);
            Vertex p = Intersection(a, outside.get(0), plane);
            Vertex q = Intersection(b, outside.get(0), plane);
            
            UV uva = getUV(a, tri);
            UV uvb = getUV(b, tri);
            UV uvc = getUV(outside.get(0), tri);
            
            Triangle temp1 = new Triangle(a,b,p, tri.getColor(), tri.clampedv1, tri.clampedv2, tri.clampedv3);
            temp1.setUV1(uva);
            temp1.setUV2(uvb);
            
            double t1 = SegmentLength(a,p)/SegmentLength(a,outside.get(0));
            UV uvt1 = new UV(uva.getU() + t1 * (uvc.getU() - uva.getU()),
            		uva.getV() + t1 * (uvc.getV() - uva.getV()));
            temp1.setUV3(uvt1);
            temp1.setTexture(tri.getTexture());
            
            Triangle temp2 = new Triangle(b, q, p, tri.getColor(), tri.clampedv1, tri.clampedv2, tri.clampedv3);
            temp2.setUV1(uvb);
            
            double tBQ = SegmentLength(b, q)/SegmentLength(b,outside.get(0));
            UV uvt2 = new UV(uvb.getU() + tBQ * (uvc.getU() - uvb.getU()),
            		uvb.getV() + tBQ * (uvc.getV() - uvb.getV()));
            temp2.setUV2(uvt2);
            temp2.setUV3(uvc);
            temp2.setTexture(tri.getTexture());
            
            return List.of(temp1, temp2);
            /*return List.of(
                new Triangle(a, b, p, tri.getColor(), tri.clampedv1, tri.clampedv2, tri.clampedv3),
                new Triangle(b, q, p, tri.getColor(), tri.clampedv1, tri.clampedv2, tri.clampedv3)
            );*/
        }
        	
    }
    private static UV getUV(Vertex v, Triangle t)
    {
    	double x = v.getX(), y = v.getY(), z = v.getZ();
    	if (x == t.getV1().getX() && y == t.getV1().getY() && z == t.getV1().getZ()) return t.getUV1();
    	if (x == t.getV2().getX() && y == t.getV2().getY() && z == t.getV2().getZ()) return t.getUV2();
    	if (x == t.getV3().getX() && y == t.getV3().getY() && z == t.getV3().getZ()) return t.getUV3();
    	return null;
    }
    
    private static double SegmentLength(Vertex A, Vertex B)
    {
    	return Math.sqrt(
    			(A.getX() - B.getX()) * (A.getX() - B.getX()) +
    			(A.getY() - B.getY()) * (A.getY() - B.getY()) +
    			(A.getZ() - B.getZ()) * (A.getZ() - B.getZ())
    			);
    }

    private static Vertex Intersection(Vertex A, Vertex B, Plane plane) 
    {
        Vertex dir = B.subtract(A);
        double t = -(plane.normal.dot(A) + plane.d) / (plane.normal.dot(B.subtract(A)));
        return new Vertex(A.getX() + dir.getX() * t, 
        		A.getY() + dir.getY() * t, 
        		A.getZ() + dir.getZ() * t);
    }

}