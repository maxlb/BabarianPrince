import util.de;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Fenetre extends JFrame implements ActionListener {
    private JLayeredPane container = new JLayeredPane();
    private JPanel Infos = new JPanel();
    public Boolean Begin = false;

    public Boolean isYes = false;
    public Boolean isNo = false;
    public Integer resultDe;
    public Boolean doubleDe = false;
    private Boolean aBouger = false;

    private Box InfosTerrain;
        private JPanel PanelTerrain = new JPanel();
            private JLabel Terrain = new JLabel("<html><u>Informations sur le Terrain :</u></html>");
        private JPanel PanelLoc = new JPanel();
            private JLabel StrLoc = new JLabel("   - Identifiant de la case : ");
            public JLabel Loc = new JLabel();
        private JPanel PanelTypo = new JPanel();
            private JLabel StrTypo = new JLabel("   - Typologie du terrain : ");
            public JLabel Typo = new JLabel();
        private JPanel PanelMonu = new JPanel();
            private JLabel StrMonu = new JLabel("   - Monument : ");
            public JLabel Monu = new JLabel();
        private JPanel PanelRoute = new JPanel();
            private JLabel StrRoute = new JLabel("   - Route : ");
            public JLabel Route = new JLabel();

    private Box InfosPrince;
        private JPanel PanelPrince = new JPanel();
            private JLabel Prince = new JLabel("<html><u>Informations sur le Prince Barbare :</u></html>");
        private JPanel PanelQuete = new JPanel();
            private JLabel StrQuete = new JLabel("   - Jours de quêtes restants : ");
            public JLabel Quete = new JLabel();
        private JPanel PanelOr = new JPanel();
            private JLabel StrOr = new JLabel("   - Or disponible : ");
            public JLabel Or = new JLabel();
        private JPanel PanelNourri = new JPanel();
            private JLabel StrNourri = new JLabel("   - Nourriture Disponible : ");
            public JLabel Nourri = new JLabel();
        private JPanel PanelVie = new JPanel();
            private JLabel StrVie = new JLabel("   - Vie : ");
            public JLabel Vie = new JLabel();
        private JPanel PanelPoids = new JPanel();
            private JLabel StrPoids = new JLabel("   - Poids à porter : ");
            public JLabel Poids = new JLabel();
        private JPanel PanelSuite = new JPanel();
            private JLabel StrSuite = new JLabel("   - Equipe : ");
            public JLabel Suite = new JLabel();
        private JPanel PanelPortage = new JPanel();
            private JLabel StrPortage = new JLabel("   - Capacité de portage : ");
            public JLabel Portage = new JLabel();

    private JPanel commandes = new JPanel();
        private JPanel Location = new JPanel();
                private JPanel PanelDep = new JPanel();
                private JButton Dep = new JButton("Lancer le(s) dé(s)");

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
                public JButton Oui = new JButton("OUI");
                public JButton Non = new JButton("NON");

    private JLayeredPane Affichage = new JLayeredPane();

        private JPanel PanelTitre = new JPanel();
        private JLabel StrStory = new JLabel("BARBARIAN PRINCE");
        public JTextArea Story = new JTextArea(" BIENVENUE DANS \"PRINCE BARBARE\" ! \n\n" +
                "  Votre royaume est le théatre de terribles événements. \n" +
                "  Votre vénérable père, le vieux roi, est mort assassiné par ses rivaux \n" +
                "  convoitant le trône. Ces usurpateurs tiennent maintenant le palais,\n" +
                "  protégés par leur féroce garde royale de mercenaires sans pitié. \n" +
                "  Vous avez pu vous échapper et devez au plus vite rassembler\n" +
                "  500 PIECES D'OR pour lever une armée et écraser \n" +
                "  ces immondes traîtres et reprendre votre héritage. \n\n" +
                "  Mais ATTENTION ! Les usurpateurs ont de puissants amis \n" +
                "  à l'étranger. Si vous ne pouvez pas revenir pour les vaincre\n" +
                "  dans 70 JOURS, leurs alliés s'armeront et vous perdrez votre royaume \n" +
                "  pour toujours… Pour échapper à la garde mercenaire et royale, \n" +
                "  votre fidèle serviteur Ogab vous a fait passer clandestinement dans \n" +
                "  une caravane marchande jusqu'à la frontière sud. \n" +
                "  Pour commencer le jeu, lancez les dés en cliquant sur le bouton \n " +
                "  ci-dessous ! Bonne chance !");


    private Panneau monPanneau;


    public Fenetre(int x, int y){
        monPanneau = new Panneau(x,y);
        Story.setEditable(false);

        this.setTitle("Prince des Barbares");
        this.setSize(1200, 1000);
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
        Oui.setEnabled(false);
        Non.setEnabled(false);

        boutons.setLayout(new BoxLayout(boutons, BoxLayout.PAGE_AXIS));
        boutons.add(boutonsN);
        boutons.add(boutonsS);
        boutons.add(Yesno);

        PanelDep.setLayout(new BoxLayout(PanelDep, BoxLayout.LINE_AXIS));
        PanelDep.add(Dep);

        PanelLoc.setLayout(new FlowLayout(FlowLayout.LEFT));
        PanelLoc.add(StrLoc);
        PanelLoc.add(Loc);
        Loc.setForeground(Color.red);

        PanelTypo.setLayout(new FlowLayout(FlowLayout.LEFT));
        PanelTypo.add(StrTypo);
        PanelTypo.add(Typo);
        Typo.setForeground(Color.red);

        PanelMonu.setLayout(new FlowLayout(FlowLayout.LEFT));
        PanelMonu.add(StrMonu);
        PanelMonu.add(Monu);
        Monu.setForeground(Color.red);

        PanelRoute.setLayout(new FlowLayout(FlowLayout.LEFT));
        PanelRoute.add(StrRoute);
        PanelRoute.add(Route);
        Route.setForeground(Color.red);

        PanelTerrain.setLayout(new FlowLayout(FlowLayout.LEFT));
        PanelTerrain.add(Terrain);

        InfosTerrain = Box.createVerticalBox();
        InfosTerrain.add(PanelTerrain);
        InfosTerrain.add(PanelLoc);
        InfosTerrain.add(PanelTypo);
        InfosTerrain.add(PanelMonu);
        InfosTerrain.add(PanelRoute);


        InfosPrince = Box.createVerticalBox();
        InfosPrince.add(PanelPrince);
        InfosPrince.add(PanelQuete);
        InfosPrince.add(PanelOr);
        InfosPrince.add(PanelNourri);
        InfosPrince.add(PanelVie);
        InfosPrince.add(PanelPoids);
        InfosPrince.add(PanelSuite);
        InfosPrince.add(PanelPortage);


        PanelPrince.setLayout(new FlowLayout(FlowLayout.LEFT));
        PanelPrince.add(Prince);

        PanelQuete.setLayout(new FlowLayout(FlowLayout.LEFT));
        PanelQuete.add(StrQuete);
        PanelQuete.add(Quete);
        Quete.setForeground(Color.red);

        PanelOr.setLayout(new FlowLayout(FlowLayout.LEFT));
        PanelOr.add(StrOr);
        PanelOr.add(Or);
        Or.setForeground(Color.red);

        PanelNourri.setLayout(new FlowLayout(FlowLayout.LEFT));
        PanelNourri.add(StrNourri);
        PanelNourri.add(Nourri);
        Nourri.setForeground(Color.red);

        PanelVie.setLayout(new FlowLayout(FlowLayout.LEFT));
        PanelVie.add(StrVie);
        PanelVie.add(Vie);
        Vie.setForeground(Color.red);

        PanelPoids.setLayout(new FlowLayout(FlowLayout.LEFT));
        PanelPoids.add(StrPoids);
        PanelPoids.add(Poids);
        Poids.setForeground(Color.red);

        PanelSuite.setLayout(new FlowLayout(FlowLayout.LEFT));
        PanelSuite.add(StrSuite);
        PanelSuite.add(Suite);
        Suite.setForeground(Color.red);

        PanelPortage.setLayout(new FlowLayout(FlowLayout.LEFT));
        PanelPortage.add(StrPortage);
        PanelPortage.add(Portage);
        Portage.setForeground(Color.red);

        Location.setLayout(new BoxLayout(Location, BoxLayout.PAGE_AXIS));
        Location.add(PanelDep);

        commandes.setLayout(new BoxLayout(commandes, BoxLayout.PAGE_AXIS));
        commandes.add(Location);
        commandes.add(InfosTerrain);
        commandes.add(InfosPrince);
        commandes.add(boutons);

        Affichage.setLayout(new BoxLayout(Affichage, BoxLayout.PAGE_AXIS));
        PanelTitre.setLayout(new FlowLayout(FlowLayout.CENTER));
        PanelTitre.add(StrStory);

        StrStory.setForeground(Color.red);
        StrStory.setFont(new Font(" Calibri ",Font.BOLD,30));

        Affichage.add(PanelTitre);
        Affichage.add(Story);
        Story.setFont(new Font(" Calibri ",Font.PLAIN,12));

        monPanneau.setPreferredSize(new Dimension(720,940));
        monPanneau.setBounds(10,10,720,940);
        Affichage.setBounds(750,10,420,320);
        commandes.setBounds(750,340,420,500);


        container.add(monPanneau);
        container.add(commandes);
        container.add(Affichage);

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
            if(!Begin){
                int[] val = new int[6];
                val[0] = 0;
                val[1] = 6;
                val[2] = 8;
                val[3] = 12;
                val[4] = 14;
                val[5] = 18;
                resultDe = de.randomDie();
                monPanneau.y = val[resultDe-1];
                monPanneau.repaint();
                Loc.setText(getLoc(monPanneau.x, monPanneau.y));
                Begin = true;
            } else {
                if(doubleDe){
                    resultDe = de.randomDice();
                } else {
                    resultDe = de.randomDie();
                }
            }
            Dep.setEnabled(false);
        }
        if(arg8.getSource() == N){
            monPanneau.x--;
            monPanneau.repaint();
            aBouger = true;
        }
        if(arg8.getSource() == S){
            monPanneau.x++;
            monPanneau.repaint();
            aBouger = true;
        }
        if(arg8.getSource() == SE){
            monPanneau.y++;
            if(monPanneau.y % 2 == 0) {
                monPanneau.x++;
            }
            monPanneau.repaint();
            aBouger = true;
        }
        if(arg8.getSource() == NE){
            monPanneau.y++;
            if(monPanneau.y % 2 != 0){
                monPanneau.x--;
            }
            monPanneau.repaint();
            aBouger = true;
        }
        if(arg8.getSource() == SW){
            monPanneau.y--;
            if(monPanneau.y % 2 == 0){
                monPanneau.x++;
            }
            monPanneau.repaint();
            aBouger = true;
        }
        if(arg8.getSource() == NW){
            monPanneau.y--;
            if(monPanneau.y % 2 != 0){
                monPanneau.x--;
            }
            monPanneau.repaint();
            aBouger = true;
        }
        if(arg8.getSource() == Oui){
            isYes = true;
            Oui.setEnabled(false);
            Non.setEnabled(false);
        }
        if(arg8.getSource() == Non){
            isNo = true;
            Non.setEnabled(false);
            Oui.setEnabled(false);
        }
        Loc.setText(getLoc(monPanneau.x, monPanneau.y));
    }

    public Integer aLancerDe(Integer NbDe){
        if(NbDe == 2){
            doubleDe = true;
        } else {
            doubleDe = false;
        }

        Story.setText(Story.getText()+"\n Veuillez lancer le(s) dé(s) pour continuer.");
        Dep.setEnabled(true);

        Boolean rep = true;
        while(rep){
            if(!Dep.isEnabled()){
                rep = false;
            }
        }

        return resultDe;
    }

    public void setStory(String story){
        this.Story.setText(story);
    }

    public String getStory(){
        return this.Story.getText();
    }

    public String aRepondu(){
        String repo = "";
        Non.setEnabled(true);
        Oui.setEnabled(true);

        while(Oui.isEnabled()){

            if(isYes){
                repo = "Oui";
                isYes = false;
            }
            if(isNo){
                repo = "Non";
                isNo = false;
            }
        }
        return repo;
    }

    public String estDeplace(){
        Story.setText(Story.getText() + "\nDéplacez-vous grâce aux boutons dédiés.");
        aBouger = false;
        Boolean bouger = false;
        String loc = "";
        NW.setEnabled(true);
        SW.setEnabled(true);
        NE.setEnabled(true);
        SE.setEnabled(true);
        S.setEnabled(true);
        N.setEnabled(true);
        verifBords();

        while(!bouger){
            if(aBouger){
                loc = getLoc(monPanneau.x, monPanneau.y);
                bouger = true;
                NW.setEnabled(false);
                SW.setEnabled(false);
                NE.setEnabled(false);
                SE.setEnabled(false);
                S.setEnabled(false);
                N.setEnabled(false);
            }
        }
        return loc;
    }
}
