package FirstPersonControl;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import UIManager.WorldOptions;
import newproject.Camera;

public class MouseControlManager implements MouseMotionListener, MouseListener
{
	public Camera camera;
	public JPanel renderPanel;
	
	boolean Pressed;
	
	int lastX, lastY;

    double sensitivity;
    
    private WorldOptions worldOptions;
	
	public MouseControlManager() 
	{
		Pressed = false;
		lastX = lastY = 0;
		sensitivity = .01;
	}
	public void setCamera(Camera camera){this.camera = camera;}
	public void setRenderPanel(JPanel renderPanel){this.renderPanel = renderPanel;}
	
	public void setSensitivity(double sensitivity) {this.sensitivity = sensitivity;}
	public void resetSensitivity() {sensitivity = .01;}
	public double getSensitivity() {return sensitivity;}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
		int dx = e.getX() - lastX;
	    int dy = e.getY() - lastY;

	    
	    camera.setYaw(camera.getYaw() + dx*sensitivity);
	    camera.setPitch(camera.getPitch() + dy*sensitivity);
		
	    lastX = e.getX();
		lastY = e.getY();
	    
		camera.update();
		worldOptions.updateRelevant();
		if (renderPanel!= null) renderPanel.repaint();
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		Pressed = true;
		lastX = e.getX();
		lastY = e.getY();
		
		camera.update();
		worldOptions.updateRelevant();
		if (renderPanel!= null) renderPanel.repaint();
		renderPanel.requestFocusInWindow();
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		Pressed = false;
		camera.update();
		worldOptions.updateRelevant();
		if (renderPanel!= null) renderPanel.repaint();
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void setWorldOptions(WorldOptions worldOptions) {this.worldOptions = worldOptions;}	
	
	
}
