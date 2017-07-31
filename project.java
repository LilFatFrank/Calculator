import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
class project extends JFrame
{
	TextField txt=new TextField("",12);
	private boolean number = true;
    private String equal = "=";
    private Result res = new Result();
    private double a=0;
    private int y=0,x=0;
	private final Font FONT=new Font("Times New Roman",Font.PLAIN,20);
	project()
	{
		ActionListener number=new NumberListener();
		String buttonOrder="123456789 "+"0";
		JPanel buttonPanel=new JPanel(new GridLayout(4,4,4,4));
		buttonPanel.setVisible(true);
		for (int i = 0; i < buttonOrder.length(); i++)
		{
            String key = buttonOrder.substring(i, i+1);
            if (key.equals(" "))
			{
                buttonPanel.add(new JLabel(""));
            }
			else
			{
                JButton button = new JButton(key);
                button.addActionListener(number);
                button.setFont(FONT);
                buttonPanel.add(button);
            }
        }
		ActionListener operator=new OperatorListener();
		JPanel panel=new JPanel(new GridLayout(4,4,4,4));
		String[] opOrder={"+","-","*","/","=","sin","cos","tan","log","C","asin","acos","atan","x^2","x^3","1/x","e","+/-","sqrt","."};
		for(int i=0;i<opOrder.length;i++)
		{
			JButton button=new JButton(opOrder[i]);
			button.addActionListener(operator);
			button.setFont(FONT);
			panel.add(button);
		}
		JPanel pan=new JPanel();
		pan.setLayout(new BorderLayout(4,4));
		pan.add(txt, BorderLayout.NORTH);
		pan.add(buttonPanel, BorderLayout.CENTER);
		pan.add(panel, BorderLayout.WEST);
		this.setContentPane(pan);
		this.pack();
		this.setTitle("Calculator");
		this.setResizable(false);
	}
	public void action()
	{
		number=true;
		txt.setText("");
		equal="=";
		res.setTotal("");
	}
	class OperatorListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{		
			String displaytext=txt.getText();
			if(e.getActionCommand().equals("sin"))
			{	
				float txt_rad = (float) Math.toRadians(Float.parseFloat(displaytext));
				double text=Math.sin(Double.valueOf(txt_rad).doubleValue());
				double value=Math.round(text*100.0)/100.0;
				txt.setText("" +value);
			}
			else if(e.getActionCommand().equals("cos"))
			{
				float txt_rad = (float) Math.toRadians(Float.parseFloat(displaytext));
				double text=Math.cos(Double.valueOf(txt_rad).doubleValue());
				double value=Math.round(text*100.0)/100.0;
				txt.setText("" +value);
			}
			else if(e.getActionCommand().equals("tan"))
			{
				float txt_rad = (float) Math.toRadians(Float.parseFloat(displaytext));
				double text=Math.tan(Double.valueOf(txt_rad).doubleValue());
				double value=Math.round(text*100.0)/100.0;
				txt.setText("" +value);
			}
			else if(e.getActionCommand().equals("log"))
			{
				txt.setText("" +Math.log(Double.valueOf(displaytext).doubleValue()));
			}
			else if(e.getActionCommand().equals("C"))
			{
				txt.setText("");
			}
			else if(e.getActionCommand().equals("asin"))
			{
				float txt_rad = (float) Math.toRadians(Float.parseFloat(displaytext));
				double text=Math.asin(Double.valueOf(txt_rad).doubleValue());
				double value=Math.round(text*100.0)/100.0;
				txt.setText("" +value);
			}
			else if(e.getActionCommand().equals("acos"))
			{
				float txt_rad = (float) Math.toRadians(Float.parseFloat(displaytext));
				double text=Math.acos(Double.valueOf(txt_rad).doubleValue());
				double value=Math.round(text*100.0)/100.0;
				txt.setText("" +value);
			}
			else if(e.getActionCommand().equals("atan"))
			{
				float txt_rad = (float) Math.toRadians(Float.parseFloat(displaytext));
				double text=Math.atan(Double.valueOf(txt_rad).doubleValue());
				double value=Math.round(text*100.0)/100.0;
				txt.setText("" +value);
			}
			else if(e.getActionCommand().equals("x^2"))
			{
				if(txt.getText().equals(""))
				{
					txt.setText("");
				}
				else
				{
					a=Math.pow(Double.parseDouble(txt.getText()),2);
					txt.setText("");
					txt.setText(txt.getText()+a);
				}
			}
			else if(e.getActionCommand().equals("x^3"))
			{
				if(txt.getText().equals(""))
				{
					txt.setText("");
				}
				else
				{
					a=Math.pow(Double.parseDouble(txt.getText()),3);
					txt.setText("");
					txt.setText(txt.getText()+a);
				}
			}
			else if(e.getActionCommand().equals("1/x"))
			{
				if(txt.getText().equals(""))
				{
					txt.setText("");
				}
				else
				{
					a=1/Double.parseDouble(txt.getText());
					txt.setText("");
					txt.setText(txt.getText()+a);
				}
			}
			else if(e.getActionCommand().equals("e"))
			{
				if(txt.getText().equals(""))
				{
					txt.setText("");
				}
				else
				{
					a=Math.exp(Double.parseDouble(txt.getText()));
					txt.setText("");
					txt.setText(txt.getText()+a);
				}
			}
			else if(e.getActionCommand().equals("+/-"))
			{
				if(x==0)
				{
					txt.setText("-" +txt.getText());
					x=1;
				}
				else
				{
					txt.setText(txt.getText());
				}
			}
			else if(e.getActionCommand().equals("sqrt"))
			{
				if(txt.getText().equals(""))
				{
					txt.setText("");
				}
				else
				{
					a=Math.sqrt(Double.parseDouble(txt.getText()));
					txt.setText("");
					txt.setText(txt.getText()+a);
				}
			}
			else if(e.getActionCommand().equals("."))
			{
				if(y==0)
				{
					txt.setText(txt.getText()+".");
				}
				else
				{
					txt.setText(txt.getText());
				}
			}
			else
            {
                if (number)
                {
                    
                    action();
                    txt.setText("");
                    
                }
                else
                {
                    number = true;
                    if (equal.equals("="))
                    {
                        res.setTotal(displaytext);
                    }else
                    if (equal.equals("+"))
                    {
                        res.add(displaytext);
                    }
                    else if (equal.equals("-"))
                    {
                        res.subtract(displaytext);
                    }
                    else if (equal.equals("*"))
                    {
                        res.multiply(displaytext);
                    }
                    else if (equal.equals("/"))
                    {
                        res.divide(displaytext);
                    }
                    
                    txt.setText("" + res.getTotal());
                    equal = e.getActionCommand();
                }
            }
		}
	}
	class NumberListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String digit=e.getActionCommand();
			if(number)
			{	
				txt.setText(digit);
				number=false;
			}
			else
			{
				txt.setText(txt.getText()+digit);
			}
		}
	}
	class Result
	{
		private double total;
		public Result()
		{
			total=0;
		}
		public String getTotal()
		{
			return ""+total;
		}
		public void setTotal(String n)
		{
			total=convertToNumber(n);
		}
		public void add(String n)
		{
			total+=convertToNumber(n);
		}
		public void subtract(String n)
		{
			total-=convertToNumber(n);
		}
		public void multiply(String n)
		{
			total*=convertToNumber(n);
		}
		public void divide(String n)
		{
			total/=convertToNumber(n);
		}
		private double convertToNumber(String n)
		{
			return Double.parseDouble(n);
		}
	}
}
class Calculator
{
	public static void main(String args[])
	{
		JFrame frame=new project();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
