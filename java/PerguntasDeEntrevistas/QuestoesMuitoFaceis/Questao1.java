import jdk.jfr.internal.tool.Print;

import java.util.Collections;
import java.util.Vector;

class Questao1{
    public static void main(String[] args){
        String[] Numeros = new String[]{"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] Casas = new String[] {"HEARTS","TILES","CLOVER","PIKES"};
        
        Vector<String> Deck = new Vector<String>();
        for (int i = 0; i < Casas.length; i++){
            for (int j = 0; j < Numeros.length; j++)
                Deck.add(Numeros[j] +"-"+ Casas[i]);
        }
        
        Collections.shuffle(Deck);
        System.out.println("\n\n\t\tDuas primeiras carta do Deck embraralhado "+Deck.get(0)+" e "+Deck.get(1)+"\n\n");
    }
    
}