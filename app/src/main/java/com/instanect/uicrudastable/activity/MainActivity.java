package com.instanect.uicrudastable.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.instanect.uicrudastable.R;
import com.instanect.uicrudastable.activity.fragments.TestFragment;

public class MainActivity extends AppCompatActivity {

    private static final String FRAG_TAG = "Form Fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TestFragment fragment = new
                 TestFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout, fragment, FRAG_TAG)
                .commit();
    }

}
