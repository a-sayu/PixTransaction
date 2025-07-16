package log;

import log.logType;
import java.time.LocalDateTime;

/**
 *
 * @author Sayu
 */
class Log {
    private logType type;
    private LocalDateTime logTime;
    private String logMessage;
    
    public Log (logType type, String logMessage) {
        this.type = type;
        this.logTime = LocalDateTime.now();
        this.logMessage = logMessage;
    }
    
    public void show() {
        System.out.println("[" + type.toString() + "] (" + logTime + "): " + logMessage);
    }
}
