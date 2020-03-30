package com.instanect.uicrudastable.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.instanect.uicrudastable.R;
import com.instanect.uicrudastable.activity.fragments.TestDisplayFragment;

public class DisplayActivity extends AppCompatActivity {
    private static final String FRAG_TAG = "Form Fragment";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);


        TestDisplayFragment fragment = new
                TestDisplayFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout, fragment, FRAG_TAG)
                .commit();

    }
}