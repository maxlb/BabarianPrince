public class Hex {
    //Champs
    Integer event;      //indice du score minimal pour lancer un event
    Boolean hunt;       // droit de chasser
    Boolean fodder;     // droit de manger
    Integer road;       //route sur cette case si 0 : non, si 1 : route
    Integer type;       // typologie du terrain

    String AbsOrd;              // id de la case
    Integer monument;           // id du monument

    // Constructor
    public Hex(String loc)
    {
        this.AbsOrd = loc;
        this.road= 0;
    }

}
