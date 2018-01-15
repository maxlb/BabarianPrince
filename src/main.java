import Personnages.Prince;
import Personnages.SoloChar;

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
        Boolean tour1Fini = false;

        while(a){
            Boolean b = maFenetre.Begin;
            System.out.print("");
            if(b){
                caseActuelle = happen.e001(myGame, maFenetre);
                a = false;
                myGame.setStatus(true);
            }
        }

        // JEU
        while (myGame.getStatus(myPrince)) //tant que le jeu est en cours
        {
            maFenetre.Portage.setText(myGame.getSuiteLoad().toString());
            maFenetre.Or.setText(myGame.getGold().toString());
            maFenetre.Nourri.setText(myGame.getFood().toString());
            maFenetre.Quete.setText(myGame.getTimeTrack().toString());
            maFenetre.Non.setEnabled(false);
            maFenetre.Oui.setEnabled(false);


            if(tour1Fini){
                String newCase = maFenetre.estDeplace();
                caseActuelle = Init.GetTypeTerrain(newCase, happen.monTerrain, happen.mesMonum, happen.mesRoutes);
                maFenetre.Story.setText("Nouvelle journée ! \n");
            }
            maFenetre.Typo.setText(caseActuelle.getType(caseActuelle.type));
            maFenetre.Route.setText(caseActuelle.getRoad());
            if(caseActuelle.monument != null){
                maFenetre.Monu.setText(caseActuelle.getMonum(caseActuelle.monument));
            } else {
                maFenetre.Monu.setText(caseActuelle.getMonum(8));
            }

            //TOUR

            //EVENT : se passe-t-il quelque chose sur cette case ?
            caseActuelle.Event(myGame, myPrince, maFenetre);

            //After all events (if any) are resolved for your daily action,
            // you must then eat your main (evening) meal, as described in the food rules (r215),
            // and if in a town, castle, or temple hex, you must also purchase lodging (r217).

            //FOOD
            //calcul du besoin de nourriture
            Integer foodneed = myGame.FoodNeed(caseActuelle);
            maFenetre.setStory(maFenetre.getStory()+"\nVotre groupe à besoin de "+ foodneed.toString() +" unité(s) de nourriture.");

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

            maFenetre.setStory(maFenetre.getStory() + "\nFin de la journée, profitez de la nuit pour dormir.");
            maFenetre.setStory(maFenetre.getStory() + "\nPour démarrer une nouvelle journée, selectionnez la directions \nque vous souhaitez prendre.");
            if(!tour1Fini){
                tour1Fini = true;
            }
        }

        //TEMPS ÉPUISÉ
        maFenetre.setStory(maFenetre.getStory() + "\nLe temps imparti est épuisé. Vous avez perdu.");
    }

}