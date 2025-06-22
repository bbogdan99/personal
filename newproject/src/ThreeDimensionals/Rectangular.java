package ThreeDimensionals;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import Matrix.Matrix4;
import newproject.Material;
import newproject.Triangle;
import newproject.UV;
import newproject.Vertex;

public class Rectangular extends Object3D {
	
	public Rectangular(Vertex v0, Vertex v1, Vertex v2, Vertex v3, Vertex v4, Vertex v5, Vertex v6, Vertex v7)
	{
		
		Triangles.add(new Triangle(v1, v5, v7));
		Triangles.add(new Triangle(v1, v7, v3));
		
		Triangles.add(new Triangle(v0, v2, v6));
		Triangles.add(new Triangle(v0, v6, v4));
		
		Triangles.add(new Triangle(v2, v3, v7));
		Triangles.add(new Triangle(v2, v7, v6));
		
		Triangles.add(new Triangle(v0, v4, v5));
		Triangles.add(new Triangle(v0, v5, v1));
		
		Triangles.add(new Triangle(v0, v1, v3));
		Triangles.add(new Triangle(v0, v3, v2));
		
		Triangles.add(new Triangle(v4, v6, v7));
		Triangles.add(new Triangle(v4, v7, v5));
		material = new Material();
	}
	
	public Rectangular(Vertex v0, Vertex v1, Vertex v2, Vertex v3, Vertex v4, Vertex v5, Vertex v6, Vertex v7, Matrix4 TRS)
	{
		Triangles.add(new Triangle(v1, v5, v7));
		Triangles.add(new Triangle(v1, v5, v3));
		
		Triangles.add(new Triangle(v0, v2, v6));
		Triangles.add(new Triangle(v0, v6, v4));
		
		Triangles.add(new Triangle(v2, v3, v7));
		Triangles.add(new Triangle(v2, v7, v6));
		
		Triangles.add(new Triangle(v0, v4, v5));
		Triangles.add(new Triangle(v0, v5, v1));
		
		Triangles.add(new Triangle(v0, v1, v3));
		Triangles.add(new Triangle(v0, v3, v2));
		
		Triangles.add(new Triangle(v4, v6, v7));
		Triangles.add(new Triangle(v4, v7, v5));
		
		this.TRS = new Matrix4();
		this.TRS.setValues(TRS.getValues());
		material = new Material();
	}
	
	public Rectangular(Vertex v0, Vertex v1, Vertex v2, Vertex v3, Vertex v4, Vertex v5, Vertex v6, Vertex v7, Matrix4 TRS, Color color)
	{

		Triangles.add(new Triangle(v1, v5, v7,color));
		Triangles.add(new Triangle(v1, v5, v3,color));
		
		Triangles.add(new Triangle(v0, v2, v6,color));
		Triangles.add(new Triangle(v0, v6, v4,color));
		
		Triangles.add(new Triangle(v2, v3, v7,color));
		Triangles.add(new Triangle(v2, v7, v6,color));
		
		Triangles.add(new Triangle(v0, v4, v5,color));
		Triangles.add(new Triangle(v0, v5, v1,color));
		
		Triangles.add(new Triangle(v0, v1, v3,color));
		Triangles.add(new Triangle(v0, v3, v2,color));
		
		Triangles.add(new Triangle(v4, v6, v7,color));
		Triangles.add(new Triangle(v4, v7, v5,color));
		
		
		
		this.TRS = new Matrix4();
		this.TRS.setValues(TRS.getValues());
		material = new Material();
		material.setColor(color);
	}
	
	public Rectangular(Vertex v0, Vertex v1, Vertex v2, Vertex v3, Vertex v4, Vertex v5, Vertex v6, Vertex v7, Matrix4 TRS, Color color, BufferedImage texture)
	{
		UV uv1 = new UV(0,0);
		UV uv2 = new UV(1,0);
		UV uv3 = new UV(0,1);
		UV uv4 = new UV(1,1);
		
		
 		Triangle front1 = new Triangle(v1,v5,v7,color);
 		front1.setUV1(uv1);
 		front1.setUV2(uv2);
 		front1.setUV3(uv3);
 		front1.setTexture(texture);
		Triangles.add(front1);
		//Triangles.add(new Triangle(v1, v5, v7,color));
		
		Triangle front2 = new Triangle(v1,v5,v3,color);
		front2.setUV1(uv1);
		front2.setUV2(uv3);
		front2.setUV3(uv4);
		front2.setTexture(texture);
		Triangles.add(front2);
		//Triangles.add(new Triangle(v1, v5, v3,color));
		
		Triangle back1 = new Triangle(v0,v2,v6,color);
		back1.setUV1(uv1);
		back1.setUV2(uv2);
		back1.setUV3(uv3);
		back1.setTexture(texture);
		Triangles.add(back1);
		//Triangles.add(new Triangle(v0, v2, v6,color));
		
		Triangle back2 = new Triangle(v0,v6,v4,color);
		back2.setUV1(uv1);
		back2.setUV2(uv3);
		back2.setUV3(uv4);
		back2.setTexture(texture);
		Triangles.add(back2);
		//Triangles.add(new Triangle(v0, v6, v4,color));
		
		Triangle top1 = new Triangle(v2,v3,v7,color);
		top1.setUV1(uv1);
		top1.setUV2(uv2);
		top1.setUV3(uv3);
		top1.setTexture(texture);
		Triangles.add(top1);
		//Triangles.add(new Triangle(v2, v3, v7,color));
		
		Triangle top2 = new Triangle(v2,v7,v6,color);
		top2.setUV1(uv1);
		top2.setUV2(uv3);
		top2.setUV3(uv4);
		top2.setTexture(texture);
		Triangles.add(top2);
		//Triangles.add(new Triangle(v2, v7, v6,color));
		
		Triangle bot1 = new Triangle(v0,v4,v5,color);
		bot1.setUV1(uv1);
		bot1.setUV2(uv2);
		bot1.setUV3(uv3);
		bot1.setTexture(texture);
		Triangles.add(bot1);
		//Triangles.add(new Triangle(v0, v4, v5,color));
		
		Triangle bot2 = new Triangle(v0,v5,v1,color);
		bot2.setUV1(uv1);
		bot2.setUV2(uv3);
		bot2.setUV3(uv4);
		bot2.setTexture(texture);
		Triangles.add(bot2);
		//Triangles.add(new Triangle(v0, v5, v1,color));
		
		Triangle left1 = new Triangle(v0,v1,v3,color);
		left1.setUV1(uv1);
		left1.setUV2(uv2);
		left1.setUV3(uv3);
		left1.setTexture(texture);
		Triangles.add(left1);
		//Triangles.add(new Triangle(v0, v1, v3,color));
		
		Triangle left2 = new Triangle(v0,v3,v2,color);
		left2.setUV1(uv1);
		left2.setUV2(uv3);
		left2.setUV3(uv4);
		left2.setTexture(texture);
		Triangles.add(left2);
		//Triangles.add(new Triangle(v0, v3, v2,color));
		
		Triangle right1 = new Triangle(v4, v6, v7, color);
		right1.setUV1(uv1);
		right1.setUV2(uv2);
		right1.setUV3(uv3);
		right1.setTexture(texture);
		Triangles.add(right1);
		//Triangles.add(new Triangle(v4, v6, v7,color));
		
		Triangle right2 = new Triangle(v4,v7,v5,color);
		right2.setUV1(uv1);
		right2.setUV2(uv3);
		right2.setUV3(uv4);
		right2.setTexture(texture);
		Triangles.add(right2);
		//Triangles.add(new Triangle(v4, v7, v5,color));
		
		this.TRS = new Matrix4();
		this.TRS.setValues(TRS.getValues());
		material = new Material();
		material.setColor(color);
	}
	
	public Rectangular(Triangle f1t1, Triangle f1t2, Triangle f2t1, Triangle f2t2, Triangle f3t1, Triangle f3t2,
			Triangle f4t1, Triangle f4t2, Triangle f5t1, Triangle f5t2, Triangle f6t1, Triangle f6t2
			)
	{
		this.Triangles = new ArrayList<>();
		// face 1
		
		Triangles.add(new Triangle(new Vertex(f1t1.getV1().getX(), f1t1.getV1().getY(), f1t1.getV1().getZ()), 
				new Vertex(f1t1.getV2().getX(), f1t1.getV2().getY(), f1t1.getV2().getZ()),
				new Vertex(f1t1.getV3().getX(), f1t1.getV3().getY(), f1t1.getV3().getZ())));
		
		Triangles.add(new Triangle(new Vertex(f1t2.getV1().getX(), f1t2.getV1().getY(), f1t2.getV1().getZ()),
				new Vertex(f1t2.getV2().getX(), f1t2.getV2().getY(), f1t2.getV2().getZ()),
				new Vertex(f1t2.getV3().getX(), f1t2.getV3().getY(), f1t2.getV3().getZ())));
		
		// face 2
		
		Triangles.add(new Triangle(new Vertex(f2t1.getV1().getX(), f2t1.getV1().getY(), f2t1.getV1().getZ()), 
				new Vertex(f2t1.getV2().getX(), f2t1.getV2().getY(), f2t1.getV2().getZ()),
				new Vertex(f2t1.getV3().getX(), f2t1.getV3().getY(), f2t1.getV3().getZ())));//this.color));
		
		Triangles.add(new Triangle(new Vertex(f2t2.getV1().getX(), f2t2.getV1().getY(), f2t2.getV1().getZ()),
				new Vertex(f2t2.getV2().getX(), f2t2.getV2().getY(), f2t2.getV2().getZ()),
				new Vertex(f2t2.getV3().getX(), f2t2.getV3().getY(), f2t2.getV3().getZ())));//this.color));
		
		// face 3
		
		Triangles.add(new Triangle(new Vertex(f3t1.getV1().getX(), f3t1.getV1().getY(), f3t1.getV1().getZ()), 
				new Vertex(f3t1.getV2().getX(), f3t1.getV2().getY(), f3t1.getV2().getZ()),
				new Vertex(f3t1.getV3().getX(), f3t1.getV3().getY(), f3t1.getV3().getZ())));//this.color));
		
		Triangles.add(new Triangle(new Vertex(f3t2.getV1().getX(), f3t2.getV1().getY(), f3t2.getV1().getZ()),
				new Vertex(f3t2.getV2().getX(), f3t2.getV2().getY(), f3t2.getV2().getZ()),
				new Vertex(f3t2.getV3().getX(), f3t2.getV3().getY(), f3t2.getV3().getZ())));//this.color));
		
		// face 4
		
		Triangles.add(new Triangle(new Vertex(f4t1.getV1().getX(), f4t1.getV1().getY(), f4t1.getV1().getZ()), 
				new Vertex(f4t1.getV2().getX(), f4t1.getV2().getY(), f4t1.getV2().getZ()),
				new Vertex(f4t1.getV3().getX(), f4t1.getV3().getY(), f4t1.getV3().getZ())));//this.color));
		
		Triangles.add(new Triangle(new Vertex(f4t2.getV1().getX(), f4t2.getV1().getY(), f4t2.getV1().getZ()),
				new Vertex(f4t2.getV2().getX(), f4t2.getV2().getY(), f4t2.getV2().getZ()),
				new Vertex(f4t2.getV3().getX(), f4t2.getV3().getY(), f4t2.getV3().getZ())));//this.color));
		
		// face 5
		
		Triangles.add(new Triangle(new Vertex(f5t1.getV1().getX(), f5t1.getV1().getY(), f5t1.getV1().getZ()), 
				new Vertex(f5t1.getV2().getX(), f5t1.getV2().getY(), f5t1.getV2().getZ()),
				new Vertex(f5t1.getV3().getX(), f5t1.getV3().getY(), f5t1.getV3().getZ())));//this.color));
				
		Triangles.add(new Triangle(new Vertex(f5t2.getV1().getX(), f5t2.getV1().getY(), f5t2.getV1().getZ()),
				new Vertex(f5t2.getV2().getX(), f5t2.getV2().getY(), f5t2.getV2().getZ()),
				new Vertex(f5t2.getV3().getX(), f5t2.getV3().getY(), f5t2.getV3().getZ())));//this.color));
		
		// face 6
		
		Triangles.add(new Triangle(new Vertex(f6t1.getV1().getX(), f6t1.getV1().getY(), f6t1.getV1().getZ()), 
				new Vertex(f6t1.getV2().getX(), f6t1.getV2().getY(), f6t1.getV2().getZ()),
				new Vertex(f6t1.getV3().getX(), f6t1.getV3().getY(), f6t1.getV3().getZ())));//this.color));
				
		Triangles.add(new Triangle(new Vertex(f6t2.getV1().getX(), f6t2.getV1().getY(), f6t2.getV1().getZ()),
				new Vertex(f6t2.getV2().getX(), f6t2.getV2().getY(), f6t2.getV2().getZ()),
				new Vertex(f6t2.getV3().getX(), f6t2.getV3().getY(), f6t2.getV3().getZ())));//this.color));
		
	}
	Rectangular(List<Triangle>face1, List<Triangle>face2, List<Triangle>face3,
			List<Triangle>face4, List<Triangle>face5, List<Triangle>face6)
	{
		material = new Material();
		this.Triangles = new ArrayList<>();
		
		for (Triangle t: face1)
		{
			Triangles.add(new Triangle(new Vertex(t.getV1().getX(), t.getV1().getY(), t.getV1().getZ()),
					new Vertex(t.getV2().getX(), t.getV2().getY(), t.getV2().getZ()),
					new Vertex(t.getV3().getX(), t.getV3().getY(), t.getV3().getZ())));
		}
		
		for (Triangle t: face2)
		{
			Triangles.add(new Triangle(new Vertex(t.getV1().getX(), t.getV1().getY(), t.getV1().getZ()),
					new Vertex(t.getV2().getX(), t.getV2().getY(), t.getV2().getZ()),
					new Vertex(t.getV3().getX(), t.getV3().getY(), t.getV3().getZ())));
		}
		
		for (Triangle t: face3)
		{
			Triangles.add(new Triangle(new Vertex(t.getV1().getX(), t.getV1().getY(), t.getV1().getZ()),
					new Vertex(t.getV2().getX(), t.getV2().getY(), t.getV2().getZ()),
					new Vertex(t.getV3().getX(), t.getV3().getY(), t.getV3().getZ())));
		}
		
		for (Triangle t: face4)
		{
			Triangles.add(new Triangle(new Vertex(t.getV1().getX(), t.getV1().getY(), t.getV1().getZ()),
					new Vertex(t.getV2().getX(), t.getV2().getY(), t.getV2().getZ()),
					new Vertex(t.getV3().getX(), t.getV3().getY(), t.getV3().getZ())));
		}
		
		for (Triangle t: face5)
		{
			Triangles.add(new Triangle(new Vertex(t.getV1().getX(), t.getV1().getY(), t.getV1().getZ()),
					new Vertex(t.getV2().getX(), t.getV2().getY(), t.getV2().getZ()),
					new Vertex(t.getV3().getX(), t.getV3().getY(), t.getV3().getZ())));
		}
		
		for (Triangle t: face6)
		{
			Triangles.add(new Triangle(new Vertex(t.getV1().getX(), t.getV1().getY(), t.getV1().getZ()),
					new Vertex(t.getV2().getX(), t.getV2().getY(), t.getV2().getZ()),
					new Vertex(t.getV3().getX(), t.getV3().getY(), t.getV3().getZ())));
		}
		
	}
	
	//public List<Triangle> getTriangles()
	//{
	//	return Triangles;
	//}
	//Cube(List<Triangle>face1, List<Triangle>face2, )
	public String toString()
	{
		return "Rectangular";
	}
}
