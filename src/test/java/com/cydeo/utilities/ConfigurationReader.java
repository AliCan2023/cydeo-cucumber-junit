package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    //1-Create the object of Properties
    private static final Properties properties = new Properties();

    static {

        try {
            //2-we need to open the file in Java memory;
            FileInputStream file = new FileInputStream("configuration.properties");//pathOfTheFileWeAreTryingTOOpen;

            //3-load the properties object using FileInputStream object;
            properties.load(file);

            //close the file
            file.close();

        } catch (IOException e) {
            System.out.println("File not found in the ConfigurationReader Class.");
            e.printStackTrace();
        }

    }

    public static String getProperty(String keyword) {
        return properties.getProperty(keyword);

    }
}
