package co.pragra.b10.framework.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class DriverConfig {

    private static Properties properties;

    private DriverConfig(){
        properties = new Properties();
        Path path = Paths.get("src","test", "resources","driverconfig.properties");

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
        return (String)properties.get(key);
    }
}
