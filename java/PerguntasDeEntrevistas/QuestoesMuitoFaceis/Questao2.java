import java.util.Vector;

class Questao2{
    public static void main(String[] args){
        int tempo = new java.util.Random().nextInt(86400)+1;
        System.out.println("\n\n\t\t"+tempo+" Segundos -> "+secs_to_String(tempo)+"\n\n");
    }
    public static String secs_to_String(int segundos){
        if (segundos > 86400)
            segundos = segundos % 86400;
        return String.format("%02d", segundos / 3600)
         +":"+ String.format("%02d", (segundos % 3600) / 60)
         +":"+ String.format("%02d", (segundos % 3600) % 60);
    }
        
}
