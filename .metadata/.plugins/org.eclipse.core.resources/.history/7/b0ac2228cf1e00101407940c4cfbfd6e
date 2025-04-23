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
		w = 1;
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
