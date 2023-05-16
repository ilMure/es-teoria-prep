public class Botteghino {
    private int bigliettiDisponibili;
    private int venditoriOccupati;

    public Botteghino(){
        this.bigliettiDisponibili = 15;
        this.venditoriOccupati = 2;
    }
    
    public synchronized void acquistaBiglietto(){
        String name = Thread.currentThread().getName();


        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            
        }


        while (bigliettiDisponibili <= 0 || venditoriOccupati >= 3){
            System.out.println(name+" mi spiace, sono finiti i biglietti...");
            try {
                wait();
            } catch (InterruptedException e) {
                
            }
        }

        venditoriOccupati++;

        bigliettiDisponibili--;

        
        System.out.println(name+" ha comprato il biglietto, disponibilità: "+bigliettiDisponibili);

        venditoriOccupati--;
    }

    public synchronized void restituisciBiglietto(String name){
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            
        }
        this.bigliettiDisponibili++;

        System.out.println(name+" ha restituito il biglietto, diponibilità: "+bigliettiDisponibili);

        notifyAll();
    }
}
