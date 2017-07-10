package com.example.miquido.rss.Common;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by miquido on 10.07.2017.
 */

public class HTTPDataHandler {

    static String stream = "";

    public HTTPDataHandler(){}

    public String GetHTTPDataHandler(String urlString){

        try{
            URL url = new URL(urlString);

            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();

            if(httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK){
                InputStream inputStream = new BufferedInputStream(httpURLConnection.getInputStream());

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder sb = new StringBuilder();
                String line="";

                while((line = bufferedReader.readLine()) != null)
                    sb.append(line);
                    stream = sb.toString();

                httpURLConnection.disconnect();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stream;
    }

}
