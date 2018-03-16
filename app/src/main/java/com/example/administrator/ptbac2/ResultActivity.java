package com.example.administrator.ptbac2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {
    Button btnBack;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tvResult = findViewById(R.id.tvResult);
        btnBack = findViewById(R.id.btnBack);
        Intent callerIntent = getIntent();

        int a = callerIntent.getIntExtra("SoA",0);
        int b = callerIntent.getIntExtra("SoB",0);
        giaiPTBac2(a, b);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ResultActivity.this, MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                finish();
            }
        });
    }

    public void giaiPTBac2(int a, int b) {
        if (a == 0) {
            if (b == 0) {
                tvResult.setText("Phương trình vô số nghiệm");
            } else {
                tvResult.setText("Phương trình vô nghiệm");
            }
        } else {
            tvResult.setText("Phương trình có nghiệm" + (float) -b / a);
        }
    }
}
