import java.util.Map;
import Personnages.Prince;
import Personnages.NewCharacter;


public class happen {

    static Map<String, Integer> monTerrain = Init.InitTypeTerrain(); //initialise les topologies de terrain de chaque case
    static Map<String, Integer> mesMonum = Init.InitMonument(); //initialise la position des monuments
    static Map<String, Integer> mesRoutes = Init.InitRoute(); //initialise la position des routes

    public static Hex e001(game myGame, Fenetre fenetre){

        //quelle case pour démarrer
        //myGame.setCurrentCase("null");
        String str ="";
        switch (fenetre.getResultDe()) {
            case 1:
                myGame.setCurrentCase("0101");
                str = "dans Ogon, une petite ville du royaume.";
                break;
            case 2:
                myGame.setCurrentCase("0701");
                str = "dans la campagne du royaume.";
                break;
            case 3:
                myGame.setCurrentCase("0901");
                str = "dans les ruines du Donjon de Jakor";
                break;
            case 4:
                myGame.setCurrentCase("1301");
                str = "dans la campagne du royaume.";
                break;
            case 5:
                myGame.setCurrentCase("1501");
                str = "dans Weshor, une petite ville du royaume.";
                break;
            case 6:
                myGame.setCurrentCase("1901");
                str = "dans les montagnes du royaume.";

        }
        fenetre.setStory("La première journée ...\n" +
                        "Alors que le pauvre Ogab fait face à la colère des gardes royaux \n" +
                        "vous vous trouvez " +
                        str + "\n\n" +
                        "À l'aube, vous poussez les chariots marchands dans un fossé, \n" +
                        "époussetez vos vêtements, vérifiez votre épée et \n" +
                        "vous vous préparez à affronter le premier jour de votre aventure !");

        //retourne la HEX sur laquelle on se positionne
        return Init.GetTypeTerrain(myGame.getCurrentCase().AbsOrd, monTerrain, mesMonum, mesRoutes);
    }


    //Ferme
    public void e009(game myGame, Fenetre maFenetre){

        maFenetre.setStory(maFenetre.getStory() + "\nVous apercevez une petite ferme devant vous. " +
                "\nVous pouvez la contourner, mais cela consommera le reste\n" +
                "de la journée, mettant fin à tout voyage pour aujourd'hui. \n" +
                "Sinon, vous pouvez y aller. Si vous choisissez d'approcher\n" +
                "la ferme, vous devez décider d'en faire une approche amicale,\n" +
                "ou une attaque.\n" +
                "Qu'allez vous faire ??");

        String reponse = maFenetre.aChoisi("Contourner", "Approcher amicalement", "Attaquer");

        if(reponse.equals("Attaquer"))
        {
            //RAID
            maFenetre.setStory(maFenetre.getStory() + "\nLe fermier et sa famille sont tués rapidement, \n" +
                    "aucun combat n'est nécéssaire, mais comme ils \n" +
                    "était pauvres et affamés, ni nourriture,\n" +
                    "ni pièce d'or ne sont gagnées.\n");
        }
        else if(reponse.equals("Contourner")){
            //DETOUR : fin du tour
        }
        else if (reponse.equals("Approcher amicalement")){
            //FRIENDLY APPROACH
            maFenetre.setStory(maFenetre.getStory() + "\nLe fermier a eu une récolte ruinée, sa famille est maintenant affamée.\n" +
                    "Il demande la charité, vous lui donnez alors 5 unités de nourriture. \n" +
                    "Si vous n'avez pas 5 unités de nourriture, il n'y a pas d'événement" +
                    "\nspécial et la rencontre se termine.\n");
            if(myGame.getFood() >= 5)
                myGame.setFood( myGame.getFood() - 5 , maFenetre);
        }
    }

    void e019(game myGame, Prince myPrince, Fenetre fenetre ){
        //You encounter a hermit monk meditating in the wilderness,
        // with combat skill 3, endurance 6, wealth 0. He seems to be ignoring you.
        // You can select one of the options below;

        fenetre.setStory(fenetre.getStory() +"\nVous rencontrez un moine hermite qui médite.\n" +
                "Il possède une compétence de combat de 3, une endurance de 6, mais aucune richesse.\n" +
                "Il feint de vous ignorer…\n" +
                "Vous pouvez l'ignorer ou alors discuter avec lui ou l'attaquer !");
        NewCharacter hermitMonk =
                new NewCharacter("Domi, le moine méditant",
                        10, 2, 25, 3, 3,1);

        String reponse = fenetre.aChoisi("Laisser passer", "Discuter", "Attaquer");

        if (reponse.equals("Laisser passer")){
            //Fin du tour
            fenetre.setStory(fenetre.getStory() + "\nVous avez superbement ignoré le moine");
        }
        else if (reponse.equals("Discuter")){
            //talk
            r337(myGame, hermitMonk, fenetre);
        }
        else if (reponse.equals("Attaquer")){
            //fight!
            r301(myGame, myPrince, hermitMonk, fenetre);
        }
    }

    void e023(game myGame, Prince myPrince, Fenetre fenetre ){
        //You meet a Wizard with combat skill 4, endurance 4, and wealth 60.
        // The wizard seems old, but still active and perhaps quite powerful.

        fenetre.setStory(fenetre.getStory() +"\nVous rencontrez un vieux sorcier.\n" +
                "Il possède une compétence de combat de 5, une endurance de 4, et 60 pièces d\n'or.\n" +
                "Il semble faible et âgé mais surement encore puissant…\n" +
                "Vous pouvez négocier votre passage, discuter avec lui ou l'attaquer !");
        NewCharacter wizard =
                new NewCharacter("Jean-Vincent le sorcier",
                        10, 1, 60, 4, 4,1);

        String reponse = fenetre.aChoisi("Négocier", "Discuter", "Attaquer");

        if (reponse.equals("Laisser passer")){
            //Fin du tour
            r322(myGame, myPrince, fenetre, wizard, 10);
        }
        else if (reponse.equals("Discuter")){
            //talk
            r337(myGame, wizard, fenetre);
        }
        else if (reponse.equals("Attaquer")){
            //fight!
            r301(myGame, myPrince, wizard, fenetre);
        }
    }


    //LAW ENFORCEMENTS OFFICERS
    void e050(game myGame, Prince myPrince, Fenetre fenetre ){
        /*You encounter local law enforcements officers.
        First roll one die to see if they are mounted,
        a 5 or higher roll means they are. Next roll one die to see how many you encounter,
        add one (+1) to the roll if they are mounted, add three (+3) to the roll if they are on foot.
        Each constable is combat skill 5, endurance 4, wealth 4.
        Now select your option, and roll the die. Add two (+2) to the die roll if you have
        visited the nearest town, castle, or temple before and did not leave it by an escape (r218).
        If you escaped, you cannot add two because you are undoubtedly a "wanted" man. If you have never
        visited the nearest town/ castle/temple before, you can add one (+1) to the die roll.
         */

        //ont ils une monture ?
        int mount = util.de.randomDie();
        if (mount>=5)
            mount=2;
        else mount=1;
        //combien sont-ils ?
        int nbAgents = util.de.randomDie();
        if (mount>1)
            nbAgents++;
        else nbAgents+=3;

        fenetre.setStory(fenetre.getStory() + "\n Voici des agents des forces de l\'ordre.\n" +
                "Ils sont " + nbAgents);
        if (mount>1)
            {fenetre.setStory(fenetre.getStory() + "sur leur monture");}
        fenetre.setStory(fenetre.getStory() + "\n Chacun d'eux a une force d'attaque de 5,\n" +
                "une endurance de 4 et une richesse de 4\n"
                + "Souhaitez vous tenter de négocier ? de fuir ? les attaquer ?");

        NewCharacter lawOfficers =
                new NewCharacter("les agents des forces de l\'ordre",
                2, mount, 4, 4, 5, nbAgents);


        String reponse = fenetre.aChoisi("Négocier", "Fuir", "Attaquer");

        if (reponse.equals("Négocier")){
            r322(myGame, myPrince, fenetre, lawOfficers, 10);
        }
        else if (reponse.equals("Fuir")){
            r311(myGame, fenetre);
        }
        else if (reponse.equals("Attaquer")){
            //fight!
            r301(myGame, myPrince, lawOfficers, fenetre);
        }
    }

    //PRÊTRE
    public void r231(game myGame, Prince myPrince, Fenetre fenetre){
        fenetre.setStory(fenetre.getStory() +"\nVous rencontrez un prêtre du coin monté sur un âne avec\n" +
                "une compétence de combat de 3, une endurance de 3, une richesse de 25.\n" +
                "Il semble distant et peu disposé à la conversation, mais il peut avoir peur\n" +
                "de vous...\n" +
                "Vous pouvez le laisser passer, et donc mettre fin à cette rencontre,\n " +
                "ou alors discuter avec lui ou l'attaquer !");
        NewCharacter donkeyPriest =
                new NewCharacter("Jose, le prêtre à l'âne",
                        10, 2, 25, 3, 3,1);

        String reponse = fenetre.aChoisi("Laisser passer", "Discuter", "Attaquer");

        if (reponse.equals("Laisser passer")){
            //Fin du tour
            fenetre.setStory(fenetre.getStory() + "\nVous l'avez laissé passer");
        }
        else if (reponse.equals("Discuter")){
            //talk
            r337(myGame, donkeyPriest, fenetre);
        }
        else if (reponse.equals("Attaquer")){
            //fight!
            r301(myGame, myPrince, donkeyPriest, fenetre);
        }


    }

    //CHEVALIER
    public void r232(game myGame, Prince myPrince, Fenetre fenetre){
        fenetre.setStory(fenetre.getStory() +"\nVous rencontrez un chevalier. Il est monté sur un cheval \n" +
                "avec la compétence de combat 6, l'endurance 6, et la richesse 7.\n" +
                "Assis là sur son cheval, il est intéressé pour rejoindre votre suite. " +
                "\nVous pouvez l'esquiver, et donc mettre fin à cette rencontre,\n" +
                "ou alors discuter avec lui ou l'attaquer !");
        NewCharacter swordsman =
                new NewCharacter("Brutus le chevalier",
                        3, 10, 2, 7, 6,1);

        String reponse = fenetre.aChoisi("Esquiver", "Discuter", "Attaquer");

        if (reponse.equals("Esquiver")){
            //Fin du tour
            fenetre.setStory(fenetre.getStory() +"\nVous avez fui, espèce de lâche !");
        }
        else if (reponse.equals("Discuter")){
            //talk
            r337(myGame, swordsman, fenetre);
        }
        else if (reponse.equals("Attaquer")){
            //fight!
            r301(myGame, myPrince, swordsman, fenetre);
        }
    }

    public void r233(game myGame, Prince myPrince, Fenetre fenetre){
        fenetre.setStory(fenetre.getStory() +"\nVous rencontrez un marchand amical. \n" +
                "\nVous pouvez le laisser passer, et donc mettre fin à cette rencontre, \n" +
                "ou alors discuter avec lui.");

        String reponse = fenetre.aChoisi("Laisser Passer", "Discuter", "");

        if (reponse.equals("Laisser Passer")){
            //Fin du tour
            fenetre.setStory(fenetre.getStory() +"\nPrudence…");
        }
        else if (reponse.equals("Discuter")){
            if(myGame.getGold() <= 50) {
                fenetre.setStory(fenetre.getStory() +"\nVous êtes trop pauvre pour acheter quoi que ce soit !");}
            else {
                fenetre.setStory(fenetre.getStory() +"\nLe marchand a un pégase à vendre, 50 pièces d'or.\n" +
                "Voulez vous l'acheter ?");
                String achatPegasus = fenetre.aRepondu();

                if(achatPegasus.equals("Oui")){
                    myPrince.setMount(3);
                    myGame.setGold( myGame.getGold() - 50, fenetre);
                    fenetre.setStory(fenetre.getStory() +"\nVous montez maintenant un pégase !");
                }

                else fenetre.setStory(fenetre.getStory() +"\nJe suis trop viril pour monter un pégase !");
            }
        }
    }

    public void r234(game myGame, Prince myPrince, Fenetre fenetre){
        //Simplifié avec juste l'event e032 Ghosts
        //A group of ghosts surprise you in combat (r220),
        // roll one die and add one (+1) for the number of ghosts,
        // each of which is combat value 4, endurance 2.
        fenetre.setStory(fenetre.getStory() +"\nUn groupe de fantômes vous attaque par surprise !");
        int nbGhosts = fenetre.aLancerDe(1) + 1;

        fenetre.setStory(fenetre.getStory() +"\nUn groupe de " + nbGhosts + " fantômes vous attaque par surprise !\n" +
        "Chacun d'eux à une valeur de combat de 4 et un valeur d'endurence de 2");

        NewCharacter GhostsBand =
                new NewCharacter("Terrible Ghosts",
                         0, 1, 0,
                        2, 4, nbGhosts);
        //fight !
        this.r301(myGame, myPrince, GhostsBand, fenetre);
    }

    public void r236(game myGame, Prince myPrince, Fenetre fenetre){
        int jete = util.de.randomDie();
        switch (jete) {
            case 1:
                e009(myGame, fenetre);
                break;
            case 2:
                e009(myGame,fenetre);
                break;
            case 3:
                e050(myGame, myPrince, fenetre);
                break;
            case 4:
                r231(myGame, myPrince, fenetre);
                break;
            case 5:
                e019(myGame, myPrince, fenetre);
                break;
            case 6:
                e023(myGame, myPrince, fenetre);
                break;
            default:break;
        }


    }


    //COMBAT
    public void r301(game myGame, Prince myPrince, NewCharacter adversaire, Fenetre fenetre){
        //FIGHT
        // Récupération des indices de combat
        Integer combP = myPrince.getCombat();
        Integer combA = adversaire.getCombat();
        Integer endP = myPrince.getEndurance();
        Integer endA = adversaire.getEndurance();

        fenetre.setStory(fenetre.getStory() +"\nTenez-vous prêt, le combat commence !");
        fenetre.setStory(fenetre.getStory() +"\nVous avez " + combP + " points de combat et votre adversaire en a " + combA + " !");
        fenetre.setStory(fenetre.getStory() +"\nVous avez " + endP + " points d'endurance et votre adversaire en a " + endA + " !");

        Boolean tourJoueur = true;
        while ((endP > 0) && (endA > 0)){
            if (endP <= 0) {
                fenetre.setStory(fenetre.getStory() +"\nVOUS ÊTES MORT ! GAME OVER");
                myGame.setStatus(false);

            }
            if (endA <=0) {
                fenetre.setStory(fenetre.getStory() +"\nVOUS AVEZ GAGNÉ ! Quel guerrier !");
                myGame.setGold( myGame.getGold() + adversaire.getWealth(), fenetre); //On récupère l'or du personnage tué
            }

            if (tourJoueur){
                int de = fenetre.aLancerDe(2);
                Integer diff = dommagesCombat(combP - combA + de);
                fenetre.setStory(fenetre.getStory() +"\nVous infligez " + diff + " de point(s) de dégat à votre adversaire.");
                adversaire.setEndurance(endA - diff);
                tourJoueur = false;
            } else {
                int de = util.de.randomDice();
                Integer diff = dommagesCombat(combA - combP + de);
                fenetre.setStory(fenetre.getStory() +"\nL'adversaire vous inflige " + diff + " de point(s) de dégat.");
                myPrince.setEndurance(endP - diff);
                tourJoueur = true;
            }

            fenetre.setStory(fenetre.getStory() +"\nVous : " + endP + ", Lui : " + endA );
        }
    }

    //A SUPPRIMER ?? ////////
    /*public void r301a(game myGame, Prince myPrince, NewCharacter adversaires, Fenetre fenetre){
        //FIGHT BAND
        fenetre.setStory(fenetre.getStory() + "\nChanceux ! Combat non codé ;)");
    }*/

    //FUIR
    public void r311(game myGame, Fenetre fenetre){
        //Your party escapes to an adjacent hex (r218 : intégré directement dans cette règle) .
        fenetre.setStory(fenetre.getStory() + "\nVotre troupe s’enfuit discrètement vers une case adjacente");
       /* r218 : When your party escapes, you move randomly to one of the six adjacent hexes.
       Roll one die to determine which direction to go:
       1-N, 2-NE, 3-SE, 4-S, 5-SW, 6-NW.
       Your party is now in that hex for the rest of the day.
       No new event occurs because you have entered that hex, but any events
       still pending must be determined, and after all event effects are resolved,
       you must eat for the day (r215).*/

       int jete = util.de.randomDie();
        switch (jete) {
            case 1:
                //N
                break;
            case 2:
                //NE
                break;
            case 3:
                //SE
                break;
            case 4:
                //S
                break;
            case 5:
                //SW
                break;
            case 6:
                //NW
                break;
            default:break;
        }

           }


    //NEGOCIER
    public void r322(game myGame, Prince myPrince, Fenetre fenetre, NewCharacter adversaire, Integer amount){
        /*Characters encountered have a nasty look, but if you pay the amount of gold
        indicated they will pass your party and the event will end.
        Otherwise, go to r330 and prepare to battle.
         */

        if (myGame.getGold()<amount){
            fenetre.setStory(fenetre.getStory() + "\nVous être trop fauchés pour négocier votre Altesse");
            r301(myGame, myPrince, adversaire, fenetre);
        }

        else {
            fenetre.setStory(fenetre.getStory() + "\nVoulez-vous graisser la pate de votre rencontre " +
                    "pour passer votre chemin tranquille ?\n" +
                    amount + " pièces d'or sont réclamées");

            String reponse = fenetre.aChoisi("Oui", "Non", "");

            //oui
            if (reponse.equals("Oui"))
                myGame.setGold(myGame.getGold() - amount, fenetre);
            else
                //non
                r301(myGame, myPrince, adversaire, fenetre);
        }

    }

    //DISCUTER ET CONVAINCRE UN PERSONNAGE DE SE JOINDRE À LA SUITE
    public void r337(game myGame, NewCharacter encounter, Fenetre fenetre){
        fenetre.setStory(fenetre.getStory() + "\n" + encounter.getName() + " à l'air douteux.\n" +
                "Vous essayez quand-même de le convaincre de rejoindre votre suite ...");


        int jete = fenetre.aLancerDe(1);

        if(jete <= 3){
            //le personnage se joint
            fenetre.setStory(fenetre.getStory() + "\n" + encounter.getName()+ " rejoint votre suite !");
            myGame.AddCharacter(encounter, fenetre);

            String suite = "";
            for (int i = 0; i < myGame.getSuite().size() ; i++){
                if(!suite.equals("")){
                    suite = suite + ", ";
                }
                suite = suite + myGame.getSuite().get(i).getName();
            }
            fenetre.setSuite(suite);
        }
        else
            fenetre.setStory(fenetre.getStory() + "\n" + encounter.getName() + " refuse votre offre.");

    }

    Integer dommagesCombat(Integer combat){
        Integer dmg;
        switch (combat){
            case -1 :
                dmg = 1;
                break;
            case 3 :
                dmg = 1;
                break;
            case 8 :
                dmg = 1;
                break;
            case 10 :
                dmg = 2;
                break;
            case 11 :
                dmg = 1;
                break;
            case 12 :
                dmg = 2;
                break;
            case 13 :
                dmg = 2;
                break;
            case 14 :
                dmg = 3;
                break;
            case 16 :
                dmg = 5;
                break;
            case 17 :
                dmg = 2;
                break;
            case 18 :
                dmg = - 5;
                break;
            case 19 :
                dmg = - 5;
                break;
            case 20 :
                dmg = - 6;
                break;
            default:
                dmg = 0;
                break;
        }

        return dmg;
    }
}