import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.*;

public class FileManager{
    File file;
    Smartphone smart;
    RandomAccessFile randomAccessFile;

    public FileManager(){
        this.file=new File("Smartphones.dat");
        open(file);
    }
    public void open(File file){
        try{
            randomAccessFile = new RandomAccessFile(file,"rw");
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }
    }
    public long numberOfRecords(int RECORD_SIZE){
        long lenght=1;
        long res=0;

        try{
            lenght = randomAccessFile.length();
        }catch(IOException ex){
            ex.printStackTrace();
        }
        res=lenght/smart.RECORD_SIZE;
        return res;
    }
    public boolean write(Smartphone smart){
        boolean res = false;
        try{
            System.out.println("POS: "+smart.RECORD_SIZE*numberOfRecords(smart.RECORD_SIZE));
            
            randomAccessFile.skipBytes((int)(smart.RECORD_SIZE*numberOfRecords(smart.RECORD_SIZE)));
            writeString(smart.getMarca());
            writeString(smart.getModello());
            writeString(smart.getTipoCPU());
            randomAccessFile.writeInt(smart.getRAM());
            randomAccessFile.writeInt(smart.getMEM());
            res=true;
        }catch(IOException ex){
            res=false;
            ex.printStackTrace();
        }
        return res;
    }
    public void writeString(String str){
        try{
            randomAccessFile.writeChars(str);
        }catch(IOException ex){
            ex.printStackTrace();
        }
        for(int i=str.length();i<smart.MAX_LENGTH;i++){
            try{
                randomAccessFile.writeChar('\0');
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
    }
    public String readString(){
        String str="";
        char c=' ';
        for(int i=0;i<smart.MAX_LENGTH;i++){
            try{
                c=randomAccessFile.readChar();
            }catch(IOException ex){
                ex.printStackTrace();
            }
            if(c!='\0'){
                str+=c;
            }
        }
        return str;
    }
    public void readAll(){
        String res = " ";
        try{
            randomAccessFile.seek(0);
            for(int i = 0;i<numberOfRecords(smart.RECORD_SIZE);i++){
                res = readString();
                res += readString();
                res += readString();
                res += randomAccessFile.readInt();
                res += randomAccessFile.readInt();
            }
            System.out.println(res);
            System.out.println("");
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}