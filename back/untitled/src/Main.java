import java.text.FieldPosition;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FunctionCalc functionCalc = new FunctionCalc();
        String kall = System.getenv("WEB_TEST");
        var vars = kall.split(":");
        System.out.println(functionCalc.isInTheSpot(Integer.parseInt(vars[0]), Integer.parseInt(vars[1]), Integer.parseInt(vars[2])));



    }
}
