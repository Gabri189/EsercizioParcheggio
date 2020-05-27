package Esercizio;

import java.util.concurrent.Semaphore;

public class Parcheggio {
    private int postiDisponibili; //variabile condivisa: numero posti totali disponibili
    private Semaphore s;
    
    public Parcheggio(int postiDisponibili) { //costruttore
        this.postiDisponibili = postiDisponibili;
        s = new Semaphore(postiDisponibili);
    }
    
    public int getPostiDisponibili(){ //get per il numero di posti totali
        return postiDisponibili;
    }

    public Semaphore getS() { //get per il semaphore
        return s;
    }
    
    public synchronized void start(){ //metodo sincronizzato start
        while(postiDisponibili == 0){
            try{
                s.acquire();
            }catch(InterruptedException ex)
            {
                ex.printStackTrace();
            }
        }
        postiDisponibili--;
    }
    
    public synchronized void end(){ //metodo sincronizzato end
        postiDisponibili++;
        s.release();
    }
}
