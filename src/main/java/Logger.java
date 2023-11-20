import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    private static final String LOG_FILE_PATH = "log.txt";

    public static void log(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE_PATH, true))) {
            String logEntry = getCurrentDateTime() + " - " + message;
            writer.write(logEntry);
            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getCurrentDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date());
    }

    }
