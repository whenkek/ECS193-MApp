package edu.ucdavis.nmng.ecs193_mapp;

import android.os.AsyncTask;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class InsertTest extends AsyncTask<String, Void, Void>
{
    @Override
    protected Void doInBackground(String... params)
    {
        HttpsURLConnection conn = null;
        String jsonStr = params[1];

        try
        {
            URL url = new URL(params[0]);
            conn = (HttpsURLConnection)url.openConnection();

            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);
            conn.setChunkedStreamingMode(0);

            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
            out.write(jsonStr.toString());
            out.flush();
            out.close();

            int res = conn.getResponseCode();
            System.out.println("Res: " + res);
        }
        catch(IOException error) {
            System.out.print(error);
        }
        finally {
            conn.disconnect();
        }

        return null;
    }
}
