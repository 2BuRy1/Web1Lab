import java.io.IOException;

public class Server {
    private final ResponseSender responseSender;


    public Server(ResponseSender responseSender){
        this.responseSender = responseSender;
    }


    public void run() throws IOException {

        while (true) {
            responseSender.sendResponse();
        }
    }

}
