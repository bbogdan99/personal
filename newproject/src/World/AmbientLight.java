package World;

import java.awt.Color;

public class AmbientLight implements LightSource{

	Color color;
	
	public AmbientLight(Color color) {this.color = new Color(color.getRed(), color.getGreen() ,color.getBlue(), color.getAlpha());}
	
	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return color;
	}

	@Override
	public LightType getType() {
		// TODO Auto-generated method stub
		return LightType.AMBIENT_LIGHT;
	}
	
	public void setColor(Color color) {this.color = new Color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());}

}
