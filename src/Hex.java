import util.de;
import Personnages.Prince;

public class Hex {

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
        this.setAbsOrd(loc);
        //valeurs par défaut
        this.event = 0;
        this.hunt = true;
        this.fodder = true;
        this.type = 1;
        this.monument = 0;
        this.road= 0;
    }

    public String getRoad(){
        String str = "Aucune route";
        if(this.road == 1){
            str= "Sur une route";
        }
        return str;
    }

    public String getMonum(int tp){
        String str = "";
        switch(tp){
            case 1:
                    str = "Temple";
                break;
            case 2:
                str = "Ruins";
                break;
            case 3:
                str = "Castle";
                break;
            case 4:
                str = "Town";
                break;
            case 5:
                str = "Oasis";
                break;
            default:
                str = "Aucun Monument";
                break;
        }
        return str;
    }

    public String getType(int tp){
        String str = "";
        switch(tp){
            case 1:
                str = "Campagne";
                break;
            case 2:
                str = "Champs";
                break;
            case 3:
                str = "Forêt";
                break;
            case 4:
                str = "Collines";
                break;
            case 5:
                str = "Montagnes";
                break;
            case 6:
                str = "Désert";
                break;
            case 7:
                str = "Marais";
            default:
                break;
        }
        return str;
    }

    public String getAbsOrd() { return AbsOrd; }

    public void setAbsOrd(String absOrd) { this.AbsOrd = absOrd; }


    //EVENEMENT

    public void Event(game myGame, Prince myPrince, Fenetre fenetre){
        if(de.randomDice() > this.event){
            fenetre.setStory(fenetre.getStory() + "\nUHOH ! Il y a quelqu'un ici !");
            int typologie = this.type;

            switch (typologie) {
                case 1:
                    EventCountrySide(myGame, myPrince,fenetre);
                    break;
                case 2:
                    EventFarmLand(myGame, myPrince,fenetre);
                    break;
                case 3:
                    EventForest(myGame, myPrince,fenetre);
                    break;
                case 4:
                    EventHills(myGame, myPrince,fenetre);
                    break;
                case 5:
                    EventMountains(myGame, myPrince,fenetre);
                    break;
                case 6:
                    EventDesert(myGame, myPrince,fenetre);
                    break;
                case 7:
                    EventSwamp(myGame, myPrince,fenetre);
                default:break;
            }
        }

        else fenetre.setStory(fenetre.getStory() + "\n Il n'y a pas âme qui vive par ici.");

    }

    public void EventCountrySide(game myGame, Prince myPrince, Fenetre fenetre){
            happen whathappen = new happen();

            int jete = fenetre.aLancerDe(1); //lancer de dé pour déterminer l'événement

            switch (jete) {
                case 1:
                    whathappen.r232(myGame, myPrince, fenetre);
                    break;
                case 2:
                    whathappen.r236(myGame, myPrince,fenetre);
                    break;
                case 3:
                    whathappen.r232(myGame, myPrince, fenetre);
                    break;
                case 4:
                    whathappen.r233(myGame, myPrince, fenetre);
                    break;
                case 5:
                    whathappen.r234(myGame, myPrince, fenetre);
                    break;
                case 6:
                    whathappen.r231(myGame, myPrince, fenetre);
                    break;

                default:break;
            }
        }

    public void EventFarmLand(game myGame, Prince myPrince, Fenetre fenetre){
        happen whathappen = new happen();
        int jete = fenetre.aLancerDe(1); //lancer de dé pour déterminer l'événement

        switch (jete) {
            case 1:
                whathappen.e009(myGame,fenetre);
                break;
            case 2:
                whathappen.r231(myGame, myPrince, fenetre);
                break;
            case 3:
                whathappen.r232(myGame, myPrince, fenetre);
                break;
            case 4:
                whathappen.r233(myGame, myPrince, fenetre);
                break;
            case 5:
                whathappen.r234(myGame, myPrince, fenetre);
                break;
            case 6:
                whathappen.r232(myGame, myPrince, fenetre);
                break;

            default:break;
        }
    }

    public void EventForest(game myGame, Prince myPrince, Fenetre fenetre){
        happen whathappen = new happen();
        int jete = fenetre.aLancerDe(1); //lancer de dé pour déterminer l'événement

        switch (jete) {
            case 1:
                whathappen.e009(myGame,fenetre);
                break;
            case 2:
                whathappen.r231(myGame, myPrince, fenetre);
                break;
            case 3:
                whathappen.r232(myGame, myPrince, fenetre);
                break;
            case 4:
                whathappen.r233(myGame, myPrince, fenetre);
                break;
            case 5:
                whathappen.r234(myGame, myPrince, fenetre);
                break;
            case 6:
                whathappen.r231(myGame, myPrince, fenetre);
                break;

            default:break;
        }
    }

    public void EventHills(game myGame, Prince myPrince, Fenetre fenetre){
        happen whathappen = new happen();
        int jete = fenetre.aLancerDe(1); //lancer de dé pour déterminer l'événement

        switch (jete) {
            case 1:
                whathappen.e009(myGame, fenetre);
                break;
            case 2:
                whathappen.r231(myGame, myPrince, fenetre);
                break;
            case 3:
                whathappen.r232(myGame, myPrince, fenetre);
                break;
            case 4:
                whathappen.r233(myGame, myPrince, fenetre);
                break;
            case 5:
                whathappen.r234(myGame, myPrince, fenetre);
                break;
            case 6:
                whathappen.r232(myGame, myPrince, fenetre);
                break;

            default:break;
        }
    }

    public void EventMountains(game myGame, Prince myPrince, Fenetre fenetre){
        happen whathappen = new happen();
        int jete = fenetre.aLancerDe(1); //lancer de dé pour déterminer l'événement

        switch (jete) {
            case 1:
                whathappen.e009(myGame, fenetre);
                break;
            case 2:
                whathappen.r231(myGame, myPrince, fenetre);
                break;
            case 3:
                whathappen.r232(myGame, myPrince, fenetre);
                break;
            case 4:
                whathappen.r233(myGame, myPrince, fenetre);
                break;
            case 5:
                whathappen.r234(myGame, myPrince, fenetre);
                break;
            case 6:
                whathappen.r231(myGame, myPrince, fenetre);
                break;

            default:break;
        }
    }

    public void EventDesert(game myGame, Prince myPrince, Fenetre fenetre){
        happen whathappen = new happen();
        int jete = fenetre.aLancerDe(1); //lancer de dé pour déterminer l'événement

        switch (jete) {
            case 1:
                whathappen.e009(myGame, fenetre);
                break;
            case 2:
                whathappen.r231(myGame, myPrince, fenetre);
                break;
            case 3:
                whathappen.r232(myGame, myPrince, fenetre);
                break;
            case 4:
                whathappen.r233(myGame, myPrince, fenetre);
                break;
            case 5:
                whathappen.r234(myGame, myPrince, fenetre);
                break;
            case 6:
                whathappen.r232(myGame, myPrince, fenetre);
                break;

            default:break;
        }
    }

    public void EventSwamp(game myGame, Prince myPrince, Fenetre fenetre){
        happen whathappen = new happen();
        int jete = fenetre.aLancerDe(1); //lancer de dé pour déterminer l'événement

        switch (jete) {
            case 1:
                whathappen.e009(myGame,fenetre);
                break;
            case 2:
                whathappen.r231(myGame, myPrince, fenetre);
                break;
            case 3:
                whathappen.r232(myGame, myPrince, fenetre);
                break;
            case 4:
                whathappen.r233(myGame, myPrince, fenetre);
                break;
            case 5:
                whathappen.r234(myGame, myPrince, fenetre);
                break;
            case 6:
                whathappen.r231(myGame, myPrince, fenetre);
                break;

            default:break;
        }
    }

    }



