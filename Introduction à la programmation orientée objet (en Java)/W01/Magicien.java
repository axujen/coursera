import java.util.Scanner;

class Papier{
    private int age, somme;

    int getAge(){ return this.age; }
    int getSomme(){ return this.somme; }

    // ecrit l'age et somme d'argent du spectateur sur une feuille
    void ecrit(int age, int somme){
        this.age = age;
        this.somme = somme;
    }
}
class Spectateur{
    private final static Scanner clavier = new Scanner(System.in);

    int getAge(){
        System.out.println("Age: ");
        int age = clavier.nextInt();
        return age;
    }

    int getSomme(){
        System.out.println("Somme: ");
        int somme = clavier.nextInt();
        return somme;
    }

    void ecrit(Papier papier){
        papier.ecrit(this.getAge(), this.getSomme());
    }
}

class Assistant{
    private int resultat;
    private Papier papier;

    // l'assistant demande au spectateur d'ecrire son age et some d'argent, verifier la somme d'argent
    void demande(Spectateur spec, Papier papier){
        System.out.println("Monsieur, est ce que tu peux ecrire ton age et la somme d'argent que tu as dans ta poche sur ce papier?");
        spec.ecrit(papier);
        while ( papier.getSomme() < 0 || papier.getSomme() > 100 ){
            System.out.println("Monsieur, la somme d'argent doit etre entre 0 100 francs!");
            spec.ecrit(papier);
        }

        while ( papier.getAge() < 0  ){
            System.out.println("Monsier, l'age doit etre positive!");
            spec.ecrit(papier);
        }

        // l'assistant garde le papier
        this.papier = papier;
    }

    // l'assistant lit le papier et fait son calcule, tout en announcant chaque etape
    void calcule(){
        int age = this.papier.getAge();
        int somme = this.papier.getSomme();

        resultat = age * 2;
        resultat = resultat + 5;
        resultat = resultat * 50;
        resultat = resultat + somme;
        resultat = resultat - 365;
        System.out.println("J'ai calcule le chiffre: " + resultat);
    }

    int getResultat(){ return resultat; }
}

class Magicien{
    // le magicien fait de la "magie"
    public static void main(String[] args){
        Spectateur spec = new Spectateur();
        Assistant assis = new Assistant();
        Papier papier   = new Papier();

        assis.demande(spec, papier);
        assis.calcule();

        char[] resultat = String.valueOf(assis.getResultat() + 115).toCharArray();
        if (resultat.length < 4){
            System.out.println("L'age est: " + resultat[0] + " La somme est: " + resultat[1] + resultat[2]);
        } else {
            System.out.println("L'age est: " + resultat[0] + resultat[1] + " La somme est: " + resultat[2] + resultat[3]);
        }
    }
}
