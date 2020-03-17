package com.instanect.uicrudastable;

import android.os.Bundle;
import android.view.View;
import android.widget.TableRow;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.instanect.uicrudastableformmodule.fragment.UITableLayoutFormFragment;
import com.instanect.uicrudastableformmodule.fragment.interfaces.UITableLayoutFormFragmentAddNewRowCallback;
import com.instanect.uicrudastableformmodule.fragment.interfaces.UITableLayoutFormFragmentDeleteRowCallback;
import com.instanect.uicrudastableformmodule.fragment.interfaces.UITableLayoutFormFragmentOnViewInsideRowClicked;
import com.instanect.uicrudastableformmodule.formObject.UiFormUnitObject;

public class MainActivity extends AppCompatActivity
        implements UITableLayoutFormFragmentAddNewRowCallback,
        UITableLayoutFormFragmentDeleteRowCallback, UITableLayoutFormFragmentOnViewInsideRowClicked {

    private static final String FRAG_TAG = "Form Fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UiFormUnitObject uiFormUnitObject = new UiFormUnitObject();
        uiFormUnitObject.setAddNewRowCallback(this);
        uiFormUnitObject.setDeleteRowCallback(this);
        uiFormUnitObject.setOnViewInsideRowClickedCallback(this);
        uiFormUnitObject.setIdResRowLayout(R.layout.example_row);
        uiFormUnitObject.setButtonDeleteResId(R.id.buttonDelete);

        UITableLayoutFormFragment fragment =
                UITableLayoutFormFragment.newInstance();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout, fragment, FRAG_TAG)
                .commit();
    }

    @Override
    public void onUITableLayoutFormFragmentAddNewButtonAddClicked( View view) {

        UITableLayoutFormFragment fragment
                = (UITableLayoutFormFragment) getSupportFragmentManager().findFragmentByTag(FRAG_TAG);
        assert fragment != null;
        fragment.onAddNewRequestSuccessful(view);

    }

    @Override
    public void onUITableLayoutFormFragmentRowDeleteButtonClicked( TableRow rowOnWhichDeleteWasClicked) {
        UITableLayoutFormFragment fragment
                = (UITableLayoutFormFragment) getSupportFragmentManager().findFragmentByTag(FRAG_TAG);
        assert fragment != null;
        fragment.deleteRow(rowOnWhichDeleteWasClicked);

    }

    @Override
    public void onUITableLayoutFormFragmentViewInsideRowClicked( View view) {
        Toast.makeText(this, "View Clicked", Toast.LENGTH_SHORT).show();
    }
}
