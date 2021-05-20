import java.util.HashMap;
import java.util.Map;

public class DataBase {
    public static void main(String[] args) {
        Map<String, Double> m = new HashMap<String, Double>();
        m.put("1234#1", 1000.70);
        m.put("553742#3", 10000.50);
        m.put("12#2", 1300.10);
        m.put("4343#1", 1000.80);
        double med = ABC.calculaMedia(m, 1); // essa chamada deve calcular a média dos salários dos funcionários com
                                             // código do cargo = 1.
        System.out.println(med);
    }
}

class ABC {

    public static double calculaMedia(Map<String, Double> g, int cargo) {
        double soma = 0.0; int quantidade = 0;
        for (String key : g.keySet()) {
            String info[] = key.split("#");
            int cargoAutal = Integer.parseInt(info[1]);
            if (cargoAutal == cargo) {
                soma += g.get(key);
                quantidade++;
            }
        }
        return soma / quantidade;
    }
    /*
     * public static double calculaMedia (Map<String, Double> g, int cargo) { Double
     * media = 0.0; int quantidade = 0; for (String key : g.keySet()) { int
     * cargoAutal = Integer.parseInt(key.split("#")[1]); if(cargoAutal == cargo){
     * media+=g.get(key); quantidade++; } } return quantidade == 0 ? 0 :
     * media/quantidade; }
     */
}
