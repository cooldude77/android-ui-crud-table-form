package com.instanect.uicrudastable.activity.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableRow;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.instanect.uicrudastable.R;
import com.instanect.uicrudastableformmodule.fragment.UITableLayoutFormFragment;
import com.instanect.uicrudastableformmodule.fragment.interfaces.UITableLayoutFormFragmentAddNewRowCallback;
import com.instanect.uicrudastableformmodule.fragment.interfaces.UITableLayoutFormFragmentDeleteRowCallback;
import com.instanect.uicrudastableformmodule.fragment.interfaces.UITableLayoutFormFragmentOnViewInsideRowClicked;

public class TestFragment extends UITableLayoutFormFragment implements UITableLayoutFormFragmentAddNewRowCallback, UITableLayoutFormFragmentDeleteRowCallback, UITableLayoutFormFragmentOnViewInsideRowClicked {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        setAddNewRowCallback(this);
        setDeleteRowCallback(this);
        setOnViewInsideRowClickedCallback(this);
        setIdResRowLayout(R.layout.example_row);
        setButtonDeleteResId(R.id.buttonDelete);
        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    public void onUITableLayoutFormFragmentAddNewButtonAddClicked(View view) {
        onAddNewRequestSuccessful(view);
    }

    @Override
    public void onUITableLayoutFormFragmentRowDeleteButtonClicked(TableRow rowOnWhichDeleteWasClicked) {
        deleteRow(rowOnWhichDeleteWasClicked);
    }

    @Override
    public void onUITableLayoutFormFragmentViewInsideRowClicked(View view) {
        Toast.makeText(getContext(), "View Clicked", Toast.LENGTH_SHORT).show();
    }
}
