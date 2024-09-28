//package MyProdConsV1;

import java.util.Random;
// Classe Producteur qui implémente Runnable
class Producteur implements Runnable {
    private final Stockage stockage;
    private final int nbIterations;
    private final Random random = new Random();

    public Producteur(Stockage s, int nbIterations) {
        this.stockage = s;
        this.nbIterations = nbIterations;
    }

    public void run() {
        try {
            for (int i = 0; i < nbIterations; i++) {
                // Crée un objet produit (ici un entier aléatoire)
                Object item = random.nextInt(100);
                stockage.produire(item);

                // Ralentit la production pour observer la synchronisation
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}