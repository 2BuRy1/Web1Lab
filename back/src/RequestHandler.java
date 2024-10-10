import com.fastcgi.FCGIInterface;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.logging.Logger;

public class RequestHandler {
    final Logger logger = LoggerConfig.getLogger(this.getClass().getName());


    public Dot readRequest() throws IOException {
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
//       if(!FCGIInterface.request.params.getProperty("REQUEST_METHOD").equals("POST")){
//            throw new RuntimeException();
//        }
        for (Map.Entry<Object, Object> entry : FCGIInterface.request.params.entrySet()) {
            logger.info(entry.getKey() + ": " + entry.getValue());
        }


        return JsonParser.parseJson(request);


    }
}



