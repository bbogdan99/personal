package newproject;

import java.awt.Color;

public class Material 
{
	private double ka, kd, ks, B;
	private Color color;
	public Material()
	{
		ka = 0.2;
		kd = 0.7;
		ks = 0.05;
		B = 32.0;
		color = Color.WHITE;
	}
	public Material(double ka, double kd, double ks, double B)
	{
		this.ka = ka;
		this.kd = kd;
		this.ks = ks;
		this.B = B;
		color = Color.WHITE;
	}
	public Material(double ka, double kd, double ks, double B, Color color)
	{
		this.ka = ka;
		this.kd = kd;
		this.ks = ks;
		this.B = B;
		this.color = color;
	}
	public void setKa(double ka) {this.ka = ka;}
	public void setKd(double kd) {this.kd = kd;}
	public void setKs(double ks) {this.ks = ks;}
	public void setB(double B) {this.B = B;}
	public void setColor(Color color) {this.color = color;}
	public double getKa() {return ka;}
	public double getKs() {return ks;}
	public double getKd() {return kd;}
	public double getB() {return B;}
	public Color getColor() {return color;}
}
