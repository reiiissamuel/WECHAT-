
package simplesoundcapture;

import java.awt.Component;
import javax.swing.JOptionPane;



public class Error extends Thread{
   
    public void err(Object j,String m)
    {
        JOptionPane.showMessageDialog((Component) j,m,"ERROR", 0);
    }
    public void con(Object j,String m)
    {
        JOptionPane.showMessageDialog((Component) j,m,"CONFORMAÇÂO", 1);
    }
    public void war(Object j,String m)
    {
        JOptionPane.showMessageDialog((Component) j,m,"AVISO", 2);
    }
    public void un(Object j,String m)
    {
        JOptionPane.showMessageDialog((Component) j,m,"DESCONHECIDO", 3);
    }
    public int cond(Object j,String m)
    {
        int i=JOptionPane.showConfirmDialog((Component) j, m, "CONFIRMAÇÂO", JOptionPane.YES_NO_CANCEL_OPTION, 2);
        return i;
    }
     public String indt(Object j,String m)
    {
        String i;
        i = JOptionPane.showInputDialog((Component) j,m, "ENTRADA", 3);
        return i;
    }
     public String indc(Object j,String m,Object[] ol)
    {
        String i;
        i = (String) JOptionPane.showInputDialog((Component) j, m, "ENTRADA", 3, null, ol,null);
        return i;
    }
    
}
