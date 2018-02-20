package edu.ucdavis.nmng.ecs193_mapp;

import android.os.AsyncTask;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class InsertTest extends AsyncTask<String, Void, Void>
{
    @Override
    protected Void doInBackground(String... params)
    {
        HttpsURLConnection conn = null;
        String jsonStr = params[0];

        try
        {
            URL url = new URL("https://majestic-legend-193620.appspot.com/insert/reading");
            conn = (HttpsURLConnection)url.openConnection();

            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setChunkedStreamingMode(0);

            DataOutputStream out = new DataOutputStream(conn.getOutputStream());
            out.writeBytes(jsonStr);
            conn.connect();
            out.flush();
            out.close();

            int res = conn.getResponseCode();
            System.out.println("Res: " + res);

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            StringBuilder responseOutput = new StringBuilder();
            while((line = br.readLine()) != null ) {
                responseOutput.append(line);
            }
            br.close();

            System.out.println("Something to it: " + responseOutput.toString());
        }
        catch(MalformedURLException error) {
            System.out.print(error);
        }
        catch(SocketTimeoutException error) {
            System.out.print(error);
        }
        catch (IOException error) {
            System.out.print(error);
        }
        finally {
            conn.disconnect();
        }

        return null;
    }
}
