//package MyProdConsV1;

class Stockage {
    private final Object[] buffer;  // Tableau d'objets à stocker
    private int count = 0;          // Compteur d'éléments dans le stockage
    private int in = 0;             // Index pour la production
    private int out = 0;            // Index pour la consommation

    public Stockage(int taille) {
        buffer = new Object[taille]; // Initialisation du stockage avec une taille donnée
    }

    // Méthode pour produire un objet
    public synchronized void produire(Object item) throws InterruptedException {
        // Si le stockage est plein, le producteur doit attendre
        while (count == buffer.length) {
            System.out.println(Thread.currentThread().getName() + " attend (stockage plein).");
            wait(); // Attente jusqu'à ce qu'un consommateur prenne un objet
        }

        // Production de l'objet
        buffer[in] = item;
        in = (in + 1) % buffer.length;
        count++;
        System.out.println(Thread.currentThread().getName() + " a produit " + item);

        // Notifie tous les threads (producteurs/consommateurs) en attente
        notifyAll();
    }

    // Méthode pour consommer un objet
    public synchronized Object consommer() throws InterruptedException {
        // Si le stockage est vide, le consommateur doit attendre
        while (count == 0) {
            System.out.println(Thread.currentThread().getName() + " attend (stockage vide).");
            wait(); // Attente jusqu'à ce qu'un producteur ajoute un objet
        }

        // Consommation de l'objet
        Object item = buffer[out];
        out = (out + 1) % buffer.length;
        count--;
        System.out.println(Thread.currentThread().getName() + " a consommé " + item);

        // Notifie tous les threads en attente
        notifyAll();
        return item;
    }
}