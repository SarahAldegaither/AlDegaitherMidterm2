package com.example.aldegaithermidterm2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    int urid, nationalid;
    String firstname, surname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button button = (Button)findViewById(R.id.button);
        Button prevPagebutton = (Button)findViewById(R.id.prevPagebutton);
        Button nxtPagebutton = (Button)findViewById(R.id.nxtPagebutton);

        final DatabaseHelper MyDB = new DatabaseHelper(this);

        EditText urid = (EditText) findViewById(R.id.urid);
        EditText firstname = (EditText) findViewById(R.id.firstname);
        EditText surname = (EditText) findViewById(R.id.surname);
        EditText nationalid = (EditText) findViewById(R.id.nationalid);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                urid = urid.getText().toString();
                firstname = firstname.getText().toString();
                surname = surname.getText().toString();
                nationalid = nationalid.getText().toString();
                if(Integer.parseInt(urid)==true){
                    MyDB.AddProduct(urid,firstname,surname,nationalid);
                    Log.d("SarahD", "log message");
                    Toasty.info(getBaseContext(), "Your data is added.", Toast.LENGTH_SHORT, true).show();
                  Cursor cursor = MyDB.getListContents();

            }
        });

    }
}