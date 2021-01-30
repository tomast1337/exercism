class Questao6{
    public static void main(String[] args){
        System.out.println("Digite um numero:");
        int num = Integer.parseInt(System.console().readLine());
        
        String result = (num & 1) == 1? "O numero "+" é impar" : "O numero "+" é par";
        System.out.println(result);
    }
}