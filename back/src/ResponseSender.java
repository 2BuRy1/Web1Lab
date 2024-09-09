import com.fastcgi.FCGIInterface;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ResponseSender {

    private final FunctionCalc functionCalc;

    public ResponseSender(FunctionCalc functionCalc) {
        this.functionCalc = functionCalc;
    }


    public void sendResponse(float[] values) throws IOException {


        var fcgiInterface = new FCGIInterface();
        while (fcgiInterface.FCGIaccept() >= 0) {
            boolean status = functionCalc.isInTheSpot((int) values[0], values[1], (int) values[2]);
            var start = System.nanoTime();
            var content = """
                    {
                    status: %s,
                    time: %.3f.
                    }
                    """;
            if(status) {
                var httpResponse = """
                        HTTP/2 200 OK
                        Content-Type: application/json
                        Content-Length: %d
                         
                        %s
                        """.formatted(content.getBytes(StandardCharsets.UTF_8).length, content);

            var end = System.nanoTime();
                    content = content.formatted("true", (end - start));
                System.out.println(httpResponse);
            }
            else{
                var httpResponse = """
                        HTTP/2 403 BAD REQUEST
                        Content-Type: application/json
                        Content-Length: %d
                         
                        %s
                        """.formatted(content.getBytes(StandardCharsets.UTF_8).length, content);
                var end = System.nanoTime();
                content = content.formatted("false", (end - start));
                System.out.println(httpResponse);
            }


        }
    }
}