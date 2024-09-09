import java.io.IOException;

public class Server {
    private final ResponseSender responseSender;

    private final FunctionCalc functionCalc;

    public Server(ResponseSender responseSender, FunctionCalc functionCalc){
        this.responseSender = responseSender;
        this.functionCalc = functionCalc;
    }


    public void run() throws IOException {
        responseSender.sendResponse();
    }


}
