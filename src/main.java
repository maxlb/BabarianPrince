import java.util.Map;

class main {
    public static void main(String[] args) {

        // Initialisation du jeu
        game myGame = new game();

        //Quelle case pour démarrer ?
        int jete = de.randomDie();

        String loc = null;
        switch (jete) {
            case 1:
                loc = "0101";
                break;
            case 2:
                loc = "0701";
                break;
            case 3:
                loc = "0801";
                break;
            case 4:
                loc = "1301";
                break;
            case 5:
                loc = "1501";
                break;
            case 6:
                loc = "1801";
        }

        Map<String, Integer> monTerrain = Init.InitTypeTerrain();
        Map<String, Integer> mesMonum = Init.InitMonument();
        Map<String, Integer> mesRoutes = Init.InitRoute();

        // JEU

        while (myGame.getStatus()) //tant que le jeu est en cours
        {
            //TOUR
            Hex caseActuelle = Init.GetTypeTerrain(loc, monTerrain, mesMonum, mesRoutes);

            //LE TOUR EST PASSE
            myGame.setTimeTrack(myGame.getTimeTrack()-1);
        }


    }


}