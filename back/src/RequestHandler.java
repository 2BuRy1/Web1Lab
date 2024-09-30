import com.fastcgi.FCGIInterface;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

public class RequestHandler {

    private Logger logger = LoggerConfig.getLogger(this.getClass().getName());


    public double[] readRequest() throws IOException {
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
            return new double[]{-228, -228, -228};
        }
       return JsonParser.parseJson(request);


    }
}



