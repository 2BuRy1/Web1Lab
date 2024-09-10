import com.fastcgi.FCGIInterface;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

public class ResponseSender {

    private final FunctionCalc functionCalc;

    Logger logger = LoggerConfig.getLogger(this.getClass().getName());

    private final RequestHandler requestHandler;

    public ResponseSender(FunctionCalc functionCalc, RequestHandler requestHandler) {
        this.functionCalc = functionCalc;
        this.requestHandler = requestHandler;
    }


    public void sendResponse() throws IOException {


        var fcgiInterface = new FCGIInterface();
        logger.info("Waiting for requests...");
        while (fcgiInterface.FCGIaccept() >= 0) {

               var values = requestHandler.readRequest();
            logger.info("Request received! %s, %s, %s".formatted(values[0], values[1], values[2]));
            var status = functionCalc.isInTheSpot((int) values[0], values[1], (int)values[2]);
            var start = System.nanoTime();
            var content = """
                    {
                    
                    "status": %s,
                    "time": %s
                    
                    }
                    """;
                var end = System.nanoTime();
                content = content.formatted(status, String.format( "%.4f",(double) (end - start)/1000000));
                var httpResponse = """
                        HTTP/1.1 200 OK
                        Content-Type: application/json
                        Content-Length: %d
                        
                        %s
                        """.formatted(content.getBytes(StandardCharsets.UTF_8).length, content);

                  logger.warning("status: %s".formatted(status));
                System.out.println(httpResponse);




        }
    }
}