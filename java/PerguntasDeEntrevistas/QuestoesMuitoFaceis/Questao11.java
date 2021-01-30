class Questao11 {

  public static void main(String[] args) {
    int sum = 0;
    for (int i = 1; i < 1000; i++) {
      if (isPrime(i)) {
        sum += i;
      }
    }
    System.out.println("A ssoma de todos os primoes de 1 a 1000 é " + sum);
  }

  static boolean isPrime(int n) {
    if (n <= 1) 
            return false; 
    for (int i = 2; i < n; i++) 
        if (n % i == 0) 
            return false; 
  
    return true; 
  }
}