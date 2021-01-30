class Questao5{
    public static void main(String[] args){
        System.out.println("Digite o capital inicial.");
        Float capital = Float.parseFloat(System.console().readLine().replace(",","."));

        System.out.println("Digite o porcentagem do juro.");
        Float porcentagem = Float.parseFloat(System.console().readLine().replace(",","."));
        
        System.out.println("Digite o tempo em anos.");
        Float tempo = Float.parseFloat(System.console().readLine().replace(",","."));
        
        Float montante = capital * (float) java.lang.Math.pow((1 + porcentagem/100 ), tempo);
        System.out.println("O montante do capital "+String.format("%.1f", capital)+" apos "+String.format("%.1f", tempo)+" anos com "+String.format("%.2f", porcentagem)+"% de juros é "+String.format("%.2f", montante));
        
    }
}