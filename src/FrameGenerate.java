import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class FrameGenerate  {

	JFrame gameFrame = new JFrame("COLOR MATCH"); // create a new frame with title color match												
	JPanel buttonsPanel = new JPanel(); // add a panel to the frame
	JPanel topPanel = new JPanel(); // for the top panel
	JButton parentButton = new JButton("MATCH MY COLOR");// created a new parent button parent button
	JButton[] button = new JButton[20];// declaring array of 20 buttons on south
	FrameGenerate f;
	int clickCounter=0;
	int clickRight=0;
	ColorRandom myRandColorParent;
	Random rand;

	public FrameGenerate() {

		gameFrame.setSize(600, 600);

		// center the Frame in screen

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		gameFrame.setLocation(dim.width / 2 - gameFrame.getSize().width / 2,
		dim.height / 2 - gameFrame.getSize().height / 2);

		gameFrame.setVisible(true);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buttonsPanel.setLayout(new GridLayout(4, 5));// change panel layout from border layout to grid layout											
		gameFrame.add(buttonsPanel, BorderLayout.SOUTH);// add panel to the south 
		gameFrame.setSize(600, 600);
		gameFrame.setBackground(Color.WHITE);

	}// FrameGnerate constructor

	public void parentGenerate() {
		parentButton.setPreferredSize(new Dimension(200, 200));// setting size

		topPanel.add(parentButton);// add button b to topPanel
		gameFrame.add(topPanel, BorderLayout.CENTER);// add topPanel to the
														// JFrame
		myRandColorParent = new ColorRandom();
		//ColorRandom myRandColorParent = new ColorRandom();// to generate random
															// color
		parentButton.setBackground(myRandColorParent.getRandColor());// parentButton.setBackground(Color.RED);
		parentButton.setOpaque(true);
		parentButton.setBorderPainted(false);

	}//parentGenerate

	public void childButtonGenerate(){
		for (int i = 0; i < 20; i++) {// adding all 20 buttons to the grid panel
			button[i] = new JButton("");
			buttonsPanel.add(button[i]);
			ColorRandom myRandColor = new ColorRandom();
			// to generate random color
			button[i].setBackground(myRandColor.getRandColor());
			button[i].setOpaque(true);
			button[i].setBorderPainted(false);
			
			button[i].addActionListener(new ActionListener() {
		   
			public  void actionPerformed(ActionEvent e) {
				
	            JButton button = (JButton)e.getSource();
	           clickCounter++;
	            if (button.getBackground() == parentButton.getBackground()) {
					//button.setVisible(false);
					button.setBackground(Color.BLACK);
					clickRight++;
	            }
	            
	            if(clickRight==5){// when all matching colors are clicked
	          
	    			JOptionPane.showMessageDialog( null, "Congratulations you clicked all matching colors in  "+clickCounter+" clicks");
	    			
	    			 int playAgain = JOptionPane.showConfirmDialog(null, " Do you want to play again ?", "It was fun!!!", JOptionPane.YES_NO_OPTION);
	    			    if (playAgain == JOptionPane.YES_OPTION)
	    			    {
	    			    	gameFrame.dispose();
	    			    	start();// start again if player chooses to.
	    			      
	    			    }
	    			    else System.exit(0);
	    			 
	            }
	      
				} //actionPerformed

			private void start() {
				 f = new FrameGenerate();
				//FrameGenerate f = new FrameGenerate();
				f.parentGenerate();
				f.childButtonGenerate();
				
			}
			});
			
		}//forloop
	
			//Random rand = new Random();
			rand = new Random();
			int color = rand.nextInt(4);// random object rand
			Color[] colors = new Color[] { Color.BLUE, Color.GREEN, Color.RED,
					Color.YELLOW };

			for (int j = 0; j < button.length; j++) {

				button[j].setBackground(colors[color]);
				color = (color + 1) % 4;		
		}// for
		
	}//childButtonGenerate

	
	
}// FrameGenerate class

