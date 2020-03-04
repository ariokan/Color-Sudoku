import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SetFrame {
	
	int clickCount=1;
	JButton btn_show =new JButton("Show Answer");
	JButton  btn_check =new JButton("check");
	JButton  btn_new = new JButton("new");
	
	JFrame frame = new JFrame();;
	ArrayList<ButtonGenerator> buttons  = new ArrayList<ButtonGenerator>();
	ArrayList<Integer> log  = new ArrayList<Integer>();
	Color colors[]=new Color[10];
	int[][] sudoku;
	
	SudokuGenerator sdkGen;
	
	
	public SetFrame() {
		setButtons();
		
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
			
		btn_new.setBounds(470, 640, 70, 30);
		btn_check.setBounds(550, 640, 70, 30);
		btn_show.setBounds(5, 640, 130, 30);
		
		frame.add(btn_check);
		frame.add(btn_show);
		frame.add(btn_new);
		frame.setBounds(100, 100, 643 , 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		sdkGen = new SudokuGenerator();
		sdkGen.nextBoard(32);
		sudoku = sdkGen.board;
		
		colors[1]=Color.BLACK;
		colors[2]=Color.BLUE;
		colors[3]=Color.RED;
		colors[4]=Color.GREEN;
		colors[5]=Color.ORANGE;
		colors[6]=Color.YELLOW;
		colors[7]=Color.GRAY;
		colors[8]=Color.CYAN;
		colors[9]=Color.PINK;
          CheckMatris();
          NewSudoku();
          ShowAnswer();

		}
	
	public void NewSudoku(){
		 btn_new.addActionListener(new ActionListener(){
			 
				
				@Override
				public void actionPerformed(ActionEvent Arg0) {
					
					sdkGen = new SudokuGenerator();
					sdkGen.nextBoard(27);
					sudoku = sdkGen.board;
					int loop=0;
					int temp = 0;			
					for(int i=0;i<=8;i++){
						for(int j=0;j<=8;j++){
						
							temp=sudoku[i][j];
							buttons.get(loop).current=0;
							buttons.get(loop).setBackground(colors[temp]);
							buttons.get(loop).setBorder(null);
							if(temp != 0)
							{
								buttons.get(loop).setEnabled(false);
								
							}
							else
							{
								buttons.get(loop).setEnabled(true);
							}
							loop++;
							System.out.println(temp);
						}
					}
				}
			});
	}
	public void setButtons(){
		for(int row = 0; row<9 ; row++ )
		{
			for(int col = 0; col<9 ; col++)
			{
			ButtonGenerator button=new ButtonGenerator();
			button.setBounds(row*70,col*70, 66, 66);
			buttons.add(button);
			frame.getContentPane().add(button);
			}
		}
	}
	
	public void ShowAnswer(){

		btn_show.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent Arg0) {
				
				int loop=0;
				for(int i=0;i<=8;i++){
					for(int j=0;j<=8;j++){
						int temp = 0;						
						temp=sdkGen.solution[i][j];
						buttons.get(loop).setBackground(colors[temp]);
						loop++;
					}
				}
			}
		});	
	}
	
	public void  CheckMatris(){
	
		btn_check.addActionListener(new ActionListener(){
              
				@Override
				public void actionPerformed(ActionEvent Arg0) {
					int index ;
					int correct=0;
					for(int i=0;i<9;i++){
						index = i * 9 ;
						for(int j=0;j<9;j++){
								if(sdkGen.solution[i][j] == buttons.get(index).current)
								{	
									System.out.println("doðru gardaþým"+index);
									buttons.get(index).setBorder(null);
									correct++;
									System.out.println(correct);
								}
								else
								{
									if(buttons.get(index).isEnabled() == true)
									{
										System.out.println("yanlýþ gardaþým"+index);
										buttons.get(index).setBorder(BorderFactory.createLineBorder(Color.red, 5)); 
									}
									
								}
								index++;
  
						}
					}
				}
		   });
	   }
	}
	
	
	

