/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/
class Patient{
    private double masse, hauteur;

    public void init(double masse, double hauteur){
        if (masse >= 0) { 
            this.masse = masse;
        } else {
            this.masse = 0;
        }
        if (hauteur >= 0) {
            this.hauteur = hauteur;
        } else {
            this.hauteur = 0;
        }
    }

    public double poids() { return this.masse; }
    public double taille() { return this.hauteur; }

    public void afficher(){
        double masse, hauteur;
        if ( this.masse == 0 || this.hauteur == 0 ) { 
            masse = hauteur = 0;
        } else {
            masse = this.masse;
            hauteur = this.hauteur;
        }
        System.out.printf("Patient: %.1f kg pour %.1f m\n", masse, hauteur);
    }

    public double imc(){
        if (this.hauteur == 0) {
            return 0;
        } else {
            return (poids() / Math.pow(taille(), 2));
        }
    }

}


/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/
class Imc {
    public static void main(String[] args) {

        Patient quidam = new Patient();
        quidam.init(74.5, 1.75);
        quidam.afficher();
        System.out.println("IMC : " + quidam.imc());
        quidam.init( -2.0, 4.5);
        quidam.afficher();
    }
}
