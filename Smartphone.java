//int RECORD_SIZE=3*MAX_LENGTH*2+8+1;
public class Smartphone{
    private String marca;
    private String modello;
    private String tipoCPU;
    private int qtaRAM;
    private int qtaMEM;
    private boolean isActive;
    
    final static int MAX_LENGTH=35;
    final static int RECORD_SIZE=3*MAX_LENGTH*2+8;
    
    public Smartphone(String marca, String modello, String tipoCPU, int qtaRAM, int qtaMEM) {
        this.marca = marca;
        this.modello = modello;
        this.tipoCPU = tipoCPU;
        this.qtaRAM = qtaRAM;
        this.qtaMEM = qtaMEM;
    }
    public Smartphone(){
        marca = "";
        modello = "";
        tipoCPU = "";
        qtaRAM = 0;
        qtaMEM = 0;
    }
    //SET
    public void setMarca(String marca){
        this.marca = marca;
    }
    public void setModello(String modello){
        this.modello = modello;
    }
    public void setTipoCPU(String tipoCPU){
        this.tipoCPU = tipoCPU;
    }
    public void setQtaRAM(int qtaRAM){
        this.qtaRAM = qtaRAM;
    }
    public void setQtaMEM(int qtaMEM){
        this.qtaMEM = qtaMEM;
    }
    //GET
    public String getMarca(){
        return marca;
    }
    public String getModello(){
        return modello;
    }
    public String getTipoCPU(){
        return tipoCPU;
    }
    public int getRAM(){
        return qtaRAM;
    }
    public int getMEM(){
        return qtaMEM;
    }

    public String toString(){
        return "Marca: "+"\n"+
                "Modello: "+"\n"+
                "Tipo CPU: "+"\n"+
                "RAM: "+"\n"+
                "Memoria: ";
    }
}