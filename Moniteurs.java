//package MyProdConsV1;

// Programme principal
public class Moniteurs {

    public static void main(String[] args) {
        // Taille du stockage
        int tailleStockage = 5;
        // Nombre d'itérations
        int nbIterations = 10;

        // Création d'un stockage de taille donnée
        Stockage stockage = new Stockage(tailleStockage);

        // Création des threads producteurs et consommateurs
        Thread producteur1 = new Thread(new Producteur(stockage, nbIterations), "Producteur 1");
        Thread producteur2 = new Thread(new Producteur(stockage, nbIterations), "Producteur 2");
        Thread consommateur1 = new Thread(new Consommateur(stockage, nbIterations), "Consommateur 1");
        Thread consommateur2 = new Thread(new Consommateur(stockage, nbIterations), "Consommateur 2");

        // Démarrage des threads
        producteur1.start();
        producteur2.start();
        consommateur1.start();
        consommateur2.start();
    }
}
