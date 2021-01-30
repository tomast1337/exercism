class Questao8{
    public static void main(String[] args){
        System.out.println("Digite o texto:");
        String texto = System.console().readLine();
        
        for(String line : texto.split(" ")) System.out.println(line);
    }
}