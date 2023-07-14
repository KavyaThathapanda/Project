import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

	//Declaring the Variables
	JFrame frame;
	JTextField textFeild;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[8];
	JButton addButton,subButton,mulButton,divButton;
	JButton decButton,equalButton,clrButton,delButton;
	JPanel panel;
	char operator;

	Font myFont = new Font("Times New Roman" ,Font.BOLD,25 );

	double num1=0 , num2=0 , result=0;

	Calculator(){
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 500);
		frame.setLayout(null);
		textFeild = new JTextField();
		textFeild.setBounds(40, 30, 300, 40);
		textFeild.setFont(myFont);
		textFeild.setEditable(false);

		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("X");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equalButton = new JButton("=");
		clrButton = new JButton("Clr");
		delButton = new JButton("Del");

		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equalButton;
		functionButtons[6] = clrButton;
		functionButtons[7] = delButton;

		for(int i =0; i<8 ; i++) {

			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
		}

		for(int i = 0; i<10; i++) {

			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
		}

		delButton.setBounds(30,420,125,30);
		clrButton.setBounds(205,420,125,30);
		
		//set the bounds and layout of the panel
		panel = new JPanel();
		panel.setBounds(35, 95, 300, 300);
		panel.setLayout(new GridLayout(4,4,10,10));

		//add all the buttons to the panel
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equalButton);
		panel.add(divButton);

		//add remaining buttons , panel and text field which displays to frame
		frame.add(panel);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(textFeild);
		frame.setVisible(true);
		
	}//calculator constructor

	public static void main(String[] args) {
		Calculator calc = new Calculator();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		for(int i = 0; i<10 ; i++) {			
			if(e.getSource() == numberButtons[i]) 			
				textFeild.setText(textFeild.getText().concat(String.valueOf(i)));						
		}
		
		if(e.getSource() == decButton) 			
			textFeild.setText(textFeild.getText().concat("."));
					
		if(e.getSource() == addButton) {			
			num1 = Double.parseDouble(textFeild.getText());
			operator = '+';
			textFeild.setText("");
		}
		
		if(e.getSource() == subButton) {			
			num1 = Double.parseDouble(textFeild.getText());
			operator = '-';
			textFeild.setText("");
		}
		
		if(e.getSource() == mulButton) {			
			num1 = Double.parseDouble(textFeild.getText());
			operator = '*';
			textFeild.setText("");
		}
		
		if(e.getSource() == divButton) {			
			num1 = Double.parseDouble(textFeild.getText());
			operator = '/';
			textFeild.setText("");
		}
		
		if(e.getSource() == equalButton) {			
			num2 = Double.parseDouble(textFeild.getText());
			
			switch(operator) {
			case '+':
				result = num1+num2;
				break;
			case '-':
				result = num1-num2;
				break;	
			case '*':
				result = num1*num2;
				break;	
			case '/':
				result = num1/num2;
				break;	
			}
			
			textFeild.setText(String.valueOf(result));
			num1 = result;
			
		}
		
		if(e.getSource() == clrButton) 			
			textFeild.setText("");

		if(e.getSource() == delButton) {			
			String str = textFeild.getText();
			textFeild.setText("");
			
			for(int i =0 ; i< str.length() -1 ; i++) {				
				textFeild.setText(textFeild.getText() + str.charAt(i));
			}
		}				

	}
}
