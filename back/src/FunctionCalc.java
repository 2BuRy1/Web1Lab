import java.util.logging.Logger;

public class FunctionCalc {



    final Logger logger = LoggerConfig.getLogger(this.getClass().getName());
    private boolean isTriangle(Dot dot) {

        var equation = dot.getR()/2*dot.getX() - dot.getR()/2;

        if(dot.getY() > 0 || dot.getX() < 0 || dot.getY() > equation){

            return false;
        }

        return true;
    }


    private boolean isCircle(Dot dot) {
        return dot.getX() * dot.getR() <= 0 && dot.getY() * dot.getR() >= 0 && Math.sqrt(dot.getX() * dot.getX() + dot.getY() * dot.getY()) <= dot.getR();


    }


    private boolean isRectangle(Dot dot) {
        return dot.getX() * dot.getR() >= 0 && dot.getY() * dot.getR() >= 0 && dot.getY() <= dot.getR() && dot.getX() <= dot.getR() / 2;

    }


    public boolean isInTheSpot(Dot dot) throws Exception {
        if (!checkY(dot) || !checkR(dot) || !checkX(dot)) {
            return false;
        }
        if (isCircle(dot) || isTriangle(dot) || isRectangle(dot)) {
            logger.info("Returned true");
            return true;
        }

        logger.warning("Returned false : x=%d, y=%f, r=%d".formatted(dot.getX(), dot.getY(), dot.getR()));
        return false;
    }


    private boolean checkY(Dot dot) throws Exception {
        if( dot.getY() <= 5 && dot.getY() >= -3){
            return true;
        }
        throw new Exception("Invalid value");
    }
    private boolean checkR(Dot dot) throws Exception {

        int[] array = new int[] {1, 2, 3, 4, 5};
        for(int i = 0; i < array.length; i++) {
            if(dot.getR() == array[i]) {
                return true;
            }
        }
        throw new Exception("Invalid value");
    }


    private boolean checkX(Dot dot) throws Exception {
        int[] array = new int[] {-3, -2, -1, 0, 1, 2, 3, 4};
        for(int i = 0; i < array.length; i++) {
            if(dot.getX() == array[i]) {
                return true;
            }
        }
        throw new Exception("Invalid value");

    }


}
