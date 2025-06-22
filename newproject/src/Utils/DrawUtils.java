package Utils;


import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class DrawUtils {
	
	public static void DrawPixel(BufferedImage img, int px, int py, int color)
	{
		img.setRGB(px, py, color);
	} //redundant
	
	public static void DrawWireframeTriangle(BufferedImage img,double p0x, double p0y, double p1x, double p1y, double p2x, double p2y, int color)
	{
		DrawLine(img, p0x, p0y, p1x, p1y, color);
		DrawLine(img, p0x, p0y, p2x, p2y, color);
		DrawLine(img, p1x, p1y, p2x, p2y, color);
	}
	
	public static void DrawLine(BufferedImage img, double p0x, double p0y,
			double p1x, double p1y, int color)
	{
		double x0 = p0x;
		double x1 = p1x;
		double y0 = p0y;
		double y1 = p1y;
		if (Math.abs(x1 - x0) > Math.abs(y1 - y0))
		{
			if (x0 > x1)
			{
				double temp = x0;
				x0 = x1;
				x1 = temp;
				temp = y0;
				y0 = y1;
				y1 = temp;
			}
			ArrayList<Integer> ys = Interpolate(x0, y0, x1, y1);
			for (int x = (int)x0; x<= x1; x++)
			{
				int temp = ys.get((int)x - (int)x0);
				img.setRGB(x, temp, color);
				//if (x >= 0 && x < img.getWidth() && temp >= 0 && temp < img.getHeight())
				//    img.setRGB(x, temp, color);
			}
		}
		else
		{
			if (y0 > y1)
			{
				double temp = x0;
				x0 = x1;
				x1 = temp;
				temp = y0;
				y0 = y1;
				y1 = temp;
			}
			ArrayList<Integer> xs = Interpolate(y0, x0, y1, x1);
			for (int y = (int)y0; y<= y1; y++)
			{
				int temp = xs.get((int)y - (int)y0);
				img.setRGB(temp, y, color);
			}
		}
	}

	private static ArrayList<Integer> Interpolate(double i0, double d0,
			double i1, double d1)
	{
		ArrayList<Integer> values = new ArrayList<>();
		if (i0 == i1)
		{
			values.add((int)d0);
			return values;
		}
		double a = (d1-d0) / (i1-i0);
		double d = d0;
		for (int i=(int) i0; i<=i1; i++)
		{
			int temp = (int)Math.round(d);
			values.add(temp);
			d+=a;
		}
		
		return values;
	}
	
	public static Color GetTexel(BufferedImage texture, double tx, double ty)
	{
		tx = (tx < 0.0) ? 0.0 : ( (tx > 1.0) ? 1.0 : tx);
		ty = (ty < 0.0) ? 0.0 : ( (ty > 1.0) ? 1.0 : ty);
		
		tx = tx * (texture.getWidth() - 1);
		ty = ty * (texture.getHeight() - 1);
		//tx = tx * (texture.getWidth())
		
		double fx = tx - (int)Math.floor(tx);
		double fy = ty - (int)Math.floor(ty);
		
		int x0 = (int)Math.floor(tx);
		int y0 = (int)Math.floor(ty);
		int x1 = (x0 + 1 < texture.getWidth() -1 )? x0+1 : texture.getWidth()-1;
		int y1 = (y0 + 1 < texture.getHeight() -1 )? y0+1 : texture.getHeight()-1;
		
	    Color TL = new Color(texture.getRGB(x0, y0));
	    Color TR = new Color(texture.getRGB(x1, y0));
	    Color BL = new Color(texture.getRGB(x0, y1));
	    Color BR = new Color(texture.getRGB(x1, y1));
		
	    int r = (int)bilinear(TL.getRed(), TR.getRed(), BL.getRed(), BR.getRed(), fx, fy);
	    int g = (int)bilinear(TL.getGreen(), TR.getGreen(), BL.getGreen(), BR.getGreen(), fx, fy);
	    int b = (int)bilinear(TL.getBlue(), TR.getBlue(), BL.getBlue(), BR.getBlue(), fx, fy);

	    return new Color(r, g, b);
	}
	
	private static double bilinear(double TL, double TR, double BL, double BR, double fx, double fy) {
	    double CT = (1 - fx) * TL + fx * TR;
	    double CB = (1 - fx) * BL + fx * BR;
	    return (1 - fy) * CT + fy * CB;
	}
}
