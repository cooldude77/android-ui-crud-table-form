package com.instanect.uicrudastable.activity.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.instanect.uicrudastable.R;
import com.instanect.uicrudastableformmodule.common.view.ChildIdList;
import com.instanect.uicrudastableformmodule.common.view.IdFieldValueForARowMap;
import com.instanect.uicrudastableformmodule.view.UIViewTableFormFragment;
import com.instanect.uicrudastableformmodule.view.structure.UIViewFragmentProperties;

public class TestDisplayFragment extends UIViewTableFormFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // initializing properties
        UIViewFragmentProperties viewFragmentProperties = new UIViewFragmentProperties();

        viewFragmentProperties.setIdResRowLayout(R.layout.example_row_display);

        setUIFragmentProperties(viewFragmentProperties);

        ChildIdList mapList = new ChildIdList();
        mapList.add(R.id.editText);
        setChildIdList(mapList);

        IdFieldValueForARowMap map1 = new IdFieldValueForARowMap();
        map1.put(R.id.tv1, String.valueOf(100));
        map1.put(R.id.tv2, String.valueOf(100));

        IdFieldValueForARowMap map2 = new IdFieldValueForARowMap();
        map2.put(R.id.tv1, String.valueOf(200));
        map2.put(R.id.tv2, String.valueOf(200));

        getValueList().add(map1);
        getValueList().add(map2);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

}
