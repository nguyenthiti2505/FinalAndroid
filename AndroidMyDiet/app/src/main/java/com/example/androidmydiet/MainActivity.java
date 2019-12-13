package com.example.androidmydiet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btncal = findViewById(R.id.btnCal);
        final Button btndel = findViewById(R.id.btnDel);
        final EditText editTextname = findViewById(R.id.textName);
        final EditText editTextWeight = findViewById(R.id.txtWeight);
        final EditText editTextHeight = findViewById(R.id.txtHeight);



        btncal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), BMIActivity.class);

                String name     = editTextname.getText().toString();
                float edtHeight = Float.parseFloat(editTextHeight.getText().toString());
                float weight    = Float.parseFloat(editTextWeight.getText().toString());
                float height    = edtHeight / 100;
                float BIMNumber = weight / (height * height);

                if(editTextname.getText().toString().isEmpty()){
                    editTextname.setError("Không được để trống");
                }
                else if(edtHeight > 250 || edtHeight < 30){
                    editTextHeight.setError("I don't belive, type again");
                }
                else{
                    intent.putExtra("name", name);
                    intent.putExtra("weight", weight);
                    intent.putExtra("height", edtHeight);
                    intent.putExtra("BIMNumber", BIMNumber);

                    startActivityForResult(intent, 0);
                }
            }
        });

        btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
    }
}
