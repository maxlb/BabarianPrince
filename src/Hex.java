import util.de;
import Personnages.Prince;

public class Hex {
    //Paramètres
    /*
    Open CountrySide :  code 1
    FarmLand :          code 2
    Forest :            code 3
    Hills :             code 4
    Mountains :         code 5
    Desert :            code 6
    Swamp :             code 7  */

    Integer event;      //indice du score minimal pour lancer un event
    Boolean hunt;       // droit util chasser
    Boolean fodder;     // droit util manger
    Integer road;       //route sur cette case si 0 : non, si 1 : route
    Integer type;       // typologie du terrain
    Integer monument;   // id du monument

    String AbsOrd;      // id de la case

    // Constructor
    public Hex(String loc)
    {
        this.AbsOrd = loc;
        this.road= 0;
    }

    //EVENEMENT
    public void Event(game myGame, Prince myPrince){
        if(de.randomDice() > this.event){
            System.out.println("Il se passe quelque chose!");
            int typologie = this.type;

            switch (typologie) {
                case 1:
                    EventCountrySide(myGame, myPrince);
                    break;
                case 2:
                    EventFarmLand(myGame, myPrince);
                    break;
                case 3:
                    EventForest(myGame, myPrince);
                    break;
                case 4:
                    EventHills(myGame, myPrince);
                    break;
                case 5:
                    EventMountains(myGame, myPrince);
                    break;
                case 6:
                    EventDesert(myGame, myPrince);
                    break;
                case 7:
                    EventSwamp(myGame, myPrince);
                default:break;
            }
        }
        else System.out.println("Pas de rencontre aujourd'hui");
    }

    public void EventCountrySide(game myGame, Prince myPrince){
            happen whathappen = new happen();
            int jete = de.randomDie(); //lancer de dé pour déterminer l'événement

            switch (jete) {
                case 1:
                    whathappen.e009(myGame);
                    break;
                case 2:
                    whathappen.r231(myGame, myPrince);
                    break;
                case 3:
                    whathappen.r232(myGame, myPrince);
                    break;
                case 4:
                    whathappen.r233(myGame, myPrince);
                    break;
                case 5:
                    whathappen.r234(myGame);
                    break;
                case 6:
                    whathappen.r235(myGame, myPrince);
                    break;

                default:break;
            }
        }

    public void EventFarmLand(game myGame, Prince myPrince){
        happen whathappen = new happen();
        int jete = de.randomDie(); //lancer de dé pour déterminer l'événement

        switch (jete) {
            case 1:
                whathappen.e009(myGame);
                break;
            case 2:
                whathappen.r231(myGame, myPrince);
                break;
            case 3:
                whathappen.r232(myGame, myPrince);
                break;
            case 4:
                whathappen.r233(myGame, myPrince);
                break;
            case 5:
                whathappen.r234(myGame);
                break;
            case 6:
                whathappen.r235(myGame, myPrince);
                break;

            default:break;
        }
    }

    public void EventForest(game myGame, Prince myPrince){
        happen whathappen = new happen();
        int jete = de.randomDie(); //lancer de dé pour déterminer l'événement

        switch (jete) {
            case 1:
                whathappen.e009(myGame);
                break;
            case 2:
                whathappen.r231(myGame, myPrince);
                break;
            case 3:
                whathappen.r232(myGame, myPrince);
                break;
            case 4:
                whathappen.r233(myGame, myPrince);
                break;
            case 5:
                whathappen.r234(myGame);
                break;
            case 6:
                whathappen.r235(myGame, myPrince);
                break;

            default:break;
        }
    }

    public void EventHills(game myGame, Prince myPrince){
        happen whathappen = new happen();
        int jete = de.randomDie(); //lancer de dé pour déterminer l'événement

        switch (jete) {
            case 1:
                whathappen.e009(myGame);
                break;
            case 2:
                whathappen.r231(myGame, myPrince);
                break;
            case 3:
                whathappen.r232(myGame, myPrince);
                break;
            case 4:
                whathappen.r233(myGame, myPrince);
                break;
            case 5:
                whathappen.r234(myGame);
                break;
            case 6:
                whathappen.r235(myGame, myPrince);
                break;

            default:break;
        }
    }

    public void EventMountains(game myGame, Prince myPrince){
        happen whathappen = new happen();
        int jete = de.randomDie(); //lancer de dé pour déterminer l'événement

        switch (jete) {
            case 1:
                whathappen.e009(myGame);
                break;
            case 2:
                whathappen.r231(myGame, myPrince);
                break;
            case 3:
                whathappen.r232(myGame, myPrince);
                break;
            case 4:
                whathappen.r233(myGame, myPrince);
                break;
            case 5:
                whathappen.r234(myGame);
                break;
            case 6:
                whathappen.r235(myGame, myPrince);
                break;

            default:break;
        }
    }

    public void EventDesert(game myGame, Prince myPrince){
        happen whathappen = new happen();
        int jete = de.randomDie(); //lancer de dé pour déterminer l'événement

        switch (jete) {
            case 1:
                whathappen.e009(myGame);
                break;
            case 2:
                whathappen.r231(myGame, myPrince);
                break;
            case 3:
                whathappen.r232(myGame, myPrince);
                break;
            case 4:
                whathappen.r233(myGame, myPrince);
                break;
            case 5:
                whathappen.r234(myGame);
                break;
            case 6:
                whathappen.r235(myGame, myPrince);
                break;

            default:break;
        }
    }

    public void EventSwamp(game myGame, Prince myPrince){
        happen whathappen = new happen();
        int jete = de.randomDie(); //lancer de dé pour déterminer l'événement

        switch (jete) {
            case 1:
                whathappen.e009(myGame);
                break;
            case 2:
                whathappen.r231(myGame, myPrince);
                break;
            case 3:
                whathappen.r232(myGame, myPrince);
                break;
            case 4:
                whathappen.r233(myGame, myPrince);
                break;
            case 5:
                whathappen.r234(myGame);
                break;
            case 6:
                whathappen.r235(myGame, myPrince);
                break;

            default:break;
        }
    }
}