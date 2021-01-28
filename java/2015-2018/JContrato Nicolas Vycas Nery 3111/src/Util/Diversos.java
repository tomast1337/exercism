
package Util;

import java.text.ParseException;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class Diversos {
   
  public static String leDados(String mensagem, String titulo){
      String dado="";//variÃ¡vel local
      do{
       dado=JOptionPane.showInputDialog(null,mensagem,titulo,JOptionPane.QUESTION_MESSAGE);
      }
      while(dado==null||dado.isEmpty()); 
      dado=dado.replace(",",".");
      return(dado);
  }
	
  public static boolean testaNum(String dado,String titulo){
      boolean teste = true;
	
      try{
	Double.parseDouble(dado); 
      }
      catch(NumberFormatException erro){
	   mostrarDados("Houve erro na conversão \n"+
           "Digite apenas caracteres númericos "+erro.getMessage(), titulo, false);
            teste=false;
      }//Fim catch
      return(teste);
  }//Fim do testa num

  public static boolean confirmar (String mensagem, String titulo){
      int resp = JOptionPane.showConfirmDialog(null,mensagem,
                  titulo,JOptionPane.YES_NO_OPTION);
        return(resp == 0); 
  }

  public static void mostrarDados(String resposta, String titulo, boolean icone){
     if(icone)
       JOptionPane.showMessageDialog(null,resposta,titulo,JOptionPane.INFORMATION_MESSAGE);
     else
       JOptionPane.showMessageDialog(null, resposta,titulo,JOptionPane.ERROR_MESSAGE);
			
  }
  
  public static DefaultFormatterFactory FormatoData()
    {
        MaskFormatter mascara = null;
        try
        {
            mascara = new MaskFormatter("##/##/####");
        }
        catch (ParseException e){
            mostrarDados("Data Formatada" + e.getMessage(), "Projeto", true);
        }
        DefaultFormatterFactory formato = new DefaultFormatterFactory(mascara, mascara);
        return (formato);
    }
  
  public static boolean intervalo(double n, double n1, double n2, String titulo){
     if (n<0){
         mostrarDados("Favor digitar valores superiores ou igual a zero", titulo,
                 false);
         return(false);
     } else if (n1!=n2 && (n<n1 || n>n2)){
                mostrarDados("Valores fora do intervalo de " + n1 + " e " + n2, 
                        titulo, false);
                return(false);
              } else 
                return(true);
  }

}
