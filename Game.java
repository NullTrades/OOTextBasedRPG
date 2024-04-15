/*

    Title: Game Class - Text Based RPG
    Authors: Osy Okocha, Simon Huang, Hassan Darky
    
*/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {

    ActionPerformed actionPerformed = new ActionPerformed();

    private Player player;
    private boolean gameRunning;
    static Gui gui = new Gui();

    public static void main(String[] args) {
        new Game();
    }

    public Game() {
        Gui.gameScreen(new ActionPerformed());
    }

    public void titleScreen() {
        gui.titlePanel.setVisible(true);
        gui.startPanel.setVisible(true);

        gui.gamePanel.setVisible(false);
        gui.infoPanel.setVisible(false);
        gui.buttonPanel.setVisible(false);

    }

    public static void toGameScreen() {
        gui.titlePanel.setVisible(false);
        gui.startPanel.setVisible(false);

        gui.gamePanel.setVisible(true);
        gui.infoPanel.setVisible(true);
        gui.buttonPanel.setVisible(true);

    }

    public static class ActionPerformed implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String click = event.getActionCommand();
            switch (click) {
                case "start":
                    toGameScreen();
                    break;
                case "choiceOne":

                    break;
                case "choiceTwo":

                    break;
                case "choiceThree":

                    break;
                case "choiceFour":

                    break;
                default:
                    break;
            }
        }

    }

}