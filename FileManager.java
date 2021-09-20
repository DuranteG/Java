import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileManager{
    private RandomAccessFile raf;
    final int MAX=30;
    public FileManager(){
    }
    
    public boolean createFile(){
        boolean trovato=true;
        File f=new File("archivio.dat");
        try{
            raf=new RandomAccessFile(f,"rw");
        }catch(FileNotFoundException exc){
            trovato=false;
            exc.printStackTrace();
        }
        return trovato;
    }
    public long numOfRecords(long record){
        long lenght=1;
        long res=0;

            try {
                lenght = raf.length();
            }catch(IOException ex){
                ex.printStackTrace();
            }
            res=lenght/recordSize;
        return res;
    }
    public void writeFile(String text){
        try{
            raf.writeChar(text);
        }catch(IOException e){
            e.printStackTrace();
        }
        for(int i=MAX-1;i<MAX;i++){
            try{
                raf.writeChar('\0');
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
    }
    public String readFile(){
        String testo="";
        try{
            raf.seek(0);
            for(i=0;i<numOfRecords();i++){
                for(j=0;j<MAX;j++){
                    testo = testo + raf.readChar();
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return testo;
    }
}