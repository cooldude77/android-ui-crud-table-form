package com.instanect.uicrudastableformmodule.common.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.instanect.uicrudastableformmodule.R;
import com.instanect.uicrudastableformmodule.R2;
import com.instanect.uicrudastableformmodule.common.view.ChildIdList;
import com.instanect.uicrudastableformmodule.common.view.IdFieldValueForARowMap;
import com.instanect.uicrudastableformmodule.common.view.RowViewAndItsTagRelationObject;

import java.util.ArrayList;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

abstract public class UIFormBaseFragment extends Fragment {
    private Context context;
    private ArrayList<RowViewAndItsTagRelationObject> rowViewAndItsTagRelationObjects = new ArrayList<>();
    private ChildIdList childIdList = new ChildIdList();
    private ArrayList<IdFieldValueForARowMap> valueList = new ArrayList<>();
    private View view;

    private int contentViewResId = -1;

    public void setContentViewResId(int contentViewResId) {
        this.contentViewResId = contentViewResId;
    }

    protected View getBaseFragmentView() {
        return view;
    }
    // Override this and initialize in derived fragments

    protected UIFragmentBaseProperties uiFragmentProperties;


    public void setUIFragmentProperties(UIFragmentBaseProperties uiFragmentBaseProperties) {
        this.uiFragmentProperties = uiFragmentBaseProperties;
    }

    public UIFragmentBaseProperties getUiFragmentProperties() {
        return uiFragmentProperties;
    }

    protected void setChildIdList(ChildIdList childIdList) {
        this.childIdList = childIdList;
    }

    protected ArrayList<RowViewAndItsTagRelationObject> getRowViewAndItsTagRelationObjects() {
        return rowViewAndItsTagRelationObjects;
    }

    public void setRowViewAndItsTagRelationObjects(
            ArrayList<RowViewAndItsTagRelationObject> rowViewAndItsTagRelationObjects) {
        this.rowViewAndItsTagRelationObjects = rowViewAndItsTagRelationObjects;
    }

    protected ChildIdList getChildIdList() {
        return childIdList;
    }

    public ArrayList<IdFieldValueForARowMap> getValueList() {
        return valueList;
    }

    public void setValueList(ArrayList<IdFieldValueForARowMap> valueList) {
        this.valueList = valueList;
    }

    @BindView(R2.id.layout_table_entries)
    LinearLayout linearLayout;

    @BindView(R2.id.textViewFormTitle)
    TextView textViewFormTitle;

    @SuppressLint("InflateParams")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(
                contentViewResId != -1 ? contentViewResId : R.layout.base_layout_display,
                null);
        ButterKnife.bind(this, view);

        textViewFormTitle.setText(uiFragmentProperties.getTitleOfForm());

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        this.context = context;
        super.onAttach(context);
    }


    @Nullable
    @Override
    public Context getContext() {
        return context;
    }

    protected LinearLayout getLinearLayout() {
        return linearLayout;
    }

    protected void fillData() {
        // iterate through value row
        for (IdFieldValueForARowMap map : valueList) {
            View row = getLayoutInflater().inflate(uiFragmentProperties.getIdResRowLayout(), null);

            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                View field = row.findViewById(entry.getKey());

                if (field instanceof CheckBox) {
                    ((CheckBox) field).setChecked(Boolean.parseBoolean(entry.getValue()));
                } else if (field instanceof TextView)
                    ((TextView) field).setText(entry.getValue());

            }

            linearLayout.addView(row);
        }
    }
}