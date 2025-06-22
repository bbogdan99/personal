package UIManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Matrix.Matrix4;
import ThreeDimensionals.Object3D;

public class NOTWORKINGReflectObjectButton extends JButton
{
	private Matrix4 TRS;
	public NOTWORKINGReflectObjectButton(String text, Matrix4 TRS)
	{
		this.setTRS(TRS);
		switch (text.toUpperCase())
		{
		case "X":
			setText("Reflect on X");
			setToolTipText("Set the object's scale on X to its negative value");
			this.addActionListener(new ActionListener() 
			{
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					double[] list = TRS.decomposeTRS();
					Matrix4 newTRS = new Matrix4(list[0], list[1], list[2], list[6], list[7], list[8], -list[3], list[4], list[5]);
					TRS.setValues(newTRS.getValues());
				}
			});
			break;
		case "Y":
			setText("Reflect on Y");
			setToolTipText("Set the object's scale on Y to its negative value");
			this.addActionListener(new ActionListener() 
			{
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					double[] list = TRS.decomposeTRS();
					Matrix4 newTRS = new Matrix4(list[0], list[1], list[2], list[6], list[7], list[8], list[3], -list[4], list[5]);
					TRS.setValues(newTRS.getValues());
				}
			});
			break;
		case "Z":
			setText("Reflect on Z");
			setToolTipText("Set the object's scale on Z to its negative value");
			this.addActionListener(new ActionListener() 
			{
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					double[] list = TRS.decomposeTRS();
					Matrix4 newTRS = new Matrix4(list[0], list[1], list[2], list[6], list[7], list[8], list[3], list[4], -list[5]);
					TRS.setValues(newTRS.getValues());
				}
			});
			break;
		default:
			setText("Incorrect axis (input must be X, Y or Z)");
			setToolTipText("You messed up");
			break;
		}
	}
	public Matrix4 getTRS() {
		return TRS;
	}
	public void setTRS(Matrix4 tRS) {
		TRS = tRS;
	}
	
}
