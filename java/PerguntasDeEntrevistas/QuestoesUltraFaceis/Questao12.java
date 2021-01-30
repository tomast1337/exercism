import java.util.Random;
class Questao12{
    public static void main(String[] args){
        boolean turnoPlayer = true;
        System.out.println("\n\n\t\tHI/LO\n\n");
        while(true){
            boolean guess;
            if(turnoPlayer){
                System.out.println("\nTruno Jogador\nO numero sera menor ou maior que 5000? (+/-)");
                String input = System.console().readLine();
                guess =  input.toLowerCase().toCharArray()[0] == '+' ;
            
            }else{
                System.out.println("\nTruno Computador\nO numero sera menor ou maior que 5000? (+/-)");
                guess = new Random().nextInt(10000) > 5000;
            }

            String resp;
            int roll = new Random().nextInt(10000);
            
            if (guess)
                resp = roll +" maior que 5000 ";
            else 
                resp = roll +" menor que 5000 ";
            
            if(guess == roll > 5000)
                resp = turnoPlayer? "\nO Player Acertou "+resp:"\nO Computador Acertou "+resp;
            else
                resp = turnoPlayer? "\nO Player Errou "+resp:"\nO Computador Errou "+resp;
            
            System.out.println(resp+"\nAperte qualuer botão para continuar...");
            System.console().readLine();
            turnoPlayer = !turnoPlayer;
            
        }
    }
}