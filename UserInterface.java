import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.SystemColor;
import java.awt.Font;

public class UserInterface {
	private static JFrame userInputFrame;
    public static void userInput(){
		userInputFrame = new JFrame("Solution");
		userInputFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("images/calculate_FILL0_wght400_GRAD0_opsz48.png"));
		userInputFrame.setTitle("Golden Search");
		userInputFrame.getContentPane().setBackground(new Color(255, 255, 255));
		userInputFrame.setSize(539,359);
		userInputFrame.setLocationRelativeTo(null);
		userInputFrame.getContentPane().setLayout(null);
        userInputFrame.setDefaultCloseOperation(userInputFrame.HIDE_ON_CLOSE);
		
		JLabel uiMainTextLogo = new JLabel("Golden-Section Search");
		uiMainTextLogo.setForeground(SystemColor.controlDkShadow);
		uiMainTextLogo.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		uiMainTextLogo.setBounds(138, 7, 258, 56);
		userInputFrame.getContentPane().add(uiMainTextLogo);
				
				JLabel lblSolveFor = new JLabel("Solve for: ");
				lblSolveFor.setForeground(SystemColor.controlDkShadow);
				lblSolveFor.setFont(new Font("Segoe UI", Font.PLAIN, 15));
				lblSolveFor.setBounds(663, 10, 258, 56);
				userInputFrame.getContentPane().add(lblSolveFor);
				
				JTextField functionValue = new JTextField();
				functionValue.setBounds(62, 87, 380, 28);
				userInputFrame.getContentPane().add(functionValue);
				functionValue.setColumns(10);
				
				JTextField initialLower = new JTextField();
				initialLower.setColumns(10);
				initialLower.setBounds(62, 152, 185, 28);
				userInputFrame.getContentPane().add(initialLower);
				
				JTextField initialUpper = new JTextField();
				initialUpper.setColumns(10);
				initialUpper.setBounds(257, 152, 185, 28);
				userInputFrame.getContentPane().add(initialUpper);

				JTextField iterationsTextField = new JTextField();
				iterationsTextField.setColumns(10);
				iterationsTextField.setBounds(211, 201, 231, 28);
				userInputFrame.getContentPane().add(iterationsTextField);
				
				JButton calculateBTN = new JButton("Calculate");
                calculateBTN.setForeground(new Color(255, 255, 255));
				calculateBTN.setBackground(new Color(46, 139, 87));
				calculateBTN.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
				calculateBTN.setBounds(211, 257, 231, 34);
				calculateBTN.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							String fValue = functionValue.getText();
							int lowerBound = Integer.parseInt(initialLower.getText());
							int upperBound = Integer.parseInt(initialUpper.getText());
							int iterations = Integer.parseInt(iterationsTextField.getText());
							GoldenSection.start(fValue, lowerBound, upperBound, iterations);
							userInputFrame.setVisible(false);
							showOutput();
						} catch (Exception a) {
							showError();
						}
	
					}
				});
				userInputFrame.getContentPane().add(calculateBTN);
				
				JLabel initialLowerLabel = new JLabel("xl");
				initialLowerLabel.setForeground(SystemColor.controlDkShadow);
				initialLowerLabel.setFont(new Font("Segoe UI", Font.PLAIN, 17));
				initialLowerLabel.setBounds(62, 120, 31, 43);
				userInputFrame.getContentPane().add(initialLowerLabel);
				
				JLabel fLabel = new JLabel("F(x)");
				fLabel.setForeground(SystemColor.controlDkShadow);
				fLabel.setFont(new Font("Segoe UI", Font.PLAIN, 17));
				fLabel.setBounds(62, 49, 31, 43);
				userInputFrame.getContentPane().add(fLabel);
				
				JLabel initialUpperLabel = new JLabel("xu");
				initialUpperLabel.setForeground(SystemColor.controlDkShadow);
				initialUpperLabel.setFont(new Font("Segoe UI", Font.PLAIN, 17));
				initialUpperLabel.setBounds(256, 120, 31, 43);
				userInputFrame.getContentPane().add(initialUpperLabel);
				
				JLabel iterationsLabel = new JLabel("No. of Iterations:");
				iterationsLabel.setForeground(SystemColor.controlDkShadow);
				iterationsLabel.setFont(new Font("Segoe UI", Font.PLAIN, 17));
				iterationsLabel.setBounds(65, 190, 138, 43);
				userInputFrame.getContentPane().add(iterationsLabel);
				userInputFrame.setVisible(true);
				userInputFrame.setResizable(false);

				JButton btnInstructions = new JButton("Instructions");
				btnInstructions.setForeground(Color.WHITE);
				btnInstructions.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
				btnInstructions.setBackground(new Color(46, 139, 87));
				btnInstructions.setBounds(63, 257, 138, 34);
				btnInstructions.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						instruct();
					}
				});
				userInputFrame.getContentPane().add(btnInstructions);
				userInputFrame.setVisible(true);
				userInputFrame.setResizable(false);
    }
   
    private static void showOutput() {
        JFrame mainPanel = new JFrame("Solution");
		mainPanel.setIconImage(Toolkit.getDefaultToolkit().getImage("images/calculate_FILL0_wght400_GRAD0_opsz48.png"));
		mainPanel.setTitle("View Solution");
		mainPanel.getContentPane().setBackground(new Color(255, 255, 255));
		mainPanel.setSize(954,635);
		mainPanel.setLocationRelativeTo(null);
		mainPanel.getContentPane().setLayout(null);
        mainPanel.setDefaultCloseOperation(mainPanel.HIDE_ON_CLOSE);
		
		JLabel uiMainTextLogo = new JLabel("Golden-Section Search");
		uiMainTextLogo.setForeground(SystemColor.controlDkShadow);
		uiMainTextLogo.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		uiMainTextLogo.setBounds(325, 12, 258, 56);
		mainPanel.getContentPane().add(uiMainTextLogo);
		
		JPanel contentPanel = new JPanel();
		contentPanel.setBounds(30, 76, 891, 501);
		mainPanel.getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
				JTextPane txtpnTest = new JTextPane();
				txtpnTest.setFont(new Font("Tahoma", Font.PLAIN, 13));
				txtpnTest.setBounds(10, 10, 871, 481);
				contentPanel.add(txtpnTest);
                txtpnTest.setText(GoldenSection.finalValue);
				txtpnTest.setEditable(false);
				
				JLabel lblSolveFor = new JLabel("Solve for: " + GoldenSection.equation);
				lblSolveFor.setForeground(SystemColor.controlDkShadow);
				lblSolveFor.setFont(new Font("Segoe UI", Font.PLAIN, 15));
				lblSolveFor.setBounds(30, 15, 258, 56);
				mainPanel.getContentPane().add(lblSolveFor);

				JButton backBtn = new JButton("Back");
					backBtn.setBackground(new Color(0, 128, 0));
					backBtn.setForeground(SystemColor.text);
					backBtn.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 17));
					backBtn.setBounds(731, 26, 178, 40);
					backBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							mainPanel.setVisible(false);
							userInput();
						}
					});
					mainPanel.getContentPane().add(backBtn);

		mainPanel.setVisible(true);
		mainPanel.setResizable(false);
    }

    private static void showError(){
        JFrame mainPanel = new JFrame("Solution");
		mainPanel.setIconImage(Toolkit.getDefaultToolkit().getImage("images/calculate_FILL0_wght400_GRAD0_opsz48.png"));
		mainPanel.setTitle("Error! Please check your inputs.");
		mainPanel.getContentPane().setBackground(new Color(255, 255, 255));
		mainPanel.setSize(518,212);
		mainPanel.setLocationRelativeTo(null);
		mainPanel.getContentPane().setLayout(null);
        mainPanel.setDefaultCloseOperation(mainPanel.HIDE_ON_CLOSE);
		
		JLabel uiMainTextLogo = new JLabel("ERROR!");
		uiMainTextLogo.setForeground(SystemColor.controlDkShadow);
		uiMainTextLogo.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		uiMainTextLogo.setBounds(138, 7, 258, 56);
		mainPanel.getContentPane().add(uiMainTextLogo);
				
				JLabel lblSolveFor = new JLabel("Solve for: ");
				lblSolveFor.setForeground(SystemColor.controlDkShadow);
				lblSolveFor.setFont(new Font("Segoe UI", Font.PLAIN, 15));
				lblSolveFor.setBounds(663, 10, 258, 56);
				mainPanel.getContentPane().add(lblSolveFor);
				
				JTextPane txtpnSomethingWentWrong = new JTextPane();
				txtpnSomethingWentWrong.setEditable(false);
				txtpnSomethingWentWrong.setForeground(SystemColor.controlDkShadow);
				txtpnSomethingWentWrong.setFont(new Font("Segoe UI", Font.PLAIN, 17));
				txtpnSomethingWentWrong.setText("Something went wrong. Either an invalid value was placed or something was blank. Please recheck all values.\r\n");
				txtpnSomethingWentWrong.setBounds(45, 73, 438, 126);
				mainPanel.getContentPane().add(txtpnSomethingWentWrong);
		mainPanel.setVisible(true);
		mainPanel.setResizable(false);
    }

	public static void instruct(){
		JFrame mainPanel = new JFrame("Solution");
		mainPanel.setIconImage(Toolkit.getDefaultToolkit().getImage("images/calculate_FILL0_wght400_GRAD0_opsz48.png"));
		mainPanel.setTitle("Instructions");
		mainPanel.getContentPane().setBackground(new Color(255, 255, 255));
		mainPanel.setSize(539,359);
		mainPanel.setLocationRelativeTo(userInputFrame);
		mainPanel.getContentPane().setLayout(null);
        mainPanel.setDefaultCloseOperation(mainPanel.HIDE_ON_CLOSE);
		
		JLabel uiMainTextLogo = new JLabel("Golden-Section Search");
		uiMainTextLogo.setForeground(SystemColor.controlDkShadow);
		uiMainTextLogo.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		uiMainTextLogo.setBounds(138, 7, 258, 56);
		mainPanel.getContentPane().add(uiMainTextLogo);
				
				JLabel lblSolveFor = new JLabel("Solve for: ");
				lblSolveFor.setForeground(SystemColor.controlDkShadow);
				lblSolveFor.setFont(new Font("Segoe UI", Font.PLAIN, 15));
				lblSolveFor.setBounds(663, 10, 258, 56);
				mainPanel.getContentPane().add(lblSolveFor);
				
				JLabel iterationsLabel = new JLabel("Instructions:");
				iterationsLabel.setForeground(SystemColor.controlDkShadow);
				iterationsLabel.setFont(new Font("Segoe UI", Font.PLAIN, 17));
				iterationsLabel.setBounds(35, 52, 237, 65);
				mainPanel.getContentPane().add(iterationsLabel);
				
				JPanel panel = new JPanel();
				panel.setBounds(57, 103, 398, 155);
				mainPanel.getContentPane().add(panel);
				panel.setLayout(null);
				
				JTextPane txtpnThisProgramAccepts = new JTextPane();
				txtpnThisProgramAccepts.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
				txtpnThisProgramAccepts.setText("This program accepts positive and negative values. \r\nFor function values please follow this format:\r\n\t3x^2+5x-7 -> 3x^2/5x/-7\r\n\r\nFor it to work as intended!");
				txtpnThisProgramAccepts.setBounds(10, 10, 378, 135);
				panel.add(txtpnThisProgramAccepts);
		mainPanel.setVisible(true);
		mainPanel.setResizable(false);
	}
}
