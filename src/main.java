import javax.swing.*;
import java.awt.*;

public class main {
    public static void main(String[] args) {
        Fenetre fen = new Fenetre();
        fen.getContentPane().add(new Panneau(9,12));
        imagePanel panel = new imagePanel("map.jpg");
        fen.getContentPane().add(panel);
        fen.pack();
        fen.setVisible(true);
    }
}

