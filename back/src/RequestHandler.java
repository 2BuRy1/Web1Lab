import com.fastcgi.FCGIInterface;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

public class RequestHandler {

    private Logger logger = LoggerConfig.getLogger(this.getClass().getName());


    public float[] readRequest() throws IOException {
        FCGIInterface.request.inStream.fill();
        var contentLength = FCGIInterface.request.inStream.available();
        var buffer = ByteBuffer.allocate(contentLength);
        var readBytes =
                FCGIInterface.request.inStream.read(buffer.array(), 0,
                        contentLength);
        var requestBodyRaw = new byte[readBytes];
        buffer.get(requestBodyRaw);
        buffer.clear();

        var request = new String(requestBodyRaw, StandardCharsets.UTF_8);
        if(!FCGIInterface.request.params.getProperty("REQUEST_METHOD").equals("POST")){
            return new float[]{-228, -228, -228};
        }
        logger.warning("Request without parsing: %s".formatted(request));
        var elements = request.split(":");


        float[] values = new float[3];
        logger.info("First split : " + elements[1] + " " + elements[2] + " " + elements[3]);
        try {
            values[0] = Float.parseFloat((elements[1].split(",")[0]));
            values[1] = Float.parseFloat((elements[2].split(",")[0]));
            values[2] = Float.parseFloat(elements[3].split("}")[0].replace("}", ""));
            return values;
        } catch (Exception e) {
            return new float[]{-228, -228, -228};
        }

    }
}



