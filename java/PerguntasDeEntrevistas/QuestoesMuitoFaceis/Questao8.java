class Questao8{
    public static void main(String[] args){
        int number = new java.util.Random().nextInt(3998)+1;
        System.out.println("\n\n\t\tO numero "+number+" em algarismo romanos é "+to_roman(number)+"\n\n");
    }
    public static String to_roman(int number){
        if(number > 3999 || number < 1) return "O Numero deve ser entre 1 e 3999";
        String[] roman = new String[] {"I","IV","V" ,"IX","X" ,"XL","L" ,"XC","C" ,"CD","D" ,"CM","M" };
        int[] values = new int[]{1 , 4  , 5  , 9  , 10 , 40 , 50 , 90 ,100 ,400 ,500 ,900 ,1000};
        
        String resp = "";
        for(int M = roman.length-1 ;M >= 0;M --){
            if (number >= values[M]){
                int times = number/values[M];
                for(int t = 1;t <= times;t ++)
                    resp += roman[M];
            }
            
            number = number%values[M];
        }
        System.out.println(number);
        return resp;
    }
}