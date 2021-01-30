import javax.sound.midi.SysexMessage;

class Questao6{
    public static void main(String[] args){
        int[] lista =  new int[100];
        int[] tipo = new int[]{0,1,2,3,4,5,6,7,8,9,10};
        int[] moda = new int[]{0,0,0,0,0,0,0,0,0,0,0};
        //
        for (int i = 0; i < lista.length; i++){
            lista[i] = new java.util.Random().nextInt(11);
            moda[lista[i]] ++;
        }
        
        for(int i = 0 ,aux; i < tipo.length; i++){
            for(int j = 0; j < tipo.length-1; j++){
                if(moda [j] > moda [j + 1]){
                    
                    aux = moda[j];
                    moda[j] = moda[j+1];
                    moda[j+1] = aux;

                    aux = tipo[j];
                    tipo[j] = tipo[j+1];
                    tipo[j+1] = aux;
                }
            }
        }
        
        String resp = "\n\n\tCrescente\n";
        for (int i = 0; i < moda.length; i++){
            resp += "\tO numero "+tipo[i]+" aparece "+moda[i]+" vezes na lista\n";
        }
        System.out.println(resp);

        resp = "\n\n\tDecrescente\n";
        for (int i = moda.length-1; i >= 0; i--){
            resp += "\tO numero "+tipo[i]+" aparece "+moda[i]+" vezes na lista\n";
        }
        System.out.println(resp);
        
    
    }
}