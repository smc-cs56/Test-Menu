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
 
 public class TestMenu extends JFrame implements ActionListener{
 
  private JButton magicButton;
  private JButton memoryButton;
  private JButton instructButton;
  private JButton close;
  private ImageIcon mainImg;
  private JLabel mainLabel;
  private JButton register;
  private JButton vreg;
  
  
  public TestMenu(){
       JPanel p = new JPanel();
       p.setLayout(null);
       
       mainImg = new ImageIcon(getClass().getResource("newFrontImage.jpg"));
       mainLabel = new JLabel(mainImg);
       mainLabel.setBounds(150,50,480,360);
       this.add(mainLabel);
	   
	   register = new JButton("Register");
	   register .setBounds(500,450,200,50);
	   register.addActionListener(this);
	   p.add(register);
       
	   vreg = new JButton("User List");
	   vreg .setBounds(300,500,200,50 );
	   vreg.addActionListener(this);
	   p.add(vreg);

       magicButton = new JButton("Magic Card");
       magicButton.setBounds(100,450,200,50);
       magicButton.addActionListener(this);
       p.add(magicButton);
       
       memoryButton = new JButton("Memory Game");
       memoryButton.setBounds(300,450,200,50);
       memoryButton.addActionListener(this);
       p.add(memoryButton);
       
       instructButton = new JButton("Instructions");
       instructButton.setBounds(100,500,200,50);
       instructButton.addActionListener(this);
       p.add(instructButton);
	   
	   
       
       close = new JButton("Close");
       close.setBounds(500,500,200,50);
       close.addActionListener(this);
       p.add(close);
       
       
       
       //getContentPane().add(p);
       this.add(p);
 
       Color customColor= new Color(15,112,1);
       p.setBackground(customColor);
       //setLayout(null);
       this.setDefaultCloseOperation(3);
       this.setSize(800,600);
       this.setVisible(true);
 
      }
 
      @Override
    public void actionPerformed (ActionEvent e)
    {
        if(e.getSource()==magicButton)
        {
           //JYCardTrick();
         this.setVisible(false);
         //this.setVisible(false);
           //JYCardTrick temp = new JYCardTrick();
          this.dispose();
           JYCardTrick test = JYCardTrick.getInstance();//new JYCardTrick();
        }
		 
		 else if (e.getSource()==vreg)
        {
           //memoryButton();
          this.setVisible(false);
         //this.setVisible(false);
         this.dispose();
           MemoryGame test = MemoryGame.getInstance();
           //MemoryGame test = new MemoryGame();
        }
		 
		 
		 
		 
		 else if (e.getSource()==register)
        {
           //memoryButton();
          //this.setVisible(false);
       
         //this.dispose();
           SimpleJdbc thing = new SimpleJdbc();
          
        }
        else if (e.getSource()==memoryButton)
        {
           //memoryButton();
          this.setVisible(false);
         //this.setVisible(false);
         this.dispose();
           MemoryGame test = MemoryGame.getInstance();
           //MemoryGame test = new MemoryGame();
        }
       else if (e.getSource()==instructButton)
       {
          JFrame Instruct = new JFrame();
          Instruct instructions = new Instruct();
          instructions.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
