package MainDatabase;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class LoginGUI extends JFrame
{
	
	private JButton login;
	private JTextField idBox;
	private JLabel headerLabel;
	
	//This opens a window to allow an employee to login into the system if they have a valid employee ID
	public LoginGUI()
	{
		super("Login Page");
		setLayout(new FlowLayout());
		setResizable(false);
		
		headerLabel = new JLabel("", JLabel.CENTER);
		headerLabel.setText("Enter you Employee ID");
		add(headerLabel);
		idBox = new JTextField(20);
		add(idBox);
		login = new JButton("Login");
		add(login);
		
		HandlerClass handler = new HandlerClass();
		login.addActionListener(handler);
		
	}
	
	
	//inner class that handles the reading of text in the text box
	//also handles the event when the login button is clicked
	private class HandlerClass implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			String command = event.getActionCommand();
			switch(command)
			{
			case "Login":
				String EmployeeId = idBox.getText();
				int idNumber = 0;
				try{
				idNumber = Integer.parseInt(EmployeeId);
				}
				catch (NumberFormatException e)
				{
					JOptionPane.showMessageDialog(getContentPane(), "Enter a number");
					return;
				}
				ReadEntries reader = new ReadEntries();
				boolean isAllowed = reader.ReadEmployeeId(idNumber);
				if(isAllowed)
				{
					OrderListsGUI frame = new OrderListsGUI();
					frame.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(getContentPane(), "Enter a valid ID");
					return;
				}
			}
			
		}
	}
	
	
}
