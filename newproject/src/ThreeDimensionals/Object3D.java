package ThreeDimensionals;

import java.awt.Color;
import java.util.ArrayList;

import Matrix.Matrix4;
import newproject.Triangle;
import newproject.Vertex;

public class Object3D 
{
	ArrayList<Triangle>Triangles;
	Matrix4 TRS;
	double ka, kd, ks;
	double B;
	Color color;
	
	
	public Object3D()
	{
		Triangles = new ArrayList<Triangle>();
		TRS = new Matrix4();
		ka = 0.2;
		kd = 0.7;
		ks = 0.05;
		B = 8.0;
		color = Color.WHITE;
	}
	public Object3D(ArrayList<Triangle>Triangles)
	{
		this.Triangles = new ArrayList<Triangle>();
		for (Triangle t: Triangles) 
		{
			Triangle a = new Triangle(t.getV1(), t.getV2(), t.getV3(), t.getColor());
			this.Triangles.add(a);
		}
		TRS = new Matrix4();
		ka = 0.2;
		kd = 0.7;
		ks = 0.05;
		B = 8.0;
		color = Color.WHITE;
	}
	public Object3D(ArrayList<Triangle>Triangles, Matrix4 TRS)
	{
		this.Triangles = new ArrayList<Triangle>();
		for (Triangle t: Triangles) 
		{
			Triangle a = new Triangle(t.getV1(), t.getV2(), t.getV3(), t.getColor());
			this.Triangles.add(a);
		}
		this.TRS = new Matrix4();
		this.TRS.setValues(TRS.getValues());
		ka = 0.2;
		kd = 0.7;
		ks = 0.05;
		B = 8.0;
		color = Color.WHITE;
	}
	public Object3D(Object3D other)
	{
		this.Triangles = new ArrayList<Triangle>();
		for (Triangle t: other.Triangles) 
		{
			Triangle a = new Triangle(new Vertex(t.getV1()), new Vertex(t.getV2()), new Vertex(t.getV3()), t.getColor());
			this.Triangles.add(a);
		}
		this.TRS = new Matrix4();
		this.TRS.setValues(other.TRS.getValues());
		this.ka = other.ka;
		this.ks = other.ks;
		this.kd = other.kd;
		this.B = other.B;
		this.color = other.color;
	}
	
	public void setTRS(Matrix4 other) {TRS.setValues(other.getValues());}
	public Matrix4 getTRS() {return TRS;}
	public void setKa(double ka) {this.ka = ka;}
	public void setKs(double ks) {this.ks = ks;}
	public void setKd(double kd) {this.kd = kd;}
	public double getKa() {return ka;}
	public double getKs() {return ks;}
	public double getKd() {return kd;}
	public void setB(double B) {this.B = B;}
	public double getB() {return B;}
	public void setColor(Color color) {this.color = color;}
	public Color getColor() {return color;}
	public ArrayList<Triangle> getTriangles() {return Triangles;}
	public void setTriangles(ArrayList<Triangle>Triangles) 
	{
		this.Triangles = new ArrayList<>();
		for (Triangle t : Triangles) 
		{
			this.Triangles.add(new Triangle(t.getV1(), t.getV2(), t.getV3(), t.getColor()));
		}
	}
}
