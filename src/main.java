import Personnages.Prince;

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
            Boolean b = maFenetre.getBegin();
            if(b){
                caseActuelle = happen.e001(myGame, maFenetre);
                a = false;
                myGame.setStatus(true);
            }
        }

        // JEU
        while (myGame.getStatus(myPrince)) //tant que le jeu est en cours
        {
            maFenetre.setPortage(myGame.getSuiteLoad().toString());
            maFenetre.setOr(myGame.getGold().toString());
            maFenetre.setNourri(myGame.getFood().toString());
            maFenetre.setQuete(myGame.getTimeTrack().toString());
            maFenetre.setTypo(caseActuelle.getType(caseActuelle.type));
            maFenetre.setRoute(caseActuelle.getRoad());
            maFenetre.setVie(myPrince.getEndurance().toString());
            maFenetre.setPoids(myPrince.getWealth().toString());
            String suite = "";
            for (int i = 0; i < myGame.getSuite().size(); i++) {
                if (!suite.equals("")) {
                    suite = suite + ", ";
                }
                suite = suite + myGame.getSuite().get(i).getName();
            }
            maFenetre.setSuite(suite);

            if (tour1Fini) {
                String newCase = maFenetre.estDeplace();
                caseActuelle = Init.GetTypeTerrain(newCase, happen.monTerrain, happen.mesMonum, happen.mesRoutes);
                maFenetre.setStory("Nouvelle journée ! \n");
            }
            if (caseActuelle.monument != null) {
                maFenetre.setMonu(caseActuelle.getMonum(caseActuelle.monument));
            } else {
                maFenetre.setMonu(caseActuelle.getMonum(8));
            }

            //TOUR

            //EVENT : se passe-t-il quelque chose sur cette case ?
            caseActuelle.Event(myGame, myPrince, maFenetre);

            /*After all events (if any) are resolved for your daily action,
             you must then eat your main (evening) meal, as described in the food rules (r215),
            and if in a town, castle, or temple hex, you must also purchase lodging (r217).*/

            // Si pas mort au cours d'un combat
            if (myGame.getStatus(myPrince)) {
                //FOOD
                //calcul du besoin de nourriture
                Integer foodneed = myGame.FoodNeed(caseActuelle);
                maFenetre.setStory(maFenetre.getStory() + "\nVotre groupe à besoin de " + foodneed.toString() + " unité(s) de nourriture aujourd'hui.");

                //FOOD-hunting
                myGame.FoodHunt(myPrince, caseActuelle, maFenetre);

                // Si pas mort à la chasse
                if (myGame.getStatus(myPrince)) {
                    //FOOD-purchase meal
                    myGame.FoodPurchase(caseActuelle, foodneed, maFenetre, myPrince);

                    //Est-on sur une case où on peut manger ??
                    myGame.Food(caseActuelle, myPrince, foodneed, maFenetre);

                    myGame.PurchaseLodging(caseActuelle, maFenetre, myPrince);

                    //CHECK DU POIDS
                    myGame.CheckLoads(maFenetre, myPrince);

                    //DAILY ACTION : REST OR TRAVEL
                    myGame.DailyAction(maFenetre, tour1Fini, myPrince);


                    //FIN DE TOUR
                    myGame.setTimeTrack(myGame.getTimeTrack() - 1, maFenetre);
                    maFenetre.setStory(maFenetre.getStory() + "\nFin de la journée, profitez de la nuit pour dormir.");
                    maFenetre.setStory(maFenetre.getStory() + "\nPour démarrer une nouvelle journée, selectionnez la directions \nque vous souhaitez prendre.");
                    if (!tour1Fini) {
                        tour1Fini = true;
                    }
                }
            }
        }

        if(myGame.getTimeTrack() <= 0){
            //TEMPS ÉPUISÉ
            maFenetre.setStory(maFenetre.getStory() + "\nLe temps imparti est épuisé. Vous avez perdu.");
        }

    }

}