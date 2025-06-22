package newproject;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Triangle {
	Vertex v1,v2,v3;
	UV uv1, uv2, uv3;
	BufferedImage texture;
	
	Color color;
	public int clampedv1, clampedv2, clampedv3;
	
	
	public Triangle(Vertex v1, Vertex v2, Vertex v3, Color color, int clampedv1,int clampedv2, int clampedv3, UV uv1, UV uv2, UV uv3, BufferedImage texture)
	{
		this.v1=v1;
		this.v2=v2;
		this.v3=v3;
		this.color=color;
		this.clampedv1 = clampedv1;
		this.clampedv2 = clampedv2;
		this.clampedv3 = clampedv3;
		this.uv1 = uv1;
		this.uv2 = uv2;
		this.uv3 = uv3;
		this.texture = texture;
		
		addFaceNormal();
	}
	public Triangle(Vertex v1, Vertex v2, Vertex v3, Color color, int clampedv1,int clampedv2, int clampedv3, UV uv1, UV uv2, UV uv3)
	{
		this.v1=v1;
		this.v2=v2;
		this.v3=v3;
		this.color=color;
		this.clampedv1 = clampedv1;
		this.clampedv2 = clampedv2;
		this.clampedv3 = clampedv3;
		this.uv1 = uv1;
		this.uv2 = uv2;
		this.uv3 = uv3;
		
		addFaceNormal();
	}
	
	public Triangle(Vertex v1, Vertex v2, Vertex v3, Color color, int clampedv1,int clampedv2, int clampedv3)
	{
		this.v1=v1;
		this.v2=v2;
		this.v3=v3;
		this.color=color;
		this.clampedv1 = clampedv1;
		this.clampedv2 = clampedv2;
		this.clampedv3 = clampedv3;
		
		addFaceNormal();
	}
	public Triangle(Vertex v1, Vertex v2, Vertex v3, Color color)
	{
		this.v1=v1;
		this.v2=v2;
		this.v3=v3;
		this.color=color;
		clampedv1 = 0;
		clampedv2 = 0;
		clampedv3 = 0;
		
		addFaceNormal();
	}
	public Triangle(Vertex v1, Vertex v2, Vertex v3)
	{
		this.v1=v1;
		this.v2=v2;
		this.v3=v3;
		this.color=Color.WHITE;
		clampedv1 = 0;
		clampedv2 = 0;
		clampedv3 = 0;
		
		addFaceNormal();
	}
	
	public void addFaceNormal()
	{
		Vertex e1 = v2.subtract(v1);
		Vertex e2 = v3.subtract(v1);
		Vertex fN = e1.cross(e2).normalizeVect();
		
		v1.xn += v1.xn + fN.getX();
		v1.yn += v1.yn + fN.getY();
		v1.zn += v1.zn + fN.getZ();
		
		v2.xn += v2.xn + fN.getX();
		v2.yn += v2.yn + fN.getY();
		v2.zn += v2.zn + fN.getZ();
		
		v3.xn += v3.xn + fN.getX();
		v3.yn += v3.yn + fN.getY();
		v3.zn += v3.zn + fN.getZ();
	}
	
	public Vertex getV1() {return v1;}
	public Vertex getV2() {return v2;}
	public Vertex getV3() {return v3;}
	public Color getColor() { return color;}
	public void setClamped(int clampedv1, int clampedv2, int clampedv3) 
	{
		this.clampedv1 = clampedv1;
		this.clampedv2 = clampedv2;
		this.clampedv3 = clampedv3;
	}
	
	public void setTexture(BufferedImage texture) {this.texture = texture;}
	public BufferedImage getTexture() {return texture;}
	
	public void setUV1(UV uv1) {this.uv1 = uv1;}
	public void setUV2(UV uv2) {this.uv2 = uv2;}
	public void setUV3(UV uv3) {this.uv3 = uv3;}
	
	public UV getUV1() {return uv1;}
	public UV getUV2() {return uv2;}
	public UV getUV3() {return uv3;}
}
