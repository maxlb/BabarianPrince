import Personnages.Prince;

import java.util.Scanner;

class main {

    public static void main(String[] args) {
        Fenetre maFenetre = new Fenetre(0,50);

        // Initialisation du jeu
        Prince myPrince = new Prince();
        game myGame = new game(myPrince);

        //Quelle case pour demarrer ?
        Hex caseActuelle = happen.e001(myGame, maFenetre.Loc.getText());

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
            //calcul du besoin de nourriture
            int foodneed = myGame.FoodNeed(caseActuelle);

            //FOOD-hunting
            myGame.FoodHunt(myPrince, caseActuelle);

            //FOOD-purchase meal
            myGame.FoodPurchase(caseActuelle, foodneed);

            //Est-on sur une case où on peut manger ??
            myGame.Food(caseActuelle, myPrince, foodneed);

            //PURCHASE LODGING (if in a town, castle, or temple hex)
            myGame.PurchaseLodging(caseActuelle);

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