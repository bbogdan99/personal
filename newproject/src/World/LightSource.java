package World;

import java.awt.Color;

import newproject.Vertex;

public interface LightSource 
{
	Color getColor();
	LightType getType();
	
	default Vertex getPos() {return null;}
	default Vertex getDirection() {return null;}
	
	default double getConstant() {return 1.0;}
	default double getLinear() {return 0.0;}
	default double getQuadratic() {return 0.0;}
	
	default double getInnerCone() {return 1.0;}
	default double getOuterCone() {return 1.0;}
}
