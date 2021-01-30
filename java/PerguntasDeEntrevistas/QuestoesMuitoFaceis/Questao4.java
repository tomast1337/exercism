class Questao4{
    public static void main(String[] args){
        int[] A =  new int[]{1,2,3,4,5};
        int[] B =  new int[]{10,11,12,13,14,15,16,17,18,19};
        int[] AB = new int[A.length+B.length];
        
        for(int i=0; i < A.length; i++){
            AB[i] = A[i];
        }
        for(int i=A.length; i < B.length+A.length; i++){
            AB[i] = B[i-A.length];
        }
        
        System.out.println("A  = "+java.util.Arrays.toString(A));
        System.out.println("B  = "+java.util.Arrays.toString(B));
        System.out.println("AB = "+java.util.Arrays.toString(AB));
    }
}