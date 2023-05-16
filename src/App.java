import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Botteghino ris = new Botteghino();

        String nome = "Compratore ";

        ArrayList<Compratore> lista = new ArrayList<>();

        for (int i=0; i<30; i++){
            Compratore c = new Compratore(nome + i, ris);
            lista.add(i, c);
            c.start();
        }

        Thread.sleep(10000);


        lista.get(0).restituisci();
        lista.get(29).restituisci();
        lista.get(28).restituisci();
        lista.get(27).restituisci();
        lista.get(26).restituisci();

        Thread.sleep(5000);
        
        for(int i=0; i<lista.size(); i++){
            Compratore c = lista.get(i);
            if (!c.getOttenuto()) c.arresta();
        }
    }
}
