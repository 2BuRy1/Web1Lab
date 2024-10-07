import java.util.logging.Logger;

public class JsonParser {
    private static Logger logger = LoggerConfig.getLogger(JsonParser.class.getName());

    public static double[] parseJson(String json) {
        var elements = json.split(":");

        double[] values = new double[3];
        try {
            values[0] = Double.parseDouble((elements[1].split(",")[0]));
            values[1] = Double.parseDouble((elements[2].split(",")[0]).replace("\"", ""));
            values[2] = Double.parseDouble(elements[3].split("}")[0].replace("}", ""));
            return values;
        } catch (Exception e) {
            logger.warning("Parsing json: " + e.getMessage());
            return new double[]{-228, -228, -228};
        }

    }



}
