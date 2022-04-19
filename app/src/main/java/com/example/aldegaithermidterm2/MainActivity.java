package com.example.aldegaithermidterm2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    TextView citytextView, humiditytextView, temperaturetextView;
    ImageView weatherBackground;
    Button button;
    Spinner spin;
   String group;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String weatherWebserviceURL = "https://api.openweathermap.org/data/2.5/weather?lat=51.50&lon=-0.12&appid=070c1556c302bf4092d273caa5ad3853";

        JSONObject jsonObj;
        //link graphical items to variables
        temperaturetextView = (TextView) findViewById(R.id.temperaturetextView);
        citytextView = (TextView) findViewById(R.id.citytextView);
        humiditytextView = (TextView) findViewById(R.id.humiditytextView);
        button = (Button) findViewById(R.id.button);
        spin = (Spinner) findViewById(R.id.spinner);
        weather(weatherWebserviceURL);
        weatherBackground = (ImageView) findViewById(R.id.weatherbackground);
        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          group = spin.getSelectedItem().toString();
                                          if (group.equals("Spring")) {


                                          } else if (group.equals("Summer")) {
                                              String url = "https://www.weather-atlas.com/weather/images/city/7/5/57-1500-75.jpg";
                                              weather(url);
                                          } else if (group.equals("Winter")) {
                                              String url = "https://cdn.kimkim.com/files/a/images/639730ceb5d75bd65030944924bb2a122c018eaa/big-6630adc36591e7aeb07b23bea1c8c4cd.jpg";
                                              weather(url);
                                          }
                                      }
                                  }
        );

    }
    public void weather(String url){
        JsonObjectRequest jsonObj = new JsonObjectRequest(Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("SaraAbdulrahman", "Response recieved");
                        Log.d("SaraAbdulrahman",response.toString());
                        try {
                            String town = response.getString("name");
                            Log.d("Sara Town", town);
                            citytextView.setText(town);

                            JSONObject jsonMain = response.getJSONObject("main");
                            JSONObject jsonMain2 = response.getJSONObject("sys");
                            double temp = jsonMain.getDouble("temp");
                            Log.d("Sara", "temp=" + String.valueOf(temp));
                            temperaturetextView.setText(String.valueOf(temp));
                            double humidity = jsonMain.getDouble("humidity");
                            humid.setText(String.valueOf(humidity));

                            /* sub categories as JSON arrays */
                            JSONArray jsonArray = response.getJSONArray("weather");
                            Log.d("Sara-array-string", jsonArray.toString());
                            for (int i = 0; i < jsonArray.length(); i++) {
                                Log.d("Sara-array", jsonArray.getString(i));
                                JSONObject oneObject = jsonArray.getJSONObject(i);
                                String wheater = oneObject.getString("main");
                                Log.d("saldegaither", wheater);
                                if (wheater.equals("Clear")) {
                                    Log.d("Sara","wheater=Clear");
                                    Glide.with(MainActivity.this)
                                            .load("https://i.picsum.photos/id/866/536/354.jpg?hmac=tGofDTV7tl2rprappPzKFiZ9vDh5MKj39oa2D--gqhA")
                                            .into(weatherBackground);
                                } else if (wheater.equals("Clouds")) {
                                    Log.d("Sara","wheater=Clouds");
                                    Glide.with(MainActivity.this)
                                            .load("https://eyesofodysseus.files.wordpress.com/2013/11/wpid-04186_hd.jpg")
                                            .into(weatherBackground);
                                } else if (wheater.equals("Rainy")) {
                                    Glide.with(MainActivity.this)
                                            .load("https://s7d2.scene7.com/is/image/TWCNews/heavy_rain_jpg-6?wid=1250&hei=703&$wide-bg$")
                                            .into(weatherBackground);
                                }
                            }
                        }catch(JSONException e){
                            e.printStackTrace();
                            Log.e("JSON error",e.toString());
                        }

                    }
                }, new Response.ErrorListener()


}}}

}

}