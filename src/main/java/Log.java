import org.apache.log4j.Logger;

class Log {
    private static final Logger LOG = org.apache.log4j.Logger.getLogger(Log.class);

    void getLog(int statusCode, String logMessage){
        if (statusCode == 200){
            LOG.info(logMessage);
        }else{
            LOG.error("Error! Status code: " + statusCode);
        }
    }
}
