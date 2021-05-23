class Cercle{
    private double rayon, x, y;

    public double getRayon(){ return this.rayon;}
    public double getX(){ return this.x;}
    public double getY(){ return this.y;}

    public void setRayon(double r){
        // le rayon doit toujours etre positive
        if (r >= 0) {
            this.rayon = r;
        } else { 
            System.out.println("Le rayon doit etre positive");
        }
    }
    public void setCentre(double x, double y){ 
        // note, en a pas besoin de forcer les coordonnes du cercle d'etre positive
        this.x = x;
        this.y = y;
    }

    public double surface(){
        return Math.PI * ( this.rayon * this.rayon );
    }

    public boolean estInterieur(double x, double y){
        boolean result = ( this.x + this.rayon >= x && this.y + this.rayon >= y );

        if (result) {
            System.out.println("les points " + x + "," + y + " sonts a l'interieur du cercle");
        } else {
            System.out.println("les points " + x + "," + y + " ne sonts pas a l'interieur du cercle");
        }

        return result;
    }
}

public class TestCercle{
    public static void main(String[] args){
        Cercle c1 = new Cercle();
        Cercle c2 = new Cercle();
        Cercle c3 = new Cercle();

        c1.setRayon(5);
        System.out.println("La surface due cercle 1 est: " + c1.surface());

        c2.setRayon(50);
        System.out.println("La surface due cercle 2 est: " + c2.surface());

        c3.setRayon(2);
        System.out.println("La surface due cercle 3 est: " + c3.surface());

        System.out.println("\n====\nTest des points a l'interieur du cercle\n");
        System.out.println("Cercle 1:");
        c1.estInterieur(0, 0);

        System.out.println("\nCercle 2:");
        c2.estInterieur(5, 2);

        System.out.println("\nCercle 3:");
        c3.estInterieur(255, 0);
    }
}
