package com.instanect.uicrudastableformmodule.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.instanect.uicrudastableformmodule.R;
import com.instanect.uicrudastableformmodule.common.base.UIFormBaseFragment;

public class UIViewTableFormFragment extends UIFormBaseFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        setContentViewResId(R.layout.base_layout_display);

        View view = super.onCreateView(inflater, container, savedInstanceState);

        fillData();

        return view;
    }

}
