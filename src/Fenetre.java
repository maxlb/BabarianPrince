import util.de;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Fenetre extends JFrame implements ActionListener {
    private JPanel container = new JPanel();
    private JPanel Infos = new JPanel();
    public Boolean Begin = false;
    public Boolean isYes = false;
    public Boolean isNo = false;



    private Box InfosTerrain;
        private JLabel Terrain = new JLabel("Infos Terrain :");
        private JPanel PanelLoc = new JPanel();
            private JLabel StrLoc = new JLabel("Identifiant de la case : ");
            public JLabel Loc = new JLabel();
        private JPanel PanelTypo = new JPanel();
            private JLabel StrTypo = new JLabel("Typologie du terrain : ");
            public JLabel Typo = new JLabel();
        private JPanel PanelMonu = new JPanel();
            private JLabel StrMonu = new JLabel("Monument : ");
            public JLabel Monu = new JLabel();
        private JPanel PanelRoute = new JPanel();
            private JLabel StrRoute = new JLabel("Route : ");
            public JLabel Route = new JLabel();

    private Box InfosPrince;
        private JLabel Prince = new JLabel("Infos Prince :");
        private JPanel PanelQuete = new JPanel();
            private JLabel StrQuete = new JLabel("Jours de quêtes restants : ");
            public JLabel Quete = new JLabel();
        private JPanel PanelOr = new JPanel();
            private JLabel StrOr = new JLabel("Or disponible : ");
            public JLabel Or = new JLabel();
        private JPanel PanelNourri = new JPanel();
            private JLabel StrNourri = new JLabel("Nourriture Disponible : ");
            public JLabel Nourri = new JLabel();
        private JPanel PanelVie = new JPanel();
            private JLabel StrVie = new JLabel("Vie : ");
            public JLabel Vie = new JLabel();
        private JPanel PanelPoids = new JPanel();
            private JLabel StrPoids = new JLabel("Poids à porter : ");
            public JLabel Poids = new JLabel();
        private JPanel PanelSuite = new JPanel();
            private JLabel StrSuite = new JLabel("Equipe : ");
            public JLabel Suite = new JLabel();
        private JPanel PanelPortage = new JPanel();
            private JLabel StrPortage = new JLabel("Capacité de portage : ");
            public JLabel Portage = new JLabel();

    private JPanel commandes = new JPanel();
        private JPanel Location = new JPanel();
                private JPanel PanelDep = new JPanel();
                private JButton Dep = new JButton("Départ");

        private JPanel boutons = new JPanel();
            private JPanel boutonsN = new JPanel();
                private JButton N = new JButton("N");
                private JButton NE = new JButton("NE");
                private JButton NW = new JButton("NW");
            private JPanel boutonsS = new JPanel();
                private JButton S = new JButton("S");
                private JButton SE = new JButton("SE");
                private JButton SW = new JButton("SW");
            private JPanel Yesno = new JPanel();
                private JButton Oui = new JButton("OUI");
                private JButton Non = new JButton("NON");
    private JPanel Affichage = new JPanel();
        private JLabel StrStory = new JLabel("Boite de dialogue : ");
        public JLabel Story = new JLabel();


    private Panneau monPanneau;


    public Fenetre(int x, int y){
        monPanneau = new Panneau(x,y);

        this.setTitle("Prince des Barbares");
        this.setSize(1100, 990);
        this.setBackground(Color.GRAY);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        boutons.setLayout(new BorderLayout());
        commandes.setLayout(new BorderLayout());
        Affichage.setLayout(new BorderLayout());

        N.addActionListener(this);
        S.addActionListener(this);
        NE.addActionListener(this);
        SE.addActionListener(this);
        NW.addActionListener(this);
        SW.addActionListener(this);
        Dep.addActionListener(this);
        Oui.addActionListener(this);
        Non.addActionListener(this);

        boutonsN.add(NW);
        boutonsN.add(N);
        boutonsN.add(NE);

        boutonsS.add(SW);
        boutonsS.add(S);
        boutonsS.add(SE);

        Yesno.add(Oui);
        Yesno.add(Non);

        boutons.setLayout(new BoxLayout(boutons, BoxLayout.PAGE_AXIS));
        boutons.add(boutonsN);
        boutons.add(boutonsS);
        boutons.add(Yesno);

        PanelDep.setLayout(new BoxLayout(PanelDep, BoxLayout.LINE_AXIS));
        PanelDep.add(Dep);

        PanelLoc.setLayout(new FlowLayout(FlowLayout.LEFT));
        PanelLoc.add(StrLoc);
        PanelLoc.add(Loc);

        PanelTypo.setLayout(new FlowLayout(FlowLayout.LEFT));
        PanelTypo.add(StrTypo);
        PanelTypo.add(Typo);

        PanelMonu.setLayout(new FlowLayout(FlowLayout.LEFT));
        PanelMonu.add(StrMonu);
        PanelMonu.add(Monu);

        PanelRoute.setLayout(new FlowLayout(FlowLayout.LEFT));
        PanelRoute.add(StrRoute);
        PanelRoute.add(Route);

        InfosTerrain = Box.createVerticalBox();
        InfosTerrain.add(Terrain);
        InfosTerrain.add(PanelLoc);
        InfosTerrain.add(PanelTypo);
        InfosTerrain.add(PanelMonu);
        InfosTerrain.add(PanelRoute);


        InfosPrince = Box.createVerticalBox();
        InfosPrince.add(Prince);
        InfosPrince.add(PanelQuete);
        InfosPrince.add(PanelOr);
        InfosPrince.add(PanelNourri);
        InfosPrince.add(PanelVie);
        InfosPrince.add(PanelPoids);
        InfosPrince.add(PanelSuite);
        InfosPrince.add(PanelPortage);


        PanelQuete.setLayout(new FlowLayout(FlowLayout.LEFT));
        PanelQuete.add(StrQuete);
        PanelQuete.add(Quete);

        PanelOr.setLayout(new FlowLayout(FlowLayout.LEFT));
        PanelOr.add(StrOr);
        PanelOr.add(Or);

        PanelNourri.setLayout(new FlowLayout(FlowLayout.LEFT));
        PanelNourri.add(StrNourri);
        PanelNourri.add(Nourri);

        PanelVie.setLayout(new FlowLayout(FlowLayout.LEFT));
        PanelVie.add(StrVie);
        PanelVie.add(Vie);

        PanelPoids.setLayout(new FlowLayout(FlowLayout.LEFT));
        PanelPoids.add(StrPoids);
        PanelPoids.add(Poids);

        PanelSuite.setLayout(new FlowLayout(FlowLayout.LEFT));
        PanelSuite.add(StrSuite);
        PanelSuite.add(Suite);

        PanelPortage.setLayout(new FlowLayout(FlowLayout.LEFT));
        PanelPortage.add(StrPortage);
        PanelPortage.add(Portage);


        Location.setLayout(new BoxLayout(Location, BoxLayout.PAGE_AXIS));
        Location.add(PanelDep);

        commandes.setLayout(new BoxLayout(commandes, BoxLayout.PAGE_AXIS));
        commandes.add(Location);
        commandes.add(InfosTerrain);
        commandes.add(InfosPrince);
        commandes.add(boutons);

        Infos.setLayout(new BoxLayout(Infos, BoxLayout.PAGE_AXIS));
        Infos.add(commandes);
        Infos.add(Affichage);

        Affichage.setLayout(new BoxLayout(Affichage, BoxLayout.PAGE_AXIS));
        Affichage.add(StrStory);
        Affichage.add(Story);

        monPanneau.setPreferredSize(new Dimension(720,940));

        container.add(monPanneau,BorderLayout.WEST);
        container.add(Infos);


        this.add(container);
        this.setVisible(true);
        verifBords();
        Loc.setText(getLoc(monPanneau.x, monPanneau.y));
    }

    private String getLoc(Integer x, Integer y){
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

    private void verifBords(){
        if(monPanneau.y != 50){
            boolean minY = monPanneau.y <= 0;
            boolean maxY = monPanneau.y >= 19;
            boolean minX = monPanneau.x <= 0;
            boolean maxX = monPanneau.x >= 22;

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
            if (maxX && monPanneau.y % 2 == 0){
                S.setEnabled(false);
            } else if (maxX && monPanneau.y % 2 != 0) {
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
            monPanneau.y = val[de.randomDie()-1];
            monPanneau.repaint();
            Loc.setText(getLoc(monPanneau.x, monPanneau.y));
            Begin = true;
            Dep.setVisible(false);
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
        if(arg8.getSource() == Oui){
            //BOUTON OUI A DEFINIR
        }
        if(arg8.getSource() == Non){
            //BOUTON NON A DEFINIR
        }
        verifBords();
        Loc.setText(getLoc(monPanneau.x, monPanneau.y));
    }


}
