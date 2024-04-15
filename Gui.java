import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.File;

public class Gui implements ActionListener {
    static JFrame frame;
    static Container container;
    static JPanel titlePanel, startPanel, gamePanel, buttonPanel, infoPanel;
    static JLabel titleLabel, hpLabel, hpVauleLabel, weaponNamLabel, weaponLabel, locationNamLabel, locationLabel;
    static JButton startButton, buttonOne, buttonTwo, buttonThree, buttonFour;
    static JTextArea textArea;
    // Set custom color
    static Color purpleColor = new Color(60, 9, 108);

    static Font customFont = loadFont("BreatheFireIii-PKLOB.ttf");
    static Font biggerTitleFont = customFont.deriveFont(Font.BOLD, 200);
    static Font standardFont = customFont.deriveFont(Font.BOLD, 40);
    static Font standardFontTwo = customFont.deriveFont(Font.BOLD, 25);
    static Font standardFontThree = customFont.deriveFont(Font.BOLD, 37);
    static Font standardFontFour = customFont.deriveFont(Font.ITALIC, 25);
    static int playerHp;
    static String weaponName;
    static String locationName;

    public static void gameScreen(Game.ActionPerformed actionPerformed) {

        // Creating new Frame
        frame = new JFrame();
        frame.setSize(1000, 800);
        frame.getContentPane().setBackground(Color.black);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container = frame.getContentPane();

        // Creating new Title panel
        titlePanel = new JPanel();
        titlePanel.setBounds(200, 100, 600, 210);
        titlePanel.setBackground(Color.black);
        container.add(titlePanel);

        // Creating new Title Lable
        titleLabel = new JLabel("Title");
        titleLabel.setForeground(purpleColor);
        titleLabel.setFont(biggerTitleFont);
        titlePanel.add(titleLabel);

        // Creating new Start button and panel
        startPanel = new JPanel();
        startPanel.setBounds(375, 550, 250, 70);
        startPanel.setBackground(Color.black);
        container.add(startPanel);

        startButton = new JButton("Start");
        startButton.setBackground(Color.black);
        startButton.setForeground(purpleColor);
        startButton.setFont(standardFont);
        startButton.addActionListener(new Gui());
        startButton.setFocusPainted(false);
        startButton.addActionListener(actionPerformed);
        startButton.setActionCommand("start");
        startPanel.add(startButton);

        // Sets visability to show
        frame.setVisible(true);

        // Sets title screen option to not show
        titlePanel.setVisible(false);
        startPanel.setVisible(false);

        // Creating new game panel
        gamePanel = new JPanel();
        gamePanel.setBounds(180, 150, 620, 250);
        gamePanel.setBackground(Color.black);
        container.add(gamePanel);

        // Creating a text window and addding to game panel
        textArea = new JTextArea(
                "Lorem ipsum dolar...");
        textArea.setBounds(180, 150, 620, 250);
        textArea.setBackground(Color.black);
        textArea.setForeground(purpleColor);
        textArea.setFont(standardFontTwo);
        textArea.setLineWrap(true);
        gamePanel.add(textArea);

        // Creating a buttone panel for the four buttons
        buttonPanel = new JPanel();
        buttonPanel.setBounds(150, 550, 700, 125);
        buttonPanel.setBackground(Color.black);
        buttonPanel.setLayout(new GridLayout(1, 4));
        container.add(buttonPanel);

        // Creating the four buttons and adding to the button panel
        buttonOne = new JButton("Option 1");
        buttonOne.setBackground(Color.black);
        buttonOne.setForeground(purpleColor);
        buttonOne.setFont(standardFontThree);
        buttonOne.addActionListener(actionPerformed);
        buttonOne.setActionCommand("choiceOne");
        buttonOne.setFocusPainted(false);

        buttonTwo = new JButton("Option 2");
        buttonTwo.setBackground(Color.black);
        buttonTwo.setForeground(purpleColor);
        buttonTwo.setFont(standardFontThree);
        buttonTwo.addActionListener(actionPerformed);
        buttonTwo.setActionCommand("choiceTwo");
        buttonTwo.setFocusPainted(false);

        buttonThree = new JButton("Option 3");
        buttonThree.setBackground(Color.black);
        buttonThree.setForeground(purpleColor);
        buttonThree.setFont(standardFontThree);
        buttonThree.addActionListener(actionPerformed);
        buttonThree.setActionCommand("choiceThree");
        buttonThree.setFocusPainted(false);

        buttonFour = new JButton("Option 4");
        buttonFour.setBackground(Color.black);
        buttonFour.setForeground(purpleColor);
        buttonFour.setFont(standardFontThree);
        buttonFour.addActionListener(actionPerformed);
        buttonFour.setActionCommand("choiceFour");
        buttonFour.setFocusPainted(false);

        buttonPanel.add(buttonOne);
        buttonPanel.add(buttonTwo);
        buttonPanel.add(buttonThree);
        buttonPanel.add(buttonFour);

        // Creating an info panel
        infoPanel = new JPanel();
        infoPanel.setBackground(Color.black);
        infoPanel.setBounds(50, 25, 900, 50);
        infoPanel.setLayout(new GridLayout(1, 6));
        container.add(infoPanel);

        // Creating values for the info panel and adding them
        hpLabel = new JLabel("HP: ");
        hpVauleLabel = new JLabel();
        weaponLabel = new JLabel("WEAPON: ");
        weaponNamLabel = new JLabel();
        locationLabel = new JLabel("LOCATION: ");
        locationNamLabel = new JLabel();

        hpLabel.setForeground(purpleColor);
        hpVauleLabel.setForeground(Color.WHITE);
        weaponLabel.setForeground(purpleColor);
        weaponNamLabel.setForeground(Color.WHITE);
        locationLabel.setForeground(purpleColor);
        locationNamLabel.setForeground(Color.WHITE);

        hpLabel.setFont(standardFontTwo);
        hpVauleLabel.setFont(standardFontFour);
        weaponLabel.setFont(standardFontTwo);
        weaponNamLabel.setFont(standardFontFour);
        locationLabel.setFont(standardFontTwo);
        locationNamLabel.setFont(standardFontFour);

        infoPanel.add(hpLabel);
        infoPanel.add(hpVauleLabel);
        infoPanel.add(locationLabel);
        infoPanel.add(locationNamLabel);
        infoPanel.add(weaponLabel);
        infoPanel.add(weaponNamLabel);
        // Calls setup method
        setup();

    }

    public static void setup() {
        playerHp = 25;
        hpVauleLabel.setText("" + playerHp);
        weaponName = " ";
        weaponNamLabel.setText(weaponName);
        locationName = "Start";
        locationNamLabel.setText(locationName);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}