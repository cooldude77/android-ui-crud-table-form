package com.instanect.uicrudastableformmodule.createOrEdit.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.instanect.uicrudastableformmodule.R;
import com.instanect.uicrudastableformmodule.R2;
import com.instanect.uicrudastableformmodule.common.base.UIFormBaseFragment;
import com.instanect.uicrudastableformmodule.common.view.IdFieldValueForARowMap;
import com.instanect.uicrudastableformmodule.createOrEdit.fragment.interfaces.UITableLayoutFormFragmentAddNewRowCallback;
import com.instanect.uicrudastableformmodule.createOrEdit.fragment.interfaces.UITableLayoutFormFragmentDeleteRowCallback;
import com.instanect.uicrudastableformmodule.createOrEdit.ui.structure.UIEditOrCreateFragmentProperties;

import java.util.ArrayList;

import butterknife.OnClick;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class UIEditOrCreateTableFormFragment extends UIFormBaseFragment
        implements UITableLayoutFormFragmentDeleteRowCallback,
        UITableLayoutFormFragmentAddNewRowCallback {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setContentViewResId(R.layout.base_layout_create);

        getUiFragmentProperties().setAddNewRowCallback(this);
        getUiFragmentProperties().setDeleteRowCallback(this);


        View view = super.onCreateView(inflater, container, savedInstanceState);

        fillData();

        return view;
    }

    @OnClick(R2.id.imageButtonAdd)
    void onImageButtonAddClicked() {
        assertNotEquals(
                getUiFragmentProperties()
                        .getIdResRowLayout(), -1);
        View view = getLayoutInflater().inflate(
                getUiFragmentProperties().getIdResRowLayout(), null);

        assertNotNull(getUiFragmentProperties().getAddNewRowCallback());

        getUiFragmentProperties()
                .getAddNewRowCallback()
                .onUITableLayoutFormFragmentAddNewButtonAddClicked(view);
    }


    public ArrayList<IdFieldValueForARowMap> getData() {
        ArrayList<IdFieldValueForARowMap> idFieldValueForARowMaps = new ArrayList<>();
        for (int i = 0; i < getRowViewAndItsTagRelationObjects().size(); i++) {
            View parent = getRowViewAndItsTagRelationObjects().get(i).getView();
            idFieldValueForARowMaps.add(getIdValueMap(parent));

        }
        return idFieldValueForARowMaps;
    }


    private IdFieldValueForARowMap getIdValueMap(View parent) {
        IdFieldValueForARowMap idValueMap = new IdFieldValueForARowMap();

        for (Integer integer : getChildIdList()) {
            assert parent != null;
            View view = parent.findViewById(integer);
            if (view != null) {
                String value = null;
                if (view instanceof TextView) {
                    value = ((TextView) view).getText().toString();
                    idValueMap.put(integer, value);
                }

            }

        }
        return idValueMap;

    }


    public void addNewRow(View rowChildView) {

        addTag(rowChildView);
        setOnClickViewListener(rowChildView);
        setDeleteListener(rowChildView);
        addRow(rowChildView);

    }


    private void setOnClickViewListener(View rowChildView) {
        if (getUiFragmentProperties().getOnViewInsideRowClickedListener() != null)
            for (int i = 0; i < ((ViewGroup) rowChildView).getChildCount(); i++) {
                View v = ((ViewGroup) rowChildView).getChildAt(i);
                if (v.getId() != getUiFragmentProperties().getButtonDeleteResId())
                    addOnClickListenerToView(v);
            }

    }

    private void setDeleteListener(View rowChildView) {
        ImageButton deleteButton = rowChildView.findViewById(getUiFragmentProperties()
                .getButtonDeleteResId());

        if (deleteButton != null)
            deleteButton.setOnClickListener(v -> {
                assertNotNull(getUiFragmentProperties().getDeleteRowCallback());
                getUiFragmentProperties().getDeleteRowCallback()
                        .onUITableLayoutFormFragmentRowDeleteButtonClicked(rowChildView);
            });

    }


    public void deleteRow(View rowOnWhichDeleteWasClicked) {
        getLinearLayout().removeView(rowOnWhichDeleteWasClicked);
    }

    @Override
    public UIEditOrCreateFragmentProperties getUiFragmentProperties() {
        return (UIEditOrCreateFragmentProperties) super.getUiFragmentProperties();
    }

    @Override
    public void onUITableLayoutFormFragmentAddNewButtonAddClicked(View view) {

        // override these
    }

    @Override
    public void onUITableLayoutFormFragmentRowDeleteButtonClicked(View rowOnWhichDeleteWasClicked) {
        // override these
    }
}
