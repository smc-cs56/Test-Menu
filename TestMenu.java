import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;
// same functionality. doesn't use whole package

public class TestMenu extends JFrame implements ActionListener{

 private JButton magicButton;
 private JButton memoryButton;
 private JButton instructButton;
 private JButton close;
 private ImageIcon mainImg;
 private JLabel mainLabel;
 
 public TestMenu(){
      JPanel p = new JPanel();
      p.setLayout(null);
      
      mainImg = new ImageIcon(getClass().getResource("newFrontImage.jpg"));
		mainLabel = new JLabel(mainImg);
		mainLabel.setBounds(150,50,480,360);
		this.add(mainLabel);
      
      magicButton = new JButton("magic trick");
      magicButton.setBounds(150,470,100,40);
      magicButton.addActionListener(this);
      p.add(magicButton);
      
      memoryButton = new JButton("memory");
      memoryButton.setBounds(275,470,100,40);
      magicButton.addActionListener(this);
      p.add(memoryButton);
      
      instructButton = new JButton("instructions");
      instructButton.setBounds(400,470,100,40);
      instructButton.addActionListener(this);
      p.add(instructButton);
      
      close = new JButton("close");
      close.setBounds(525,470,100,40);
      close.addActionListener(this);
      p.add(close);
      
      
      
      getContentPane().add(p); // what does this do?
      
      Color customColor= new Color(15,112,1);
      p.setBackground(customColor);
      //setLayout(null);
      this.setDefaultCloseOperation(3);
      this.setSize(800,600);
      this.setVisible(true);

     }
 
 	public void actionPerformed (ActionEvent e)
 	{
 		if(e.getSource()==magicButton)
 		{
 			// vanishes. unsure if I should remove it
 			this.setVisible(false);
 			JYCardTrick test = JYCardTrick.getInstance(); // play the magic card game
 			//JYCardTrick();
 		}
 		else if (e.getSource()==memoryButton)
 		{
 			//memoryButton();
 		}
 		else if (e.getSource()==instructButton)
 		{
 			JFrame Instruct = new JFrame();
			Instruct instructions = new Instruct();
			//instructions.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			instructions.setSize(300,200);
			instructions.setVisible(true);
 		}
 		else if(e.getSource()==close)
 		{
 			System.exit(0);
 		}
 	}
   public static void main(String[]args){
       new TestMenu();
       }
}

class Instruct extends JFrame implements ActionListener
{
	private JTextArea instructions = new JTextArea();
	private JButton back;
	
	public Instruct()
	{
		setLayout(new FlowLayout());
		//instructions area
		instructions = new JTextArea("INSTRUCTIONS INSTRUCTIONS INSTRUCTIONS \nINSTRUCTIONS INSTRUCTIONS INSTRUCTIONS \nINSTRUCTIONS INSTRUCTIONS INSTRUCTIONS \n ");
		add(instructions);
		
		back = new JButton("Back");
		back.addActionListener(this);
		add(back);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==back)
		{
			this.dispose();
		}
	}
}
