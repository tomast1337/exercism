
package Util;

import java.text.ParseException;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class Diversos {
   
  public static String leDados(String mensagem, String titulo){
      String dado="";
      do{
       dado=JOptionPane.showInputDialog(null,mensagem,titulo,JOptionPane.QUESTION_MESSAGE);
      }
      while(dado==null||dado.isEmpty()); 
      dado=dado.replace(",",".");
      return(dado);
  }
  
  public static void mostrarDados(String resposta, String titulo, boolean icone) {
     if(icone)
       JOptionPane.showMessageDialog(null,resposta,titulo,JOptionPane.INFORMATION_MESSAGE);
     else
       JOptionPane.showMessageDialog(null, resposta,titulo,JOptionPane.ERROR_MESSAGE);
			
  }
  
  public static boolean testaNum(String dado,String titulo){
      boolean teste;
	
      try{
	 teste=true;
	 Double.parseDouble(dado); 
      }
      catch(NumberFormatException erro){
	   mostrarDados("Houve erro na conversão \n"+
           "Digite apenas caracteres númericos"+erro.getMessage(), titulo, false);
            teste=false;
      }//Fim catch
      return(teste);
  }//Fim do testa num

  public static boolean confirmar (String mensagem, String titulo) {
      return(JOptionPane.showConfirmDialog(null,mensagem,
                  titulo,JOptionPane.YES_NO_OPTION)==0);
       
  }
  
  public static boolean intervalo(double n, double n1, double n2, String titulo) {
     if (n<=0){
         mostrarDados("Favor digitar valores superiores a zero", titulo, false);
         return(false);
     } else if (n1!=n2 && (n<n1 || n>n2)){
                mostrarDados("Valores fora do intervalo de " + n1 + " e " + n2, titulo, false);
	        return(false);
	    } else 
                return(true);
  }
  
  public static String carNumerico(String texto, char car) {
        // TODO add your handling code here:
        if ((car >= '0' && car <= '9') ||
                 car == ',' || car == 8) {
             if (car != 8)
                 texto += String.valueOf(car);
             else if (!texto.isEmpty())
               texto = texto.substring(0,texto.length()-1);
        }
        return (texto);
  }
  
   public static DefaultFormatterFactory FormatoData(String titulo, int op) {
        MaskFormatter mascara = null;
        try {
            switch(op) {
                case 0 : mascara = new MaskFormatter("##/##/####");
                             break;
                case 1 : mascara = new MaskFormatter("##:##");    
            }
        }
        catch (ParseException e){
            mostrarDados("Erro na data formatada ou hora" + e.getMessage(), titulo, false);
        }
        DefaultFormatterFactory formato = new DefaultFormatterFactory(mascara, mascara);
        return (formato);
  }
        
 }
