class Questao10{
    public static void main(String[] args){
        System.out.println("\n\n\nDigite a nota:");
        int nota = Integer.parseInt(System.console().readLine());
        
        System.out.println("Fez projeto? (S/N)");
        String input = System.console().readLine();
        boolean projeto =  input.toLowerCase().toCharArray()[0] == 's' ;
        
        String result = projeto ? "\n\n\nO aluno fez o projeto":"O aluno não fez o projeto ";
        result +="e tem a nota: "; 
        
        if (projeto) 
            if(nota > 40)
                nota += 20;
            else 
                nota = 50;
    
        if (nota < 50)
            result += "F";
        else if (nota < 69)
            result += "C";
        else if (nota < 89)
            result += "B";
        else
            result += "A";
            
        System.out.println(result);
    }
}