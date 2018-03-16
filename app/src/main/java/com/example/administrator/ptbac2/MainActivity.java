package com.example.administrator.ptbac2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtSoA;
    EditText edtSoB;
    Button btnTong;
    public static final String MyPREFERENCES = "MyPrefs";
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtSoA = findViewById(R.id.edtSoA);
        edtSoB = findViewById(R.id.edtSoB);
        btnTong = findViewById(R.id.btnTong);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        edtSoA.setText("");
        edtSoB.setText("");
        Boolean isFirst = sharedpreferences.getBoolean("isFirst", false);
        if (isFirst) {
            int a_old = sharedpreferences.getInt("SoA", 0);
            int b_old = sharedpreferences.getInt("SoB", 0);
            Toast.makeText(MainActivity.this, "Wellcome back to MainActivity ! Your last edit text : a= " + a_old + " ,b= " + b_old, Toast.LENGTH_SHORT).show();
        }

        btnTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int a = Integer.parseInt(edtSoA.getText().toString());
                    int b = Integer.parseInt(edtSoB.getText().toString());

                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putBoolean("isFirst", true);
                    editor.putInt("SoA", a);
                    editor.putInt("SoB", b);
                    editor.commit();

                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("SoA", a);
                    intent.putExtra("SoB", b);

                    startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "xin nhập số!" + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
