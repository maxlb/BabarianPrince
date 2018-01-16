import java.util.Map;
import java.util.Scanner;

import Personnages.BandChar;
import Personnages.Prince;
import Personnages.SoloChar;
import util.de;

public class happen {

    static Map<String, Integer> monTerrain = Init.InitTypeTerrain(); //initialise les topologies de terrain de chaque case
    static Map<String, Integer> mesMonum = Init.InitMonument(); //initialise la position des monuments
    static Map<String, Integer> mesRoutes = Init.InitRoute(); //initialise la position des routes

    public static Hex e001(game myGame, Fenetre fenetre){

        //quelle case pour démarrer
        myGame.setCurrentCase("null");
        String str ="";
        switch (fenetre.resultDe) {
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
                str = "dans les ruines du donjon de Jakor";
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
                        "pour rentrer à la maison, vous vous trouvez \n" +
                        str + "\n\n" +
                        "Maintenant, à l'aube, vous poussez les chariots marchands dans un fossé, \n" +
                        "époussetez vos vêtements, desserrez votre ceinture d'épée et \n" +
                        "vous vous préparez à commencer le premier jour de votre aventure !");

        //retourne la HEX sur laquelle on se positionne
        return Init.GetTypeTerrain(myGame.getCurrentCase(), monTerrain, mesMonum, mesRoutes);
    }

    public void e009(game myGame, Fenetre maFenetre){

        maFenetre.setStory(maFenetre.getStory() + "\nVous apercevez une petite ferme devant vous. " +
                "\nVous pouvez la contourner, mais cela consommera le reste\n" +
                "de la journée, mettant fin à tout voyage pour aujourd'hui. \n" +
                "Sinon, vous pouvez y aller. Si vous choisissez d'approcher\n" +
                "la ferme, vous devez décider d'en faire une approche amicale, ou une attaque.\n" +
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

    public void r231(game myGame, Prince myPrince, Fenetre fenetre){
        fenetre.setStory(fenetre.getStory() +"\nVous rencontrez un prêtre local monté sur un âne avec \n" +
                "une compétence de combat de 3, une endurance de 3, une richesse de 25. \n" +
                "Il semble distant et peu disposé à la conversation, mais il peut avoir peur de \n" +
                "vous...\n" +
                "Vous pouvez le laisser passer, et donc mettre fin à cette rencontre,\n " +
                "ou alors discuter avec lui ou l'attaquer !");
        SoloChar donkeyPriest =
                new SoloChar("Jose, le prêtre à l'âne",
                        2, 10, 2, 25, 3,3);

        String reponse = fenetre.aChoisi("Laisser passer", "Discuter", "Attaquer");

        if (reponse.equals("Laisser passer")){
            //Fin du tour
            fenetre.setStory(fenetre.getStory() + "\nVous l'avez laisser passer");
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

    public void r232(game myGame, Prince myPrince, Fenetre fenetre){
        fenetre.setStory(fenetre.getStory() +"\nVous rencontrez un chevalier. Il est monté sur un cheval \n" +
                "avec la compétence de combat 6, l'endurance 6, et la richesse 7.\n" +
                "Assis là sur son cheval, il est intéressé pour rejoindre votre suite. " +
                "\nVous pouvez l'esquiver, et donc mettre fin à cette rencontre,\n" +
                "ou alors discuter avec lui ou l'attaquer !");
        SoloChar swordsman =
                new SoloChar("Brutus le chevalier",
                        3, 10, 2, 7, 6,6);

        String reponse = fenetre.aChoisi("Esquiver", "Discuter", "Attaquer");

        if (reponse.equals("Esquiver")){
            //Fin du tour
            fenetre.setStory(fenetre.getStory() +"\nVous avez fuis, espèce de lâche !");
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
                "\nVous pouvez le laisser, et donc mettre fin à cette rencontre, \n" +
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

        int nbGhosts = fenetre.aLancerDe(1) +1;

        fenetre.setStory(fenetre.getStory() +"\nUn groupe de " + nbGhosts + " fantômes vous attaque par surprise !\n" +
        "Chacun d'eux à une valeur de comba de 4 et un valeur d'endurence de 2");

        BandChar GhostsBand =
                new BandChar("Terrible Fantôme",
                        4, 0, 1, 0,
                        2, 4, nbGhosts);
        //fight !
        this.r301a(myGame, myPrince, GhostsBand, fenetre);
    }

    public void r235(game myGame,Fenetre fenetre){
        fenetre.setStory(fenetre.getStory() +"\nChanceux, event non codé ;)");
    }

    public void r301(game myGame, Prince myPrince, SoloChar adversaire, Fenetre fenetre){
        //FIGHT SOLO CHARACTER
        fenetre.setStory(fenetre.getStory() + "\nChanceux ! Combat non codé ;)");
    }

    public void r301a(game myGame, Prince myPrince, BandChar adversaires, Fenetre fenetre){
        fenetre.setStory(fenetre.getStory() + "\nChanceux ! Combat non codé ;)");
    }

    public void r337(game myGame, SoloChar encounter, Fenetre fenetre){
        fenetre.setStory(fenetre.getStory() + "\n" + encounter.getName() + " à l'air douteux.\n" +
                "Vous essayez quand-même de le convaincre de rejoindre votre suite ...");


        int jete = fenetre.aLancerDe(1);

        if(jete <= 3){
            //le personnage se joint
            fenetre.setStory(fenetre.getStory() + "\n" + encounter.getName()+ " rejoint votre suite !");
            myGame.AddCharacter(encounter, fenetre);
        }
        else
            fenetre.setStory(fenetre.getStory() + "\n" + encounter.getName() + " refuse votre offre.");

    }


}