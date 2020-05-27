package Esercizio;

public class Parcheggio {
    
    public int postiDisponibili; //variabile condivisa: numero posti totali disponibili
    
    public Parcheggio(int PostiDisponibili) { //costruttore
        this.postiDisponibili = PostiDisponibili;
    }
    
    public synchronized void entra() { //entra nel parcheggio
        while (postiDisponibili == 0) {
            try {
                wait();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        postiDisponibili--;
    }
    
    public synchronized void esce() { //esce dal parcheggio
        postiDisponibili++;
        notifyAll();
    }
}
