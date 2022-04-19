package com.example.aldegaithermidterm2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    Button button = (Button)findViewById(R.id.button);
    Button prevbtn = (Button)findViewById(R.id.prevbtn);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    MyDB.AddProduct(urid,firstname,surname,nationalid);
                    Log.d("SarahD", "log message");

                    Toasty.info(getBaseContext(), "Your data is deleted.", Toast.LENGTH_SHORT, true).show();

    }
}
                prevbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(MainActivity3.this, MainActivity2.class));
    }
    }
    }
}