class Animal{
    public void eat(){System.out.print("Animal come. ");}  
}
class Felino extends Animal{
    public void eat(){System.out.print("Felino come. ");} 
    public void hunt(){System.out.print("Felino caça. ");}  
}
class Gato extends Felino{
    public void eat(){System.out.print("Gato come. ");}
}
public class Dispath {
    public static void main(String[] args) {
        Animal a = new Felino();
        Felino g = new Gato();
        a.eat();
        //a.hunt();
        g.eat();
        g.hunt();

    }
}