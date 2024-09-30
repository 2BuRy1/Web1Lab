public class JsonParser {



    public static double[] parseJson(String json) {
        String [] elements = json.split(":");

        double[] values = new double[3];
        try {
            values[0] = Double.parseDouble((elements[1].split(",")[0]));
            values[1] = Double.parseDouble((elements[2].split(",")[0]));
            values[2] = Double.parseDouble(elements[3].split("}")[0].replace("}", ""));
            return values;
        } catch (Exception e) {
            return new double[]{-228, -228, -228};
        }

    }



}
