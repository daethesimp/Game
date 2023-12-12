import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class GUI extends JFrame implements KeyListener {
	
	public GUI() {
		setTitle("Adventure");
		setSize(500, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		
		Font pixelFont = new Font("PixelFont", Font.PLAIN, 14);
		
		setBackground(Color.BLACK);
		setOpacity(1);

		
		
		textField = new JTextField();
		textField.setColumns(25);
		textField.setFont(pixelFont);
		textField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		textField.setBackground(Color.WHITE);
		//textField.setBackground(Color.DARK_GRAY);
		textField.setForeground(Color.RED);
		textField.addKeyListener(this);
		
		
		textArea = new JTextArea();
		textArea.setColumns(25);
		textArea.setFont(pixelFont);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		textArea.setBackground(Color.BLACK);
		textArea.setBackground(Color.BLACK);
		textArea.setForeground(Color.RED);
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBorder(BorderFactory.createLineBorder(Color.RED));
		scroll.getViewport().setBackground(Color.BLACK);
		add(scroll, BorderLayout.CENTER);
		
		bottomLabel = new JLabel("What do you want to do?");
		JPanel panel = new JPanel(new GridLayout(2, 1));
		panel.add(bottomLabel);
		panel.add(textField);
		add(panel, BorderLayout.SOUTH);
		//panel.setOpaque(true);
		//panel.setBackground(Color.BLACK);
		//panel.setForeground(Color.RED);
		
		promptLabel = new JLabel("Text Adventure");
        promptLabel.setHorizontalAlignment(JLabel.CENTER);
        promptLabel.setFont(pixelFont);
        promptLabel.setOpaque(true);
        promptLabel.setForeground(Color.RED);
        promptLabel.setBackground(Color.BLACK);
        add(promptLabel, BorderLayout.NORTH);
		
		setVisible(true);
	}
	
	private JTextArea textArea;;
	private JTextField textField;
	private JLabel promptLabel;
	private JLabel bottomLabel;
	
	public void print(Object x) {
		textArea.append(x.toString());
	}
	
	public void actionPerformed(ActionEvent e) {
		JTextArea text = (JTextArea) e.getSource();
		
	}
	
	public void print(String s) {
		textArea.append(s+"\n\n");
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		
		if(e.getKeyChar() == '\n') {
			if(Character.isDigit(textField.getText().charAt(0))) {
				NPC character = Game.getCurrentRoom().getNPC(Game.NPCname);
				character.response(Integer.parseInt(textField.getText()));
			} else {
			Game.proccessCommand(textField.getText());
			}
			textField.setText("");
		}
		//Game.proccessCommand(e);
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void endGame() {
		textField.setEnabled(false);
	}
	
	
	
	

}
