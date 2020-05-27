package Esercizio;

public class Test {
    public static void main(String[] args){
        
        Parcheggio p = new Parcheggio(10);
        Macchina m;
        
        for (int i = 1; i <= 10; i++) {
            m = new Macchina("L'auto " + i, p);
        }
    }
}
