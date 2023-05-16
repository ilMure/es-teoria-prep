public class Compratore extends Thread{
    private Botteghino risorsa;
    private Boolean ottenuto;
    private Boolean running;

    public Compratore(String name, Botteghino risorsa){
        super(name);
        this.risorsa = risorsa;
        this.ottenuto = false;
        this.running = true;
    }

    @Override
    public void run() {
        if (running){
            risorsa.acquistaBiglietto();
            ottenuto = true; 
            running = false;
        }
        
    }

    public void restituisci(){
        if(ottenuto){
            risorsa.restituisciBiglietto(this.getName());
            this.ottenuto = false;
        }
    }

    public void arresta(){
        this.running = false;
        System.out.println(getName()+": sono stato fermato");
    }

    public Boolean getOttenuto() {
        return ottenuto;
    }
}
