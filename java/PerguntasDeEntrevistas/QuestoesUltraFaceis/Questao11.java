class Questao11{
    public static void main(String[] args){
        int [] numeros = new int[100];
        for (int i = 0; i < numeros.length; i++)
            numeros[i] = new java.util.Random().nextInt(10000);

        int guess = 5;
        
        while(guess > 0 && guess <= 10000 ){
            System.out.println("\nDigite um numero entre 0 e 10000 para verificar se ele esta na lista:");
            guess = Integer.parseInt(System.console().readLine());
            
            boolean found = false;
            for (int i = 0; i < numeros.length; i++){
                found = numeros[i] == guess;
                if(found) break;
            }
                
            if(found)
                System.out.println("O numero "+guess+" esta na lista");
            else
                System.out.println("O numero "+guess+" não esta na lista");
        }
    }
}