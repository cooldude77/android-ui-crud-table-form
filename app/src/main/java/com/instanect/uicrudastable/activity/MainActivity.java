package com.instanect.uicrudastable.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.instanect.uicrudastable.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        findViewById(R.id.button_create_edit).setOnClickListener(
                v -> startActivity(new Intent(MainActivity.this,
                        CreateOrEditActivity.class))
        );
        findViewById(R.id.button_display).setOnClickListener(
                v -> startActivity(new Intent(MainActivity.this,
                        DisplayActivity.class))
        );
    }
}
