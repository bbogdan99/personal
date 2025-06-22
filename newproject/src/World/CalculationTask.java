package World;

import java.util.ArrayList;
import java.util.Arrays;

import Utils.ClippingEngine.Plane;
import newproject.Camera;
import newproject.Material;
import newproject.Triangle;
import newproject.Vertex;

public class CalculationTask implements Runnable
{
	private Scene scene;
	private Vertex v;
	private Material M;
	private double[] result = new double[3];

	

	public CalculationTask(Scene scene)
	{
		this.scene = scene;
		//result = new double[3];
	}

	@Override
	public void run() 
	{
		// TODO Auto-generated method stub
		//result = new double[] {0,0,0};
		result = calculateLighting();
	}
	
	public double[] getResult()
	{
		//System.out.println(result[0] + " " + result[1] + " " + result[2]);
		return result;
	}
	
	public double[] calculateLighting()
	{
		double iA = 0.0, iB = 0.0, iC =0.0;
		Camera cam = scene.getCam();
		//System.out.println("Number of lights: " + scene.getLightSources().size());
		for (LightSource light: scene.getLightSources())
		{
			switch (light.getType())
			{
			case DIRECTIONAL_LIGHT:
				Vertex cv = v.getNormal();
				
				Vertex viewDir = (new Vertex(cam.getX() - v.getX(), cam.getY() - v.getY(), cam.getZ() - v.getZ())).normalizeVect();
				Vertex half = (new Vertex(light.getDirection().getX() + viewDir.getX(),
						light.getDirection().getY() + viewDir.getY(),
						light.getDirection().getZ() + viewDir.getZ())).normalizeVect();
				
				double diffuse = Math.max(0.0, cv.dot( light.getDirection() ));
				double specular = Math.pow(Math.max(0.0, cv.dot(half)), M.getB());
				
				iA += M.getKd() * light.getColor().getRed() * diffuse + M.getKs() * light.getColor().getRed() * specular;
				iB += M.getKd() * light.getColor().getGreen() * diffuse + M.getKs() * light.getColor().getGreen() * specular;
				iC += M.getKd() * light.getColor().getBlue() * diffuse + M.getKs() * light.getColor().getBlue() * specular;
				break;
			case POINT_LIGHT:
				Vertex pv = v.getNormal();
				
				Vertex lightDir = new Vertex(light.getPos().getX() - v.getX(), light.getPos().getY() - v.getY(),
						light.getPos().getZ() - v.getZ());
				
				double dist = Math.sqrt( (v.getX() - light.getPos().getX()) * (v.getX() - light.getPos().getX()) +
						(v.getY() - light.getPos().getY()) * (v.getY() - light.getPos().getY()) + 
						(v.getZ() - light.getPos().getZ()) * (v.getZ() - light.getPos().getZ()));
				
				lightDir = lightDir.normalizeVect();
				
				Vertex pviewDir = (new Vertex(cam.getX() - v.getX(), cam.getY() - v.getY(), cam.getZ() - v.getZ())).normalizeVect();
				Vertex phalf = (new Vertex(lightDir.getX() + pviewDir.getX(),
						lightDir.getY() + pviewDir.getY(),
						lightDir.getZ() + pviewDir.getZ())).normalizeVect();
				
				double diffuseP = Math.max(0.0, pv.dot( lightDir ));
				double specularP = Math.pow(Math.max(0.0, pv.dot(phalf)), M.getB());
				
				double attenuation = 1.0 / (light.getConstant() + light.getLinear() * dist + light.getQuadratic() * dist * dist);
				
				iA += attenuation * (M.getKd() * light.getColor().getRed() * diffuseP + M.getKs() * light.getColor().getRed() * specularP);
				iB += attenuation * (M.getKd() * light.getColor().getGreen() * diffuseP + M.getKs() * light.getColor().getGreen() * specularP);
				iC += attenuation * (M.getKd() * light.getColor().getBlue() * diffuseP + M.getKs() * light.getColor().getBlue() * specularP);
				
				break;
			case SPOT_LIGHT:
				Vertex sv = v.getNormal();
				
				Vertex lightVec = new Vertex(light.getPos().getX() - v.getX(), light.getPos().getY() - v.getY(),
						light.getPos().getZ() - v.getZ());
				
				double distS = Math.sqrt( (v.getX() - light.getPos().getX()) * (v.getX() - light.getPos().getX()) + 
						(v.getY() - light.getPos().getY()) * (v.getY() - light.getPos().getY()) + 
						(v.getZ() - light.getPos().getZ()) * (v.getZ() - light.getPos().getZ()));
				
				Vertex lightDirS = lightVec.normalizeVect();
				Vertex viewDirS = new Vertex(cam.getX() - v.getX(), cam.getY() - v.getY(), cam.getZ() - v.getZ()).normalizeVect();
				
				Vertex halfS = new Vertex( lightDirS.getX() + viewDirS.getX(), lightDirS.getY() + viewDirS.getY(),
						lightDirS.getZ() + viewDirS.getZ()).normalizeVect();
				
				double diffuseS = Math.max(0.0, sv.dot(lightDirS));
				double specularS = Math.pow(Math.max(0.0, sv.dot(halfS)), M.getB());

				Vertex spotDir = light.getDirection().normalizeVect();
				double spotFactor = lightDirS.dot(spotDir);

				if (spotFactor > Math.cos(light.getOuterCone())) 
				{
					double falloff = Math.pow(spotFactor, light.getInnerCone());

					double attenuationS = 1.0 / (light.getConstant() + light.getLinear() * distS + light.getQuadratic() * distS * distS);

					iA += attenuationS * falloff * (M.getKd() * light.getColor().getRed() * diffuseS + M.getKs() * light.getColor().getRed() * specularS);
					iB += attenuationS * falloff * (M.getKd() * light.getColor().getGreen() * diffuseS + M.getKs() * light.getColor().getGreen() * specularS);
					iC += attenuationS * falloff * (M.getKd() * light.getColor().getBlue() * diffuseS + M.getKs() * light.getColor().getBlue() * specularS);
				}
				break;
			case AMBIENT_LIGHT:
				iA += M.getKa() * light.getColor().getRed();
				iB += M.getKa() * light.getColor().getGreen();
				iC += M.getKa() * light.getColor().getBlue();
				break;
			default:
				break;
			}
		}
		iA += M.getKa() * scene.getIa().getColor().getRed();
		iB += M.getKa() * scene.getIa().getColor().getGreen();
		iC += M.getKa() * scene.getIa().getColor().getBlue();
		
		iA = clampIntensity(iA);
		iB = clampIntensity(iB);
		iC = clampIntensity(iC);
		
		//System.out.println("Lighting result: " + iA + " " + iB + " " + iC);
		
		return new double[]{iA, iB, iC};
	}
	
	public void NDC(Vertex v, int W, int H)
	{
		v.normalize();
		v.setX( (v.getX() + 1.0) * 0.5 * (double)W );
		v.setY( (1.0 - v.getY()) * 0.5 * (double)H );
	}
	
	private double clampIntensity(double intensity)
	{
		intensity = (intensity > 255.0) ? 255.0 : intensity;
		intensity = (intensity < 0.0) ? 0.0 : intensity;
		return intensity;
	}
	
	public void setV(Vertex v) {this.v = new Vertex(v);}
	public void setM(Material m) {M = new Material(m);}
	public Vertex getV() {return v;}
	public Material getM() {return M;}
}
