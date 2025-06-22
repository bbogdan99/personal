package World;

import java.awt.Color;

import newproject.Vertex;

public class PointLight implements LightSource
{
	Vertex pos;
	Color color;
	double constant, linear, quadratic;

	public PointLight(Vertex pos, Color color, double constant, double linear, double quadratic)
	{
		this.pos = new Vertex(pos);
		this.color = color;
		this.constant = constant;
		this.linear = linear;
		this.quadratic = quadratic;
	}
	
	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return color;
	}

	@Override
	public LightType getType() {
		// TODO Auto-generated method stub
		return LightType.POINT_LIGHT;
	}
	
	public Vertex getPos() {return pos;}
	public double getConstant() {return constant;}
	public double getLinear() {return linear;}
	public double getQuadratic() {return quadratic;}
	
	public void setPos(Vertex pos) {this.pos = new Vertex(pos);}
	public void setColor(Color color) {this.color = color;}
	public void setConstant(double constant) {this.constant = constant;}
	public void setLinear(double linear) {this.linear = linear;}
	public void setQuadratic(double quadratic) {this.quadratic = quadratic;}
}
