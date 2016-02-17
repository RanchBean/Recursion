package ctec.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JPanel;
import ctec.controller.RecursionController;
import java.awt.Color;


public class RecursionPanel extends JPanel 
{

	private RecursionController baseController;
	private JButton fibonacciButton;
	private JButton factorialButton;
	private JTextField inputField;
	private JTextArea resultsArea;
	private SpringLayout baseLayout;

	public RecursionPanel(RecursionController baseController)
	{
		
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		fibonacciButton = new JButton("Fibonacci");
		factorialButton = new JButton("Factorial");
		inputField = new JTextField("");
		resultsArea = new JTextArea("");
		resultsArea.setLineWrap(true);
		
		
		setupPanel();
		setupLayout();
		setupListeners();
		
	}
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(fibonacciButton);
		this.add(factorialButton);
		this.add(inputField);
		this.add(resultsArea);

	}
	private void setupLayout()
	{
		
		
		
		
		baseLayout.putConstraint(SpringLayout.WEST, resultsArea, 84, SpringLayout.WEST, this);baseLayout.putConstraint(SpringLayout.EAST, resultsArea, -112, SpringLayout.EAST, this);baseLayout.putConstraint(SpringLayout.NORTH, inputField, 10, SpringLayout.NORTH, this);baseLayout.putConstraint(SpringLayout.WEST, factorialButton, 0, SpringLayout.WEST, fibonacciButton);baseLayout.putConstraint(SpringLayout.WEST, inputField, 22, SpringLayout.WEST, this);baseLayout.putConstraint(SpringLayout.NORTH, factorialButton, 6, SpringLayout.SOUTH, fibonacciButton);baseLayout.putConstraint(SpringLayout.NORTH, fibonacciButton, 0, SpringLayout.NORTH, this);baseLayout.putConstraint(SpringLayout.NORTH, resultsArea, 144, SpringLayout.SOUTH, inputField);baseLayout.putConstraint(SpringLayout.EAST, fibonacciButton, 0, SpringLayout.EAST, this);baseLayout.putConstraint(SpringLayout.SOUTH, resultsArea, -31, SpringLayout.SOUTH, this);setBackground(Color.BLUE);baseLayout.putConstraint(SpringLayout.EAST, inputField, 126, SpringLayout.WEST, this);
		
		
	}
	private void setupListeners()
	{
		fibonacciButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String input = inputField.getText();
				if(checkInput(input))
				{
					resultsArea.setText(baseController.doFibonacci(input));
				}
			}
		});
		
		factorialButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String input = inputField.getText();
				if(checkInput(input))
				{
					resultsArea.append(baseController.doFactorial(input));
				}
			}
		});

	}
	
	private boolean checkInput(String input)
	{
		boolean isNumber = false;
		
		try
		{
			Double.parseDouble(input);
			isNumber = true;
		}
		catch(Exception numberException)
		{
			resultsArea.setText("you must type a number");
		}
		return isNumber;
	}
	
}
