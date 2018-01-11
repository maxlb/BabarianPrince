import java.awt.*;
import javax.swing.JPanel;



public class Panneau extends JPanel {

    public Panneau(int x, int y) {
        this.x = x;
        this.y = y;
    }

    final static int cote=24; // Ceci définit la taille du côté d'un polygone
    Polygon pol;
    int x;
    int y;

    public void paint(Graphics arg0) {

        Polygon p2 = getPolygon(0, 0, cote); // Crée un hexagone
        Rectangle r = p2.getBounds(); // Récupère le plus petit rectangle // aux bord de la fenêtre dans lequel l'hexagone peut s'inscrire
        arg0.setColor(Color.black);
        super.paint(arg0);
        Graphics2D g2d;


        g2d = (Graphics2D) arg0;
        g2d.rotate(Math.toRadians(90));
        g2d.translate(0,cote * (-30));
        BasicStroke epaisseur = new BasicStroke(1);// Permet de fixer l'épaisseur du trait dans la suite
        g2d.setStroke(epaisseur);
        int i = 1;
        Polygon[][] Coord = new Polygon[23][20];


        for(int l=1;l<20;l=l+2){// Remarquer le "+2" car la grille est constituée de 2 sous grilles (les lignes impaires sont décallées)
            for(int c=0;c<23;c++){
                Polygon poly=getPolygon(c*r.width, (int)(l*cote*1.5),cote);
                pol = poly;
                System.out.println(19-l);
                if(19-l == y && c == x) {
                    g2d.setColor(Color.red);
                    g2d.fill(poly);
                }else {
                    g2d.draw(poly);
                }
                g2d.setColor(Color.black);
                Coord[c][19-l] = poly;
                i++;
            }
        }
        for(int l=0;l<20;l=l+2){
            for(int c=0;c<23;c++)
            {
                Polygon poly=getPolygon(c*r.width+r.width/2,  (int)(l*cote*1.5+0.5),cote);
                if(19-l == y && c == x) {
                    g2d.setColor(Color.red);
                    g2d.fill(poly);
                }else {
                    g2d.draw(poly);
                }
                g2d.setColor(Color.black);
                pol = poly;
                Coord[c][19-l]=poly;
                i++;
            }
        }
        System.out.println();
    }


    public static Polygon getPolygon(int x,int y,int cote){// Forme le polygone
        int haut=cote/2;
        int larg=(int)(cote*(Math.sqrt(3)/2));
        Polygon hex=new Polygon();
        hex.addPoint(x,y+haut);// /
        hex.addPoint(x+larg,y); // \
        hex.addPoint(x+2*larg,y+haut);// |
        hex.addPoint(x+2*larg,y+(int)(1.5*cote)); // /
        hex.addPoint(x+larg,y+2*cote);// \
        hex.addPoint(x,y+(int)(1.5*cote));// |


        return hex;
    }

     /* Polygon hex=new Polygon();
        hex.addPoint(x,y+haut);// /
        hex.addPoint(x+larg,y); // \
        hex.addPoint(x+2*larg,y+haut);// |
        hex.addPoint(x+2*larg,y+(int)(1.5*cote)); // /
        hex.addPoint(x+larg,y+2*cote);// \
        hex.addPoint(x,y+(int)(1.5*cote));// | */

}

