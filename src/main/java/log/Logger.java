package log;

import log.logType;
import java.util.ArrayList;

/**
 *
 * @author Sayu
 */
public final class Logger {

    private static volatile Logger instance;
    private final ArrayList<Log> logRecords;

    private Logger() {
        logRecords = new ArrayList<>();
    }

    public static Logger getInstance() {
        Logger log = instance;
        if (log != null) {
            return log;
        }
        synchronized (Logger.class) {
            if (instance == null) {
                instance = new Logger();
            }
            return instance;
        }
    }

    public void showLog() {
        System.out.println("\n\nLOG============================");
        for (Log log : logRecords) {
            log.show();
        }
    }

    public void log(logType type, String logMessage) {
        Log log = new Log(type, logMessage);
        logRecords.add(log);
    }

}
