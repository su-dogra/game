import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;




public class StartFrame {
	
	FrameGenerate f;

		JFrame InitFrame = new JFrame("COLOR MATCH"); // Title
		JPanel buttonsPanel = new JPanel(); // add a panel to the frame
		JPanel topPanel = new JPanel(); // for the top panel
		JButton startButton = new JButton("LET'S MATCH COLORS");// created a new
		
		
		public StartFrame() {

			InitFrame.setSize(600, 600);

			// center the Frame in screen

			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			InitFrame.setLocation(dim.width / 2 - InitFrame.getSize().width / 2,
			dim.height / 2 - InitFrame.getSize().height / 2);

			InitFrame.setVisible(true);
	 		InitFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			buttonsPanel.setLayout(new GridLayout(4, 5));// change panel layout from border layout to grid layout
			InitFrame.add(buttonsPanel, BorderLayout.SOUTH);// add panel to the south
			InitFrame.setSize(600, 600);
			InitFrame.setBackground(Color.WHITE);
			
			startButton.setPreferredSize(new Dimension(200, 100));// setting size
			topPanel.add(startButton);// add button b to topPanel
			InitFrame.add(topPanel, BorderLayout.SOUTH);// add topPanel to JFrame 
			startButton.setBackground(Color.CYAN);
			startButton.setOpaque(true);
			startButton.setBorderPainted(false);

			
			startButton.addActionListener(new ActionListener() {     
	            public void actionPerformed(ActionEvent e) {
	            	if(e.getSource()== startButton){
	            
	            		InitFrame.dispose();// previous Frame
	            		f = new FrameGenerate();// Generate main frame again
	         // FrameGenerate f = new FrameGenerate();// Generate main frame again
	    		f.parentGenerate();
	    		f.childButtonGenerate();}
	            	
	            }
	        });
			
			
		}// Constructor StartFrame

		
	}// StratFrame

