class Questao10{
    public static void main(String[] args){
        System.out.println("\n\n\n\t\t\tO numero "+12321+(is_palidrome(12321)?" é palidromo":" não é palidromo"));
        System.out.println("\t\t\tO numero "+187+(is_palidrome(187)?" é palidromo":" não é palidromo"));
        System.out.println("\t\t\tO numero "+88888+(is_palidrome(88888)?" é palidromo":" não é palidromo"));
        System.out.println("\t\t\tO numero "+987789+(is_palidrome(987789)?" é palidromo":" não é palidromo"));
        System.out.println("\t\t\tO numero "+25876852+(is_palidrome(25876852)?" é palidromo":" não é palidromo\n\n\n"));
    }
    static boolean is_palidrome(int num){
        int halfSize = 0, magnetude = 1;
        while(num / magnetude > 0){
            magnetude *=10;
            halfSize ++;
        }
        halfSize = halfSize%2 == 00 ? halfSize/2 : (halfSize-1)/2;
        magnetude = magnetude/10;

        for (int i = 0; i < halfSize; i++) {
            int start = num / magnetude;
            int end = num % 10;
            
            num = num%magnetude;
            num = num/10;
            magnetude = magnetude/100;
            
            if(start != end){
                return false;        
            }
        }
        return true;
    }
}