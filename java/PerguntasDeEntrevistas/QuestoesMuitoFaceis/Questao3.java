class Questao3{
    public static void main(String[] args){
        int caraCount =0,coroaCount =0;
        for(int i = 0; i < 1000;i++){
            // True = cara , false = coroa
            boolean moeda =  new java.util.Random().nextBoolean();
            if(moeda) caraCount++;
            else coroaCount++;
        }
        System.out.println("Apos a moeda ser jogada 1000 veze ela caiu "+caraCount*100/1000+"% Cara e "+coroaCount*100/1000+"% Coroa");

    }
}