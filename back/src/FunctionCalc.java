import java.util.logging.Logger;

public class FunctionCalc {



    Logger logger = LoggerConfig.getLogger(this.getClass().getName());
    private boolean isTriangle(int x, double y, int r) {
        if (x < 0 || y > 0) {
            return false;
        }

        double xA = 0, yA = 0;
        double xB = r, yB = 0;
        double xC = 0, yC = -r / 2;

        double S = 0.5 * Math.abs(xA * (yB - yC) + xB * (yC - yA) + xC * (yA - yB));

        double S1 = 0.5 * Math.abs(x * (yA - yB) + xA * (yB - y) + xB * (y - yA));

        double S2 = 0.5 * Math.abs(x * (yC - yA) + xA * (y - yC) + xC * (yA - y));

        double S3 = 0.5 * Math.abs(x * (yB - yC) + xB * (yC - y) + xC * (y - yB));

        return (S1 + S2 + S3) == S;
    }


    private boolean isCircle(int x, double y, int r) {
        if( x * r <=0 && y * r >= 0 && Math.sqrt(x * x + y * y) <= r ){
            return true;
        }
        return false;


    }


    private boolean isRectangle(int x, double y, int r) {
        if(x * r >= 0 && y * r >= 0 && y <=r && x <=r/2){
            return true;
        }

        return false;

    }


    public boolean isInTheSpot(int x, double y, int r) {
        if (y > 5 || y < -3) {
            return false;
        }
        if (isCircle(x, y, r) || isTriangle(x, y, r) || isRectangle(x, y, r)) {
            logger.info("Returned true");
            return true;
        }
        logger.warning("Returned false");
        logger.warning("Returned false : x=%d, y=%f, r=%d".formatted( x, y, r));
        return false;
    }


}
