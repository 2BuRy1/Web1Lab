import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FunctionCalc functionCalc = new FunctionCalc();

        RequestHandler requestHandler = new RequestHandler();

        ResponseSender responseSender = new ResponseSender(functionCalc, requestHandler);


        Server server = new Server(responseSender);


        server.run();
    }
}
