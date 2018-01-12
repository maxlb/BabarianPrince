import Personnages.Prince;

import java.util.Scanner;

class main {

    public static void main(String[] args) {
        Fenetre maFenetre = new Fenetre(0,50);

        // Initialisation du jeu
        Prince myPrince = new Prince();
        game myGame = new game(myPrince);

        Hex caseActuelle = new Hex("0000");

        //Quelle case pour demarrer ?
        Boolean a = true;

        while(a){
            Boolean b = maFenetre.Begin;
            System.out.print("");
            if(b){
                caseActuelle = happen.e001(myGame, maFenetre.Loc.getText());
                a = false;
                myGame.setStatus(true);
            }
        }

        // JEU
        while (myGame.getStatus(myPrince)) //tant que le jeu est en cours
        {
            maFenetre.Nourri.setText(myGame.getFood().toString());
            maFenetre.Quete.setText(myGame.getTimeTrack().toString());
            maFenetre.Typo.setText(caseActuelle.getType(caseActuelle.type));
            if(caseActuelle.monument != null){
                maFenetre.Monu.setText(caseActuelle.getMonum(caseActuelle.monument));
            } else {
                maFenetre.Monu.setText(caseActuelle.getMonum(8));
            }

            //TOUR

            //EVENT : se passe-t-il quelque chose sur cette case ?

            caseActuelle.Event(myGame, myPrince, maFenetre);

            //où suis-je ? terrain ? monument ? route ?
            //Hex caseActuelle = Init.GetTypeTerrain(myGame.getCurrentCase(), monTerrain, mesMonum, mesRoutes);

            //After all events (if any) are resolved for your daily action,
            // you must then eat your main (evening) meal, as described in the food rules (r215),
            // and if in a town, castle, or temple hex, you must also purchase lodging (r217).

            //FOOD
            //calcul du besoin de nourriture
            int foodneed = myGame.FoodNeed(caseActuelle);

            //FOOD-hunting
            myGame.FoodHunt(myPrince, caseActuelle, maFenetre);

            //FOOD-purchase meal
            myGame.FoodPurchase(caseActuelle, foodneed, maFenetre);

            //Est-on sur une case où on peut manger ??
            myGame.Food(caseActuelle, myPrince, foodneed, maFenetre);

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
            myGame.setTimeTrack(myGame.getTimeTrack()-1, maFenetre);

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