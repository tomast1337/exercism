class Questao5{
    public static void main(String[] args){
        System.out.println("Digite seu nome:");
        String name = System.console().readLine();
        
        if (name.equalsIgnoreCase("Jack")) 
            System.out.println("Oi "+name);
        else
            System.out.println("Ola "+name);
    }
}