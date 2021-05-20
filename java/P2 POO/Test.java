public class Test {

    public static void mains(String[] args) {
        int valor1 = 5, valor2 = 10;
        ++valor1;
        valor2++;
        valor1--;
        ++valor2;
        valor2 += 1;
        valor1 -= 2;
        valor2 = valor2 + valor1;
        System.out.println(valor2);
    }

    public static void main(String[] args) {
        double Imposto = 1000.00, ValoraPagar, ValorMulta, ValorJurosDia;
        int DiasdeAtraso = 10;
        double PercentagemMultaAtraso = 2.0, PercentagemJurosDia = 0.1;
        ValoraPagar = Imposto;
        if (DiasdeAtraso > 0) {
            ValorMulta = ValoraPagar * (PercentagemMultaAtraso) / 100;
            ValoraPagar += ValorMulta;
            ValorJurosDia = Imposto * (PercentagemJurosDia) / 100;
            ValoraPagar += ValorJurosDia * DiasdeAtraso;
            System.out.println("Valor para Pagar Hoje: " + ValoraPagar);
            for (int i = 1; i < 5; i++) {
                ValoraPagar += ValorJurosDia;
                System.out.println("Valor para Pagar Hoje+" + i + ":" + ValoraPagar);
            }
        }
    }
}

abstract class T {
    public void name() {
        System.out.print("ola");
        String nomeA = ",", nomeB = "asd";

    }
}

class Y extends T {

}

interface Animal {
    public void animalSound(); // interface method (does not have a body)

    public void sleep(); // interface method (does not have a body)
}

interface Car {
    public void CarSound(); // interface method (does not have a body)
}

class AnimalCar implements Car, Animal {

    @Override
    public void animalSound() {
        T t = new T();
        // TODO Auto-generated method stub

    }

    @Override
    public void sleep() {
        // TODO Auto-generated method stub

    }

    @Override
    public void CarSound() {
        // TODO Auto-generated method stub

    }

}