package edu.ucdavis.nmng.ecs193_mapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void PostNumbers (View button) throws Exception
    {
        final EditText patientIDField = (EditText)findViewById(R.id.patient_id_field);
        String patientIDStr = patientIDField.getText().toString();

        final EditText channel0Field = (EditText)findViewById(R.id.channel0_field);
        String channel0Str = channel0Field.getText().toString();

        final EditText channel1Field = (EditText)findViewById(R.id.channel1_field);
        String channel1Str = channel1Field.getText().toString();

        final EditText channel2Field = (EditText)findViewById(R.id.channel2_field);
        String channel2Str = channel2Field.getText().toString();

        final EditText channel3Field = (EditText)findViewById(R.id.channel3_field);
        String channel3Str = channel3Field.getText().toString();

        JSONObject patient = new JSONObject();
        JSONObject floats = new JSONObject();

        floats.put("ch0", channel0Str);
        floats.put("ch1", channel1Str);
        floats.put("ch2", channel2Str);
        floats.put("ch3", channel3Str);

        patient.put("patient_" + patientIDStr, floats);

        String jsonStr = patient.toString();

//        System.out.println(jsonStr);

        new InsertTest().execute(jsonStr);
    }
}
