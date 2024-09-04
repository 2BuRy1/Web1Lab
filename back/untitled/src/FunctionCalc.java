public class FunctionCalc {



    private boolean isTriangle(int x, int y, int r){
        int x1 = -1;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;
        int x3 = 0;
        int y3 = -1;

        //проверка суммой площадей
        float s = r*r*Math.abs(x1*(y2-y3)+x2*(y3-y1)+x3*(y1-y2));
        float s1 = Math.abs(x*(r*y1-r*y2)+r*x1*(r*y2-y)+x2*(y-r*y1));
        float s2 = Math.abs(x*(r*y2-r*y3)+r*x2*(r*y3-y)+x3*(y-r*y2));
        float s3 = Math.abs(x*(r*y3-r*y1)+r*x3*(r*y1-y)+r*x1*(y-r*y3));

        return s==(s1+s2+s3);
    }


    private boolean isCircle(int x, int y, int r){
        if( x * r >=0 && y * r <= 0 && Math.sqrt(x * x + y * y) <= r){
            return true;
        }


        return false;


    }


    private boolean isRectangle(int x, int y, int r) {
        if(  x * r >= 0 && y * r <= 0  && Math.abs(x) <= r && 2 * Math.abs(y) <= r){
            return true;
        }

        return false;

    }



    public boolean isInTheSpot(int x, int y, int r){
        if (x > 3 || x < -3 || y > 5 || y < -3){
            return false;
        }
        if(isCircle(x, y, r) || isTriangle(x, y, r) || isRectangle(x, y, r)){
            return true;
        }
        return false;
    }






}
