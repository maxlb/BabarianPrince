import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenetre extends JFrame implements ActionListener {
    private JPanel container = new JPanel();

    private JPanel Posi = new JPanel();
    JLabel posX = new JLabel();
    JLabel posY = new JLabel();

    private JPanel commandes = new JPanel();
        private JPanel Location = new JPanel();
            private JPanel PanelDep = new JPanel();
                private JButton Dep = new JButton("Départ");
            private JPanel PanelStr = new JPanel();
                private JLabel StrLoc = new JLabel("Identifiant de la case : ");
                private JLabel Loc = new JLabel();

        private JPanel boutons = new JPanel();
            private JPanel boutonsN = new JPanel();
                private JButton N = new JButton("N");
                private JButton NE = new JButton("NE");
                private JButton NW = new JButton("NW");
            private JPanel boutonsS = new JPanel();
                private JButton S = new JButton("S");
                private JButton SE = new JButton("SE");
                private JButton SW = new JButton("SW");


    private Panneau monPanneau;


    public Fenetre(int x, int y){
        monPanneau = new Panneau(x,y);

        this.setTitle("Prince des Barbares");
        this.setSize(1000, 970);
        this.setBackground(Color.GRAY);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        boutons.setLayout(new BorderLayout());
        commandes.setLayout(new BorderLayout());

        N.addActionListener(this);
        S.addActionListener(this);
        NE.addActionListener(this);
        SE.addActionListener(this);
        NW.addActionListener(this);
        SW.addActionListener(this);
        Dep.addActionListener(this);

        boutonsN.add(NW);
        boutonsN.add(N);
        boutonsN.add(NE);

        boutonsS.add(SW);
        boutonsS.add(S);
        boutonsS.add(SE);

        boutons.setLayout(new BoxLayout(boutons, BoxLayout.PAGE_AXIS));
        boutons.add(boutonsN);
        boutons.add(boutonsS);


        PanelDep.setLayout(new BoxLayout(PanelDep, BoxLayout.LINE_AXIS));
        PanelDep.add(Dep);

        PanelStr.setLayout(new BoxLayout(PanelStr, BoxLayout.LINE_AXIS));
        PanelStr.add(StrLoc);
        PanelStr.add(Loc);

        Location.setLayout(new BoxLayout(Location, BoxLayout.PAGE_AXIS));
        Location.add(PanelDep);
        Location.add(PanelStr);

        commandes.setLayout(new BoxLayout(commandes, BoxLayout.PAGE_AXIS));
        commandes.add(Location);
        commandes.add(boutons);

        monPanneau.setPreferredSize(new Dimension(720,920));

        container.add(monPanneau,BorderLayout.WEST);
        container.add(commandes,BorderLayout.EAST);

        this.add(container);
        this.setVisible(true);
        verifBords();
        Loc.setText(getLoc(monPanneau.x, monPanneau.y));
    }



    public String getLoc(Integer x, Integer y){
        String str = "";
        Integer valx = x+1;
        Integer valy = y+1;

        if(valy < 10){
            str += "0";
        }

        str += valy.toString();

        if(valx < 10){
            str += "0";
        }

        str += valx.toString();

        if(y == 50){
            str = "";
        }

        return str;
    }

    public void verifBords(){
        if(monPanneau.y != 50){
            boolean minY = monPanneau.y <= 0;
            boolean maxY = monPanneau.y >= 19;
            boolean minX = monPanneau.x <= 0;
            boolean maxX = monPanneau.x >= 21;

            if(minY){
                NW.setEnabled(false);
                SW.setEnabled(false);
            } else {
                NW.setEnabled(true);
                SW.setEnabled(true);
            }
            if(maxY){
                NE.setEnabled(false);
                SE.setEnabled(false);
            } else {
                NE.setEnabled(true);
                SE.setEnabled(true);
            }
            if (maxX && monPanneau.y % 2 != 0){
                S.setEnabled(false);
            } else if (monPanneau.x == 22 && monPanneau.y % 2 == 0) {
                S.setEnabled(false);
                SW.setEnabled(false);
                SE.setEnabled(false);
            } else {
                S.setEnabled(true);
            }
            if(minX){
                N.setEnabled(false);
                if(monPanneau.y % 2 == 0){
                    NW.setEnabled(false);
                    NE.setEnabled(false);
                }
            } else {
                N.setEnabled(true);
            }
        } else {
            NW.setEnabled(false);
            SW.setEnabled(false);
            NE.setEnabled(false);
            SE.setEnabled(false);
            S.setEnabled(false);
            N.setEnabled(false);
        }

    }

    public void actionPerformed(ActionEvent arg8) {
        if(arg8.getSource() == Dep){
            int[] val = new int[6];
            val[0] = 0;
            val[1] = 6;
            val[2] = 8;
            val[3] = 12;
            val[4] = 14;
            val[5] = 18;
            monPanneau.y = val[(int)(Math.random()*6)];
            monPanneau.repaint();
            Dep.setEnabled(false);
        }
        if(arg8.getSource() == N){

            monPanneau.x--;
            monPanneau.repaint();

        }
        if(arg8.getSource() == S){
            monPanneau.x++;
            monPanneau.repaint();
        }
        if(arg8.getSource() == SE){
            monPanneau.y++;
            if(monPanneau.y % 2 == 0) {
                monPanneau.x++;
            }
            monPanneau.repaint();
        }
        if(arg8.getSource() == NE){
            monPanneau.y++;
            if(monPanneau.y % 2 != 0){
                monPanneau.x--;
            }
            monPanneau.repaint();
        }
        if(arg8.getSource() == SW){
            monPanneau.y--;
            if(monPanneau.y % 2 == 0){
                monPanneau.x++;
            }
            monPanneau.repaint();
        }
        if(arg8.getSource() == NW){
            monPanneau.y--;
            if(monPanneau.y % 2 != 0){
                monPanneau.x--;
            }
            monPanneau.repaint();
        }
        verifBords();
        Loc.setText(getLoc(monPanneau.x, monPanneau.y));
    }


}
