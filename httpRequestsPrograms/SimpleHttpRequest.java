package httpRequestsPrograms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class SimpleHttpRequest {
    public static void main(String[] args) throws IOException{
        long startTime = System.currentTimeMillis();
        String webpageContent = fetchWebpage("https://example.com");
        long endTime = System.currentTimeMillis();

        System.out.println("Webpage length:- "+webpageContent.length());
        System.out.println("Time taken:- "+(endTime-startTime) +" in milliseconds");
    }
    public static String fetchWebpage(String url) throws IOException{
        URL webpageUrl = new URL(url);
        StringBuilder content = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(webpageUrl.openStream()))){
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        }
        return content.toString();
    }
}
