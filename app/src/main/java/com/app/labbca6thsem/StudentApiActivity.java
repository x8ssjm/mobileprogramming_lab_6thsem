package com.app.labbca6thsem;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class StudentApiActivity extends AppCompatActivity {

    Button btnLoad;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_api);

        btnLoad = findViewById(R.id.btn_load_api);
        txtResult = findViewById(R.id.txt_api_result);

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FetchStudentData().execute();
            }
        });
    }

    private class FetchStudentData extends AsyncTask<Void, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            txtResult.setText("Loading data from API...");
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {
                // Using jsonplaceholder API for better reliability
                URL url = new URL("https://jsonplaceholder.typicode.com/users");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder result = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }

                reader.close();
                return result.toString();

            } catch (Exception e) {
                return "Error: " + e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String result) {
            if (result.startsWith("Error")) {
                txtResult.setText(result);
                return;
            }

            try {
                // jsonplaceholder returns a JSONArray directly
                JSONArray resultsArray = new JSONArray(result);
                StringBuilder formattedData = new StringBuilder();

                for (int i = 0; i < resultsArray.length(); i++) {
                    JSONObject user = resultsArray.getJSONObject(i);

                    int id = user.getInt("id");
                    String fullName = user.getString("name");
                    String email = user.getString("email");

                    // Use company name as "Faculty" for display
                    JSONObject companyObj = user.getJSONObject("company");
                    String faculty = companyObj.getString("name");

                    formattedData.append("ID: ").append(id).append("\n");
                    formattedData.append("Name: ").append(fullName).append("\n");
                    formattedData.append("Email: ").append(email).append("\n");
                    formattedData.append("Company: ").append(faculty).append("\n");
                    formattedData.append("----------------------------\n\n");
                }

                txtResult.setText(formattedData.toString());

            } catch (JSONException e) {
                txtResult.setText("JSON Parsing Error: " + e.getMessage());
            }
        }
    }
}
