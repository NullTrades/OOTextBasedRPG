import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.File;

public class Gui implements ActionListener {
    static JFrame frame;
    static Container container;
    static JPanel titlePanel, startPanel, gamePanel, buttonPanel, hpPanel, weaponPanel, levelPanel;
    static JLabel titleLabel, hpLabel, weaponLabel, levelLabel;
    static JButton startButton, buttonOne, buttonTwo, buttonThree, buttonFour;
    static JTextArea textArea;
    // Set custom color
    static Color customColor = new Color(60, 9, 108);
    static Font customFont = loadFont("BreatheFireIii-PKLOB.ttf");
    static Font biggerTitleFont = customFont.deriveFont(Font.BOLD, 200);
    static Font standardFont = customFont.deriveFont(Font.BOLD, 40);
    static Font standardFontTwo = customFont.deriveFont(Font.BOLD, 25);
    static Font standardFontThree = customFont.deriveFont(Font.BOLD, 37);

    public static void main(String[] args) {
        titleScreen();
    }

    public static void titleScreen() {

        frame = new JFrame();
        frame.setSize(1000, 800);
        frame.getContentPane().setBackground(Color.black);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        container = frame.getContentPane();

        titlePanel = new JPanel();
        titlePanel.setBounds(200, 100, 600, 210);
        titlePanel.setBackground(Color.black);
        container.add(titlePanel);
        titleLabel = new JLabel("Title");

        titleLabel.setForeground(customColor);
        titleLabel.setFont(biggerTitleFont);
        titlePanel.add(titleLabel);

        startPanel = new JPanel();
        startPanel.setBounds(375, 550, 250, 70);
        startPanel.setBackground(Color.black);
        container.add(startPanel);

        startButton = new JButton("Start");
        startButton.setBackground(Color.black);
        startButton.setForeground(customColor);
        startButton.setFont(standardFont);
        startButton.addActionListener(new Gui());
        startPanel.add(startButton);
    }

    public static void gameScreen() {
        titlePanel.setVisible(false);
        startPanel.setVisible(false);
        gamePanel = new JPanel();
        gamePanel.setBounds(180, 150, 620, 250);
        gamePanel.setBackground(Color.black);
        container.add(gamePanel);

        textArea = new JTextArea(
                "Lorem ipsum dolar...");
        textArea.setBounds(180, 150, 620, 250);
        textArea.setBackground(Color.black);
        textArea.setForeground(customColor);
        textArea.setFont(standardFontTwo);
        textArea.setLineWrap(true);
        gamePanel.add(textArea);

        buttonPanel = new JPanel();
        buttonPanel.setBounds(150, 550, 700, 125);
        buttonPanel.setBackground(Color.black);
        container.add(buttonPanel);

        buttonOne = new JButton("Option 1");
        buttonOne.setBackground(Color.black);
        buttonOne.setForeground(customColor);
        buttonOne.setFont(standardFontThree);
        buttonTwo = new JButton("Option 2");
        buttonTwo.setBackground(Color.black);
        buttonTwo.setForeground(customColor);
        buttonTwo.setFont(standardFontThree);
        buttonThree = new JButton("Option 3");
        buttonThree.setBackground(Color.black);
        buttonThree.setForeground(customColor);
        buttonThree.setFont(standardFontThree);
        buttonFour = new JButton("Option 4");
        buttonFour.setBackground(Color.black);
        buttonFour.setForeground(customColor);
        buttonFour.setFont(standardFontThree);

        buttonPanel.add(buttonOne);
        buttonPanel.add(buttonTwo);
        buttonPanel.add(buttonThree);
        buttonPanel.add(buttonFour);

        hpPanel = new JPanel();
        weaponPanel = new JPanel();
        levelPanel = new JPanel();
        hpPanel.setBackground(Color.BLACK);
        weaponPanel.setBackground(Color.BLACK);
        levelPanel.setBackground(Color.BLACK);
        hpPanel.setBounds(20, 0, 100, 50);
        weaponPanel.setBounds(760, 0, 120, 50);
        levelPanel.setBounds(330, 0, 200, 50);

        container.add(hpPanel);
        container.add(weaponPanel);
        container.add(levelPanel);

        hpLabel = new JLabel("HP: ");
        weaponLabel = new JLabel("WEAPON: ");
        levelLabel = new JLabel("LEVEL: ");
        hpLabel.setForeground(customColor);
        weaponLabel.setForeground(customColor);
        levelLabel.setForeground(customColor);
        hpLabel.setFont(standardFontTwo);
        weaponLabel.setFont(standardFontTwo);
        levelLabel.setFont(standardFontTwo);
        hpPanel.add(hpLabel);
        weaponPanel.add(weaponLabel);
        levelPanel.add(levelLabel);

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == startButton) {
            gameScreen();
        }
    }

    private static Font loadFont(String filename) {
        Font font = null;
        try {
            // Load the font file
            File file = new File(filename);
            font = Font.createFont(Font.TRUETYPE_FONT, file);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            // Handle the exception (e.g., display an error message)
        }
        return font;
    }

}