class Questao7{
    public static void main(String[] args){
        int size = 12;
        for(int i = 1,j = 1;i <= size*size;i++){
            String line = i % size == 0 ? 
                String.format("%03d", (j) * (size))   +"\n": 
                String.format("%03d", (j) * (i%size)) +" ";
            
            if(i % size == 0) j++;
            
            System.out.print(line);
        }
    }
}