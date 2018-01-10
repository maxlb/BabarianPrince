import javax.swing.JFrame;

public class Fenetre extends JFrame {
    public Fenetre(){
        this.setTitle("Prince des Barbares");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(new Panneau());

        this.setVisible(true);
    }
}
