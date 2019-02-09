package co.pragra.b10.framework.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class DriverConfig {

    private static Properties properties;
    private final static Logger logger = LogManager.getLogger(DriverConfig.class);

    private DriverConfig(){
        properties = new Properties();
        Path path = Paths.get("src","test", "resources","driverconfig.properties");
        logger.info("Reading config file from location - {}", path.toString());
        try {

            InputStream fileInputStream = new FileInputStream(path.toFile());
            properties.load(fileInputStream);

        }catch (IOException ex){

        }
    }


    public static String getProperty(String key){
        if(properties==null){
            new DriverConfig();
        }
        if(properties.get(key)==null){
            logger.error("No property define for the key -  {}", key);
        }
        logger.info("Property found for the key - {} - Value - {}", key,properties.get(key));
        return (String)properties.get(key);
    }
}
