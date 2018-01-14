import java.util.Map;
import java.util.Scanner;

import Personnages.Prince;
import Personnages.NewCharacter;
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
        return Init.GetTypeTerrain(myGame.getCurrentCase().AbsOrd, monTerrain, mesMonum, mesRoutes);
    }

    public void e009(game myGame, Fenetre maFenetre){

        System.out.println("You spot a small farm ahead. You may detour around it,\n" +
                "but that will consume the rest of the day, ending all travel\n" +
                "for today. Alternately, you can go up to it. If you approach\n" +
                "the farm, you must decide whether to make it a friendly approach,\n" +
                "or a raid.\n"+
                "What are you going to do ??\n"+
                "Type D for detour, F for friendly or R for raid !");
        Scanner sc = new Scanner(System.in);
        String reponse = sc.nextLine();

        if(reponse.equals("r") || reponse.equals("R"))
        {
            //RAID
            System.out.println("farmer and his family are quickly killed, \n" +
                    "no combat is necessary, but you find he was poor and starving,\n " +
                    "no food or money are gained.\n");
        }
        else if(reponse.equals("D") || reponse.equals("d")){
            //DETOUR : fin du tour
        }
        else if (reponse.equals("f") || reponse.equals("F")){
            //FRIENDLY APPROACH
            System.out.println("farmer had a ruined harvest, his family is now starving.\n " +
                    "He begs the charity of 5 food units from you. If you don't have 5 food units,\n " +
                    "there is no special event and the encounter ends.\n");
            if(myGame.getFood()>=5)
                myGame.setFood( myGame.getFood() - 5 , maFenetre);
        }
    }

    public void r231(game myGame, Prince myPrince, Fenetre fenetre){
        System.out.println("You encounter a local Priest riding on a donkey\n" +
                "with combat skill 3, " +
                "endurance 3, wealth 25. He seems aloof and not disposed \n" +
                "to conversation, but he may be afraid of you . . . You can let him pass,\n " +
                "ending this encounter, or select one of the two options below:\n" +
                "Type P for Pass, T for Talk or F for Fight!");
        NewCharacter donkeyPriest =
                new NewCharacter("Jose the donkey priest",
                        2, 10, 2, 25, 3,3);
        Scanner sc = new Scanner(System.in);
        String reponse = sc.nextLine();

        if (reponse.equals("p") || reponse.equals("P")){
            //Fin du tour
            System.out.println("You let him pass");
        }
        else if (reponse.equals("t") || reponse.equals("T")){
            //talk
            r337(myGame, donkeyPriest, fenetre);
        }
        else if (reponse.equals("f") || reponse.equals("F")){
            //fight!
            r301(myGame, myPrince, donkeyPriest);
        }


    }

    public void r232(game myGame, Prince myPrince, Fenetre fenetre){
        System.out.println("You meet a swordsman adventurer.\n " +
                "He is mounted on a horse with combat skill 6, \n" +
                "endurance 6, and wealth 7. Sitting there on his horse\n" +
                " he takes an active interest in your party. Your options are:\n" +
                "Talk (type t), evade (type e) or fight (type f)");
        NewCharacter swordsman =
                new NewCharacter("Brutus the swodsman adventurer",
                        3, 10, 2, 7, 6,6);
        Scanner sc = new Scanner(System.in);
        String reponse = sc.nextLine();

        if (reponse.equals("e") || reponse.equals("E")){
            //Fin du tour
            System.out.println("You evade, you coward!");
        }
        else if (reponse.equals("t") || reponse.equals("T")){
            //talk
            r337(myGame, swordsman, fenetre);
        }
        else if (reponse.equals("f") || reponse.equals("F")){
            //fight!
            r301(myGame, myPrince, swordsman);
        }
    }

    public void r233(game myGame, Prince myPrince, Fenetre fenetre){
        System.out.println("You meet a friendly merchant.\n " +
                "You can either pass by and ignore him, ending this encounter,\n " +
                "or you can stop to chat and barter.\n" +
                "Stop (type S), Pass (Type P)\n");
        Scanner sc = new Scanner(System.in);
        String reponse = sc.nextLine();

        if (reponse.equals("p") || reponse.equals("P")){
            //Fin du tour
            System.out.println("Prudence…");
        }
        else if (reponse.equals("s") || reponse.equals("S")){
            if(myGame.getGold() <= 50) {
                System.out.println("You are too poor to buy anything your highness !");}
            else {
                System.out.println("Merchant has pegasus mount for sale, 50 gold.\n" +
                "Do you buy it ?\n");
                String achatPegasus = fenetre.aRepondu();

                if(achatPegasus.equals("Oui")){
                    myPrince.setMount(3);
                    myGame.setGold( myGame.getGold() - 50, fenetre);
                    System.out.println("You now ride a pegasus !");
                }

                else System.out.println("I'm too manly to ride a pegasus!");
            }
        }
    }

    public void r234(game myGame, Prince myPrince){
        //Simplifié avec juste l'event e032 Ghosts
        //A group of ghosts surprise you in combat (r220),
        // roll one die and add one (+1) for the number of ghosts,
        // each of which is combat value 4, endurance 2.

        int nbGhosts = de.randomDie() +1;
        System.out.println(" A group of " + nbGhosts + " ghosts surprise you in combat\n" +
        "each of which is combat value 4, endurance 2");

        NewCharacter GhostsBand =
                new NewCharacter("Terrible Ghosts",
                         0, 1, 0,
                        2, 4, nbGhosts);
        //fight !
        this.r301a(myGame, myPrince, GhostsBand);
    }

    public void r235(game myGame){
        //
    }

    public void r301(game myGame, Prince myPrince, NewCharacter adversaire){
        //FIGHT SOLO CHARACTER
    }

    public void r301a(game myGame, Prince myPrince, NewCharacter adversaires){
        //FIGHT BAND
    }

    public void r337(game myGame, NewCharacter encounter, Fenetre fenetre){
        System.out.println(encounter.getName() + " encountered look unsavory, " +
                "but willing to talk - you try to convince them to join " +
                "your party…");
        int jete = de.randomDie();

        if(jete<=3){
            //le personnage se joint
            System.out.println(encounter.getName()+ " is joining your party!");
            myGame.AddCharacter(encounter, fenetre);
        }
        else
            System.out.println(encounter.getName() + " turn down your offer.");

    }


}