package World;

import java.awt.Color;

import newproject.Vertex;

public class DirectionalLight implements LightSource
{
	Color color;
	Vertex direction;
	
	public DirectionalLight(Color color, Vertex direction)
	{
		this.color = color;
		this.direction = new Vertex(direction.normalizeVect());
	}
	
	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return color;
	}

	@Override
	public LightType getType() {
		// TODO Auto-generated method stub
		return LightType.DIRECTIONAL_LIGHT;
	}

	public Vertex getDirection() {return direction;}
	public void setDirection(Vertex direction) {this.direction = direction.normalizeVect();}
	public void setColor(Color color) {this.color = color;}
}
