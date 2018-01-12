import java.util.Map;
import java.util.Scanner;

import Personnages.Prince;
import Personnages.SoloChar;
import util.de;

public class happen {


    public static Hex e001(game myGame){

        System.out.println("\n\nWELCOME TO \"BARBARIAN PRINCE\"!!!\n" +
                "____________________________________\n\n"+
                "Evil events have overtaken your Northlands Kingdom. Your father, \n" +
                "the old king, is dead - assassinated by rivals to the throne. \n" +
                "These usurpers now hold the palace with their mercenary royal guard.\n" +
                "You have escaped, and must collect 500 GOLD PIECES to raise a force to smash them \n" +
                "and retake your heritage. Furthermore, the usurpers have powerful friends overseas. \n" +
                "If you can't return to take them out in 70 DAYS, their allies will arm\n" +
                "and you will lose your kingdom forever.\n"+
                "To escape the mercenary and royal guard, your loyal body servant \n" +
                "Ogab smuggled you into a merchant caravan to the southern border. \n");


        //quelle case pour démarrer
        int jete = de.randomDie();
        myGame.setCurrentCase("null");
        switch (jete) {
            case 1:
                myGame.setCurrentCase("0101");
                System.out.println("You are now in Ogon, small town in the CountrySide…");
                break;
            case 2:
                myGame.setCurrentCase("0701");
                System.out.println("You are now in the middle of the CountrySide…");
                break;
            case 3:
                myGame.setCurrentCase("0901");
                System.out.println("You are now in the moutains, in the Ruins of Jakor\'s Keep…");
                break;
            case 4:
                myGame.setCurrentCase("1301");
                System.out.println("You are now in the middle of the CountrySide…");
                break;
            case 5:
                myGame.setCurrentCase("1501");
                System.out.println("You are now in Weshor, small town in the Farmland…");
                break;
            case 6:
                myGame.setCurrentCase("1901");
                System.out.println("You are now in the mountains…");

        }

        Map<String, Integer> monTerrain = Init.InitTypeTerrain(); //initialise les topologies de terrain de chaque case
        Map<String, Integer> mesMonum = Init.InitMonument(); //initialise la position des monuments
        Map<String, Integer> mesRoutes = Init.InitRoute(); //initialise la position des routes

        //retourne la HEX sur laquelle on se positionne
        return Init.GetTypeTerrain(myGame.getCurrentCase(), monTerrain, mesMonum, mesRoutes);

    }


    public void e009(game myGame){

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
                myGame.setFood( myGame.getFood() - 5 );
        }
    }

    public void r231(game myGame){
        System.out.println("You encounter a local Priest riding on a donkey\n" +
                "with combat skill 3, " +
                "endurance 3, wealth 25. He seems aloof and not disposed \n" +
                "to conversation, but he may be afraid of you . . . You can let him pass,\n " +
                "ending this encounter, or select one of the two options below:\n" +
                "Type P for Pass, T for Talk or F for Fight!");
        SoloChar donkeyPriest =
                new SoloChar("Jose the donkey priest",
                        2, 10, 2, 25, 3,3);
        Scanner sc = new Scanner(System.in);
        String reponse = sc.nextLine();

        if (reponse.equals("p") || reponse.equals("P")){
            //Fin du tour
            System.out.println("You let him pass");
        }
        else if (reponse.equals("t") || reponse.equals("T")){
            //talk
            r337(myGame, donkeyPriest);
        }
        else if (reponse.equals("f") || reponse.equals("F")){
            //fight!
            r301(myGame);
        }


    }
    public void r232(game myGame){
        System.out.println("You meet a swordsman adventurer.\n " +
                "He is mounted on a horse with combat skill 6, \n" +
                "endurance 6, and wealth 7. Sitting there on his horse\n" +
                " he takes an active interest in your party. Your options are:\n" +
                "Talk (type t), evade (type e) or fight (type f)");
        SoloChar swordsman =
                new SoloChar("Brutus the swodsman adventurer",
                        3, 10, 2, 7, 6,6);
        Scanner sc = new Scanner(System.in);
        String reponse = sc.nextLine();

        if (reponse.equals("e") || reponse.equals("E")){
            //Fin du tour
            System.out.println("You evade, you coward!");
        }
        else if (reponse.equals("t") || reponse.equals("T")){
            //talk
            r337(myGame, swordsman);
        }
        else if (reponse.equals("f") || reponse.equals("F")){
            //fight!
            r301(myGame);
        }
    }

    public void r233(game myGame, Prince myPrince){
        System.out.println("You meet a friendly merchant.\n " +
                "You can either pass by and ignore him, ending this encounter,\n " +
                "or you can stop to chat and barter." +
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
                "Do you buy it ?\n" +
                "Yes (type Y), No (type N)");
                String achatPegasus = sc.nextLine();

                if(achatPegasus.equals("Y") || achatPegasus.equals("y")){
                    myPrince.setMount(3);
                    myGame.setGold( myGame.getGold() - 50);
                    System.out.println("You now ride a pegasus !");
                }

                else System.out.println("I'm too manly to ride a pegasus!");


            }

            }
        }



    public void r234(game myGame){
        //
    }

    public void r235(game myGame){
        //
    }

    public void r301(game myGame){
        //FIGHT
    }
    public void r337(game myGame, SoloChar encounter){
        System.out.println(encounter.getName() + " encountered look unsavory, " +
                "but willing to talk - you try to convince them to join " +
                "your party…");
        int jete = de.randomDie();

        if(jete<=3){
            //le personnage se joint
            System.out.println(encounter.getName()+ " is joining your party!");
            myGame.AddCharacter(encounter);
        }
        else
            System.out.println(encounter.getName() + " turn down your offer.");

    }


}