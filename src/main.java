import Personnages.Prince;
import java.util.Scanner;

class main {
    public static void main(String[] args) {

        // Initialisation du jeu
        Prince myPrince = new Prince();
        game myGame = new game();

        //Quelle case pour demarrer ?
        happen tour1 = new happen();
        Hex caseActuelle = tour1.e001(myGame);

        // JEU
        while (myGame.getStatus()) //tant que le jeu est en cours
        {
            //TOUR

            //EVENT : se passe-t-il quelque chose sur cette case ?
            caseActuelle.Event(myGame, myPrince);


            //où suis-je ? terrain ? monument ? route ?
            //Hex caseActuelle = Init.GetTypeTerrain(myGame.getCurrentCase(), monTerrain, mesMonum, mesRoutes);

            //After all events (if any) are resolved for your daily action,
            // you must then eat your main (evening) meal, as described in the food rules (r215),
            // and if in a town, castle, or temple hex, you must also purchase lodging (r217).


            //FOOD
            int foodneed;
            foodneed = myGame.FoodNeed(caseActuelle); //calcul du besoin de nourriture
            
            System.out.println("Vous êtes sur une case de type " + caseActuelle.type);
            System.out.println("Votre reserve actuelle de nourriture = " + myGame.getFood());
            System.out.println("Votre besoin quotidien de nourriture = " + foodneed);



            //FOOD-hunting
            if(caseActuelle.type!= null && (caseActuelle.type==2 || caseActuelle.type==1 || caseActuelle.type==3 || caseActuelle.type==4 || caseActuelle.type==7))
            {
                Scanner sc = new Scanner(System.in);
                System.out.println("Voulez-vous chasser votre nourriture ? Tapez Y pour oui, N pour non");
                String chasse = sc.nextLine();

                if(chasse.equals("Y") || chasse.equals("y"))
                {
                    int newHunt = myPrince.Hunt();

                    if(newHunt==-1) { //le Prince est tué dans la chasse => perdu
                        myGame.setStatus(false);
                        System.out.println("GAME OVER");
                        break;
                    }
                    else {
                        myGame.setFood( myGame.getFood() + newHunt);
                        System.out.println("Vous avez chassé " + newHunt + " unité(s) de nourriture");
                    }
                }

            }


            //FOOD-purchase meal
            //(r215d): if you are in a town, castle, or village
            // you can purchase food for each character in your party.
            // Normal cost is 1 gold piece per character for food that day.
            // Animals cost 1 gold piece per day to feed at the stables of the town/castle/village.
            // If you don't purchase food, you must eat stores, as hunting is prohibited in these hexes.

            if(caseActuelle.monument!= null && (caseActuelle.monument==4 || caseActuelle.monument==3) ) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Voulez-vous acheter de la nourriture ? Tapez Y pour oui, N pour non");
                String achat = sc.nextLine();

                if(achat.equals("Y") || achat.equals("y"))
                {
                    if(myGame.getGold()>=foodneed){ //si le Prince a assez d'argent
                        myGame.setGold(myGame.getGold() - foodneed);
                        myGame.setFood( myGame.getFood() + foodneed);
                    }

                    else
                        System.out.println("Vous n'avez pas assez d'argent");
                }

            }

            // on a chassé, on a fait les courses, on MANGE !!

            //starvation !
            //!!!! à rajouter la famine de la troupe (boucle)
            if (myGame.getFood() >= foodneed){ //il y a assez de nourriture pour tous
                myGame.setFood(myGame.getFood() - foodneed);
                myPrince.Feed();
                //!!!! à rajouter le festin de la troupe (boucle)
            }

            else myPrince.Starve();

            //PURCHASE LODGING (if in a town, castle, or temple hex)

            //DAILY ACTION : REST OR TRAVEL

            /*System.out.println("Voulez vous rester sur cette case (Tapez R) ou changer de case (Taper T) ?");
            Scanner sc = new Scanner(System.in);
            String reponse = sc.nextLine();

                //REST : on reste sur cette case et on guérit
            if(reponse.equals("R") || reponse.equals("r")){
                //
            }


                //TRAVEL : on souhaite changer de case
            else if(reponse.equals("T") || reponse.equals("t")){
                // changement de caseActuelle
            }

            */

            //FIN DE TOUR
            myGame.setTimeTrack(myGame.getTimeTrack()-1);
            System.out.println("Jours restants : " + myGame.getTimeTrack());
            System.out.println("Fin de tour, appuyer sur une touche pour continuer");
            Scanner sc = new Scanner(System.in);
            String findetour = sc.nextLine();
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - -");



        }

        //TEMPS ÉPUISÉ
        System.out.println("Le temps imparti est épuisé. Vous avez perdu");


    }


}