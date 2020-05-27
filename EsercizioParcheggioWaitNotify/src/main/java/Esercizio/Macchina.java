package Esercizio;

class Macchina extends Thread {
    
    private Parcheggio p; //parcheggio
    
    public Macchina(String nome, Parcheggio p) { //costruttore
        super(nome);
        this.p = p;
        start();
    }
    
    public void run() {
        while (true) {
            try { 
                sleep((int)(Math.random() * 20000)); //guida prima del parcheggio
            } catch (InterruptedException e) {e.printStackTrace();} synchronized(p){
                p.entra();
                System.out.println(getName() + " è entrata. Posti liberi:" + p.postiDisponibili);
            }
            try { sleep((int)(Math.random() * 10000)); //tempo di parcheggio
            } catch (InterruptedException e) {e.printStackTrace();} synchronized(p){
                p.esce();
                System.out.println(getName() + " è uscita. Posti liberi:" + p.postiDisponibili);
            }
        }
    }
}
