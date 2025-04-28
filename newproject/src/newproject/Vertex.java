package newproject;

public class Vertex {
	double x,y,z, w;
	public Vertex(double x, double y, double z, double w)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	
	public Vertex(double x, double y, double z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		w = 1.0;
	}
	
	public Vertex(Vertex v1) {
		this.x = v1.x;
		this.y = v1.y;
		this.z = v1.z;
		this.w = v1.w;
	}

	public Vertex subtract(Vertex other)
	{
		return new Vertex(this.x - other.x, this.y - other.y, this.z - other.z, 1);
	}
	public double dot(Vertex other)
	{
		return this.x * other.x + this.y * other.y + this.z * other.z;
	}
	public Vertex cross(Vertex other)
	{
		return new Vertex(this.y*other.z - this.z*other.y, this.z*other.x - this.x*other.z, this.x*other.y - this.y * other.x );
	}
	public Vertex normalizeVect()
	{
		double length = Math.sqrt(x*x + y*y + z*z);
		if (length == 0.0) return new Vertex(0,0,0);
		return new Vertex(x/length, y/length, z/length);
	}
	
	public double getX() {return x;}
	public double getY() {return y;}
	public double getZ() {return z;}
	public double getW() {return w;}
	public void normalize()
	{
		if (w==0) 
		{
			w = 1;
		}
		else
		{
			x = x/w;
			y = y/w;
			z = z/w;
			w = 1;
		}
	}
	
	
	public void setX(double X) {this.x =X;}
	public void setY(double Y) {this.y =Y;}
	public void setZ(double Z) {this.z =Z;}
	public void setW(double W) {this.w =W;}
}
