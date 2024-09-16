import java.util.logging.Logger;

public class FunctionCalc {



    Logger logger = LoggerConfig.getLogger(this.getClass().getName());
    private boolean isTriangle(int x, double y, int r) {

        var equation = r/2*x - r/2;

        if(y > 0 || x < 0 || y > equation){
            logger.info("returned false with arguments: %s, %s, %s".formatted(x, y, r));
            return false;
        }

        logger.info("returned true with arguments: %s, %s, %s".formatted(x, y, r));
        return true;
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
