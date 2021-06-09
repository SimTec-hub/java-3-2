package geekbrain;


import java.io.FileInputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Logging {
    static Logger LOGGER;
    static {
        try(FileInputStream ins = new FileInputStream("C:\\log.config")){
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = Logger.getLogger(MyServer.class.getName());
        }catch (Exception ignore){
            ignore.printStackTrace();
        }
    }
}
