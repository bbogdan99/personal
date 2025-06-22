package FirstPersonControl;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import UIManager.WorldOptions;
import newproject.Camera;

public class KeyEventManager implements KeyListener{
	
	public Camera camera;
	public JPanel renderPanel;
	public double speed;
	private WorldOptions worldOptions;
	
	public void setCamera(Camera camera)
	{
		this.camera = camera;
		speed = 1.0;
	}

	public void setRenderPanel(JPanel renderPanel)
	{
		this.renderPanel = renderPanel;
	}
	public void setSpeed(double speed)
	{
		this.speed = speed;
	}
	public void resetSpeed() {speed = 1.0;}
	public double getSpeed() {return speed;}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyChar())
		{
		case 'a':
			camera.setX(camera.getX() - speed);
			camera.update();
			worldOptions.updateRelevant();
			if (renderPanel!= null) renderPanel.repaint();
			break;
		case 's':
			camera.setZ(camera.getZ() + speed);
			camera.update();
			worldOptions.updateRelevant();
			if (renderPanel!= null) renderPanel.repaint();
			break;
		case 'd':
			camera.setX(camera.getX() + speed);
			camera.update();
			worldOptions.updateRelevant();
			if (renderPanel!= null) renderPanel.repaint();
			break;
		case 'w':
			camera.setZ(camera.getZ() - speed);
			camera.update();
			worldOptions.updateRelevant();
			if (renderPanel!= null) renderPanel.repaint();
			break;
		case 'e':
			camera.setY(camera.getY() + speed);
			camera.update();
			worldOptions.updateRelevant();
			if (renderPanel!= null) renderPanel.repaint();
			break;
		case 'q':
			camera.setY(camera.getY() - speed);
			camera.update();
			worldOptions.updateRelevant();
			if (renderPanel!= null) renderPanel.repaint();
			break;
		}
		
		
	}

	
	public void setWorldOptions(WorldOptions worldOptions) {this.worldOptions = worldOptions;}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
