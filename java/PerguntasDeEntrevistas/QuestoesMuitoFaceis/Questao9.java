class Questao9{
    public static void main(String[] args){
        int num1 = new java.util.Random().nextInt(12345);
        int num2 = new java.util.Random().nextInt(12345);
        System.out.println(num1+"+"+num2+"="+sum(num1, num2));
        System.out.println(num2+"+"+num1+"="+sum(num2, num1));
    }
    static int sum(int num1,int num2){
        int magnetude = 1;
        while(num2 / magnetude > 0){
            magnetude *=10;
        }
        return num1*magnetude + num2;
    } 
}