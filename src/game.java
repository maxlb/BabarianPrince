import Personnages.NewCharacter;
import Personnages.Character;
import Personnages.Prince;
import util.de;

import java.util.ArrayList;
import java.util.Scanner;

public class game {
    //Parameters
    private Integer timeTrack;
    private Integer Gold;
    private Integer Food; //unités de nourriture disponible
    private Integer Endurance; //vie
    private Integer TotalLoad; //total de la charge à porter
    private Boolean Status; //true : jeu en cours / False : game over
    private String currentCase; //case actuelle du jeu
    private ArrayList<NewCharacter> suite = new ArrayList<NewCharacter>(); //Liste des personnages présents dans la suite du prince
    private Integer suiteLoad; //capacité de portage de la suite
    private Integer suiteFood; //besoin en nourriture de la suite du Prince

    //Constructors
    // Au début du jeu, il reste 70 tours, on a 2 pièces d'or (donc 1 load à porter)
    public game(Prince myPrince){
        this.timeTrack = 70;
        this.Gold = 2;
        this.Food = 5;
        this.Endurance = myPrince.getEndurance();
        this.TotalLoad = 1;
        this.Status = true;
        this.suite.add(myPrince); //le premier membre de la suite est le Prince lui-même !
        this.suiteLoad = 10;
        this.suiteFood = 1;
    }


    //Gold

    public Integer getGold() {
        return Gold;
    }
    public void setGold(Integer gold) {
        Gold = gold;
    }

    //Food
    public Integer getFood() {
        return Food;
    }
    public void setFood(Integer food) {
        Food = food;
    }

    // Total Load : chaque point Food vaut 1, 100 pièces ou moins vaut 1
    public Integer getTotalLoad(){
        int goldLoad = this.Gold/100;
        if(this.Gold==0)
            this.TotalLoad= this.Food;
        else
            this.TotalLoad= this.Food + goldLoad;
        return TotalLoad;
    }

    //Status
    // Le jeu est terminé si
    // Le temps est écoulé : timeTrack <= 0
    // Le prince a récolté 50 pièces d'or : Gold >=500
    // L'endurance du prince est épuisée :
    public Boolean getStatus() {
        if (this.timeTrack<=0 || this.Gold>=500 || this.Endurance<=0)
            this.Status=false;
        else
            this.Status=true;
        return Status;
    }

    public void setStatus(Boolean status) {
        Status = status;
    }

    //TimeTrack

    public Integer getTimeTrack() {
        return timeTrack;
    }

    public void setTimeTrack(Integer timeTrack) {
        this.timeTrack = timeTrack;
    }

    //Current Case

    public String getCurrentCase() {
        return currentCase;
    }

    public void setCurrentCase(String currentCase) {
        this.currentCase = currentCase;
    }



    //SUITE DU PRINCE (TROUPE)

    public ArrayList getSuite(){
        return suite;
        }

    public void setSuite(NewCharacter newCharacter){
        //ajout d'un personnage dans la suite du prince
        this.suite.add(newCharacter);
    }

    public Integer getSuiteLoad(){
        // à calculer en fonction de la suite
        return suiteLoad;
    }

    public void setSuiteLoad(Integer newLoad){
        this.suiteLoad= newLoad;
    }

    public Integer getSuiteFood() {
        suiteFood = this.suite.size(); //1 unité par personne
        return suiteFood;
    }

    public void setSuiteFood(Integer suiteFood) {
        this.suiteFood = suiteFood;
    }


    //AJOUT D'UN PERSONNAGE DANS LA SUITE
    public void AddCharacter(NewCharacter newCharacter){

        this.setSuite(newCharacter);

        this.setGold( this.getGold() + newCharacter.getWealth());
        this.setSuiteLoad( this.getSuiteLoad() + newCharacter.getLoads() ) ;


        if (newCharacter.getMount()==1)
            this.setSuiteFood( this.getSuiteFood() + 1);
        else
            this.setSuiteFood( this.getSuiteFood() +2);
    }

    //SUPPRESSION D'UN PERSONNAGE DANS LA SUITE
    public void DeleteCharacter(NewCharacter perso){

        this.suite.remove(perso);

        this.setSuiteLoad( this.getSuiteLoad() - perso.getLoads() );

        if (perso.getMount()==1)
            this.setSuiteFood( this.getSuiteFood() - 1);
        else
            this.setSuiteFood( this.getSuiteFood() - 2);
    }




    /*
    FOOD
    Calcul en besoin de nourriture par tour
    1 food unit par personne (avec ou sans monture) (règle simplifiée)
    si dans le desert sans oasis 2 food unit par personne
    calcul du besoin en nourriture
    */

    public Integer FoodNeed(Hex macase){
        int foodneed = 0;
        if(macase.type==6 && macase.monument!=5)
            foodneed = this.suiteFood*2;
            else
            foodneed = this.suiteFood;
    System.out.println("Available food: " + this.getFood());
    System.out.println("Food need for you and your party: " + foodneed);
    return foodneed;
    }


    //FOOD-HUNT
    public void FoodHunt(Personnages.Prince myPrince, Hex currentCase) {

        int newHunt = 0;
        //peut on chasser sur ce type de terrain ?
        if (currentCase.type != null
                && (currentCase.type == 2 || currentCase.type == 1 || currentCase.type == 3 || currentCase.type == 4 || currentCase.type == 7))
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Are you in the mood for hunting ? Type \"Y\" for Yes, \"N\" for No");
            String chasse = sc.nextLine();

            if (chasse.equals("Y") || chasse.equals("y"))
            {
                newHunt = myPrince.Hunt();
                this.Endurance = myPrince.getEndurance();

                if (newHunt == -1)
                    { //le Prince est tué dans la chasse => perdu
                    this.Endurance = 0;
                    this.setStatus(false);
                    System.out.println("YOU DIE ! \n GAME OVER");
                }
                else {
                    this.setFood(this.getFood() + newHunt);
                    System.out.println("You hunted " + newHunt + " food unit(s)");
                }
            }
        }
    }


    //FOOD-PURCHASE
    public void FoodPurchase(Hex currentCase, int foodneed){

        /*
        if you are in a town, castle, or village
        you can purchase food for each character in your party.
        Normal cost is 1 gold piece per character for food that day.
        Animals cost 1 gold piece per day to feed at the stables of the town/castle/village.
        If you don't purchase food, you must eat stores, as hunting is prohibited in these hexes.
        */

        if(currentCase.monument!= null && (currentCase.monument==4 || currentCase.monument==3) ) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Do you want to purchase food? Type Y for Yes, N for No");
            String achat = sc.nextLine();

            if(achat.equals("Y") || achat.equals("y"))
            {
                if(this.getGold()>=foodneed){ //si le Prince a assez d'argent
                    this.setGold(this.getGold() - foodneed);
                    this.setFood( this.getFood() + foodneed);
                    System.out.println("You bought " + foodneed + " food unit(s)\n"+
                    "You now have " + this.getGold() + " gold unit and " + this.Food + " food unit");
                }
                else
                    System.out.println("You're so broke my highness! You can't buy food");
            }
        }
    }//fin de food-purchase

    //FOOD : se nourrir
    public void Food(Hex currentCase, Prince myPrince, int foodneed){
        if(currentCase.fodder) {
            if (this.getFood() >= foodneed) { //il y a assez de nourriture pour tous
                this.setFood(this.getFood() - foodneed);
                myPrince.Feed();
                //!!!! à rajouter le festin de la troupe (boucle)
            } else myPrince.Starve(); //!!!! à rajouter la famine de la troupe (boucle)
        }
    }//fin de la méthode Food

    /*
    PURCHASE LODGING (if in a town, castle, or temple hex)
    Each room costs one gold piece for the night. You require a single room.
    All other followers can share, two per room.
    If you decide to not purchase rooms (due to lack of funds,
    or a desire to save money), you must roll one die for each
    character in your party.
    If the total is "5" or more, the character deserts - he refuses to serve such
    a penurious leader!
    */

    public void PurchaseLodging(Hex currentCase){
        if(currentCase.monument!= null
                && (currentCase.monument==4 || currentCase.monument==3 || currentCase.monument==1 )){
            int cost = 1 + ((suite.size()-1)/2); //1 chambre pour le prince + 1 chambre pour 2 pour le reste de la suite

            if(this.Gold>=cost) //il y a assez d'argent pour loger toute la suite
            {
                System.out.println("Would you purchase lodging for you and your party\n"+
                "Type Y for Yes, N for No");
                Scanner sc = new Scanner(System.in);
                String lodging = sc.nextLine();

                if (lodging.equals("Y") || lodging.equals("y"))//YES PURCHASE
                {
                    this.setGold( this.getGold() - cost);
                    System.out.println("All your party is sleeping well. Thank you your Highness!");
                }

                else // NO DO NOT PURCHASE
                {
                    System.out.println("You greeeeedy!");

                    //jet de dé pour chaque perso de la suite pour voir s'il déserte
                    for (int i =0 ; i < this.suite.size(); i++){
                        int jete = de.randomDie();
                        if (jete>=5)
                        {
                            //le personnage déserte
                            this.DeleteCharacter(this.suite.get(i));
                            System.out.println( this.suite.get(i).getName() + "refuses to serve such\n" +
                                    "    // a penurious leader! He deserts");
                        }

                    }
                }
            }

            else { //il n'y a pas assez d'argent pour loger la suite
                System.out.println("You're so broke your Highness !");

                //jet de dé pour chaque perso de la suite pour voir s'il déserte
                for (int i =0 ; i < this.suite.size(); i++){
                    int jete = de.randomDie();
                    if (jete>=5)
                    {
                        //le personnage déserte
                        this.DeleteCharacter(this.suite.get(i));
                        System.out.println( this.suite.get(i).getName() + "refuses to serve such\n" +
                                "    // a penurious leader! He deserts");
                    }

                }
            }

        }

    }


}












