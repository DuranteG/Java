import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GestoreBottoni implements ActionListener{
    FrameFile ff;
    FileManager fm;
    public GestoreBottoni(FrameFile ff){
        this.ff=ff;
        this.fm=new FileManager();
        fm.createFile();
    }
    public void actionPerformed(ActionEvent e){
        JButton bPremuto=(JButton) e.getSource();
        
        if(bPremuto == ff.btn_write){
            String txt = ff.txt_write.getText();
            fm.writeFile(txt);
        }
        if(bPremuto == ff.btn_read){
            ff.txa_visual.append(fm.readFile());
        }
    }
}