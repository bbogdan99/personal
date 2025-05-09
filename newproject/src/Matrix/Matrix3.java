package Matrix;

import newproject.Vertex;

public class Matrix3 
{
	double[]values;
	Matrix3 (double[]values)
	{
		this.values = values;
	}
	public Matrix3 multiply(Matrix3 other)
	{
		double[] result = new double[9];
		for (int row=0; row<3; row++)
			for (int col = 0; col<3; col++)
				for (int i=0; i<3; i++)
		result[row*3 + col]+= this.values[row*3 + i] * other.values[i*3 + col];
		
		return new Matrix3(result);
	}
	
	public Matrix3 subtract(Matrix3 other)
	{
		double[] result = new double[9];
		for (int row=0; row<3; row++)
			for (int col = 0; col<3; col++)
				result[row*3 + col] = this.values[row*3 + col] - other.values[row*3 + col];
		
		return new Matrix3(result);
	}
	
	public Matrix3 add(Matrix3 other)
	{
		double[] result = new double[9];
		for (int row=0; row<3; row++)
			for (int col = 0; col<3; col++)
				result[row*3 + col] = this.values[row*3 + col] + other.values[row*3 + col];
		
		return new Matrix3(result);
	}
	
	
	
	public Vertex transform(Vertex in)
	{
		
		return new Vertex (
		in.getX()*values[0] + in.getY()*values[3] + in.getZ()*values[6],
		in.getX()*values[1] + in.getY()*values[4] + in.getZ()*values[7],
		in.getX()*values[2] + in.getY()*values[5] + in.getZ()*values[8]		
				);
	}
	
	public Matrix3 rotateAroundZ(double angle)
	{
		return this.multiply(Matrix3.rotateAroundZMatrix(angle));
	}
	public Matrix3 rotateAroundX(double angle)
	{
		return this.multiply(Matrix3.rotateAroundXMatrix(angle));
	}
	public Matrix3 rotateAroundY(double angle)
	{
		return this.multiply(Matrix3.rotateAroundYMatrix(angle));
	}
	
	public static Matrix3 rotateAroundZMatrix(double angle)
	{
		return new Matrix3 (new double[] {
			Math.cos(angle), -Math.sin(angle), 0,
			Math.sin(angle), Math.cos(angle), 0,
			0,                  0,            1
		});
	}
	
	public static Matrix3 rotateAroundXMatrix(double angle)
	{
		return new Matrix3 (new double[] {
			1, 0, 0,
			0, Math.cos(angle), -Math.sin(angle),
			0, Math.sin(angle), Math.cos(angle)
		});
	}
	
	public static Matrix3 rotateAroundYMatrix(double angle)
	{
		return new Matrix3 (new double[] {
			Math.cos(angle), 0, Math.sin(angle),
			0, 1, 0,
			-Math.sin(angle), 0, Math.cos(angle)
		});
	}
	
	public static Matrix3 identityMatrix3()
	{
		return new Matrix3(new double[] {
			1,0,0,
			0,1,0,
			0,0,1
		});
	}
	
	public static Matrix3 zeroMatrix3()
	{
		return new Matrix3(new double[] {
			0,0,0,
			0,0,0,
			0,0,0
		});
	}
	
	public static Matrix3 scale(double sx, double sy, double sz)
	{
		return new Matrix3(new double[] {
				sx, 0, 0,
				0, sy, 0,
				0, 0, sz
		});
	}
	
	public Matrix4 toMatrix4()
	{
		return new Matrix4(new double[] {
				values[0], values[1], values[2], 0,
				values[3], values[4], values[5], 0,
				values[6], values[7], values[8], 0,
				0, 0, 0, 1
		});
	}
}
