import java.util.logging.Logger;

public class FunctionCalc {



    Logger logger = LoggerConfig.getLogger(this.getClass().getName());
    private boolean isTriangle(int x, double y, int r) {

        //координаты вершин трегольника
        int x1 = r;
        int y1 = 0;
        int x2 = 0;
        int y2 = -r / 2;
        int x3 = 0;
        int y3 = 0;

        //формулы площадей
        var S = 1 / 2 * r / 2 * r;
        var S1 = 1 / 2 * Math.abs(x * (y2 - y3) + x2 * (y3 - y) + x3 * (y - y2));
        var S2 = 1 / 2 * Math.abs(x1 * (y - y3) + x * (y3 - y1) + x3 * (y1 - y));
        var S3 = 1 / 2 * Math.abs(x1 * (y2 - y) + x2 * (y - y1) + x * (y1 - y2));

        if (x * r >= 0 && y * r <= 0 && S == S1 + S2 + S3) {
            return true;
        }
        return false;
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
            logger.warning("Returned false : x=%d, y=%f, r=%d".formatted( x, y, r));
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
