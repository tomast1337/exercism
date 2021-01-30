class Questao7{
    public static void main(String[] args){
        System.out.println("\n\t\t 24/3 -> "+divisao(24,3,0,0,true));
        System.out.println("\n\t\t 4/3 -> "+divisao(4,3,0,0,true));
        System.out.println("\n\t\t 25/5 -> "+divisao(25,5,0,0,true));
        System.out.println("\n\t\t 0/55 -> "+divisao(0,55,0,0,true));

        System.out.println("\n\t\t -24/3 -> "+divisao(-24,3,0,0,true));
        System.out.println("\n\t\t -4/-3 -> "+divisao(-4,-3,0,0,true));
        System.out.println("\n\t\t 25/-5 -> "+divisao(25,-5,0,0,true));
        System.out.println("\n\t\t -7894/-26 -> "+divisao(-7894,-26,0,0,true));

        System.out.println("\n\t\t 0/0 -> "+divisao(0,0,0,0,true));
        System.out.println("\n\t\t 69/0 -> "+divisao(-69,0,0,0,true));
    }
    static String divisao(int dividendo,int divisor,int resultado,int resto,boolean sinal){
        if(divisor == 0)
            return "Resultado Indefinido !!";
        else if(dividendo == 0)
            return "Resultado = "+dividendo+", Resto = "+dividendo;
        
        if (dividendo < 0){
            dividendo = dividendo * -1;
            sinal = dividendo < 0;
        } 
        if(divisor < 0){
            divisor = divisor * -1;
            sinal = sinal == divisor < 0;
        }

        if(dividendo > divisor){
            return divisao(dividendo - divisor, divisor, resultado+1 ,0,sinal);
        }else{
            return sinal? "Resultado = "+resultado+", Resto = "+dividendo : "Resultado = -"+resultado+", Resto = -"+dividendo;
        }
    }
}