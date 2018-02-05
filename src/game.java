import Personnages.NewCharacter;
import Personnages.Prince;
import java.util.ArrayList;

public class game {
    //Parameters
    private Integer timeTrack;
    private Integer Gold;
    private Integer Food; //unités de nourriture disponible
    private Integer TotalLoad;
    private Boolean Status; //true : jeu en cours / False : game over
    private Hex currentCase; //Case actuelle du jeu
    private ArrayList<NewCharacter> suite = new ArrayList<>(); //Liste des personnages présents dans la suite du prince
    private Integer suiteLoad; //capacité de portage de la suite
    private Integer suiteFood; //besoin en nourriture de la suite du Prince

    //Constructors
    // Au début du jeu, il reste 70 tours, on a 2 pièces d'or (donc 1 load à porter)
    public game(Prince myPrince){
        this.timeTrack = 70;
        this.Gold = 2;
        this.Food = 5;
        this.TotalLoad = 1;
        this.Status = false;
        this.currentCase = new Hex("0000");
        this.setSuite(myPrince); //le premier membre de la suite est le Prince lui-même !
        this.suiteLoad = 10;
        this.suiteFood = 1;
        this.currentCase = new Hex("0000"); // Un objet doit toujours être initialisé ;)
    }


    //Gold

    public Integer getGold() {
        return Gold;
    }
    public void setGold(Integer gold, Fenetre fenetre) {
        Gold = gold;
        fenetre.setOr(gold.toString());
    }

    //Food
    public Integer getFood() {
        return Food;
    }
    public void setFood(Integer food, Fenetre fenetre) {
        Food = food;
        fenetre.setNourri(food.toString());
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
    public void setTotalLoad(Integer totalLoad) {
        TotalLoad = totalLoad;
    }

    /*
    GAME STATUS
    Le jeu est terminé si
    Le temps est écoulé : timeTrack <= 0
    Le prince a récolté 50 pièces d'or : Gold >=500
    L'endurance du prince est épuisée : */

    public Boolean getStatus(Prince myPrince) {
        if (this.timeTrack <= 0 || this.Gold >= 500 || myPrince.getEndurance() <= 0)
            this.Status = false;
        else
            this.Status = true;
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
        fenetre.setQuete(timeTrack.toString());
    }

    //Current Case

    public Hex getCurrentCase() {
        return currentCase;
    }

    public void setCurrentCase(String loc) {
        this.currentCase.setAbsOrd(loc);
    }

    //SUITE DU PRINCE (TROUPE)

    public ArrayList<NewCharacter> getSuite(){
        return suite;
    }

    public void setSuite(NewCharacter newCharacter) {
        //ajout d'un personnage dans la suite du prince
        this.suite.add(newCharacter);
    }

    public Integer getSuiteLoad(){
        this.suiteLoad=0;
        // on additionne la capacité de portage de chaque personnage de la suite
        for (int i =0 ; i < this.suite.size(); i++){
            setSuiteLoad(this.suiteLoad + this.suite.get(i).getLoads());
        }
        return suiteLoad;
    }

    public void setSuiteLoad(Integer newLoad){
        this.suiteLoad= newLoad;
    }

    public void removeSuite(NewCharacter personnage) {
        //suppression d'un personnage dans la suite du prince
        this.suite.remove(personnage);
    }

    public Integer getSuiteFood() {
        int maFood = this.suite.size(); //une unité de food par personn

        // +1 si monture :
        for (int i =0 ; i < this.suite.size(); i++){
            if(this.suite.get(i).getMount()>1){
                maFood++;
            }
        }
        this.suiteFood = maFood;

        return suiteFood; }

    public void setSuiteFood(Integer suiteFood) {
        this.suiteFood = suiteFood;
    }


    //AJOUT D'UN PERSONNAGE DANS LA SUITE
    public void AddCharacter(NewCharacter newCharacter, Fenetre fenetre){
        this.setGold( this.getGold() + newCharacter.getWealth(), fenetre);
        this.setSuiteLoad( this.getSuiteLoad() + newCharacter.getLoads() ) ;
        this.setSuite(newCharacter);
        this.setSuiteFood(this.getSuiteFood());
    }


    //SUPPRESSION D'UN PERSONNAGE DANS LA SUITE
    public void DeleteCharacter(NewCharacter perso) {
        this.suite.remove(perso);
        this.setSuiteLoad(this.getSuiteLoad() - perso.getLoads());
        this.setSuiteFood(this.getSuiteFood());
    }

    //Calcul en besoin de nourriture par tour
    // 1 food unit par personne (avec ou sans monture) (règle simplifiée)
    // si dans le desert sans oasis 2 food unit par personne
    //calcul du besoin en nourriture

    public Integer FoodNeed(Hex macase){
        int foodneed = 0;
        if(macase.type == 6 && macase.monument != null && macase.monument != 5)
            foodneed = this.getSuiteFood()*2;
            else
            foodneed = this.getSuiteFood();
        return foodneed;
    }


    //FOOD-HUNT
    public void FoodHunt(Personnages.Prince myPrince, Hex currentCase, Fenetre fenetre) {

        int newHunt = 0;
        //peut on chasser sur ce type de terrain ?
        if (this.getStatus(myPrince)
                && (currentCase.type == 2 || currentCase.type == 1 || currentCase.type == 3 || currentCase.type == 4 || currentCase.type == 7))
        {
            fenetre.setStory(fenetre.getStory() + "\nÊtes-vous d'humeur à chasser votre Altesse ? ");
            String chasse = fenetre.aRepondu();

            if (chasse.equals("Oui"))
            {
                newHunt = myPrince.Hunt();

                if (newHunt == -1) { //le Prince est tué dans la chasse => perdu
                    this.setStatus(false);
                    fenetre.setStory(fenetre.getStory() + "\nUn sanglier sans vergogne a foncé sur vous, vous êtes mort. \n GAME OVER");
                } else {
                    this.setFood(this.getFood() + newHunt, fenetre);
                    fenetre.setStory(fenetre.getStory() + "\nBravo ! Vous avez récupéré " + newHunt + " unité(s) de nourriture");
                }
            }
        }
    }


    //FOOD-PURCHASE
    public void FoodPurchase(Hex currentCase, int foodneed, Fenetre fenetre, Prince myPrince){

        //if you are in a town, castle, or village
        // you can purchase food for each character in your party.
        // Normal cost is 1 gold piece per character for food that day.
        // Animals cost 1 gold piece per day to feed at the stables of the town/castle/village.
        // If you don't purchase food, you must eat stores, as hunting is prohibited in these hexes.

        if(this.getStatus(myPrince) && currentCase.monument!= null && (currentCase.monument == 4 || currentCase.monument == 3) ) {
            fenetre.setStory(fenetre.getStory() + " \nVoulez vous acheter de la nourriture ?");
            String achat = fenetre.aRepondu();

            if(achat.equals("Oui"))
            {
                if(this.getGold() >= foodneed){ //si le Prince a assez d'argent
                    this.setGold(this.getGold() - foodneed, fenetre);
                    this.setFood( this.getFood() + foodneed, fenetre);
                    fenetre.setStory(fenetre.getStory() + " \nVous avez pu acheter " + foodneed + " unité(s) de nourriture.");
                }
                else
                    fenetre.setStory(fenetre.getStory() + " \nVous êtes fauchés votre Altesse ! Vous ne pouvez pas acheter de nourriture pour le moment.");
            }
        }
    }//fin de food-purchase

    //FOOD : se nourrir
    public void Food(Hex currentCase, Prince myPrince, int foodneed, Fenetre fenetre){
        if(this.getStatus(myPrince) && currentCase.fodder) {
            if (this.getFood() >= foodneed) { //il y a assez de nourriture pour tous
                this.setFood(this.getFood() - foodneed, fenetre);

                for (int i =0 ; i < this.suite.size(); i++){
                    this.suite.get(i).Feed();
                }
                fenetre.setStory(fenetre.getStory()+" \nVotre groupe se restaure de "+ foodneed +" nourriture(s) pour survivre.");

            } else {
                for (int i =0 ; i < this.suite.size(); i++){
                    this.suite.get(i).Starve();
                }
                fenetre.setStory(fenetre.getStory()+" \nVotre groupe n'a pas assez a manger, c'est la famine !");
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

    public void PurchaseLodging(Hex currentCase,Fenetre fenetre, Prince myPrince) {
        if (this.getStatus(myPrince) && currentCase.monument != null
                && (currentCase.monument == 4 || currentCase.monument == 3 || currentCase.monument == 1)) {
            int cost = 1 + ((suite.size() - 1) / 2); //1 chambre pour le prince + 1 chambre pour 2 pour le reste de la suite

            if (this.Gold >= cost) //il y a assez d'argent pour loger toute la suite
            {
                fenetre.setStory(fenetre.getStory() + "\nVoulez-vous chercher un gîte pour vous et votre suite ce soir votre Altesse ?");
                String lodging = fenetre.aRepondu();

                if (lodging.equals("Oui"))//YES PURCHASE
                {
                    this.setGold(this.getGold() - cost, fenetre);
                    fenetre.setStory(fenetre.getStory() + "\nToute votre troupe va dormir ce soir dans une charmante auberge ! Merci votre Altesse !");
                } else // NO DO NOT PURCHASE
                {
                    fenetre.setStory(fenetre.getStory() + "\nVous avez des oursins dans les poches votre Altesse !");

                    //jet de dé pour chaque perso de la suite pour voir s'il déserte
                    for (int i = 0; i < this.suite.size(); i++) {
                        int jete = util.de.randomDie();
                        if (jete >= 5) {
                            //le personnage déserte
                            this.DeleteCharacter(this.suite.get(i));
                            fenetre.setStory(fenetre.getStory() + "\n" + this.suite.get(i).getName() + "refuse catégoriquement de continuer à servir un tel avare !\n" +
                                    "Il déserte !");
                        }

                    }
                }
            } else { //il n'y a pas assez d'argent pour loger la suite
                fenetre.setStory(fenetre.getStory() + "\nVous êtes fauchés comme les blés votre Altesse, pas d'auberge ce soir.");

                //jet de dé pour chaque perso de la suite pour voir s'il déserte
                for (int i = 0; i < this.suite.size(); i++) {
                    int jete = util.de.randomDie();
                    if (jete >= 5) {
                        //le personnage déserte
                        this.DeleteCharacter(this.suite.get(i));
                        fenetre.setStory(fenetre.getStory() + "\n" + this.suite.get(i).getName() + "refuse catégoriquement de continuer à servir un Prince ruiné !\n" +
                                "Il déserte !");
                    }
                }
            }
        }
    }//fin du purchaselodging

    //DAILY ACTION : REST AND TRAVEL

    public Hex DailyAction(Fenetre fenetre, Boolean tour1Fini, Prince myPrince) {
        if(this.getStatus(myPrince)){
        fenetre.setStory(fenetre.getStory() + "\nVoulez-vous rester sur cette case au prochain tour pour panser" +
                "\nvos éventuelles plaies et vous reposer ou continuer à voyager ?");
        String reponse = fenetre.aRepondu();

        if(reponse.equals("Rester"))//REST
        {   this.Rest(fenetre);
            //case inchangée
        }

        else if(reponse.equals("L'aventure n'attend pas !")){
            fenetre.setStory(fenetre.getStory() + "\nSelectionnez la direction \nque vous souhaitez prendre.");
            this.currentCase = this.Travel(fenetre);

            }
        if(!tour1Fini){
            tour1Fini = true;
        return this.currentCase;
        }

    return this.currentCase;}
        else return null;
    } //fin de DailyAction


    //REST
    public void Rest(Fenetre fenetre){
        for (int i = 0; i < this.suite.size(); i++)
            this.suite.get(i).Heal(); //chaque personnage de la suite se repose et guérit
        fenetre.setStory(fenetre.getStory() + "\nVous et votre suite vous reposez à cet endroit. Quelle charmante journée !");
    }
    //TRAVEL
    public Hex Travel(Fenetre fenetre){
        //À VÉRIFIER !!
        Hex newHex = new Hex(fenetre.estDeplace());
        return newHex;
    }

    //CHECK LOADS
    public void CheckLoads(Fenetre fenetre, Prince myPrince) {
        if(this.getStatus(myPrince)){
        int diff = this.getSuiteLoad() /*capacité de portage de la suite*/ - this.getTotalLoad()/*ce qu'il faut porter*/ ;
        while (diff < 0) {
            fenetre.setStory(fenetre.getStory() + "\n" + this.getTotalLoad() + "\n" + this.getSuiteLoad() + "\n" + diff);
            fenetre.setStory(fenetre.getStory() + "\nVotre charge est trop lourde pour vous et votre suite. Vous devez abandonner des réserves de nourriture ou de l'or");
            String abandon = fenetre.aRepondu();

            if (abandon.equals("Abandonner de la nourriture"))//FOOD
            {
                if (this.getFood() < 0) {
                    System.out.println("Pauvre fou ! Vous n'avez pas même de nourriture à abandonner");
                } else {
                    this.setFood(this.getFood() - diff, fenetre);
                    this.setTotalLoad(this.getTotalLoad());
                    System.out.println
                            ("Vous voilà allégé. Vous avez maintenant " + this.getFood() + " unité(s) de nourriture");
                }
            } else//GOLD
            {
                if (this.getGold() <= 0)
                    System.out.println("Pauvre Prince ruiné, vous n'avez pas d'or à abandonner");

                else {//de 1 à 100 pièces d'or = 1 loads
                    int goldLoad = this.Gold / 100;
                    int newGoldLoad = goldLoad - diff;
                    if (newGoldLoad <= 0)
                        this.setGold(0, fenetre);
                    else {
                        this.setGold(100 * newGoldLoad, fenetre);
                    }
                    System.out.println("Vous voilà allégé de quelques pièces. Vous avez maintenant " + this.getGold() + " pièce(s) d'or)");
                }

            }


        }
    }}



}


