import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public  class ButtonGenerator extends JButton implements ActionListener{
	
	
	public Color[] colors;
	public int current=0;
	
	public ButtonGenerator()
	{
		 
		 
		// TODO Auto-generated method stub
		 colors = new Color[10];
		colors[1]=Color.BLACK;
		colors[2]=Color.BLUE;
		colors[3]=Color.RED;
		colors[4]=Color.GREEN;
		colors[5]=Color.ORANGE;
		colors[6]=Color.YELLOW;
		colors[7]=Color.GRAY;
		colors[8]=Color.CYAN;
		colors[9]=Color.PINK; 
		this.addActionListener(this); 
	}
	



	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		current++;
		if(current < 10)
		{
			this.setBackground(colors[current]);
		}
		else
		{
			current = 1;
			this.setBackground(colors[current]);
		}
		
		
		// TODO Auto-generated method stub
		
		
	}


	
	 

}
