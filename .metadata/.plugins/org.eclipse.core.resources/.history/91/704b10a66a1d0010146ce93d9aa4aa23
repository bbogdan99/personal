package newproject;

import Matrix.Matrix4;
//TODO LATER
public class Camera 
{

	Vertex pos;
	double pitch, yaw, roll; //x, y, z
	Matrix4 ViewMatrix;
	Matrix4 ProjectionMatrix;
	public Camera(Vertex pos, double pitch, double yaw, double roll)
	{
		this.pos = new Vertex(pos.getX(), pos.getY(), pos.getZ(), pos.getW());
		this.yaw = yaw;
		this.roll = roll;
		this.pitch = pitch;
		this.ViewMatrix = Matrix4.identityMatrix4();
		//this.ViewMatrix.setValues(Matrix4.identityMatrix4().getValues());
		//this.ProjectionMatrix.setValues(Matrix4.identityMatrix4().getValues());
		this.ProjectionMatrix = Matrix4.identityMatrix4();
	}
	public Camera()
	{
		this.pos = new Vertex(0,0,0,1);
		pitch = yaw = roll = 0;
		this.ViewMatrix = Matrix4.identityMatrix4();
		this.ProjectionMatrix = Matrix4.identityMatrix4();
		//this.ViewMatrix.setValues(Matrix4.identityMatrix4().getValues());
		//this.ProjectionMatrix.setValues(Matrix4.identityMatrix4().getValues());
	}
	public Matrix4 getCameraT()
	{
		return ViewMatrix.multiply(ProjectionMatrix);
	}
	public void update(double rx, double ry, double rz, double tx, double ty, double tz)
	{
		pos.setX(pos.getX() - tx);
		pos.setY(pos.getY() - ty);
		pos.setZ(pos.getZ() - tz);
		
		pitch-=rx; yaw-=ry; roll-=rz;
		setViewMatrix();
	}
	public void setViewMatrix()
	{
		Matrix4 Rx = Matrix4.rotateAroundXMatrix(Math.toRadians(-pitch));
		Matrix4 Ry = Matrix4.rotateAroundYMatrix(Math.toRadians(-yaw));
		Matrix4 Rz = Matrix4.rotateAroundZMatrix(Math.toRadians(-roll));
		
		Matrix4 T = Matrix4.translate(-pos.getX(), -pos.getY(), -pos.getZ());
		Matrix4 RT = Rx.multiply(Ry).multiply(Rz).multiply(T);
		ViewMatrix.setValues(RT.getValues());
	}
	public void setProjectionMatrix(double far, double near, double angle, double aspect)
	{
		ProjectionMatrix.setValues(Matrix4.perspectiveMatrix(far, near, angle, aspect).getValues());
	}
	public void setViewMatrix(Matrix4 mat)
	{
		this.ViewMatrix.setValues(mat.getValues());
	}
	public void setProjectionMatrix(Matrix4 mat)
	{
		this.ProjectionMatrix.setValues(mat.getValues());
	}
	public Matrix4 getViewMatrix()
	{
		return ViewMatrix;
	}
	public Matrix4 getProjectionMatrix()
	{
		return ProjectionMatrix;
	}
	
}
