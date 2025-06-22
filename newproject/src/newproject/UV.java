package newproject;

public class UV 
{
	double u, v, w;
	public UV(double u, double v)
	{
		this.u = u;
		this.v = v;
		w = 1.0;
	}
	public UV(double u, double v, double w)
	{
		this.u = u;
		this.v = v;
		this.w = w;
	}
	
	public void flattened()
	{
		u = u/w;
		v = v/w;
		w = 1.0;
	
		u = u%1.0;
		v = v%1.0;
		while (u < 0.0) u++;
		while (v < 0.0) v++;
	}
	
	public double getU() {return u;}
	public double getV() {return v;}
	public double getW() {return w;}
	
	public void setU(double u) {this.u = u;}
	public void setV(double v) {this.v = v;}
	public void setW(double w) {this.w = w;}
}
