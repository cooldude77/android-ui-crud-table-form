package com.instanect.uicrudastable.activity.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.instanect.uicrudastable.R;
import com.instanect.uicrudastableformmodule.common.view.ChildIdList;
import com.instanect.uicrudastableformmodule.common.view.IdFieldValueForARowMap;
import com.instanect.uicrudastableformmodule.createOrEdit.fragment.UIEditOrCreateTableFormFragment;
import com.instanect.uicrudastableformmodule.createOrEdit.ui.structure.UIEditOrCreateFragmentProperties;

public class TestEditCreateFragment extends UIEditOrCreateTableFormFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // initializing properties
        UIEditOrCreateFragmentProperties uiEditOrCreateFragmentProperties = new UIEditOrCreateFragmentProperties();

        uiEditOrCreateFragmentProperties.setIdResRowLayout(R.layout.example_row_create_edit);
        uiEditOrCreateFragmentProperties.setButtonDeleteResId(R.id.buttonDelete);

        setUIFragmentProperties(uiEditOrCreateFragmentProperties);

        ChildIdList mapList = new ChildIdList();

        mapList.add(R.id.editText);

        setChildIdList(mapList);


        IdFieldValueForARowMap map1 = new IdFieldValueForARowMap();
        map1.put(R.id.editText, String.valueOf(100));
        map1.put(R.id.checkBox, String.valueOf(true));

        IdFieldValueForARowMap map2 = new IdFieldValueForARowMap();
        map2.put(R.id.editText, String.valueOf(200));
        map2.put(R.id.checkBox, String.valueOf(false));

        getValueList().add(map1);
        getValueList().add(map2);


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
