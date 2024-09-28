//package MyProdConsV1;

import java.util.Random;

// Classe Consommateur qui implémente Runnable
class Consommateur implements Runnable {
    private final Stockage stockage;
    private final int nbIterations;
    private final Random random = new Random();

    public Consommateur(Stockage s, int nbIterations) {
        this.stockage = s;
        this.nbIterations = nbIterations;
    }

    public void run() {
        try {
            for (int i = 0; i < nbIterations; i++) {
                // Consomme un objet du stockage
                Object item = stockage.consommer();

                // Ralentit la consommation pour observer la synchronisation
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}