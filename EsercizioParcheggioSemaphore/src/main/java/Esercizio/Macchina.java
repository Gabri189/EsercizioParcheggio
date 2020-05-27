package Esercizio;

public class Macchina extends Thread{
    
    private Parcheggio p;

    public Parcheggio getP() {
        return p;
    }

    public Macchina(String nome, Parcheggio p) {
        super(nome);
        this.p = p;
        start();
    }
    
    public void run(){
        while(true){
            try{
                sleep((int)(Math.random() * 2500));
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
            synchronized(p){
                p.start();
                System.out.println(getName() + ": e' entrata nel parcheggio. Posti disponibili: " + p.getPostiDisponibili());
            }
            try{
                sleep((int)(Math.random() * 5000));
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
            synchronized(p){
                p.end();
                System.out.println(getName() + ": e' uscita dal parcheggio. Posti disponibili: " + p.getPostiDisponibili());
            }
        }
    }
}
