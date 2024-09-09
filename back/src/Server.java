import java.io.IOException;

public class Server {


    private final RequestHandler requestHandler;

    private final ResponseSender responseSender;

    private final FunctionCalc functionCalc;

    public Server(RequestHandler requestHandler, ResponseSender responseSender, FunctionCalc functionCalc){
        this.requestHandler = requestHandler;
        this.responseSender = responseSender;
        this.functionCalc = functionCalc;
    }


    public void run() throws IOException {
        var floats = requestHandler.readRequest();
        responseSender.sendResponse(floats);
    }


}
