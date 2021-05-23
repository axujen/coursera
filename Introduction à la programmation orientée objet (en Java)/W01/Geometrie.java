import java.util.Scanner;
import java.lang.Math;

// Class definie un des 3 points dans le triangle
class Point{
    private final static Scanner clavier = new Scanner(System.in);
    private double x, y;

    double getX() { return x; }
    double getY() { return y; }

    void setCoords(){
        System.out.println("Construction d'un nouveau point");
        System.out.printf("\tVeiller entrer x: ");
        this.x = clavier.nextDouble();
        System.out.printf("\tVeiller entrer y: ");
        this.y = clavier.nextDouble();
    }
}

// class qui definie un des 3 cotes du triangle
class Cote{
    private Point p1, p2;

    void setPoints(Point p1, Point p2){
        this.p1 = p1;
        this.p2 = p2;
    }

    double getLongeur(){
        double x = Math.pow((p1.getX() - p2.getX()), 2);
        double y = Math.pow((p1.getY() - p2.getY()), 2);
        return Math.sqrt(x + y);
    }
}

// Class qui define le triangle
class Triangle{
    private Point[] points = new Point[3];
    private Cote[] cotes = new Cote[3];

    void Init(){
        setPoints();
        setCotes();
    }

    void setPoints(){
        for ( int i = 0; i <= 2; i++ ){
            points[i] = new Point();
            points[i].setCoords();
        }
    }

    void setCotes(){
        for ( int i = 0; i <= 2; i++ ){
            cotes[i] = new Cote();

            if (  i != 2 ) { 
                cotes[i].setPoints(points[i], points[i+1]);
            } else {
                cotes[i].setPoints(points[i], points[0]);
            }
        }
    }

    double getPerimetre(){
        return cotes[0].getLongeur() + cotes[1].getLongeur() + cotes[2].getLongeur();
    }

    boolean getIsocele(){
        for ( int i = 0; i <= 2; i++ ){
            for ( int o = 0; o <= 2; o++ ){
                if (i == o ) { continue; }
                if (cotes[i].getLongeur() == cotes[o].getLongeur()) { return true; }
            }
        }
        return false;
    }
}

public class Geometrie{
    public static void main(String[] args){
        Triangle triangle = new Triangle();
        triangle.Init();

        // calcule le perimetre
        System.out.printf("Le perimetre du triangle est: %f\n", triangle.getPerimetre());

        // calcule ci le triangle est isocele
        if ( triangle.getIsocele() ){
            System.out.println("Le triangle est Isocele");
        } else {
            System.out.println("Le triangle n'est pas Isocele");
        }
    }
}
