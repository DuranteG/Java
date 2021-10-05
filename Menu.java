import java.io.*;
public class Menu{
	public static void main(String[] args){
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader in=new BufferedReader(input);
        
		FileManager fm=new FileManager();
		Smartphone smart;
        String s;
		int opt = 0;
		
		try{
            do{
                System.out.println("0 --> Esci");
                System.out.println("1 --> Crea il file");
                System.out.println("2 --> Scrivi sul file");
                System.out.println("3 --> Leggi il file");
                System.out.println("Scelta: ");
                s=in.readLine();
                opt=Integer.parseInt(s);
                    switch(opt){
                        case 0:
                            break;
                        case 1:
                            fm=new FileManager();
                            break;
                        case 2:
                            smart=new Smartphone("Samsung","s10","Exynos",8,128);
                            fm.write(smart);
                            break;
                        case 3:
                            fm.readAll();
                            break;
                    }
                }while(opt!=0);
		}catch(Exception e){
			System.out.println(e);
		}
	}
}