package com.example.androidmydiet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BMIActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        TextView TvName = findViewById(R.id.tvName);
        TextView TvWeight = findViewById(R.id.tvWeight);
        TextView TvHeight = findViewById(R.id.tvHeight);
        TextView TvBIM = findViewById(R.id.tvBMI);
        TextView Picture = findViewById(R.id.tvPicture);
        Button back = findViewById(R.id.btnBack);
        Button choose = findViewById(R.id.btnChoose);

        final Intent intent = this.getIntent();
        String name = intent.getStringExtra("name");
        final float weight = intent.getFloatExtra("weight", 0.0f);
        final float height = intent.getFloatExtra("height", 0.0f);
        final float BIMNumber = intent.getFloatExtra("BIMNumber", 0.0f);

        TvName.setText("Hello: "+name);
        TvWeight.setText("Your Weight: "+Math.round(weight) + "kg");
        TvHeight.setText("Your Height: " +Math.round(height) + "cm");
        TvBIM.setText("Your BMI: " + Math.round(BIMNumber));

        if(BIMNumber < 18.5){
            Picture.setText("You are now too thin compared to your body, eat and rest well.");
        }
        else if(BIMNumber >= 18.5 && BIMNumber < 24.9) {
            Picture.setText("You are able to be normal and healthy, remember to stay healthy and exercise");
        }
        else if(BIMNumber >= 24.9 && BIMNumber < 29.9){
            Picture.setText("You are on obesity 1 so you need to adjust your diet properly and increase activity");
        }
        else if(BIMNumber >= 30){
            Picture.setText("You are overweight, you need to see a doctor," +
                    " need to adjust the diet and increase physical activity to lose weight, bring BMI to normal levels.");
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(view.getContext(), MainActivity.class);
                startActivityForResult(intent1, 0);
            }
        });

        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(BIMNumber < 18.5){
                    Intent slimIntent = new Intent(BMIActivity.this, SlimActivity.class);
                    startActivity(slimIntent);
                }
                else if(BIMNumber >= 18.5 && BIMNumber < 24.9) {
                    Intent mediumIntent = new Intent(BMIActivity.this, MediumActivity.class);
                    startActivity(mediumIntent);
                }
                else if(BIMNumber >= 24.9 && BIMNumber < 29.9){
                    Intent fatIntent = new Intent(BMIActivity.this, FatActivity.class);
                    startActivity(fatIntent);
                }
                else if(BIMNumber >= 30){
                    Intent fat1Intent = new Intent(BMIActivity.this, FatActivity.class);
                    startActivity(fat1Intent);
                }

            }
        });

    }
}
