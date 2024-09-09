import com.fastcgi.FCGIInterface;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class RequestHandler {


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

        var elements = request.split(":");


        float[] values = new float[3];

        if (elements.length != 4) {
            return new float[]{-20, -20, -20};
        }
        try {
            values[0] = Float.parseFloat((elements[1].split(",")[0]));
            values[1] = Float.parseFloat((elements[2].split(",")[0]));
            values[2] = Float.parseFloat(elements[3].split("}")[0].replace("}", ""));
            return values;
        } catch (Exception e) {
            return new float[]{-20, -20, -20};
        }

    }
}



