import util.de;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Fenetre extends JFrame implements ActionListener {

    /*
     * Booléens de checks des boutons
     */
    private volatile Boolean Begin = false;
    private volatile Boolean isYes;
    private volatile Boolean isNo;
    private volatile Boolean isChoisi;
    private volatile Integer resultDe;
    private volatile Boolean doubleDe;
    private volatile Boolean aBouger;
    private volatile Boolean deJete;
    private volatile String monChoix;

    /*
     * Informations modifiées en temps réel
     */
    private JLabel Loc = new JLabel();
    private JLabel Typo = new JLabel();
    private JLabel Monu = new JLabel();
    private JLabel Route = new JLabel();
    private JLabel Quete = new JLabel();
    private JLabel Or = new JLabel();
    private JLabel vie = new JLabel();
    private JLabel Nourri = new JLabel();
    private JLabel suite = new JLabel();
    private JLabel poids = new JLabel();
    private JLabel Portage = new JLabel();

    /*
     * Boutons de contrôle
     */
    private JButton Dep;
    private JButton N = new JButton("N");
    private JButton NE = new JButton("NE");
    private JButton NW = new JButton("NW");
    private JButton S = new JButton("S");
    private JButton SE = new JButton("SE");
    private JButton SW = new JButton("SW");
    private JButton Oui = new JButton("OUI");
    private JButton Non = new JButton("NON");
    private JButton Choix1 = new JButton("Choix 1");
    private JButton Choix2 = new JButton("Choix 2");
    private JButton Choix3 = new JButton("Choix 3");


    /*
     * Zone d'histoire
     */
    private JScrollPane jScrollPane;
    private JTextArea Story = new JTextArea("BIENVENUE AU \"PRINCE BARBARE\" ! \n\n" +
                "Des événements maléfiques ont dépassés votre royaume du Nord.\n" +
                " Votre père, le vieux roi, est mort assassiné par ses rivaux au trône. \n" +
                "Ces usurpateurs tiennent maintenant le palais avec leur garde \n" +
                "royale mercenaire. \n" +
                "Vous vous êtes échappé et devez collecter 500 PIECES D'OR pour lever \n" +
                "une armée pour les écraser et reprendre votre héritage. De plus, \n" +
                "les usurpateurs ont de puissants amis à l'étranger. \n" +
                "Si vous ne pouvez pas revenir pour les vaincre dans 70 JOURS, leurs \n" +
                "alliés s'armeront et vous perdrez votre royaume pour toujours. \n" +
                "Pour échapper à la garde mercenaire et royale, votre fidèle serviteur \n" +
                "Ogab vous a fait passer clandestinement dans une caravane marchande \n" +
                "jusqu'à la frontière sud. \n\n" +
                "Pour commencer le jeu, lancez les dés en cliquant sur le bouton \n " +
                "ci-dessous !");


    /*
     * Plateau de jeu
     */
    private Panneau monPanneau;



    Fenetre(int x, int y){
        /*
         * Paramétrage de la fenêtre
         */
        this.setTitle("Prince des Barbares");
        this.setSize(1200, 1000);
        this.setBackground(Color.GRAY);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        /*
         * Zone globale de la fenêtre
         */
        JLayeredPane container = new JLayeredPane();


        /*
         * Ajout du plateau de jeu
         */
        monPanneau = new Panneau(x,y);
        monPanneau.setPreferredSize(new Dimension(720,940));
        monPanneau.setBounds(10,10,720,940);

        container.add(monPanneau);


        /*
         * Ajout du titre
         */
        JPanel panelTitre = new JPanel();
        panelTitre.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel strTitre = new JLabel("BARBARIAN PRINCE");
        strTitre.setForeground(Color.red);
        strTitre.setFont(new Font(" Calibri ",Font.BOLD,30));

        panelTitre.add(strTitre);
        panelTitre.setBounds(750,10,420,50);

        container.add(panelTitre);


        /*
         * Ajout de la zone d'histoire
         */
        Story.setEditable(false);
        Story.setFont(new Font(" Calibri ",Font.PLAIN,12));

        jScrollPane = new JScrollPane(Story);
        jScrollPane.setBounds(750,70,420,320);
        jScrollPane.getVerticalScrollBar().setValue(jScrollPane.getHorizontalScrollBar().getMaximum());
        container.add(jScrollPane);


        /*
         * Ajout de la zone de commandes du jeu
         */
        JPanel commandes = new JPanel();
        commandes.setLayout(new BorderLayout());
        commandes.setLayout(new BoxLayout(commandes, BoxLayout.PAGE_AXIS));
        commandes.setBounds(750,400,420,550);

        container.add(commandes);


        /*
         * Bouton de lancer de dés
         */
        Dep = new JButton("Lancer le(s) dé(s)");
        Dep.addActionListener(this);

        JPanel panelDep = new JPanel();
        panelDep.setLayout(new BoxLayout(panelDep, BoxLayout.LINE_AXIS));
        panelDep.add(Dep);

        commandes.add(panelDep);


         /*
         * Ajout des boutons de contrôle du jeu
         */
        JPanel boutons = new JPanel();
        boutons.setLayout(new BoxLayout(boutons, BoxLayout.PAGE_AXIS));

        JPanel boutonsN = new JPanel();
        NW.addActionListener(this);
        N.addActionListener(this);
        NE.addActionListener(this);
        boutonsN.add(NW);
        boutonsN.add(N);
        boutonsN.add(NE);

        JPanel boutonsS = new JPanel();
        SW.addActionListener(this);
        S.addActionListener(this);
        SE.addActionListener(this);
        boutonsS.add(SW);
        boutonsS.add(S);
        boutonsS.add(SE);

        JPanel yesno = new JPanel();
        Oui.addActionListener(this);
        Non.addActionListener(this);
        yesno.add(Oui);
        yesno.add(Non);

        JPanel choix = new JPanel();
        Choix1.addActionListener(this);
        Choix2.addActionListener(this);
        Choix3.addActionListener(this);
        choix.add(Choix1);
        choix.add(Choix2);
        choix.add(Choix3);

        boutons.add(boutonsN);
        boutons.add(boutonsS);
        boutons.add(yesno);
        boutons.add(choix);

        commandes.add(boutons);

        /*
         * Informations sur le terrain
         */
        JPanel panelTerrain = new JPanel();
        panelTerrain.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel terrain = new JLabel("<html><u>Informations sur le Terrain :</u></html>");
        panelTerrain.add(terrain);

        JPanel panelLoc = new JPanel();
        panelLoc.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel strLoc = new JLabel("   - Identifiant de la case : ");
        panelLoc.add(strLoc);
        panelLoc.add(Loc);
        Loc.setForeground(Color.red);

        JPanel panelTypo = new JPanel();
        panelTypo.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel strTypo = new JLabel("   - Typologie du terrain : ");
        panelTypo.add(strTypo);
        panelTypo.add(Typo);
        Typo.setForeground(Color.red);

        JPanel panelMonu = new JPanel();
        panelMonu.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel strMonu = new JLabel("   - Monument : ");
        panelMonu.add(strMonu);
        panelMonu.add(Monu);
        Monu.setForeground(Color.red);

        JPanel panelRoute = new JPanel();
        panelRoute.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel strRoute = new JLabel("   - Route : ");
        panelRoute.add(strRoute);
        panelRoute.add(Route);
        Route.setForeground(Color.red);

        Box infosTerrain = Box.createVerticalBox();
        infosTerrain.add(panelTerrain);
        infosTerrain.add(panelLoc);
        infosTerrain.add(panelTypo);
        infosTerrain.add(panelMonu);
        //infosTerrain.add(panelRoute);

        commandes.add(infosTerrain);


        /*
         * Informations sur le prince
         */
        JPanel panelPrince = new JPanel();
        panelPrince.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel prince = new JLabel("<html><u>Informations sur le Prince Barbare :</u></html>");
        panelPrince.add(prince);

        JPanel panelQuete = new JPanel();
        panelQuete.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel strQuete = new JLabel("   - Jours de quêtes restants : ");
        panelQuete.add(strQuete);
        panelQuete.add(Quete);
        Quete.setForeground(Color.red);

        JPanel panelOr = new JPanel();
        panelOr.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel strOr = new JLabel("   - Or disponible : ");
        panelOr.add(strOr);
        panelOr.add(Or);
        Or.setForeground(Color.red);

        JPanel panelNourri = new JPanel();
        panelNourri.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel strNourri = new JLabel("   - Nourriture Disponible : ");
        panelNourri.add(strNourri);
        panelNourri.add(Nourri);
        Nourri.setForeground(Color.red);

        JPanel panelVie = new JPanel();
        panelVie.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel strVie = new JLabel("   - Vie : ");
        panelVie.add(strVie);
        panelVie.add(vie);
        vie.setForeground(Color.red);

        JPanel panelPoids = new JPanel();
        panelPoids.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel strPoids = new JLabel("   - Valeur de combat : ");
        panelPoids.add(strPoids);
        panelPoids.add(poids);
        poids.setForeground(Color.red);

        JPanel panelSuite = new JPanel();
        panelSuite.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel strSuite = new JLabel("   - Équipe : ");
        panelSuite.add(strSuite);
        panelSuite.add(suite);
        suite.setForeground(Color.red);

        JPanel panelPortage = new JPanel();
        panelPortage.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel strPortage = new JLabel("   - Capacité de portage : ");
        panelPortage.add(strPortage);
        panelPortage.add(Portage);
        Portage.setForeground(Color.red);


        Box infosPrince = Box.createVerticalBox();
        infosPrince.add(panelPrince);
        infosPrince.add(panelQuete);
        infosPrince.add(panelOr);
        infosPrince.add(panelNourri);
        infosPrince.add(panelVie);
        infosPrince.add(panelPoids);
        infosPrince.add(panelSuite);
        infosPrince.add(panelPortage);

        commandes.add(infosPrince);





        /*
         * Affichage dans le fenêtre
         */
        this.add(container);
        this.setVisible(true);


        /*
         * Désactivation des boutons initialement
         */
        DisableOuiNon();
        DisableChoix();
        DisableMove();
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
        boolean minY = monPanneau.getYP() <= 0;
        boolean maxY = monPanneau.getYP() >= 19;
        boolean minX = monPanneau.getXP() <= 0;
        boolean maxX = monPanneau.getXP() >= 22;

        if(minY){
            NW.setEnabled(false);
            SW.setEnabled(false);
        }

        if(maxY){
            NE.setEnabled(false);
            SE.setEnabled(false);
        }

        if (maxX && monPanneau.getYP() % 2 == 0){
            S.setEnabled(false);
        } else if (maxX && monPanneau.getYP() % 2 != 0) {
            S.setEnabled(false);
            SW.setEnabled(false);
            SE.setEnabled(false);
        }

        if(minX){
            N.setEnabled(false);
            if(monPanneau.getYP() % 2 == 0){
                NW.setEnabled(false);
                NE.setEnabled(false);
            }
        }

    }

    public void actionPerformed(ActionEvent arg8) {
        if(arg8.getSource() == Dep){
            if(!getBegin()){
                int[] val = new int[6];
                val[0] = 0;
                val[1] = 6;
                val[2] = 8;
                val[3] = 12;
                val[4] = 14;
                val[5] = 18;
                setResultDe(de.randomDie());
                monPanneau.setYP(val[getResultDe()-1]);
                monPanneau.repaint();
                updateLoc();
                setBegin(true);
                DisableDe();
            } else {
                if(getDoubleDe()){
                    setResultDe(de.randomDice());
                } else {
                    setResultDe(de.randomDie());
                }
                setDeJete(true);
            }
        }
        else if(arg8.getSource() == N){
            monPanneau.setXP(monPanneau.getXP()-1);
            monPanneau.repaint();
            setaBouger(true);
            updateLoc();
        }
        else if(arg8.getSource() == S){
            deplacementSud();
        }
        else if(arg8.getSource() == SE){
            deplacementSudEst();
        }
        else if(arg8.getSource() == NE){
            deplacementNordEst();
        }
        else if(arg8.getSource() == SW){
            deplacementSudOuest();
        }
        else if(arg8.getSource() == NW){
            deplacementNordOuest();
        }
        else if(arg8.getSource() == Oui){
            setYes(true);
        }
        else if(arg8.getSource() == Non){
            setNo(true);
        }
        else if(arg8.getSource() == Choix1){
            setChoisi(true);
            setMonChoix(Choix1.getText());
        }
        else if(arg8.getSource() == Choix2){
            setChoisi(true);
            setMonChoix(Choix2.getText());
        }
        else if(arg8.getSource() == Choix3){
            setChoisi(true);
            setMonChoix(Choix3.getText());
        }
    }

    Integer aLancerDe(Integer NbDe){
        setStory(getStory() + "\n Veuillez lancer le(s) dé(s) pour continuer.");
        setDoubleDe(NbDe == 2);
        setDeJete(false);
        EnableDe();

        Integer repo = 0;
        while(repo == 0){
            if(getDeJete()){
                DisableDe();
                repo = getResultDe();
            }
        }

        return repo;
    }

    String aRepondu(){
        setYes(false);
        setNo(false);
        EnableOuiNon();

        String rep = "";

        while(rep.equals("")){
            if(getYes()){
                rep = "Oui";
            } else if (getNo()){
                rep = "Non";
            }
        }
        DisableOuiNon();

        return rep;
    }

    String aChoisi(String c1, String c2, String c3){
        setChoisi(false);
        setMonChoix("");
        EnableChoix(!c3.equals(""));
        setChoix1(c1);
        setChoix2(c2);
        if(!c3.equals("")){
            setChoix3(c3);
        }

        String ch = "";
        while(ch.equals("")){
            if(getChoisi()){
                DisableChoix();
                ch = getMonChoix();
            }
        }

        return ch;
    }

    String estDeplace(){
        setStory(getStory() + "\nDéplacez-vous grâce aux boutons dédiés.");
        setaBouger(false);
        EnableMove();

        String loc = "";
        while(loc.equals("")){
            if(getaBouger()){
                loc = getLoc(monPanneau.getXP(), monPanneau.getYP());
            }
        }
        DisableMove();

        return loc;
    }

    Boolean getaBouger() {
        return aBouger;
    }

    Boolean getBegin() {
        return Begin;
    }

    Boolean getChoisi() {
        return isChoisi;
    }

    Boolean getDeJete() {
        return deJete;
    }

    Boolean getDoubleDe() {
        return doubleDe;
    }

    Boolean getNo() {
        return isNo;
    }

    Boolean getYes() {
        return isYes;
    }

    Integer getResultDe() {
        return resultDe;
    }

    String getMonChoix() {
        return monChoix;
    }

    String getStory(){

        return this.Story.getText();
    }

    void updateLoc() {
        Loc.setText(getLoc(monPanneau.getXP(), monPanneau.getYP()));
    }

    void setaBouger(Boolean aBouger) {
        this.aBouger = aBouger;
    }

    void setBegin(Boolean begin) {
        Begin = begin;
    }

    void setChoisi(Boolean choisi) {
        isChoisi = choisi;
    }

    void setDeJete(Boolean deJete) {
        this.deJete = deJete;
    }

    void setDoubleDe(Boolean doubleDe) {
        this.doubleDe = doubleDe;
    }

    void setResultDe(Integer res) {
        this.resultDe = res;
    }

    void setNo(Boolean no) {
        isNo = no;
    }

    void setYes(Boolean yes) {
        isYes = yes;
    }

    void setMonChoix(String monChoix) {
        this.monChoix = monChoix;
    }

    void setMonu(String monu) {
        Monu.setText(monu);
    }

    void setNourri(String nourri) {
        Nourri.setText(nourri);
    }

    void setOr(String or) {
        Or.setText(or);
    }

    void setPoids(String poids) {
        this.poids.setText(poids);
    }

    void setQuete(String quete) {
        Quete.setText(quete);
    }

    void setPortage(String portage) {
        Portage.setText(portage);
    }

    void setRoute(String route) {
        Route.setText(route);
    }

    void setSuite(String suite) {
        this.suite.setText(suite);
    }

    void setTypo(String typo) {
        Typo.setText(typo);
    }

    void setVie(String vie) {
        this.vie.setText(vie);
    }

    void setStory(String story) {
        Story.setText(story);
        updateScroll();
    }

    private void updateScroll(){
        jScrollPane.getVerticalScrollBar().setValue(jScrollPane.getVerticalScrollBar().getMaximum());
    }

    void setChoix1(String choix) {
        Choix1.setText(choix);
    }

    void setChoix2(String choix) {
        Choix2.setText(choix);
    }

    void setChoix3(String choix) {
        Choix3.setText(choix);
    }

    void EnableOuiNon() {
        Oui.setEnabled(true);
        Non.setEnabled(true);
    }

    void DisableOuiNon() {
        Oui.setEnabled(false);
        Non.setEnabled(false);
    }

    void EnableMove(){
        NW.setEnabled(true);
        SW.setEnabled(true);
        NE.setEnabled(true);
        SE.setEnabled(true);
        S.setEnabled(true);
        N.setEnabled(true);
        verifBords();
    }

    void DisableMove(){
        NW.setEnabled(false);
        SW.setEnabled(false);
        NE.setEnabled(false);
        SE.setEnabled(false);
        S.setEnabled(false);
        N.setEnabled(false);
    }

    void EnableChoix(Boolean is3){
        Choix1.setEnabled(true);
        Choix2.setEnabled(true);

        if(is3){
            Choix3.setEnabled(true);
        } else {
            Choix3.setEnabled(false);
        }
    }

    void DisableChoix() {
        Choix1.setEnabled(false);
        Choix2.setEnabled(false);
        Choix3.setEnabled(false);
    }

    void EnableDe(){
        Dep.setEnabled(true);
    }

    void DisableDe(){
        Dep.setEnabled(false);
    }


//DÉPLACEMENT


public void deplacementNord(){
        monPanneau.setXP(monPanneau.getXP()-1);
        monPanneau.repaint();
        setaBouger(true);
        updateLoc();
    }

public void deplacementSud(){
        monPanneau.setXP(monPanneau.getXP()+1);
        monPanneau.repaint();
        setaBouger(true);
        updateLoc();
    }

public void deplacementSudEst(){
        monPanneau.setYP(monPanneau.getYP()+1);
        if(monPanneau.getYP() % 2 == 0) {
            monPanneau.setXP(monPanneau.getXP()+1);
        }
        monPanneau.repaint();
        setaBouger(true);
        updateLoc();
    }

public void deplacementNordEst(){
        monPanneau.setYP(monPanneau.getYP()+1);
        if(monPanneau.getYP() % 2 != 0){
            monPanneau.setXP(monPanneau.getXP()-1);
        }
        monPanneau.repaint();
        setaBouger(true);
        updateLoc();
    }

public void deplacementSudOuest(){
        monPanneau.setYP(monPanneau.getYP()-1);
        if(monPanneau.getYP() % 2 == 0){
            monPanneau.setXP(monPanneau.getXP()+1);
        }
        monPanneau.repaint();
        setaBouger(true);
        updateLoc();
    }

public void deplacementNordOuest(){
        monPanneau.setYP(monPanneau.getYP()-1);
        if(monPanneau.getYP() % 2 != 0){
            monPanneau.setXP(monPanneau.getXP()-1);
        }
        monPanneau.repaint();
        setaBouger(true);
        updateLoc();
    }
}
