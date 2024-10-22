package Practica2.URLManager;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class HTTPFileDownloader {
    static private final int BUFFER_SIZE = 1024;

    private HTTPFileDownloader() {}

    public static String downloadFromURL(String link) {
        StringBuilder myURLContent = new StringBuilder();
        try {
            // Abrir enlace URL como stream de datos
            BufferedInputStream in = new BufferedInputStream(new URL(link).openStream());
            int bytesRead;
            byte[] byteContents = new byte[BUFFER_SIZE];
            // Lectura de contenido
            while((bytesRead = in.read(byteContents)) != -1) {
                // Transformación de contenido a String
                myURLContent.append(new String(byteContents, 0, bytesRead));
            }

            return myURLContent.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.err.println("There is a malformed URL in " + HTTPFileDownloader.class);
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("There is an IO error for the Stream opened in " + HTTPFileDownloader.class);
            System.exit(1);
        }
        return myURLContent.toString();
    }
}
