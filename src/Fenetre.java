import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenetre extends JFrame implements ActionListener {
    private JPanel container = new JPanel();

    private JPanel boutons = new JPanel();
    private JPanel boutonsN = new JPanel();
    private JPanel boutonsS = new JPanel();
    private JPanel Posi = new JPanel();


    private JButton N = new JButton("N");
    private JButton S = new JButton("S");
    private JButton NE = new JButton("NE");
    private JButton SE = new JButton("SE");
    private JButton SW = new JButton("SW");
    private JButton NW = new JButton("NW");


    Integer x= 5;
    Integer y= 5;
    private Panneau monPanneau = new Panneau(x,y);

    JLabel posX = new JLabel(String.valueOf(monPanneau.x));
    JLabel posY = new JLabel(String.valueOf(monPanneau.y));


    public Fenetre(){
        this.setTitle("Prince des Barbares");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        boutons.setLayout(new BorderLayout());

        N.addActionListener(this);
        S.addActionListener(this);
        NE.addActionListener(this);
        SE.addActionListener(this);
        NW.addActionListener(this);
        SW.addActionListener(this);

        boutonsN.add(NW);
        boutonsN.add(N);
        boutonsN.add(NE);

        boutonsS.add(SW);
        boutonsS.add(S);
        boutonsS.add(SE);

        container.add(posX, BorderLayout.EAST);
        container.add(posY, BorderLayout.EAST);
        boutons.add(boutonsN,BorderLayout.NORTH);
        boutons.add(boutonsS,BorderLayout.SOUTH);


        monPanneau.setPreferredSize(new Dimension(720,920));
        container.add(monPanneau,BorderLayout.WEST);
        container.add(boutons,BorderLayout.EAST);

        this.add(container);
        this.setVisible(true);
    }


    public void actionPerformed(ActionEvent arg8) {
        if(arg8.getSource() == N){

            monPanneau.x--;
            monPanneau.repaint();
            posX.setText("position x : " + monPanneau.x);
            posY.setText("position y : " + monPanneau.y);

        }

        if(arg8.getSource() == S){
            monPanneau.x++;
            monPanneau.repaint();
            posX.setText("position x : " + monPanneau.x);
            posY.setText("position y : " + monPanneau.y);
        }
        if(arg8.getSource() == SE){
            monPanneau.y++;
            if(monPanneau.y % 2 == 0) {
                monPanneau.x++;
            }
            monPanneau.repaint();
            posX.setText("position x : " + monPanneau.x);
            posY.setText("position y : " + monPanneau.y);
        }

        if(arg8.getSource() == NE){
            monPanneau.y++;
            if(monPanneau.y % 2 != 0){
                monPanneau.x--;
            }
            monPanneau.repaint();
            posX.setText("position x : " + monPanneau.x);
            posY.setText("position y : " + monPanneau.y);
        }
        if(arg8.getSource() == SW){
            monPanneau.y--;
            if(monPanneau.y % 2 == 0){
                monPanneau.x++;
            }

            monPanneau.repaint();
            posX.setText("position x : " + monPanneau.x);
            posY.setText("position y : " + monPanneau.y);
        }

        if(arg8.getSource() == NW){
            monPanneau.y--;
            if(monPanneau.y % 2 != 0){
                monPanneau.x--;
            }
            monPanneau.repaint();
            posX.setText("position x : " + monPanneau.x);
            posY.setText("position y : " + monPanneau.y);
        }
    }

}