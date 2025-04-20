package FirstPersonControl;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import newproject.Camera;

public class KeyEventManager implements KeyListener{
	
	public Camera camera;
	public JPanel renderPanel;
	public double speed;
	
	public void setCamera(Camera camera)
	{
		this.camera = camera;
	}

	public void setRenderPanel(JPanel renderPanel)
	{
		this.renderPanel = renderPanel;
	}
	public void setSpeed(double speed)
	{
		this.speed = speed;
	}
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
			if (renderPanel!= null) renderPanel.repaint();
			break;
		case 's':
			camera.setZ(camera.getZ() - speed);
			camera.update();
			if (renderPanel!= null) renderPanel.repaint();
			break;
		case 'd':
			camera.setX(camera.getX() + speed);
			camera.update();
			if (renderPanel!= null) renderPanel.repaint();
			break;
		case 'w':
			camera.setZ(camera.getZ() + speed);
			camera.update();
			if (renderPanel!= null) renderPanel.repaint();
			break;
		case 'e':
			camera.setY(camera.getY() + speed);
			camera.update();
			if (renderPanel!= null) renderPanel.repaint();
			break;
		case 'q':
			camera.setY(camera.getY() - speed);
			camera.update();
			if (renderPanel!= null) renderPanel.repaint();
			break;
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
