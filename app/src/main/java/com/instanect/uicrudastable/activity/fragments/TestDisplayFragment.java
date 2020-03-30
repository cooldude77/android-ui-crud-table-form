package com.instanect.uicrudastable.activity.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.instanect.uicrudastable.R;
import com.instanect.uicrudastableformmodule.common.view.ChildIdList;
import com.instanect.uicrudastableformmodule.view.UIViewTableFormFragment;
import com.instanect.uicrudastableformmodule.view.structure.UIViewFragmentProperties;

public class TestDisplayFragment extends UIViewTableFormFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // initializing properties
        UIViewFragmentProperties viewFragmentProperties = new UIViewFragmentProperties();

        viewFragmentProperties.setIdResRowLayout(R.layout.example_row);

        setUIFragmentProperties(viewFragmentProperties);

        ChildIdList mapList = new ChildIdList();
        mapList.add(R.id.editText);
        setChildIdList(mapList);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

}
