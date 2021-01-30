import java.util.Random;
class Questao9{
    public static void main(String[] args){
        int num1 = new Random().nextInt(20);
        int num2 = new Random().nextInt(20);
        int num3 = new Random().nextInt(20);
        
        String resposta = "\n\n\tNum1:"+num1+", Num2:"+num2+", Num3:"+num3 + "\n\t";
        if (num1 > num2 && num1 > num3)
            resposta += num1 +" é o maior";    
        else if(num2 > num1 && num2 > num3)
            resposta += num2 +" é o maior";
        else
            resposta += num3 +" é o maior";
        
        System.out.println(resposta +"\n\tA media entre eles é "+((num1+num2+num2)/3));
    }
}