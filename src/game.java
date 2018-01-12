import Personnages.SoloChar;
import Personnages.Character;
import Personnages.Prince;
import java.util.ArrayList;
import java.util.Scanner;

public class game {
    //Parameters
    private Integer timeTrack;
    private Integer Gold;
    private Integer Food; //unités de nourriture disponible
    private Integer Endurance; //vie
    private Integer TotalLoad;
    private Boolean Status; //true : jeu en cours / False : game over
    private String currentCase; //case actuelle du jeu
    private ArrayList suite = new ArrayList(); //Liste des personnages présents dans la suite du prince
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
        this.Status = false;
        this.suite.add(myPrince); //le premier membre de la suite est le Prince lui-même !
        this.suiteLoad = 10;
        this.suiteFood = 1;
    }


    //Gold

    public Integer getGold() {
        return Gold;
    }
    public void setGold(Integer gold, Fenetre fenetre) {
        Gold = gold;
        fenetre.Or.setText(gold.toString());
    }

    //Food
    public Integer getFood() {
        return Food;
    }
    public void setFood(Integer food, Fenetre fenetre) {
        Food = food;
        fenetre.Nourri.setText(food.toString());
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
    public Boolean getStatus(Prince myPrince) {
        if (this.timeTrack<=0 || this.Gold>=500 || myPrince.getEndurance() <= 0)
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

    public void setTimeTrack(Integer timeTrack, Fenetre fenetre) {
        this.timeTrack = timeTrack;
        fenetre.Quete.setText(timeTrack.toString());
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

    public void setSuite(Character newCharacter){
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
    public void AddCharacter(SoloChar newCharacter, Fenetre fenetre){

        this.setGold( this.getGold() + newCharacter.getWealth(), fenetre);
        this.setSuiteLoad( this.getSuiteLoad() + newCharacter.getLoads() ) ;
        this.setSuite(newCharacter);
        if (newCharacter.getMount()==1)
            this.setSuiteFood( this.getSuiteFood() + 1);
        else
            this.setSuiteFood( this.getSuiteFood() +2);
    }





    //Calcul en besoin de nourriture par tour
    // 1 food unit par personne (avec ou sans monture) (règle simplifiée)
    // si dans le desert sans oasis 2 food unit par personne
    //calcul du besoin en nourriture

    public Integer FoodNeed(Hex macase){
        int foodneed = 0;
        if(macase.type==6 && macase.monument!=5)
            foodneed = this.suiteFood*2;
            else
            foodneed = this.suiteFood;
        return foodneed;
    }


    //FOOD-HUNT
    public void FoodHunt(Personnages.Prince myPrince, Hex currentCase, Fenetre fenetre) {

        int newHunt = 0;
        //peut on chasser sur ce type de terrain ?
        if (currentCase.type != null
                && (currentCase.type == 2 || currentCase.type == 1 || currentCase.type == 3 || currentCase.type == 4 || currentCase.type == 7))
        {
            fenetre.setStory(fenetre.getStory() + "\nÊtes-vous d'humeur à chasser ? ");
            String chasse = fenetre.aRepondu();

            if (chasse.equals("Oui"))
            {
                newHunt = myPrince.Hunt();
                this.Endurance = myPrince.getEndurance();

                if (newHunt == -1) { //le Prince est tué dans la chasse => perdu
                    this.Endurance = 0;
                    this.setStatus(false);
                    fenetre.setStory(fenetre.getStory() + "\nDommage vous êtes MORT à la chasse ! \n GAME OVER");
                } else {
                    this.setFood(this.getFood() + newHunt, fenetre);
                    fenetre.setStory(fenetre.getStory() + "\nBravo ! Vous avez récupéré " + newHunt + " unité(s) de nourriture");
                }
            }
        }
    }


    //FOOD-PURCHASE
    public void FoodPurchase(Hex currentCase, int foodneed, Fenetre fenetre){

        //if you are in a town, castle, or village
        // you can purchase food for each character in your party.
        // Normal cost is 1 gold piece per character for food that day.
        // Animals cost 1 gold piece per day to feed at the stables of the town/castle/village.
        // If you don't purchase food, you must eat stores, as hunting is prohibited in these hexes.

        if(currentCase.monument!= null && (currentCase.monument == 4 || currentCase.monument == 3) ) {
            fenetre.setStory(fenetre.getStory() + "\nVoulez vous acheter de la nourriture ?");
            String achat = fenetre.aRepondu();

            if(achat.equals("Oui"))
            {
                if(this.getGold()>=foodneed){ //si le Prince a assez d'argent
                    this.setGold(this.getGold() - foodneed, fenetre);
                    this.setFood( this.getFood() + foodneed, fenetre);
                    fenetre.setStory(fenetre.getStory() + "\nVous avez pu acheter " + foodneed + " unité(s) de nourriture.");
                }
                else
                    System.out.println("You're so broke my highness! You can't buy food");
            }
        }
    }//fin de food-purchase

    //FOOD : se nourrir
    public void Food(Hex currentCase, Prince myPrince, int foodneed, Fenetre fenetre){
        if(currentCase.fodder) {
            if (this.getFood() >= foodneed) { //il y a assez de nourriture pour tous
                this.setFood(this.getFood() - foodneed, fenetre);
                myPrince.Feed();
                fenetre.setStory(fenetre.getStory()+"\nVotre groupe mange "+ foodneed +" nourriture(s) pour survire.");
                //!!!! à rajouter le festin de la troupe (boucle)
            } else {
                myPrince.Starve(); //!!!! à rajouter la famine de la troupe (boucle)
                fenetre.setStory(fenetre.getStory()+"\nVotre groupe n'a pas assez a manger, c'est la famine !");
            }
        }
    }//fin de la méthode Food

    //PURCHASE LODGING (if in a town, castle, or temple hex)
    // Each room costs one gold piece for the night. You and any priests,
    // monks, magicians, wizards, or witches in your party each require a single room.
    // All other followers can share, two per room, if you wish.
    // If you decide to not purchase rooms (due to lack of funds,
    // or a desire to save money), you must roll two dice for each
    // character in your party, and then subtract your wit & wiles from the result.
    // If the total is "4" or more, the character deserts - he refuses to serve such
    // a penurious leader! If a mount is without stables, roll one die for each mount,
    // a 4 or higher means thieves steal the mount during the night, it is permanently lost.

    public void PurchaseLodging(Hex currentCase){
        if(currentCase.monument!= null
                && (currentCase.monument==4 || currentCase.monument==3 || currentCase.monument==1 )){



        }


    }//fin de purchase lodging






}


