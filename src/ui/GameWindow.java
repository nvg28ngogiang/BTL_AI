package ui;

import javax.swing.*;

import players.Player;

import java.awt.*;

public class GameWindow extends JFrame {

    public GameWindow(Player player1, Player player2){
        GamePanel gp = new GamePanel(player1, player2, this);
    	//EndGame gp = new EndGame(player1, player2, "asdasd", this);
        this.add(gp);
        this.setTitle("Reversi v0.1");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        //this.setSize(500,500);
    }

}
