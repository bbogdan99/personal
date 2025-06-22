package World;

import java.awt.Color;

import newproject.Vertex;

public class SpotLight implements LightSource
{
	Vertex pos;
	Vertex direction;
	Color color;
	double cutoff, outerCutoff;
	double constant, linear, quadratic;
	
	public SpotLight(Vertex pos, Vertex direction, Color color, double cutoff, double outerCutoff,
			double constant, double linear, double quadratic)
	{
		this.pos = new Vertex(pos);
		this.direction = new Vertex(direction.normalizeVect());
		this.color = color;
		this.cutoff = cutoff;
		this.outerCutoff = outerCutoff;
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
		return LightType.SPOT_LIGHT;
	}

	public Vertex getPos() {return pos;}
	public Vertex getDirection() {return direction;}
	public double getInnerCone() {return cutoff;}
	public double getOuterCone() {return outerCutoff;}
	public double getConstant() {return constant;}
	public double getLinear() {return linear;}
	public double getQuadratic() {return quadratic;}
	
	public void setPos(Vertex pos) {this.pos = new Vertex(pos);}
	public void setDirection(Vertex direction) {this.direction = direction.normalizeVect();}
	public void setColor(Color color) {this.color = color;}
	public void setInnerCone(double cutoff) {this.cutoff = cutoff;}
	public void setOuterCone(double outerCutoff) {this.outerCutoff = outerCutoff;}
	public void setConstant(double constant) {this.constant = constant;}
	public void setLinear(double linear) {this.linear = linear;}
	public void setQuadratic(double quadratic) {this.quadratic = quadratic;}
}
