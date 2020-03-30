package com.instanect.uicrudastable.activity.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.instanect.uicrudastable.R;
import com.instanect.uicrudastableformmodule.createOrEdit.fragment.UIEditOrCreateTableFormFragment;
import com.instanect.uicrudastableformmodule.createOrEdit.fragment.interfaces.UITableLayoutFormFragmentAddNewRowCallback;
import com.instanect.uicrudastableformmodule.createOrEdit.fragment.interfaces.UITableLayoutFormFragmentDeleteRowCallback;
import com.instanect.uicrudastableformmodule.createOrEdit.fragment.interfaces.UITableLayoutFormFragmentOnViewInsideRowClicked;

import com.instanect.uicrudastableformmodule.common.view.ChildIdList;
import com.instanect.uicrudastableformmodule.createOrEdit.ui.structure.UIEditOrCreateFragmentProperties;

public class TestEditCreateFragment extends UIEditOrCreateTableFormFragment implements UITableLayoutFormFragmentAddNewRowCallback, UITableLayoutFormFragmentDeleteRowCallback, UITableLayoutFormFragmentOnViewInsideRowClicked {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // initializing properties
        UIEditOrCreateFragmentProperties uiEditOrCreateFragmentProperties =  new UIEditOrCreateFragmentProperties();

        uiEditOrCreateFragmentProperties.setIdResRowLayout(R.layout.example_row_create_edit);

        uiEditOrCreateFragmentProperties.setAddNewRowCallback(this);
        uiEditOrCreateFragmentProperties.setDeleteRowCallback(this);
        uiEditOrCreateFragmentProperties.setOnViewInsideRowClickedCallback(this);
        uiEditOrCreateFragmentProperties.setButtonDeleteResId(R.id.buttonDelete);

        setUIFragmentProperties(uiEditOrCreateFragmentProperties);

        ChildIdList mapList = new ChildIdList();

        mapList.add(R.id.editText);

        setChildIdList(mapList);


        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    public void onUITableLayoutFormFragmentAddNewButtonAddClicked(View view) {
        addNewRow(view);
    }

    @Override
    public void onUITableLayoutFormFragmentRowDeleteButtonClicked(View rowOnWhichDeleteWasClicked) {
        deleteRow(rowOnWhichDeleteWasClicked);
    }

    @Override
    public void onUITableLayoutFormFragmentViewInsideRowClicked(View view) {
        Toast.makeText(getContext(), "View Clicked", Toast.LENGTH_SHORT).show();
    }
}
