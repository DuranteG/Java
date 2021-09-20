import javax.swing.*;
import java.awt.*;

public class FrameFile{
    
    JTextField txt_write;
    JTextArea txa_visual;
    
    JButton btn_write;
    JButton btn_read;
    
    public FrameFile(){
        JFrame frm_file=new JFrame();
        frm_file.setSize(600,300);
        frm_file.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel pnl_princ=new JPanel();
        JPanel pnl_north=new JPanel();
        JPanel pnl_west=new JPanel();
        
        btn_write=new JButton("Scrivi");
        btn_read=new JButton("Leggi");
        
        txt_write=new JTextField();
        txa_visual=new JTextArea();
        
        pnl_princ.setLayout(new BorderLayout());
        
        GridLayout gd_north=new GridLayout(1,1);
        pnl_north.add(txt_write);
        pnl_north.setLayout(gd_north);
        
        GridLayout gd_west=new GridLayout(2,1);
        pnl_west.add(btn_write);
        pnl_west.add(btn_read);
        pnl_west.setLayout(gd_west);
        
        Container c = frm_file.getContentPane();
        c.add(pnl_princ);
        
        btn_write.addActionListener(new GestoreBottoni(this));
        btn_read.addActionListener(new GestoreBottoni(this));
        
        pnl_princ.add(pnl_north,BorderLayout.NORTH);
        pnl_princ.add(pnl_west,BorderLayout.WEST);
        pnl_princ.add(txa_visual,BorderLayout.CENTER);
        
        frm_file.setVisible(true);
        
    }
    public static void main(String args[]){
        FrameFile ff=new FrameFile();
    }
}