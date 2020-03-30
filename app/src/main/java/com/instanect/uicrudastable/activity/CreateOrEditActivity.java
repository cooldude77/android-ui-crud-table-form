package com.instanect.uicrudastable.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.instanect.uicrudastable.R;
import com.instanect.uicrudastable.activity.fragments.TestEditCreateFragment;
import com.instanect.uicrudastableformmodule.common.view.IdFieldValueForARowMap;

import java.util.ArrayList;

public class CreateOrEditActivity extends AppCompatActivity {
    private static final String FRAG_TAG = "Form Fragment";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);
        TestEditCreateFragment fragment = new
                TestEditCreateFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout, fragment, FRAG_TAG)
                .commit();




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.test, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.get) {
            ArrayList<IdFieldValueForARowMap> data
                    = ((TestEditCreateFragment) getSupportFragmentManager()
                    .findFragmentByTag(FRAG_TAG))
                    .getData();
            int i = 0;
            i++;
        }
        return super.onOptionsItemSelected(item);
    }


}
