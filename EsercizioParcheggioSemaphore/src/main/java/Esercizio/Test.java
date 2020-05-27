package Esercizio;

public class Test {
    public static void main(String[] args){
        Parcheggio p = new Parcheggio(10);
        String nome;
        for(int i = 0; i < 10; i++){
            nome = "Macchina " + i;
            Macchina m = new Macchina(nome, p);
        }
    }
}
