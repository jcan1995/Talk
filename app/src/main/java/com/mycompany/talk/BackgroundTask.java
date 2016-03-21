package com.mycompany.talk;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by joshua on 3/19/2016.
 */
public class BackgroundTask extends AsyncTask<String,Void,String> {
public Context mContext;

    BackgroundTask(Context c){
        this.mContext = c;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }



    @Override
    protected String doInBackground(String... params) {

        Log.d("doInBackground","Inside doInBackground method");
        String register_url= "http://192.168.43.85/talkappdb/register.php";
        String login_url = "http://10.0.2.2/talkappdb/login.php";

        String method = params[0];
        if(method.equals("register")){
            Log.d("ifstatement","Inside if statement");

            String name = params[1];
            String user_name = params[2];
            String user_pass = params[3];
            String gender = params[4];
            String age = params[5];
            String email = params[6];


            try {
                URL url = new URL(register_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));

                String data = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name,"UTF-8")+"&"+
                        URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(user_name,"UTF-8")+"&"+
                        URLEncoder.encode("user_pass", "UTF-8") + "=" + URLEncoder.encode(user_pass,"UTF-8")+"&"+
                        URLEncoder.encode("gender", "UTF-8") + "=" + URLEncoder.encode(gender,"UTF-8")+"&"+
                        URLEncoder.encode("age", "UTF-8") + "=" + URLEncoder.encode(age,"UTF-8")+"&"+
                        URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email,"UTF-8");

                        bufferedWriter.write(data);
                        bufferedWriter.flush();
                        bufferedWriter.close();
                        OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return "Registration success...";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return null;
    }


    @Override
    protected void onProgressUpdate(Void... values) {

    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(mContext,result,Toast.LENGTH_LONG).show();
    }
}
