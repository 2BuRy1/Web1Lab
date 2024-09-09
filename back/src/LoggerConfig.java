import java.util.logging.Logger;

public class LoggerConfig {
    Logger logger;

    public static Logger getLogger(String name) {
        return Logger.getLogger(name);
    }

}
