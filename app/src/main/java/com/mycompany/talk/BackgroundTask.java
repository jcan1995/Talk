package com.mycompany.talk;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

    AlertDialog.Builder builder;
    Activity mActivity;
    ProgressDialog mProgressDialog;


    public BackgroundTask(Context c){
        this.mContext = c;
        mActivity = (Activity) c;
    }

    @Override
    protected void onPreExecute() {
        builder = new AlertDialog.Builder(mActivity);
        mProgressDialog = new ProgressDialog(mContext);
        mProgressDialog.setTitle("Please wait");
        mProgressDialog.setMessage("Connecting to server...");
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
    }



    @Override
    protected String doInBackground(String... params) {

        Log.d("doInBackground","Inside doInBackground method");
        String register_url= "http://192.168.0.4/talkappdb/register.php";
        String login_url = "http://192.168.0.4/talkappdb/login.php";

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
                httpURLConnection.setDoInput(true);

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
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(IS));
                StringBuilder stringBuilder = new StringBuilder();

                String line = "";
                while((line = bufferedReader.readLine())!= null){
                    stringBuilder.append(line+"\n");
                }
               //IS.close();
                httpURLConnection.disconnect();
                Thread.sleep(5000);

                return stringBuilder.toString().trim();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else if(method.equals("login")){
            String login_name = params[1];
            String login_pass = params[2];
            try {
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data = URLEncoder.encode("login_name","UTF-8") + "=" + URLEncoder.encode(login_name,"UTF-8")+"&"+
                            URLEncoder.encode("login_pass","UTF-8") + "=" + URLEncoder.encode(login_pass,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String response = "";
                String line = "";
                while((line = bufferedReader.readLine())!= null){
                    response += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return response;




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
    protected void onPostExecute(String json) {
        try {
            mProgressDialog.dismiss();
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("server_response");
            JSONObject JO = jsonArray.getJSONObject(0);
            String code = JO.getString("code");
            String message = JO.getString("message");
            if(code.equals("reg_true")) {
                showDialog("Registration success.",message,code);
            }

            else if(code.equals("reg_false")){
                showDialog("Registration failed.",message,code);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void showDialog(String title,String message, String code){

        builder.setTitle(title);
        if(code.equals("reg_true")||code.equals("reg_false")){
            builder.setMessage(message);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    mActivity.finish();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }

    }

}
