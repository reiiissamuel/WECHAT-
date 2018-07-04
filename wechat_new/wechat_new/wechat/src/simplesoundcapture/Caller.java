package simplesoundcapture;

import java.io.BufferedInputStream;
import java.io.IOException;

/* classe que usa comdando de prompt I.E usado para o "SYSTEM CALLS no programa */ 

public class Caller 
{ 
    Caller()
    {
        
    }

    //metodo para executar a string dada no prompt

 public void system(String executer)  
 { 
  try 
  {
      Runtime r=Runtime.getRuntime(); 
      Process p=r.exec("cmd /c "+executer); 
  } 
  catch(IOException ie) 
  { 
      ie.printStackTrace(); 
  } 
 } 

 /* MÉTODO PARA EXECUTAR A CADEIA CONCEDIDA NO PROMPT DE COMANDO E COPIAR O TEXTO EXECUTADO PARA ESTE PROGRAMA */

 public String system(String executer,boolean big)  
 { 
    int rr;
    String re=" "; 
    try 
    { 
        Runtime r=Runtime.getRuntime(); 
        Process p=r.exec("cmd /c "+executer);               
        try 
        { 
            BufferedInputStream bf = new BufferedInputStream(p.getInputStream()); 
            re=""; 
            while((rr=bf.read())!=-1) 
                re=re+((char)rr);
            return re;
        } 
        catch(IOException ie) 
        { 
            ie.printStackTrace(); 
        }   
    } 
    catch(IOException ie) 
    { 
       ie.printStackTrace(); 
    }
    return null;
 }
 
} 