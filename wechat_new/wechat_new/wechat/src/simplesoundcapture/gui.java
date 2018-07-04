
package simplesoundcapture;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;



public class gui extends JFrame{
    private JTabbedPane jt1;
    private JPanel p1;
    private JPanel p2;
    private JPanel p3;
    private JPanel p4;
    private Component cc;
    private JTable t1;
    private DefaultTableModel df1;
    private String[] ts;
    private Object[][] oo;
    
    Error er;
    private int objcount;
    private Chat1 c1;
    private Chat c;
    private JTextField tf1;
    private int mode;
    private DefaultTableModel df2;
    private JTable t2;
    private JTextField tf2;
    private TChat1 tc1;
    private TChat tc;
    private JPopupMenu jp1;
    private JMenuItem jm1;
    private Clientv1 vc1;
    private Clientv2 vc2;
    private JButton pjb1;
    private JButton pjb2;
    private JPanel p5;
    private DefaultMutableTreeNode root,temp;
    private JTree jtre1;
    Capture cap1;
    int recor=0;
    private JButton pjb3;
    private JButton pjb4;
    private JPanel p6;
    private DefaultMutableTreeNode root1,temp1;
    private JTree jtre2;
    File ff;
    private Clientv3 tfi1;
    private Clientv4 tfi2;
    private final JMenuItem jm11;
    private final JMenuItem jm12;
    //private final JMenuItem jm13;
    private final JPopupMenu jpm1;
    private final JMenuItem jm21;
    private final JMenuItem jm22;
    //private final JMenuItem jm23;
    private final JPopupMenu jpm2;
    gui()
    {
        er=new Error();
        Look.look();
        jt1=new JTabbedPane();
        p1=new JPanel();
        p1.setLayout(new BorderLayout());
        p2=new JPanel(new BorderLayout());
        p3=new JPanel();
        p4=new JPanel();
        ts=new String[1];
        ts[0]="MENSAGENS";
        oo=new Object[1][1];
        df1=new DefaultTableModel(oo,ts);
        df2=new DefaultTableModel(oo,ts);
        t1=new JTable(df1);
        t2=new JTable(df2);
        t2.setEnabled(false);
        t1.setEnabled(false);
        p1.add(new JScrollPane(t1),BorderLayout.CENTER);
        p2.add(new JScrollPane(t2),BorderLayout.CENTER);
        jt1.add(p1,"MENSAGEM");
        jt1.add(p2,"MENSAGEM DE VOZ");
        jt1.add(p3,"VOZ");
        jt1.add(p4,"ARQUIVOS");
        this.addc(jt1);
        tf1=new JTextField(15);
        p1.add(tf1,BorderLayout.SOUTH);
        tf2=new JTextField(15);
        p2.add(tf2,BorderLayout.SOUTH);
        
        pjb1=new JButton("GRAVAR");
        pjb2=new JButton("ENVIAR");
        p5=new JPanel();
        p5.add(pjb1);
        p5.add(pjb2);
        p3.setLayout(new BorderLayout());
        p3.add(p5,BorderLayout.SOUTH);
        root=new DefaultMutableTreeNode("MENSAGENS DE VOZ");
        jtre1=new JTree(root);
        p3.add(new JScrollPane(jtre1),BorderLayout.CENTER);
        
        pjb3=new JButton("SELECIONAR");
        pjb4=new JButton("ENVIAR");
        p6=new JPanel();
        p6.add(pjb3);
        p6.add(pjb4);
        p4.setLayout(new BorderLayout());
        p4.add(p6,BorderLayout.SOUTH);
        root1=new DefaultMutableTreeNode("ARQUIVO");
        jtre2=new JTree(root1);
        p4.add(new JScrollPane(jtre2),BorderLayout.CENTER);
        jm11=new JMenuItem("PLAY");
        jm12=new JMenuItem("REMOVER");
        //jm13=new JMenuItem("REMOVE ALL");
        jpm1=new JPopupMenu();
        jpm1.add(jm11);
        jpm1.add(jm12);
        //jpm1.add(jm13);
        jtre1.setComponentPopupMenu(jpm1);
        jm21=new JMenuItem("ABRIR");
        jm22=new JMenuItem("REMOVER");
        //jm23=new JMenuItem("REMOVE ALL");
        jpm2=new JPopupMenu();
        jpm2.add(jm21);
        jpm2.add(jm22);
        //jpm2.add(jm23);
        jtre2.setComponentPopupMenu(jpm2);
        tf1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                 if(mode==1)
                 {
                    try {
                        String s="";
                        c.send(s=tf1.getText());
                        mes(s,0);
                        tf1.setText("");
                    } catch (Exception ex) {
                        Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
                    }
                 }
                 if(mode==2)
                 {
                    try {
                        String s="";
                        c1.send(s=tf1.getText());
                        mes(s,0);
                        tf1.setText("");
                    } catch (Exception ex) {
                        Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
                    }
                 }
            }
            
        });
        tf2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                 if(mode==1)
                 {
                    try {
                        String s="";
                        tc.send(s=tf2.getText());
                        mes1(s,0);
                        tf2.setText("");
                    } catch (Exception ex) {
                        Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
                    }
                 }
                 if(mode==2)
                 {
                    try {
                        String s="";
                        tc1.send(s=tf2.getText());
                        mes1(s,0);
                        tf2.setText("");
                    } catch (Exception ex) {
                        Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
                    }
                 }
            }
            
        });
        jt1.addChangeListener(new ChangeListener(){

            @Override
            public void stateChanged(ChangeEvent e) {
                call(jt1.getSelectedIndex());
            }   
        });
        jtre1.addTreeSelectionListener(new TreeSelectionListener()
        {
            public void valueChanged(TreeSelectionEvent e) {
                try
                {
                TreePath tp=e.getNewLeadSelectionPath();
                Object o=tp.getLastPathComponent();
                TreeNode tn=(TreeNode) o;
                System.out.println(tn.toString());
                DefaultMutableTreeNode dmt=(DefaultMutableTreeNode)o;
                //System.out.println(dmt.getParent().toString());
                temp=dmt;
                }
                catch(Exception etree)
                {
                    System.out.println("error tree");
                }
            }
            
        });
        jtre2.addTreeSelectionListener(new TreeSelectionListener()
        {
            public void valueChanged(TreeSelectionEvent e) {
                try
                {
                TreePath tp=e.getNewLeadSelectionPath();
                Object o=tp.getLastPathComponent();
                TreeNode tn=(TreeNode) o;
                System.out.println(tn.toString());
                DefaultMutableTreeNode dmt=(DefaultMutableTreeNode)o;
                //System.out.println(dmt.getParent().toString());
                temp1=dmt;
                }
                catch(Exception etree)
                {
                    System.out.println("error tree");
                }
            }
            
        });
        pjb1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                cap1=new Capture();
                cap1.start();
                recor++;
            }
        });
        pjb2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                cap1.stop();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
                }
                Caller ca1=new Caller();
                ca1.system("renomear voz.wav voz"+recor+".jpg",true);
                new File("voz.wav").delete();
                mes2("voz"+recor+".wav",0);
                if(mode==1)
                    new vcs1(vc1,"voz"+recor+".jpg");
                else if(mode==2)
                    new vcs2(vc2,"voz"+recor+".jpg");
            }
        });
        pjb3.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                ff=select();
            }
        });
        pjb4.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                Caller ca1=new Caller();
                String nam ="",ext = "",name=ff.getName();
                for(int i=0;i<name.length();i++)
                {
                    char c=name.charAt(i);
                    if(c=='.')
                    {
                        i++;
                       for(;i<name.length();i++)
                       {
                           c=name.charAt(i);
                           ext+=c;
                       }
                    }
                    else
                    {
                        nam+=c;
                    }
                }
                ca1.system("copiar \""+ff.getAbsolutePath()+"\" .",true);
                ca1.system("renomear \""+ff.getName()+"\" "+nam+".jpg",true);
                ca1.system("copiar "+nam+".jpg "+ff.getName(),true);
                System.out.println("ext:"+ext);
                mes3(ff.getName(),0);
                if(mode==1)
                    new vcs3(tfi1,nam+".jpg",ext);
                else if(mode==2)
                    new vcs4(tfi2,nam+".jpg",ext);
            }
        });
        jm11.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                if(temp!=null)
                {
                    new ac(temp.toString());
                }
                else
                    er.err(null,"SELECIONE UMA MENSAGEM PARA EXECUTAR");
            }
        });
        jm12.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                if(temp!=null)
                {
                    temp.removeFromParent();
                    ((DefaultTreeModel)jtre1.getModel()).reload();
                    jtre2.validate();
                    jtre2.setVisible(true);
                    p4.validate();
                }
                else
                    er.err(null,"SELECIONE UMA MENSAGEM PARA REMOVER");
            }
        });
        
        jm21.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                if(temp1!=null)
                {
                    Caller ca=new Caller();
                    ca.system("start "+temp1.toString(),true);
                }
                else
                    er.err(null,"SELECIONE UM ARQUIVO PARA ABRIR");
            }
        });
        jm22.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                if(temp1!=null)
                {
                    temp1.removeFromParent();
                    ((DefaultTreeModel)jtre2.getModel()).reload();
                    jtre2.validate();
                    jtre2.setVisible(true);
                    p4.validate();
                }
                else
                    er.err(null,"SELECIONE UM ARQUIVO PARA REMOVER");
            }
        });
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        init();
    }
    public void call(int state)
    {
        if(state==0)
        {
            
        }
        else if(state==1)
        {
            
        }
        else if(state==2)
        {
            
        }
        else if(state==3)
        {
            
        }
    }
    public void addc(Component c)
    {
        this.cc=c;
        this.add(cc);
    }
    public void removec()
    {
        this.remove(cc);
    }
    public static void main(String args[])
    {
        new gui();
    }
    public synchronized void mes2(String s,int co)
    {
        if(co==0)
        {
            this.root.add(new DefaultMutableTreeNode(s));
        }
        else if(co==1)
        {
            jt1.setSelectedIndex(2);
            this.root.add(new DefaultMutableTreeNode(s));
        }
        ((DefaultTreeModel)jtre1.getModel()).reload();
        jtre1.validate();
        jtre1.setVisible(true);
        p3.validate();
        this.setVisible(true);
    }
    public synchronized void mes(String s,int co) {
        String ss[]=new String[1];
        
        if(co==0)
        {
            ss[0]=s;
        }
        else if(co==1)
        {
            jt1.setSelectedIndex(0);
            ss[0]="Re: "+s;
        }
        df1.addRow((Object[])ss);
        p1.validate();
        this.setVisible(true);
    }
    public synchronized void mes1(String s,int co) {
        String ss[]=new String[1];
        if(co==0)
        {
            ss[0]=s;
        }
        else if(co==1)
        {
            jt1.setSelectedIndex(1);
            ss[0]="Re: "+s;
            new Read(s);
        }
        df2.addRow((Object[])ss);
        p2.validate();
        this.setVisible(true);
    }
    public synchronized void mes3(String s,int co)
    {
        if(co==0)
        {
            this.root1.add(new DefaultMutableTreeNode(s));
        }
        else if(co==1)
        {
            jt1.setSelectedIndex(3);
            this.root1.add(new DefaultMutableTreeNode(s));
        }
        ((DefaultTreeModel)jtre2.getModel()).reload();
        jtre2.validate();
        jtre2.setVisible(true);
        p4.validate();
        this.setVisible(true);
    }
    
    public File select()
    {
        File f;
        JFileChooser jfil=new JFileChooser();
                if(jfil.showOpenDialog(this)==JFileChooser.APPROVE_OPTION)
			f=jfil.getSelectedFile();
		else 
			f=null;
                return f;
    }
    private void init() {
        String indc = er.indc(this,"SELECIONE UM MODO PARA OPERAR",new Object[]{"MODO1","MODO2"});
        if(indc.compareTo("MODO1")==0)
        {
            er.con(this,"CHAT DE VOZ OPERARÁ NO MODO 1");
            if(er.cond(this,"O OUTRO CHAT DE VOZ DEVE OPERAR MODE 2")==0)
            {
                if(er.cond(this,"POR FAVOR, TENHA CONEXÃO COM OUTRO SISTEMA WIRE OU WIRELESS")==0)
                {
                    String ip=er.indt(this,"INSIRA O ENDEREÇO IP DO OUTRO SISTEMA EM REDE");
                    c=new Chat(this,ip);
                    tc=new TChat(this,ip);
                    vc1=new Clientv1(this,ip);
                    tfi1=new Clientv3(this,ip);
                    this.mode=1;
                }
                else
                {
                    er.err(this,"NÃO HÁ CONEXÃO. SAÍNDO...");
                    System.exit(0);
                }
            }
            else
            {
                    er.err(this,"DESCULPE! FUNCIONALIDADE IMPOSSIBILITADA. SAÍNDO...");
                    System.exit(0);
            }
            
        }
        else
        {
            er.con(this,"CHAT DE VOZ OPERARÁ NO MODO 2");
            if(er.cond(this,"O OUTRO CHAT DE VOZ DEVE OPERAR MODE 1")==0)
            {
                if(er.cond(this,"POR FAVOR, TENHA CONEXÃO COM OUTRO SISTEMA WIRE OU WIRELESS")==0)
                {
                    String ip=er.indt(this,"INSIRA O ENDEREÇO IP DO OUTRO SISTEMA EM REDE");
                    c1=new Chat1(this,ip);
                    tc1=new TChat1(this,ip);
                    vc2=new Clientv2(this,ip);
                    tfi2=new Clientv4(this,ip);
                    this.mode=2;
                }
                else
                {
                    er.err(this,"NÃO HÁ CONEXÃO. SAÍNDO...");
                    System.exit(0);
                }
            }
            else
            {
                    er.err(this,"DESCULPE! FUNCIONALIDADE IMPOSSIBILITADA. SAÍNDO...");
                    System.exit(0);
            }
        }
    }
}
class vcs1 extends Thread
{
    private Clientv1 vcc1;
    String file;
    vcs1(Clientv1 vc,String fi)
    {
        this.vcc1=vc;
        this.file=fi;
        Thread t=new Thread(this);
        t.start();
    }
    public void run()
    {
        vcc1.send(new File(file).getAbsolutePath());
        //new File(file).delete();
    }
}
class vcs2 extends Thread
{
    private Clientv2 vcc1;
    String file;
    vcs2(Clientv2 vc,String fi)
    {
        this.vcc1=vc;
        this.file=fi;
        Thread t=new Thread(this);
        t.start();
    }
    public void run()
    {
        vcc1.send(new File(file).getAbsolutePath());
        //new File(file).delete();
    }
}

class vc extends Thread
{
    String name="";
    gui Gui;
    vc(String nam,gui ui)
    {
        this.name=nam;
        this.Gui=ui;
        Thread t=new Thread(this);
        t.start();
    }
    public void run()
    {
        System.out.println("vs()"+name);
        String ss="";
        for(int i=0;;i++)
        {
            char c=name.charAt(i);
            if(c=='.')
            {
                Caller ca1=new Caller();
                ca1.system("rename "+name+" "+ss+".wav", true);
                System.out.println("vs()"+name);
                Gui.mes2(ss+".wav",1);
                System.out.println("vs()"+name);
                new ac(ss+".wav");
                System.out.println("vs()"+name);
                break;
            }
            else
                ss+=c;
        }
    }
}

class vcs3 extends Thread
{
    private Clientv3 vcc1;
    String file;
    private String ext;
    vcs3(Clientv3 vc,String fi,String ex)
    {
        this.vcc1=vc;
        this.file=fi;
        this.ext=ex;
        Thread t=new Thread(this);
        t.start();
    }
    public void run()
    {
        vcc1.send(new File(file).getAbsolutePath(),ext);
        //new File(file).delete();
    }
}
class vcs4 extends Thread
{
    private Clientv4 vcc1;
    String file;
    private String ext;
    vcs4(Clientv4 vc,String fi,String ex)
    {
        this.vcc1=vc;
        this.file=fi;
        this.ext=ex;
        Thread t=new Thread(this);
        t.start();
    }
    public void run()
    {
        vcc1.send(new File(file).getAbsolutePath(),ext);
        //new File(file).delete();
    }
}


class vc1 extends Thread
{
    String name="",ext;
    gui Gui;
    vc1(String nam,gui ui,String ex)
    {
        this.name=nam;
        this.Gui=ui;
        this.ext=ex;
        Thread t=new Thread(this);
        t.start();
    }
    public void run()
    {   
        System.out.println("vs()"+name);
        String ss="";
        for(int i=0;;i++)
        {
            char c=name.charAt(i);
            if(c=='.')
            {
                Caller ca1=new Caller();
                ca1.system("renomear "+name+" "+ss+"."+ext, true);
                System.out.println("vs()"+name);
                Gui.mes3(ss+"."+ext,1);
                System.out.println("vs()"+name);
                break;
            }
            else
                ss+=c;
        }
    }
}
